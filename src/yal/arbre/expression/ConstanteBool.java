package yal.arbre.expression ;

import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {

	private final String TRUE  = "vrai" ;
	private final String FALSE = "faux" ;

    public ConstanteBool(String texte, int n) {
        super(texte, n) ;
    }

    private int eval (String bool_expr) {
    	return bool_expr.equals(TRUE) ? 1
									  : 0 ;
	}

	@Override
	public void verifier() {
		if (!cste.equals(TRUE) && !cste.equals(FALSE)) {
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
    	int bool_expr = eval(cste) ;

		return "# Chargement de la constante " + bool_expr + "\n" +
				"li $v0, " + bool_expr ;
	}

	@Override
	public String getType() {
		return "boolean";
	}

}
