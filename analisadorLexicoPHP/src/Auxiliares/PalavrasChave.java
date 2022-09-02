

package Auxiliares;

public class PalavrasChave {

    private static final String ELSE = "else";
    private static final String FALSE = "false";
    private static final String IF   = "if";
    private static final String PRINT   = "print";
    private static final String RETURN = "return";
    private static final String STATIC = "static";
    private static final String WHILE = "while";
    //palavras adicionadas
    private static final String ECHO   = "echo";
    private static final String ELSEIF   = "elseif";
    private static final String BREAK   = "break";
    private static final String CLONE   = "clone";
    private static final String ENDSWITCH   = "endswitch";
    private static final String FINAL   = "final";
    private static final String FUNCTION   = "function";
    private static final String INCLUDE   = "include";
    private static final String READONLY   = "readonly";
    private static final String SWITCH   = "switch";
    private static final String USE   = "use";
    private static final String ABSTRACT   = "abstract";
    private static final String CALLABLE   = "callable";
    private static final String CONST   = "const";
    private static final String DO   = "do";
    private static final String ENDDECLARE   = "enddeclare";
    private static final String ENDWHILE   = "endwhile";
    private static final String FINALLY   = "finally";
    private static final String GLOBAL   = "global";
    private static final String REQUIRE   = "require";
    private static final String THROW   = "throw";
    private static final String VAR   = "var";
    private static final String ENDFOR   = "endfor";
    private static final String CASE   = "case";
    private static final String CONTINUE   = "continue";
    private static final String MATCH   = "match";
    private static final String GOTO   = "goto";
    private static final String INSTANCEOF   = "instanceof";
    private static final String PRIVATE   = "private";
    private static final String TRAIT   = "trait";
    private static final String CATCH   = "catch";
    private static final String DECLARE   = "declare";
    private static final String ENDFOREACH   = "endforeach";
    private static final String INSTEADOF   = "insteadof";
    private static final String NAMESPACE   = "namespace";
    private static final String PROTECTED   = "protected";
    private static final String TRY   = "try";
    private static final String AS   = "as";
    private static final String CLASS   = "class";
    private static final String DEFAULT   = "default";
    private static final String ENDIF   = "endif";
    private static final String EXTENDS   = "extends";
    private static final String FOREACH   = "foreach";
    private static final String IMPLEMENTS   = "implements";
    private static final String INTERFACE   = "interface";
    private static final String NEW   = "new";
    private static final String PUBLIC   = "public";
    private static final String YIELD   = "yield";
    private static final String AND2   = "and";
    private static final String OR2   = "or";
    private static final String XOR   = "xor";

    private static final String PHP   = "php";




    public static boolean isPalavraChave(StringBuffer palavra) {

        String palavra1 = palavra.toString();

        if ( palavra1.equals(FALSE) || palavra1.equals(IF) ||palavra1.equals(PRINT) || palavra1.equals(RETURN)
                || palavra1.equals(STATIC) || palavra1.equals(WHILE) || palavra1.equals(ECHO) || palavra1.equals(ELSEIF)
                || palavra1.equals(BREAK) || palavra1.equals(CLONE) || palavra1.equals(ENDSWITCH)
                || palavra1.equals(FINAL) || palavra1.equals(FUNCTION) || palavra1.equals(INCLUDE) || palavra1.equals(READONLY)
                || palavra1.equals(SWITCH) || palavra1.equals(USE) || palavra1.equals(ABSTRACT) || palavra1.equals(CALLABLE)
                || palavra1.equals(CONST) || palavra1.equals(DO) || palavra1.equals(ENDDECLARE) || palavra1.equals(ENDWHILE)
                || palavra1.equals(FINALLY) || palavra1.equals(GLOBAL) || palavra1.equals(REQUIRE) || palavra1.equals(THROW)
                || palavra1.equals(VAR) || palavra1.equals(ENDFOR) || palavra1.equals(CASE) || palavra1.equals(CONTINUE)
                || palavra1.equals(MATCH) || palavra1.equals(GOTO) || palavra1.equals(INSTANCEOF) || palavra1.equals(PRIVATE)
                || palavra1.equals(TRAIT) || palavra1.equals(CATCH) || palavra1.equals(DECLARE) || palavra1.equals(ENDFOREACH)
                || palavra1.equals(INSTEADOF) || palavra1.equals(NAMESPACE) || palavra1.equals(PROTECTED) || palavra1.equals(TRY)
                || palavra1.equals(AS) || palavra1.equals(CLASS) || palavra1.equals(DEFAULT)|| palavra1.equals(ENDIF)
                || palavra1.equals(EXTENDS) || palavra1.equals(FOREACH) || palavra1.equals(IMPLEMENTS) || palavra1.equals(INTERFACE)
                || palavra1.equals(NEW) || palavra1.equals(PUBLIC) || palavra1.equals(YIELD) || palavra1.equals(AND2) || palavra1.equals(OR2) || palavra1.equals(XOR) || palavra1.equals(PHP)) {

            return true;

        }

        return false;

    }

