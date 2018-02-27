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
        return String.join (
                "\n",
                exp.toMIPS(),
                "# affectation de " + exp.toString() + " -> " + idf,
                "\tsw $v0, " + TDS.getInstance()
                                    .identifier (
                                            idf,
                                            noLigne
                                    )
                                    .getPointeur() + "($s7)"
        ) ;
    }

    @Override
    public String toString() {
        return "Affectation " + idf + " = " + exp.toString() + "\n" ;
    }
}
