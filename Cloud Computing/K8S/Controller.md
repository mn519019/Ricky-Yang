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

$ vi rc-nginx.yaml 
# You can always manually change the yaml file too 

$ kubectl delete rs rs-nginx --cascade=false
# Only deletes the controller, but keeps the pods

```

### Replicaset🕹

- It plays a similar role with Replication Controller 
- It has **'matchLabels'** and **'matchExpressions'** 

```
# example
selector:
  matchExpressions:
  -{key:version, operation: In, value:["1.14"]}
```

### Deployment 🎇

- It controls Replicaset and manage numbers of the pods 
- Rolling Update & Rolling Back 

```
# Create pods using --record
$ kubectl create -f <yaml file> --record

# rolling update
$ kubectl set image deployment <deploy name> <container name>=<new version image> --record 

# rolling back
$ kubectl rollout history deployment <deploy_name>
$ kubectl rollout undo deploy <deploy_name> --to-revision=<number of revision>

# check rollout history 
$ kubectl history deployment <pod name> 
```

### DaemonSet 💎

- Ensure every node runs a pod 
- It ensures every node has a pod running evenly so effective application deployment is possible
- Log monitoring can be used with DaemonSet. Since every pod needs to be monitored and logged the system details. 
- roll back is possible using Daemonset. Simply change the application version and this will be redeployed by each node in order. 

### StatefulSet 🎯

- It maintains the pod status such as pod's name and volume (storage) 
- Other controllers will create randon hashed names for creating pods 
- "serviceName" needs to be added in the yaml file 

```
# You can edit sf-nginx pods using below comment, so rollback and rollout is possible
$ kubectl edit statefulsets.apps  sf-nginx 
```

### Job 🎐

- k8s maintains the pods keep running 
- Job Controller is suitable for batch operation 
- A pod needs to be turned off when the batch operation is done
- This helps a pod complete the batch operation

```
# completion : Start conainers time

# parallelism: x number of pods will be created 

# activeDeadlineSeconds: batch job needs to be done within a set time

# restartPolicy: Never or OnFailure 

# backoffLimit: If "OnFailure" is selected, then only try 3 times. 
```


