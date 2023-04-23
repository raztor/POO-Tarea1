# Makefile para Stage1

# Variables
JAVAC=javac
JAVA=java
JFLAGS=

# Reglas
all: Stage1.class

Stage1.class: Stage1.java
	$(JAVAC) $(JFLAGS) $<

run: Stage1.class
	$(JAVA) Stage1

clean:
    rm -f *.class
