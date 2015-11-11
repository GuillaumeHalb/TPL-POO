import gui.GUISimulator;
import java.awt.Color;

public class TestBoids {
    public static void main(String[] args) {
	Integer taillex = 500;
	Integer tailley = 500;
	EssaimSimulator E = new EssaimSimulator(taillex,tailley,6,2);
        //C.getCells().reInit();
	for(int i=1;i<6;i++){
	    double x =  (Math.random() * taillex + 1.0);
	    double y =  (Math.random() * tailley + 1.0);
	    double x1 =  (Math.random());
	    double y1 =  (Math.random()); 
	    Pt Pos = new Pt(x,y);
	    Pt dir = new Pt(x1,y1);
	    Individu ind = new Individu (1,Pos,dir);
	    E.getEssaim().ajouteIndividu(ind);
	}
	E.getGUI().setSimulable(E);
    }
}
