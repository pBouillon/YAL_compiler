package yal.arbre.expression;

import yal.DataFactory;
import yal.EtiquetteFactory;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;

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
		return " / ";
	}

	@Override
	public String toMIPS() {
		EtiquetteFactory et = EtiquetteFactory.getInstance() ;

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
				"\tli $v0, 4",
				"la $a0, "+ DataFactory.getInstance().getErrDiv(),
				"j end",
				"syscall",
				et.getSi() + ":",
				"\taddi $sp, $sp, 4",
				"\tlw $t8, ($sp)",
				"\tdiv $v0, $t8, $v0",
				"\tsw $v0, ($sp)"
		) ;
/*
		StringBuilder s = new StringBuilder();
			s.append(gauche.toMIPS())
			.append("\n")
			.append("sw $v0, ($sp)\n")
			.append("addi $sp, $sp, -4\n")
			.append( droite.toMIPS() )
			.append("\n")
			.append("lw $t8, ($sp)\n")
			.append("beqz $v0,"+ EtiquetteFactory.getInstance().getNextSiNeg()+"\n")
			.append("j " + EtiquetteFactory.getInstance().getNextSiNonNeg() +"\n")
			.append(EtiquetteFactory.getInstance().getSiNeg()+ ":\n")
			.append("la $a0, "+ DataFactory.getInstance().getErrDiv()+" \n")
			.append("syscall \n")
			.append(EtiquetteFactory.getInstance().getSiNonNeg()+ ":\n")
			.append("div $t8, $v0")
			.append("\n")
			.append("mflo $v0 \n")
			.append("j " + EtiquetteFactory.getInstance().getNextFinSiNeg()+"\n")
			.append(EtiquetteFactory.getInstance().getFinSiNeg()+":\n");
			return s.toString();
*/
	}
	
	@Override
	public String getType() {
		return "int";
	}

}
