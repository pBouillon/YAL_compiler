package yal.arbre.expression;

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
		StringBuilder s = new StringBuilder();
			s.append(gauche.toMIPS())
			.append("\n")
			.append("sw $v0, ($sp)")
			.append("\n")
			.append( droite.toMIPS() )
			.append("\n")
			.append("lw $t8, ($sp) ")
			.append("\n")
			.append("beqz $v0,"+ EtiquetteFactory.getInstance().getNextSiNeg()+"\n")
			.append("j " + EtiquetteFactory.getInstance().getNextSiNonNeg() +"\n")
			.append(EtiquetteFactory.getInstance().getSiNeg()+ ":\n")
			.append("la $a0, errdiv \n")
			.append("syscall \n")
			.append(EtiquetteFactory.getInstance().getSiNonNeg()+ ":\n")
			.append("div $t8, $v0")
			.append("\n")
			.append("mflo $v0 \n")
			.append("j " + EtiquetteFactory.getInstance().getNextFinSiNeg()+"\n")
			.append(EtiquetteFactory.getInstance().getFinSiNeg()+":\n");
			return s.toString();
	}    
	
	@Override
	public String getType() {
		return "int";
	}

}
