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
### step 2: Build a master component and network environment setup

- Please remember, this setup is only neeeded for the master node

```
# Create a single control-plane cluster with kubeadm

$ kubeadm init

# This will generate below messages 

...
To start using your cluster, you need to run the following as a regular user:

# run this on the maseter node 
mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
sudo chown $(id -u):$(id -g) $HOME/.kube/config
...
# remember the token 
kubeadm join 10.100.0.104:6443 --token 1ou05o.kkist9u6fbc2uhp3 --discovery-token-ca-cert-hash sha256:8d9a7308ea6ff73.........576c112f326690

```
- It's important to remember toekn to join with other nodes with your master node. Thus, you can keep your token in your local desktop just in case. 

``` 
$ cat > token.txt
kubeadm join 10.100.0.104:6443 --token 1ou05o.kkist9u6fbc2uhp3 --discovery-token-ca-cert-hash sha256:8d9a7308ea6ff73.........576c112f326690
```
### step 3: Installing a pod network add-on 

- This ensures that your nodes are connected. Weave Net provides a network to connect all pods together, implementing the Kubernetes model. Kubernetes uses the Container Network Interface (CNI) to join pods onto Weave Net.

``` 
$ kubectl apply -f "https://cloud.weave.works/k8s/net?k8s-version=$(kubectl version | base64 | tr -d '\n')"

$ kubectl get nodes
```

### step 4: Build a worker node and connect with master node 

- SSH into node1 and node2 and please run the 'kubeadm join token' while running kubeadm init command on the master node 

```
# kubeadm join 10.100.0.104:6443 --token 1ou05o.kk...3 --discovery-token-ca-cert-hash sha256:8d9a7308ea6ff73.........576c112f326690

```

### step 5: Verification 

```
$ kubectl get nodes 

# Below messages will show up if you are connected correctly 

NAME                 STATUS   ROLES    AGE   VERSION
master.example.com   Ready    master   10m   v1.18.0
node1.example.com    Ready    <none>   17m   v1.18.0
node2.example.com    Ready    <none>   17m   v1.18.0

```
