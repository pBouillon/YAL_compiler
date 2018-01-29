package yal.exceptions;

public class SemantiqueException extends RuntimeException {
    
    protected SemantiqueException(int ligne, int colonne, String m) {
    	super("ERREUR LEXICALE :\n\tligne " + ligne + " colonne " + colonne + "\n\t" + m + " : caractère non reconnu") ;
    }
}
