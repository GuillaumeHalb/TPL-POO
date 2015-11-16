import gui.GUISimulator;


public class BallsEvent extends Event {
    private Balls balls;
    private int taillex;
    private int tailley;
    private GUISimulator gui;
    
    public BallsEvent (long date,
		       Balls balls,
		       int taillex, int tailley,
		       GUISimulator gui){
	super(date);
	this.balls = balls;
	this.taillex = taillex;
	this.tailley = tailley;
	this.gui = gui;
    }

    public Balls getBalles(){
	return this.balls;
    }

    @Override
    public void execute() {
        this.balls.translate(taillex,tailley,15);
	this.balls.Affiche(taillex,tailley,gui);
    }
}
