pipeline {

    agent any

    tools {
             maven 'Maven'
        }

    environment {

        GITHUB_REPO_URL = 'https://github.com/JoshiRiya0110/SPE_Major_Project.git/'
        BACKEND_REPO_NAME = "joshiriya/gratefulplate-backend"
        FRONTEND_REPO_NAME = "joshiriya/gratefulplate-frontend"
        TAG = "latest"
        backendImage = ""
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

        stage('Create backend Docker image') {
            steps {
                script {
                    docker.build("${BACKEND_REPO_NAME}:${TAG}", "./demo")
                }
            }
        }

        stage('Push backend Docker image') {
            steps {
                script {
                    docker.withRegistry('','docker-hub-credential') {
                        sh 'docker push joshiriya/gratefulplate-backend:latest --debug'
                    }
                }
            }

         }
    }
}

