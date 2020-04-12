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

    stage ('package') {
      steps {
        script {
          sh "mvn package"
        }
      }
    }
    
    stage ('Build development image') {
      steps {
        script {
            openshift.withCluster() {
                openshift.withProject() {
                    openshift.selector("bc", "cant-touch-this").startBuild("--from-file=./cant-touch-this-0.0.1-SNAPSHOT.jar", "--wait=true")
                }
            }
        }
      }
    }

  }
}