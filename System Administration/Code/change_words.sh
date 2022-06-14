#!/bin/bash

# You are required to delete > , zone=~"stg35|qa35|dev35"
# Name of the file: test-rules.yml

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
   

