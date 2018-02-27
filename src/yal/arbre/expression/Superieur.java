package yal.arbre.expression;

import yal.EtiquetteFactory;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Superieur extends Comparaison {

	public Superieur(Expression gauche, Expression droite) {
		super(gauche, droite);
	}

	@Override
	public String operateur() {
		return " > ";
	}

	@Override
	public String toMIPS() {
		return gauche.toMIPS() +
				"sw $v0, ($sp)\n" +
				"addi $sp, $sp -4\n" +
				droite.toMIPS() +
				"addi $sp, $sp, +4\n" +
				"lw $t8, ($sp)\n" +
				"sub $v0, $t8, $v0\n" +
				"bltz $v0,"+EtiquetteFactory.getInstance().getNextSiInf()+"\n" +
				"j "+ EtiquetteFactory.getInstance().getNextSiNonInf() +"\n" +
				EtiquetteFactory.getInstance().getSiInf()+": \n" +
				"li $v0, 1\n" +
				"j "+EtiquetteFactory.getInstance().getNextFinSiInf()+"\n" +
				EtiquetteFactory.getInstance().getSiNonInf()+":\n" +
				"li $v0, 0\n" +
				EtiquetteFactory.getInstance().getFinSiInf()+ ":\n";

//		return gauche.toMIPS() +
//				"sw $v0, ($sp)\n" +
//				"addi $sp, $sp -4\n" +
//				droite.toMIPS() +
//				"addi $sp, $sp, +4\n" +
//				"lw $t8, ($sp)\n" +
//				"# stockage de $v0 - $t8 dans $v0\n" +
//				"sub $v0, $t8, $v0\n" +
//				"# teste si $v0 - $t8 > 0\n" +
//                "bgtz $v0, " + EtiquetteFactory.getInstance().getNextSiSup() + "\n" +
//				"#Si resultat non superieur, va a l'etiquette sinonSup\n" +
//                "j " + EtiquetteFactory.getInstance().getNextSiNonSup() + "\n" +
//				EtiquetteFactory.getInstance().getSiSup() + ": \n" +
//                "li $v0, 1\n"  +
//                "j " + EtiquetteFactory.getInstance().getNextFinSiSup() + "\n" +
//				EtiquetteFactory.getInstance().getSiNonSup() + ":\n"  +
//                "li $v0, 0\n"  +
//				EtiquetteFactory.getInstance().getFinSiSup() + ":\n";
	}


	@Override
	public String getType() {
		return "boolean";
	}

}
