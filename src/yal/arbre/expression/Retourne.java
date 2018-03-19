package yal.arbre.expression;

import yal.arbre.instruction.Instruction;

public class Retourne extends Instruction {
    private Expression exp ;

    protected Retourne(Expression e, int no) {
        super(no);
        exp = e ;
    }

    @Override
    public void verifier() {
        exp.verifier() ;
    }

    @Override
    public String toMIPS() {
        return String.join (
           "\n",
           "\n # Retour fonction",
                exp.toMIPS(),
                "# on stocke la valeur de v0 à la fin de la pile",
                "sw $v0, 16(s7)"
        ) ;
    }
}
