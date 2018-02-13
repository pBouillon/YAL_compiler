package yal.arbre.instruction;

import yal.DataFactory;

public class EcrireChaine extends Ecrire {
    private String cste ;

    public EcrireChaine(String _cste, int no) {
        super(no);
        cste = _cste ;
    }

    @Override
    public void verifier() { }

    @Override
    public String toMIPS() {
        DataFactory.getInstance().addData(cste) ;
        return String.join (
                "\n",
                "\t# stockage de v0 en memoire",
                "\tsw $v0, ($sp)",
                "\taddi $sp, $sp, -4",
                "\t# affichage de la chaine de caractere",
                "\tli $v0 , 1",
                "\tli $a0 , " + DataFactory.getInstance().getVarFor(cste),
                "\tsyscall",
                "\t# recuperation de la valeur en memoire",
                "\taddi $sp, $sp, 4",
                "\tlw $v0, ($sp)"
            ) ;
    }
}
