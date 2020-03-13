pipeline {
  agent {
    node {
        label 'master'
    }
  }

  stages {
    stage('preamble') {
       stage('preamble') {
        steps {
            script {
                openshift.withCluster() {
                    openshift.withProject() {
                        echo "using project ${openshift.project()}"
                    }
                }
            }
         }
       }
    }

    stage('build') {
        steps {
            sh "mvn clean compile"
        }
    }
  }