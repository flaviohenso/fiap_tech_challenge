provider "helm" {
  kubernetes {
    host                   = module.eks.cluster_endpoint
    cluster_ca_certificate = base64decode(module.eks.cluster_certificate_authority_data)
    token                  = data.aws_eks_cluster_auth.cluster_auth.token
  }
}

provider "kubernetes" {
  host                   = module.eks.cluster_endpoint
  cluster_ca_certificate = base64decode(module.eks.cluster_certificate_authority_data)
  token                  = data.aws_eks_cluster_auth.cluster_auth.token
}

resource "kubernetes_namespace" "argocd" {
  metadata {
    name = "argocd"
  }
}


resource "helm_release" "argocd" {
  name       = "argocd"
  namespace  = "argocd" 
  repository = "https://argoproj.github.io/argo-helm"
  chart      = "argo-cd"
  version    = "4.5.1"

  set {
    name  = "server.service.type"
    value = "LoadBalancer"
  }
depends_on = [ kubernetes_namespace.argocd ]
}
