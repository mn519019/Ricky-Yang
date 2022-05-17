## What is SSH keys 
- It enables the automation to ssh into the server. It grants safer access and control who can access 
- SSH are consisting of two parts which are private and public keys 
- You keep the private key and share the public keys tat you would like to authenticate and establis an enrypted communication channel between a client and a remote server over the internet
- Port 22 is bening used by default. So ensure if you want to use <b>Secure Shell</b>(ssh) protocol. 

## Getting Started
1. This doucment is written for ubuntu 20.04 
2. It is important you have ssh packges installed on your server 
3. People know the idea that key pairs exist but they sometimes got confused what key needs to be placed in the remote server 
4. Please reference https://github.com/mn519019/Ricky-Yang/blob/master/System%20Architecture/SSH_Client_Server_Authentication.pdf to understand how it works.
5. You are not going to share your private key anyone else since this will lead to the security breach so make sure you keep your private key safe! 


## Step 1 - Creating the key pair 
- If you have exisiting ssh key or even not sure whether it exists. Please use the below command to see whether the id_rsa.pub and id_rsa files in the directory.

```
  $ cd ~/.ssh 
  or
  $ ls -l ~/.ssh/id_*.pub 
```

  
- If it exists you can simply copy the public key to the remote server and you are no longer required to type in password every time to ssh into the remote instance or node. 
```
  $ ssh username@IP Address 
```
- If it does not exist in the directory, you are required to create key pair. 
  #This will create a 3072-bit RSA key pair. 
```  
  $ ssh-keygen
``` 
  #Please hit the enter key to process further
```  
  Output
  Generating public/private rsa key pair.
  Enter file in which to save the key (/your_home/.ssh/id_rsa):
```  
  #Please hit the enter key to process further or you can specify passphrase if you want
```  
  Output
  Enter passphrase (empty for no passphrase):
```  
  - Now your public and private key will be stored in the ~/.ssh/ directory. 


## Step 2 - Copying the public key to your remote server 

- Now, it's time to copy your public key to remote server and there is a command for you
```
  $ ssh-copy-id username@remote_host 
``` 
- You will see the following messages
```
  Output
  The authenticity of host 'x.x.x.x (x.x.x.x)' can't be established.
  ECDSA key fingerprint is fd:fd:d4:f9:77:fe:73:84:e1:55:00:ad:d6:6d:22:fe.
  Are you sure you want to continue connecting (yes/no)? 
  yes
  
  Output
  /usr/bin/ssh-copy-id: INFO: attempting to log in with the new key(s), to filter out     any that are already installed
  /usr/bin/ssh-copy-id: INFO: 1 key(s) remain to be installed -- if you are prompted now   it is to install the new keys
  username@remote_server's password:
  
  Output
  Number of key(s) added: 1

  Now try logging into the machine, with:   "ssh 'username@remote_server'"
  and check to make sure that only the key(s) you wanted were added.
 ``` 
## Step 3 - Authenticating to Your Ubuntu Server Using SSH Keys
```
  $ ssh username@remote_server 
   
    Output
    The authenticity of host '203.0.113.1 (203.0.113.1)' can't be established.
    ECDSA key fingerprint is fd:fd:d4:f9:77:fe:73:84:e1:55:00:ad:d6:6d:22:fe.
    Are you sure you want to continue connecting (yes/no)? yes
```
  - If you see you got into the new server in your terminal, this proves that the ssh   
  key authentication is completed! Congrats! 
  
  
