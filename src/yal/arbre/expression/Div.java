package yal.arbre.expression;

import yal.DataFactory;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Div extends BinaireArithmetique {

	public Div(Expression gauche, Expression droite) {
		super(gauche, droite);
	}

	@Override
	public String operateur() {
		return SYM_DIV ;
	}

	@Override
	public String toMIPS() {
		return String.join(
			"\n",
				"\t# Division",
				gauche.toMIPS(),
				"\tsw $v0, ($sp)",
				"\taddi $sp, $sp, -4",
				droite.toMIPS(),
				"\tbnez $v0, " + et.getNextSi(),
				"\tj " + et.getNextSinon(),
				et.getSinon() + ":",
				"\tla $a0, "+ DataFactory.getInstance().getErrDiv(),
				"\tli $v0, 4",
				"\tsyscall",
				"\tj end",
				et.getSi() + ":",
				"\taddi $sp, $sp, 4",
				"\tlw $t8, ($sp)",
				"\tdiv $v0, $t8, $v0",
				"\tsw $v0, ($sp)"
		) ;
	}
	
	@Override
	public String getType() {
		return "int";
	}

}
