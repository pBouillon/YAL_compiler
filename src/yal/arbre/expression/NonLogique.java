package yal.arbre.expression;

import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {

	public NonLogique(Expression expr) {
		super(expr);
	}

	@Override
	public String operateur() {
		return " non " ;
	}

	@Override
	public void verifier() {
		expression.verifier();
		if(expression.getType() != "boolean" ) {
			String s =  operateur() + " avec un " + expression.getType();
			ListeSemantiqueException.getInstance().addException(new SemantiqueException(noLigne,s));
		}
	}

	@Override
	public String toMIPS() {
			return null;
	}


	@Override
	public String getType() {
		return "boolean";
	}

}
