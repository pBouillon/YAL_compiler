package yal.arbre.expression;

import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {

	public MoinsUnaire(Expression expr) {
		super(expr);
	}

	@Override
	public String operateur() {
		return "- " ;
	}

	@Override
	public void verifier() {
		expression.verifier();
		if(expression.getType() != "int") {
			String s =  operateur() + " avec un " + expression.getType();
			ListeSemantiqueException.getInstance().addException(new SemantiqueException(noLigne,s));
		}
	}

	@Override
	public String toMIPS() {
			return 	"li $v0, 0 \n" +  "\n" +
					"sw $v0, ($sp) \n" +
					expression.toMIPS()	+
					"lw $t8, ($sp) \n" +
					"sub $v0, $t8, $v0\n" ;
	}

	@Override
	public String getType() {
		return "int";
	}

}
