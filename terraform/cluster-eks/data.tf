data "aws_eks_cluster" "cluster" {
  depends_on = [ module.eks]
  name = "fiap_tech_challenge"
}


data "aws_eks_cluster_auth" "cluster_auth" {
  name = "fiap_tech_challenge"
}