package yal.arbre.expression ;

import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {

    public ConstanteBool(String texte, int n) {
        super(texte, n) ;
    }

    private int eval (String bool_expr) {
    	return bool_expr.equals(SYM_CSTE_BOOL_TRUE) ? 1
									  				 : 0 ;
	}

	@Override
	public void verifier() {
		if (!cste.equals(SYM_CSTE_BOOL_TRUE)
				&& !cste.equals(SYM_CSTE_BOOL_FALSE)) {
			ListeSemantiqueException
				.getInstance()
				.addException (
					new SemantiqueException (
							noLigne,
							cste + ": Symbole non reconnu"
					)
				) ;
		}
	}

	@Override
	public String toMIPS() {
    	return String.join(
    			"\n# chargement de la constante " + eval(cste),
				"\tli $v0, " + eval(cste)
		) ;
	}

	@Override
	public String getType() {
		return TYPE_BOOLEAN;
	}

}
