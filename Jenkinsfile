pipeline {
    agent any

    environment {
        IMAGE_NAME     = 'springboot-crudops'
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
                    HOST_IP=$(ip route show default | awk '/default/ {print $3}')
                    echo "Host IP: ${HOST_IP}"

                    docker stop ${CONTAINER_NAME} 2>/dev/null || true
                    docker rm   ${CONTAINER_NAME} 2>/dev/null || true

                    docker run -d \
                        --name springbootcrudops\
                        -p 8082:8080\
                        -e SPRING_DATASOURCE_URL="jdbc:mysql://host.docker.internal:3306/SpringDocker?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true" \
                        -e SPRING_DATASOURCE_USERNAME=root \
                        -e SPRING_DATASOURCE_PASSWORD=Suyochi@123 \
                        -e SPRING_JPA_HIBERNATE_DDL_AUTO=update \
                        springbootcrudops
                '''
            }
        }

        stage('Health Check') {
            steps {
                echo '❤️ Health checking...'
                sh '''
                    sleep 20
                    curl --fail http://localhost:8082/Department/fetch
                    echo "✅ App is running!"
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
