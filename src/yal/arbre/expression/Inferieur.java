package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Inferieur extends Comparaison {

    public Inferieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " < ";
    }

	@Override
	public void verifier() {
		if(gauche.getType() != "int" || droite.getType() != "int") {
			System.out.println("ERREUR SEMANTIQUE: " + this.getType() + " entre un " + gauche.getType() + " et un " + droite.getType());
		}
	}

	@Override
	public String toMIPS() {
			return null;
	}

	@Override
	public String getType() {
		return "inferieur";
	}
    
}
