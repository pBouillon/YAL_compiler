package yal.exceptions;

public class DoubleDeclarationException extends RuntimeException {
    
    public DoubleDeclarationException(int ligne, String m) {
    	super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t" + m + " : variable deja declaree") ;
    }
}
