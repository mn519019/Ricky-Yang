## pod for kubernetes 

- A Pod is a mnimal unit of the K8S API to show a container 
- A pod may contain more than one container such as web-server and web-log 

## How to crate a pod ? 

```
# run with a docker image
$ kubectl run webserver --image=nginx:latest 
# run with a yaml file
$ kubectl create -f pod-nginx.yaml 
```
