package yal.tabledessymboles;

import yal.ETQ;

public class TDSv2 {
    public static String PARM_NAME = "param" ;

    private static TDSv2 ourInstance = new TDSv2();
    public static TDSv2 getInstance() {
        return ourInstance;
    }

    private static Node root ;
    private static Node currentNode ;

    private int maxRegion ;
    private int currentRegion ;

    private int paramValue;
    private int varValue;

    private TDSv2() {
        root = new Node (null,
                new FnEntry("Root", "root"),
                new FnSymbol("Root", 0, 0, "racine", null)
        ) ;
        currentNode = root ;

        maxRegion = 0 ;
        currentRegion = 0 ;

        paramValue = 0 ;
        varValue = 0 ;
    }

    public int getCurrentRegion() {
        return currentRegion ;
    }

    public static void addVar (Entry e, Symbol s) {
        currentNode.setChilds(new Node (
                currentNode,
                e,
                s
        )) ;
    }

    public static void addFn (Entry e, Symbol s) {
        Node fn = new Node(currentNode, e, s) ;
        currentNode.setChilds(fn) ;
        currentNode = fn ;
    }

    public Symbol identifierFn (Entry e, int paramNb) {
        for (Node n : root.getChilds()) {
            if (currentNode.getEntry() instanceof FnEntry
                    && n.getEntry().equals(e)
                    && n.getSymbol().getNbParam() == paramNb) {
                return n.getSymbol();
            }
        }
        return null ;
    }

    public String identifierVar (Entry e) {
        Node n = getSymbol(e) ;

        assert n != null ;
        int noRegion = n.getSymbol().getNoRegion() ;

        String generated = "" ;
        int padding = 16 - n.getSymbol().getPadding() ;

        if (n.getEntry().getType().equals(PARM_NAME)) {
            generated += String.join (
                    "\n",
                    "\n\tadd $s2, $s7, " + padding
            ) ;
        }
        else {
            if (noRegion != currentRegion) {
                generated += String.join (
                        "\n",
                        "\n\tmove $t1, $s7",
                        ETQ.getInstance().getNextCheck() + ":",
                        "\tlw $t1, 8($t1)",
                        "\tlw $t2, 4($t1)",
                        "\tbeq $t2, $zero, " + ETQ.getInstance().getNextFcheck(),
                        "\tj " + ETQ.getInstance().getCheck(),
                        ETQ.getInstance().getFcheck() + ":",
                        "\tmove $s2, $t1"
                ) ;
            }
            generated += "\n\tadd $s2, $s2, " + n.getSymbol().getPadding() ;
        }

        return "\n\tmove $s2, $s7" + generated ;
    }

    private Node getSymbol (Entry e) {
        for (Node n : currentNode.getChilds()) {
            if (n.getEntry().equals(e)) return n ;
        }
        for (Node n : root.getChilds()) {
            if (n.getEntry().equals(e)
                    && n.getEntry().getType().equals(PARM_NAME)) {
                return n ;
            }
        }
        return null ;
    }

    public boolean fnExists(Entry e, int nbParam) {
        for (Node n : root.getChilds()) {
            if (n.getEntry().equals(e)
                    && n.getSymbol().getNbParam() == nbParam) {
                return true ;
            }
        }
        return false ;
    }

    public boolean varExists(Entry e, int noRegion) {
        return root.exists(e, noRegion) ;
    }

    public boolean paramExists(Entry e, int noRegion) {
        for (Node n : root.getChilds()) {
            if (n.getEntry().equals(e)
                    && n.getSymbol().getNoRegion() == noRegion) {
                return true ;
            }
        }
        return false ;
    }

    public void beginBloc() {
        ++maxRegion ;
        currentRegion = maxRegion ;
    }

    public void endBlock() {
        currentNode = currentNode.getParent() ;
        currentRegion = 0 ;
        paramValue = 0 ;
    }

    public int getParamValue() {
        return paramValue ;
    }

    public void decrParamVal() {
        paramValue -= 4 ;
    }

    public int getVarValue() {
        return currentNode.getVal() ;
    }

    public void decrVarValue() {
        currentNode.decrVal() ;
    }

    public String genFn() {
        StringBuilder mips = new StringBuilder() ;
        for (Node n : root.getChilds()) {
            if (n.getSymbol() instanceof FnSymbol) {
                mips.append(n.getSymbol().getFn().toMIPS()) ;
            }
        }
        return mips.toString() ;
    }

    public void checkFn() {
        for (Node n : root.getChilds()) {
            if (n.getSymbol() instanceof FnSymbol) {
                n.getSymbol().getFn().verifier() ;
            }
        }
    }
}
