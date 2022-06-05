### What is Kubernetes Service API? 🧧

- Virtual IP handles the entry poitns for multiple pods. 
- Virtual IP plays a role of a loadbalancer.


### Service Type 🎨

- Cluseter IP (Default) : Create a virtual IP for a group of pods

- NodePort: It works after creating a cluster IP and every worker node can have a dedicated port number thta can be accessed externally

- LoadBalancer: It provisions LoadBalancers automatically for AWS, Azure, and GCP

- EternalName: It is a special case of Service that does not have selectors and uses DNS name instead 


### Cluster IP  👓

- As above mentioned, the cluster IP will enable multiple pods can be accessed randomly by using a clusterIP. 
- Let's say you have multiple nginx pods running on the node 

```
Every 2.0s: kubectl get pods -o wide                          controlplane: Sun Jun  5 22:41:31 2022

NAME                           READY   STATUS    RESTARTS   AGE   IP           NODE     NOMINATED NO
DE   READINESS GATES
deploy-nginx-6f8645dc9-9p4bt   1/1     Running   0          11m   10.244.1.5   node01   <none>
     <none>
deploy-nginx-6f8645dc9-df4zh   1/1     Running   0          11m   10.244.1.4   node01   <none>
     <none>
deploy-nginx-6f8645dc9-jntw4   1/1     Running   0          11m   10.244.1.3   node01   <none>
     <none>

```

- Run the below script 
- Now, you can access to one of the pods with curling 10.96.100.100 and this can be same for any users who would like to access the nginx service that has "webui" name selector 
```
# This will create a virutal IP pod and the cluster IP will connect to webui
apiVersion: v1
kind: Service
metadata:
 name: webui-svc
spec:
 clusterIP: 10.96.100.100 
 selector:
  app: webui
 ports:
 - protocol: TCP
   port: 80
   targetPort: 80 
```

- Verification 

``` 
curl 10.96.100.100 
<html>
<body>
<h1>Welcome to nginx!</h1>
<p>If you see this page, the nginx web server is successfully installed and
working. Further configuration is required.</p>

<p>For online documentation and support please refer to
<a href="http://nginx.org/">nginx.org</a>.<br/>
Commercial support is available at
<a href="http://nginx.com/">nginx.com</a>.</p>

<p><em>Thank you for using nginx.</em></p>
</body>
</html>

```


