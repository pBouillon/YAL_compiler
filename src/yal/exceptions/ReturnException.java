package yal.exceptions;

public class ReturnException extends RuntimeException {

    public ReturnException(int ligne) {
        super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t-> Aucun return attendu") ;
    }
}