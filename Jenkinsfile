pipeline {
    agent any

    environment {
        IMAGE_NAME     = 'springbootcrudops'
        CONTAINER_NAME = 'springboot-app'
        APP_PORT       = '8082'
    }

    stages {

        stage('Checkout') {
            steps {
                echo '📥 Cloning repository...'
                git branch: 'main',
                    url: 'https://github.com/Yellareddy07/SpringBootCrudOps.git'
            }
        }

        stage('Maven Build') {
            steps {
                echo '🔨 Building JAR...'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                echo '🐳 Building Docker image...'
                sh 'docker build -t springbootcrudops .'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Deploying container...'
                sh '''
                    

                    docker stop springboot-app 2>/dev/null || true
                    docker rm   springboot-app 2>/dev/null || true

                    docker run -d \
                        --name springboot-app\
                        -p 8082:8080\
                        -e SPRING_DATASOURCE_URL="jdbc:mysql://host.docker.internal:3306/SpringDocker?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true" \
                        -e SPRING_DATASOURCE_USERNAME=root \
                        -e SPRING_DATASOURCE_PASSWORD=Suyochi@123 \
                        -e SPRING_JPA_HIBERNATE_DDL_AUTO=update \
                        springbootcrudops
                '''
            }
        }

        
    }

    post {
        success {
            echo '✅ Pipeline successful!'
        }
        failure {
            echo '❌ Pipeline failed!'
            sh 'docker logs ${CONTAINER_NAME} || true'
        }
    }
}
