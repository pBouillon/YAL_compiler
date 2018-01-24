package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		StringBuilder s = new StringBuilder();
		s.append("#Evaluation d'une constante dans v0 \n");
		s.append("li $v0, " + cste);
		return s.toString();
	}

}
