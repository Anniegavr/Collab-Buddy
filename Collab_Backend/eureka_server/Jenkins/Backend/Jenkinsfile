pipeline {
    agent any
    stages {
        stage('Build and Test Backend Spring Boot Application') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
    post {
        failure {
            mail to: 'agavrilita@inthergroup.com',
                 subject: "Build failed: ${currentBuild.fullDisplayName}",
                 body: "Something went wrong with ${env.BUILD_URL}"
        }
    }
}
