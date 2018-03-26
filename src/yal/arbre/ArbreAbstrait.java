package yal.arbre;

import yal.ETQ;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class ArbreAbstrait {

    public static ETQ et = ETQ.getInstance() ;

    protected static String TYPE_BOOLEAN = "boolean" ;
    protected static String TYPE_ENTIER  = "int" ;
    protected static String TYPE_IDF     = "idf" ;

    protected static String SYM_AND  = " et " ;
    protected static String SYM_CSTE_BOOL_TRUE  = "vrai" ;
    protected static String SYM_CSTE_BOOL_FALSE = "faux" ;
    protected static String SYM_DIFF = " != " ;
    protected static String SYM_DIV  = " / "  ;
    protected static String SYM_EQU  = " == " ;
    protected static String SYM_INF  = " < "  ;
    protected static String SYM_MIN  = " - "  ;
    protected static String SYM_MULT = " * " ;
    protected static String SYM_OR   = " ou " ;
    protected static String SYM_PLUS = " + " ;
    protected static String SYM_UNARY_MIN  = "- "  ;
    protected static String SYM_UNARY_NEG  = " non "  ;
    protected static String SYM_SUP  = " + " ;


    // numéro de ligne du début de l'instruction
    protected int noLigne ;
    
    protected ArbreAbstrait(int no) {
        noLigne = no ;
    }
    
    public int getNoLigne() {
            return noLigne ;
    }

     public abstract void verifier() ;   
     public abstract String toMIPS() ;   

}
