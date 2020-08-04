#!/bin/sh

sshkey=$(cat ~/.ssh/shollygithub |base64 -w 0)

oc process -p APPLICATION_NAME=cant-touch-this \
	 -p NAMESPACE="ci-cd" -f buildconfig.yml |oc apply -f -

