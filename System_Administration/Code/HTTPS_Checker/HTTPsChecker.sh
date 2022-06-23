#!/bin/bash

# HTTP Status will in a play when you ensure servers are running as expected. 
# There will be various senciaro and you are going to check http status code using this script for multiple servers.
# Desired HTTP(s) STATUS CODE 200
# The script can be improved to reflect multiple HTTP(s) Status Code if you wish!

# TEST CASES
# https://rickyyang.netlify.com -> 200 will success
# https://google.ca -> 302 will fail


echo "Please state how many server would you like to check!"
read n 

for ((c=1; c<=n; c++))
do 
      echo "Please type full ip or  domain name"
      read website
      res=`curl -I -s $website | egrep HTTP | awk {'print $2'}`
        if [ "$res" -ne 200 ]; then 
            echo "The server is not stable. Status code $res."
        else
            echo "Successfully get the desired http status. Status code $res."
            exit 0
        fi
done
exit 1