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
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		if(gauche.getType() != "int" || droite.getType() != "int") {
			return "ERREUR SEMANTIQUE: " + this.getType() + " entre un " + gauche.getType() + " et un " + droite.getType();
		}else {
			return null;
		}
	}

	@Override
	public String getType() {
		return "inferieur";
	}
    
}
