pipeline {
    agent any
    stages {
        stage('Checkout') { steps { git url: 'https://github.com/tejuaks1/pomhybridtestautomation.git' } }
        stage('Build') { steps { sh 'mvn clean compile' } }
        stage('Test') { steps { sh 'mvn test' } }
        stage('Report') { steps { junit 'target/surefire-reports/*.xml' } }
    }
    post { always { publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'test-output', reportFiles: 'index.html', reportName: 'HTML Report']) } }
}