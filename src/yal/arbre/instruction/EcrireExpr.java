package yal.arbre.instruction;
import yal.arbre.expression.*;

public class EcrireExpr extends Ecrire {
	private Expression expr;
	
    public EcrireExpr(Expression e, int no) {
        super(no);
        this.expr = e ;
    }

    @Override
    public void verifier() {}

    @Override
    public String toMIPS() {
        return "# ecriture de l'expression" + expr +
                "" ;
    }
}
