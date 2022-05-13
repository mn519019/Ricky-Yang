## Getting Started
- Please reference https://github.com/mn519019/Ricky-Yang/blob/master/Cloud%20Computing/K8S/Kubernetes_Cluster_Architecture.png for kubernetes setup.
- You can add more nodes if you wish.
- You can use either Ubuntu or Centos depending on your preference.

## Prerequistes
- Docker is required to run kubernetes
- Please download required version of Docker engine 
- Cent OS: https://docs.docker.com/engine/install/centos/
- Ubuntu OS: https://docs.docker.com/desktop/linux/install/ubuntu/

```
# This will show whether the docker engine is installed or not. 

$ docker version
```

## Installation 

### step 1: kubeadm, kubectl, kubelet
- Please reference https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/install-kubeadm/

kubeadm: the command to bootstrap the cluser
kubelet: the component that runs on all of the machines in your cluster and does things like starting pods and containers.
kubectl: the command line util to talk to your cluster.

```
sudo apt-get update
sudo apt-get install -y apt-transport-https ca-certificates curl
```
```
sudo curl -fsSLo /usr/share/keyrings/kubernetes-archive-keyring.gpg https://packages.cloud.google.com/apt/doc/apt-key.gpg

echo "deb [signed-by=/usr/share/keyrings/kubernetes-archive-keyring.gpg] https://apt.kubernetes.io/ kubernetes-xenial main" | sudo tee /etc/apt/sources.list.d/kubernetes.list

# Now install required packages
sudo apt-get update
sudo apt-get install -y kubelet kubeadm kubectl
sudo apt-mark hold kubelet kubeadm kubectl
```


