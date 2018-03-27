package yal.arbre.instruction;

import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;
import yal.tabledessymboles.Entry;
import yal.tabledessymboles.TDSv2;
import yal.tabledessymboles.VarEntry;
import yal.tabledessymboles.VarSymbol;

import static yal.tabledessymboles.TDSv2.PARM_NAME;

public class DeclParam extends Instruction {
    Entry entry ;
    int nbParam ;
    int noRegion ;

    boolean exists ;
    String name ;

    public DeclParam(String idf, int no) {
        super(no);

        entry = new VarEntry (idf, PARM_NAME) ;
        nbParam = 0 ;

        name = idf ;

        noRegion = TDSv2.getInstance().getCurrentRegion() ;

        addParam() ;
        verifier() ;
    }

    private void addParam() {
        if (TDSv2.getInstance().paramExists(entry, noRegion)) {
            exists = true ;
            return ;
        }
        TDSv2.addVar(
                entry,
                new VarSymbol (
                        name,
                        noRegion,
                        TDSv2.getInstance().getParamValue()
                )
        ) ;
        TDSv2.getInstance().decrParamVal() ;
        exists = false ;
    }

    @Override
    public void verifier() {
        if (exists) {
            ListeSemantiqueException.getInstance()
                    .addException (
                            new SemantiqueException (
                                    noLigne,
                                    "Double déclaration de parametre"
                            )
                    ) ;
        }
    }

    @Override
    public String toMIPS() {
        return null;
    }
}
