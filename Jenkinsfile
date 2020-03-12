pipeline {
  agent {
    node {
        label 'maven'
    }
  }

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