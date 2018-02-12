package yal.tabledessymboles;

import java.util.HashMap;

public class TDS {
	private HashMap<Entree,Symbole> map;
	private int compteur;

    private TDS()
    {
    	this.map = new HashMap<>();
    	compteur = 0 ;
    }
 
    private static TDS INSTANCE = new TDS();
    
    public static TDS getInstance() {
        return INSTANCE;
    }

    public void ajouter(Entree e,Symbole s) { // throws doubleDeclarationException
    	this.map.put(e,s);
    }

    public Symbole identifier(Entree e) { // throws VariableUndefinedException
    	return this.map.get(e);
    }

	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

}
