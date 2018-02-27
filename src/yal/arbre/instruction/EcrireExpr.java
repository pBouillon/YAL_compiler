package yal.arbre.instruction;
import yal.DataFactory;
import yal.EtiquetteFactory;
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
        String code ;

        code = String.join (
           "\n",
           "\t# ecriture de " + expr.toString()
        ) ;

        if (expr.getType().equals(TYPE_BOOLEAN)) {
            code += String.join (
                    "\n",
                    "\tbeqz $v0, " + et.getNextSiEg(),
                    "\tj "+ et.getNextSiNonEg(),
                    "\t" + et.getSiEg() + ": ",
                    "\t# affichage de vrai",
                    "\tli $v0 , 4",
                    "\tla $a0 , " + DataFactory.getInstance().getFalse(),
                    "\tj " + et.getNextFinSiEg(),
                    "\t" + et.getSiNonEg() + ":",
                    "\t# affichage de faux",
                    "\tli $v0 , 4",
                    "\tla $a0 , " + DataFactory.getInstance().getTrue(),
                    "\t" +et.getFinSiEg() + ":"
            ) ;
        }
        else {
            code += String.join (
                    "\n",
                    expr.toMIPS(),
                    "\tmove $a0, $v0",
                    "\t# affichage de la chaine de caractere",
                    "\tli $v0 , 1"
            ) ;
        }

        return code ;
    }

    @Override
    public String toString() {
        return "ecrire " + expr.toString() + "\n" ;
    }
}
