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
                sh 'mvn test'
            }
        }
        // stage('Create backend Docker image') {
        //     steps {
        //         script {
        //             backendImage = docker.build(backendRepositoryName + ":" + tag, "./demo")
        //         }
        //     }
        // }
        // stage('Push backend image to Docker Hub') {
        //     steps {
        //         script {
        //             docker.withRegistry('', 'DockerHubCred') {
        //                 backendImage.push()
        //             }
        //         }
        //     }
        // }
        // stage('Create frontend Docker image') {
        //     steps {
        //         script {
        //             frontendImage = docker.build(frontendRepositoryName + ":" + tag, "./frontendUpdated")
        //         }
        //     }
        // }
        // stage('Push frontend image to Docker Hub') {
        //     steps {
        //         script {
        //             docker.withRegistry('', 'DockerHubCred') {
        //                 frontendImage.push()
        //             }
        //         }
        //     }
        // }

        // stage ("Run Ansible Playbook") {
        //            steps {
        //                 script {

        //                  sh '/Users/samayochita/.local/bin/ansible-playbook -i inventory playbook.yml'

        //                  }
        //            }
        // }
    }
}

