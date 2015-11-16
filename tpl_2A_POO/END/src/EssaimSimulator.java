import gui.Simulable;
import gui.GUISimulator;
import gui.Rectangle;
import java.awt.Color;
import java.util.LinkedList;


public class EssaimSimulator extends Simulator {

    private int nb_essaims;
    private Essaim[] essaim;
    private int[] nb_agents;
    private LinkedList<Individu> allAgents;

    public EssaimSimulator(int taillex, int tailley,double d, Integer v_max,
			   int[] nb_agents, int nb_essaims) {
	super(taillex,tailley);
	this.nb_essaims = nb_essaims;
	this.essaim = new Essaim[nb_essaims];
	for (int i=0;i<nb_essaims;i++){
	    
	    if (i==0) { //Les prédateurs
		this.essaim[i] = new Essaim(d,v_max,Color.RED,
					    nb_agents[i]);
	    }
	    else {
	    this.essaim[i] = new Essaim(d,v_max,new Color(70*(i+1)%255,
							  255-(70*(i+1))%255,
							  200),
					nb_agents[i]);
	    }
	}
	this.nb_agents = nb_agents;
	this.allAgents = new LinkedList<Individu>();

    }

    public Essaim getEssaim(int i) {
	return this.essaim[i];
    }

    //Attaque des predateurs sur les autres
    public void SupprimeAgents(){
	Pt p = new Pt(0.0,0.0);
	int indice_fin = 1;
	LinkedList<Individu> aSupprimer = new LinkedList<Individu>();
	for(int ind_essaim = 1; ind_essaim<nb_essaims ; ind_essaim++){
	    // Pour chaque essaim non prédateur
	    
	    //On supprime les agents mangés
	    if (ind_essaim != 1)  {
		indice_fin = ind_essaim;
		for (Individu index : aSupprimer){
		    this.essaim[ind_essaim-1].getAgents().remove(index);
		}
	    }
	    //On ré-initialise la liste d'agents à supprimer
	    aSupprimer = new LinkedList<Individu>();
	    
	    for (Individu j :this.essaim[0].getAgents()){
		// Pour chaque predateur
		
		for ( Individu i : this.essaim[ind_essaim].getAgents() ) {
		    // Pour chaque proie
		    
		    if ((p.distance(i.position, j.position) < 5.0) &&
			!i.estEgal(i, j) ){ 
			// On ajoute i (mangé par j) à la liste à supprimer.
			int index = this.essaim[ind_essaim].getAgents().indexOf(i);
			aSupprimer.add(i);
			this.allAgents.remove(i);
		    }
		}
	    }
	}
	for (Individu index : aSupprimer){
		this.essaim[indice_fin].getAgents().remove(index);
	    }

    }
    
    @Override
    public void next() {
	gui.reset();
	gui.addGraphicalElement(new Rectangle(0,0,Color.RED,Color.WHITE,
					      2*taillex+10,2*tailley+10));
	this.eventMan.next();

	// Suppression des agents attaqués
	SupprimeAgents();
	// Ajout de "l'évènement" pour l'animation de la simulation
	for (int i=0;i<nb_essaims;i++){
	    long date = this.eventMan.getcurrentDate()+(i+1);
	    this.eventMan.addEvent(new EssaimEvent(date,
						   this.essaim[i],
						   taillex,tailley,
						   this.gui,
						   this.allAgents));
	}
    }
    
    @Override
    public void restart() {
	gui.addGraphicalElement(new Rectangle(0,0,Color.RED,Color.WHITE,
					      2*taillex+10,2*tailley+10));
	this.allAgents = new LinkedList<Individu>();
	for (int i=0;i<this.nb_essaims;i++){
	    this.essaim[i].reInit(taillex,tailley);
	    this.allAgents.addAll(this.essaim[i].getAgents());
	    this.essaim[i].Affiche(taillex,tailley,gui,this.allAgents);
	}

    }
}
