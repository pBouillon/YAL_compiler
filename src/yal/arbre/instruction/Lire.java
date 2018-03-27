package yal.arbre.instruction;

import yal.tabledessymboles.TDS;
import yal.tabledessymboles.TDSv2;
import yal.tabledessymboles.VarEntry;

public class Lire extends Instruction {
	private String varName;

	public Lire(String _var, int no) {
		super(no);
		varName = _var ;
	}

	@Override
	public void verifier() {
		TDS.getInstance().identifier(varName, noLigne);
	}

	@Override
	public String toMIPS() {
		return String.join("\n",
			"\t# read code",
			"\tli $v0, 5",
			"\tsyscall",
			TDSv2.getInstance().identifierVar(new VarEntry(varName, "VAR")),
			
			"\tsw $v0, ($s2)"
		) ;
	}
}
