package yal.arbre.expression ;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {

	private final String TRUE  = "vrai" ;
	private final String FALSE = "faux" ;

    public ConstanteBool(String texte, int n) {
        super(texte, n) ;
    }

    private int eval (String bool_expr) {
    	return bool_expr.equals(TRUE) ? 1
									  : 0 ;
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
    	int bool_expr = eval(cste) ;

		return "# Chargement de la constante " + bool_expr + "\n" +
				"li $v0, " + bool_expr ;
	}

}
