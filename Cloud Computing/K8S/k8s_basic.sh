# /bin/bash

# show connected all nodes with a master node 
$ kubectl get node 

#show extra node information 
$ kubectl get node -o wide 

# show all pods from the node
$ kubectl get pods 

#show extra pod information 
$ kubectl get pods -o wide 

# Describe the node details 
$ kubectl describe node <node name> 

#Describe the pod details 
$ kubectl describe pod <pod name> 

#Deploy 3 pods using nginx image
$ kubectl create deploy webui --image=nginx:latest --replics=3 

#Create a namespace for your needs  
$ kubectl create deploy ui --image=nginx --namespace prod
$ kubectl create deploy ui --image=nginx --namespace dev 

#How to use namespace 
#namespace for CLI 
$ kubectl create namespace blue 
$ kubectl get namespaces 

#namespace for yaml 
$ kubectl create namesapce dev --dry-run -o yaml > dev.yaml
$ vim dev.yaml
$ kubectl create -f dev.yaml





