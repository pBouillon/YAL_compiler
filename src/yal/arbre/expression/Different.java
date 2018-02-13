package yal.arbre.expression;

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
				"# vérifie si v0 != t8\n" +
				"bne $v0, $t8, siEq\n" +
				"j siNonEq\n" +
				"siEq:\n" +
				"li $v0, 1\n" +
				"j finSiEq\n" +
				"siNonEq:\n" +
				"li $v0, 0\n" +
				"finSiEq:\n";
	}

	@Override
	public String getType() {
		return "boolean";
	}

}
