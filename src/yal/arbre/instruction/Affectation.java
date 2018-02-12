package yal.arbre.instruction;

import yal.arbre.expression.Expression;

public class Affectation extends Instruction {
    public Affectation(String idf, Expression v, int no) {
        super(no);
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return null;
    }
}
