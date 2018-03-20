package yal.exceptions;

public class ReturnManquantException extends RuntimeException {

    public ReturnManquantException(int ligne, String m) {
        super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t" + m + " : Return manquant") ;
    }
}
