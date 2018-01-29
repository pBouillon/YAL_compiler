package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {

	public MoinsUnaire(Expression expr) {
		super(expr);
	}

	@Override
	public String operateur() {
		return "- " ;
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toMIPS() {
		if(expression.getType() != "int") {
			return "ERREUR SEMANTIQUE: " + this.getType() + " avec un " + expression.getType() ;
		}else {
			return 	"li $v0, 0 \n" +  "\n" +
					"sw $v0, ($sp) \n" +
					expression.toMIPS()	+
					"lw $t8, ($sp) \n" +
					"sub $v0, $t8, $v0\n" ;
		}
	}

	@Override
	public String getType() {
		return "soustraction unaire";
	}

}
