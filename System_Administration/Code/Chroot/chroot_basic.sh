#! /bin/bash

# chroot --version 
# This will ensure whether chroot program exists in your OS. 
# Otherwsie, run "apt-get install coreutils" on Ubuntu

## Note ## 
# chroot command will require "sudo" access to run. 
# This will show all dependencies to run /bin/bash command
# ldd /bin/bash 

mkdir -p /tmp/new_root/bin/ /tmp/new_root/bin/bash/
sudo cp /bin/bash /tmp/new_root/bin/

mkdir -p /tmp/new_root/lib/x86_64-linux-gnu/ /tmp/new_root/lib64
cp /lib/x86_64-linux-gnu/libtinfo.so.6 /tmp/new_root/lib/x86_64-linux-gnu/
cp /lib/x86_64-linux-gnu/libdl.so.2 /tmp/new_root/lib/x86_64-linux-gnu/
cp /lib/x86_64-linux-gnu/libc.so.6 /tmp/new_root/lib/x86_64-linux-gnu/
cp /lib64/ld-linux-x86-64.so.2 /tmp/new_root/lib64

# This will show all dependencies to run ls command
# ldd /bin/ls

mkdir -p /tmp/new_root/bin/ls
cp /bin/ls /tmp/new_root/bin/ls
cp /lib/x86_64-linux-gnu/libselinux.so.1 /tmp/new_root/lib/x86_64-linux-gnu/
cp /lib/x86_64-linux-gnu/libc.so.6 /tmp/new_root/lib/x86_64-linux-gnu/
cp /lib/x86_64-linux-gnu/libpcre2-8.so.0 /tmp/new_root/lib/x86_64-linux-gnu/
cp /lib/x86_64-linux-gnu/libdl.so.2 tmp/new_root/lib/x86_64-linux-gnu/
cp /lib/x86_64-linux-gnu/libpthread.so.0 /tmp/new_root/lib/x86_64-linux-gnu/
cp /lib64/ld-linux-x86-64.so.2 /tmp/new_root/lib64

chroot /tmp/new_root /bin/bash/bash
chroot /tmp/new_root /bin/ls/ls

# As a result, this will install "ls" and "bash" command as chroot 
