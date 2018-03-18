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
		return SYM_DIFF;
	}

	@Override
	public String toMIPS() {
		return String.join (
				"\n",
				"\t# Operation !=",
				gauche.toMIPS(),
				"\tsw $v0, ($sp)",
				"\taddi $sp, $sp -4",
				droite.toMIPS(),
				"\taddi $sp, $sp, +4",
				"\tlw $t8, ($sp)",
				"\t#vérifie si v0 != t8",
				"\tbne $v0, $t8, " + et.getNextSiNonNeg(),
				"\tj " + et.getNextSiNeg(),
				et.getSiNeg() + ":",
				"\tli $v0, 1",
				"\tj " + et.getNextFinSiNeg(),
				et.getSiNonNeg() + ":",
				"\tli $v0, 0",
				et.getFinSiNeg() + ":"
		) ;
	}

	@Override
	public String getType() {
		return TYPE_BOOLEAN;
	}

}
