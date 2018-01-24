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
        return " + " ;
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		StringBuilder s = new StringBuilder();
		s.append("#Evaluation de l'opérande gauche \n");
		s.append(gauche.toMIPS());
		s.append("\n");
		s.append("#Stocke la valeur de v0 dans la mémoire \n");
		s.append("sw $v0, ($sp)");
		s.append("\n");
		s.append("#Déplacement de sp \n");
		s.append("addi $sp, $sp -4");
		s.append("\n");
		s.append("#Evaluation de l'opérande droite \n");
		s.append(droite.toMIPS());
		s.append("\n");
		s.append("#Déplacement de sp \n");
		s.append("addi $sp, $sp, +4");
		s.append("\n");
		s.append("lw $t8, ($sp) ");
		s.append("\n");
		s.append("#Ajout de t8 et v0 \n");
		s.append("add $v0, $t8, $v0");
		return s.toString();
	}

}
