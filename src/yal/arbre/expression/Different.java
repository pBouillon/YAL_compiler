package yal.arbre.expression;

import yal.EtiquetteFactory;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Different extends Comparaison {

	public Different(Expression gauche, Expression droite) {
		super(gauche, droite);
	}

	@Override
	public String operateur() {
		return " != ";
	}

	@Override
	public String toMIPS() {
		return gauche.toMIPS() +
				"\n" +
				"sw $v0, ($sp)" +
				"\n" +
				"addi $sp, $sp -4" +
				"\n" +
				droite.toMIPS() +
				"\n" +
				"addi $sp, $sp, +4" +
				"\n" +
				"lw $t8, ($sp) " +
				"\n" +
				"sub $v0, $t8, $v0\n" +
				"# verifie si v0 != t8\n" +
				"beqz $v0,"+ EtiquetteFactory.getInstance().getNextSiNeg()+"\n" +
				"j "+EtiquetteFactory.getInstance().getNextSiNonNeg()+"\n" +
				EtiquetteFactory.getInstance().getSiNeg()+":\n" +
				"li $v0, 0\n" +
				"j "+EtiquetteFactory.getInstance().getNextFinSiNeg()+"\n" +
				EtiquetteFactory.getInstance().getSiNonNeg()+":\n" +
				"li $v0, 1\n" +
				EtiquetteFactory.getInstance().getFinSiNeg()+":\n";
	}

	@Override
	public String getType() {
		return "boolean";
	}

}
