import gui.GUISimulator;
import java.awt.Color;

public class TestCellsSimulator {
    public static void main(String[] args) {
	//GUISimulator gui = new GUISimulator(500, 500, Color.WHITE);
	
	CelluleSimulator C = new CelluleSimulator(50,50,2);
    C.getCells().reInit();
	C.getGUI().setSimulable(C);
    }
}