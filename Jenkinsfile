pipeline {
    agent any
    tools {
    maven 'Maven 3.8.6'
    }
    stages {
        stage('build') {
            steps {
            echo 'building application'
            bat "mvn install -f jenkinsFilePipelinee "
           
            }
        }
        stage('test') {
            steps {
               
                           bat "mvn test -f jenkinsFilePipelinee"
               

            }
        }
        stage('package') {
            steps {
                              
                                                          bat "mvn package -f jenkinsFilePipelinee"
                               

            }
        }
    
    }
}