package yal.tabledessymboles;

import yal.arbre.expression.DeclFonction;

public abstract class Symbol {
    String name  ;
    int noRegion ;
    String etq ;

    Symbol (String _name, int _noRegion, String _etq) {
        name = _name ;
        noRegion = _noRegion ;
        etq = _etq ;
    }

    public int getNoRegion() {
        return noRegion ;
    }

    abstract int getPadding() ;
    abstract int getNbParam() ;
    abstract DeclFonction getFn() ;

    public String getEtq() {
        return etq ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null
                || getClass() != obj.getClass()) {
            return false;
        }

        Symbol testedObj = (Symbol) obj ;
        return noRegion == getNoRegion()
                && testedObj.name.equals(name) ;

    }
}
