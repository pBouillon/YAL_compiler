package yal.arbre.instruction;

public class EcrireExpr extends Ecrire {
    private String cste ;
    protected EcrireExpr(int no, String _cste) {
        super(no);
        cste = _cste ;
    }

    @Override
    public void verifier() {}

    @Override
    public String toMIPS() {
        return  "\t# affichage de la chaine de caractere\n" +
                "\tli $v0 , 1\n" +
                "\tli $a0 , " + cste + "\n" +
                "\tsyscall\n" ;
    }
}
