package yal.exceptions;

import java.util.ArrayList;

public class ListeSemantiqueException {
	private boolean error = false;
	private  ArrayList<RuntimeException> listeException;

	/** Constructeur privé */
	private ListeSemantiqueException()
	{
		this.listeException = new ArrayList<>();
	}
	
	/** Instance unique pré-initialisée */
	private static ListeSemantiqueException INSTANCE = new ListeSemantiqueException();

	/** Point d'accès pour l'instance unique du singleton */
	public static ListeSemantiqueException getInstance()
	{   return INSTANCE;
	}

	public void addException(RuntimeException e) {
		this.error = true ;
		this.listeException.add(e) ;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public ArrayList<RuntimeException> getListeException() {
		return listeException;
	}

	public void setListeException(ArrayList<RuntimeException> listeException) {
		this.listeException = listeException;
	}
	
	
}
