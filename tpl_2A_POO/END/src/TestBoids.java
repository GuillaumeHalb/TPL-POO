import gui.GUISimulator;
import java.awt.Color;
import java.util.Scanner;
import java.util.*;

public class TestBoids {
    public static void main(String[] args) {
	System.out.println("Combien d'essaims souhaitez vous simuler?");
	Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez saisir un entier :");
	String str = sc.nextLine();
	int nb_essaims = Integer.parseInt(str);
	System.out.println("Combien d'agents souhaitez vous simuler?");
	int[] nb_agents= new int[nb_essaims];
	for(int i = 0; i<nb_essaims;i++){
	    System.out.println("Pour l'essaim "+(i+1) + " :");
	    str = sc.nextLine();
	    nb_agents[i] = Integer.parseInt(str);
	}
	System.out.println("Entrez la taille de l'écran :");
	str = sc.nextLine();
	int largeur = Integer.parseInt(str);
	EssaimSimulator E = new EssaimSimulator(largeur,largeur,60,20,nb_agents,nb_essaims);
	E.getGUI().setSimulable(E);
    }
}
