package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Plus extends BinaireArithmetique {

	public Plus(Expression gauche, Expression droite) {
		super(gauche, droite);
	}

	@Override
	public String operateur() {
		return " + " ;
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toMIPS() {
		StringBuilder s = new StringBuilder() ;
		if(gauche.getType() != "int" || droite.getType() != "int") {
			return "ERREUR SEMANTIQUE: " + this.getType() + " entre un " + gauche.getType() + " et un " + droite.getType();
		}else {
			s.append("# Evaluation de l'opérande gauche \n")
			.append(gauche.toMIPS())
			.append("\n")
			.append("# Stocke la valeur de v0 dans la mémoire \n")
			.append("sw $v0, ($sp)")
			.append("\n")
			.append("# Dépilement dans $sp \n")
			.append("addi $sp, $sp -4")
			.append("\n")
			.append("# Evaluation de l'opérande droite \n")
			.append(droite.toMIPS())
			.append("\n")
			.append("# Déplacement de sp \n")
			.append("addi $sp, $sp, +4")
			.append("\n")
			.append("lw $t8, ($sp) ")
			.append("\n")
			.append("# Ajout de t8 et v0 \n")
			.append("add $v0, $t8, $v0") ;
			return s.toString() ;
		}
	}

	@Override
	public String getType() {
		return "addition";
	}

}
