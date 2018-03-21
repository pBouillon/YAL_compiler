package yal.exceptions;

/**
 * From YAL_compiler > yal.exceptions
 * Created on 21/03/2018
 */
public class BadAffectationException extends RuntimeException {

    public BadAffectationException(int ligne) {
        super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t=> Impossible d'affecter ces deux types") ;
    }
}