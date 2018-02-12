package yal.tabledessymboles;

import java.util.HashMap;

public class TableDesSymboles {
	private HashMap<Entree,Symbole> map;
	private int compteur;
	/** Constructeur privé */
    private TableDesSymboles()
    {
    	this.map = new HashMap<>();
    	compteur = 0 ;
    }
 
    /** Instance unique pré-initialisée */
    private static TableDesSymboles INSTANCE = new TableDesSymboles();
    
    /** Point d'accès pour l'instance unique du singleton */
    public static TableDesSymboles getInstance() {
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
