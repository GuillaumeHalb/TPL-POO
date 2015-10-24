import java.awt.Color; 
import gui.GUISimulator; 
import gui.Oval ;

public class TestBallsSimulator1 {
    public static void main(String[] args) {

	BallsSimulator sim = new BallsSimulator(500,500,9);

	for (int i = 0; i < sim.getBalls().getDim(); i++) {
	    gui.addGraphicalElement(
			new Oval((int) sim.getBalls().getBalle(i).getX(),
				      (int) sim.getBalls().getBalle(i).getY(),
				      new Color(50 + 50*i, 50 + 50*i, 50 + 50*i),
				      new Color(50 + 50*i, 50 + 50*i, 50 + 50*i),
				      15
				      )
				    );
	}
    }
}
