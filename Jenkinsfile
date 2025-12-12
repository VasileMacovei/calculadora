pipeline {
    agent any
    tools {
        jdk 'JDK21'
        maven 'Maven 3.9.11'
    }

    stages {

        stage('Test') {
            steps {
                sh 'mvn test -Djava.awt.headless=true'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('Docker Build') {
            steps {
                sh 'docker build -t miapp:latest .'
            }
        }

        stage('Docker Deploy') {
            steps {
                sh '''
                    docker stop miapp || true
                    docker rm miapp || true
                    docker run -d --name miapp -p 8081:8080 miapp:latest
                '''
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        failure {
            echo 'El build ha fallado.'
        }
    }
}
