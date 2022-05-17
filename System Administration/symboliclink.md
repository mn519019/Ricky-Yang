### Prerequisites 🔎
- Linux system (Ubuntu or CentOS) 
- Terminal (CLI)
- sudo or root privileges 

### Getting Started 🔰
- A symbolic link is creating an access point for files or folders on the computing machine.
- Simply put, it serves as a reference to another file or directory. 
- We are going to focus on soft links this time. 
- I often use this to debug system issues related to missing files, libraries, and so on. 

### Symbolic link in Ubuntu 🔗

- It may still be confisuing for you. Let me give you an example case.
- You are in situation to update your Operating System but the latest version of OS is not fully compatible
with previous version of OS. You were running a web application and the updated os is not fully fucntional in this case.
Luckly, you found some data from log files saying that library14.s.0 is not available. 
- As a first step you may verify creating a softlink that points library 13 with 14 and restart the web application.
- If it works, you may unlink the symbolic link and restart the web application 

```
$ ln -s <source file path> <symbolic file> 

# exmple
$ ln -s library13.so.0 library14.so.0 

# verify the symlink 
$ ln -la | grep -i .so.0

#sample outputs 
-rw-r--r-- 1 root root 0 May 16 22:00 library13.so.0
lrwxr-xr-x 1 root root 5 May 16 22:00 library14.so.0 -> library13.so.0
.
.
```
### Remove symlinks 🛠
- You should delete the <b>symbolic file name</b> not the <b> source file path </b>
```
$ rm -f symlink_dir/ 
$ rm symlink_file
$ unlink symlink_name 
```
