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




