package yal ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import yal.analyse.AnalyseurLexical;
import yal.analyse.AnalyseurSyntaxique;
import yal.arbre.ArbreAbstrait;
import yal.exceptions.AnalyseException;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.SemantiqueException;

/**
 * 24 mars 2015 
 * 
 * @author brigitte wrobel-dautcourt
 */

public class Yal {

	public Yal(String fichier) {
		try {
			AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichier)));
			ArbreAbstrait arbre = (ArbreAbstrait) analyseur.parse().value;
			System.err.println("expression stockée dans l'yal.arbre : " + arbre);

			// à écrire pour yal0
			arbre.verifier() ;

			ListeSemantiqueException liste = ListeSemantiqueException.getInstance();
			if(liste.isError()) {
				for(SemantiqueException s : liste.getListeException()) {
					System.err.println(s.getMessage());
				}
			}else {
				String fileName = fichier.substring(0,fichier.length()-4);
				PrintWriter out = new PrintWriter(fileName + ".mips");
				out.println(
						header() +
						arbre.toMIPS() +
						footer()
						);
				out.close();
				System.out.println("COMPILATION OK");
			}
		} 

		catch (FileNotFoundException ex) {
			System.err.println("Fichier " + fichier + " inexistant") ;
		}
		catch (AnalyseException ex) {
			System.err.println(ex.getMessage());
		}
		catch (Exception ex) {
			Logger.getLogger(Yal.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private String header() {
		return  ".data : \n"+
				"errdiv: 	.asciiz \"Division par zero impossible \" \n"+
				".text\n" +
				"main:\n" +
				"move $s7, $sp\n" ;
	}

	private String footer() {
		return  "\n\nend:\n" +
				"move $v1, $v0\n" +
				"li $v0, 10\n" +
				"syscall\n" ;
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Nombre incorrect d'arguments") ;
			System.err.println("\tjava -jar yal.jar <fichierSource.yal>") ;
			System.exit(1) ;
		}
		new Yal(args[0]) ;
	}

}
