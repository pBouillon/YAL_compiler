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
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		return gauche.toMIPS() + "\n" +
				"sw $v0, ($sp)\n" +
				droite.toMIPS() + "\n" +
				"lw $t8, ($sp) n" +
				"div $v0, $t8\n" +
				"mflo $v0\n" ;
	}
    
}
