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
		return String.join (
			"\n",
			"\t# inferieur",
				gauche.toMIPS(),
				"\tsw $v0, ($sp)",
				"\taddi $sp, $sp -4",
				droite.toMIPS(),
				"\taddi $sp, $sp, +4",
				"\tlw $t8, ($sp)",
				"\tsub $v0, $t8, $v0",
				"\tbgtz $v0, " + et.getNextSiSup(),
				"\tj " + et.getNextSiNonSup(),
				et.getSiSup() + ":",
				"\tli $v0, 1",
				"\tj " + et.getNextFinSiSup(),
				et.getSiNonSup() + ":",
				"\tli $v0, 0",
				et.getFinSiSup() + ":"
		) ;
	}

	@Override
	public String getType() {
		return TYPE_BOOLEAN;
	}
    
}
