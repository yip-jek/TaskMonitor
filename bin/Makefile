JAR        = jar
JAR_FLAGS  = -cvfm

mf  = MANIFEST.MF
#des = TaskMonitor
lib = lib/log4j-1.2.17.jar lib/db2jcc.jar lib/db2jcc_license_cu.jar

.PHONY: clean

$(des_jar): $(objs) $(lib)
#$(JAR) $(JAR_FLAGS) $@ $(des) $^
	$(JAR) $(JAR_FLAGS) $@ $(mf) $^

clean:
	@echo Deleting $(des_jar)
	@rm -f $(des_jar)
	@echo Deleting $(objs)
	@rm -f $(objs)

