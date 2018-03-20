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
           "\n\t# Retour fonction",
                exp.toMIPS(),
                "\t# Retour au programme",
                "\tjr $ra"
                
                /* 
                 * # c'est ce que j'ai noté du td mais j'ai l'impression que brigitte a donné de la merde incompréhensible 
                 * # retourne
                 * 
                 * #initialiser la base courante
                 * 		  move $t8, $s7
                 * 
                 *  iter :
                 * 		  si (4($t8) == n° bloc) alors aller a etiquette de fin
                 * 		  lw $v0, 8($ oublié de noté ce qu'il y a ici)
                 * 		  j iter
                 * 
                 *  fin :
                 *  # acces a la variable deplacement($t8)
                 * 	
                 * 
                 * 
                 * 
                 * 
                 */
        ) ;
    }
}
