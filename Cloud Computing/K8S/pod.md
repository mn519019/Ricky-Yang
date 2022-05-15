## pod for kubernetes 👌

- Before you start using k8s, you may reference https://github.com/mn519019/Ricky-Yang/blob/master/Cloud%20Computing/K8S/K8S_Set_Up.md to set up k8s in your enviornment
- A Pod is a mnimal unit of the K8S API to show a container 
- A pod may contain more than one container such as <b>web-server</b> and <b>web-log </b>

## How to crate a pod ? 😎

```
# run with a docker image
$ kubectl run webserver --image=nginx:latest 

# run with a yaml file
$ kubectl create -f pod-nginx.yaml 

# monitor your pods using watch command in CLI, default is every 2 second
$ watch kubectl get pods -o wide 

# watch the pod (port 80 should be opened)
$ curl <IP address> 

# check current ip of the pod, use either json or yaml 
$ kubectl get pods <name of the pod> -o json | grep -i podip 
```

## multi-container pod creation 🤷‍♂️
- You can create 2 containers in a pod. This can be a beautiful feature of the <b>k8s</b>! 

``` 
apiVersion: v1
kind: Pod
metadata:
  name: multipod
spec:
  containers:
  - name: nginx-container
    image: nginx:1.14
    ports:
    - containerPort: 80
  - name: centos-container
    image: centos:7
    command:
    - sleep
    - "10000"
```
## ssh into the pod from your master node a.k.a control-plane  ✔
- It's similar like docker 
- Multiple containers in the same pod uses a same IP 
- <b>i</b> means interactive 
- <b>t</b> means terminal 
```
$ kubectl exec <pod name> -c <container name> -it -- /bin/bash 
```
## troubleshooting pod ✨
- It's common to see a trouble and you may want to see a log of the container 
```
$ kubectl logs <pod name> -c <contianer name> 
```
