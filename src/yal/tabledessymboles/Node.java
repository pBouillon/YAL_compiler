package yal.tabledessymboles;

import java.util.ArrayList;

public class Node {
    private Node parent ;
    private ArrayList<Node> childs ;

    private Entry entree ;
    private Symbol symbol;

    private int val ;

    public Node(Node _parent, Entry e, Symbol s) {
        parent = _parent ;
        childs = new ArrayList<>() ;

        entree  = e ;
        symbol = s ;

        val = 0 ;
    }

    public void setChilds(Node _child) {
        childs.add(_child) ;
    }

    public Node getParent() {
        return parent ;
    }

    public Entry getEntry() {
        return entree ;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public ArrayList<Node> getChilds() {
        return childs;
    }

    public int getVal() {
        return val ;
    }

    public boolean exists (Entry e, int noRegion) {
        for (Node n : childs) {
            if (!(n.symbol instanceof FnSymbol)
                    && n.exists(e, noRegion)) {
                return true ;
            }
        }
        return entree.equals(e) && symbol.getNoRegion() == noRegion ;
    }

    public void decrVal() {
        val -= 4 ;
    }


}
