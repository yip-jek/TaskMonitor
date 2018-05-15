BIN=/home/ej/files/workspaces/TaskMonitor/bin/taskmonitor.jar
LOG_ID=100001
CFG=/home/ej/files/workspaces/TaskMonitor/etc/task_mon.cfg

#nohup java -jar ${BIN} ${LOG_ID} ${CFG} &
java -jar ${BIN} ${LOG_ID} ${CFG}

