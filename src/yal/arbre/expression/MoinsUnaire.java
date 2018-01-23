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
		StringBuilder s = new StringBuilder();
		s.append(expression.toMIPS());
		s.append("\n");
		s.append("sw $v0, ($sp)");
		s.append("\n");	
		s.append("li $v0, 0");
		s.append("\n");
		s.append("lw $t8, ($sp) ");
		s.append("\n");		
		s.append("sub $v0, $t8, $v0");
		return s.toString();
	}

}
