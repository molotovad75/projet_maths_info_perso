package application.automate;

public class Etat {
	private boolean initial, final_;
	private int numero;
	
	public Etat(int numero, boolean initial, boolean final_) {
		this.final_=final_;
		this.initial=initial;
		this.numero=numero;
	}
}
