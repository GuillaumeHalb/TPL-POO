# Ensimag 2A POO - TP 2015/16
# ============================
#
# Ce Makefile permet de compiler le test de l'ihm en ligne de commande.
# Alternative (recommandee?): utiliser un IDE (eclipse, netbeans, ...)
# Le but est d'illustrer les notions de "classpath", a vous de l'adapter
# a votre projet.
#
# Organisation:
#  1) Les sources (*.java) se trouvent dans le repertoire src
#     Les classes d'un package toto sont dans src/toto
#     Les classes du package par defaut sont dans src
#
#  2) Les bytecodes (*.class) se trouvent dans le repertoire bin
#     La hierarchie des sources (par package) est conservee.
#     Pour un package (ici gui.jar), il est aussi dans bin.
#
# Compilation:
#  Options de javac:
#   -d : repertoire dans lequel sont places les .class compiles
#   -classpath : repertoire dans lequel sont cherches les .class deja compiles
#   -sourcepath : repertoire dans lequel sont cherches les .java (dependances)

all: exeCellsSimu

testGUI:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestGUI.java

BallsSimu:	
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestBallsSimulator.java

CellsSimu:	
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestCellsSimulator.java

BallsSimu1:	
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestBallsSimulator1.java

Balls:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/Balls.java
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestBalls.java

testGUI1:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestGUI1.java


# Execution:
# on peut taper directement la ligne de commande :
#   > java -classpath bin TestGUI
# ou bien lancer l'execution en passant par ce Makefile:
#   > make exeIHM
exeGUI: testGUI
	java -classpath bin:bin/gui.jar TestGUI

exeBallsSimu: BallsSimu
	java -classpath bin:bin/gui.jar TestBallsSimulator

exeCellsSimu: CellsSimu
	java -classpath bin:bin/gui.jar TestCellsSimulator

exeBallsSimu1: BallsSimu1 
	java -classpath bin:bin/gui.jar TestBallsSimulator1

exeBalls: Balls
	java -classpath bin:bin/gui.jar TestBalls

exeGUI1: testGUI1
	java -classpath bin:bin/gui.jar TestGUI1

clean:
	rm -rf bin/*.class

