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

# resource "kubernetes_namespace" "argocd" {
#   metadata {
#     name = "argocd"
#   }
# }

# resource "kubernetes_namespace" "metrics" {
#   metadata {
#     name = "metrics"
#   }
# }

resource "helm_release" "metrics_server" {
  name       = "metrics-server"
  repository = "https://kubernetes-sigs.github.io/metrics-server/"
  chart      = "metrics-server"
  namespace =  "metrics"
  create_namespace = true
  version    = "3.8.3"  # Substitua pela versão desejada

  set {
    name  = "args[0]"
    value = "--kubelet-insecure-tls"
  }

  set {
    name  = "resources.limits.cpu"
    value = "200m"
  }

  set {
    name  = "resources.limits.memory"
    value = "200Mi"
  }

  set {
    name  = "resources.requests.cpu"
    value = "100m"
  }

  set {
    name  = "resources.requests.memory"
    value = "100Mi"
  }

}

resource "helm_release" "argocd" {
  name       = "argocd"
  namespace  = "argocd" 
  create_namespace = true 
  repository = "https://argoproj.github.io/argo-helm"
  chart      = "argo-cd"
  version    = "7.3.11"

  set {
    name  = "server.service.type"
    value = "LoadBalancer"
  }

   
  values = [file("${path.module}/values-argocd.yaml")]


}

resource "null_resource" "apply_argocd_applications" {
  provisioner "local-exec" {
    command = "kubectl apply -f ${path.module}/values-argocd.yaml"
  }

  depends_on = [
    helm_release.argocd
  ]
}
