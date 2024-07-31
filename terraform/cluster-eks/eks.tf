module "eks" {
  source          = "terraform-aws-modules/eks/aws"
  cluster_name    = "tech-challenge"
  cluster_version = "1.30"          
  cluster_endpoint_public_access  = true
  enable_cluster_creator_admin_permissions = true

  
  cluster_addons = {
    coredns                = {}
    kube-proxy             = {}
    vpc-cni                = {}
  }

  # vpc_id          = "vpc-0c759cb94ff0e2a85"      
  # subnet_ids         = ["subnet-07efb7a15c29f9257", "subnet-00b7572ad3068c914"]
   
  vpc_id          = "vpc-08387cb9ae462ef6e"      
  subnet_ids         = ["subnet-0af4713a95ea8bebf", "subnet-0e80c63392abe4ee8"]
  
  eks_managed_node_groups = {
    eks_nodes = {
      desired_size =     2
      max_capacity     = 5
      min_capacity     = 2

      instance_type    = ["t3.medium"]
    }
  }
  

  tags = {
    name      = "tech-challenge"
    Terraform = "true"
  }

}
