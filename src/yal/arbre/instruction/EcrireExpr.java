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
    public void verifier() { }

    @Override
    public String toMIPS() {
        String ret = "# ecriture de l'expression " + expr + "\n" ;
        if (expr.getType().equals("boolean")) {
            ret += String.join (
               "\n",
               "\tbeqz $v0, " + EtiquetteFactory.getInstance().getNextSiEg(),
                    "\tj "+ EtiquetteFactory.getInstance().getNextSiNonEg(),
                    "\t" + EtiquetteFactory.getInstance().getSiEg() + ": ",
                    "\t# affichage de vrai",
                    "\tli $v0 , 4",
                    "\tla $a0 , " + DataFactory.getInstance().getFalse(),
                    "\tj " + EtiquetteFactory.getInstance().getNextFinSiEg(),
                    "\t" + EtiquetteFactory.getInstance().getSiNonEg() + ":",
                    "\t# affichage de faux",
                    "\tli $v0 , 4",
                    "\tla $a0 , " + DataFactory.getInstance().getTrue(),
                    "\t" + EtiquetteFactory.getInstance().getFinSiEg() + ":"
            ) ;
        } else {
            ret += String.join(
                "\n",
                expr.toMIPS(),
                "\tmove $a0, $v0",
                "\t# affichage de la chaine de caractere",
                "\tli $v0 , 1" // code d'affichage pour les entiers
            ) ;
        }

        return ret + "\n\tsyscall\n";
    }

    @Override
    public String toString() {
        return "ecrire " + expr.toString() + "\n" ;
    }
}
