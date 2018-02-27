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
		return TYPE_IDF ;
	}

	@Override
	public void verifier() {}

	@Override
	public String toMIPS() {
		return String.join (
			"\n",
			"# recuperation de la valeur de " +  idf,
				"lw $v0, "+ TDS.getInstance()
								.identifier (idf, noLigne)
								.getPointeur()
		) ;
	}
}
