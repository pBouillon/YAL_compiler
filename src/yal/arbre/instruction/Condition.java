package yal.arbre.instruction;

import yal.arbre.BlocDInstructions;
import yal.arbre.expression.Expression;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;

public class Condition extends Instruction {
	private Expression 		  condition ;
	private BlocDInstructions si ;
	private BlocDInstructions sinon ;

	public Condition(
			Expression _cond,
			BlocDInstructions _si,
			BlocDInstructions _sinon,
			int no) {
		super(no);
		condition = _cond ;
		sinon = _sinon ;
		si    = _si ;
	}
	
	// Constructeur de Condition sans instruction dans le si
	public Condition(
			Expression _cond,
			BlocDInstructions _sinon,
			int no) {
		super(no);
		condition = _cond ;
		sinon = _sinon ;
	}

	@Override
	public void verifier() {
		if (condition.getType().equals(TYPE_BOOLEAN)) return ;

		ListeSemantiqueException
				.getInstance()
				.addException(
					new SemantiqueException (
							super.noLigne,
							"Expression booléenne attendue"
				)) ;
	}

	@Override
	public String toMIPS() {
		String blocSinon = (sinon != null) ? sinon.toMIPS()
										   : "" ;

		String blocSi = (si != null) ? si.toMIPS()
									  : "" ;
		return String.join (
			"\n",
			"\t# debut du si .. sinon ..",

			"\t# si",
			et.getSi() + ": ",
			"\t" + condition.toMIPS(),
			"\tbeqz $v0, " + et.getNextSinon(),

			"\t# alors",
			et.getAlors() + ":",
			"\t" + blocSi,
			"\tj " + et.getNextFsi(),

			"\t# sinon",
			et.getSinon() + ":",
			"\t" + blocSinon,

			et.getFsi() + ":",
			"\t# fin du si .. sinon .."
		) ;
	}

}
