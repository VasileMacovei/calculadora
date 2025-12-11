pipeline {
    agent any

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
