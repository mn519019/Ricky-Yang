#!/bin/bash

# check whether the script runs as a root user
if ! [ $(id -u) = 0 ]; then
   echo "The script need to be run as root." >&2
   exit 1
fi

echo "please type file name to create a backup."
read file
echo "You are creating $file as a backup."
backup=`date +"%m-%d-%Y"`
# Set Source and Destination paths
DEST=/var/backup_file/backup-$backup.tar.gz
SRC=/Users/rickyyang/Desktop/Ricky-Yang/System_Administration/Code/Create_BackUps/$file
# Run a script when a condition passes
if [ -f "$file" ]; then
    sudo tar -cpzf $DEST $SRC
    echo "Backup has been completed"
    echo "* * * * * "
sleep 1
else 
    echo "Please check whether the file exists"
    exit 1
fi


# It's possible to create a cron task but then you would need to modify code instead of typing  a file.


