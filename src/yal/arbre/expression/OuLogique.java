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
        return " ou " ;
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		return "# Evaluation de l'opérande gauche \n" +
				gauche.toMIPS() + "\n" + 
				"# Stocke la valeur de v0 dans la mémoire \n" +
				"sw $v0, ($sp) \n" +
				"# Dépilement dans $sp \n" +
				"addi $sp, $sp -4 \n" +
				"# Evaluation de l'opérande droite \n" +
				droite.toMIPS() + "\n" +
				"# Déplacement de sp \n" +
				"addi $sp, $sp, +4 \n" +
				"lw $t8, ($sp) \n" +
				"# comparaison de t8 et v0 (ou) \n" +
				"or $v0, $t8, $v0\n" ;
	}

}
