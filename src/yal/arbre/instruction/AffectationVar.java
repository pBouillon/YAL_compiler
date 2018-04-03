package yal.arbre.instruction;

import yal.arbre.expression.Expression;
import yal.exceptions.BadAffectationException;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;
import yal.tabledessymboles.TDSv2;
import yal.tabledessymboles.VarEntry;

public class AffectationVar extends Instruction {
	
	private Expression exp;
	private String idf;

	int noRegion ;
	
    public AffectationVar(String idf, Expression v, int no) {
        super(no);
        this.idf = idf;
        this.exp = v;
        noRegion = TDSv2.getInstance().getCurrentRegion() ;
    }

    @Override
    public void verifier() {
        if (!TDSv2.getInstance().varExists(new VarEntry(idf, "VAR"), noRegion)){
            ListeSemantiqueException.getInstance().addException(new SemantiqueException(noLigne, idf +": var non déclarée"));
        }
        else if (!exp.getType().equals(TYPE_ENTIER)) {
            ListeSemantiqueException.getInstance().addException(new BadAffectationException(noLigne));
        }
    }

    @Override
    public String toMIPS() {
        return String.join (
                "\n",
                exp.toMIPS(),
                "# affectation de " + exp.toString() + " -> " + idf,
                TDSv2.getInstance().identifierVar(new VarEntry(idf, "VAR")),
                "\tsw $v0, ($s2)"
        ) ;
    }

    @Override
    public String toString() {
        return "AffectationVar " + idf + " = " + exp.toString() + "\n" ;
    }
}
