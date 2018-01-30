package yal.arbre.expression;

import yal.EtiquetteFactory;
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
			return  expression.toMIPS() + "\n" + 
					"bgtz $v0, "+EtiquetteFactory.getInstance().getNextSiEg()+"\n" +
					"j "+EtiquetteFactory.getInstance().getNextSiNonEg()+"\n" +
					EtiquetteFactory.getInstance().getSiEg()+":\n" +
					"li $v0, 0\n" +
					"j "+EtiquetteFactory.getInstance().getNextFinSiEg()+"\n" +
					EtiquetteFactory.getInstance().getSiNonEg()+":\n" +
					"li $v0, 1\n" +
					EtiquetteFactory.getInstance().getFinSiEg()+":\n";
	}


	@Override
	public String getType() {
		return "boolean";
	}

}
