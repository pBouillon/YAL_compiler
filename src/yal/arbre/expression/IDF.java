package yal.arbre.expression;

import yal.tabledessymboles.Entry;
import yal.tabledessymboles.TDS;
import yal.tabledessymboles.TDSv2;
import yal.tabledessymboles.VarEntry;

public class IDF extends Expression{
	
	private String idf;
	private Entry entry ;
	boolean exist ;
	int noRegion ;

	public IDF(String i, int n) {
		super(n);
		idf = i;
		entry = new VarEntry(i, "VAR") ;
		noRegion = TDSv2.getInstance().getCurrentRegion() ;
	}

	@Override
	public String getType() {
		return TYPE_IDF ;
	}

	@Override
	public void verifier() {
		exist = TDSv2.getInstance().varExists(entry, noRegion) ;
		TDS.getInstance().identifier(idf, noLigne);
	}

	@Override
	public String toMIPS() {
		return String.join (
			"\n",
			"# recuperation de la valeur de " +  idf,
				"lw $v0, "+ TDS.getInstance()
								.identifier (idf, noLigne)
								.getPointeur()+"($s7) \n"
		) ;
	}
}
