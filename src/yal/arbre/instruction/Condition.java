package yal.arbre.instruction;

import yal.EtiquetteFactory;
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

	@Override
	public void verifier() {
		if (condition.getType().equals("boolean")) return ;

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
		EtiquetteFactory et = EtiquetteFactory.getInstance() ;

		String blocSinon = (sinon != null) ? sinon.toMIPS()
										   : "" ;

		String blocSi = (si != null) ? si.toMIPS()
									  : "" ;
		return String.join (
				"\n",
				"\t# debut du si .. sinon ..",

				"\t#SI",
				et.getSi() + ": ",
				"\t" + condition.toMIPS(),
				"\tbeqz $v0, " + et.getNextSinon(),

				"\t# ALORS",
				et.getAlors() + ":",
				"\t" + blocSi,
				"\tj " + et.getNextFsi(),

				"\t# SINON",
				et.getSinon() + ":",
				"\t" + blocSinon,

				et.getFsi() + ":",
				"\t# fin du si .. sinon .."
				) ;
	}

}
