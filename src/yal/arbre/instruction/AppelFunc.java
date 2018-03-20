package yal.arbre.instruction;

import yal.arbre.expression.Expression;
import yal.tabledessymboles.TDS;

public class AppelFunc extends Expression {
    private String name ;

    public AppelFunc(String _name, int no) {
        super(no);
        name = _name ;
    }

    @Override
    public void verifier() {
        TDS.getInstance().identifier("func_" + name, noLigne) ;
    }

    @Override
    public String toMIPS() {
        return String.join(
                "\n",
                "\n\t# allocation place pour return",
                "\taddi $sp, $sp, -4",
                "\t# appel de " + name + "()",
                "\tjal " + name
        );
    }

    @Override
    public String getType() {
        return TYPE_ENTIER;
    }
}
