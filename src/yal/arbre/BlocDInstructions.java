package yal.arbre;

import java.util.ArrayList;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArrayList<ArbreAbstrait> linst ;
    
    public BlocDInstructions(int n) {
        super(n) ;
        linst = new ArrayList<ArbreAbstrait>();
    }
    
    public void ajouter(ArbreAbstrait a) {
        linst.add(a) ;
    }
    
    @Override
    public String toString() {
    	String res = "";
			for (ArbreAbstrait a: linst){
				if (a != null){
					res = res + a.toString();
				}
			}
		return res;
    }

	@Override
	public void verifier() {
			for (ArbreAbstrait a: linst){
			if (a != null){
				a.verifier();
				}
			}
	}

	@Override
	public String toMIPS() {
		String res = "";
			for (ArbreAbstrait a: linst){
				if (a != null){
					res = res + a.toMIPS();
				}
			}
		return res;
	}

}
