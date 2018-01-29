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
		return gauche.toMIPS() +
				"sw $v0, ($sp)\n" +
				"addi $sp, $sp -4\n" +
				droite.toMIPS() +
				"addi $sp, $sp, +4\n" +
				"lw $t8, ($sp)\n" +
				"sub $v0, $t8, $v0\n" +
                "bgtz $v0, siSup\n" +
                "j sinonSup\n" +
                "siSup: \n" +
                "lw $v0, 1\n" +
                "j finSiSup\n" +
                "sinonSup:\n" +
                "lw $v0, 0\n" +
                "finSiSup:\n";
	}


	@Override
	public String getType() {
		return "boolean";
	}

}
