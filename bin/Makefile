JAR        = jar
JAR_FLAGS  = -cvfe

des = TaskMonitor

.PHONY: clean

$(des_jar): $(objs)
	$(JAR) $(JAR_FLAGS) $@ $(des) $^

clean:
	@echo Deleting $(des_jar)
	@rm -f $(des_jar)
	@echo Deleting $(objs)
	@rm -f $(objs)

