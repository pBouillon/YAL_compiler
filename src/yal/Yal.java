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

	private static final String COMP_OK = "COMPILATION_OK" ;

	private static final int ARG_REQUIRED = 1 ;
	private static final int EXIT_FAILURE = 1 ;


    /**
     * References Yal
     * @param fichier .yal to compile
     */
	private Yal (String fichier) {
		try {
			AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(
					new AnalyseurLexical (
							new FileReader(fichier)
					)
			) ;
			ArbreAbstrait arbre = (ArbreAbstrait) analyseur.parse().value ;
			System.err.println ("expression stockée dans l'yal.arbre : " + arbre) ;

			arbre.verifier() ;

			ListeSemantiqueException liste = ListeSemantiqueException.getInstance() ;
			if (liste.isError()) {
				for(RuntimeException s : liste.getListeException()) {
					System.err.println (s.getMessage()) ;
				}
			} else {
				String fileName = fichier.substring (0, fichier.length() - 4) ;
				PrintWriter out = new PrintWriter (fileName + ".mips") ;
				out.println (
						header() +
						arbre.toMIPS() +
						footer()
					) ;
				out.close() ;
				System.out.println (COMP_OK) ;
			}
		} 

		catch (FileNotFoundException ex) {
			System.err.println ("Fichier " + fichier + " inexistant") ;
		}
		catch (AnalyseException ex) {
			System.err.println(ex.getMessage());
		}
		catch (Exception ex) {
			Logger.getLogger (Yal.class.getName())
					.log(Level.SEVERE, null, ex) ;
		}
	}

    /**
     * @return mips prog begin and data declarations
     */
	private String header() {
		return  ".data : \n"+
				"errdiv: 	.asciiz \"Division par zero impossible\" \n"+
				".text\n" +
				"main:\n" +
				"move $s7, $sp\n" ;
	}

    /**
     * @return mips clean ending and storage in $v1
     */
	private String footer() {
		return  "\n\nend:\n" +
				"move $v1, $v0\n" +
				"li $v0, 10\n" +
				"syscall\n" ;
	}

	public static void main(String[] args) {
		if (args.length != ARG_REQUIRED) {
			System.err.println ("Nombre incorrect d'arguments") ;
			System.err.println ("\tjava -jar yal.jar <fichierSource.yal>") ;
			System.exit(EXIT_FAILURE) ;
		}
		new Yal(args[0]) ;
	}

}
