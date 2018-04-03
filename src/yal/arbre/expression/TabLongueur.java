package yal.arbre.expression;

public class TabLongueur extends Expression {
    String name ;

    public TabLongueur(String _name, int no) {
        super(no);
        name = _name ;
    }

    @Override
    public void verifier() {

    }

    @Override
    public String toMIPS() {
        return null;
    }

    @Override
    public String getType() {
        return TYPE_ENTIER;
    }
}
