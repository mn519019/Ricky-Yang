#!/bin/bash

if(($#!=1))
then
	# Then, display usage
	echo "Usage: $0 [LOG FILE]"
else
# File path can be changed
    LOG_FILE="/home/minwyang/example/python/log_monitoring/log_file.txt"

    # Get the current number of line for the log file
    old=$(cat $LOG_FILE | wc -l)
        # looping the condition 
    while true
    do
         new=$(cat $LOG_FILE | wc -l)

        if [[ $new -gt $old ]]
        then 
            #read each new line using a while loop
            while read -r line; do
                    
                # grep two patterns which are status code and path
                code=$(echo $line | grep -Eo '"(GET|POST) /[^ ]* HTTP/[012].[0-9]" [1-6][0-9][0-9]' | cut -d' ' -f4)
		# Get the HTTP path from the log entry
		path=$(echo $line | grep -Eo '"(GET|POST) /[^ ]* HTTP/[012].[0-9]" [1-6][0-9][0-9]' | cut -d' ' -f2)

                if [[ $code -eq "500" ]]
                then
                    #mail "alert@project.com" "HTTP 500 on $path" 2>/dev/null
                    echo "Status code \"$code\" is not acceptable. Please inveistage the issue on \"$path\""
                fi
            done < <(cat $LOG_FILE | tail -$((new-old)))
            # update the file
            old=$new
        fi
    done
fi             
