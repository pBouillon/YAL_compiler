package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class OuLogique extends BinaireLogique {

	public OuLogique(Expression gauche, Expression droite) {
		super(gauche, droite);
	}

	@Override
	public String operateur() {
		return " ou " ;
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toMIPS() {
		if(gauche.getType() != "boolean" || droite.getType() != "boolean") {
			return "ERREUR SEMANTIQUE: " + this.getType() + " entre un " + gauche.getType() + " et un " + droite.getType();
		}else {
			return "# Evaluation de l'opérande gauche \n" +
					gauche.toMIPS() + "\n" + 
					"# Stocke la valeur de v0 dans la mémoire \n" +
					"sw $v0, ($sp) \n" +
					"# Dépilement dans $sp \n" +
					"addi $sp, $sp -4 \n" +
					"# Evaluation de l'opérande droite \n" +
					droite.toMIPS() + "\n" +
					"# Déplacement de sp \n" +
					"addi $sp, $sp, +4 \n" +
					"lw $t8, ($sp) \n" +
					"# comparaison de t8 ou v0  \n" +
					"or $v0, $t8, $v0\n" ;
		}
	}
	@Override
	public String getType() {
		return "ou logique";
	}

}
