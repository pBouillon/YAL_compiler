package yal.arbre;

import yal.Yal;
import yal.arbre.expression.DeclFonction;
import yal.arbre.instruction.Retourne;

import java.util.ArrayList;

import static yal.Yal.footer;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    private ArrayList<ArbreAbstrait> linst ;
    
    public BlocDInstructions(int n) {
        super(n) ;
        linst = new ArrayList<>();
    }

    public ArrayList<ArbreAbstrait> getInstr() {
    	return linst ;
	}
    
    public void ajouter(ArbreAbstrait a) {
        linst.add(a) ;
    }



    @Override
    public String toString() {
    	StringBuilder res = new StringBuilder();
        for (ArbreAbstrait a: linst){
            if (a != null) res.append(a.toString()) ;
        }
		return res.toString();
    }

	@Override
	public void verifier() {
        for (ArbreAbstrait a: linst) {
            if (a != null) a.verifier() ;
        }
	}

	@Override
	public String toMIPS() {
        boolean funcDeclared = false ;

		StringBuilder res = new StringBuilder() ;

        for (ArbreAbstrait a: linst) {
            if (a instanceof Retourne) Yal.incRet(a.noLigne);

            if (a instanceof DeclFonction && !funcDeclared){
                res.append("\n");
                res.append(footer()) ;
                res.append("\n");
                funcDeclared = true ;
            }
            if (a != null) res.append (a.toMIPS()) ;
        }

		return res.toString();
	}

}
