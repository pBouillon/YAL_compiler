package yal.arbre.expression;

import yal.arbre.ArbreAbstrait;
import yal.arbre.BlocDInstructions;
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
            if (i instanceof Retourne) {
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
                name + ":",

                "\t# Sauvegarde addresse retour",
                "\tsw $ra, ($sp)",
                "\taddi $sp, $sp, -4",

                "\t# Empilement de $s7 pour chainage arriere",
                "\tsw $s7, ($sp)",
                "\taddi $sp, $sp, -4",

                "\t# Empilement de num de region",
                "\tsw $zero, ($sp)",
                "\taddi $sp, $sp, -4",

                "\t# Deplacement de la base",
                "\tmove $s7, $sp",

//                FONCTIONS AVEC PARAM:
//                "\tmove $sp, $sp - nb_vars"

                // Corps de fonction
                linstr.toMIPS()
        ) ;
    }
}
