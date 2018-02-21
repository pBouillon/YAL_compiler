package yal.exceptions;

public class VariableUndefinedException extends RuntimeException {
    
    public VariableUndefinedException(int ligne, String m) {
    	super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t" + m + " : variable jamais déclarée") ;
    }
}
