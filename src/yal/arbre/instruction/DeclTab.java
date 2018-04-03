package yal.arbre.instruction;

import yal.arbre.expression.Expression;

public class DeclTab extends Instruction {
    String name ;
    Expression exp ;

    public DeclTab(String _name, Expression _exp, int n) {
        super(n);
        name = _name ;
        exp = _exp ;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return null;
    }
}
