package yal.arbre.instruction;

import yal.arbre.expression.Expression;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.VariableUndefinedException;
import yal.tabledessymboles.Entree;
import yal.tabledessymboles.TDS;

public class Affectation extends Instruction {
	
	private Expression exp;
	private String idf;
	
    public Affectation(String idf, Expression v, int no) {
        super(no);
        this.idf = idf;
        this.exp = v;
    }

    @Override
    public void verifier() {
    	 TDS.getInstance().identifier(idf, noLigne);
    }

    @Override
    public String toMIPS() {
        return  +
        		"# Affectation de " +
        		" "+
        		" "+
        		" ";
    }
}
