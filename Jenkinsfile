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
    
//     stage ('Build development image') {
//       steps {
//         script {
//             openshift.withCluster() {
//                 openshift.withProject() {
//                     openshift.selector("bc", "cant-touch-this").startBuild("--from-file=./target/cant-touch-this.jar", "--wait=true")
//                 }
//                 }
//             }
//         }
//       }
    stage ('Build quay.io image') {
      steps {
        script {
          openshift.withCluster() {
              openshift.withProject() {
                  def commit_abbrev = sh(returnStdout: true, script: "echo ${env.GIT_COMMIT} | cut -c -12").trim()
                  echo "commit abbreviated: ${commit_abbrev}"
                  imgbc = openshift.selector("bc", "cant-touch-this-quayio").object()
                  imgbc.spec.output.to.name = "quay.io/sholly/cant-touch-this:${commit_abbrev}"
                  openshift.apply(imgbc)
                  openshift.selector("bc", "cant-touch-this-quayio").startBuild("--from-file=./target/cant-touch-this.jar", "--wait=true")
              }
           }
        }
      }
    }
  }
}
