## What is self-healing ? 🤷‍♂️
- Ensure pods are running all the times 
- self-healings are defined in the <b> spec </b>

## livenessProbe ✅
- It is important to undestand what you want to inspect 
- There are three mechanisms available 

### httpGet ✨
- It can be used for webservice 
- httpGet method is using IP address, port number, and path. They send a <b> GET </b> reuest to the container and ensure whether the status code is 200 or not. If it is not, kubnertes will kill the container and restart the service 

```
livenessProbe:
  httpGet
    path: /
    port 80
```

### tcpSocket ✨
- It can be used for sshd service 
- Try to connect using <b>TCP</b>, and if the connection is not available, k8s will restart the container

```
// Let's assume we are trying to connect sshd service
livenessProbe:
  tcpSocket:
    port 22
```

### exec ✨
- A command based checking method
- If the exit code is not <b> 0 </b>, k8s will restart the container 

```
livenessProbe:
  exec:
    command:
    - ls
    - /var/mysql
```

