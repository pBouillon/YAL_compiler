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
		return SYM_UNARY_MIN ;
	}

	@Override
	public void verifier() {
		expression.verifier();
		if (!expression.getType().equals("int")) {
			ListeSemantiqueException
				.getInstance()
				.addException (
					new SemantiqueException (
						noLigne,
						operateur() + " avec un " + expression.getType()
					)
				) ;
		}
	}

	@Override
	public String toMIPS() {
		return String.join (
				"\n",
				"\t# moins unaire",
				"\tli $v0, 0",
				"\tsw $v0, ($sp)",
				expression.toMIPS(),
				"\tlw $t8, ($sp)",
				"\tsub $v0, $t8, $v0"
		) ;
	}

	@Override
	public String getType() {
		return TYPE_ENTIER ;
	}

}
