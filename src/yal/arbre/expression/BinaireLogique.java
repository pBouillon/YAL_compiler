package yal.arbre.expression;

import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;

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
		gauche.verifier();
		droite.verifier();
		if(gauche.getType() != TYPE_BOOLEAN || droite.getType() != TYPE_BOOLEAN) {
			String s = operateur() + " entre un " + gauche.getType() + " et un " + droite.getType();
			ListeSemantiqueException.getInstance().addException(new SemantiqueException(noLigne,s));
		}

	} 
}
