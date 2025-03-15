ifeq ($(OS),Windows_NT)
SEP = ;
else
SEP = :
endif
JC = javac
JAR = jar
JFLAGS = -cp $(WIN_INCLUDE)$(SEP)$(UNIX_INCLUDE)$(SEP)$(SRC_INCLUDE)
LIB = lib
WIN_INCLUDE = $(LIB)/windows/jintellitype.jar
UNIX_INCLUDE = $(LIB)/unix/lib/JXGrabKey.jar
SRC_INCLUDE = src/main/java
EXAMPLES = examples
SRC = src/main/java/com/dstjacques/jhotkeys

all: source examples library

source: \
         JHotKeyListener.class \
         JHotKeyController.class \
         UnixHotKeyController.class \
         WindowsHotKeyController.class \
         JHotKeys.class

JHotKeyListener.class: $(SRC)/JHotKeyListener.java
	$(JC) $(JFLAGS) $(SRC)/JHotKeyListener.java

JHotKeyController.class: $(SRC)/JHotKeyController.java
	$(JC) $(JFLAGS) $(SRC)/JHotKeyController.java

UnixHotKeyController.class: $(SRC)/UnixHotKeyController.java
	$(JC) $(JFLAGS) $(SRC)/UnixHotKeyController.java

WindowsHotKeyController.class: $(SRC)/WindowsHotKeyController.java
	$(JC) $(JFLAGS) $(SRC)/WindowsHotKeyController.java

JHotKeys.class: $(SRC)/JHotKeys.java
	$(JC) $(JFLAGS) $(SRC)/JHotKeys.java

examples: \
            GlobalHotKeyExample.class

library: source
	$(JAR) cvf $(LIB)/JHotKeys.jar -C $(SRC_INCLUDE) .

GlobalHotKeyExample.class: $(EXAMPLES)/GlobalHotKeyExample.java
	$(JC) $(JFLAGS) $(EXAMPLES)/GlobalHotKeyExample.java

clean:
	$(RM) $(SRC)/*.class
	$(RM) $(EXAMPLES)/*.class
	$(RM) $(LIB)/*.jar


