# Makefile para Stage3

# Variables
JAVAC=javac
JAVA=java
JFLAGS=

# Reglas
all: Stage3.class

Stage3.class: Stage3.java
	$(JAVAC) $(JFLAGS) $<

run: Stage3.class
	$(JAVA) Stage3

clean:
    rm -f *.class
