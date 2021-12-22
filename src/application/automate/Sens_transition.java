package application.automate;

public enum Sens_transition {
	etat_PG_etat_PP, //etat avec un numéro plus grand vers un etat ayant un numéro plus petit
	etat_PP_etat_PG, //etat avec un numéro plus petit vers un etat ayant un plus gros numéro
	etat_sur_etat //Transition qui boucle sur un même état
}
