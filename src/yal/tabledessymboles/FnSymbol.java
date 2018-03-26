package yal.tabledessymboles;

import yal.arbre.expression.DeclFonction;

public class FnSymbol extends Symbol {

    int nbParam;
    DeclFonction fn ;

    public FnSymbol(String _name, int _noRegion, int _paramNb, String _etq, DeclFonction _fn) {
        super(_name, _noRegion, _etq);
        nbParam = _paramNb ;
        fn = _fn ;
    }

    public DeclFonction getFn() {
        return fn ;
    }

    @Override
    int getPadding() {
        return 0;
    }

    @Override
    int getNbParam() {
        return nbParam ;
    }
}
