package yal.arbre.expression;

import yal.arbre.ArbreAbstrait;
import yal.arbre.BlocDInstructions;
import yal.arbre.instruction.Instruction;

public class Fonction extends Expression {
    private String name ;
    private BlocDInstructions linstr ;

    public Fonction(String _name, BlocDInstructions _linstr, int n) {
        super(n);
        name   = _name ;
        linstr = _linstr ;
    }

    @Override
    public String getType() {
        return TYPE_ENTIER ;
    }

    @Override
    public void verifier() {
        boolean returnFound = false ;
        for (ArbreAbstrait i : linstr.getInstr()) {
            if (i instanceof Instruction) {
                returnFound = true ;
                break ;
            }
        }

        if (!returnFound) {

        }

        linstr.verifier() ;
    }

    @Override
    public String toMIPS() {
        return String.join (
                "\n",
                "\n# Declaration de la fonction " + name) ;
    }
}
