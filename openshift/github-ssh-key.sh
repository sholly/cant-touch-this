#!/bin/sh 
set -x
sshkey=$(cat ~/.ssh/shollygithub |base64 -w 0)
oc process -p SSH_KEY_NAME="shollygithub"\
         -p SSH_PRIVATE_KEY=${sshkey} \
	 -p NAMESPACE=ci-cd\
	 -f github-ssh-key.yml | oc apply -f - 

