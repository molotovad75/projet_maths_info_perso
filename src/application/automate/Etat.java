package application.automate;

import java.util.ArrayList;

public class Etat {
	private boolean initial, terminal;
	private int numero;
	private ArrayList<Transition> transition;
	private ArrayList<Etat> predecceseur;
	
	public Etat(int numero, boolean initial, boolean terminal) {
		this.setTerminal(terminal);
		this.setInitial(initial);
		this.setNumero(numero);
		this.transition=new ArrayList<Transition>();
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
	
	public ArrayList<Transition> getTransition(){
		
		return transition;
	}

	public ArrayList<Etat> getPredecceseur() {
		return predecceseur;
	}

	public void setPredecceseur(ArrayList<Etat> predecceseur) {
		this.predecceseur = predecceseur;
	}
	
	
}
