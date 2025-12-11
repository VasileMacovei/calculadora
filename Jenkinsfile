pipeline {
    agent any
    tools {
        jdk 'JDK21'
        maven 'Maven 3.9.11'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B clean package'
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
