package yal.tabledessymboles;

import yal.arbre.expression.DeclFonction;

public class VarSymbol extends Symbol {
    int padding ;

    public VarSymbol(String _name, int _noRegion, int _padding) {
        super(_name, _noRegion, "") ;
        padding = _padding ;

    }

    @Override
    int getPadding() {
        return padding ;
    }

    @Override
    int getNbParam() {
        return 0 ;
    }

    @Override
    DeclFonction getFn() {
        return null ;
    }
}
