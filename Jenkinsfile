pipeline {
    agent any
    tools {
    maven 'Maven 3.8.6'
    }
    stages {
        stage('build') {
            steps {
            echo 'building application'
            sh "mvn install"
           
            }
        }
        stage('test') {
            steps {
               echo 'testing application'

            }
        }
        stage('deploy') {
            steps {
                               echo 'deploying application'

            }
        }
    
    }
}