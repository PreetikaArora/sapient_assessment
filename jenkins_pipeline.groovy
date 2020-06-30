pipeline {
    agent any

    tools {
        maven 'Maven 3.8.2'
        jdk 'Jdk 8'
    }


    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/PreetikaArora/sapient_assessment.git'


                // Run Maven on a Unix agent.
                sh "cd Assessment mvn clean install"
            }

            //post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            //  success {
            //     junit '**/target/surefire-reports/TEST-*.xml'
            //     archiveArtifacts 'target/*.jar'
            //  }
            //}
        }
    }
}
