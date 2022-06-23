#!/bin/bash

# Reference: https://www.garron.me/en/bits/how-to-md5sum-mac-os-x.html
# If you use Linux such as Ubuntu, the command is slightly different
# You may use md5sum instead. Sometimes as a sys admin, you are required to validate whether data is same or not
# md5 command line tool is quicky validating whether the files are identical or not
# Limitation: space or small minor changes can't be detected since it uses hash function to validate each file

#echo "Please state how many files would you like to compare!"
#read n 

for ((c=1; c<=2; c++))
do 
        echo "please type file name with full path!"
        read file
        result=$(md5 $file)
        array+=("$result")
done

#echo ${array[@]} | sed 's/^.*= //'

for str in ${array[@]}; do
  echo $str
done


