## Pod with init container 📦

- The concept is ensuring the main container in running well.
- If the init container fails, the main container will never start. 
- It ensures all te required services are running before starting the application.


## Infrastructure contianer (pause containers) 🏗

- When you create a container, a hidden <**pause**> container will be created simultaniously per pod.
- A pause container manages ip, host, network, and other infra resources for corresponding containers. 
- You can create a pod and ssh into the corresponding node then check the docker information 

```
# Create a nginx server that uses port 80 
$ kubectl run webserver --image=nginx:1.14 --port=80

# Get the pod information 
$ kubectl get pods -o wdie 

# This shows that the webserver is running on node01 
NAME        READY   STATUS    RESTARTS   AGE     IP           NODE     NOMINATED NODE   READINESS GATES
webserver   1/1     Running   0          4m54s   10.244.1.6   node01   <none>  

# ssh into the node 
$ ssh node01

# Will show the running container information 
$ docker ps 

# You will see that nginx and pause container will be created simultaniously.
```

## static pod
- A static pod is managed by **kubelet Daemon**
- You do not need an API server, so you can run a static pod in the node01~03.
- Go to /var/lib/kubernetes and change the **staticPodPath **if you need.
- The pod will start runing when you save k8s yaml file in the **/etc/kubernetes/manifest**s directory
- To delete the pod, you need to delete the yaml file 

```
$ vi /var/lib/kubelet/config.yaml 

$ static pod path: /etc/Kubernetes/manifests

$ systemctl restart kubelet
```
