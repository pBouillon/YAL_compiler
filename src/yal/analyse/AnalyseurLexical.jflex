package yal.analyse ;

import java_cup.runtime.*;
import yal.exceptions.AnalyseLexicaleException;
      
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


csteE      = [0-9]+
csteB      = "vrai" | "faux"
csteC      = \"([^\"\n]|\\n|\"\")*\"

entier     = "entier"
idf        = [a-zA-Z0-9]+
ecrire     = "ecrire"
lire       = "lire"

tantque    = "tantque"
repeter    = "repeter"
fintantque = "fintantque"

si         = "si"
alors      = "alors"
sinon      = "sinon"
fsi        = "fsi"

programme  = "programme"
debut      = "debut"
fin        = "fin"

fonction   = "fonction"
retourne   = "retourne"

finDeLigne = \r|\n|;
espace     = {finDeLigne}  | [ \t\f]

commentaireSlashSlash = [/][/].*

crochOuvr = "["
crochFer  = "]"
point     = "\."
longueur  = "longueur"

%%
{entier}                { return symbol(CodesLexicaux.ENTIER, yytext()); }
{ecrire}                { return symbol(CodesLexicaux.ECRIRE, yytext()); }
{lire}                  { return symbol(CodesLexicaux.LIRE, yytext()); }

{si}                    { return symbol(CodesLexicaux.SI, yytext()); }
{alors}                 { return symbol(CodesLexicaux.ALORS, yytext()); }
{sinon}                 { return symbol(CodesLexicaux.SINON, yytext()); }
{fsi}                 	{ return symbol(CodesLexicaux.FSI, yytext()); }

{tantque}               { return symbol(CodesLexicaux.TANTQUE, yytext()); }
{repeter}               { return symbol(CodesLexicaux.REPETER, yytext()); }
{fintantque}            { return symbol(CodesLexicaux.FINTANTQUE, yytext()); }

{programme}             { return symbol(CodesLexicaux.PROGRAMME, yytext()); }
{fonction}              { return symbol(CodesLexicaux.FONCTION, yytext()); }
{debut}                 { return symbol(CodesLexicaux.DEBUT, yytext()); }
{fin}                   { return symbol(CodesLexicaux.FIN, yytext()); }

{fonction}              { return symbol(CodesLexicaux.FONCTION, yytext()); }
{retourne}              { return symbol(CodesLexicaux.RETOURNE, yytext()); }

";"                		{ return symbol(CodesLexicaux.POINTVIRGULE); }
","                		{ return symbol(CodesLexicaux.VIRGULE); }

"+"              	    { return symbol(CodesLexicaux.PLUS);  }
"-"               	    { return symbol(CodesLexicaux.MOINS); }
"*"                	    { return symbol(CodesLexicaux.MULT);  }
"/"                	    { return symbol(CodesLexicaux.DIV);   }

"="                     { return symbol(CodesLexicaux.EGAL); }
"=="                    { return symbol(CodesLexicaux.EGALEGAL); }
"!="                    { return symbol(CodesLexicaux.DIFF); }
"<"                	    { return symbol(CodesLexicaux.INF);  }
">"                	    { return symbol(CodesLexicaux.SUP);  }

"et"                	{ return symbol(CodesLexicaux.ET);  }
"ou"                	{ return symbol(CodesLexicaux.OU);  }
"non"                	{ return symbol(CodesLexicaux.NON); }

"("                	    { return symbol(CodesLexicaux.PAROUV); }
")"              	    { return symbol(CodesLexicaux.PARFER); }

{csteB}      	        { return symbol(CodesLexicaux.CONSTANTEBOOL, yytext());   }
{csteC}      	        { return symbol(CodesLexicaux.CONSTANTECHAINE, yytext()); }
{csteE}      	        { return symbol(CodesLexicaux.CONSTANTEINT, yytext());    }

{idf}                   { return symbol(CodesLexicaux.IDF, yytext()); }

{espace}                { }

{commentaireSlashSlash} { }

{finDeLigne}            { }

{crochOuvr}             { return symbol(CodesLexicaux.CROCH_OUVR, yytext()) ; }
{crochFer}              { return symbol(CodesLexicaux.CROCH_FER, yytext()) ;  }
{point}                 { return symbol(CodesLexicaux.POINT, yytext()) ;      }
{longueur}              { return symbol(CodesLexicaux.LONGUEUR, yytext()) ;   }

.                       { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
