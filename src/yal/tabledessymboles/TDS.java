package yal.tabledessymboles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import yal.exceptions.DoubleDeclarationException;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.VariableUndefinedException;

public class TDS {
	private HashMap<Entree,Symbole> map;
	private int compteur;
	private ArrayList<TDS> tds;
	private int compteurBloc; // permet de connaitre le numero du bloc 
	private boolean func = false;
	
	private TDS()
	{
		this.map = new HashMap<>();
		compteur = 0 ;
		compteurBloc = 0;
		this.tds = new ArrayList<>();
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
			if(e.getIdentifier().contains("func")) {
				func = true;
			}
		}
	}

	public Symbole identifier(String e, int ligne){ 
		// partir de la TDS de la fonction puis appeler la mere
		boolean trouve = false;
		Symbole res = null;

		for (Entry<Entree, Symbole> entry : map.entrySet())
		{
			if(entry.getKey().getIdentifier().equals(e) ) {						
				res = entry.getValue(); 
				trouve = true;
			}
		}
		if(!trouve) {
			ListeSemantiqueException.getInstance().addException(new VariableUndefinedException(ligne, "variable : " + e));
			return null;
		}else {
			return res;
		}
	}

	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	public ArrayList<TDS> getTds() {
		return tds;
	}

	public void setTds(ArrayList<TDS> tds) {
		this.tds = tds;
	}

	public int getNextCompteurBloc(){
		compteurBloc++;
		return compteurBloc;
	}

	public boolean containsFunc() {
		return func;
	}
	
	

}
