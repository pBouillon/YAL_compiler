package yal.arbre.instruction;

import yal.arbre.expression.Expression;

public class AffectationTab extends Instruction {
    String name ;
    Expression indice ;
    Expression exp ;

    public AffectationTab(String _name, Expression _exp, Expression _exp2, int no) {
        super(no);
        name   = _name ;
        indice = _exp  ;
        exp    = _exp2 ;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return null;
    }
}
