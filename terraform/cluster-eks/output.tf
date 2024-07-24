output "cluster_id" {
  value = data.aws_eks_cluster.cluster.cluster_id
}

output "cluster_endpoint" {
  value = data.aws_eks_cluster.cluster.endpoint
}

