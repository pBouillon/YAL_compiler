package yal.tabledessymboles;

public class Symbole {
	private int pointeur;
	
	/*
	 * Constructeur qui initialise le pointeur de la variable vers son espace memoire 
	 * */
	public Symbole() {
		 this.pointeur = TableDesSymboles.getInstance().getCompteur();
		 TableDesSymboles.getInstance().setCompteur(-4);
	}

}
