package yal.tabledessymboles;

import java.util.HashMap;

import yal.exceptions.DoubleDeclarationException;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;
import yal.exceptions.VariableUndefinedException;

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

	public void ajouter(Entree e,Symbole s, int ligne) throws DoubleDeclarationException { 
		if(this.map.containsKey(e)) {
			ListeSemantiqueException.getInstance().addException(new DoubleDeclarationException(ligne, "variable : " + e.getIdentifier()));
		}else {
			this.map.put(e,s);
			System.out.println("ajout dans la TDS : " + e);
		}
	}

	public Symbole identifier(Entree e, int ligne){ 
		if(this.map.containsKey(new Entree(e.getIdentifier()))) {
			ListeSemantiqueException.getInstance().addException(new VariableUndefinedException(ligne, "variable : " + e.getIdentifier()));
			return null;
		}else {
			return this.map.get(e);
		}
	}

	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}


}
