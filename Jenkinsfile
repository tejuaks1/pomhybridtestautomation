pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/tejuaks1/pomhybridtestautomation.git'  // Fixed: one git step
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean compile'  // bat for Windows
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'  // bat for Windows
            }
        }
        stage('Report') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }
    post {
        always {
            publishHTML([
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'test-output',
                reportFiles: 'index.html',
                reportName: 'HTML Report'
            ])
        }
    }
}
