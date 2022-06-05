### What is Kubernetes Service API? 🧧

- Virtual IP handles the entry poitns for multiple pods. 
- Virtual IP plays a role of a loadbalancer.

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

### Service Type 🎨

- Cluseter IP (Default) : Create a virtual IP for a group of pods

- NodePort: It works after creating a cluster IP and every worker node can have a dedicated port number thta can be accessed externally

- LoadBalancer: It provisions LoadBalancers automatically for AWS, Azure, and GCP

- EternalName: It is a special case of Service that does not have selectors and uses DNS name instead 

