package application.automate;

import java.util.ArrayList;

public class Etat {
	private boolean initial, terminal;
	private int numero;
	private ArrayList<Transition> transition_entrantes,transition_sortantes;
	private ArrayList<Etat> predecceseur;
	private boolean acceptant;
	
	public Etat(int numero, boolean initial, boolean terminal) {
		this.setTerminal(terminal);
		this.setInitial(initial);
		this.setNumero(numero);
		this.transition_entrantes=new ArrayList<Transition>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isInitial() {
		return initial;
	}

	public void setInitial(boolean initial) {
		this.initial = initial;
	}

	public boolean isTerminal() {
		return terminal;
	}

	public void setTerminal(boolean terminal) {
		this.terminal = terminal;
	}
	
	public ArrayList<Transition> getTransition_entrantes(){
		
		return transition_entrantes;
	}

	public ArrayList<Etat> getPredecceseur() {
		return predecceseur;
	}

	public void setPredecceseur(ArrayList<Etat> predecceseur) {
		this.predecceseur = predecceseur;
	}

	public ArrayList<Transition> getTransition_sortantes() {
		return transition_sortantes;
	}

	public void setTransition_sortantes(ArrayList<Transition> transition_sortantes) {
		this.transition_sortantes = transition_sortantes;
	}

	public boolean isAcceptant() {
		return acceptant;
	}

	public void setAcceptant(boolean acceptant) {
		this.acceptant = acceptant;
	}
	
	
}
