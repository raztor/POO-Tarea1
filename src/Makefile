# Makefile para Stage1

# Variables
JAVAC=javac
JAVA=java
JFLAGS=

# Reglas
all: Bonus.class

Stage1.class: Bonus.java
	$(JAVAC) $(JFLAGS) $<

run: Stage1.class
	$(JAVA) Bonus ./resources/config.txt

clean:
	rm -f *