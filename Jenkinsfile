pipeline{
  agent any

  stages{
    stage("Checkout"){
      steps{
        git 'https://github.com/Yellareddy07/SpringBootCrudOps.git'
      }
    }

    stage("build"){
      steps{
        sh 'docker build -t SpringBootCrud .'
        echo 'build successfully'
      }
    }

    stage("Deploy"){
      steps{
        sh 'docker run -d -p 8082:8080 SpringBootCrud'
      }
    }
  }}
    
