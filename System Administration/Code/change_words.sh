#!/bin/bash
############SCENARIO#################
# Your task is creating prometheus alerts to monitor system metrics accurately.
# Your manager asked you to delete all zone from given alerts 
# Since he wants to apply the alert rules for all nodes
# Therefore, delete all the zone in the script efficiently. 
# In production environment, there will be more than coutnable numbers 
# You can use a script to delete all if you wish
# You are required to delete > , zone=~"stg35|qa35|dev35"
# Name of the file: test-rules.yml
#################End#################


echo "Please type the file name: "
read File
echo "You are searching $File"

if [ -f "$File" ]; then
    read Word
    echo "Please type words to replace: $Word"
    sed -e "s/$Word//g" $File > test-rules.yml
    #sed -e 's/, zone=~"stg35|qa35|dev35"//g' $File > test-rules.yml
    echo "Words has been replaced in a new file."

else
    echo "File has not found. Please try it again."
fi
   

# 13th June 2022 # 
# Solved the issue #