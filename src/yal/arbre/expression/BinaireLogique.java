package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireLogique extends Binaire {

	protected BinaireLogique(Expression gauche, Expression droite) {
		super(gauche, droite) ;
	}

	public void verifier() {
		if(gauche.getType() != "boolean" || droite.getType() != "boolean") {
		}
		System.out.println("ERREUR SEMANTIQUE: " + this.getType() + " entre un " + gauche.getType() + " et un " + droite.getType());
	} 
}
