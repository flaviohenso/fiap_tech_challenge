module "eks" {
  source          = "terraform-aws-modules/eks/aws"
  cluster_name    = "fiap_tech_challenge"
  cluster_version = "1.30"          
  cluster_endpoint_public_access  = true
  enable_cluster_creator_admin_permissions = true

  
  cluster_addons = {
    coredns                = {}
    eks-pod-identity-agent = {}
    kube-proxy             = {}
    vpc-cni                = {}
  }

  # vpc_id          = "vpc-0c759cb94ff0e2a85"      
  # subnet_ids         = ["subnet-07efb7a15c29f9257", "subnet-00b7572ad3068c914"]
   
  vpc_id          = "vpc-0055ade1f9088e0fa"      
  subnet_ids         = ["subnet-065cb9924aa370d64", "subnet-0b892119d7930b3ee"]
  
  eks_managed_node_groups = {
    eks_nodes = {
      desired_capacity = 4
      max_capacity     = 7
      min_capacity     = 4
      instance_type    = "t3.medium"
      scaling_config = 2
    }
  }
  

  tags = {
    name      = "fiap_tech_challenge"
    Terraform = "true"
  }

}
