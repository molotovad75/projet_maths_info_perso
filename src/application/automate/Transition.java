package application.automate;



public class Transition {
	private static String symbole_alphabet[]=new String[Automate.getNb_lettre_alphabet()];
	private Sens_transition sens;
	
	public Transition(String [] symbole_alphabet) {
		Transition.symbole_alphabet=symbole_alphabet;
	}
	
	public String [] getSymbole_alphabet() {
		return symbole_alphabet;
	}
	public static String [] getSymbole_alphabet_static() {
		return symbole_alphabet;
	}
	
	public static void setSymbole_alphabet(String[] symbole_alphabet) {
		Transition.symbole_alphabet=symbole_alphabet;
	}
	
	public Sens_transition getSens() {
		return this.sens;
	}
	
//	public ArrayList<String> conversion_char_liste(){
//		ArrayList<char> symbole_alphabet=new ArrayList<String>();
//		for (int i = 0; i < Automate.nb_lettre_alphabet; i++) {
//			symbole_alphabet.add(symbole_alphabet[i]);
//		}
//	}
}
