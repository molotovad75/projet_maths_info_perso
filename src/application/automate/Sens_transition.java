package application.automate;

public enum Sens_transition {
	etat_PG_etat_PP, //etat avec un num�ro plus grand vers un etat ayant un num�ro plus petit
	etat_PP_etat_PG, //etat avec un num�ro plus petit vers un etat ayant un plus gros num�ro
	etat_sur_etat //Transition qui boucle sur un m�me �tat
}
