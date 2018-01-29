package yal.arbre.expression;

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
			s.append(gauche.toMIPS());
			s.append("\n");
			s.append("sw $v0, ($sp)");
			s.append("\n");
			s.append( droite.toMIPS() );
			s.append("\n");
			s.append("lw $t8, ($sp) ");
			s.append("\n");
			s.append("div $v0, $t8");
			s.append("\n");
			s.append("mflo $v0");
			return s.toString();
	}

	@Override
	public String getType() {
		return "division";
	}

}
