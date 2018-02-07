package yal.tabledessymboles;

import java.util.HashMap;

public class TableDesSymboles {
	private HashMap<Entree,Symbole> map;
	
	/** Constructeur privé */
    private TableDesSymboles()
    {
    	this.map = new HashMap<>();
    }
 
    /** Instance unique pré-initialisée */
    private static TableDesSymboles INSTANCE = new TableDesSymboles();
    
    /** Point d'accès pour l'instance unique du singleton */
    public static TableDesSymboles getInstance()
    {   return INSTANCE;
    }
    
    public void ajouter(Entree e,Symbole s) { // throws doubleDeclarationException
    	this.map.put(e,s);
    }
}
