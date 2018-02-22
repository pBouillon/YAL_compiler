package yal.arbre.expression;

public class IDF extends Expression{
	
	private String idf;

	public IDF(String i, int n) {
		super(n);
		idf = i;
	}

	@Override
	public String getType() {
		return "idf";
	}

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
