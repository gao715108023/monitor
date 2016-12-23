#!/bin/sh
source ~/.bash_profile
mvn clean package -DskipTests
scp monitor-agent/target/monitor-agent.zip root@nayi:/opt/monitor
