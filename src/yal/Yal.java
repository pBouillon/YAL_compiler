package yal ;

import yal.analyse.AnalyseurLexical;
import yal.analyse.AnalyseurSyntaxique;
import yal.arbre.ArbreAbstrait;
import yal.exceptions.AnalyseException;
import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.ReturnException;
import yal.tabledessymboles.TDS;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.exit;

/**
 * 24 mars 2015 
 * 
 * @author brigitte wrobel-dautcourt
 */

public class Yal {

	private static final String COMP_OK = "COMPILATION_OK" ;

	private static final int ARG_REQUIRED = 1 ;
	private static final int EXIT_FAILURE = 1 ;

	private static int line   = 0 ;

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

			arbre.verifier() ;

			ListeSemantiqueException liste = ListeSemantiqueException.getInstance() ;
			if (liste.isError()) {
				for(RuntimeException s : liste.getListeException()) {
					System.err.println (s.getMessage()) ;
				}
				exit(1) ;
			} else {
				String mipsCode = arbre.toMIPS() ;
				if(TDS.getInstance().containsFunc()) {
					check_ret(header() + mipsCode) ;
				}
				liste = ListeSemantiqueException.getInstance() ;
				if (liste.isError()) {
					for(RuntimeException s : liste.getListeException()) {
						System.err.println (s.getMessage()) ;
					}
					exit(1) ;
				}

				String fileName = fichier.substring (0, fichier.length() - 4) ;
				PrintWriter out = new PrintWriter (fileName + ".mips") ;
				out.println (
						header() +
						mipsCode
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

	public static void incRet(int no) {
		if (no > line) line = no ;
	}

	private void check_ret(String mips) {
		String substr = mips.substring(mips.indexOf("main:"), mips.indexOf("end:"));
		if (substr.contains("# RETOUR")) {
			ListeSemantiqueException.getInstance()
				.addException (
					new ReturnException(
						line
					)
				) ;
		}
	}

    /**
     * @return mips prog begin and data declarations
     */
	private String header() {
		return String.join (
				"\n",
				DataFactory.getInstance().genData(),
				".text:",
				"main:",
				"\tmove $s7, $sp",
				"\taddi $sp, $sp, " + TDS.getInstance().getCompteur()
		) ;
	}

	public static void main(String[] args) {
		if (args.length != ARG_REQUIRED) {
			System.err.println ("Nombre incorrect d'arguments") ;
			System.err.println ("\tjava -jar yal.jar <fichierSource.yal>") ;
			exit(EXIT_FAILURE) ;
		}
		new Yal(args[0]) ;
	}

}
