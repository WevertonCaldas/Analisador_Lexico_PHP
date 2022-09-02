
package Auxiliares;

import Erro.LexerException;

import java.io.BufferedReader;
import java.io.IOException;


public class AnalisadorLexico {

    // Atributos

    private BufferedReader reader;
    private int estado;
    private int buffer;
    private boolean bufferValid = false;

    public AnalisadorLexico(BufferedReader reader) {

        this.reader = reader;

    }

    public Token pegarProximoToken() throws IOException, LexerException {

        boolean feito = false;
        int tipoAtual = Token.EOF;
        int primeiroValor = 0;
        Object valorAtual = null;
        StringBuffer sBuffer = null;

        estado = 0;

        while ( !feito ) {

            int caractere = pegardoBuffer();

            if ( Character.isWhitespace(caractere) && tipoAtual == Token.EOF ) {

                continue;

            } else if ( caractere == -1 && tipoAtual == Token.EOF ) {

                return Token.EOF();

            }

            switch (estado) {

                case 0: {

                    switch( caractere ) {

                        case '<': {

                            primeiroValor = Token.LT;
                            estado = 1;
                            tipoAtual = Token.RELOP;
                            valorAtual = Integer.parseInt(String.valueOf(Token.LT));//less than

                        }break;

                        case '>': {

                            primeiroValor = Token.GT;
                            estado = 10;
                            tipoAtual = Token.RELOP;
                            valorAtual = Integer.parseInt(String.valueOf( Token.GT ));

                        }break;

                        case '=': {

                            primeiroValor = Token.ATR;
                            estado = 4;
                            tipoAtual = Token.AT;
                            valorAtual = Integer.parseInt(String.valueOf( Token.ATR ));

                        }break;

                        case '!': {

                            estado = 7;
                            tipoAtual = Token.LOG;
                            valorAtual = Integer.parseInt(String.valueOf( Token.NOT ));

                        }break;

                        case '+': {

                            primeiroValor = Token.AD;
                            estado = 12;
                            tipoAtual = Token.OP;
                            valorAtual = Integer.parseInt(String.valueOf( Token.AD ));

                        }break;

                        case '-': {

                            primeiroValor = Token.SUB;
                            estado = 12;
                            tipoAtual = Token.OP;
                            valorAtual = Integer.parseInt(String.valueOf( Token.SUB ));

                        }break;

                        case '*': {

                            primeiroValor = Token.MUL;
                            estado = 14;
                            tipoAtual = Token.OP;
                            valorAtual = Integer.parseInt(String.valueOf( Token.MUL ));

                        }break;

                        case '/': {

                            estado = 24;

                        }break;

                        case '&': {

                            estado = 28;

                        }break;

                        case '|': {

                            estado = 32;

                        }break;

                        case ',': {

                            tipoAtual = Token.PONTUACAO;
                            valorAtual = Integer.parseInt(String.valueOf( Token.VG ));

                            feito = true;

                        }break;

                        case ';': {

                            tipoAtual = Token.PONTUACAO;
                            valorAtual = Integer.parseInt(String.valueOf( Token.PV ));

                            feito = true;

                        }break;

                        case '(': {

                            tipoAtual = Token.PONTUACAO;
                            valorAtual = Integer.parseInt(String.valueOf( Token.AP ));

                            feito = true;

                        }break;

                        case ')': {

                            tipoAtual = Token.PONTUACAO;
                            valorAtual = Integer.parseInt(String.valueOf( Token.FP ));

                            feito = true;

                        }break;

                        case '{': {


                            tipoAtual = Token.PONTUACAO;
                            valorAtual = Integer.parseInt(String.valueOf( Token.AC ));

                            feito = true;

                        }break;

                        case '}': {

                            tipoAtual = Token.PONTUACAO;
                            valorAtual = Integer.parseInt(String.valueOf( Token.FC ));

                            feito = true;

                        }break;

                        case '?': {

                            estado = 11;
                            tipoAtual = Token.RELOP;

                        }break;

                        case '^': {

                            estado = 13;
                            tipoAtual = Token.ASIG;

                        }break;

                        case '.': {

                            estado = 15;
                            tipoAtual = Token.ASIG;

                        }break;

                        case '%': {

                            primeiroValor = Token.RES;
                            estado = 15;
                            tipoAtual = Token.OP;
                            valorAtual = Integer.parseInt(String.valueOf( Token.RES ));

                        }break;

                        case '$': {

                            estado = 35;

                            tipoAtual = Token.INIT;
                            valorAtual = Token.RELOP;
                            feito = true;


                        }break;

                        default:{

                            retoneparaBuffer( caractere );
                            estado = getProximoEstado();

                        }

                    }

                }break;

                case 1: {

                    if ( caractere == '=' ) {

                        estado = 9;
                        valorAtual = Integer.parseInt(String.valueOf( Token.LE ));

                    } else if ( caractere == '>' ) {

                            if(primeiroValor == Token.GT) {
                                tipoAtual = Token.ASIG;
                                estado = 17;

                            }else {
                                valorAtual = Integer.parseInt(String.valueOf(Token.DIF));
                                feito = true;
                            }

                    }else if ( caractere == '<' ) {

                        estado = 17;
                        valorAtual = Integer.parseInt(String.valueOf(Token.DIF));

                    }else if ( caractere == '?' ) {

                        estado = 0;

                    }else {

                        retoneparaBuffer( caractere );
                        feito = true;
                    }


                }break;

                case 4: {

                    if ( caractere == '=' ) {

                        estado = 8;

                        tipoAtual = Token.RELOP;
                        valorAtual = Integer.parseInt(String.valueOf( Token.EQ ));

                    } else {

                        retoneparaBuffer( caractere );
                        feito = true;

                    }

                }break;

                case 7: {

                    if ( caractere == '=' ) {

                        estado = 8;

                        tipoAtual = Token.RELOP;
                        valorAtual = Integer.parseInt(String.valueOf(Token.NE));

                    } else {

                        retoneparaBuffer( caractere );
                        feito = true;

                    }

                }break;

                case 8: {

                    if ( caractere == '=' ) {

                        if(primeiroValor == Token.ATR){
                            valorAtual = Integer.parseInt(String.valueOf(Token.ES));
                            feito = true;

                        }else {
                            valorAtual = Integer.parseInt(String.valueOf(Token.NI));
                            feito = true;
                        }

                    } else {

                        retoneparaBuffer( caractere );
                        feito = true;

                    }

                }break;

                case 9: {

                    if ( caractere == '>' ) {

                        valorAtual = Integer.parseInt(String.valueOf(Token.SP));
                        feito = true;

                    } else {

                        retoneparaBuffer( caractere );
                        feito = true;

                    }

                }break;

                case 10: {

                    if ( caractere == '=' ) {

                        if (primeiroValor == Token.GT){
                            valorAtual = Integer.parseInt(String.valueOf( Token.GE ));
                            feito = true;
                        }else {
                            tipoAtual = Token.ASIG;
                            valorAtual = Integer.parseInt(String.valueOf( Token.FNA ));
                            feito = true;
                        }

                    } else {

                        estado = 1;
                        retoneparaBuffer( caractere );
                    }

                }break;

                case 11: {

                    if ( caractere == '?' ) {

                        estado = 10;
                        valorAtual = Integer.parseInt(String.valueOf(Token.FN));

                    }else if ( caractere == '>' ) {
                        tipoAtual = Token.FIM;

                    } else {

                        retoneparaBuffer( caractere );
                        feito = true;

                    }

                }break;

                case 12: {

                    if ( caractere == '=' ) {

                        if (primeiroValor == Token.AD){
                            tipoAtual = Token.ASIG;
                            valorAtual = Integer.parseInt(String.valueOf( Token.AA ));
                            feito = true;

                        }else {
                            tipoAtual = Token.ASIG;
                            valorAtual = Integer.parseInt(String.valueOf( Token.SUB ));
                            feito = true;
                        }
                    } else {

                        estado = 16;
                        retoneparaBuffer( caractere );
                    }

                }break;

                case 13: {

                    if ( caractere == '=' ) {

                        if(primeiroValor == Token.MUL){
                            tipoAtual = Token.ASIG;
                            valorAtual = Integer.parseInt(String.valueOf( Token.EA ));
                            feito = true;

                        }else{
                            tipoAtual = Token.ASIG;
                            valorAtual = Integer.parseInt(String.valueOf( Token.XE ));
                            feito = true;
                        }
                    } else {

                        retoneparaBuffer( caractere );
                        feito = true;
                    }

                }break;

                case 14: {

                    if ( caractere == '*' ) {

                        estado = 13;
                        valorAtual = Integer.parseInt(String.valueOf( Token.ESP ));

                    } else {

                        if(caractere == '='){
                            tipoAtual = Token.ASIG;
                            valorAtual = Integer.parseInt(String.valueOf( Token.MA ));
                        }else {
                            retoneparaBuffer( caractere );
                            feito = true;
                        }
                    }

                }break;
                case 15: {

                    if ( caractere == '=' ) {
                        if (primeiroValor == Token.RES){
                            tipoAtual = Token.ASIG;
                            valorAtual = Integer.parseInt(String.valueOf( Token.MOA ));
                            feito = true;
                        }else {
                            valorAtual = Integer.parseInt(String.valueOf( Token.CA ));
                            feito = true;
                        }
                    } else {

                        retoneparaBuffer( caractere );
                        feito = true;

                    }

                }break;

                case 16: {

                    if ( caractere == '-' ) {

                        tipoAtual = Token.IDC;
                        valorAtual = Integer.parseInt(String.valueOf( Token.DC ));
                        feito = true;

                    }else if(caractere == '+'){

                        tipoAtual = Token.IDC;
                        valorAtual = Integer.parseInt(String.valueOf( Token.IC ));
                        feito = true;

                    }else{
                        retoneparaBuffer( caractere );
                        feito = true;
                    }

                }break;

                case 17: {

                    if ( caractere == '=' ) {

                        if(primeiroValor == Token.LT){
                            tipoAtual = Token.ASIG;
                            valorAtual = Integer.parseInt(String.valueOf(Token.DE));
                        }else{
                            valorAtual = Integer.parseInt(String.valueOf(Token.DD));
                            feito = true;
                        }

                    } else {

                        retoneparaBuffer( caractere );
                        feito = true;

                    }

                }break;

                case 24: {

                    if( caractere == '/' ) {

                        while( caractere != '\n' && caractere != -1 ) {

                            caractere = pegardoBuffer();

                        }

                        estado = 0;

                    } else if( caractere == '*' ) {

                        caractere = pegardoBuffer();

                        while( caractere != '*' && caractere != -1 ) {

                            caractere = pegardoBuffer();

                        }

                        caractere = pegardoBuffer();

                        if( caractere != '/' ) {

                            estado = 24;

                        } else {

                            estado = 0;

                        }

                    }else if( caractere == '=' ) {

                        tipoAtual = Token.ASIG;
                        valorAtual = Integer.parseInt(String.valueOf( Token.DA ));
                        feito = true;

                    } else {

                        tipoAtual = Token.OP;
                        valorAtual = Integer.parseInt(String.valueOf( Token.DIV ));

                        retoneparaBuffer( caractere );
                        feito = true;

                    }

                }break;

                case 28: {

                    if( caractere == '&' ) {

                        tipoAtual = Token.LOG;
                        valorAtual = Integer.parseInt(String.valueOf( Token.AND ));

                        feito = true;

                    } else {

                        if(caractere == '='){
                            tipoAtual = Token.ASIG;
                            valorAtual = Integer.parseInt(String.valueOf( Token.AE ));
                            feito = true;

                        }else {
                            retoneparaBuffer(caractere);
                            estado = getProximoEstado();
                        }
                    }

                }break;

                case 29: {

                    if( caractere == '*' && pegardoBuffer() == '/' ) {

                        valorAtual = sBuffer;
                        feito = true;

                    } else {

                        estado = 29;

                        sBuffer.append( (char)caractere );

                    }

                }break;

                case 32: {

                    if( caractere == '|' ) {

                        tipoAtual = Token.LOG;
                        valorAtual = Integer.parseInt(String.valueOf( Token.OR ));

                        feito = true;

                    } else {

                        if(caractere == '='){
                            tipoAtual = Token.ASIG;
                            valorAtual = Integer.parseInt(String.valueOf( Token.OE ));
                            feito = true;

                        }else {
                            retoneparaBuffer(caractere);
                            estado = getProximoEstado();
                        }

                    }

                }break;

                case 34: {

                    if ( Character.isLetterOrDigit( caractere ) || caractere == '_' ) {

                        estado = 34;

                        sBuffer.append( (char) caractere );

                    } else if(caractere == '"') {

                        feito = true;

                    }

                }break;

                case 35: {

                    if ( Simbolos.isLetra( caractere ) || caractere == '_' ) {

                        estado = 36;

                        tipoAtual = Token.ID;

                        sBuffer = new StringBuffer();
                        sBuffer.append( (char) caractere );

                    } else {

                        retoneparaBuffer( caractere );
                        estado = getProximoEstado();

                    }

                }break;

                case 36: {

                    if ( Character.isLetterOrDigit( caractere ) || caractere == '_' ) {

                        estado = 36;

                        sBuffer.append( (char) caractere );

                    } else {

                        retoneparaBuffer( caractere );

                        if ( PalavrasChave.isPalavraChave( sBuffer) ) {

                            tipoAtual = PalavrasChave.tipoPalavraChave( sBuffer );
                            valorAtual = null;

                        } else {

                            valorAtual = sBuffer.toString();

                        }

                        feito = true;

                    }

                }break;

                case 38: {

                    if ( Character.isDigit( caractere ) ) {

                        estado = 39;

                        tipoAtual = Token.LITERALNUMERICO;

                        sBuffer = new StringBuffer();
                        sBuffer.append( (char) caractere );

                    } else {

                        retoneparaBuffer( caractere );
                        estado = getProximoEstado();

                    }

                }break;

                case 39: {

                    if ( Character.isDigit( caractere ) ) {

                        estado = 39;
                        sBuffer.append( ( char) caractere );

                    }
		  /*else if(Character.isLetter(caractere)) {
			  throw new LexerException();

		  }*/
                    else {

                        retoneparaBuffer( caractere );

                        valorAtual = Integer.parseInt(String.valueOf(sBuffer.toString()));
                        feito = true;

                    }

                }break;

                case 41: {

                    if( caractere == '\'' ) {

                        estado = 42;

                        tipoAtual = Token.LITERALCHAR;

                        sBuffer = new StringBuffer();

                    } else {

                        retoneparaBuffer( caractere );
                        estado = getProximoEstado();

                    }

                }break;

                case 42: {

                    if( Simbolos.isLetraouDigito( caractere ) ) {

                        estado = 44;

                        sBuffer.append( (char) caractere );

                    } else if ( caractere == '\\') {

                        estado = 43;

                        sBuffer.append( (char) caractere );

                    } else {

                        retoneparaBuffer( caractere );
                        estado = getProximoEstado();
                    }

                }break;

                case 43: {

                    if( caractere == 'r' || caractere == 'n' || caractere == 't' || caractere == '\\' ) {

                        estado = 44;

                        sBuffer.append( (char) caractere );

                    } else {

                        retoneparaBuffer( caractere );
                        estado = getProximoEstado();

                    }

                }break;

                case 44: {

                    if( caractere == '\'' ) {

                        valorAtual = sBuffer;

                        feito = true;

                    } else {

                        retoneparaBuffer( caractere );
                        estado = getProximoEstado();

                    }

                }break;

                case 46: {

                    if( caractere == '"' ) {

                        estado = 47;

                        tipoAtual = Token.LITERALSTRING;

                        sBuffer = new StringBuffer();

                    } else {

                        retoneparaBuffer( caractere );

                        estado = getProximoEstado();

                    }

                }break;

                case 47: {

                    if( Simbolos.isLetraouDigito( caractere ) || caractere == ' ' ) {

                        estado = 47;

                        sBuffer.append( (char) caractere );

                    } else if( caractere == '\\' ){

                        estado = 48;

                        sBuffer.append( (char) caractere );

                    } else {

                        retoneparaBuffer( caractere );
                        estado = 49;

                    }

                }break;

                case 48: {

                    if( caractere == '\\' || caractere == 'r' || caractere == 't' || caractere == 'n' ) {

                        estado = 47;

                        sBuffer.append( (char) caractere );

                    } else {

                        estado = getProximoEstado();

                    }

                }break;

                case 49: {

                    if( caractere == '"' ) {

                        valorAtual = sBuffer;
                        feito = true;

                    } else {

                        retoneparaBuffer( caractere );
                        estado = getProximoEstado();

                    }

                }break;

                default: {

                    throw new Error("Estado nao esperado!!!");

                }

            }

        }
        //System.out.println(estado);
        return new Token( tipoAtual, valorAtual );

    }

    private int pegardoBuffer() throws IOException {

        int result;

        if ( bufferValid ) {

            result = buffer;
            bufferValid = false;

        } else {

            result = reader.read();
            bufferValid = false;

        }

        return result;

    }

    private void retoneparaBuffer(int c) {

        if ( bufferValid ) {

            throw new Error( "Buffer cheio!!" );

        }

        buffer = c;
        bufferValid = true;

    }

    private int getProximoEstado() throws LexerException {

        int resultado = 0;

        switch (estado) {

            case 0: resultado = 35; break;

            case 35: resultado = 38; break;

            case 38: resultado = 41; break;

            case 41: resultado = 46; break;

            default: throw new LexerException( "Erro Lexico: Impossível reconhecer token " );

        }

        return resultado;

    }

}
