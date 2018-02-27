package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class OuLogique extends BinaireLogique {

	public OuLogique(Expression gauche, Expression droite) {
		super(gauche, droite);
	}

	@Override
	public String operateur() {
		return SYM_OR ;
	}

	@Override
	public String toMIPS() {
		return String.join (
				"\n",
				"\t# ou logique",
				gauche.toMIPS(),
				"\tsw $v0, ($sp)",
				"\taddi $sp, $sp -4",
				droite.toMIPS(),
				"\taddi $sp, $sp, +4",
				"\tlw $t8, ($sp)",
				"\tor $v0, $t8, $v0"
		) ;
	}
	@Override
	public String getType() {
		return TYPE_BOOLEAN;
	}
}
