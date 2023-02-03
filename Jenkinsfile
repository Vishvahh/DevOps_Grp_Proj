pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
                bat "mvn clean -f jenkinsFilePipelinee"
            }
        }
        stage('install') {
            steps {
                bat "mvn install -f jenkinsFilePipelinee"
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