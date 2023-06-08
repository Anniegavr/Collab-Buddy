pipeline {
  agent any
  stages {
    stage('Build Backend') {
      steps {
        sh 'mvn clean install -U'
        echo 'Building finished'
      }
    }

    stage('Build Frontend') {
      steps {
        sh 'cd ./frontend/frontend_app'
        echo 'Continue with fronend'
        sh 'npm run build'
      }
    }

  }
}