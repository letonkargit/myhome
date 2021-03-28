pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        git(url: 'https://github.com/letonkargit/myhome.git', branch: 'initialcode')
      }
    }

    stage('build') {
      agent any
      steps {
        sh 'mvn clean compile package'
      }
    }

  }
}