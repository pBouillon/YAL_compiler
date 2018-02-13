package yal;

import java.util.HashMap;

public class DataFactory {

    private final String VAR_NAME = "var" ;

    private static DataFactory INSTANCE
            = new DataFactory() ;

    private HashMap<String, Integer> var ;
    private int cpt ;

    private DataFactory() {
        cpt = 0 ;
        var = new HashMap<>() ;
        addData("Division par zero impossible");
    }

    public static DataFactory getInstance() {
        return INSTANCE ;
    }

    public void addData(String data) {
        var.put(data, cpt++) ;
    }

    /**
     * @param data string
     * @return VAR_NAME + nb
     */
    public String getVarFor(String data) {
        return VAR_NAME + var.get(data) ;
    }

    String genData() {
        StringBuilder dataGen = new StringBuilder(".data:\n");

        for (String data : var.keySet()) {
            dataGen.append("\t")
                    .append(getVarFor(data))
                    .append(": .asciiz ")
                    .append("\"" + data + "\"")
                    .append("\n") ;
        }

        return dataGen.toString();
    }
}
