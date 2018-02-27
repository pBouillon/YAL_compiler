package yal.arbre.instruction;

import yal.arbre.BlocDInstructions;
import yal.arbre.expression.Expression;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;

public class Boucle extends Instruction {
	Expression condition;
	BlocDInstructions instr ;

	public Boucle(Expression _cond, BlocDInstructions _instr, int no) {
		super(no);
		condition = _cond ;
		instr = _instr ;
	}

	@Override
	public void verifier() {
		if (condition.getType().equals(TYPE_BOOLEAN)) return ;

		ListeSemantiqueException
				.getInstance()
				.addException(
						new SemantiqueException(
								super.noLigne,
								"Expression booléenne attendue"
						)) ;
	}

	@Override
	public String toMIPS() {
		return String.join (
				"\n",
				"\t# Debut tantque ...",

				"\t# Evaluation de la condition",
				et.getEvalTantQue() + ":",
				"\t" + condition.toMIPS(),
				"\tbeqz $v0, " + et.getNextTantQue(),
				"\tj " + et.getNextFTantQue(),

				"\t# corps de la boucle",
				et.getTantQue() + ":",
				instr.toMIPS(),
				"\tj " + et.getPrevEvalTantQue(),

				"\t# fin de la boucle",
				et.getFTantQue() + ":"
		) ;
	}
}
