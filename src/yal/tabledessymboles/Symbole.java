package yal.tabledessymboles;

public class Symbole {
	private int pointeur;
	
	public int getPointeur() {
		return pointeur;
	}

	/*
	 * Constructeur qui initialise le pointeur de la variable vers son espace memoire 
	 * */
	public Symbole() {
		 this.pointeur = TDS.getInstance().getCompteur();
		 TDS.getInstance().setCompteur(TDS.getInstance().getCompteur()-4);
	}

}
