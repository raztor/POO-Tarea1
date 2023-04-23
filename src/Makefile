# Makefile para Stage1

# Variables
JAVAC=javac
JAVA=java
JFLAGS=

# Reglas
all: Stage1.class

Stage1.class: Bonus.java
	$(JAVAC) $(JFLAGS) $<

run: Stage1.class
	$(JAVA) Stage1 ./resources/config.txt

clean:
	rm -f *