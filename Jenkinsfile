pipeline{
  agent any

  stages{
    stage("Checkout"){
      steps{
     git branch: 'main',  
    url: 'https://github.com/Yellareddy07/SpringBootCrudOps.git'    
      }
    }
       stage('Maven Build') {              // ✅ Step 1 - Build JAR first
            steps {
                echo '🔨 Building JAR...'
                sh 'mvn clean package -DskipTests'
            }
        }

    stage("build"){
      steps{
        sh 'docker build -t springbootcrud .'
        echo 'build successfully'
      }
    }

    stage("Deploy"){
      steps{
        sh 'docker run -d -p 8082:8080 springbootcrud'
      }
    }
  }}
    
