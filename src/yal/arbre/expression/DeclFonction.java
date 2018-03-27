package yal.arbre.expression;

import yal.arbre.ArbreAbstrait;
import yal.arbre.BlocDInstructions;
import yal.arbre.instruction.Instruction;
import yal.arbre.instruction.Retourne;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.ReturnManquantException;
import yal.exceptions.SemantiqueException;
import yal.tabledessymboles.Entry;
import yal.tabledessymboles.FnEntry;
import yal.tabledessymboles.FnSymbol;
import yal.tabledessymboles.TDSv2;

public class DeclFonction extends Instruction {
    private String name ;

    private BlocDInstructions ldecl  ;
    private BlocDInstructions linstr ;

    int noParam ;

    Entry entry ;
    boolean exist ;

    public DeclFonction(String _name, BlocDInstructions _linstr, int n, int _noParam) {
        super(n);
        name   = _name ;
        linstr = _linstr ;
        entry = new FnEntry(name, "func_" + _name) ;

        addFn() ;

        noParam = _noParam ;
    }

    public DeclFonction(String _name, BlocDInstructions _ldecl, BlocDInstructions _linstr, int n, int _noParam) {
        super(n);
        name   = _name ;
        linstr = _linstr ;
        ldecl  = _ldecl  ;

        addFn() ;

        noParam = _noParam ;
    }

    public void addFn() {
        if (TDSv2.getInstance().fnExists(entry, noParam)) {
            exist = true ;
            return ;
        }
        TDSv2.addFn (
            entry,
            new FnSymbol (
                    name,
                    TDSv2.getInstance().getCurrentRegion(),
                    noParam,
                    entry.getEtq(),
                    this
            )
        ) ;
        exist = false ;
    }

    @Override
    public void verifier() {
        // fn exists
        if (exist) {
            ListeSemantiqueException.getInstance()
                    .addException (
                            new SemantiqueException(
                                    noLigne,
                                    "Fonction deja declaree"
                            )
                    ) ;
        }

        // return
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
        StringBuilder mips = new StringBuilder() ;

        mips.append (
                String.join (
                        "\n",
                        "\n\t# declaration de " + name + " avec " + noParam + " parametres",

                        entry.getEtq() + ":",
                        "\t# Sauvegarde addresse retour",
                        "\tsw $ra, ($sp)",
                        "\taddi $sp, $sp, -4",

                        "\t# Empilement de $s7 pour chainage arriere",
                        "\tsw $s7, ($sp)",
                        "\taddi $sp, $sp, -4",

                        "\t# Empilement de numero de region",
                        "\taddi $v0, $zero, " + TDSv2.getInstance()
                                                        .identifierFn(entry, noParam)
                                                        .getNoRegion(),
                        "\tsw $v0, 0($sp)",
                        "\taddi $sp, $sp, -4",

                        "\t# deplacement de la base",
                        "\tmove $s7, $sp",

                        "\t# deplacement pile: place pour " + TDSv2.getInstance()
                                                                    .getVarValue() / (-4) + " variable.s",
                        "\taddi $sp, $sp, " + TDSv2.getInstance()
                                                    .getVarValue()
                )
        ) ;

        if (ldecl != null) mips.append(ldecl.toMIPS()) ;
        mips.append(linstr.toMIPS()) ;

        return mips.toString() ;
    }
}
