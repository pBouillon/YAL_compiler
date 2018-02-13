package yal.exceptions;

public class VariableUndefinedException extends RuntimeException {
    
    public VariableUndefinedException(int ligne, String m) {
    	super("ERREUR TDS :\n\tligne " + ligne + "\n\t" + m + " : variable jamais déclarée") ;
    }
}
