package application.automate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Automate {
	private static final int nb_lettre_alphabet=3;
	private ArrayList<Etat> liste_etat;
	private ArrayList<String> liste_mots_reconnus;
	private ArrayList<Etat> etat_acceptant; //L'état acceptant est simplement l'état qui accepte la transition équipé d'un ou plusieurs symboles de l'alphabet
	
	private boolean deterministe,complet,standard;
	
	//Il faut savoir comment représenter une table des transitions
	//Constructeur de test
	public Automate(boolean deterministe, boolean complet) {
		this.deterministe=deterministe;
		this.complet=complet;
		liste_etat=new ArrayList<Etat>();
		liste_mots_reconnus=new ArrayList<String>();
		etat_acceptant=new ArrayList<Etat>();
	}
	
	//constructeur par défaut d'un automate
	public Automate() {
		this.deterministe=false;
		this.complet=false;
		liste_etat=new ArrayList<Etat>();
		liste_mots_reconnus=new ArrayList<String>();
		etat_acceptant=new ArrayList<Etat>();
	}
	
	public static int getNb_lettre_alphabet() {
		return nb_lettre_alphabet;
	}
	
	//1 ère partie
	
	public void lecture_automate(File file) {
		try {
			FileReader fr=new FileReader(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//**********************************************************************************************

	//2 ème partie
	
	public String [][] affichage_automate() {
		String tab[][]=new String[liste_etat.size()][nb_lettre_alphabet];
		for (int j = 0; j < nb_lettre_alphabet; j++) {
			
			for (int i = 0, i2=0; i < liste_etat.size() && i2< etat_acceptant.size() ; i++, i2++) {// i est inférieur à la taille de la liste d'états et t est inférieur aux nombres de transitions entrantes dans notre état acceptant pour un état à l'indice i.
				for (int t=0, t2=0; t<liste_etat.get(i).getTransition_sortantes().size() && t<etat_acceptant.get(i2).getTransition_entrantes().size(); t++, t2++) {
					//Dans le if on vérifie que l'alphabet pour une transition qui part de un état (liste_etat) est égale à l'alphabet arrivant à l'état acceptant avec cette même transition
					if(liste_etat.get(i).getTransition_sortantes().get(t).getSymbole_alphabet()==etat_acceptant.get(i2).getTransition_entrantes().get(t2).getSymbole_alphabet() && liste_etat.get(i).getTransition_sortantes().get(t).getSymbole_alphabet()[j]==Transition.getSymbole_alphabet_static()[j]) {
						tab[i][j]="Etat :"+i+"\n Lettre de l'alphabet : "+ Transition.getSymbole_alphabet_static()[j]+" Etat acceptant : "+ etat_acceptant.get(i2).getNumero()+"\n";
						//Trouver un moyen de faire apparaitre tous les états acceptants.
					}
				}
			}
		}
		return tab;
		
	}
	
	
	
	//**********************************************************************************************

	//3 ème partie
	
	public boolean isDeterministe() {
		//Au plus 1 état initial
		boolean foutu = false;
		
		int compteur=0;
		for (Etat etat : liste_etat) {
			if(etat.isInitial()==true && compteur>0) {
				this.deterministe=false;
				compteur++;
			}else if(etat.isInitial()==true && compteur==0 ) {
				compteur++;
			}else if(etat.isInitial()==false && liste_etat.get(liste_etat.size()-1).isInitial()==false && compteur<=1) {
				//Analyser les transitions qui sortent de chaque état. Il faut au maximum 1 transition sortante avec une même lettre de l'alphabet
				for (int i = 0, tran=0, j=0 ; i < liste_etat.size() && tran < liste_etat.get(i).getTransition_sortantes().size() && j<nb_lettre_alphabet; i++, tran++, j++) {
					 //Pour chaque transition de chaque état on vérifie qu'il n'y a pas plus de 1 transition sortantes avec le même symbole
						if (liste_etat.get(i).getTransition_sortantes().get(tran).getSymbole_alphabet()[j]==liste_etat.get(i).getTransition_sortantes().get(tran-1).getSymbole_alphabet()[j] && tran>0) {
							this.deterministe=false;
							foutu=true;
							j=0;
						}else if(liste_etat.get(i).getTransition_sortantes().get(tran).getSymbole_alphabet()[j]!=liste_etat.get(i).getTransition_sortantes().get(tran-1).getSymbole_alphabet()[j] && tran>0) {
							
							if(tran==liste_etat.get(i).getTransition_sortantes().size()-1 && foutu==false) {
								this.deterministe=true;
							}else if(tran!=liste_etat.get(i).getTransition_sortantes().size()-1) {
								j=0;
							}
							
						}//liste_etat.get(i).getTransition_sortantes().get(tran).getSymbole_alphabet()[j]==liste_etat.get(i).getTransition_sortantes().get(tran-1).getSymbole_alphabet()[j] && tran>0
				}//Fin For
			}//FIN ELSE IF QUAND au plus 1 état est initial parmis tout le reste qui ne le sont pas.
		}//Fin for each
		return this.deterministe;
	}
	
	public boolean isComplet() {
		for (Etat etat : liste_etat) {
			for (int i = 0; i < etat.getTransition_sortantes().size(); i++) {
				if(etat.getTransition_sortantes().get(i)==null) {
					this.complet=false;
				}else if(etat.getTransition_sortantes().get(i)!=null && i==etat.getTransition_sortantes().size()-1) {
					this.complet=true;
				}
			}
		}
		return this.complet;
	}
	
	public boolean standardisation() {
		Etat i;
		
	}
	
	//**********************************************************************************************
	
	//4 ème partie
	
	public ArrayList<String> reconnaissance_mots(){
		
	}
	//**********************************************************************************************
	
	//5ème partie
	
	public Etat ajouter_etat(Etat e, boolean acceptant) {
		e.setAcceptant(acceptant);
		for (int i = 0; i < liste_etat.size(); i++) {
			if(!liste_etat.contains(liste_etat.get(i))) {
				e.setNumero(i);
				if(i==0) {
					e.setInitial(true); //Par défaut l'état ayant le numéro 0 est l'état initial.
				}
			}
		}
		liste_etat.add(e);
		if(acceptant==true) {
			for (int i = 0; i < etat_acceptant.size(); i++) {
				if(!etat_acceptant.contains(etat_acceptant.get(i)) ) {
					e.setNumero(i);
				}
			}
			etat_acceptant.add(e);
		}
		return e;
	}
	
	public String sans_mot_vide() {
		
	}
	
	
	//**********************************************************************************************
	

}
