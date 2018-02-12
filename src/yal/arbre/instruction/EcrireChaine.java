package yal.arbre.instruction;

public class EcrireChaine extends Ecrire {
    private String cste ;

    protected EcrireChaine(int no, String _cste) {
        super(no);
        cste = _cste ;
    }

    @Override
    public void verifier() { }

    @Override
    public String toMIPS() {
        return  "\t# affichage de la chaine de caractere\n" +
                "\tli $v0 , 1\n" +
                "\tli $a0 , " + cste + "\n" +
                "\tsyscall\n" ;
    }
}
