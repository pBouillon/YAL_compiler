package yal.arbre.instruction;

import yal.arbre.expression.Expression;

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
