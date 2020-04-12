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

    stage ('package') {
      steps {
        script {
          sh "mvn package"
          sh "ls -lR . "
        }
      }
    }
    
    stage ('Build development image') {
      steps {
        script {
            openshift.withCluster() {
                openshift.withProject() {}
                    openshift.selector("bc", "cant-touch-this").startBuild("--from-file=./target/cant-touch-this-0.0.1-SNAPSHOT.jar", "--wait=true")
                }
            }
        }
      }
    }
}
