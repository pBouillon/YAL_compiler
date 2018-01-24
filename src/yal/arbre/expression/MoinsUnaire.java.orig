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
		return expression.toMIPS() + "\n" +
				"sw $v0, ($sp) \n" +
				"li $v0, 0 \n" +
				"lw $t8, ($sp) \n" +
				"sub $v0, $t8, $v0\n" ;
	}

}
