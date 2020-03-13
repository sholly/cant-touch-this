pipeline {
  agent {
    node {
        label 'master'
    }
  }

  withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'ci-cd-sholly-github', passwordVariable: 'TOKEN']]) {
  stages {
    stage('preamble') {
        steps {
            script {
                openshift.withCluster() {
                    openshift.withProject() {
                        echo "project: ${openshift.project}"
                        echo "token: $TOKEN"
                    }
                }
            }
        }
    }
    stage('build') {
        steps {
            script {
                sh "mvn clean package"
            }
        }
    }
  }
  }