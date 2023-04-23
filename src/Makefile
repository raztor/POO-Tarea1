# Makefile para Bonus

# Variables
JAVAC=javac
JAVA=java
JFLAGS=

# Reglas
all: Bonus.class

Bonus.class: Bonus.java
	$(JAVAC) $(JFLAGS) $<

run: Bonus.class
	$(JAVA) Bonus

clean:
    rm -f *.class
