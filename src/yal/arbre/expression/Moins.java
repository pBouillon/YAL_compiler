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
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return gauche.toMIPS() + "\n sw $v0, ($sp) \n addi $sp, $sp -4 \n " + droite.toMIPS() + "\n addi $sp, $sp, +4 \n lw $t8, ($sp) \n sub $v0, $t8, $v0";
		
	}
    
}
