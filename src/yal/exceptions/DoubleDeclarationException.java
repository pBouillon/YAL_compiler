package yal.exceptions;

public class DoubleDeclarationException extends RuntimeException {
    
    public DoubleDeclarationException(int ligne, String m) {
    	super("ERREUR TDS :\n\tligne " + ligne + "\n\t" + m + " : variable déjà déclarée") ;
    }
}
