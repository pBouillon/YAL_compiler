package yal.arbre.expression;

import yal.EtiquetteFactory;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Inferieur extends Comparaison {

    public Inferieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " < ";
    }


	@Override
	public String toMIPS() {
		return gauche.toMIPS() +
				"sw $v0, ($sp)\n" +
				"addi $sp, $sp -4\n" +
				droite.toMIPS() +
				"addi $sp, $sp, +4\n" +
				"lw $t8, ($sp)\n" +
				"sub $v0, $t8, $v0\n" +
                "bltz $v0,"+EtiquetteFactory.getInstance().getNextSiInf()+"\n" +
                "j "+ EtiquetteFactory.getInstance().getNextSiNonInf() +"\n" +
                EtiquetteFactory.getInstance().getSiInf()+": \n" +
                "lw $v0, 1\n" +
                "j "+EtiquetteFactory.getInstance().getNextFinSiInf()+"\n" +
                EtiquetteFactory.getInstance().getSiNonInf()+":\n" +
                "lw $v0, 0\n" +
                EtiquetteFactory.getInstance().getFinSiInf()+ ":\n";
	}

	@Override
	public String getType() {
		return "boolean";
	}
    
}
