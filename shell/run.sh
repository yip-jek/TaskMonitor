MAIN_PATH=/home/ej/files/workspaces/TaskMonitor
BIN=${MAIN_PATH}/bin/taskmonitor.jar
CLASS_PATH=${MAIN_PATH}/lib/log4j-1.2.17.jar:${MAIN_PATH}/lib/db2jcc.jar
LOG4J_PROP=${MAIN_PATH}/etc/log4j.properties
CFG=${MAIN_PATH}/etc/task_mon.cfg

rm -f nohup.out

nohup java -Xbootclasspath/a:${CLASS_PATH} -jar ${BIN} ${LOG4J_PROP} ${CFG} &

