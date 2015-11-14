import gui.GUISimulator;
import java.awt.Color;
import java.util.Scanner;
import java.util.*;

public class TestBoids {
    public static void main(String[] args) {
	System.out.println("Combien d'agents souhaitez vous simuler?");
	Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez saisir un entier :");
	String str = sc.nextLine();
	int nb_agents = Integer.parseInt(str);
	int largeur = nb_agents *25;
	EssaimSimulator E = new EssaimSimulator(largeur,largeur,60,20,nb_agents);
	E.getGUI().setSimulable(E);
    }
}
