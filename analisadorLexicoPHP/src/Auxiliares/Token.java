
package Auxiliares;

public class Token {

    // Constantes para tipos de token

    public static final int ELSE = 1;
    public static final int FALSE = 2;
    public static final int IF = 3;
    public static final int PRINT = 4;
    public static final int RETURN = 5;
    public static final int STATIC  = 6;
    public static final int WHILE = 7;
    public static final int ID = 8;
    public static final int LITERALNUMERICO = 9;
    public static final int AT = 10;
    public static final int OP = 11;
    public static final int LOG = 12;
    public static final int RELOP = 13;
    public static final int LITERALSTRING  = 14;
    public static final int LITERALCHAR = 15;
    public static final int PONTUACAO = 16;
    //ADICIONADOS
    public static final int ECHO = 17;
    public static final int ELSEIF = 18;
    public static final int BREAK = 19;
    public static final int CLONE = 20;
    public static final int ENDSWITCH = 21;
    public static final int FINAL = 22;
    public static final int FUNCTION = 23;
    public static final int INCLUDE = 24;
    public static final int READONLY = 25;
    public static final int SWITCH = 26;
    public static final int USE = 27;
    public static final int ABSTRACT = 28;
    public static final int CALLABLE = 29;
    public static final int CONST = 30;
    public static final int DO = 31;
    public static final int ENDDECLARE = 32;
    public static final int ENDWHILE = 33;
    public static final int FINALLY = 34;
    public static final int GLOBAL = 35;
    public static final int REQUIRE = 36;
    public static final int THROW = 37;
    public static final int VAR = 38;
    public static final int ENDFOR = 39;
    public static final int CASE = 40;
    public static final int CONTINUE = 41;
    public static final int MATCH = 42;
    public static final int GOTO = 43;
    public static final int INSTANCEOF = 44;
    public static final int PRIVATE = 45;
    public static final int TRAIT = 46;
    public static final int CATCH = 47;
    public static final int DECLARE = 48;
    public static final int ENDFOREACH = 49;
    public static final int INSTEADOF = 50;
    public static final int NAMESPACE = 51;
    public static final int PROTECTED = 52;
    public static final int TRY = 53;
    public static final int AS = 54;
    public static final int CLASS = 55;
    public static final int DEFAULT = 56;
    public static final int ENDIF = 57;
    public static final int EXTENDS = 58;
    public static final int FOREACH = 59;
    public static final int IMPLEMENTS = 60;
    public static final int INTERFACE = 61;
    public static final int NEW = 62;
    public static final int PUBLIC = 63;
    public static final int YIELD = 64;
    public static final int ASIG = 65;
    public static final int IDC = 66;
    public static final int AND2 = 67;
    public static final int OR2 = 68;
    public static final int XOR = 69;

    public static final int INIT = 70;
    public static final int PHP = 71;

    public static final int FIM = 72;


    // Valor fim de Arquivo

    public static final int EOF   = 100;

    // Valores para tokens RELOP(< > <= >=  == === != !== <> <=> ??)

    public static final int LT = 1; // <
    public static final int LE = 2; // <=
    public static final int GT = 3; // >
    public static final int GE = 4; // >=
    public static final int EQ = 5; // ==
    public static final int NE = 6;  // !=
    public static final int ES = 7; // ===
    public static final int NI = 8; // !==
    public static final int DIF = 9; // <>
    public static final int SP = 10; // <=>
    public static final int FN = 11; // ??



    // Valores para tokens AUX

    public static final int ATR = 1;

    // Valores para tokens OP

    public static final int AD = 1;
    public static final int SUB = 2;
    public static final int DIV = 3;
    public static final int MUL = 4;
    public static final int RES = 5;
    public static final int ESP = 6;



    // Valores para tokens LOG

    public static final int AND = 1;
    public static final int OR = 2;
    public static final int NOT = 3;

    // Valores para tokens PONTUACAO

    public static final int AP = 1;
    public static final int FP = 2;
    public static final int AC = 3;
    public static final int FC = 4;
    public static final int PV = 5;
    public static final int VG = 6;

    public static final int ASP = 7;


    // Valores para tokens ASIGNACIÓN

