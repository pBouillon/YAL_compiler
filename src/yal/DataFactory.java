package yal;

import java.util.HashMap;

public class DataFactory {

    private final String VAR_PREFIX = "var" ;
    private final String DIV_ZERO =  "\"Division par zero impossible\"" ;
    private final String STR_TRUE =  "\"vrai\"" ;
    private final String STR_FALSE = "\"faux\"" ;

    private static DataFactory INSTANCE
            = new DataFactory() ;

    private HashMap<Integer, String> varName ;
    private HashMap<Integer, Integer> varCpt ;
    private int cpt ;

    private DataFactory() {
        cpt = 0 ;
        varName = new HashMap<>() ;
        varCpt = new HashMap<>()  ;
        addData(DIV_ZERO) ;
        addData(STR_TRUE) ;
        addData(STR_FALSE);
    }

    public static DataFactory getInstance() {
        return INSTANCE ;
    }

    public void addData(String data) {
        int key = getKeyStr(data) ;

        if (varName.containsKey(key)) {
            return ;
        }

        varName.put(key, data) ;
        varCpt.put(key, cpt++) ;
    }

    /**
     * @param data string
     * @return VAR_PREFIX + nb
     */
    public String getVarFor(String data) {
        return VAR_PREFIX + varCpt.get(getKeyStr(data)) ;
    }

    private int getKeyStr(String str) {
        int key = 0 ;
        for (int i = 0; i < str.length(); ++i) {
            key += (int)str.charAt(i) ;
        }

        return key + str.length() ;
    }

    String genData() {
        StringBuilder dataGen = new StringBuilder(".data:\n");

        for (String data : varName.values()) {
            dataGen.append("\t")
                    .append(getVarFor(data))
                    .append(": .asciiz ")
                    .append(data) // "data" by default
                    .append("\n") ;
        }

        return dataGen.toString();
    }

    public String getErrDiv() {
        return VAR_PREFIX + varCpt.get(getKeyStr(DIV_ZERO)) ;
    }
    public String getTrue() {return VAR_PREFIX + varCpt.get(getKeyStr(STR_TRUE));}
    public String getFalse() {return VAR_PREFIX + varCpt.get(getKeyStr(STR_FALSE));}
}
