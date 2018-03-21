package yal.arbre.expression;

import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
	public void verifier() {
		gauche.verifier();
		droite.verifier();
		if((gauche.getType() != TYPE_ENTIER && gauche.getType() != TYPE_IDF)|| (droite.getType() != TYPE_ENTIER && droite.getType() != TYPE_IDF)) {
			String s = operateur() + " entre un " + gauche.getType() + " et un " + droite.getType();
			ListeSemantiqueException.getInstance().addException(new SemantiqueException(noLigne,s));
		}
	}
}
