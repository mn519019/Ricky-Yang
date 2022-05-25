### What is Controller? ⚔

- It ensures number of pods .
- You can deploy webserver using command line interface if the right containerized image is available. 
- Kubernetes will look up nodes and deploy servers 
- It may play a role of ensuring service safer.

```
$ kubectl create deployment myweb --image=nginx --replica=3 
```

### Replication Controller 🎃

- Set pod numbers and let K8S to keep the set number of pods.
- If a pod goes down, K8S will create a new pod to keep the pod numbers
- Replication Controller consists of "selector", "replicas", and "template"
- "**label**" should be included in the template so "**selector**" can ensure pod numbers

```
$ kubectl create rc-nginx --image=nginx -replicas=3 --selector=app=webui
```

### CMD Controoler Tweaks 🧩

- rc-ngix is the name of the pod
- rc-nginx is defined in the metadata 
- Controller only looks after **"selector"** so manual change is not aplicable apart from **"selector"**
```

$ kubectl edit rc rc-ngix 
# Then change the replicas number if you need 

kubectl scale rc rc-nginx --replicas=2 
# This will change the replicas number

# vi rc-nginx.yaml 
# You can always manually change the yaml file too 

```
