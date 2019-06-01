# A general java project makefile
# Author: Wu Jiqing (jiqingwu@gmail.com)
# create: 2012-06-12
# update: 2012-06-13
# version: 0.7

# 設置你要生成的jar包的文件名
# Set the file name of your jar package:
JAR_PKG = run.jar

# 設置你的項目的入口點
# Set your entry point of your java app:
ENTRY_POINT = run

# 是否需要res目錄，如果你的程序有圖片、文檔等，
# 最好放入res目錄中。
# yes: 需要；no：不需要
RES_DIR = yes

# 設置你項目包含的源文件
# 如果你使用了package，請自己在src下建立相應的目錄層次，
# 並將源文件放在對應的目錄中。
# 如你要生成的一個類是 com.game.A，
# 那麼你的源文件應該是 com/game/A.java。
# 多個類之間用空格間隔，如果一行太長，用'\'換行，
# 建議一行一個。
# 另外注意順序，如果class A 引用 class B，那麼B.java應該放在A.java前。
# SOURCE_FILES = \
# test/B.java \
# test/A.java
SOURCE_FILES = run.java
# 設置你的java編譯器
# Set your java compiler here:
JAVAC = javac
# 設置你的編譯選項
JFLAGS = -encoding UTF-8

# 用法：
# make new: 在你的工程目錄下生成src, bin, res子目錄。
# 如果你定義的類包含在某個包裡：請自己在src下建立相應的目錄層次。
# 最終的目錄結構如下：
# ├── a.jar
# ├── bin
# │     └── test
# │             ├── A.class
# │             └── B.class
# ├── makefile
# ├── res
# │     └── doc
# │            └── readme.txt
# └── src
#        └── test
#                ├── A.java
#                └── B.java
# make build: 編譯，在bin目錄下生成 java classes。
# make clean: 清理編譯結果，以便重新編譯
# make rebuild: 清理編譯結果，重新編譯。
# make run: make 之後，可以通過make run查看運行結果。
# make jar: 生成可執行的jar包。

#############下面的內容建議不要修改####################
vpath %.class bin
vpath %.java src

# show help message by default
Default:
	@echo "make new: new project, create src, bin, res dirs."
	@echo "make build: build project."
	@echo "make clean: clear classes generated."
	@echo "make rebuild: rebuild project."
	@echo "make run: run your app."
	@echo "make jar: package your project into a executable jar."

build: $(SOURCE_FILES:.java=.class)

# pattern rule
# 不能處理兩個類互相引用的情況，盡量避免
%.class: %.java
	$(JAVAC) -cp bin -d bin $(JFLAGS) $<

rebuild: clean build

.PHONY: new clean run jar

new:
ifeq ($(RES_DIR),yes)
	mkdir -pv src bin res
else
	mkdir -pv src bin
endif

clean:
	rm -frv bin/*

run:
	java -cp bin $(ENTRY_POINT)

jar:
ifeq ($(RES_DIR),yes)
	jar cvfe $(JAR_PKG) $(ENTRY_POINT)  -C bin . res
else
	jar cvfe $(JAR_PKG) $(ENTRY_POINT) -C bin .
endif