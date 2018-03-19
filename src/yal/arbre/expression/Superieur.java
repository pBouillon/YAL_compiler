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
		return SYM_SUP ;
	}

	@Override
	public String toMIPS() {
		return String.join (
			"\n",
				"\t# superieur",
				gauche.toMIPS(),
				"\tsw $v0, ($sp)" ,
				"addi $sp, $sp -4\n" ,
				droite.toMIPS(),
				"\taddi $sp, $sp, +4",
				"\tlw $t8, ($sp)",
				"\tsub $v0, $t8, $v0",
				"\tbltz $v0, " + et.getNextSiInf(),
				"\tj " + et.getNextSiNonInf(),
				et.getSiInf() + ":",
				"\tli $v0, 1",
				"\tj " + et.getNextFinSiInf(),
				et.getSiNonInf() + ":",
				"\tli $v0, 0",
				et.getFinSiInf() + ":"
		) ;
	}

	@Override
	public String getType() {
		return TYPE_BOOLEAN ;
	}
}
