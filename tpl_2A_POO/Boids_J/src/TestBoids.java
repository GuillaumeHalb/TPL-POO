import gui.GUISimulator;
import java.awt.Color;
import java.util.Scanner;
import java.util.*;

public class TestBoids {
    public static void main(String[] args) {
	System.out.println("Combien de boids souhaitez vous simuler?");
	Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez saisir un entier :");
	String str = sc.nextLine();
	int nb_boids = Integer.parseInt(str);
	System.out.println("Entrez également la taille de la boite:");
	System.out.println("Largeur :");
        str = sc.nextLine();
	int largeur = Integer.parseInt(str);
	System.out.println("Hauteur :");
        str = sc.nextLine();
	int hauteur = Integer.parseInt(str);
	EssaimSimulator E = new EssaimSimulator(largeur,hauteur,60,20,nb_boids);
	E.getGUI().setSimulable(E);
    }
}
