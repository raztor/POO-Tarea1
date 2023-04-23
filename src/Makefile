# Makefile para Stage4

# Variables
JAVAC=javac
JAVA=java
JFLAGS=

# Reglas
all: Stage4.class

Stage4.class: Stage4.java
	$(JAVAC) $(JFLAGS) $<

run: Stage4.class
	$(JAVA) Stage4

clean:
    rm -f *.class
