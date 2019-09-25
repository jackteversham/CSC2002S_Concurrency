JAVAC = /usr/bin/javac
JFLAGS = -g
.SUFFIXES: .java .class

SRCDIR=skeletonCodeAssgnmt4
BINDIR=bin
DOCDIR=doc

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) $(JFLAGS) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=Score.class WordDictionary.class WordRecord.class checkFinished.class WordApp.class WordPanel.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

run:
	java -cp $(BINDIR) WordApp

docs:
	javadoc -d $(DOCDIR) $(SRCDIR)/*.java

clean:
	rm $(BINDIR)/*.class
