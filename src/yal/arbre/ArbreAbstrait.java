package yal.arbre;

import yal.EtiquetteFactory;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class ArbreAbstrait {

    public static EtiquetteFactory et = EtiquetteFactory.getInstance() ;

    public static String TYPE_BOOLEAN = "boolean" ;
    public static String TYPE_ENTIER  = "int" ;
    public static String TYPE_IDF     = "idf" ;

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
