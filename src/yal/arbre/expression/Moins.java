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
		s.append(gauche.toMIPS());
		s.append("\n");
		s.append("sw $v0, ($sp)");
		s.append("\n");
		s.append("addi $sp, $sp -4");
		s.append("\n");
		s.append( droite.toMIPS() );
		s.append("\n");
		s.append("addi $sp, $sp, +4");
		s.append("\n");
		s.append("lw $t8, ($sp) ");
		s.append("\n");
		s.append("sub $v0, $t8, $v0");
		return s.toString();

	}

	@Override
	public String getType() {
		return "soustraction";
	}

}
