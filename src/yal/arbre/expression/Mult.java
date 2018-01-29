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
		StringBuilder s = new StringBuilder();
			s.append("# Evaluation de l'opérande gauche \n")
			.append(gauche.toMIPS())
			.append("\n")
			.append("# Stocke la valeur de v0 dans la mémoire \n")
			.append("sw $v0, ($sp)")
			.append("\n")
			.append("addi $sp, $sp, -4")
			.append("\n")
			.append("# Evaluation de l'opérande droite \n")
			.append( droite.toMIPS() )
			.append("\n")
			.append("# Recuperation de sp dans t8 \n")
			.append("addi $sp, $sp, 4")
			.append("\n")
			.append("lw $t8, ($sp) ")
			.append("\n")
			.append("# Multiplication de t8 par v0 \n")
			.append("mult $v0, $t8")
			.append("\n")
			.append("mflo $v0\n");
			return s.toString();
		}
	
	@Override
	public String getType() {
		return "int";
	}

}
