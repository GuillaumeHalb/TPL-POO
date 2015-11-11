import gui.GUISimulator;
import java.awt.Color;

public class TestBoids {
    public static void main(String[] args) {
	Integer taillex = 500;
	Integer tailley = 500;
	EssaimSimulator E = new EssaimSimulator(taillex,tailley,60,60);
	E.getGUI().setSimulable(E);
    }
}
