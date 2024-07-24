terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

# Configure the AWS Provider
provider "aws" {
  region = "us-east-1"
  profile = "pedrones"
  # access_key = "AKIAYLI2SW23SUYJBZNJ"
  # secret_key = "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"

}
