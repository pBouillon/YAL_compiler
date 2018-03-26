package yal.arbre.expression;

import yal.exceptions.ListeSemantiqueException;
import yal.exceptions.VariableUndefinedException;
import yal.tabledessymboles.Entry;
import yal.tabledessymboles.FnEntry;
import yal.tabledessymboles.TDSv2;

import java.util.ArrayList;

public class AppelFunc extends Expression {
    private String name ;
    Entry entry ;
    int nbParam ;
    ArrayList<Expression> param;

    public AppelFunc(String _name, int no, ArrayList<Expression> _param) {
        super(no);
        name = _name ;
        entry = new FnEntry(name, null) ;
        param = _param ;
        nbParam = param.size() ;
    }

    @Override
    public void verifier() {
        if (!TDSv2.getInstance().fnExists(entry, nbParam)) {
            ListeSemantiqueException.getInstance().addException (
                    new VariableUndefinedException (
                            noLigne,
                            "fonction : " + name
                    )
                ) ;
        }
//        TDS.getInstance().identifier("func_" + name, noLigne) ;
    }

    @Override
    public String toMIPS() {
//        return String.join(
//                "\n",
//                "\n\t# allocation place pour return",
//                "\taddi $sp, $sp, -4",
//                "\t# appel de " + name + "()",
//                "\tjal " + name
//        );
        StringBuilder mips = new StringBuilder() ;

        mips.append("\n# Appel de " + name + " avec " + nbParam + "parametres") ;
        int i = 0 ;
        for (Expression e : param) {
            mips.append (String.join(
                    "\n",
                    "\n\t# Eval du " + i + "eme parametre",
                    e.toMIPS(),
                    "sw $v0, (sp)",
                    "addi $sp, $sp, -4"
                )
            ) ;
        }
        mips.append (
                String.join("\n",
                        "\n\t# appel de la fonction",
                        "\tjal " + TDSv2.getInstance().identifierFn(entry, nbParam).getEtq(),
                        "\t# Deplacement de sp pour les " + nbParam + " parametres",
                        "\taddi $sp, $sp, " + nbParam * 4
                )
        ) ;

        return mips.toString() ;
    }

    @Override
    public String getType() {
        return TYPE_ENTIER;
    }
}
