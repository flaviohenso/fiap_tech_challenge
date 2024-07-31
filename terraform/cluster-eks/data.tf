data "aws_eks_cluster" "cluster" {
  depends_on = [ module.eks]
  name = "tech-challenge"
}


data "aws_eks_cluster_auth" "cluster_auth" {
  name = "tech-challenge"
}

