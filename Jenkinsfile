pipeline {
  agent {
    node {
        label 'master'
    }
  }

  withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'ci-cd-sholly-github']]) {
  stages {
    stage('preamble') {
        steps {
            script {
                openshift.withCluster() {
                    openshift.withProject() {
                        echo "project: ${openshift.project}"
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