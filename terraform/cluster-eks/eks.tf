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

  vpc_id          = "vpc-0c759cb94ff0e2a85"      
  subnet_ids         = ["subnet-07efb7a15c29f9257", "subnet-00b7572ad3068c914"]
   
  
  eks_managed_node_groups = {
    eks_nodes = {
      desired_capacity = 2
      max_capacity     = 3
      min_capacity     = 1
      instance_type    = "t3.medium"
    }
  }
  

  tags = {
    name      = "fiap_tech_challenge"
    Terraform = "true"
  }

}
