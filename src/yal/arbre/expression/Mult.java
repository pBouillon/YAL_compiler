package yal.arbre.expression;

import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Mult extends BinaireArithmetique {

	public Mult(Expression gauche, Expression droite) {
		super(gauche, droite);
	}

	@Override
	public String operateur() {
		return " * ";
	}    

	@Override
	public String toMIPS() {
		return String.join (
			"\n",
			"# evaluation operande gauche",
			gauche.toMIPS(),
			"\tsw $v0, ($sp) ",
			"\taddi $sp, $sp, -4",
			droite.toMIPS(),
			"\taddi $sp, $sp, 4",
			"\tlw $t8, ($sp)",
			"\tmult $v0, $t8",
			"\tmflo $v0",
			"\tsw $v0, ($sp)"
		) ;
	}
	
	@Override
	public String getType() {
		return TYPE_ENTIER ;
	}

}
