package yal.arbre.expression;

import yal.arbre.instruction.Instruction;

public class Retourne extends Instruction {
    private Expression exp ;

    public Retourne(Expression e, int no) {
        super(no);
        exp = e ;
    }

    @Override
    public void verifier() {
        exp.verifier() ;
    }

    @Override
    public String toMIPS() {
        return String.join (
           "\n",
           "\n\t# RETOUR",
                "\t# Retour fonction",
                exp.toMIPS(),

                "\t# Stockage $v0 dans val retour",
                "\tsw $v0, 16($sp)", // 4 * champs obligatoires ( == 4)

                "\t# Remontee de $sp jusqu'au chainage dyn",
                "\tadd $sp, $sp, 8", // nb_var * 4 + no region + ch dyn

                "\t# Depilement de la base: $s7 = $sp",
                "\tlw $s7, ($sp)",
                "\tadd $sp, $sp, 4",

//                FONCTIONS AVEC PARAM:
//                "\tmove $sp, $sp + nb_var + no_region + ch_dyn"

                "\t# Recuperation addresse pour addr de retour",
                "\tlw $ra, ($sp)",

                "\t# Remonte $sp a val retour",
                "\taddi $sp, $sp, 4",

                "\t# Retour de la fonction",
                "\tjr $ra"
        ) ;
    }
}
