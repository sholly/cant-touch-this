#!/bin/sh

sshkey=$(cat ~/.ssh/shollygithub |base64 -w 0)

oc process -p APPLICATION_NAME=cant-touch-this \
	 -p SSH_KEY_NAME="shollygithub" \
	 -p SSH_PRIVATE_KEY=${sshkey} \
	 -p NAMESPACE="ci-cd" -f buildconfig.yml |oc apply -f -

