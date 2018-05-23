.PHONY: all clean tar_src

all:
	@make -C src

clean:
	@make -C src clean

tar_src:
	@make -C src tar_src

