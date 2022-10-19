#!/bin/bash
# Should run this script with sudo access

node_exporter_version=1.3.1

useradd -rs /bin/false node_exporter
mkdir /usr/local/prometheus
#Download Binary
wget https://github.com/prometheus/node_exporter/releases/download/v$node_exporter_version/node_exporter-$node_exporter_version.linux-amd64.tar.gz

# Extract the tar ball
tar xvzf node_exporter-$node_exporter_version.linux-amd64.tar.gz

cp -r node_exporter-$node_exporter_version.linux-amd64/ /usr/local/prometheus/
chown node_exporter:node_exporter /usr/local/prometheus/node_exporter-$node_exporter_version.linux-amd64/node_exporter


#Creating Service File
cat <<- EOF > /etc/systemd/system/node_exporter.service
[Unit]
Description=Node Exporter
Wants=network-online.target
After=network-online.target
[Service]
Restart=alway
User=node_exporter
Group=node_exporter
Type=simple
ExecStart=/usr/local/prometheus/node_exporter-$node_exporter_version.linux-amd64/node_exporter --collector.systemd
[Install]
WantedBy=multi-user.target
EOF
#Reload and Start
systemctl daemon-reload;
systemctl enable node_exporter
systemctl start node_exporter
systemctl status node_exporter
