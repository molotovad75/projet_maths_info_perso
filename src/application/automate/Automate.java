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
	private ArrayList<Etat> etat_acceptant; //L'�tat acceptant est simplement l'�tat qui accepte la transition �quip� d'un ou plusieurs symboles de l'alphabet
	
	private boolean deterministe,complet,standard;
	
	//Il faut savoir comment repr�senter une table des transitions
	//Constructeur de test
	public Automate(boolean deterministe, boolean complet) {
		this.deterministe=deterministe;
		this.complet=complet;
		liste_etat=new ArrayList<Etat>();
		liste_mots_reconnus=new ArrayList<String>();
		etat_acceptant=new ArrayList<Etat>();
	}
	
	//constructeur par d�faut d'un automate
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
	
	//1 �re partie
	
	public void lecture_automate(File file) {
		try {
			FileReader fr=new FileReader(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//**********************************************************************************************

	//2 �me partie
	
	public String [][] affichage_automate() {
		String tab[][]=new String[liste_etat.size()][nb_lettre_alphabet];
		for (int j = 0; j < nb_lettre_alphabet; j++) {
			
			for (int i = 0, i2=0; i < liste_etat.size() && i2< etat_acceptant.size() ; i++, i2++) {// i est inf�rieur � la taille de la liste d'�tats et t est inf�rieur aux nombres de transitions entrantes dans notre �tat acceptant pour un �tat � l'indice i.
				for (int t=0, t2=0; t<liste_etat.get(i).getTransition_sortantes().size() && t<etat_acceptant.get(i2).getTransition_entrantes().size(); t++, t2++) {
					//Dans le if on v�rifie que l'alphabet pour une transition qui part de un �tat (liste_etat) est �gale � l'alphabet arrivant � l'�tat acceptant avec cette m�me transition
					if(liste_etat.get(i).getTransition_sortantes().get(t).getSymbole_alphabet()==etat_acceptant.get(i2).getTransition_entrantes().get(t2).getSymbole_alphabet() && liste_etat.get(i).getTransition_sortantes().get(t).getSymbole_alphabet()[j]==Transition.getSymbole_alphabet_static()[j]) {
						tab[i][j]="Etat :"+i+"\n Lettre de l'alphabet : "+ Transition.getSymbole_alphabet_static()[j]+" Etat acceptant : "+ etat_acceptant.get(i2).getNumero()+"\n";
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
		//Au plus 1 �tat initial
		boolean foutu = false;
		
		int compteur=0;
		for (Etat etat : liste_etat) {
			if(etat.isInitial()==true && compteur>0) {
				this.deterministe=false;
				compteur++;
			}else if(etat.isInitial()==true && compteur==0 ) {
				compteur++;
			}else if(etat.isInitial()==false && liste_etat.get(liste_etat.size()-1).isInitial()==false && compteur<=1) {
				//Analyser les transitions qui sortent de chaque �tat. Il faut au maximum 1 transition sortante avec une m�me lettre de l'alphabet
				for (int i = 0, tran=0, j=0 ; i < liste_etat.size() && tran < liste_etat.get(i).getTransition_sortantes().size() && j<nb_lettre_alphabet; i++, tran++, j++) {
					 //Pour chaque transition de chaque �tat on v�rifie qu'il n'y a pas plus de 1 transition sortantes avec le m�me symbole
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
			}//FIN ELSE IF QUAND au plus 1 �tat est initial parmis tout le reste qui ne le sont pas.
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
	
	//4 �me partie
	
	public ArrayList<String> reconnaissance_mots(){
		
	}
	//**********************************************************************************************
	
	//5�me partie
	
	public Etat ajouter_etat(Etat e, boolean acceptant) {
		e.setAcceptant(acceptant);
		for (int i = 0; i < liste_etat.size(); i++) {
			if(!liste_etat.contains(liste_etat.get(i))) {
				e.setNumero(i);
				if(i==0) {
					e.setInitial(true); //Par d�faut l'�tat ayant le num�ro 0 est l'�tat initial.
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
