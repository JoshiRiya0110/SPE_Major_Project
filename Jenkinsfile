pipeline {
    agent any
    tools {
             maven 'Maven'

        }

    environment {

        GITHUB_REPO_URL = 'https://github.com/JoshiRiya0110/SPE_Major_Project.git/'
        
    }
    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main',
                url: "${GITHUB_REPO_URL}"
            }
        }
        stage('Build backend code using Maven') {
            steps {
                script {
                    sh 'mvn -f demo/pom.xml clean install'
                }
            }
        }
        stage('Unit Testing') {
            steps {
                sh 'mvn -f demo/pom.xml test'
            }
        }
    }
}