    public static final int AA = 1; // +=
    public static final int SA = 2; // -=
    public static final int AE = 3;  // &=
    public static final int OE = 4;  // |=
    public static final int XE = 5;  // ^=
    public static final int MA = 6; // *=
    public static final int DA = 7; // /=
    public static final int MOA = 8; // %=
    public static final int DE = 9;  // <<=
    public static final int DD = 10;  // >>=
    public static final int FNA = 11;  // ??=
    public static final int EA = 12;  // **=
    public static final int CA = 13;  // .=



    // Valores para tokens INCREMENTO/DECREMENTO

    public static final int IC = 1;
    public static final int DC = 2;



    // Atributos

    private int tipo;
    private Object valor;

    // Construtores

    public Token(int tipo, Object valor) {

        this.tipo = tipo;
        this.valor = valor;

    }

    public Token(int tipo) {

        this( tipo, null );

    }

    // M�todos para criar tokens

    public static Token EOF() {

        return new Token(EOF);

    }

    public int getTipo() {

        return this.tipo;

    }

    public Object getValor() {

        return this.valor;

    }

    public String toString()  {

        String valorString = "-";

        switch( tipo ) {

            case RELOP: valorString = tipoRelop( (Integer) valor);
                break;

            case AT: valorString = "ATR";
                break;

            case OP: valorString = tipoOP( (Integer) valor );
                break;

            case LOG: valorString = tipoLog( (Integer) valor );
                break;

            case PONTUACAO: valorString = tipoPontuacao( (Integer) valor );
                break;

            case ASIG: valorString = tipoAsig( (Integer) valor );
                break;

            case IDC: valorString = tipoIDc( (Integer) valor );
                break;

            case INIT: valorString = "$";
                break;

            case PHP: valorString = "<?php";
                break;

            case FIM: valorString = "?>";
                break;


            default: {

                if( valor != null ) {

                    valorString = valor.toString().trim();

                }

            }

        }

        return "<" + tipoString() + ", " + valorString + ">";

    }

    private String tipoString() {

        String resultado = "Erro";

        switch ( tipo ) {

            case ELSE: resultado = "else";
                break;

            case FALSE: resultado = "falso";
                break;

            case IF: resultado = "if";
                break;

            case PRINT: resultado = "print";
                break;

            case RETURN: resultado = "return";
                break;

            case STATIC: resultado = "static";
                break;

            case WHILE: resultado = "while";
                break;

            case ID: resultado = "id";
                break;

            case LITERALNUMERICO: resultado = "literalNumerico";
                break;

            case LITERALSTRING: resultado = "literalString";
                break;

            case LITERALCHAR: resultado = "literalChar";
                break;

            case AT: resultado = "at";
                break;

            case OP: resultado = "op";
                break;

            case LOG: resultado = "log";
                break;

            case RELOP: resultado = "relop";
                break;

            case PONTUACAO: resultado = "pontuação";
                break;

            case ECHO: resultado = "echo";
                break;

            case ELSEIF: resultado = "elseif";
                break;

            case BREAK: resultado = "break";
                break;

            case CLONE: resultado = "clone";
                break;

            case ENDSWITCH: resultado = "endswitch";
                break;

            case FINAL: resultado = "final";
                break;

            case FUNCTION: resultado = "function";
                break;

            case INCLUDE: resultado = "include";
                break;

            case READONLY: resultado = "readonly";
                break;

            case SWITCH: resultado = "switch";
                break;

            case USE: resultado = "use";
                break;

            case ABSTRACT: resultado = "abstract";
                break;

            case CALLABLE: resultado = "callable";
                break;

            case CONST: resultado = "const";
                break;

            case DO: resultado = "do";
                break;

            case ENDDECLARE: resultado = "enddeclare";
                break;

            case ENDWHILE: resultado = "endwhile";
                break;

            case FINALLY: resultado = "finally";
                break;

            case GLOBAL: resultado = "global";
                break;

            case REQUIRE: resultado = "require";
                break;

            case THROW: resultado = "throw";
                break;

            case VAR: resultado = "var";
                break;

            case ENDFOR: resultado = "endfor";
                break;

            case CASE: resultado = "case";
                break;

            case CONTINUE: resultado = "continue";
                break;

            case MATCH: resultado = "match";
                break;

            case GOTO: resultado = "goto";
                break;

            case INSTANCEOF: resultado = "instanceof";
                break;

            case PRIVATE: resultado = "private";
                break;

            case TRAIT: resultado = "trait";
                break;

            case CATCH: resultado = "catch";
                break;

            case DECLARE: resultado = "declare";
                break;

            case ENDFOREACH: resultado = "endforeach";
                break;

            case INSTEADOF: resultado = "insteadof";
                break;

            case NAMESPACE: resultado = "namespace";
                break;

            case PROTECTED: resultado = "protected";
                break;

            case TRY: resultado = "try";
                break;

            case AS: resultado = "as";
                break;

            case CLASS: resultado = "class";
                break;

            case DEFAULT: resultado = "default";
                break;

            case ENDIF: resultado = "as";
                break;

            case EXTENDS: resultado = "class";
                break;

            case FOREACH: resultado = "default";
                break;

            case IMPLEMENTS: resultado = "implements";
                break;

            case INTERFACE: resultado = "interface";
                break;

            case NEW: resultado = "new";
                break;

            case PUBLIC: resultado = "public";
                break;

            case YIELD: resultado = "yield";
                break;

            case ASIG: resultado = "asig";
                break;

            case IDC: resultado = "idc";
                break;

            case INIT: resultado = "Inicializador de variavel";
                break;

            case PHP: resultado = "Inicializador de class";
                break;

            case FIM: resultado = "finalizador de class";
                break;


        }

        return resultado;

    }

