package yal.arbre;

import yal.Yal;
import yal.arbre.expression.Fonction;
import yal.arbre.expression.Retourne;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.ReturnException;
import yal.exceptions.ReturnManquantException;

import java.util.ArrayList;

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

    /**
     * @return mips clean ending and storage in $v1
     */
    private String footer() {
        return String.join (
                "\n",
                "\nend:",
                "\tmove $v1, $v0",
                "\tli $v0, 10",
                "\tsyscall"
        ) ;
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
            if (a instanceof Retourne) {
                Yal.incRet(a.noLigne);
            }

            if (a instanceof Fonction && !funcDeclared){
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
