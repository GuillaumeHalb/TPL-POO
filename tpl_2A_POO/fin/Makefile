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

all: boids

BallsSimu:	
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestBallsSimulator.java

CellsVieSimu:	
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestCellsSimulator.java

BoidsSimu:	
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestBoids.java

CellsImmigSimu:	
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestCells_ImmigSimulator.java

CellsSchellingSimu:
	javac -d bin -classpath bin/gui.jar -sourcepath src src/TestCell_SchellingSimulator.java


# Execution:
# on peut taper directement la ligne de commande :
#   > java -classpath bin TestGUI
# ou bien lancer l'execution en passant par ce Makefile:
#   > make exeIHM

balls: BallsSimu
	java -classpath bin:bin/gui.jar TestBallsSimulator

boids: BoidsSimu
	java -classpath bin:bin/gui.jar TestBoids

vie: CellsVieSimu
	java -classpath bin:bin/gui.jar TestCellsSimulator

immigration: CellsImmigSimu
	java -classpath bin:bin/gui.jar TestCells_ImmigSimulator

schelling: CellsSchellingSimu
	java -classpath bin:bin/gui.jar TestCell_SchellingSimulator

clean:
	rm -rf bin/*.class
