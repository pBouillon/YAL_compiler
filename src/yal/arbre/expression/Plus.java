package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Plus extends BinaireArithmetique {

	public Plus(Expression gauche, Expression droite) {
		super(gauche, droite);
	}

	@Override
	public String operateur() {
		return SYM_PLUS ;
	}

	@Override
	public String toMIPS() {
		return String.join (
				"\n",
				gauche.toMIPS(),
				"\tsw $v0, ($sp)",
				"\taddi $sp, $sp -4",
				droite.toMIPS(),
				"\taddi $sp, $sp, +4",
				"\tlw $t8, ($sp)",
				"\tadd $v0, $t8, $v0"
		) ;
	}
    
	@Override
	public String getType() {
		return TYPE_ENTIER;
	}
}
