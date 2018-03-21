package yal.arbre.expression;

import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Comparaison extends Binaire {

	protected Comparaison(Expression gauche, Expression droite) {
		super(gauche, droite);
	}

	public void verifier() {
		gauche.verifier();
		droite.verifier();
		if(gauche.getType() != droite.getType()) {
			if(gauche.getType() == TYPE_IDF) {
				if(droite.getType() != TYPE_ENTIER) {
					String s =  operateur() + " entre un " + gauche.getType() + " et un " + droite.getType();
					ListeSemantiqueException.getInstance().addException(new SemantiqueException(noLigne,s));
				}
			}else 
				if(droite.getType() == TYPE_IDF) { 
					if(gauche.getType() != TYPE_ENTIER) {
						String s =  operateur() + " entre un " + gauche.getType() + " et un " + droite.getType();
						ListeSemantiqueException.getInstance().addException(new SemantiqueException(noLigne,s));

					} 
				}

		}
	}

}
