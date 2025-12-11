pipeline {
    agent any

    tools {
        jdk 'JDK22'
        maven 'Maven 3.9.11'
    }

    stages {
        stage('Check Java') {
            steps {
                sh 'echo $JAVA_HOME'
                sh 'java -version'
            }
        }

        stage('Build') {
            steps {
                withEnv(["JAVA_HOME=${tool 'JDK22'}", "PATH=${tool 'JDK22'}/bin:${env.PATH}"]) {
                    sh 'java -version'
                    sh 'mvn -B clean package'
                }
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

