package yal.tabledessymboles;

import yal.arbre.expression.DeclFonction;

public class VarSymbol extends Symbol {
    VarSymbol(String _name, int _noRegion) {
        super(_name, _noRegion, "") ;
    }

    @Override
    int getPadding() {
        return 0;
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
