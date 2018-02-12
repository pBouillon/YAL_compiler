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


csteE       = [0-9]+
csteB       = "vrai" | "faux"
csteC       = \"[a-zA-Z]+\"

entier        = "entier"
idf         = [a-zA-Z0-9]+
ecrire      = "ecrire"

finDeLigne  = \r|\n|;
espace      = {finDeLigne}  | [ \t\f]

commentaireSlashSlash = [/][/].*

%%
			
{entier}                { return symbol(CodesLexicaux.ENTIER, yytext()); }
{ecrire}                { return symbol(CodesLexicaux.ECRIRE, yytext()); }

";"                		{ return symbol(CodesLexicaux.POINTVIRGULE); }
"+"              	    { return symbol(CodesLexicaux.PLUS);  }
"-"               	    { return symbol(CodesLexicaux.MOINS); }
"*"                	    { return symbol(CodesLexicaux.MULT); }
"/"                	    { return symbol(CodesLexicaux.DIV);  }

"="                    { return symbol(CodesLexicaux.EGAL); }
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

{idf}                   { return symbol(CodesLexicaux.CONSTANTEIDF, yytext()); }


{espace}                { }

{commentaireSlashSlash} { }

{finDeLigne}            { }
.                       { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
