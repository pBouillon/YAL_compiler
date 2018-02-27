package yal.arbre.expression;

import yal.EtiquetteFactory;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;

import java.util.Objects;

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
		if (!Objects.equals(expression.getType(), TYPE_BOOLEAN)) {
			String s =  operateur() + " avec un " + expression.getType();
			ListeSemantiqueException.getInstance()
					.addException (
							new SemantiqueException (
									noLigne,
									s
			));
		}
	}

	@Override
	public String toMIPS() {
		return String.join (
				"\n",
				"\t# non logique",
				"\tbgtz $v0, " + et.getNextSiEg(),
				"\tj, " + et.getNextSiNonEg(),
				et.getSiEg() + ":",
				"\tli $v0, 0",
				"\tj " + et.getNextFinSiEg(),
				et.getSiNonEg() + ":",
				"\tli $v0, 1",
				et.getFinSiEg()
		) ;
	}

	@Override
	public String getType() {
		return TYPE_BOOLEAN;
	}
}
