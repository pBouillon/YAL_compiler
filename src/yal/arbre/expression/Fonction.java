package yal.arbre.expression;

import yal.arbre.BlocDInstructions;

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
        linstr.verifier() ;
    }

    @Override
    public String toMIPS() {
        return String.join (
                "\n",
                "\n# Declaration de la fonction " + name) ;
    }
}
