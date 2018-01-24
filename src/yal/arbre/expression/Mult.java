package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Mult extends BinaireArithmetique {

    public Mult(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
  
    @Override
    public String operateur() {
        return " * ";
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		return "#Evaluation de l'opérande gauche \n" +
				gauche.toMIPS() + "\n" +
				"# Stocke la valeur de v0 dans la mémoire \n" +
				"sw $v0, ($sp) \n" +
				"addi $sp, $sp, -4 \n" +
				"# Evaluation de l'opérande droite \n" +
				droite.toMIPS() + "\n" +
				"# Recuperation de sp dans t8 \n" +
				"addi $sp, $sp, 4 \n" +
				"lw $t8, ($sp) \n" +
				"# Multiplication de t8 par v0 \n" +
				"mult $v0, $t8 \n" +
				"mflo $v0 \n" ;
	}

}
