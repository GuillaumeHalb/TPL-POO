import gui.GUISimulator;
import java.awt.Color;

public class TestCells_ImmiSimulator {
    public static void main(String[] args) {
	//GUISimulator gui = new GUISimulator(500, 500, Color.WHITE);
	
	CelluleSimulator C = new Cellule_ImmiSimulator(50,50,10);
        C.getCells().reInit();
	C.getGUI().setSimulable(C);
    }
}
