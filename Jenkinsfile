pipeline {
    agent any
    tools{
        maven 'mvn'
    }
    stages {
        stage('build') {
            steps {
                script {
                    echo "building the application..."
                    bat "mvn package"
                }
            }
        }
        stage('test') {
            steps {
                script {
                    echo "Testing the application..."
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                    bat 'java -jar target/student-0.0.1-SNAPSHOT.jar'

                }
            }
        }
    }
}