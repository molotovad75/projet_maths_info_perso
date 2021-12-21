package application.automate;

import java.util.ArrayList;

public class Automate {
	private ArrayList<Etat> liste_etat;
	private ArrayList<Transition> liste_etat_transition;
	private boolean deterministe,complet;
	
	public Automate() {
		this.deterministe=false;
		this.complet=false;
		liste_etat=new ArrayList<Etat>();
	}
	
	public Etat ajouter_etat(Etat e) {
		liste_etat.add(e);
		
		return e;
	}
	

}
