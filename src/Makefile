# Makefile para Stage2

# Variables
JAVAC=javac
JAVA=java
JFLAGS=

# Reglas
all: Stage2.class

Stage2.class: Stage2.java
	$(JAVAC) $(JFLAGS) $<

run: Stage2.class
	$(JAVA) Stage2

clean:
    rm -f *.class
