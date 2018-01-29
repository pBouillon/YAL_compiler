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
		// TODO Auto-generated method stub

	}

	@Override
	public String toMIPS() {
		if(expression.getType() != "boolean" ) {
			return "ERREUR SEMANTIQUE: " + this.getType() + " avec un " + expression.getType() ;
		}else {
			return null;
		}
	}


	@Override
	public String getType() {
		return "non logique";
	}

}
