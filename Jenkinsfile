pipeline {
  agent {
    node {
        label 'maven'
    }
  }

  stages {
    stage ('preamble'){
      steps {
        script {
          openshift.withCluster() {
            openshift.withProject() {
              echo "Project: ${openshift.project()}"
              sh "oc get project"
            }
          }
        }
      }
    }

    stage ('build') {
      steps {
        script {
          sh "mvn clean compile"
        }
      }
    }
  }
}