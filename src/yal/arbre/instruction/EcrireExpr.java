package yal.arbre.instruction;
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
        return String.join(
                "\n",
                "# ecriture de l'expression " + expr + "\n" ,
                expr.toMIPS(),
                "\t# stockage de l'expr dans t8",
                "\tlw $t8, $v0",
                "\t# affichage de la chaine de caractere",
                "\tli $v0 , 1", // code d'affichage pour les entiers
                "\tli $a0 , $t8"
        ) ;
    }

    @Override
    public String toString() {
        return "ecrire " + expr.toString() + "\n" ;
    }
}
