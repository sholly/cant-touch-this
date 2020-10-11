This is a placeholder, just working on a private project for openshift testing.
dont forget to update the openshift-sync version in Jenkins, otherwise you will not be 
able to pull from private repos no matter what you do. 
It will annoy you. 

setting up the build: 

Set up the Ci-CD namespace

set up github ssh key:
set up template and shell script, see openshift/github-ssh-key

quayio secret and link to builder: 
Make sure you've logged into quay.io, then create the secret from the ~/.docker/config.json: 
oc create secret generic quayio --from-file=.dockerconfigjson=/home/sholly/.docker/config.json --type=kubernetes.io/dockerconfigjson
oc secrets link builder quayio
