package yal.arbre.expression;

import yal.arbre.ArbreAbstrait;
import yal.arbre.BlocDInstructions;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.ReturnManquantException;
import yal.tabledessymboles.TDS;

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

                "\t# sauvegarde de la base locale dans la pile (ch dynamique)",
                "\tsw $sp, ($sp)",
                "\taddi $sp, $sp, -4",
                
                 "\t# empiler le numero de bloc",
                 "\tli $v0," +TDS.getInstance().getNextCompteurBloc(),
                 "\tsw $v0, ($sp)",
                 "\taddi $sp, $sp, -4",
                
                 "\t# initialisation de la base locale des variables",
                 "\tmove $s7, $sp",
                 "\t# reserver espace des variables locales ( pas besoin pour ce yal) ",
                 
                // Corps de fonction
                linstr.toMIPS(),


                "end"+name+":",
                "# restaurer le pointeur de pile ",
                "lw $sp, 12($s7)",
                "# restaurer la base locale s7",
                "lw $s7, 8($s7)",
                "restaurer le compteur (@ retour)",
                "lw $ra, ($sp)",
                "jr $ra"
                
                /*Appel fonc : 
                 * #reserver espace val retour
                 * 		addi $sp, $sp , -4
                 * # branchement a la fonction
                 * 		jal name  ( avec jal addresse de retour dans le registre ra 
                 * 
                 * name :
                 * # empiler addr retour
                 * 		sw $ra, ($sp)
                 * 		addi $sp, $sp, -4
                 * # sauvegarde de la base locale dans la pile (ch dynamique)
                 * 		sw $sp, ($sp)
                 * 		addi $sp, $sp, -4
                 * # empiler le numero de bloc (pour le bloc numero 3, nécessite un compteur global de nb de fonction)  
                 *        li $vo, 3      
                 *        sw $vo, ($sp)
                 * 		  addi $sp, $sp, -4
                 * # initialisation de la base locale des variables
                 * 		  move $s7, $sp
                 * # reserver espace des variables locales
                 * 		  addi $sp, $sp, -4*(nb variable fonc  pas besoin pour ce yal  ) 
                 * 
                 * 
                 * # execution des différentes instructions
                 * 		  linstr.toMIPS()
                 * endname:
                 * # restaurer le pointeur de pile 
                 * 		  lw $sp, 12($s7)
                 * # restaurer la base locale s7
                 * 		  lw $s7, 8($s7)
                 * #restaurer le compteur (@ retour)
                 * 		  lw $ra, ($sp)
                 * 		  jr $ra
                 * 
                 * 
                 * # si il y a une instr retourne alors l'espace qui lui était reservé sera rempli
                 * # mettre la valeur de retour dans la bonne variable 
                 * # puis depiler la valeur de retour
                 */
        ) ;
    }
}
