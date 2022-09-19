# 🧑‍💻 What is Chroot? 🧑‍💻

- chroot really means "change root directory"
- Every OS has "/" which is called root directory as well. Every directories and files exist under the "root directory" A.K.A "/".
- However, Windows use "\" as its root directory.

Let's assume we have a process called "R" 

- R can search other files based on the root directory "/"
- Let's say if we want to access file "E", then this will go through "/" -> "A"  -> "E".
- So basically, general processes use "/" and access files. 
- However, chroot can set the root directory at a different location such as any of directoreis; "A", "B", and so on.                              
                             "/"
                          /   |   \
                        "A"  "B"  "C"
                        /  \ 
                      "D"  "E"

Now, we would like to chroot and have a process called "K"  within the process "R".
- chroot/A /bin/bash
- Process K is no longer using "/" as its root directory but rather "A"
- With saying this, process K is not able to access "/" anymore.

                        "A"  
                        /  \ 
                      "D"  "E"









- Refrence: https://www.44bits.io/ko/post/change-root-directory-by-using-chroot
