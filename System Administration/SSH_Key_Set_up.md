This doucment is written for ubuntu 20.04 

Step 1 - Creating the key pair 
- If you have exisiting ssh key or even not sure whether it exists. Please use the below command to see whether the id_rsa.pub and id_rsa files in the directory.

  $ cd ~/.ssh 
  or
  $ ls -l ~/.ssh/id_*.pub 
  
- If it exists you can simply copy the public key to the remote server and you are no longer required to type in password every time to ssh into the remote instance or node. 

  $ ssh username@IP Address 
  
- IF it does not exist in the directory, you are required to create key pair. 
  #This will create a 3072-bit RSA key pair. 
  
  $ ssh-keygen
  
  #Please hit the enter key to process further
  Output
  Generating public/private rsa key pair.
  Enter file in which to save the key (/your_home/.ssh/id_rsa):
  
  #Please hit the enter key to process further or you can specify passphrase if you want 
  Output
  Enter passphrase (empty for no passphrase):
