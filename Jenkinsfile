pipeline {
  agent {
    node {
        label 'master'
    }
  }

  stages {
    stage ('preamble'){
      steps {
        script {
          openshift.withCluster() {
            openshift.withProject() {
              echo "Project: ${openshift.project()}"
            }
          }
        }
      }
    }
  }
}