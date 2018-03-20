package yal.arbre.expression;

import yal.arbre.instruction.Instruction;

public class DeclVar extends Instruction {
    private String name ;
    public DeclVar(String _name, int no) {
        super(no);
        name = _name ;
    }

    @Override
    public void verifier() {}

    @Override
    public String toMIPS() {
        return String.join (
                "\n",
                "\n# Declaration de la variable " + name
        ) ;
    }
}
