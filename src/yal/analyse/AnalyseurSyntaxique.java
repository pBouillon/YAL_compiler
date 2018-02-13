
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Tue Feb 13 15:35:23 CET 2018
//----------------------------------------------------

package yal.analyse;

import java.util.*;
import yal.arbre.*;
import yal.arbre.expression.*;
import yal.arbre.instruction.*;
import yal.exceptions.AnalyseSyntaxiqueException;
import yal.tabledessymboles.*;
import java_cup.runtime.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Tue Feb 13 15:35:23 CET 2018
  */
public class AnalyseurSyntaxique extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalyseurSyntaxique() {super();}

  /** Constructor which sets the default scanner. */
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\034\000\002\002\004\000\002\002\003\000\002\012" +
    "\003\000\002\012\004\000\002\006\003\000\002\007\004" +
    "\000\002\010\005\000\002\004\005\000\002\004\005\000" +
    "\002\004\005\000\002\004\005\000\002\004\005\000\002" +
    "\004\005\000\002\004\005\000\002\004\005\000\002\004" +
    "\004\000\002\004\005\000\002\004\005\000\002\004\004" +
    "\000\002\004\003\000\002\004\005\000\002\003\004\000" +
    "\002\003\004\000\002\003\004\000\002\011\004\000\002" +
    "\011\004\000\002\005\003\000\002\005\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\063\000\010\023\005\027\011\030\004\001\002\000" +
    "\016\005\027\010\033\021\032\024\026\025\031\026\065" +
    "\001\002\000\004\022\024\001\002\000\004\002\023\001" +
    "\002\000\004\012\022\001\002\000\012\002\uffff\023\uffff" +
    "\027\uffff\030\uffff\001\002\000\004\023\021\001\002\000" +
    "\004\012\020\001\002\000\004\012\017\001\002\000\004" +
    "\012\ufffd\001\002\000\012\002\000\023\005\027\011\030" +
    "\004\001\002\000\012\002\ufffe\023\ufffe\027\ufffe\030\ufffe" +
    "\001\002\000\012\002\uffea\023\uffea\027\uffea\030\uffea\001" +
    "\002\000\012\002\uffec\023\uffec\027\uffec\030\uffec\001\002" +
    "\000\004\012\ufffc\001\002\000\012\002\uffeb\023\uffeb\027" +
    "\uffeb\030\uffeb\001\002\000\004\002\001\001\002\000\014" +
    "\005\027\010\033\021\032\024\026\025\031\001\002\000" +
    "\030\004\040\005\045\006\036\007\041\012\ufffb\013\046" +
    "\014\042\015\047\016\043\017\037\020\044\001\002\000" +
    "\032\004\uffe7\005\uffe7\006\uffe7\007\uffe7\011\uffe7\012\uffe7" +
    "\013\uffe7\014\uffe7\015\uffe7\016\uffe7\017\uffe7\020\uffe7\001" +
    "\002\000\014\005\027\010\033\021\032\024\026\025\031" +
    "\001\002\000\032\004\uffee\005\uffee\006\uffee\007\uffee\011" +
    "\uffee\012\uffee\013\uffee\014\uffee\015\uffee\016\uffee\017\uffee" +
    "\020\uffee\001\002\000\032\004\uffe6\005\uffe6\006\uffe6\007" +
    "\uffe6\011\uffe6\012\uffe6\013\uffe6\014\uffe6\015\uffe6\016\uffe6" +
    "\017\uffe6\020\uffe6\001\002\000\014\005\027\010\033\021" +
    "\032\024\026\025\031\001\002\000\014\005\027\010\033" +
    "\021\032\024\026\025\031\001\002\000\030\004\040\005" +
    "\045\006\036\007\041\011\035\013\046\014\042\015\047" +
    "\016\043\017\037\020\044\001\002\000\032\004\uffed\005" +
    "\uffed\006\uffed\007\uffed\011\uffed\012\uffed\013\uffed\014\uffed" +
    "\015\uffed\016\uffed\017\uffed\020\uffed\001\002\000\014\005" +
    "\027\010\033\021\032\024\026\025\031\001\002\000\014" +
    "\005\027\010\033\021\032\024\026\025\031\001\002\000" +
    "\014\005\027\010\033\021\032\024\026\025\031\001\002" +
    "\000\014\005\027\010\033\021\032\024\026\025\031\001" +
    "\002\000\014\005\027\010\033\021\032\024\026\025\031" +
    "\001\002\000\014\005\027\010\033\021\032\024\026\025" +
    "\031\001\002\000\014\005\027\010\033\021\032\024\026" +
    "\025\031\001\002\000\014\005\027\010\033\021\032\024" +
    "\026\025\031\001\002\000\014\005\027\010\033\021\032" +
    "\024\026\025\031\001\002\000\014\005\027\010\033\021" +
    "\032\024\026\025\031\001\002\000\032\004\040\005\045" +
    "\006\036\007\041\011\ufff4\012\ufff4\013\046\014\042\015" +
    "\ufff4\016\ufff4\017\ufff4\020\ufff4\001\002\000\032\004\040" +
    "\005\045\006\036\007\041\011\ufff5\012\ufff5\013\ufff5\014" +
    "\ufff5\015\ufff5\016\ufff5\017\ufff5\020\ufff5\001\002\000\032" +
    "\004\ufff9\005\ufff9\006\036\007\041\011\ufff9\012\ufff9\013" +
    "\ufff9\014\ufff9\015\ufff9\016\ufff9\017\ufff9\020\ufff9\001\002" +
    "\000\032\004\040\005\045\006\036\007\041\011\ufff0\012" +
    "\ufff0\013\046\014\042\015\047\016\043\017\037\020\ufff0" +
    "\001\002\000\032\004\040\005\045\006\036\007\041\011" +
    "\ufff3\012\ufff3\013\046\014\042\015\ufff3\016\ufff3\017\ufff3" +
    "\020\ufff3\001\002\000\032\004\040\005\045\006\036\007" +
    "\041\011\ufff6\012\ufff6\013\ufff6\014\ufff6\015\ufff6\016\ufff6" +
    "\017\ufff6\020\ufff6\001\002\000\032\004\ufff7\005\ufff7\006" +
    "\ufff7\007\ufff7\011\ufff7\012\ufff7\013\ufff7\014\ufff7\015\ufff7" +
    "\016\ufff7\017\ufff7\020\ufff7\001\002\000\032\004\ufffa\005" +
    "\ufffa\006\036\007\041\011\ufffa\012\ufffa\013\ufffa\014\ufffa" +
    "\015\ufffa\016\ufffa\017\ufffa\020\ufffa\001\002\000\032\004" +
    "\040\005\045\006\036\007\041\011\ufff1\012\ufff1\013\046" +
    "\014\042\015\047\016\043\017\ufff1\020\ufff1\001\002\000" +
    "\032\004\ufff8\005\ufff8\006\ufff8\007\ufff8\011\ufff8\012\ufff8" +
    "\013\ufff8\014\ufff8\015\ufff8\016\ufff8\017\ufff8\020\ufff8\001" +
    "\002\000\032\004\uffef\005\uffef\006\uffef\007\uffef\011\uffef" +
    "\012\uffef\013\uffef\014\uffef\015\uffef\016\uffef\017\uffef\020" +
    "\uffef\001\002\000\032\004\ufff2\005\ufff2\006\036\007\041" +
    "\011\ufff2\012\ufff2\013\ufff2\014\ufff2\015\ufff2\016\ufff2\017" +
    "\ufff2\020\ufff2\001\002\000\030\004\040\005\045\006\036" +
    "\007\041\012\uffe9\013\046\014\042\015\047\016\043\017" +
    "\037\020\044\001\002\000\004\012\uffe8\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\063\000\020\002\005\003\007\006\012\007\013\010" +
    "\006\011\011\012\014\001\001\000\006\004\063\005\027" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\014\003\015\006" +
    "\012\007\013\010\006\011\011\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\006\004\024\005\027" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\004" +
    "\062\005\027\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\004\061\005\027\001\001\000\006\004\033\005" +
    "\027\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\004\060\005\027\001\001\000\006\004\057\005\027\001" +
    "\001\000\006\004\056\005\027\001\001\000\006\004\055" +
    "\005\027\001\001\000\006\004\054\005\027\001\001\000" +
    "\006\004\053\005\027\001\001\000\006\004\052\005\027" +
    "\001\001\000\006\004\051\005\027\001\001\000\006\004" +
    "\050\005\027\001\001\000\006\004\047\005\027\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalyseurSyntaxique$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalyseurSyntaxique$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalyseurSyntaxique$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    public void report_error(String message, Object info) {

        HashMap<Integer, String> lesTerminaux = new HashMap<>() ;
    
        lesTerminaux.put(new Integer(CodesLexicaux.PLUS), "+") ;
        lesTerminaux.put(new Integer(CodesLexicaux.MOINS), "-") ;
        lesTerminaux.put(new Integer(CodesLexicaux.MULT), "*") ;
        lesTerminaux.put(new Integer(CodesLexicaux.DIV), "/") ;
        lesTerminaux.put(new Integer(CodesLexicaux.PAROUV), "(") ;
        lesTerminaux.put(new Integer(CodesLexicaux.PARFER), ")") ;
        lesTerminaux.put(new Integer(CodesLexicaux.SUP), ">") ;
        lesTerminaux.put(new Integer(CodesLexicaux.INF), "<") ;
        lesTerminaux.put(new Integer(CodesLexicaux.EGALEGAL), "==") ;
        lesTerminaux.put(new Integer(CodesLexicaux.DIFF), "!=") ;
        lesTerminaux.put(new Integer(CodesLexicaux.ET), "et") ;
        lesTerminaux.put(new Integer(CodesLexicaux.OU), "ou") ;
        lesTerminaux.put(new Integer(CodesLexicaux.NON), "non") ;

        StringBuffer m = new StringBuffer() ;

        if (info instanceof java_cup.runtime.Symbol) {
            java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);

            if (s.left >= 0) {                
                m.append("\tligne : " + (s.left + 1)) ;
                if (s.right >= 0)                    
                    m.append(" colonne : " + (s.right+1)) ;
            }
            
            if (s.value != null) {
                lesTerminaux.put(CodesLexicaux.CONSTANTEINT, "" + s.value) ;
                lesTerminaux.put(CodesLexicaux.CONSTANTEBOOL, "" + s.value) ;
            }

            if (lesTerminaux.containsKey(new Integer(s.sym))) {
                m.append(" dernier token lu : " + lesTerminaux.get(new Integer(s.sym))) ;
            }
            else {
                m.append(" expression non terminée") ;
            }

        }
        throw new AnalyseSyntaxiqueException("" + m) ;
    }

    public void report_fatal_error(String message, Object info) {
        report_error(message, info);
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalyseurSyntaxique$actions {

 
             
  private final AnalyseurSyntaxique parser;

  /** Constructor */
  CUP$AnalyseurSyntaxique$actions(AnalyseurSyntaxique parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$AnalyseurSyntaxique$do_action(
    int                        CUP$AnalyseurSyntaxique$act_num,
    java_cup.runtime.lr_parser CUP$AnalyseurSyntaxique$parser,
    java.util.Stack            CUP$AnalyseurSyntaxique$stack,
    int                        CUP$AnalyseurSyntaxique$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalyseurSyntaxique$result;

      /* select the action based on the action number */
      switch (CUP$AnalyseurSyntaxique$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // CSTE ::= CONSTANTEBOOL 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new ConstanteBool(e, eleft+1) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("CSTE",3, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // CSTE ::= CONSTANTEINT 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new ConstanteEntiere(e, eleft+1) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("CSTE",3, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // PRINT ::= ECRIRE CONSTANTECHAINE 
            {
              Instruction RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		  RESULT = new EcrireChaine(c,cleft+1) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("PRINT",7, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // PRINT ::= ECRIRE EXPR 
            {
              Instruction RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		  RESULT = new EcrireExpr(e,eleft+1) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("PRINT",7, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // INSTR ::= DECLARATION POINTVIRGULE 
            {
              Instruction RESULT =null;

              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("INSTR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // INSTR ::= AFFECT POINTVIRGULE 
            {
              Instruction RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		Instruction a = (Instruction)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		 RESULT = a ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("INSTR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // INSTR ::= PRINT POINTVIRGULE 
            {
              Instruction RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		Instruction p = (Instruction)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		 RESULT = p ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("INSTR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // EXPR ::= PAROUV EXPR PARFER 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		 RESULT = e ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // EXPR ::= CSTE 
            {
              Expression RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression c = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = c ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // EXPR ::= NON EXPR 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new NonLogique(e); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // EXPR ::= EXPR OU EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new OuLogique(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // EXPR ::= EXPR ET EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new EtLogique(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // EXPR ::= MOINS EXPR 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new MoinsUnaire(e); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EXPR ::= EXPR DIFF EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Different(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EXPR ::= EXPR EGALEGAL EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Egal(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // EXPR ::= EXPR SUP EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Superieur(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // EXPR ::= EXPR INF EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Inferieur(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // EXPR ::= EXPR DIV EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Div(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // EXPR ::= EXPR MULT EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Mult(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // EXPR ::= EXPR MOINS EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Moins(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // EXPR ::= EXPR PLUS EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Plus(g, d) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // AFFECT ::= IDF EGAL EXPR 
            {
              Instruction RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		  RESULT = new Affectation(i,e,eleft+1);  
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("AFFECT",6, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // DECL_VAR ::= ENTIER IDF 
            {
              Instruction RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		  TDS.getInstance().ajouter(new Entree(i), new Symbole(),ileft+1); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("DECL_VAR",5, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // DECLARATION ::= DECL_VAR 
            {
              Instruction RESULT =null;

              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("DECLARATION",4, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // LINSTR ::= LINSTR INSTR 
            {
              BlocDInstructions RESULT =null;
		int lileft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int liright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		BlocDInstructions li = (BlocDInstructions)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Instruction e = (Instruction)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 	li.ajouter(e) ;
                	RESULT = li ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("LINSTR",8, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // LINSTR ::= INSTR 
            {
              BlocDInstructions RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Instruction e = (Instruction)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		  BlocDInstructions bloc = new BlocDInstructions(eleft+1) ;
                	bloc.ajouter(e) ;
                	RESULT = bloc ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("LINSTR",8, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // PROG ::= LINSTR 
            {
              ArbreAbstrait RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		BlocDInstructions e = (BlocDInstructions)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		   RESULT = e; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("PROG",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= PROG EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		ArbreAbstrait start_val = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		RESULT = start_val;
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalyseurSyntaxique$parser.done_parsing();
          return CUP$AnalyseurSyntaxique$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

