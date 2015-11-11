import gui.GUISimulator;
import java.awt.Color;

public class TestCells_ImmigSimulator {
    public static void main(String[]  args) {
	//GUISimulator gui = new GUISimulator(500, 500, Color.WHITE);
	
	CelluleSimulator C = new Cellule_ImmigSimulator(50,50,4);
        C.getCells().reInit();
	C.getGUI().setSimulable(C);
    }
}