pipeline {
    agent any
    tools { maven 'Maven3' }  // Uses configured Maven
    stages {
        // Checkout unchanged
        stage('Build') { steps { bat 'mvn clean compile' } }
        stage('Test') { steps { bat 'mvn test' } }
        stage('Report') { steps { junit 'target/surefire-reports/*.xml' } }
    }
    post {
        always {
          junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
            publishHTML([allowMissing: true,  // Allow missing dir
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'test-output',
                reportFiles: 'index.html',
                reportName: 'HTML Report'
            ])
        }
    }
}
