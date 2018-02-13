package yal.arbre.instruction;

import yal.arbre.expression.Expression;
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
        return  exp.toMIPS()+
        		"# Affectation de " +  exp.toString() + " dans " + idf + " \n" +
        		"sw $v0, "+ TDS.getInstance().identifier(idf, this.noLigne ).getPointeur() +"($s7) \n";
    }
}
