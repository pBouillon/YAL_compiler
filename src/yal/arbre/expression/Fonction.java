package yal.arbre.expression;

import yal.arbre.ArbreAbstrait;
import yal.arbre.BlocDInstructions;
import yal.arbre.instruction.Instruction;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.ReturnManquantException;

public class Fonction extends ArbreAbstrait {
    private String name ;
    private BlocDInstructions linstr ;

    public Fonction(String _name, BlocDInstructions _linstr, int n) {
        super(n);
        name   = _name ;
        linstr = _linstr ;
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
            ListeSemantiqueException.getInstance()
                    .addException (
                            new ReturnManquantException (
                                    super.noLigne,
                                    name
                            )
                    );
        }

        linstr.verifier() ;
    }

    @Override
    public String toMIPS() {
        return String.join (
                "\n",
                "\n\t# Declaration de la fonction " + name,
                "\n\t" + name + ":"
        ) ;
    }
}
