package yal.arbre.expression;

import yal.arbre.instruction.Instruction;
import yal.exceptions.DoubleDeclarationException;
import yal.exceptions.ListeSemantiqueException;
import yal.tabledessymboles.Entry;
import yal.tabledessymboles.TDSv2;
import yal.tabledessymboles.VarEntry;
import yal.tabledessymboles.VarSymbol;

public class DeclVar extends Instruction {
    private String name ;
    boolean exists ;
    int noRegion ;

    Entry entry ;

    public DeclVar(String _name, int no) {
        super(no);
        System.out.println("ajout de la var " + _name + " avec un bloc de " + TDSv2.getInstance().getCurrentRegion());

        name = _name ;

        noRegion = TDSv2.getInstance().getCurrentRegion() ;
        entry = new VarEntry(name, "VAR") ;

        if (TDSv2.getInstance().varExists(entry, noRegion)) exists = true ;
        else {
            exists = false ;
            TDSv2.addVar (
                    entry,
                    new VarSymbol(name, noRegion, TDSv2.getInstance().getVarValue())
            ) ;
            TDSv2.getInstance().decrVarValue() ;
        }
    }

    @Override
    public void verifier() {
        if (exists){
            ListeSemantiqueException.getInstance()
                    .addException(
                            new DoubleDeclarationException(
                                    noLigne,
                                    "Variable " + name + " deja declaree"
                            )
                    ) ;
        }
    }

    @Override
    public String toMIPS() {
        return String.join (
                "\n",
                "\n# Declaration de la variable " + name
        ) ;
    }
}
