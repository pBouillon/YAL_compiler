package yal.arbre.expression;

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
		if(expression.getType() != "boolean" ) {
			System.out.println("ERREUR SEMANTIQUE: " + this.getType() + " avec un " + expression.getType()) ;
		}
	}

	@Override
	public String toMIPS() {
			return null;
	}


	@Override
	public String getType() {
		return "non logique";
	}

}
