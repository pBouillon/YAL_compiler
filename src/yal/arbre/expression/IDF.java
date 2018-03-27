package yal.arbre.expression;

import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;
import yal.tabledessymboles.Entry;
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
		if (!exist) {
			ListeSemantiqueException.getInstance()
					.addException(
							new SemantiqueException(noLigne, idf + ": Var non déclarée")
					);
		}
	}

	@Override
	public String toMIPS() {
		return String.join (
			"\n",
			"\t# recuperation de la valeur de " +  idf,
				TDSv2.getInstance().identifierVar(entry),
				"\tlw $v0, ($s2)"
		) ;
	}
}
