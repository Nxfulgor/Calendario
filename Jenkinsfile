pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/Nxfulgor/Calendario.git'
        BRANCH = 'main'
    }

    stages {

        stage('Clonar repo') {
            steps {
                git branch: "${BRANCH}", url: "${REPO_URL}"
            }
        }

        stage('Build Spring Boot') {
            steps {
                dir('festivos-api') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build y Deploy Docker') {
            steps {
                sh 'docker compose down'
                sh 'docker compose up -d --build'
            }
        }
    }

    post {
        success {
            echo 'Deploy exitoso 🚀'
        }
        failure {
            echo 'Deploy fallido ❌'
        }
    }
}