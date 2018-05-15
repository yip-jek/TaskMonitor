JAVAC      = javac
JAVA_FLAGS = -d $(BIN_PATH)
BIN_PATH   = ../bin

des_jar = taskmonitor.jar
srcs    = $(wildcard *.java)
objs    = $(srcs:.java=.class)

vpath %.class $(BIN_PATH)
vpath %.jar   $(BIN_PATH)

.PHONY: all clean

all: $(des_jar)
	@echo ALL MADE

$(des_jar): $(objs)
	@make -C $(BIN_PATH)

$(objs): $(srcs)
	$(JAVAC) $(JAVA_FLAGS) $^

clean:
	@make -C $(BIN_PATH) clean

