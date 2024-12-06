pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/iamignat/rppzl.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'  // Сборка проекта
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'  // Запуск тестов
            }
        }
        stage('Run') {
            steps {
                sh 'java -jar target/rppzl.jar'  // Запуск приложения
            }
        }
    }
}
