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
