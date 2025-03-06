provider "aws" { region = "us-east-1" }
resource "aws_sqs_queue"  "RamaQueue"{
  name= "Sri-queue"
}
