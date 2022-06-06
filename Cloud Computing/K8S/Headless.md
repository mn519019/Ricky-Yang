### Wat is Headless Service ? 

- Sometimes you would want to have an end-point, but do not need load-balancing and single cluster ip. In this case, you can create headless service instead.
- You can specify "none" in the cluster ip section.
- It does not have a cluster ip 


### Kube-proxy 

- Implement backend functions to use Kubernets Service
- Build iptables to connect endpoint
- Ensure pod to connect each other using nodeport
