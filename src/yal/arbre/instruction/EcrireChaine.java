package yal.arbre.instruction;

import yal.DataFactory;

public class EcrireChaine extends Ecrire {
    private String cste ;

    public EcrireChaine(String _cste, int no) {
        super(no);
        cste = _cste ;
    }

    @Override
    public void verifier() {}

    @Override
    public String toMIPS() {
        DataFactory.getInstance().addData(cste) ;
        return String.join (
                "\n",
                "\t# affichage de " + cste,
                "\tli $v0 , 4",
                "\tla $a0 , " + DataFactory.getInstance().getVarFor(cste),
                "\tsyscall"
            ) ;
    }

    @Override
    public String toString() {
        return "ecrire " + cste + "\n" ;
    }
}