    private String tipoRelop(Integer tipo1) {

        String resultado = "Erro";

        switch ( tipo1.intValue() ) {

            case LT: resultado = "LT";
                break;

            case LE: resultado = "LE";
                break;

            case GT: resultado = "GT";
                break;

            case GE: resultado = "GE";
                break;

            case EQ: resultado = "EQ";
                break;

            case NE: resultado = "NE";
                break;

            case ES: resultado = "ES";
                break;

            case NI: resultado = "NI";
                break;

            case DIF: resultado = "DIF";
                break;

            case SP: resultado = "SP";
                break;

            case FN: resultado = "FN";
                break;

        }

        return resultado;

    }

    private String tipoOP(Integer tipo1) {

        String resultado = "Erro";

        switch ( tipo1.intValue() ) {

            case AD: resultado = "+";
                break;

            case SUB: resultado = "-";
                break;

            case MUL: resultado = "*";
                break;

            case DIV: resultado = "/";
                break;

            case RES: resultado = "%";
                break;

            case ESP: resultado = "**";
                break;

        }

        return resultado;

    }

    private String tipoLog(Integer tipo1) {

        String resultado = "Erro";

        switch ( tipo1.intValue() ) {

            case AND: resultado = "&&";
                break;

            case OR: resultado = "||";
                break;

            case NOT: resultado = "!";
                break;

        }

        return resultado;

    }

    private String tipoPontuacao(Integer valor2) {

        String resultado = "Erro";

        switch ( valor2.intValue() ) {

            case AP: resultado = "(";
                break;

            case FP: resultado = ")";
                break;

            case AC: resultado = "{";
                break;

            case FC: resultado = "}";
                break;

            case PV: resultado = ";";
                break;

            case VG: resultado = ",";
                break;

            case ASP: resultado = "string";
                break;
        }

        return resultado;

    }


    private String tipoAsig(Integer tipo1) {

        String resultado = "Erro";

        switch ( tipo1.intValue() ) {

            case AA: resultado = "+=";
                break;

            case SA: resultado = "-=";
                break;

            case AE: resultado = "&=";
                break;

            case OE: resultado = "|=";
                break;

            case XE: resultado = "^=";
                break;

            case MA: resultado = "*=";
                break;

            case DA: resultado = "/=";
                break;

            case MOA: resultado = "%=";
                break;

            case DE: resultado = "<<=";
                break;

            case DD: resultado = ">>=";
                break;

            case FNA: resultado = "??=";
                break;

            case EA: resultado = "**=";
                break;

            case CA: resultado = ".=";
                break;
        }

        return resultado;

    }

    private String tipoIDc(Integer tipo1) {

        String resultado = "Erro";

        switch ( tipo1.intValue() ) {

            case IC: resultado = "--";
                break;

            case DC: resultado = "++";
                break;


        }

        return resultado;

    }

}
