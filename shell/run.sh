BIN=/home/ej/files/workspaces/TaskMonitor/bin/taskmonitor.jar
#CLASS_PATH=/home/ej/files/workspaces/TaskMonitor/lib/log4j-1.2-api-2.11.0.jar:/home/ej/files/workspaces/TaskMonitor/lib/log4j-api-2.11.0.jar:/home/ej/files/workspaces/TaskMonitor/lib/log4j-slf4j-impl-2.11.0.jar:/home/ej/files/workspaces/TaskMonitor/lib/log4j-core-2.11.0.jar:/home/ej/files/workspaces/TaskMonitor/lib/log4j-iostreams-2.11.0.jar
CLASS_PATH=/home/ej/files/workspaces/TaskMonitor/lib/log4j-1.2.17.jar
LOG_ID=100001
#LOG4J_PROP=/home/ej/files/workspaces/TaskMonitor/etc/log4j.properties
CFG=/home/ej/files/workspaces/TaskMonitor/etc/task_mon.cfg

rm -f nohup.out

#nohup java -jar ${BIN} ${LOG_ID} ${CFG} &
#java -Dfile.encoding=UTF-8 -Dlog4j.configuration=${LOG4J_PROP} -Xbootclasspath/a:${CLASS_PATH} -jar ${BIN} ${LOG_ID} ${CFG}
nohup java -Xbootclasspath/a:${CLASS_PATH} -jar ${BIN} ${LOG_ID} ${CFG} &

