package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

	@Override
	public void verifier() {}

	@Override
	public String toMIPS() {
    	return String.join (
    			"\n",
				"\n\t# Evaluation d'une constante",
				"\tli $v0, " + cste
		) ;
	}

	@Override
	public String getType() {
		return TYPE_ENTIER;
	}

}
