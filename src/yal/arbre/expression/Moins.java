package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Moins extends BinaireArithmetique {

	public Moins(Expression gauche, Expression droite) {
		super(gauche, droite);
	}

	@Override
	public String operateur() {
		return " - ";
	}


	@Override
	public String toMIPS() {
		StringBuilder s = new StringBuilder();
		s.append(gauche.toMIPS())
		 .append("\n")
		 .append("sw $v0, ($sp)")
		 .append("\n")
		 .append("addi $sp, $sp -4")
		 .append("\n")
		 .append( droite.toMIPS() )
		 .append("\n")
		 .append("addi $sp, $sp, +4")
		 .append("\n")
		 .append("lw $t8, ($sp) ")
		 .append("\n")
		 .append("sub $v0, $t8, $v0\n") ;
		return s.toString() ;
	}
	
	@Override
	public String getType() {
		return "int";
	}

}
