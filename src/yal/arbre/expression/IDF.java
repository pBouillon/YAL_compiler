package yal.arbre.expression;

import yal.tabledessymboles.TDS;

public class IDF extends Expression{
	
	private String idf;

	public IDF(String i, int n) {
		super(n);
		idf = i;
	}

	@Override
	public String getType() {
		return "idf";
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		return  "# recuperation de la valeur de " +  idf +" \n" +
        		"sw $v0, "+ TDS.getInstance().identifier(idf, this.noLigne).getPointeur() +"($s7) \n";
    
	}
	
	

}
