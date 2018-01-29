package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Superieur extends Comparaison {

	public Superieur(Expression gauche, Expression droite) {
		super(gauche, droite);
	}

	@Override
	public String operateur() {
		return " > ";
	}

	@Override
	public String toMIPS() {
			return null;		
	}


	@Override
	public String getType() {
		return "superieur";
	}

}
