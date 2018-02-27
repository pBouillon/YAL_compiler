package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Egal extends Comparaison {

    public Egal(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return SYM_EQU ;
    }

	@Override
	public String toMIPS() {
    	return String.join (
    			"\n",
				"\t# debut egalite",
				gauche.toMIPS(),
				"\tsw $v0, ($sp)",
				"\taddi $sp, $sp -4",
				droite.toMIPS(),
				"\taddi $sp, $sp, +4",
				"\tlw $t8, ($sp)",
				"\tsub $v0, $t8, $v0",
				"\tbeqz $v0, " + et.getNextSiEg(),
				"\tj " + et.getNextSiNonEg(),
				et.getSiEg() + ":",
				"\tli $v0, 1",
				"\tj " + et.getNextFinSiEg(),
				et.getSiNonEg() + ":",
				"\tli $v0, 0",
				et.getFinSiEg() + ":"
		) ;
	}

	@Override
	public String getType() {
		return TYPE_BOOLEAN ;
	}
    
}
