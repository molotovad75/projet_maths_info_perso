package application.automate;

import java.io.BufferedReader;
import java.util.ArrayList;

public class Automate {
	private static final int nb_lettre_alphabet=3;
	private ArrayList<Etat> liste_etat;
	private ArrayList<String> liste_mots_reconnus;
	private ArrayList<Etat> etat_acceptant;
	
	private boolean deterministe,complet;
	
	//Il faut savoir comment repr�senter une table des transitions
	//Constructeur de test
	public Automate(boolean deterministe, boolean complet) {
		this.deterministe=deterministe;
		this.complet=complet;
		liste_etat=new ArrayList<Etat>();
		liste_mots_reconnus=new ArrayList<String>();
		
	}
	
	//constructeur par d�faut d'un automate
	public Automate() {
		this.deterministe=false;
		this.complet=false;
		liste_etat=new ArrayList<Etat>();
		liste_mots_reconnus=new ArrayList<String>();
		
	}
	
	public static int getNb_lettre_alphabet() {
		return nb_lettre_alphabet;
	}
	
	//1 �re partie
	
	public void lecture_automate(BufferedReader file) {
		
	}
	
	//**********************************************************************************************

	//2 �me partie
	
	public String [][] affichage_automate() {
		String tab[][]=new String[liste_etat.size()][nb_lettre_alphabet];
		for (int j = 0; j < nb_lettre_alphabet; j++) {
			// i est inf�rieur � la taille de la liste d'�tats et t est inf�rieur aux nombres de transitions entrantes dans notre �tat acceptant pour un �tat � l'indice i.
			for (int i = 0, i2=0; i < liste_etat.size() && i2< etat_acceptant.size() ; i++, i2++) {
				for (int t=0; t<liste_etat.get(i).getTransition_entrantes().size(); t++) {
					if(liste_etat.get(i).getTransition_entrantes().get(t).getSymbole_alphabet()==etat_acceptant.get(i2).getTransition_entrantes().get(t).getSymbole_alphabet() && liste_etat.get(i).getTransition_entrantes().get(t).getSymbole_alphabet()[j]==Transition.getSymbole_alphabet_static()[j]) {
						tab[i][j]="Etat :"+i+"\n Lettre de l'alphabet : "+ Transition.getSymbole_alphabet_static()[j]+" Etat acceptant : "+ etat_acceptant.get(i2).getNumero();
						//Trouver un moyen de faire apparaitre tous les �tats acceptants.
					}
				}
			}
		}
		return tab;
		
	}
	
	
	
	//**********************************************************************************************

	//3 �me partie
	
	public boolean isDeterministe() {
		
	}
	
	public boolean isComplet() {
		
	}
	
	//**********************************************************************************************
	
	//4 �me partie
	
	public ArrayList<String> reconnaissance_mots(){
		
	}
	//**********************************************************************************************
	
	//5�me partie
	
	public Etat ajouter_etat(Etat e) {
		for (int i = 0; i < liste_etat.size(); i++) {
			if(!liste_etat.contains(liste_etat.get(i))) {
				e.setNumero(i);
			}
		}
		liste_etat.add(e);
		return e;
	}
	
	public String sans_mot_vide() {
		
	}
	
	
	//**********************************************************************************************
	

}
