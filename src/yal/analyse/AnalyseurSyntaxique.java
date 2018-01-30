
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Mon Jan 29 13:00:51 CET 2018
//----------------------------------------------------

package yal.analyse;

import java.util.*;
import yal.arbre.*;
import yal.arbre.expression.*;
import yal.exceptions.AnalyseSyntaxiqueException;
import java_cup.runtime.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Mon Jan 29 13:00:51 CET 2018
  */
public class AnalyseurSyntaxique extends java_cup.runtime.lr_parser {

  /** Default constructor.*/
  public AnalyseurSyntaxique() {super();}

  /** Constructor which sets the default scanner. */
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\022\000\002\002\004\000\002\002\003\000\002\003" +
    "\005\000\002\003\005\000\002\003\005\000\002\003\005" +
    "\000\002\003\005\000\002\003\005\000\002\003\005\000" +
    "\002\003\005\000\002\003\004\000\002\003\005\000\002" +
    "\003\005\000\002\003\004\000\002\003\003\000\002\003" +
    "\005\000\002\004\003\000\002\004\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\042\000\014\005\010\010\013\020\012\021\007\022" +
    "\011\001\002\000\004\002\044\001\002\000\030\002\000" +
    "\004\020\005\024\006\016\007\021\012\026\013\022\014" +
    "\027\015\023\016\017\017\025\001\002\000\032\002\ufff3" +
    "\004\ufff3\005\ufff3\006\ufff3\007\ufff3\011\ufff3\012\ufff3\013" +
    "\ufff3\014\ufff3\015\ufff3\016\ufff3\017\ufff3\001\002\000\032" +
    "\002\ufff1\004\ufff1\005\ufff1\006\ufff1\007\ufff1\011\ufff1\012" +
    "\ufff1\013\ufff1\014\ufff1\015\ufff1\016\ufff1\017\ufff1\001\002" +
    "\000\014\005\010\010\013\020\012\021\007\022\011\001" +
    "\002\000\032\002\ufff0\004\ufff0\005\ufff0\006\ufff0\007\ufff0" +
    "\011\ufff0\012\ufff0\013\ufff0\014\ufff0\015\ufff0\016\ufff0\017" +
    "\ufff0\001\002\000\014\005\010\010\013\020\012\021\007" +
    "\022\011\001\002\000\014\005\010\010\013\020\012\021" +
    "\007\022\011\001\002\000\030\004\020\005\024\006\016" +
    "\007\021\011\015\012\026\013\022\014\027\015\023\016" +
    "\017\017\025\001\002\000\032\002\ufff2\004\ufff2\005\ufff2" +
    "\006\ufff2\007\ufff2\011\ufff2\012\ufff2\013\ufff2\014\ufff2\015" +
    "\ufff2\016\ufff2\017\ufff2\001\002\000\014\005\010\010\013" +
    "\020\012\021\007\022\011\001\002\000\014\005\010\010" +
    "\013\020\012\021\007\022\011\001\002\000\014\005\010" +
    "\010\013\020\012\021\007\022\011\001\002\000\014\005" +
    "\010\010\013\020\012\021\007\022\011\001\002\000\014" +
    "\005\010\010\013\020\012\021\007\022\011\001\002\000" +
    "\014\005\010\010\013\020\012\021\007\022\011\001\002" +
    "\000\014\005\010\010\013\020\012\021\007\022\011\001" +
    "\002\000\014\005\010\010\013\020\012\021\007\022\011" +
    "\001\002\000\014\005\010\010\013\020\012\021\007\022" +
    "\011\001\002\000\014\005\010\010\013\020\012\021\007" +
    "\022\011\001\002\000\032\002\ufff9\004\020\005\024\006" +
    "\016\007\021\011\ufff9\012\026\013\022\014\ufff9\015\ufff9" +
    "\016\ufff9\017\ufff9\001\002\000\032\002\ufffa\004\020\005" +
    "\024\006\016\007\021\011\ufffa\012\ufffa\013\ufffa\014\ufffa" +
    "\015\ufffa\016\ufffa\017\ufffa\001\002\000\032\002\ufff5\004" +
    "\020\005\024\006\016\007\021\011\ufff5\012\026\013\022" +
    "\014\027\015\023\016\017\017\ufff5\001\002\000\032\002" +
    "\ufffe\004\ufffe\005\ufffe\006\016\007\021\011\ufffe\012\ufffe" +
    "\013\ufffe\014\ufffe\015\ufffe\016\ufffe\017\ufffe\001\002\000" +
    "\032\002\ufff8\004\020\005\024\006\016\007\021\011\ufff8" +
    "\012\026\013\022\014\ufff8\015\ufff8\016\ufff8\017\ufff8\001" +
    "\002\000\032\002\ufffb\004\020\005\024\006\016\007\021" +
    "\011\ufffb\012\ufffb\013\ufffb\014\ufffb\015\ufffb\016\ufffb\017" +
    "\ufffb\001\002\000\032\002\ufffc\004\ufffc\005\ufffc\006\ufffc" +
    "\007\ufffc\011\ufffc\012\ufffc\013\ufffc\014\ufffc\015\ufffc\016" +
    "\ufffc\017\ufffc\001\002\000\032\002\uffff\004\uffff\005\uffff" +
    "\006\016\007\021\011\uffff\012\uffff\013\uffff\014\uffff\015" +
    "\uffff\016\uffff\017\uffff\001\002\000\032\002\ufff6\004\020" +
    "\005\024\006\016\007\021\011\ufff6\012\026\013\022\014" +
    "\027\015\023\016\ufff6\017\ufff6\001\002\000\032\002\ufffd" +
    "\004\ufffd\005\ufffd\006\ufffd\007\ufffd\011\ufffd\012\ufffd\013" +
    "\ufffd\014\ufffd\015\ufffd\016\ufffd\017\ufffd\001\002\000\032" +
    "\002\ufff4\004\ufff4\005\ufff4\006\ufff4\007\ufff4\011\ufff4\012" +
    "\ufff4\013\ufff4\014\ufff4\015\ufff4\016\ufff4\017\ufff4\001\002" +
    "\000\032\002\ufff7\004\ufff7\005\ufff7\006\016\007\021\011" +
    "\ufff7\012\ufff7\013\ufff7\014\ufff7\015\ufff7\016\ufff7\017\ufff7" +
    "\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\042\000\010\002\003\003\004\004\005\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\006\003\042\004\005\001\001\000\002\001" +
    "\001\000\006\003\041\004\005\001\001\000\006\003\013" +
    "\004\005\001\001\000\002\001\001\000\002\001\001\000" +
    "\006\003\040\004\005\001\001\000\006\003\037\004\005" +
    "\001\001\000\006\003\036\004\005\001\001\000\006\003" +
    "\035\004\005\001\001\000\006\003\034\004\005\001\001" +
    "\000\006\003\033\004\005\001\001\000\006\003\032\004" +
    "\005\001\001\000\006\003\031\004\005\001\001\000\006" +
    "\003\030\004\005\001\001\000\006\003\027\004\005\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001" });

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
          case 17: // CSTE ::= CONSTANTEBOOL 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new ConstanteBool(e, eleft+1) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("CSTE",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // CSTE ::= CONSTANTEINT 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new ConstanteEntiere(e, eleft+1) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("CSTE",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // EXPR ::= PAROUV EXPR PARFER 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		 RESULT = e ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EXPR ::= CSTE 
            {
              Expression RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression c = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = c ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EXPR ::= NON EXPR 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new NonLogique(e); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // EXPR ::= EXPR OU EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new OuLogique(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // EXPR ::= EXPR ET EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new EtLogique(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // EXPR ::= MOINS EXPR 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new MoinsUnaire(e); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // EXPR ::= EXPR DIFF EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Different(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // EXPR ::= EXPR EGALEGAL EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Egal(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // EXPR ::= EXPR SUP EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Superieur(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // EXPR ::= EXPR INF EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Inferieur(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // EXPR ::= EXPR DIV EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Div(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // EXPR ::= EXPR MULT EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Mult(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // EXPR ::= EXPR MOINS EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Moins(g, d); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // EXPR ::= EXPR PLUS EXPR 
            {
              Expression RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression g = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression d = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Plus(g, d) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // PROG ::= EXPR 
            {
              ArbreAbstrait RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 BlocDInstructions arbre = new BlocDInstructions(eleft+1) ;
                   arbre.ajouter(e) ;
                   RESULT = arbre ; 
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