    public static int tipoPalavraChave(StringBuffer palavra) {

        String palavra1 = palavra.toString();

        int resultado;

        if (palavra1.equals(ELSE)) {

            resultado = Token.ELSE;

        } else if (palavra1.equals(FALSE)) {

            resultado = Token.FALSE;

        } else if (palavra1.equals(IF)) {

            resultado = Token.IF;

        } else if (palavra1.equals(RETURN)) {

            resultado = Token.RETURN;

        } else if (palavra1.equals(STATIC)) {

            resultado = Token.STATIC;


        } else if (palavra1.equals(ECHO)) {

            resultado = Token.ECHO;

        } else if (palavra1.equals(ELSEIF)) {

            resultado = Token.ELSEIF;

        } else if (palavra1.equals(BREAK)) {

            resultado = Token.BREAK;

        } else if (palavra1.equals(CLONE)) {

            resultado = Token.CLONE;

        } else if (palavra1.equals(ENDSWITCH)) {

            resultado = Token.ENDSWITCH;

        } else if (palavra1.equals(FINAL)) {

            resultado = Token.FINAL;

        } else if (palavra1.equals(FUNCTION)) {

            resultado = Token.FUNCTION;

        } else if (palavra1.equals(INCLUDE)) {

            resultado = Token.INCLUDE;

        } else if (palavra1.equals(READONLY)) {

            resultado = Token.READONLY;

        } else if (palavra1.equals(SWITCH)) {

            resultado = Token.SWITCH;

        } else if (palavra1.equals(USE)) {

            resultado = Token.USE;

        } else if (palavra1.equals(ABSTRACT)) {

            resultado = Token.ABSTRACT;

        } else if (palavra1.equals(CALLABLE)) {

            resultado = Token.CALLABLE;

        } else if (palavra1.equals(CONST)) {

            resultado = Token.CONST;

        } else if (palavra1.equals(DO)) {

            resultado = Token.DO;

        } else if (palavra1.equals(ENDDECLARE)) {

            resultado = Token.ENDDECLARE;

        } else if (palavra1.equals(ENDWHILE)) {

            resultado = Token.ENDWHILE;

        } else if (palavra1.equals(FINALLY)) {

            resultado = Token.FINALLY;

        } else if (palavra1.equals(GLOBAL)) {

            resultado = Token.GLOBAL;

        } else if (palavra1.equals(REQUIRE)) {

            resultado = Token.REQUIRE;

        } else if (palavra1.equals(THROW)) {

            resultado = Token.THROW;

        } else if (palavra1.equals(VAR)) {

            resultado = Token.VAR;

        } else if (palavra1.equals(ENDFOR)) {

            resultado = Token.ENDFOR;

        } else if (palavra1.equals(CASE)) {

            resultado = Token.CASE;

        } else if (palavra1.equals(CONTINUE)) {

            resultado = Token.CONTINUE;

        } else if (palavra1.equals(MATCH)) {

            resultado = Token.MATCH;

        } else if (palavra1.equals(GOTO)) {

            resultado = Token.GOTO;

        } else if (palavra1.equals(INSTANCEOF)) {

            resultado = Token.INSTANCEOF;

        } else if (palavra1.equals(PRIVATE)) {

            resultado = Token.PRIVATE;

        } else if (palavra1.equals(TRAIT)) {

            resultado = Token.TRAIT;

        } else if (palavra1.equals(CATCH)) {

            resultado = Token.CATCH;

        } else if (palavra1.equals(DECLARE)) {

            resultado = Token.DECLARE;

        } else if (palavra1.equals(ENDFOREACH)) {

            resultado = Token.ENDFOREACH;

        } else if (palavra1.equals(INSTEADOF)) {

            resultado = Token.INSTEADOF;

        } else if (palavra1.equals(NAMESPACE)) {

            resultado = Token.NAMESPACE;

        } else if (palavra1.equals(PROTECTED)) {

            resultado = Token.PROTECTED;

        } else if (palavra1.equals(TRY)) {

            resultado = Token.TRY;

        } else if (palavra1.equals(AS)) {

            resultado = Token.AS;

        } else if (palavra1.equals(CLASS)) {

            resultado = Token.CLASS;

        } else if (palavra1.equals(DEFAULT)) {

            resultado = Token.DEFAULT;

        } else if (palavra1.equals(ENDIF)) {

            resultado = Token.ENDIF;

        } else if (palavra1.equals(EXTENDS)) {

            resultado = Token.EXTENDS;

        } else if (palavra1.equals(FOREACH)) {

            resultado = Token.FOREACH;

        } else if (palavra1.equals(IMPLEMENTS)) {

            resultado = Token.IMPLEMENTS;

        } else if (palavra1.equals(INTERFACE)) {

            resultado = Token.INTERFACE;

        } else if (palavra1.equals(NEW)) {

            resultado = Token.NEW;

        } else if (palavra1.equals(PUBLIC)) {

            resultado = Token.PUBLIC;

        } else if (palavra1.equals(YIELD)) {

            resultado = Token.YIELD;

        } else if (palavra1.equals(AND2)) {

            resultado = Token.AND2;

        } else if (palavra1.equals(OR2)) {

            resultado = Token.OR2;

        } else if (palavra1.equals(XOR)) {

            resultado = Token.XOR;

        }else if (palavra1.equals(PHP)) {

            resultado = Token.PHP;

        }

        else {

            resultado = Token.WHILE;

        }

        return resultado;

    }

}
