pipeline {
    agent any

    tools {
        // Install the Gradle version.
        gradle 'Gradle'
    }

    stages {
        stage('Test') {
            steps {
                sh './gradlew clean test --no-daemon' //run a gradle task
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/site/serenity/', reportFiles: 'index.html', reportName: 'Serenity Report', reportTitles: '', useWrapperFileDirectly: true])
                }
            }
        }
    }
}