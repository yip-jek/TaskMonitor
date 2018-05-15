JAVAC      = javac
JAVA_FLAGS = -d $(BIN_PATH)
#CLASS_PATH = -cp $(LIB_PATH)/log4j-1.2-api-2.11.0.jar:$(LIB_PATH)/log4j-api-2.11.0.jar:$(LIB_PATH)/log4j-slf4j-impl-2.11.0.jar:$(LIB_PATH)/log4j-core-2.11.0.jar:$(LIB_PATH)/log4j-iostreams-2.11.0.jar
CLASS_PATH = -cp $(LIB_PATH)/log4j-1.2.17.jar

APP_PATH = ..
BIN_PATH = $(APP_PATH)/bin
LIB_PATH = $(APP_PATH)/lib

des_jar = taskmonitor.jar
srcs    = $(wildcard *.java)
objs    = $(srcs:.java=.class)

export des_jar objs

vpath %.class $(BIN_PATH)
vpath %.jar   $(BIN_PATH)

.PHONY: all clean

all: $(des_jar)
	@echo ALL MADE

$(des_jar): $(objs)
	@make -C $(BIN_PATH)

%.class: %.java
	$(JAVAC) $(JAVA_FLAGS) $(CLASS_PATH) $<

clean:
	@make -C $(BIN_PATH) clean

