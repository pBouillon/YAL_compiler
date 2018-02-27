package yal.arbre.instruction;

import yal.tabledessymboles.TDS;

public class Lire extends Instruction {
	private String varName;

	public Lire(String _var, int no) {
		super(no);
		varName = _var ;
	}

	@Override
	public void verifier() {
	}

	@Override
	public String toMIPS() {
		return String.join("\n",
			"\t# read code",
			"\tli $v0, 5",
			"\tsyscall",
			"\t# Input is in v0",
			"\tsw $v0, " +
					TDS.getInstance()
							.identifier(varName, super.noLigne)
							.getPointeur() +
					"($s7)"
		) ;
	}

}
