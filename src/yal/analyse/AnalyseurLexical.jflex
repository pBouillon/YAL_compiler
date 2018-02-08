package yal.yal.analyse ;

import java_cup.runtime.*;
import yal.yal.exceptions.AnalyseLexicaleException;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}


csteE = [0-9]+
csteB = "vrai" | "faux"

finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]

%state commentaire

commentaireSlashSlash = [/][/].*
commentaireSlashEtoile = [/][*]
commentaireEtoileSlash = [*][/]

%%

<YYINITIAL>{commentaireSlashSlash} 	{ }
					// je ne fais rien, tous les caractères sont jetés

<YYINITIAL>{commentaireSlashEtoile}	{ yybegin(commentaire) ; }
					// je change d’état - début du commentaire

<commentaire> {commentaireEtoileSlash} 	{ yybegin(YYINITIAL) ; }
					// fin du commentaire
					
<YYINITIAL>{"+"}              	{ return symbol(CodesLexicaux.PLUS); }
<YYINITIAL>{"-"}               	{ return symbol(CodesLexicaux.MOINS); }
<YYINITIAL>{"*"}                	{ return symbol(CodesLexicaux.MULT); }
<YYINITIAL>{"/"}                	{ return symbol(CodesLexicaux.DIV); }

<YYINITIAL>{"=="}                    { return symbol(CodesLexicaux.EGALEGAL); }
<YYINITIAL>{"!="}                    { return symbol(CodesLexicaux.DIFF); }
<YYINITIAL>{"<"}                	{ return symbol(CodesLexicaux.INF); }
<YYINITIAL>{">"}                	{ return symbol(CodesLexicaux.SUP); }

<YYINITIAL>{"et"}                	{ return symbol(CodesLexicaux.ET); }
<YYINITIAL>{"ou"}                	{ return symbol(CodesLexicaux.OU); }
<YYINITIAL>{"non"}                	{ return symbol(CodesLexicaux.NON); }

<YYINITIAL>{"("}                	{ return symbol(CodesLexicaux.PAROUV); }
<YYINITIAL>{")"}              	{ return symbol(CodesLexicaux.PARFER); }

<YYINITIAL>{csteE}      	        { return symbol(CodesLexicaux.CONSTANTEINT, yytext()); }
<YYINITIAL>{csteB}      	        { return symbol(CodesLexicaux.CONSTANTEBOOL, yytext()); }

<YYINITIAL>{espace}                { }

.                       { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
