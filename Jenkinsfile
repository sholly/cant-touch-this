pipeline {
  agent {
    node {
        label 'master'
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