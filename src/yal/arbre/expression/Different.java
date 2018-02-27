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
		return String.join (
				"\n",
				"\t# Operation !=",
				gauche.toMIPS(),
				"\tsw $v0, ($sp)",
				"\taddi $sp, $sp -4",
				droite.toMIPS(),
				"\taddi $sp, $sp, +4",
				"\tlw $t8, ($sp)",
				"\tsub $v0, $t8, $v0",
				"\tvérifie si v0 != t8",
				"\tbne $v0, $v8, " + et.getNextSiEg(),
				"\tj " + et.getSiNonNeg(),
				et.getSiEg() + ":",
				"\tli $v0, 1",
				"\tj " + et.getFinSiEg(),
				et.getSiNonEg() + ":",
				"\tli $v0, 0",
				et.getFinSiEg() + ":"
		) ;
	}

	@Override
	public String getType() {
		return TYPE_BOOLEAN;
	}

}
