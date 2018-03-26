package yal.tabledessymboles;

public class TDSv2 {
    private static TDSv2 ourInstance = new TDSv2();
    public static TDSv2 getInstance() {
        return ourInstance;
    }

    private Node root ;
    private Node currentNode ;

    private TDSv2() {
        root = new Node() ;
        currentNode = root ;
    }
}
