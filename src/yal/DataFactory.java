package yal;

import java.util.HashMap;

public class DataFactory {

    private final String VAR_NAME = "var" ;
    private final String DIV_ZERO =  "\"Division par zero impossible\"" ;
    private final String STR_TRUE =  "\"vrai\"" ;
    private final String STR_FALSE = "\"faux\"" ;

    private static DataFactory INSTANCE
            = new DataFactory() ;

    private HashMap<String, Integer> var ;
    private int cpt ;

    private DataFactory() {
        cpt = 0 ;
        var = new HashMap<>() ;
        addData(DIV_ZERO);
        addData(STR_TRUE);
        addData(STR_FALSE);
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
                    .append(data) // "data" by default
                    .append("\n") ;
        }

        return dataGen.toString();
    }

    public String getErrDiv() {
        return VAR_NAME + var.get(DIV_ZERO) ;
    }
    public String getTrue() {return VAR_NAME + var.get(STR_TRUE);}
    public String getFalse() {return VAR_NAME + var.get(STR_FALSE);}
}
