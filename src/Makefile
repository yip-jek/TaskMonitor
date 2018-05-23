JAVAC      = javac
JAVA_FLAGS = -encoding utf-8 -d $(BIN_PATH)
CLASS_PATH = -cp $(LIB_PATH)/log4j-1.2.17.jar:$(LIB_PATH)/db2jcc.jar:$(BIN_PATH)

APP_PATH = ..
BIN_PATH = $(APP_PATH)/bin
LIB_PATH = $(APP_PATH)/lib

des_jar = taskmonitor.jar
tar_gz  = $(APP_PATH)/tm.src.tar.gz
srcs    = $(wildcard *.java)
objs    = $(srcs:.java=.class)

# 导出变量，到子makefile中也可使用
export des_jar objs

# 让 make 到指定目录搜索指定类型的文件
vpath %.class $(BIN_PATH)
vpath %.jar   $(BIN_PATH)

# 伪目标
.PHONY: all clean tar_src

# 中间目标
.INTERMEDIATE: fake_target

all: $(des_jar)
	@echo ALL MADE

$(des_jar): $(objs)
	@make -C $(BIN_PATH)

#%.class: %.java
#	$(JAVAC) $(JAVA_FLAGS) $(CLASS_PATH) $<

$(objs): fake_target

fake_target: $(srcs)
	$(JAVAC) $(JAVA_FLAGS) $(CLASS_PATH) $^

# 清理
clean:
	@make -C $(BIN_PATH) clean

# 打包（源码文件）
tar_src:
	@echo "tar source file(s) ..."
	@tar -zcvf $(tar_gz) $(srcs)

