pipeline {

    agent any

    tools {
        // Install the Gradle version.
        gradle 'Gradle-8'
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git url: 'https://github.com/josersophos/ironmate_servicios.gitt', branch: 'main'

                // Run gradle.
                bat "gradle clean test -Denvironment=stg aggregate"
            }
			post {
				always {
					publishHTML(
						target: [
							reportName : 'Serenity',
							reportDir:   'target/site/serenity',
							reportFiles: 'index.html',
							keepAll:     true,
							alwaysLinkToLastBuild: true,
							allowMissing: false
						]
					)
				}
			}
        }
    }
}