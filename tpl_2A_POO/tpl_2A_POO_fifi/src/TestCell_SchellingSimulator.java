import gui.GUISimulator;
import java.awt.Color;
import java.util.Scanner;
import java.util.*;

public class TestCell_SchellingSimulator {
    public static void main(String[]  args) {
	
		System.out.println("Combien de couleurs souhaitez vous simuler?");
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un entier :");
		String str = sc.nextLine();
		int nb_couleurs = Integer.parseInt(str);
		
		System.out.println("Quel seuil choississez vous pour la simulation?");
		Scanner scc = new Scanner(System.in);
		System.out.println("Veuillez saisir un entier :");
		String strr = scc.nextLine();
		int seuil = Integer.parseInt(strr);


		CelluleSimulator C = new Cellule_SchellingSimulator(50,50, nb_couleurs, seuil);
	        C.getCells().reInit();
		C.getGUI().setSimulable(C);
    }
}
