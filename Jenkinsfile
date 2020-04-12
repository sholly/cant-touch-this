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
    
    stage ('Build development image') {
      steps {
        script {
        sh """
          set -x
          rm -rf oc-build && mkdir -p oc-build/deployments
          for t in \$(echo "jar;war;ear" | tr ";" "\\n"); do
            cp -rfv ./target/*.\$t oc-build/deployments/ 2> /dev/null || echo "No \$t files"
          done
          oc start-build cant-touch-this --from-dir=oc-build --wait=true --follow=true || exit 1
        """
        }
      }
    }

  }
}
