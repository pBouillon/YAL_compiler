package yal.exceptions;

public class SemantiqueException extends RuntimeException {
    
    public SemantiqueException(int ligne, String m) {
    	super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t" + m) ;
    }
}
