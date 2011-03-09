/*******************************************************************************
 * Copyright 2011 Sruthi Bandhakavi
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
// $ANTLR 3.1.1 ES3.g 2010-11-01 00:27:46

 package javascriptAnalysis.parser; 


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class ES3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NULL", "TRUE", "FALSE", "BREAK", "CASE", "CATCH", "CONTINUE", "DEFAULT", "DELETE", "DO", "ELSE", "FINALLY", "FOR", "FUNCTION", "IF", "IN", "INSTANCEOF", "NEW", "RETURN", "SWITCH", "THIS", "THROW", "TRY", "TYPEOF", "VAR", "VOID", "WHILE", "WITH", "EACH", "ABSTRACT", "BOOLEAN", "BYTE", "CHAR", "CLASS", "CONST", "DEBUGGER", "DOUBLE", "ENUM", "EXPORT", "EXTENDS", "FINAL", "FLOAT", "GOTO", "IMPLEMENTS", "IMPORT", "INT", "INTERFACE", "LONG", "NATIVE", "PACKAGE", "SHORT", "STATIC", "SUPER", "SYNCHRONIZED", "THROWS", "TRANSIENT", "VOLATILE", "LBRACE", "RBRACE", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "DOT", "SEMIC", "COMMA", "LT", "GT", "LTE", "GTE", "EQ", "NEQ", "SAME", "NSAME", "ADD", "SUB", "MUL", "MOD", "INC", "DEC", "SHL", "SHR", "SHU", "AND", "OR", "XOR", "NOT", "INV", "LAND", "LOR", "QUE", "COLON", "ASSIGN", "ADDASS", "SUBASS", "MULASS", "MODASS", "SHLASS", "SHRASS", "SHUASS", "ANDASS", "ORASS", "XORASS", "DIV", "DIVASS", "ARGS", "ARRAY", "BLOCK", "BYFIELD", "BYINDEX", "CALL", "CEXPR", "EXPR", "FORITER", "FORSTEP", "ITEM", "LABELLED", "NAMEDVALUE", "NEG", "OBJECT", "PAREXPR", "PDEC", "PINC", "POS", "FUNBODY", "ROOT_ID", "BSLASH", "DQUOTE", "SQUOTE", "TAB", "VT", "FF", "SP", "NBSP", "USP", "WhiteSpace", "LF", "CR", "LS", "PS", "LineTerminator", "EOL", "MultiLineComment", "SingleLineComment", "Identifier", "StringLiteral", "HexDigit", "IdentifierStartASCII", "DecimalDigit", "IdentifierPart", "IdentifierNameASCIIStart", "RegularExpressionLiteral", "OctalDigit", "ExponentPart", "DecimalIntegerLiteral", "DecimalLiteral", "OctalIntegerLiteral", "HexIntegerLiteral", "CharacterEscapeSequence", "ZeroToThree", "OctalEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "EscapeSequence", "BackslashSequence", "RegularExpressionFirstChar", "RegularExpressionChar"
    };
    public static final int VT=134;
    public static final int LOR=93;
    public static final int FUNCTION=17;
    public static final int PACKAGE=53;
    public static final int SHR=85;
    public static final int RegularExpressionChar=170;
    public static final int LT=70;
    public static final int ROOT_ID=129;
    public static final int WHILE=30;
    public static final int MOD=81;
    public static final int SHL=84;
    public static final int CONST=38;
    public static final int BackslashSequence=168;
    public static final int LS=142;
    public static final int CASE=8;
    public static final int CHAR=36;
    public static final int NEW=21;
    public static final int DQUOTE=131;
    public static final int DO=13;
    public static final int NOT=90;
    public static final int DecimalDigit=152;
    public static final int BYFIELD=112;
    public static final int EOF=-1;
    public static final int CEXPR=115;
    public static final int BREAK=7;
    public static final int Identifier=148;
    public static final int DIVASS=108;
    public static final int BYINDEX=113;
    public static final int FORSTEP=118;
    public static final int FINAL=44;
    public static final int RPAREN=64;
    public static final int INC=82;
    public static final int IMPORT=48;
    public static final int EOL=145;
    public static final int POS=127;
    public static final int OctalDigit=156;
    public static final int THIS=24;
    public static final int RETURN=22;
    public static final int ExponentPart=157;
    public static final int ARGS=109;
    public static final int DOUBLE=40;
    public static final int WhiteSpace=139;
    public static final int VAR=28;
    public static final int EXPORT=42;
    public static final int VOID=29;
    public static final int LABELLED=120;
    public static final int EACH=32;
    public static final int SUPER=56;
    public static final int GOTO=46;
    public static final int EQ=74;
    public static final int XORASS=106;
    public static final int ADDASS=97;
    public static final int ARRAY=110;
    public static final int SHU=86;
    public static final int RBRACK=66;
    public static final int FUNBODY=128;
    public static final int RBRACE=62;
    public static final int STATIC=55;
    public static final int INV=91;
    public static final int SWITCH=23;
    public static final int NULL=4;
    public static final int ELSE=14;
    public static final int NATIVE=52;
    public static final int THROWS=58;
    public static final int INT=49;
    public static final int DELETE=12;
    public static final int MUL=80;
    public static final int IdentifierStartASCII=151;
    public static final int TRY=26;
    public static final int FF=135;
    public static final int SHLASS=101;
    public static final int OctalEscapeSequence=164;
    public static final int USP=138;
    public static final int RegularExpressionFirstChar=169;
    public static final int ANDASS=104;
    public static final int TYPEOF=27;
    public static final int IdentifierNameASCIIStart=154;
    public static final int QUE=94;
    public static final int OR=88;
    public static final int DEBUGGER=39;
    public static final int GT=71;
    public static final int PDEC=125;
    public static final int CALL=114;
    public static final int CharacterEscapeSequence=162;
    public static final int CATCH=9;
    public static final int FALSE=6;
    public static final int EscapeSequence=167;
    public static final int LAND=92;
    public static final int MULASS=99;
    public static final int THROW=25;
    public static final int PINC=126;
    public static final int OctalIntegerLiteral=160;
    public static final int DEC=83;
    public static final int CLASS=37;
    public static final int LBRACK=65;
    public static final int HexEscapeSequence=165;
    public static final int ORASS=105;
    public static final int SingleLineComment=147;
    public static final int NAMEDVALUE=121;
    public static final int LBRACE=61;
    public static final int GTE=73;
    public static final int FOR=16;
    public static final int RegularExpressionLiteral=155;
    public static final int SUB=79;
    public static final int FLOAT=45;
    public static final int ABSTRACT=33;
    public static final int AND=87;
    public static final int DecimalIntegerLiteral=158;
    public static final int HexDigit=150;
    public static final int LTE=72;
    public static final int LPAREN=63;
    public static final int IF=18;
    public static final int SUBASS=98;
    public static final int EXPR=116;
    public static final int BOOLEAN=34;
    public static final int SYNCHRONIZED=57;
    public static final int IN=19;
    public static final int IMPLEMENTS=47;
    public static final int OBJECT=123;
    public static final int CONTINUE=10;
    public static final int COMMA=69;
    public static final int FORITER=117;
    public static final int TRANSIENT=59;
    public static final int SHRASS=102;
    public static final int MODASS=100;
    public static final int PS=143;
    public static final int DOT=67;
    public static final int IdentifierPart=153;
    public static final int MultiLineComment=146;
    public static final int WITH=31;
    public static final int ADD=78;
    public static final int BYTE=35;
    public static final int XOR=89;
    public static final int ZeroToThree=163;
    public static final int ITEM=119;
    public static final int VOLATILE=60;
    public static final int UnicodeEscapeSequence=166;
    public static final int SHUASS=103;
    public static final int DEFAULT=11;
    public static final int NSAME=77;
    public static final int TAB=133;
    public static final int SHORT=54;
    public static final int INSTANCEOF=20;
    public static final int SQUOTE=132;
    public static final int DecimalLiteral=159;
    public static final int TRUE=5;
    public static final int SAME=76;
    public static final int StringLiteral=149;
    public static final int COLON=95;
    public static final int PAREXPR=124;
    public static final int NEQ=75;
    public static final int ENUM=41;
    public static final int FINALLY=15;
    public static final int HexIntegerLiteral=161;
    public static final int NBSP=137;
    public static final int SP=136;
    public static final int BLOCK=111;
    public static final int LineTerminator=144;
    public static final int NEG=122;
    public static final int ASSIGN=96;
    public static final int INTERFACE=50;
    public static final int DIV=107;
    public static final int SEMIC=68;
    public static final int CR=141;
    public static final int LONG=51;
    public static final int EXTENDS=43;
    public static final int BSLASH=130;
    public static final int LF=140;

    // delegates
    // delegators


        public ES3Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ES3Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return ES3Parser.tokenNames; }
    public String getGrammarFileName() { return "ES3.g"; }



    int varnameCounter = 0;
    private final boolean isLeftHandSideAssign(RuleReturnScope lhs, Object[] cached)
    {
    	if (cached[0] != null)
    	{
    		return ((Boolean)cached[0]).booleanValue();
    	}
    	
    	boolean result;
    	if (isLeftHandSideExpression(lhs))
    	{
    		switch (input.LA(1))
    		{
    			case ASSIGN:
    			case MULASS:
    			case DIVASS:
    			case MODASS:
    			case ADDASS:
    			case SUBASS:
    			case SHLASS:
    			case SHRASS:
    			case SHUASS:
    			case ANDASS:
    			case XORASS:
    			case ORASS:
    				result = true;
    				break;
    			default:
    				result = false;
    				break;
    		}
    	}
    	else
    	{
    		result = false;
    	}
    	
    	cached[0] = new Boolean(result);
    	return result;
    }

    private final static boolean isLeftHandSideExpression(RuleReturnScope lhs)
    {
    	if (lhs.getTree() == null) // e.g. during backtracking
    	{
    		return true;
    	}
    	else
    	{
    		switch (((Tree)lhs.getTree()).getType())
    		{
    		// primaryExpression
    			case THIS:
    			case Identifier:
    			case NULL:
    			case TRUE:
    			case FALSE:
    			case DecimalLiteral:
    			case OctalIntegerLiteral:
    			case HexIntegerLiteral:
    			case StringLiteral:
    			case RegularExpressionLiteral:
    			case ARRAY:
    			case OBJECT:
    			case PAREXPR:
    		// functionExpression
    			case FUNCTION:
    		// newExpression
    			case NEW:
    		// leftHandSideExpression
    			case CALL:
    			case BYFIELD:
    			case BYINDEX:
    				return true;
    			
    			default:
    				return false;
    		}
    	}
    }
    	
    private final boolean isLeftHandSideIn(RuleReturnScope lhs, Object[] cached)
    {
    	if (cached[0] != null)
    	{
    		return ((Boolean)cached[0]).booleanValue();
    	}
    	
    	boolean result = isLeftHandSideExpression(lhs) && (input.LA(1) == IN);
    	cached[0] = new Boolean(result);
    	return result;
    }

    private final void promoteEOL(ParserRuleReturnScope rule)
    {
    	// Get current token and its type (the possibly offending token).
    	Token lt = input.LT(1);
    	int la = lt.getType();
    	
    	// We only need to promote an EOL when the current token is offending (not a SEMIC, EOF, RBRACE, EOL or MultiLineComment).
    	// EOL and MultiLineComment are not offending as they're already promoted in a previous call to this method.
    	// Promoting an EOL means switching it from off channel to on channel.
    	// A MultiLineComment gets promoted when it contains an EOL.
    	if (!(la == SEMIC || la == EOF || la == RBRACE || la == EOL || la == MultiLineComment))
    	{
    		// Start on the possition before the current token and scan backwards off channel tokens until the previous on channel token.
    		for (int ix = lt.getTokenIndex() - 1; ix > 0; ix--)
    		{
    			lt = input.get(ix);
    			if (lt.getChannel() == Token.DEFAULT_CHANNEL)
    			{
    				// On channel token found: stop scanning.
    				break;
    			}
    			else if (lt.getType() == EOL || (lt.getType() == MultiLineComment && lt.getText().matches("/.*\r\n|\r|\n")))
    			{
    				// We found our EOL: promote the token to on channel, position the input on it and reset the rule start.
    				lt.setChannel(Token.DEFAULT_CHANNEL);
    				input.seek(lt.getTokenIndex());
    				if (rule != null)
    				{
    					rule.start = lt;
    				}
    				break;
    			}
    		}
    	}
    }

    private final String removeQuotes(String rule)	{
        //System.out.println("quotes removed: "+ rule.substring(1,rule.length()-1));
    	return rule.substring(1,rule.length()-1);
    }

    private final boolean isGetOrSet(String name){
    	return (name.equals("get") || name.equals("set")) ;
    }
    	


    public static class token_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "token"
    // ES3.g:528:1: token : ( reservedWord | Identifier | punctuator | numericLiteral | StringLiteral );
    public final ES3Parser.token_return token() throws RecognitionException {
        ES3Parser.token_return retval = new ES3Parser.token_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Identifier2=null;
        Token StringLiteral5=null;
        ES3Parser.reservedWord_return reservedWord1 = null;

        ES3Parser.punctuator_return punctuator3 = null;

        ES3Parser.numericLiteral_return numericLiteral4 = null;


        Object Identifier2_tree=null;
        Object StringLiteral5_tree=null;

        try {
            // ES3.g:529:2: ( reservedWord | Identifier | punctuator | numericLiteral | StringLiteral )
            int alt1=5;
            switch ( input.LA(1) ) {
            case NULL:
            case TRUE:
            case FALSE:
            case BREAK:
            case CASE:
            case CATCH:
            case CONTINUE:
            case DEFAULT:
            case DELETE:
            case DO:
            case ELSE:
            case FINALLY:
            case FOR:
            case FUNCTION:
            case IF:
            case IN:
            case INSTANCEOF:
            case NEW:
            case RETURN:
            case SWITCH:
            case THIS:
            case THROW:
            case TRY:
            case TYPEOF:
            case VAR:
            case VOID:
            case WHILE:
            case WITH:
            case EACH:
            case ABSTRACT:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CLASS:
            case CONST:
            case DEBUGGER:
            case DOUBLE:
            case ENUM:
            case EXPORT:
            case EXTENDS:
            case FINAL:
            case FLOAT:
            case GOTO:
            case IMPLEMENTS:
            case IMPORT:
            case INT:
            case INTERFACE:
            case LONG:
            case NATIVE:
            case PACKAGE:
            case SHORT:
            case STATIC:
            case SUPER:
            case SYNCHRONIZED:
            case THROWS:
            case TRANSIENT:
            case VOLATILE:
                {
                alt1=1;
                }
                break;
            case Identifier:
                {
                alt1=2;
                }
                break;
            case LBRACE:
            case RBRACE:
            case LPAREN:
            case RPAREN:
            case LBRACK:
            case RBRACK:
            case DOT:
            case SEMIC:
            case COMMA:
            case LT:
            case GT:
            case LTE:
            case GTE:
            case EQ:
            case NEQ:
            case SAME:
            case NSAME:
            case ADD:
            case SUB:
            case MUL:
            case MOD:
            case INC:
            case DEC:
            case SHL:
            case SHR:
            case SHU:
            case AND:
            case OR:
            case XOR:
            case NOT:
            case INV:
            case LAND:
            case LOR:
            case QUE:
            case COLON:
            case ASSIGN:
            case ADDASS:
            case SUBASS:
            case MULASS:
            case MODASS:
            case SHLASS:
            case SHRASS:
            case SHUASS:
            case ANDASS:
            case ORASS:
            case XORASS:
            case DIV:
            case DIVASS:
                {
                alt1=3;
                }
                break;
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt1=4;
                }
                break;
            case StringLiteral:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ES3.g:529:4: reservedWord
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_reservedWord_in_token1740);
                    reservedWord1=reservedWord();

                    state._fsp--;

                    adaptor.addChild(root_0, reservedWord1.getTree());

                    }
                    break;
                case 2 :
                    // ES3.g:530:4: Identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    Identifier2=(Token)match(input,Identifier,FOLLOW_Identifier_in_token1745); 
                    Identifier2_tree = (Object)adaptor.create(Identifier2);
                    adaptor.addChild(root_0, Identifier2_tree);


                    }
                    break;
                case 3 :
                    // ES3.g:531:4: punctuator
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_punctuator_in_token1750);
                    punctuator3=punctuator();

                    state._fsp--;

                    adaptor.addChild(root_0, punctuator3.getTree());

                    }
                    break;
                case 4 :
                    // ES3.g:532:4: numericLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numericLiteral_in_token1755);
                    numericLiteral4=numericLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, numericLiteral4.getTree());

                    }
                    break;
                case 5 :
                    // ES3.g:533:4: StringLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    StringLiteral5=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_token1760); 
                    StringLiteral5_tree = (Object)adaptor.create(StringLiteral5);
                    adaptor.addChild(root_0, StringLiteral5_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "token"

    public static class reservedWord_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "reservedWord"
    // ES3.g:538:1: reservedWord : ( keyword | futureReservedWord | NULL | booleanLiteral );
    public final ES3Parser.reservedWord_return reservedWord() throws RecognitionException {
        ES3Parser.reservedWord_return retval = new ES3Parser.reservedWord_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NULL8=null;
        ES3Parser.keyword_return keyword6 = null;

        ES3Parser.futureReservedWord_return futureReservedWord7 = null;

        ES3Parser.booleanLiteral_return booleanLiteral9 = null;


        Object NULL8_tree=null;

        try {
            // ES3.g:539:2: ( keyword | futureReservedWord | NULL | booleanLiteral )
            int alt2=4;
            switch ( input.LA(1) ) {
            case BREAK:
            case CASE:
            case CATCH:
            case CONTINUE:
            case DEFAULT:
            case DELETE:
            case DO:
            case ELSE:
            case FINALLY:
            case FOR:
            case FUNCTION:
            case IF:
            case IN:
            case INSTANCEOF:
            case NEW:
            case RETURN:
            case SWITCH:
            case THIS:
            case THROW:
            case TRY:
            case TYPEOF:
            case VAR:
            case VOID:
            case WHILE:
            case WITH:
            case EACH:
                {
                alt2=1;
                }
                break;
            case ABSTRACT:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CLASS:
            case CONST:
            case DEBUGGER:
            case DOUBLE:
            case ENUM:
            case EXPORT:
            case EXTENDS:
            case FINAL:
            case FLOAT:
            case GOTO:
            case IMPLEMENTS:
            case IMPORT:
            case INT:
            case INTERFACE:
            case LONG:
            case NATIVE:
            case PACKAGE:
            case SHORT:
            case STATIC:
            case SUPER:
            case SYNCHRONIZED:
            case THROWS:
            case TRANSIENT:
            case VOLATILE:
                {
                alt2=2;
                }
                break;
            case NULL:
                {
                alt2=3;
                }
                break;
            case TRUE:
            case FALSE:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ES3.g:539:4: keyword
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_keyword_in_reservedWord1773);
                    keyword6=keyword();

                    state._fsp--;

                    adaptor.addChild(root_0, keyword6.getTree());

                    }
                    break;
                case 2 :
                    // ES3.g:540:4: futureReservedWord
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_futureReservedWord_in_reservedWord1778);
                    futureReservedWord7=futureReservedWord();

                    state._fsp--;

                    adaptor.addChild(root_0, futureReservedWord7.getTree());

                    }
                    break;
                case 3 :
                    // ES3.g:541:4: NULL
                    {
                    root_0 = (Object)adaptor.nil();

                    NULL8=(Token)match(input,NULL,FOLLOW_NULL_in_reservedWord1783); 
                    NULL8_tree = (Object)adaptor.create(NULL8);
                    adaptor.addChild(root_0, NULL8_tree);


                    }
                    break;
                case 4 :
                    // ES3.g:542:4: booleanLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_booleanLiteral_in_reservedWord1788);
                    booleanLiteral9=booleanLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, booleanLiteral9.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "reservedWord"

    public static class keyword_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyword"
    // ES3.g:549:1: keyword : ( BREAK | CASE | CATCH | CONTINUE | DEFAULT | DELETE | DO | ELSE | FINALLY | FOR | EACH | FUNCTION | IF | IN | INSTANCEOF | NEW | RETURN | SWITCH | THIS | THROW | TRY | TYPEOF | VAR | VOID | WHILE | WITH );
    public final ES3Parser.keyword_return keyword() throws RecognitionException {
        ES3Parser.keyword_return retval = new ES3Parser.keyword_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set10=null;

        Object set10_tree=null;

        try {
            // ES3.g:550:2: ( BREAK | CASE | CATCH | CONTINUE | DEFAULT | DELETE | DO | ELSE | FINALLY | FOR | EACH | FUNCTION | IF | IN | INSTANCEOF | NEW | RETURN | SWITCH | THIS | THROW | TRY | TYPEOF | VAR | VOID | WHILE | WITH )
            // ES3.g:
            {
            root_0 = (Object)adaptor.nil();

            set10=(Token)input.LT(1);
            if ( (input.LA(1)>=BREAK && input.LA(1)<=EACH) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set10));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyword"

    public static class futureReservedWord_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "futureReservedWord"
    // ES3.g:582:1: futureReservedWord : ( ABSTRACT | BOOLEAN | BYTE | CHAR | CLASS | CONST | DEBUGGER | DOUBLE | ENUM | EXPORT | EXTENDS | FINAL | FLOAT | GOTO | IMPLEMENTS | IMPORT | INT | INTERFACE | LONG | NATIVE | PACKAGE | SHORT | STATIC | SUPER | SYNCHRONIZED | THROWS | TRANSIENT | VOLATILE );
    public final ES3Parser.futureReservedWord_return futureReservedWord() throws RecognitionException {
        ES3Parser.futureReservedWord_return retval = new ES3Parser.futureReservedWord_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set11=null;

        Object set11_tree=null;

        try {
            // ES3.g:583:2: ( ABSTRACT | BOOLEAN | BYTE | CHAR | CLASS | CONST | DEBUGGER | DOUBLE | ENUM | EXPORT | EXTENDS | FINAL | FLOAT | GOTO | IMPLEMENTS | IMPORT | INT | INTERFACE | LONG | NATIVE | PACKAGE | SHORT | STATIC | SUPER | SYNCHRONIZED | THROWS | TRANSIENT | VOLATILE )
            // ES3.g:
            {
            root_0 = (Object)adaptor.nil();

            set11=(Token)input.LT(1);
            if ( (input.LA(1)>=ABSTRACT && input.LA(1)<=VOLATILE) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set11));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "futureReservedWord"

    public static class punctuator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "punctuator"
    // ES3.g:657:1: punctuator : ( LBRACE | RBRACE | LPAREN | RPAREN | LBRACK | RBRACK | DOT | SEMIC | COMMA | LT | GT | LTE | GTE | EQ | NEQ | SAME | NSAME | ADD | SUB | MUL | MOD | INC | DEC | SHL | SHR | SHU | AND | OR | XOR | NOT | INV | LAND | LOR | QUE | COLON | ASSIGN | ADDASS | SUBASS | MULASS | MODASS | SHLASS | SHRASS | SHUASS | ANDASS | ORASS | XORASS | DIV | DIVASS );
    public final ES3Parser.punctuator_return punctuator() throws RecognitionException {
        ES3Parser.punctuator_return retval = new ES3Parser.punctuator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set12=null;

        Object set12_tree=null;

        try {
            // ES3.g:658:2: ( LBRACE | RBRACE | LPAREN | RPAREN | LBRACK | RBRACK | DOT | SEMIC | COMMA | LT | GT | LTE | GTE | EQ | NEQ | SAME | NSAME | ADD | SUB | MUL | MOD | INC | DEC | SHL | SHR | SHU | AND | OR | XOR | NOT | INV | LAND | LOR | QUE | COLON | ASSIGN | ADDASS | SUBASS | MULASS | MODASS | SHLASS | SHRASS | SHUASS | ANDASS | ORASS | XORASS | DIV | DIVASS )
            // ES3.g:
            {
            root_0 = (Object)adaptor.nil();

            set12=(Token)input.LT(1);
            if ( (input.LA(1)>=LBRACE && input.LA(1)<=DIVASS) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set12));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "punctuator"

    public static class literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal"
    // ES3.g:712:1: literal : ( NULL | booleanLiteral | numericLiteral | StringLiteral | RegularExpressionLiteral );
    public final ES3Parser.literal_return literal() throws RecognitionException {
        ES3Parser.literal_return retval = new ES3Parser.literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NULL13=null;
        Token StringLiteral16=null;
        Token RegularExpressionLiteral17=null;
        ES3Parser.booleanLiteral_return booleanLiteral14 = null;

        ES3Parser.numericLiteral_return numericLiteral15 = null;


        Object NULL13_tree=null;
        Object StringLiteral16_tree=null;
        Object RegularExpressionLiteral17_tree=null;

        try {
            // ES3.g:713:2: ( NULL | booleanLiteral | numericLiteral | StringLiteral | RegularExpressionLiteral )
            int alt3=5;
            switch ( input.LA(1) ) {
            case NULL:
                {
                alt3=1;
                }
                break;
            case TRUE:
            case FALSE:
                {
                alt3=2;
                }
                break;
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt3=3;
                }
                break;
            case StringLiteral:
                {
                alt3=4;
                }
                break;
            case RegularExpressionLiteral:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ES3.g:713:4: NULL
                    {
                    root_0 = (Object)adaptor.nil();

                    NULL13=(Token)match(input,NULL,FOLLOW_NULL_in_literal2459); 
                    NULL13_tree = (Object)adaptor.create(NULL13);
                    adaptor.addChild(root_0, NULL13_tree);


                    }
                    break;
                case 2 :
                    // ES3.g:714:4: booleanLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_booleanLiteral_in_literal2464);
                    booleanLiteral14=booleanLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, booleanLiteral14.getTree());

                    }
                    break;
                case 3 :
                    // ES3.g:715:4: numericLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numericLiteral_in_literal2469);
                    numericLiteral15=numericLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, numericLiteral15.getTree());

                    }
                    break;
                case 4 :
                    // ES3.g:716:4: StringLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    StringLiteral16=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_literal2474); 
                    StringLiteral16_tree = (Object)adaptor.create(StringLiteral16);
                    adaptor.addChild(root_0, StringLiteral16_tree);


                    }
                    break;
                case 5 :
                    // ES3.g:717:4: RegularExpressionLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    RegularExpressionLiteral17=(Token)match(input,RegularExpressionLiteral,FOLLOW_RegularExpressionLiteral_in_literal2479); 
                    RegularExpressionLiteral17_tree = (Object)adaptor.create(RegularExpressionLiteral17);
                    adaptor.addChild(root_0, RegularExpressionLiteral17_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "literal"

    public static class booleanLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "booleanLiteral"
    // ES3.g:720:1: booleanLiteral : ( TRUE | FALSE );
    public final ES3Parser.booleanLiteral_return booleanLiteral() throws RecognitionException {
        ES3Parser.booleanLiteral_return retval = new ES3Parser.booleanLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set18=null;

        Object set18_tree=null;

        try {
            // ES3.g:721:2: ( TRUE | FALSE )
            // ES3.g:
            {
            root_0 = (Object)adaptor.nil();

            set18=(Token)input.LT(1);
            if ( (input.LA(1)>=TRUE && input.LA(1)<=FALSE) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set18));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "booleanLiteral"

    public static class numericLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "numericLiteral"
    // ES3.g:767:1: numericLiteral : ( DecimalLiteral | OctalIntegerLiteral | HexIntegerLiteral );
    public final ES3Parser.numericLiteral_return numericLiteral() throws RecognitionException {
        ES3Parser.numericLiteral_return retval = new ES3Parser.numericLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set19=null;

        Object set19_tree=null;

        try {
            // ES3.g:768:2: ( DecimalLiteral | OctalIntegerLiteral | HexIntegerLiteral )
            // ES3.g:
            {
            root_0 = (Object)adaptor.nil();

            set19=(Token)input.LT(1);
            if ( (input.LA(1)>=DecimalLiteral && input.LA(1)<=HexIntegerLiteral) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set19));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "numericLiteral"

    public static class primaryExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primaryExpression"
    // ES3.g:855:1: primaryExpression : ( THIS | Identifier | literal | arrayLiteral | objectLiteral | lpar= LPAREN expression RPAREN -> ^( PAREXPR[$lpar, \"PAREXPR\"] expression ) );
    public final ES3Parser.primaryExpression_return primaryExpression() throws RecognitionException {
        ES3Parser.primaryExpression_return retval = new ES3Parser.primaryExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token lpar=null;
        Token THIS20=null;
        Token Identifier21=null;
        Token RPAREN26=null;
        ES3Parser.literal_return literal22 = null;

        ES3Parser.arrayLiteral_return arrayLiteral23 = null;

        ES3Parser.objectLiteral_return objectLiteral24 = null;

        ES3Parser.expression_return expression25 = null;


        Object lpar_tree=null;
        Object THIS20_tree=null;
        Object Identifier21_tree=null;
        Object RPAREN26_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // ES3.g:856:2: ( THIS | Identifier | literal | arrayLiteral | objectLiteral | lpar= LPAREN expression RPAREN -> ^( PAREXPR[$lpar, \"PAREXPR\"] expression ) )
            int alt4=6;
            switch ( input.LA(1) ) {
            case THIS:
                {
                alt4=1;
                }
                break;
            case Identifier:
                {
                alt4=2;
                }
                break;
            case NULL:
            case TRUE:
            case FALSE:
            case StringLiteral:
            case RegularExpressionLiteral:
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt4=3;
                }
                break;
            case LBRACK:
                {
                alt4=4;
                }
                break;
            case LBRACE:
                {
                alt4=5;
                }
                break;
            case LPAREN:
                {
                alt4=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ES3.g:856:4: THIS
                    {
                    root_0 = (Object)adaptor.nil();

                    THIS20=(Token)match(input,THIS,FOLLOW_THIS_in_primaryExpression3102); 
                    THIS20_tree = (Object)adaptor.create(THIS20);
                    adaptor.addChild(root_0, THIS20_tree);


                    }
                    break;
                case 2 :
                    // ES3.g:857:4: Identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    Identifier21=(Token)match(input,Identifier,FOLLOW_Identifier_in_primaryExpression3107); 
                    Identifier21_tree = (Object)adaptor.create(Identifier21);
                    adaptor.addChild(root_0, Identifier21_tree);


                    }
                    break;
                case 3 :
                    // ES3.g:858:4: literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primaryExpression3112);
                    literal22=literal();

                    state._fsp--;

                    adaptor.addChild(root_0, literal22.getTree());

                    }
                    break;
                case 4 :
                    // ES3.g:859:4: arrayLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_arrayLiteral_in_primaryExpression3117);
                    arrayLiteral23=arrayLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayLiteral23.getTree());

                    }
                    break;
                case 5 :
                    // ES3.g:860:4: objectLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_objectLiteral_in_primaryExpression3122);
                    objectLiteral24=objectLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, objectLiteral24.getTree());

                    }
                    break;
                case 6 :
                    // ES3.g:861:4: lpar= LPAREN expression RPAREN
                    {
                    lpar=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpression3129);  
                    stream_LPAREN.add(lpar);

                    pushFollow(FOLLOW_expression_in_primaryExpression3131);
                    expression25=expression();

                    state._fsp--;

                    stream_expression.add(expression25.getTree());
                    RPAREN26=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpression3133);  
                    stream_RPAREN.add(RPAREN26);



                    // AST REWRITE
                    // elements: expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 861:34: -> ^( PAREXPR[$lpar, \"PAREXPR\"] expression )
                    {
                        // ES3.g:861:37: ^( PAREXPR[$lpar, \"PAREXPR\"] expression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PAREXPR, lpar, "PAREXPR"), root_1);

                        adaptor.addChild(root_1, stream_expression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "primaryExpression"

    public static class arrayLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayLiteral"
    // ES3.g:864:1: arrayLiteral : lb= LBRACK ( arrayItem ( COMMA arrayItem )* )? RBRACK -> ^( ARRAY[$lb, \"ARRAY\"] ( arrayItem )* ) ;
    public final ES3Parser.arrayLiteral_return arrayLiteral() throws RecognitionException {
        ES3Parser.arrayLiteral_return retval = new ES3Parser.arrayLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token lb=null;
        Token COMMA28=null;
        Token RBRACK30=null;
        ES3Parser.arrayItem_return arrayItem27 = null;

        ES3Parser.arrayItem_return arrayItem29 = null;


        Object lb_tree=null;
        Object COMMA28_tree=null;
        Object RBRACK30_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_arrayItem=new RewriteRuleSubtreeStream(adaptor,"rule arrayItem");
        try {
            // ES3.g:865:2: (lb= LBRACK ( arrayItem ( COMMA arrayItem )* )? RBRACK -> ^( ARRAY[$lb, \"ARRAY\"] ( arrayItem )* ) )
            // ES3.g:865:4: lb= LBRACK ( arrayItem ( COMMA arrayItem )* )? RBRACK
            {
            lb=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayLiteral3157);  
            stream_LBRACK.add(lb);

            // ES3.g:865:14: ( arrayItem ( COMMA arrayItem )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=NULL && LA6_0<=FALSE)||LA6_0==DELETE||LA6_0==FUNCTION||LA6_0==NEW||LA6_0==THIS||LA6_0==TYPEOF||LA6_0==VOID||LA6_0==LBRACE||LA6_0==LPAREN||LA6_0==LBRACK||LA6_0==COMMA||(LA6_0>=ADD && LA6_0<=SUB)||(LA6_0>=INC && LA6_0<=DEC)||(LA6_0>=NOT && LA6_0<=INV)||(LA6_0>=Identifier && LA6_0<=StringLiteral)||LA6_0==RegularExpressionLiteral||(LA6_0>=DecimalLiteral && LA6_0<=HexIntegerLiteral)) ) {
                alt6=1;
            }
            else if ( (LA6_0==RBRACK) ) {
                int LA6_2 = input.LA(2);

                if ( (( input.LA(1) == COMMA )) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // ES3.g:865:16: arrayItem ( COMMA arrayItem )*
                    {
                    pushFollow(FOLLOW_arrayItem_in_arrayLiteral3161);
                    arrayItem27=arrayItem();

                    state._fsp--;

                    stream_arrayItem.add(arrayItem27.getTree());
                    // ES3.g:865:26: ( COMMA arrayItem )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==COMMA) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ES3.g:865:28: COMMA arrayItem
                    	    {
                    	    COMMA28=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayLiteral3165);  
                    	    stream_COMMA.add(COMMA28);

                    	    pushFollow(FOLLOW_arrayItem_in_arrayLiteral3167);
                    	    arrayItem29=arrayItem();

                    	    state._fsp--;

                    	    stream_arrayItem.add(arrayItem29.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            RBRACK30=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayLiteral3175);  
            stream_RBRACK.add(RBRACK30);



            // AST REWRITE
            // elements: arrayItem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 866:2: -> ^( ARRAY[$lb, \"ARRAY\"] ( arrayItem )* )
            {
                // ES3.g:866:5: ^( ARRAY[$lb, \"ARRAY\"] ( arrayItem )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAY, lb, "ARRAY"), root_1);

                // ES3.g:866:28: ( arrayItem )*
                while ( stream_arrayItem.hasNext() ) {
                    adaptor.addChild(root_1, stream_arrayItem.nextTree());

                }
                stream_arrayItem.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayLiteral"

    public static class arrayItem_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayItem"
    // ES3.g:869:1: arrayItem : (expr= assignmentExpression | {...}?) -> ^( ITEM ( $expr)? ) ;
    public final ES3Parser.arrayItem_return arrayItem() throws RecognitionException {
        ES3Parser.arrayItem_return retval = new ES3Parser.arrayItem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ES3Parser.assignmentExpression_return expr = null;


        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            // ES3.g:870:2: ( (expr= assignmentExpression | {...}?) -> ^( ITEM ( $expr)? ) )
            // ES3.g:870:4: (expr= assignmentExpression | {...}?)
            {
            // ES3.g:870:4: (expr= assignmentExpression | {...}?)
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=NULL && LA7_0<=FALSE)||LA7_0==DELETE||LA7_0==FUNCTION||LA7_0==NEW||LA7_0==THIS||LA7_0==TYPEOF||LA7_0==VOID||LA7_0==LBRACE||LA7_0==LPAREN||LA7_0==LBRACK||(LA7_0>=ADD && LA7_0<=SUB)||(LA7_0>=INC && LA7_0<=DEC)||(LA7_0>=NOT && LA7_0<=INV)||(LA7_0>=Identifier && LA7_0<=StringLiteral)||LA7_0==RegularExpressionLiteral||(LA7_0>=DecimalLiteral && LA7_0<=HexIntegerLiteral)) ) {
                alt7=1;
            }
            else if ( (LA7_0==RBRACK||LA7_0==COMMA) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ES3.g:870:6: expr= assignmentExpression
                    {
                    pushFollow(FOLLOW_assignmentExpression_in_arrayItem3203);
                    expr=assignmentExpression();

                    state._fsp--;

                    stream_assignmentExpression.add(expr.getTree());

                    }
                    break;
                case 2 :
                    // ES3.g:870:34: {...}?
                    {
                    if ( !(( input.LA(1) == COMMA )) ) {
                        throw new FailedPredicateException(input, "arrayItem", " input.LA(1) == COMMA ");
                    }

                    }
                    break;

            }



            // AST REWRITE
            // elements: expr
            // token labels: 
            // rule labels: retval, expr
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"token expr",expr!=null?expr.tree:null);

            root_0 = (Object)adaptor.nil();
            // 871:2: -> ^( ITEM ( $expr)? )
            {
                // ES3.g:871:5: ^( ITEM ( $expr)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ITEM, "ITEM"), root_1);

                // ES3.g:871:13: ( $expr)?
                if ( stream_expr.hasNext() ) {
                    adaptor.addChild(root_1, stream_expr.nextTree());

                }
                stream_expr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayItem"

    public static class objectLiteral_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objectLiteral"
    // ES3.g:874:1: objectLiteral : lb= LBRACE ( nameValuePair ( COMMA nameValuePair )* )? ( COMMA )? RBRACE -> ^( OBJECT[$lb, \"OBJECT\"] ( nameValuePair )* ) ;
    public final ES3Parser.objectLiteral_return objectLiteral() throws RecognitionException {
        ES3Parser.objectLiteral_return retval = new ES3Parser.objectLiteral_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token lb=null;
        Token COMMA32=null;
        Token COMMA34=null;
        Token RBRACE35=null;
        ES3Parser.nameValuePair_return nameValuePair31 = null;

        ES3Parser.nameValuePair_return nameValuePair33 = null;


        Object lb_tree=null;
        Object COMMA32_tree=null;
        Object COMMA34_tree=null;
        Object RBRACE35_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_nameValuePair=new RewriteRuleSubtreeStream(adaptor,"rule nameValuePair");
        try {
            // ES3.g:875:2: (lb= LBRACE ( nameValuePair ( COMMA nameValuePair )* )? ( COMMA )? RBRACE -> ^( OBJECT[$lb, \"OBJECT\"] ( nameValuePair )* ) )
            // ES3.g:875:4: lb= LBRACE ( nameValuePair ( COMMA nameValuePair )* )? ( COMMA )? RBRACE
            {
            lb=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_objectLiteral3235);  
            stream_LBRACE.add(lb);

            // ES3.g:875:14: ( nameValuePair ( COMMA nameValuePair )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=Identifier && LA9_0<=StringLiteral)||(LA9_0>=DecimalLiteral && LA9_0<=HexIntegerLiteral)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ES3.g:875:16: nameValuePair ( COMMA nameValuePair )*
                    {
                    pushFollow(FOLLOW_nameValuePair_in_objectLiteral3239);
                    nameValuePair31=nameValuePair();

                    state._fsp--;

                    stream_nameValuePair.add(nameValuePair31.getTree());
                    // ES3.g:875:30: ( COMMA nameValuePair )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==COMMA) ) {
                            int LA8_1 = input.LA(2);

                            if ( ((LA8_1>=Identifier && LA8_1<=StringLiteral)||(LA8_1>=DecimalLiteral && LA8_1<=HexIntegerLiteral)) ) {
                                alt8=1;
                            }


                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ES3.g:875:32: COMMA nameValuePair
                    	    {
                    	    COMMA32=(Token)match(input,COMMA,FOLLOW_COMMA_in_objectLiteral3243);  
                    	    stream_COMMA.add(COMMA32);

                    	    pushFollow(FOLLOW_nameValuePair_in_objectLiteral3245);
                    	    nameValuePair33=nameValuePair();

                    	    state._fsp--;

                    	    stream_nameValuePair.add(nameValuePair33.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            // ES3.g:875:58: ( COMMA )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==COMMA) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ES3.g:875:58: COMMA
                    {
                    COMMA34=(Token)match(input,COMMA,FOLLOW_COMMA_in_objectLiteral3253);  
                    stream_COMMA.add(COMMA34);


                    }
                    break;

            }

            RBRACE35=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_objectLiteral3256);  
            stream_RBRACE.add(RBRACE35);



            // AST REWRITE
            // elements: nameValuePair
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 876:2: -> ^( OBJECT[$lb, \"OBJECT\"] ( nameValuePair )* )
            {
                // ES3.g:876:5: ^( OBJECT[$lb, \"OBJECT\"] ( nameValuePair )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OBJECT, lb, "OBJECT"), root_1);

                // ES3.g:876:30: ( nameValuePair )*
                while ( stream_nameValuePair.hasNext() ) {
                    adaptor.addChild(root_1, stream_nameValuePair.nextTree());

                }
                stream_nameValuePair.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "objectLiteral"

    public static class nameValuePair_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nameValuePair"
    // ES3.g:879:1: nameValuePair : ( propertyName COLON assignmentExpression -> ^( NAMEDVALUE propertyName assignmentExpression ) | getterOrSetterExpression );
    public final ES3Parser.nameValuePair_return nameValuePair() throws RecognitionException {
        ES3Parser.nameValuePair_return retval = new ES3Parser.nameValuePair_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON37=null;
        ES3Parser.propertyName_return propertyName36 = null;

        ES3Parser.assignmentExpression_return assignmentExpression38 = null;

        ES3Parser.getterOrSetterExpression_return getterOrSetterExpression39 = null;


        Object COLON37_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleSubtreeStream stream_propertyName=new RewriteRuleSubtreeStream(adaptor,"rule propertyName");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            // ES3.g:880:2: ( propertyName COLON assignmentExpression -> ^( NAMEDVALUE propertyName assignmentExpression ) | getterOrSetterExpression )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Identifier) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==Identifier) ) {
                    alt11=2;
                }
                else if ( (LA11_1==COLON) ) {
                    alt11=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA11_0==StringLiteral||(LA11_0>=DecimalLiteral && LA11_0<=HexIntegerLiteral)) ) {
                alt11=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ES3.g:880:4: propertyName COLON assignmentExpression
                    {
                    pushFollow(FOLLOW_propertyName_in_nameValuePair3281);
                    propertyName36=propertyName();

                    state._fsp--;

                    stream_propertyName.add(propertyName36.getTree());
                    COLON37=(Token)match(input,COLON,FOLLOW_COLON_in_nameValuePair3283);  
                    stream_COLON.add(COLON37);

                    pushFollow(FOLLOW_assignmentExpression_in_nameValuePair3285);
                    assignmentExpression38=assignmentExpression();

                    state._fsp--;

                    stream_assignmentExpression.add(assignmentExpression38.getTree());


                    // AST REWRITE
                    // elements: assignmentExpression, propertyName
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 880:44: -> ^( NAMEDVALUE propertyName assignmentExpression )
                    {
                        // ES3.g:880:47: ^( NAMEDVALUE propertyName assignmentExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NAMEDVALUE, "NAMEDVALUE"), root_1);

                        adaptor.addChild(root_1, stream_propertyName.nextTree());
                        adaptor.addChild(root_1, stream_assignmentExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // ES3.g:881:4: getterOrSetterExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_getterOrSetterExpression_in_nameValuePair3302);
                    getterOrSetterExpression39=getterOrSetterExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getterOrSetterExpression39.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nameValuePair"

    public static class getterOrSetterExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getterOrSetterExpression"
    // ES3.g:884:1: getterOrSetterExpression : getorset= Identifier name= Identifier formalParameterList functionBody -> ^( FUNCTION $name formalParameterList functionBody ) ;
    public final ES3Parser.getterOrSetterExpression_return getterOrSetterExpression() throws RecognitionException {
        ES3Parser.getterOrSetterExpression_return retval = new ES3Parser.getterOrSetterExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token getorset=null;
        Token name=null;
        ES3Parser.formalParameterList_return formalParameterList40 = null;

        ES3Parser.functionBody_return functionBody41 = null;


        Object getorset_tree=null;
        Object name_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_functionBody=new RewriteRuleSubtreeStream(adaptor,"rule functionBody");
        RewriteRuleSubtreeStream stream_formalParameterList=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterList");
        try {
            // ES3.g:885:2: (getorset= Identifier name= Identifier formalParameterList functionBody -> ^( FUNCTION $name formalParameterList functionBody ) )
            // ES3.g:885:4: getorset= Identifier name= Identifier formalParameterList functionBody
            {
            getorset=(Token)match(input,Identifier,FOLLOW_Identifier_in_getterOrSetterExpression3316);  
            stream_Identifier.add(getorset);

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_getterOrSetterExpression3320);  
            stream_Identifier.add(name);

            pushFollow(FOLLOW_formalParameterList_in_getterOrSetterExpression3322);
            formalParameterList40=formalParameterList();

            state._fsp--;

            stream_formalParameterList.add(formalParameterList40.getTree());
            pushFollow(FOLLOW_functionBody_in_getterOrSetterExpression3324);
            functionBody41=functionBody();

            state._fsp--;

            stream_functionBody.add(functionBody41.getTree());


            // AST REWRITE
            // elements: formalParameterList, functionBody, name
            // token labels: name
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 886:2: -> ^( FUNCTION $name formalParameterList functionBody )
            {
                // ES3.g:886:6: ^( FUNCTION $name formalParameterList functionBody )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_formalParameterList.nextTree());
                adaptor.addChild(root_1, stream_functionBody.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getterOrSetterExpression"

    public static class propertyName_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "propertyName"
    // ES3.g:893:1: propertyName : ( Identifier | StringLiteral | numericLiteral );
    public final ES3Parser.propertyName_return propertyName() throws RecognitionException {
        ES3Parser.propertyName_return retval = new ES3Parser.propertyName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Identifier42=null;
        Token StringLiteral43=null;
        ES3Parser.numericLiteral_return numericLiteral44 = null;


        Object Identifier42_tree=null;
        Object StringLiteral43_tree=null;

        try {
            // ES3.g:894:2: ( Identifier | StringLiteral | numericLiteral )
            int alt12=3;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt12=1;
                }
                break;
            case StringLiteral:
                {
                alt12=2;
                }
                break;
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ES3.g:894:4: Identifier
                    {
                    root_0 = (Object)adaptor.nil();

                    Identifier42=(Token)match(input,Identifier,FOLLOW_Identifier_in_propertyName3356); 
                    Identifier42_tree = (Object)adaptor.create(Identifier42);
                    adaptor.addChild(root_0, Identifier42_tree);


                    }
                    break;
                case 2 :
                    // ES3.g:895:4: StringLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    StringLiteral43=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_propertyName3361); 
                    StringLiteral43_tree = (Object)adaptor.create(StringLiteral43);
                    adaptor.addChild(root_0, StringLiteral43_tree);


                    }
                    break;
                case 3 :
                    // ES3.g:896:4: numericLiteral
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_numericLiteral_in_propertyName3366);
                    numericLiteral44=numericLiteral();

                    state._fsp--;

                    adaptor.addChild(root_0, numericLiteral44.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "propertyName"

    public static class memberExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "memberExpression"
    // ES3.g:908:1: memberExpression : ( primaryExpression | functionExpression | newExpression );
    public final ES3Parser.memberExpression_return memberExpression() throws RecognitionException {
        ES3Parser.memberExpression_return retval = new ES3Parser.memberExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ES3Parser.primaryExpression_return primaryExpression45 = null;

        ES3Parser.functionExpression_return functionExpression46 = null;

        ES3Parser.newExpression_return newExpression47 = null;



        try {
            // ES3.g:909:2: ( primaryExpression | functionExpression | newExpression )
            int alt13=3;
            switch ( input.LA(1) ) {
            case NULL:
            case TRUE:
            case FALSE:
            case THIS:
            case LBRACE:
            case LPAREN:
            case LBRACK:
            case Identifier:
            case StringLiteral:
            case RegularExpressionLiteral:
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt13=1;
                }
                break;
            case FUNCTION:
                {
                alt13=2;
                }
                break;
            case NEW:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ES3.g:909:4: primaryExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primaryExpression_in_memberExpression3384);
                    primaryExpression45=primaryExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, primaryExpression45.getTree());

                    }
                    break;
                case 2 :
                    // ES3.g:910:4: functionExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionExpression_in_memberExpression3389);
                    functionExpression46=functionExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, functionExpression46.getTree());

                    }
                    break;
                case 3 :
                    // ES3.g:911:4: newExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_newExpression_in_memberExpression3394);
                    newExpression47=newExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, newExpression47.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "memberExpression"

    public static class newExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "newExpression"
    // ES3.g:914:1: newExpression : NEW leftHandSideExpression ;
    public final ES3Parser.newExpression_return newExpression() throws RecognitionException {
        ES3Parser.newExpression_return retval = new ES3Parser.newExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token NEW48=null;
        ES3Parser.leftHandSideExpression_return leftHandSideExpression49 = null;


        Object NEW48_tree=null;

        try {
            // ES3.g:915:2: ( NEW leftHandSideExpression )
            // ES3.g:915:4: NEW leftHandSideExpression
            {
            root_0 = (Object)adaptor.nil();

            NEW48=(Token)match(input,NEW,FOLLOW_NEW_in_newExpression3405); 
            NEW48_tree = (Object)adaptor.create(NEW48);
            root_0 = (Object)adaptor.becomeRoot(NEW48_tree, root_0);

            pushFollow(FOLLOW_leftHandSideExpression_in_newExpression3408);
            leftHandSideExpression49=leftHandSideExpression();

            state._fsp--;

            adaptor.addChild(root_0, leftHandSideExpression49.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "newExpression"

    public static class arguments_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arguments"
    // ES3.g:919:1: arguments : LPAREN ( assignmentExpression ( COMMA assignmentExpression )* )? RPAREN -> ^( ARGS ( assignmentExpression )* ) ;
    public final ES3Parser.arguments_return arguments() throws RecognitionException {
        ES3Parser.arguments_return retval = new ES3Parser.arguments_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN50=null;
        Token COMMA52=null;
        Token RPAREN54=null;
        ES3Parser.assignmentExpression_return assignmentExpression51 = null;

        ES3Parser.assignmentExpression_return assignmentExpression53 = null;


        Object LPAREN50_tree=null;
        Object COMMA52_tree=null;
        Object RPAREN54_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            // ES3.g:920:2: ( LPAREN ( assignmentExpression ( COMMA assignmentExpression )* )? RPAREN -> ^( ARGS ( assignmentExpression )* ) )
            // ES3.g:920:4: LPAREN ( assignmentExpression ( COMMA assignmentExpression )* )? RPAREN
            {
            LPAREN50=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_arguments3422);  
            stream_LPAREN.add(LPAREN50);

            // ES3.g:920:11: ( assignmentExpression ( COMMA assignmentExpression )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=NULL && LA15_0<=FALSE)||LA15_0==DELETE||LA15_0==FUNCTION||LA15_0==NEW||LA15_0==THIS||LA15_0==TYPEOF||LA15_0==VOID||LA15_0==LBRACE||LA15_0==LPAREN||LA15_0==LBRACK||(LA15_0>=ADD && LA15_0<=SUB)||(LA15_0>=INC && LA15_0<=DEC)||(LA15_0>=NOT && LA15_0<=INV)||(LA15_0>=Identifier && LA15_0<=StringLiteral)||LA15_0==RegularExpressionLiteral||(LA15_0>=DecimalLiteral && LA15_0<=HexIntegerLiteral)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ES3.g:920:13: assignmentExpression ( COMMA assignmentExpression )*
                    {
                    pushFollow(FOLLOW_assignmentExpression_in_arguments3426);
                    assignmentExpression51=assignmentExpression();

                    state._fsp--;

                    stream_assignmentExpression.add(assignmentExpression51.getTree());
                    // ES3.g:920:34: ( COMMA assignmentExpression )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==COMMA) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ES3.g:920:36: COMMA assignmentExpression
                    	    {
                    	    COMMA52=(Token)match(input,COMMA,FOLLOW_COMMA_in_arguments3430);  
                    	    stream_COMMA.add(COMMA52);

                    	    pushFollow(FOLLOW_assignmentExpression_in_arguments3432);
                    	    assignmentExpression53=assignmentExpression();

                    	    state._fsp--;

                    	    stream_assignmentExpression.add(assignmentExpression53.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            RPAREN54=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_arguments3440);  
            stream_RPAREN.add(RPAREN54);



            // AST REWRITE
            // elements: assignmentExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 921:2: -> ^( ARGS ( assignmentExpression )* )
            {
                // ES3.g:921:5: ^( ARGS ( assignmentExpression )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGS, "ARGS"), root_1);

                // ES3.g:921:13: ( assignmentExpression )*
                while ( stream_assignmentExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_assignmentExpression.nextTree());

                }
                stream_assignmentExpression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arguments"

    public static class leftHandSideExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "leftHandSideExpression"
    // ES3.g:924:1: leftHandSideExpression : ( memberExpression -> memberExpression ) ( arguments -> ^( CALL $leftHandSideExpression arguments ) | LBRACK ex= expression RBRACK -> ^( BYINDEX $leftHandSideExpression expression ) | DOT Identifier -> ^( BYFIELD $leftHandSideExpression Identifier ) )* ;
    public final ES3Parser.leftHandSideExpression_return leftHandSideExpression() throws RecognitionException {
        ES3Parser.leftHandSideExpression_return retval = new ES3Parser.leftHandSideExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBRACK57=null;
        Token RBRACK58=null;
        Token DOT59=null;
        Token Identifier60=null;
        ES3Parser.expression_return ex = null;

        ES3Parser.memberExpression_return memberExpression55 = null;

        ES3Parser.arguments_return arguments56 = null;


        Object LBRACK57_tree=null;
        Object RBRACK58_tree=null;
        Object DOT59_tree=null;
        Object Identifier60_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_memberExpression=new RewriteRuleSubtreeStream(adaptor,"rule memberExpression");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_arguments=new RewriteRuleSubtreeStream(adaptor,"rule arguments");
        try {
            // ES3.g:925:2: ( ( memberExpression -> memberExpression ) ( arguments -> ^( CALL $leftHandSideExpression arguments ) | LBRACK ex= expression RBRACK -> ^( BYINDEX $leftHandSideExpression expression ) | DOT Identifier -> ^( BYFIELD $leftHandSideExpression Identifier ) )* )
            // ES3.g:926:2: ( memberExpression -> memberExpression ) ( arguments -> ^( CALL $leftHandSideExpression arguments ) | LBRACK ex= expression RBRACK -> ^( BYINDEX $leftHandSideExpression expression ) | DOT Identifier -> ^( BYFIELD $leftHandSideExpression Identifier ) )*
            {
            // ES3.g:926:2: ( memberExpression -> memberExpression )
            // ES3.g:927:3: memberExpression
            {
            pushFollow(FOLLOW_memberExpression_in_leftHandSideExpression3469);
            memberExpression55=memberExpression();

            state._fsp--;

            stream_memberExpression.add(memberExpression55.getTree());


            // AST REWRITE
            // elements: memberExpression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 927:22: -> memberExpression
            {
                adaptor.addChild(root_0, stream_memberExpression.nextTree());

            }

            retval.tree = root_0;
            }

            // ES3.g:929:2: ( arguments -> ^( CALL $leftHandSideExpression arguments ) | LBRACK ex= expression RBRACK -> ^( BYINDEX $leftHandSideExpression expression ) | DOT Identifier -> ^( BYFIELD $leftHandSideExpression Identifier ) )*
            loop16:
            do {
                int alt16=4;
                switch ( input.LA(1) ) {
                case LPAREN:
                    {
                    alt16=1;
                    }
                    break;
                case LBRACK:
                    {
                    alt16=2;
                    }
                    break;
                case DOT:
                    {
                    alt16=3;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // ES3.g:930:3: arguments
            	    {
            	    pushFollow(FOLLOW_arguments_in_leftHandSideExpression3485);
            	    arguments56=arguments();

            	    state._fsp--;

            	    stream_arguments.add(arguments56.getTree());


            	    // AST REWRITE
            	    // elements: leftHandSideExpression, arguments
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 930:13: -> ^( CALL $leftHandSideExpression arguments )
            	    {
            	        // ES3.g:930:16: ^( CALL $leftHandSideExpression arguments )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CALL, "CALL"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_arguments.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;
            	case 2 :
            	    // ES3.g:931:5: LBRACK ex= expression RBRACK
            	    {
            	    LBRACK57=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_leftHandSideExpression3505);  
            	    stream_LBRACK.add(LBRACK57);

            	    pushFollow(FOLLOW_expression_in_leftHandSideExpression3509);
            	    ex=expression();

            	    state._fsp--;

            	    stream_expression.add(ex.getTree());
            	    RBRACK58=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_leftHandSideExpression3511);  
            	    stream_RBRACK.add(RBRACK58);



            	    // AST REWRITE
            	    // elements: expression, leftHandSideExpression
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 931:34: -> ^( BYINDEX $leftHandSideExpression expression )
            	    {
            	        // ES3.g:931:37: ^( BYINDEX $leftHandSideExpression expression )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BYINDEX, "BYINDEX"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_expression.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;
            	case 3 :
            	    // ES3.g:932:5: DOT Identifier
            	    {
            	    DOT59=(Token)match(input,DOT,FOLLOW_DOT_in_leftHandSideExpression3532);  
            	    stream_DOT.add(DOT59);

            	    Identifier60=(Token)match(input,Identifier,FOLLOW_Identifier_in_leftHandSideExpression3534);  
            	    stream_Identifier.add(Identifier60);



            	    // AST REWRITE
            	    // elements: leftHandSideExpression, Identifier
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 932:21: -> ^( BYFIELD $leftHandSideExpression Identifier )
            	    {
            	        // ES3.g:932:24: ^( BYFIELD $leftHandSideExpression Identifier )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BYFIELD, "BYFIELD"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_Identifier.nextNode());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;
            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "leftHandSideExpression"

    public static class postfixExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "postfixExpression"
    // ES3.g:946:1: postfixExpression : leftHandSideExpression ( postfixOperator )? ;
    public final ES3Parser.postfixExpression_return postfixExpression() throws RecognitionException {
        ES3Parser.postfixExpression_return retval = new ES3Parser.postfixExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ES3Parser.leftHandSideExpression_return leftHandSideExpression61 = null;

        ES3Parser.postfixOperator_return postfixOperator62 = null;



        try {
            // ES3.g:947:2: ( leftHandSideExpression ( postfixOperator )? )
            // ES3.g:947:4: leftHandSideExpression ( postfixOperator )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_leftHandSideExpression_in_postfixExpression3571);
            leftHandSideExpression61=leftHandSideExpression();

            state._fsp--;

            adaptor.addChild(root_0, leftHandSideExpression61.getTree());
             if (input.LA(1) == INC || input.LA(1) == DEC) promoteEOL(null); 
            // ES3.g:947:95: ( postfixOperator )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=INC && LA17_0<=DEC)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ES3.g:947:97: postfixOperator
                    {
                    pushFollow(FOLLOW_postfixOperator_in_postfixExpression3577);
                    postfixOperator62=postfixOperator();

                    state._fsp--;

                    root_0 = (Object)adaptor.becomeRoot(postfixOperator62.getTree(), root_0);

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "postfixExpression"

    public static class postfixOperator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "postfixOperator"
    // ES3.g:950:1: postfixOperator : (op= INC | op= DEC );
    public final ES3Parser.postfixOperator_return postfixOperator() throws RecognitionException {
        ES3Parser.postfixOperator_return retval = new ES3Parser.postfixOperator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;

        Object op_tree=null;

        try {
            // ES3.g:951:2: (op= INC | op= DEC )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==INC) ) {
                alt18=1;
            }
            else if ( (LA18_0==DEC) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ES3.g:951:4: op= INC
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)match(input,INC,FOLLOW_INC_in_postfixOperator3595); 
                    op_tree = (Object)adaptor.create(op);
                    adaptor.addChild(root_0, op_tree);

                     op.setType(PINC); 

                    }
                    break;
                case 2 :
                    // ES3.g:952:4: op= DEC
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)match(input,DEC,FOLLOW_DEC_in_postfixOperator3604); 
                    op_tree = (Object)adaptor.create(op);
                    adaptor.addChild(root_0, op_tree);

                     op.setType(PDEC); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "postfixOperator"

    public static class unaryExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryExpression"
    // ES3.g:959:1: unaryExpression : ( postfixExpression | unaryOperator unaryExpression );
    public final ES3Parser.unaryExpression_return unaryExpression() throws RecognitionException {
        ES3Parser.unaryExpression_return retval = new ES3Parser.unaryExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ES3Parser.postfixExpression_return postfixExpression63 = null;

        ES3Parser.unaryOperator_return unaryOperator64 = null;

        ES3Parser.unaryExpression_return unaryExpression65 = null;



        try {
            // ES3.g:960:2: ( postfixExpression | unaryOperator unaryExpression )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=NULL && LA19_0<=FALSE)||LA19_0==FUNCTION||LA19_0==NEW||LA19_0==THIS||LA19_0==LBRACE||LA19_0==LPAREN||LA19_0==LBRACK||(LA19_0>=Identifier && LA19_0<=StringLiteral)||LA19_0==RegularExpressionLiteral||(LA19_0>=DecimalLiteral && LA19_0<=HexIntegerLiteral)) ) {
                alt19=1;
            }
            else if ( (LA19_0==DELETE||LA19_0==TYPEOF||LA19_0==VOID||(LA19_0>=ADD && LA19_0<=SUB)||(LA19_0>=INC && LA19_0<=DEC)||(LA19_0>=NOT && LA19_0<=INV)) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ES3.g:960:4: postfixExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_postfixExpression_in_unaryExpression3621);
                    postfixExpression63=postfixExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, postfixExpression63.getTree());

                    }
                    break;
                case 2 :
                    // ES3.g:961:4: unaryOperator unaryExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_unaryOperator_in_unaryExpression3626);
                    unaryOperator64=unaryOperator();

                    state._fsp--;

                    root_0 = (Object)adaptor.becomeRoot(unaryOperator64.getTree(), root_0);
                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression3629);
                    unaryExpression65=unaryExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, unaryExpression65.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryExpression"

    public static class unaryOperator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryOperator"
    // ES3.g:964:1: unaryOperator : ( DELETE | VOID | TYPEOF | INC | DEC | op= ADD | op= SUB | INV | NOT );
    public final ES3Parser.unaryOperator_return unaryOperator() throws RecognitionException {
        ES3Parser.unaryOperator_return retval = new ES3Parser.unaryOperator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token DELETE66=null;
        Token VOID67=null;
        Token TYPEOF68=null;
        Token INC69=null;
        Token DEC70=null;
        Token INV71=null;
        Token NOT72=null;

        Object op_tree=null;
        Object DELETE66_tree=null;
        Object VOID67_tree=null;
        Object TYPEOF68_tree=null;
        Object INC69_tree=null;
        Object DEC70_tree=null;
        Object INV71_tree=null;
        Object NOT72_tree=null;

        try {
            // ES3.g:965:2: ( DELETE | VOID | TYPEOF | INC | DEC | op= ADD | op= SUB | INV | NOT )
            int alt20=9;
            switch ( input.LA(1) ) {
            case DELETE:
                {
                alt20=1;
                }
                break;
            case VOID:
                {
                alt20=2;
                }
                break;
            case TYPEOF:
                {
                alt20=3;
                }
                break;
            case INC:
                {
                alt20=4;
                }
                break;
            case DEC:
                {
                alt20=5;
                }
                break;
            case ADD:
                {
                alt20=6;
                }
                break;
            case SUB:
                {
                alt20=7;
                }
                break;
            case INV:
                {
                alt20=8;
                }
                break;
            case NOT:
                {
                alt20=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ES3.g:965:4: DELETE
                    {
                    root_0 = (Object)adaptor.nil();

                    DELETE66=(Token)match(input,DELETE,FOLLOW_DELETE_in_unaryOperator3641); 
                    DELETE66_tree = (Object)adaptor.create(DELETE66);
                    adaptor.addChild(root_0, DELETE66_tree);


                    }
                    break;
                case 2 :
                    // ES3.g:966:4: VOID
                    {
                    root_0 = (Object)adaptor.nil();

                    VOID67=(Token)match(input,VOID,FOLLOW_VOID_in_unaryOperator3646); 
                    VOID67_tree = (Object)adaptor.create(VOID67);
                    adaptor.addChild(root_0, VOID67_tree);


                    }
                    break;
                case 3 :
                    // ES3.g:967:4: TYPEOF
                    {
                    root_0 = (Object)adaptor.nil();

                    TYPEOF68=(Token)match(input,TYPEOF,FOLLOW_TYPEOF_in_unaryOperator3651); 
                    TYPEOF68_tree = (Object)adaptor.create(TYPEOF68);
                    adaptor.addChild(root_0, TYPEOF68_tree);


                    }
                    break;
                case 4 :
                    // ES3.g:968:4: INC
                    {
                    root_0 = (Object)adaptor.nil();

                    INC69=(Token)match(input,INC,FOLLOW_INC_in_unaryOperator3656); 
                    INC69_tree = (Object)adaptor.create(INC69);
                    adaptor.addChild(root_0, INC69_tree);


                    }
                    break;
                case 5 :
                    // ES3.g:969:4: DEC
                    {
                    root_0 = (Object)adaptor.nil();

                    DEC70=(Token)match(input,DEC,FOLLOW_DEC_in_unaryOperator3661); 
                    DEC70_tree = (Object)adaptor.create(DEC70);
                    adaptor.addChild(root_0, DEC70_tree);


                    }
                    break;
                case 6 :
                    // ES3.g:970:4: op= ADD
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)match(input,ADD,FOLLOW_ADD_in_unaryOperator3668); 
                    op_tree = (Object)adaptor.create(op);
                    adaptor.addChild(root_0, op_tree);

                     op.setType(POS); 

                    }
                    break;
                case 7 :
                    // ES3.g:971:4: op= SUB
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)match(input,SUB,FOLLOW_SUB_in_unaryOperator3677); 
                    op_tree = (Object)adaptor.create(op);
                    adaptor.addChild(root_0, op_tree);

                     op.setType(NEG); 

                    }
                    break;
                case 8 :
                    // ES3.g:972:4: INV
                    {
                    root_0 = (Object)adaptor.nil();

                    INV71=(Token)match(input,INV,FOLLOW_INV_in_unaryOperator3684); 
                    INV71_tree = (Object)adaptor.create(INV71);
                    adaptor.addChild(root_0, INV71_tree);


                    }
                    break;
                case 9 :
                    // ES3.g:973:4: NOT
                    {
                    root_0 = (Object)adaptor.nil();

                    NOT72=(Token)match(input,NOT,FOLLOW_NOT_in_unaryOperator3689); 
                    NOT72_tree = (Object)adaptor.create(NOT72);
                    adaptor.addChild(root_0, NOT72_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryOperator"

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiplicativeExpression"
    // ES3.g:980:1: multiplicativeExpression : unaryExpression ( ( MUL | DIV | MOD ) unaryExpression )* ;
    public final ES3Parser.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        ES3Parser.multiplicativeExpression_return retval = new ES3Parser.multiplicativeExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set74=null;
        ES3Parser.unaryExpression_return unaryExpression73 = null;

        ES3Parser.unaryExpression_return unaryExpression75 = null;


        Object set74_tree=null;

        try {
            // ES3.g:981:2: ( unaryExpression ( ( MUL | DIV | MOD ) unaryExpression )* )
            // ES3.g:981:4: unaryExpression ( ( MUL | DIV | MOD ) unaryExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression3704);
            unaryExpression73=unaryExpression();

            state._fsp--;

            adaptor.addChild(root_0, unaryExpression73.getTree());
            // ES3.g:981:20: ( ( MUL | DIV | MOD ) unaryExpression )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=MUL && LA21_0<=MOD)||LA21_0==DIV) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ES3.g:981:22: ( MUL | DIV | MOD ) unaryExpression
            	    {
            	    set74=(Token)input.LT(1);
            	    set74=(Token)input.LT(1);
            	    if ( (input.LA(1)>=MUL && input.LA(1)<=MOD)||input.LA(1)==DIV ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set74), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression3723);
            	    unaryExpression75=unaryExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, unaryExpression75.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "multiplicativeExpression"

    public static class additiveExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "additiveExpression"
    // ES3.g:988:1: additiveExpression : multiplicativeExpression ( ( ADD | SUB ) multiplicativeExpression )* ;
    public final ES3Parser.additiveExpression_return additiveExpression() throws RecognitionException {
        ES3Parser.additiveExpression_return retval = new ES3Parser.additiveExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set77=null;
        ES3Parser.multiplicativeExpression_return multiplicativeExpression76 = null;

        ES3Parser.multiplicativeExpression_return multiplicativeExpression78 = null;


        Object set77_tree=null;

        try {
            // ES3.g:989:2: ( multiplicativeExpression ( ( ADD | SUB ) multiplicativeExpression )* )
            // ES3.g:989:4: multiplicativeExpression ( ( ADD | SUB ) multiplicativeExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression3741);
            multiplicativeExpression76=multiplicativeExpression();

            state._fsp--;

            adaptor.addChild(root_0, multiplicativeExpression76.getTree());
            // ES3.g:989:29: ( ( ADD | SUB ) multiplicativeExpression )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=ADD && LA22_0<=SUB)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ES3.g:989:31: ( ADD | SUB ) multiplicativeExpression
            	    {
            	    set77=(Token)input.LT(1);
            	    set77=(Token)input.LT(1);
            	    if ( (input.LA(1)>=ADD && input.LA(1)<=SUB) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set77), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression3756);
            	    multiplicativeExpression78=multiplicativeExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multiplicativeExpression78.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "additiveExpression"

    public static class shiftExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shiftExpression"
    // ES3.g:996:1: shiftExpression : additiveExpression ( ( SHL | SHR | SHU ) additiveExpression )* ;
    public final ES3Parser.shiftExpression_return shiftExpression() throws RecognitionException {
        ES3Parser.shiftExpression_return retval = new ES3Parser.shiftExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set80=null;
        ES3Parser.additiveExpression_return additiveExpression79 = null;

        ES3Parser.additiveExpression_return additiveExpression81 = null;


        Object set80_tree=null;

        try {
            // ES3.g:997:2: ( additiveExpression ( ( SHL | SHR | SHU ) additiveExpression )* )
            // ES3.g:997:4: additiveExpression ( ( SHL | SHR | SHU ) additiveExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_shiftExpression3775);
            additiveExpression79=additiveExpression();

            state._fsp--;

            adaptor.addChild(root_0, additiveExpression79.getTree());
            // ES3.g:997:23: ( ( SHL | SHR | SHU ) additiveExpression )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=SHL && LA23_0<=SHU)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ES3.g:997:25: ( SHL | SHR | SHU ) additiveExpression
            	    {
            	    set80=(Token)input.LT(1);
            	    set80=(Token)input.LT(1);
            	    if ( (input.LA(1)>=SHL && input.LA(1)<=SHU) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set80), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_additiveExpression_in_shiftExpression3794);
            	    additiveExpression81=additiveExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, additiveExpression81.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "shiftExpression"

    public static class relationalExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relationalExpression"
    // ES3.g:1004:1: relationalExpression : shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression )* ;
    public final ES3Parser.relationalExpression_return relationalExpression() throws RecognitionException {
        ES3Parser.relationalExpression_return retval = new ES3Parser.relationalExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set83=null;
        ES3Parser.shiftExpression_return shiftExpression82 = null;

        ES3Parser.shiftExpression_return shiftExpression84 = null;


        Object set83_tree=null;

        try {
            // ES3.g:1005:2: ( shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression )* )
            // ES3.g:1005:4: shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_shiftExpression_in_relationalExpression3813);
            shiftExpression82=shiftExpression();

            state._fsp--;

            adaptor.addChild(root_0, shiftExpression82.getTree());
            // ES3.g:1005:20: ( ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=IN && LA24_0<=INSTANCEOF)||(LA24_0>=LT && LA24_0<=GTE)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ES3.g:1005:22: ( LT | GT | LTE | GTE | INSTANCEOF | IN ) shiftExpression
            	    {
            	    set83=(Token)input.LT(1);
            	    set83=(Token)input.LT(1);
            	    if ( (input.LA(1)>=IN && input.LA(1)<=INSTANCEOF)||(input.LA(1)>=LT && input.LA(1)<=GTE) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set83), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpression3844);
            	    shiftExpression84=shiftExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, shiftExpression84.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "relationalExpression"

    public static class relationalExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relationalExpressionNoIn"
    // ES3.g:1008:1: relationalExpressionNoIn : shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression )* ;
    public final ES3Parser.relationalExpressionNoIn_return relationalExpressionNoIn() throws RecognitionException {
        ES3Parser.relationalExpressionNoIn_return retval = new ES3Parser.relationalExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set86=null;
        ES3Parser.shiftExpression_return shiftExpression85 = null;

        ES3Parser.shiftExpression_return shiftExpression87 = null;


        Object set86_tree=null;

        try {
            // ES3.g:1009:2: ( shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression )* )
            // ES3.g:1009:4: shiftExpression ( ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_shiftExpression_in_relationalExpressionNoIn3858);
            shiftExpression85=shiftExpression();

            state._fsp--;

            adaptor.addChild(root_0, shiftExpression85.getTree());
            // ES3.g:1009:20: ( ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==INSTANCEOF||(LA25_0>=LT && LA25_0<=GTE)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ES3.g:1009:22: ( LT | GT | LTE | GTE | INSTANCEOF ) shiftExpression
            	    {
            	    set86=(Token)input.LT(1);
            	    set86=(Token)input.LT(1);
            	    if ( input.LA(1)==INSTANCEOF||(input.LA(1)>=LT && input.LA(1)<=GTE) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set86), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpressionNoIn3885);
            	    shiftExpression87=shiftExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, shiftExpression87.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "relationalExpressionNoIn"

    public static class equalityExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equalityExpression"
    // ES3.g:1016:1: equalityExpression : relationalExpression ( ( EQ | NEQ | SAME | NSAME ) relationalExpression )* ;
    public final ES3Parser.equalityExpression_return equalityExpression() throws RecognitionException {
        ES3Parser.equalityExpression_return retval = new ES3Parser.equalityExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set89=null;
        ES3Parser.relationalExpression_return relationalExpression88 = null;

        ES3Parser.relationalExpression_return relationalExpression90 = null;


        Object set89_tree=null;

        try {
            // ES3.g:1017:2: ( relationalExpression ( ( EQ | NEQ | SAME | NSAME ) relationalExpression )* )
            // ES3.g:1017:4: relationalExpression ( ( EQ | NEQ | SAME | NSAME ) relationalExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_equalityExpression3904);
            relationalExpression88=relationalExpression();

            state._fsp--;

            adaptor.addChild(root_0, relationalExpression88.getTree());
            // ES3.g:1017:25: ( ( EQ | NEQ | SAME | NSAME ) relationalExpression )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=EQ && LA26_0<=NSAME)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ES3.g:1017:27: ( EQ | NEQ | SAME | NSAME ) relationalExpression
            	    {
            	    set89=(Token)input.LT(1);
            	    set89=(Token)input.LT(1);
            	    if ( (input.LA(1)>=EQ && input.LA(1)<=NSAME) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set89), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_equalityExpression3927);
            	    relationalExpression90=relationalExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, relationalExpression90.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "equalityExpression"

    public static class equalityExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equalityExpressionNoIn"
    // ES3.g:1020:1: equalityExpressionNoIn : relationalExpressionNoIn ( ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn )* ;
    public final ES3Parser.equalityExpressionNoIn_return equalityExpressionNoIn() throws RecognitionException {
        ES3Parser.equalityExpressionNoIn_return retval = new ES3Parser.equalityExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set92=null;
        ES3Parser.relationalExpressionNoIn_return relationalExpressionNoIn91 = null;

        ES3Parser.relationalExpressionNoIn_return relationalExpressionNoIn93 = null;


        Object set92_tree=null;

        try {
            // ES3.g:1021:2: ( relationalExpressionNoIn ( ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn )* )
            // ES3.g:1021:4: relationalExpressionNoIn ( ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relationalExpressionNoIn_in_equalityExpressionNoIn3941);
            relationalExpressionNoIn91=relationalExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, relationalExpressionNoIn91.getTree());
            // ES3.g:1021:29: ( ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=EQ && LA27_0<=NSAME)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ES3.g:1021:31: ( EQ | NEQ | SAME | NSAME ) relationalExpressionNoIn
            	    {
            	    set92=(Token)input.LT(1);
            	    set92=(Token)input.LT(1);
            	    if ( (input.LA(1)>=EQ && input.LA(1)<=NSAME) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set92), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_relationalExpressionNoIn_in_equalityExpressionNoIn3964);
            	    relationalExpressionNoIn93=relationalExpressionNoIn();

            	    state._fsp--;

            	    adaptor.addChild(root_0, relationalExpressionNoIn93.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "equalityExpressionNoIn"

    public static class bitwiseANDExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitwiseANDExpression"
    // ES3.g:1028:1: bitwiseANDExpression : equalityExpression ( AND equalityExpression )* ;
    public final ES3Parser.bitwiseANDExpression_return bitwiseANDExpression() throws RecognitionException {
        ES3Parser.bitwiseANDExpression_return retval = new ES3Parser.bitwiseANDExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AND95=null;
        ES3Parser.equalityExpression_return equalityExpression94 = null;

        ES3Parser.equalityExpression_return equalityExpression96 = null;


        Object AND95_tree=null;

        try {
            // ES3.g:1029:2: ( equalityExpression ( AND equalityExpression )* )
            // ES3.g:1029:4: equalityExpression ( AND equalityExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_equalityExpression_in_bitwiseANDExpression3984);
            equalityExpression94=equalityExpression();

            state._fsp--;

            adaptor.addChild(root_0, equalityExpression94.getTree());
            // ES3.g:1029:23: ( AND equalityExpression )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==AND) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ES3.g:1029:25: AND equalityExpression
            	    {
            	    AND95=(Token)match(input,AND,FOLLOW_AND_in_bitwiseANDExpression3988); 
            	    AND95_tree = (Object)adaptor.create(AND95);
            	    root_0 = (Object)adaptor.becomeRoot(AND95_tree, root_0);

            	    pushFollow(FOLLOW_equalityExpression_in_bitwiseANDExpression3991);
            	    equalityExpression96=equalityExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, equalityExpression96.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitwiseANDExpression"

    public static class bitwiseANDExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitwiseANDExpressionNoIn"
    // ES3.g:1032:1: bitwiseANDExpressionNoIn : equalityExpressionNoIn ( AND equalityExpressionNoIn )* ;
    public final ES3Parser.bitwiseANDExpressionNoIn_return bitwiseANDExpressionNoIn() throws RecognitionException {
        ES3Parser.bitwiseANDExpressionNoIn_return retval = new ES3Parser.bitwiseANDExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AND98=null;
        ES3Parser.equalityExpressionNoIn_return equalityExpressionNoIn97 = null;

        ES3Parser.equalityExpressionNoIn_return equalityExpressionNoIn99 = null;


        Object AND98_tree=null;

        try {
            // ES3.g:1033:2: ( equalityExpressionNoIn ( AND equalityExpressionNoIn )* )
            // ES3.g:1033:4: equalityExpressionNoIn ( AND equalityExpressionNoIn )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_equalityExpressionNoIn_in_bitwiseANDExpressionNoIn4005);
            equalityExpressionNoIn97=equalityExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, equalityExpressionNoIn97.getTree());
            // ES3.g:1033:27: ( AND equalityExpressionNoIn )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==AND) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ES3.g:1033:29: AND equalityExpressionNoIn
            	    {
            	    AND98=(Token)match(input,AND,FOLLOW_AND_in_bitwiseANDExpressionNoIn4009); 
            	    AND98_tree = (Object)adaptor.create(AND98);
            	    root_0 = (Object)adaptor.becomeRoot(AND98_tree, root_0);

            	    pushFollow(FOLLOW_equalityExpressionNoIn_in_bitwiseANDExpressionNoIn4012);
            	    equalityExpressionNoIn99=equalityExpressionNoIn();

            	    state._fsp--;

            	    adaptor.addChild(root_0, equalityExpressionNoIn99.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitwiseANDExpressionNoIn"

    public static class bitwiseXORExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitwiseXORExpression"
    // ES3.g:1036:1: bitwiseXORExpression : bitwiseANDExpression ( XOR bitwiseANDExpression )* ;
    public final ES3Parser.bitwiseXORExpression_return bitwiseXORExpression() throws RecognitionException {
        ES3Parser.bitwiseXORExpression_return retval = new ES3Parser.bitwiseXORExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token XOR101=null;
        ES3Parser.bitwiseANDExpression_return bitwiseANDExpression100 = null;

        ES3Parser.bitwiseANDExpression_return bitwiseANDExpression102 = null;


        Object XOR101_tree=null;

        try {
            // ES3.g:1037:2: ( bitwiseANDExpression ( XOR bitwiseANDExpression )* )
            // ES3.g:1037:4: bitwiseANDExpression ( XOR bitwiseANDExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseANDExpression_in_bitwiseXORExpression4028);
            bitwiseANDExpression100=bitwiseANDExpression();

            state._fsp--;

            adaptor.addChild(root_0, bitwiseANDExpression100.getTree());
            // ES3.g:1037:25: ( XOR bitwiseANDExpression )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==XOR) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ES3.g:1037:27: XOR bitwiseANDExpression
            	    {
            	    XOR101=(Token)match(input,XOR,FOLLOW_XOR_in_bitwiseXORExpression4032); 
            	    XOR101_tree = (Object)adaptor.create(XOR101);
            	    root_0 = (Object)adaptor.becomeRoot(XOR101_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseANDExpression_in_bitwiseXORExpression4035);
            	    bitwiseANDExpression102=bitwiseANDExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, bitwiseANDExpression102.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitwiseXORExpression"

    public static class bitwiseXORExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitwiseXORExpressionNoIn"
    // ES3.g:1040:1: bitwiseXORExpressionNoIn : bitwiseANDExpressionNoIn ( XOR bitwiseANDExpressionNoIn )* ;
    public final ES3Parser.bitwiseXORExpressionNoIn_return bitwiseXORExpressionNoIn() throws RecognitionException {
        ES3Parser.bitwiseXORExpressionNoIn_return retval = new ES3Parser.bitwiseXORExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token XOR104=null;
        ES3Parser.bitwiseANDExpressionNoIn_return bitwiseANDExpressionNoIn103 = null;

        ES3Parser.bitwiseANDExpressionNoIn_return bitwiseANDExpressionNoIn105 = null;


        Object XOR104_tree=null;

        try {
            // ES3.g:1041:2: ( bitwiseANDExpressionNoIn ( XOR bitwiseANDExpressionNoIn )* )
            // ES3.g:1041:4: bitwiseANDExpressionNoIn ( XOR bitwiseANDExpressionNoIn )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseANDExpressionNoIn_in_bitwiseXORExpressionNoIn4051);
            bitwiseANDExpressionNoIn103=bitwiseANDExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, bitwiseANDExpressionNoIn103.getTree());
            // ES3.g:1041:29: ( XOR bitwiseANDExpressionNoIn )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==XOR) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ES3.g:1041:31: XOR bitwiseANDExpressionNoIn
            	    {
            	    XOR104=(Token)match(input,XOR,FOLLOW_XOR_in_bitwiseXORExpressionNoIn4055); 
            	    XOR104_tree = (Object)adaptor.create(XOR104);
            	    root_0 = (Object)adaptor.becomeRoot(XOR104_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseANDExpressionNoIn_in_bitwiseXORExpressionNoIn4058);
            	    bitwiseANDExpressionNoIn105=bitwiseANDExpressionNoIn();

            	    state._fsp--;

            	    adaptor.addChild(root_0, bitwiseANDExpressionNoIn105.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitwiseXORExpressionNoIn"

    public static class bitwiseORExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitwiseORExpression"
    // ES3.g:1044:1: bitwiseORExpression : bitwiseXORExpression ( OR bitwiseXORExpression )* ;
    public final ES3Parser.bitwiseORExpression_return bitwiseORExpression() throws RecognitionException {
        ES3Parser.bitwiseORExpression_return retval = new ES3Parser.bitwiseORExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OR107=null;
        ES3Parser.bitwiseXORExpression_return bitwiseXORExpression106 = null;

        ES3Parser.bitwiseXORExpression_return bitwiseXORExpression108 = null;


        Object OR107_tree=null;

        try {
            // ES3.g:1045:2: ( bitwiseXORExpression ( OR bitwiseXORExpression )* )
            // ES3.g:1045:4: bitwiseXORExpression ( OR bitwiseXORExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseXORExpression_in_bitwiseORExpression4073);
            bitwiseXORExpression106=bitwiseXORExpression();

            state._fsp--;

            adaptor.addChild(root_0, bitwiseXORExpression106.getTree());
            // ES3.g:1045:25: ( OR bitwiseXORExpression )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==OR) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ES3.g:1045:27: OR bitwiseXORExpression
            	    {
            	    OR107=(Token)match(input,OR,FOLLOW_OR_in_bitwiseORExpression4077); 
            	    OR107_tree = (Object)adaptor.create(OR107);
            	    root_0 = (Object)adaptor.becomeRoot(OR107_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseXORExpression_in_bitwiseORExpression4080);
            	    bitwiseXORExpression108=bitwiseXORExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, bitwiseXORExpression108.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitwiseORExpression"

    public static class bitwiseORExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitwiseORExpressionNoIn"
    // ES3.g:1048:1: bitwiseORExpressionNoIn : bitwiseXORExpressionNoIn ( OR bitwiseXORExpressionNoIn )* ;
    public final ES3Parser.bitwiseORExpressionNoIn_return bitwiseORExpressionNoIn() throws RecognitionException {
        ES3Parser.bitwiseORExpressionNoIn_return retval = new ES3Parser.bitwiseORExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OR110=null;
        ES3Parser.bitwiseXORExpressionNoIn_return bitwiseXORExpressionNoIn109 = null;

        ES3Parser.bitwiseXORExpressionNoIn_return bitwiseXORExpressionNoIn111 = null;


        Object OR110_tree=null;

        try {
            // ES3.g:1049:2: ( bitwiseXORExpressionNoIn ( OR bitwiseXORExpressionNoIn )* )
            // ES3.g:1049:4: bitwiseXORExpressionNoIn ( OR bitwiseXORExpressionNoIn )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseXORExpressionNoIn_in_bitwiseORExpressionNoIn4095);
            bitwiseXORExpressionNoIn109=bitwiseXORExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, bitwiseXORExpressionNoIn109.getTree());
            // ES3.g:1049:29: ( OR bitwiseXORExpressionNoIn )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==OR) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ES3.g:1049:31: OR bitwiseXORExpressionNoIn
            	    {
            	    OR110=(Token)match(input,OR,FOLLOW_OR_in_bitwiseORExpressionNoIn4099); 
            	    OR110_tree = (Object)adaptor.create(OR110);
            	    root_0 = (Object)adaptor.becomeRoot(OR110_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseXORExpressionNoIn_in_bitwiseORExpressionNoIn4102);
            	    bitwiseXORExpressionNoIn111=bitwiseXORExpressionNoIn();

            	    state._fsp--;

            	    adaptor.addChild(root_0, bitwiseXORExpressionNoIn111.getTree());

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bitwiseORExpressionNoIn"

    public static class logicalANDExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalANDExpression"
    // ES3.g:1056:1: logicalANDExpression : bitwiseORExpression ( LAND bitwiseORExpression )* ;
    public final ES3Parser.logicalANDExpression_return logicalANDExpression() throws RecognitionException {
        ES3Parser.logicalANDExpression_return retval = new ES3Parser.logicalANDExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LAND113=null;
        ES3Parser.bitwiseORExpression_return bitwiseORExpression112 = null;

        ES3Parser.bitwiseORExpression_return bitwiseORExpression114 = null;


        Object LAND113_tree=null;

        try {
            // ES3.g:1057:2: ( bitwiseORExpression ( LAND bitwiseORExpression )* )
            // ES3.g:1057:4: bitwiseORExpression ( LAND bitwiseORExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseORExpression_in_logicalANDExpression4121);
            bitwiseORExpression112=bitwiseORExpression();

            state._fsp--;

            adaptor.addChild(root_0, bitwiseORExpression112.getTree());
            // ES3.g:1057:24: ( LAND bitwiseORExpression )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==LAND) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ES3.g:1057:26: LAND bitwiseORExpression
            	    {
            	    LAND113=(Token)match(input,LAND,FOLLOW_LAND_in_logicalANDExpression4125); 
            	    LAND113_tree = (Object)adaptor.create(LAND113);
            	    root_0 = (Object)adaptor.becomeRoot(LAND113_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseORExpression_in_logicalANDExpression4128);
            	    bitwiseORExpression114=bitwiseORExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, bitwiseORExpression114.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "logicalANDExpression"

    public static class logicalANDExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalANDExpressionNoIn"
    // ES3.g:1060:1: logicalANDExpressionNoIn : bitwiseORExpressionNoIn ( LAND bitwiseORExpressionNoIn )* ;
    public final ES3Parser.logicalANDExpressionNoIn_return logicalANDExpressionNoIn() throws RecognitionException {
        ES3Parser.logicalANDExpressionNoIn_return retval = new ES3Parser.logicalANDExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LAND116=null;
        ES3Parser.bitwiseORExpressionNoIn_return bitwiseORExpressionNoIn115 = null;

        ES3Parser.bitwiseORExpressionNoIn_return bitwiseORExpressionNoIn117 = null;


        Object LAND116_tree=null;

        try {
            // ES3.g:1061:2: ( bitwiseORExpressionNoIn ( LAND bitwiseORExpressionNoIn )* )
            // ES3.g:1061:4: bitwiseORExpressionNoIn ( LAND bitwiseORExpressionNoIn )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_bitwiseORExpressionNoIn_in_logicalANDExpressionNoIn4142);
            bitwiseORExpressionNoIn115=bitwiseORExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, bitwiseORExpressionNoIn115.getTree());
            // ES3.g:1061:28: ( LAND bitwiseORExpressionNoIn )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==LAND) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ES3.g:1061:30: LAND bitwiseORExpressionNoIn
            	    {
            	    LAND116=(Token)match(input,LAND,FOLLOW_LAND_in_logicalANDExpressionNoIn4146); 
            	    LAND116_tree = (Object)adaptor.create(LAND116);
            	    root_0 = (Object)adaptor.becomeRoot(LAND116_tree, root_0);

            	    pushFollow(FOLLOW_bitwiseORExpressionNoIn_in_logicalANDExpressionNoIn4149);
            	    bitwiseORExpressionNoIn117=bitwiseORExpressionNoIn();

            	    state._fsp--;

            	    adaptor.addChild(root_0, bitwiseORExpressionNoIn117.getTree());

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "logicalANDExpressionNoIn"

    public static class logicalORExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalORExpression"
    // ES3.g:1064:1: logicalORExpression : logicalANDExpression ( LOR logicalANDExpression )* ;
    public final ES3Parser.logicalORExpression_return logicalORExpression() throws RecognitionException {
        ES3Parser.logicalORExpression_return retval = new ES3Parser.logicalORExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LOR119=null;
        ES3Parser.logicalANDExpression_return logicalANDExpression118 = null;

        ES3Parser.logicalANDExpression_return logicalANDExpression120 = null;


        Object LOR119_tree=null;

        try {
            // ES3.g:1065:2: ( logicalANDExpression ( LOR logicalANDExpression )* )
            // ES3.g:1065:4: logicalANDExpression ( LOR logicalANDExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logicalANDExpression_in_logicalORExpression4164);
            logicalANDExpression118=logicalANDExpression();

            state._fsp--;

            adaptor.addChild(root_0, logicalANDExpression118.getTree());
            // ES3.g:1065:25: ( LOR logicalANDExpression )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==LOR) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ES3.g:1065:27: LOR logicalANDExpression
            	    {
            	    LOR119=(Token)match(input,LOR,FOLLOW_LOR_in_logicalORExpression4168); 
            	    LOR119_tree = (Object)adaptor.create(LOR119);
            	    root_0 = (Object)adaptor.becomeRoot(LOR119_tree, root_0);

            	    pushFollow(FOLLOW_logicalANDExpression_in_logicalORExpression4171);
            	    logicalANDExpression120=logicalANDExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, logicalANDExpression120.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "logicalORExpression"

    public static class logicalORExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalORExpressionNoIn"
    // ES3.g:1068:1: logicalORExpressionNoIn : logicalANDExpressionNoIn ( LOR logicalANDExpressionNoIn )* ;
    public final ES3Parser.logicalORExpressionNoIn_return logicalORExpressionNoIn() throws RecognitionException {
        ES3Parser.logicalORExpressionNoIn_return retval = new ES3Parser.logicalORExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LOR122=null;
        ES3Parser.logicalANDExpressionNoIn_return logicalANDExpressionNoIn121 = null;

        ES3Parser.logicalANDExpressionNoIn_return logicalANDExpressionNoIn123 = null;


        Object LOR122_tree=null;

        try {
            // ES3.g:1069:2: ( logicalANDExpressionNoIn ( LOR logicalANDExpressionNoIn )* )
            // ES3.g:1069:4: logicalANDExpressionNoIn ( LOR logicalANDExpressionNoIn )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logicalANDExpressionNoIn_in_logicalORExpressionNoIn4186);
            logicalANDExpressionNoIn121=logicalANDExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, logicalANDExpressionNoIn121.getTree());
            // ES3.g:1069:29: ( LOR logicalANDExpressionNoIn )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==LOR) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ES3.g:1069:31: LOR logicalANDExpressionNoIn
            	    {
            	    LOR122=(Token)match(input,LOR,FOLLOW_LOR_in_logicalORExpressionNoIn4190); 
            	    LOR122_tree = (Object)adaptor.create(LOR122);
            	    root_0 = (Object)adaptor.becomeRoot(LOR122_tree, root_0);

            	    pushFollow(FOLLOW_logicalANDExpressionNoIn_in_logicalORExpressionNoIn4193);
            	    logicalANDExpressionNoIn123=logicalANDExpressionNoIn();

            	    state._fsp--;

            	    adaptor.addChild(root_0, logicalANDExpressionNoIn123.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "logicalORExpressionNoIn"

    public static class conditionalExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conditionalExpression"
    // ES3.g:1076:1: conditionalExpression : logicalORExpression ( QUE assignmentExpression COLON assignmentExpression )? ;
    public final ES3Parser.conditionalExpression_return conditionalExpression() throws RecognitionException {
        ES3Parser.conditionalExpression_return retval = new ES3Parser.conditionalExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QUE125=null;
        Token COLON127=null;
        ES3Parser.logicalORExpression_return logicalORExpression124 = null;

        ES3Parser.assignmentExpression_return assignmentExpression126 = null;

        ES3Parser.assignmentExpression_return assignmentExpression128 = null;


        Object QUE125_tree=null;
        Object COLON127_tree=null;

        try {
            // ES3.g:1077:2: ( logicalORExpression ( QUE assignmentExpression COLON assignmentExpression )? )
            // ES3.g:1077:4: logicalORExpression ( QUE assignmentExpression COLON assignmentExpression )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logicalORExpression_in_conditionalExpression4212);
            logicalORExpression124=logicalORExpression();

            state._fsp--;

            adaptor.addChild(root_0, logicalORExpression124.getTree());
            // ES3.g:1077:24: ( QUE assignmentExpression COLON assignmentExpression )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==QUE) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ES3.g:1077:26: QUE assignmentExpression COLON assignmentExpression
                    {
                    QUE125=(Token)match(input,QUE,FOLLOW_QUE_in_conditionalExpression4216); 
                    QUE125_tree = (Object)adaptor.create(QUE125);
                    root_0 = (Object)adaptor.becomeRoot(QUE125_tree, root_0);

                    pushFollow(FOLLOW_assignmentExpression_in_conditionalExpression4219);
                    assignmentExpression126=assignmentExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpression126.getTree());
                    COLON127=(Token)match(input,COLON,FOLLOW_COLON_in_conditionalExpression4221); 
                    pushFollow(FOLLOW_assignmentExpression_in_conditionalExpression4224);
                    assignmentExpression128=assignmentExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpression128.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "conditionalExpression"

    public static class conditionalExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conditionalExpressionNoIn"
    // ES3.g:1080:1: conditionalExpressionNoIn : logicalORExpressionNoIn ( QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn )? ;
    public final ES3Parser.conditionalExpressionNoIn_return conditionalExpressionNoIn() throws RecognitionException {
        ES3Parser.conditionalExpressionNoIn_return retval = new ES3Parser.conditionalExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QUE130=null;
        Token COLON132=null;
        ES3Parser.logicalORExpressionNoIn_return logicalORExpressionNoIn129 = null;

        ES3Parser.assignmentExpressionNoIn_return assignmentExpressionNoIn131 = null;

        ES3Parser.assignmentExpressionNoIn_return assignmentExpressionNoIn133 = null;


        Object QUE130_tree=null;
        Object COLON132_tree=null;

        try {
            // ES3.g:1081:2: ( logicalORExpressionNoIn ( QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn )? )
            // ES3.g:1081:4: logicalORExpressionNoIn ( QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logicalORExpressionNoIn_in_conditionalExpressionNoIn4238);
            logicalORExpressionNoIn129=logicalORExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, logicalORExpressionNoIn129.getTree());
            // ES3.g:1081:28: ( QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==QUE) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ES3.g:1081:30: QUE assignmentExpressionNoIn COLON assignmentExpressionNoIn
                    {
                    QUE130=(Token)match(input,QUE,FOLLOW_QUE_in_conditionalExpressionNoIn4242); 
                    QUE130_tree = (Object)adaptor.create(QUE130);
                    root_0 = (Object)adaptor.becomeRoot(QUE130_tree, root_0);

                    pushFollow(FOLLOW_assignmentExpressionNoIn_in_conditionalExpressionNoIn4245);
                    assignmentExpressionNoIn131=assignmentExpressionNoIn();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpressionNoIn131.getTree());
                    COLON132=(Token)match(input,COLON,FOLLOW_COLON_in_conditionalExpressionNoIn4247); 
                    pushFollow(FOLLOW_assignmentExpressionNoIn_in_conditionalExpressionNoIn4250);
                    assignmentExpressionNoIn133=assignmentExpressionNoIn();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpressionNoIn133.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "conditionalExpressionNoIn"

    public static class assignmentExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignmentExpression"
    // ES3.g:1110:1: assignmentExpression : lhs= conditionalExpression ({...}? assignmentOperator assignmentExpression )? ;
    public final ES3Parser.assignmentExpression_return assignmentExpression() throws RecognitionException {
        ES3Parser.assignmentExpression_return retval = new ES3Parser.assignmentExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ES3Parser.conditionalExpression_return lhs = null;

        ES3Parser.assignmentOperator_return assignmentOperator134 = null;

        ES3Parser.assignmentExpression_return assignmentExpression135 = null;




        	Object[] isLhs = new Object[1];

        try {
            // ES3.g:1115:2: (lhs= conditionalExpression ({...}? assignmentOperator assignmentExpression )? )
            // ES3.g:1115:4: lhs= conditionalExpression ({...}? assignmentOperator assignmentExpression )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_conditionalExpression_in_assignmentExpression4278);
            lhs=conditionalExpression();

            state._fsp--;

            adaptor.addChild(root_0, lhs.getTree());
            // ES3.g:1116:2: ({...}? assignmentOperator assignmentExpression )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=ASSIGN && LA40_0<=XORASS)||LA40_0==DIVASS) ) {
                int LA40_1 = input.LA(2);

                if ( (( isLeftHandSideAssign(lhs, isLhs) )) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // ES3.g:1116:4: {...}? assignmentOperator assignmentExpression
                    {
                    if ( !(( isLeftHandSideAssign(lhs, isLhs) )) ) {
                        throw new FailedPredicateException(input, "assignmentExpression", " isLeftHandSideAssign(lhs, isLhs) ");
                    }
                    pushFollow(FOLLOW_assignmentOperator_in_assignmentExpression4285);
                    assignmentOperator134=assignmentOperator();

                    state._fsp--;

                    root_0 = (Object)adaptor.becomeRoot(assignmentOperator134.getTree(), root_0);
                    pushFollow(FOLLOW_assignmentExpression_in_assignmentExpression4288);
                    assignmentExpression135=assignmentExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpression135.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignmentExpression"

    public static class assignmentOperator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignmentOperator"
    // ES3.g:1119:1: assignmentOperator : ( ASSIGN | MULASS | DIVASS | MODASS | ADDASS | SUBASS | SHLASS | SHRASS | SHUASS | ANDASS | XORASS | ORASS );
    public final ES3Parser.assignmentOperator_return assignmentOperator() throws RecognitionException {
        ES3Parser.assignmentOperator_return retval = new ES3Parser.assignmentOperator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set136=null;

        Object set136_tree=null;

        try {
            // ES3.g:1120:2: ( ASSIGN | MULASS | DIVASS | MODASS | ADDASS | SUBASS | SHLASS | SHRASS | SHUASS | ANDASS | XORASS | ORASS )
            // ES3.g:
            {
            root_0 = (Object)adaptor.nil();

            set136=(Token)input.LT(1);
            if ( (input.LA(1)>=ASSIGN && input.LA(1)<=XORASS)||input.LA(1)==DIVASS ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set136));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignmentOperator"

    public static class assignmentExpressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignmentExpressionNoIn"
    // ES3.g:1123:1: assignmentExpressionNoIn : lhs= conditionalExpressionNoIn ({...}? assignmentOperator assignmentExpressionNoIn )? ;
    public final ES3Parser.assignmentExpressionNoIn_return assignmentExpressionNoIn() throws RecognitionException {
        ES3Parser.assignmentExpressionNoIn_return retval = new ES3Parser.assignmentExpressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ES3Parser.conditionalExpressionNoIn_return lhs = null;

        ES3Parser.assignmentOperator_return assignmentOperator137 = null;

        ES3Parser.assignmentExpressionNoIn_return assignmentExpressionNoIn138 = null;




        	Object[] isLhs = new Object[1];

        try {
            // ES3.g:1128:2: (lhs= conditionalExpressionNoIn ({...}? assignmentOperator assignmentExpressionNoIn )? )
            // ES3.g:1128:4: lhs= conditionalExpressionNoIn ({...}? assignmentOperator assignmentExpressionNoIn )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_conditionalExpressionNoIn_in_assignmentExpressionNoIn4365);
            lhs=conditionalExpressionNoIn();

            state._fsp--;

            adaptor.addChild(root_0, lhs.getTree());
            // ES3.g:1129:2: ({...}? assignmentOperator assignmentExpressionNoIn )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=ASSIGN && LA41_0<=XORASS)||LA41_0==DIVASS) ) {
                int LA41_1 = input.LA(2);

                if ( (( isLeftHandSideAssign(lhs, isLhs) )) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // ES3.g:1129:4: {...}? assignmentOperator assignmentExpressionNoIn
                    {
                    if ( !(( isLeftHandSideAssign(lhs, isLhs) )) ) {
                        throw new FailedPredicateException(input, "assignmentExpressionNoIn", " isLeftHandSideAssign(lhs, isLhs) ");
                    }
                    pushFollow(FOLLOW_assignmentOperator_in_assignmentExpressionNoIn4372);
                    assignmentOperator137=assignmentOperator();

                    state._fsp--;

                    root_0 = (Object)adaptor.becomeRoot(assignmentOperator137.getTree(), root_0);
                    pushFollow(FOLLOW_assignmentExpressionNoIn_in_assignmentExpressionNoIn4375);
                    assignmentExpressionNoIn138=assignmentExpressionNoIn();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpressionNoIn138.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignmentExpressionNoIn"

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // ES3.g:1136:1: expression : exprs+= assignmentExpression ( COMMA exprs+= assignmentExpression )* -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ ) -> $exprs;
    public final ES3Parser.expression_return expression() throws RecognitionException {
        ES3Parser.expression_return retval = new ES3Parser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA139=null;
        List list_exprs=null;
        RuleReturnScope exprs = null;
        Object COMMA139_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            // ES3.g:1137:2: (exprs+= assignmentExpression ( COMMA exprs+= assignmentExpression )* -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ ) -> $exprs)
            // ES3.g:1137:4: exprs+= assignmentExpression ( COMMA exprs+= assignmentExpression )*
            {
            pushFollow(FOLLOW_assignmentExpression_in_expression4397);
            exprs=assignmentExpression();

            state._fsp--;

            stream_assignmentExpression.add(exprs.getTree());
            if (list_exprs==null) list_exprs=new ArrayList();
            list_exprs.add(exprs.getTree());

            // ES3.g:1137:32: ( COMMA exprs+= assignmentExpression )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==COMMA) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ES3.g:1137:34: COMMA exprs+= assignmentExpression
            	    {
            	    COMMA139=(Token)match(input,COMMA,FOLLOW_COMMA_in_expression4401);  
            	    stream_COMMA.add(COMMA139);

            	    pushFollow(FOLLOW_assignmentExpression_in_expression4405);
            	    exprs=assignmentExpression();

            	    state._fsp--;

            	    stream_assignmentExpression.add(exprs.getTree());
            	    if (list_exprs==null) list_exprs=new ArrayList();
            	    list_exprs.add(exprs.getTree());


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);



            // AST REWRITE
            // elements: exprs, exprs
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: exprs
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"token exprs",list_exprs);
            root_0 = (Object)adaptor.nil();
            // 1138:2: -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ )
            if ( list_exprs.size() > 1 ) {
                // ES3.g:1138:28: ^( CEXPR ( $exprs)+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CEXPR, "CEXPR"), root_1);

                if ( !(stream_exprs.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_exprs.hasNext() ) {
                    adaptor.addChild(root_1, stream_exprs.nextTree());

                }
                stream_exprs.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 1139:2: -> $exprs
            {
                adaptor.addChild(root_0, stream_exprs.nextTree());

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class expressionNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expressionNoIn"
    // ES3.g:1142:1: expressionNoIn : exprs+= assignmentExpressionNoIn ( COMMA exprs+= assignmentExpressionNoIn )* -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ ) -> $exprs;
    public final ES3Parser.expressionNoIn_return expressionNoIn() throws RecognitionException {
        ES3Parser.expressionNoIn_return retval = new ES3Parser.expressionNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA140=null;
        List list_exprs=null;
        RuleReturnScope exprs = null;
        Object COMMA140_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_assignmentExpressionNoIn=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpressionNoIn");
        try {
            // ES3.g:1143:2: (exprs+= assignmentExpressionNoIn ( COMMA exprs+= assignmentExpressionNoIn )* -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ ) -> $exprs)
            // ES3.g:1143:4: exprs+= assignmentExpressionNoIn ( COMMA exprs+= assignmentExpressionNoIn )*
            {
            pushFollow(FOLLOW_assignmentExpressionNoIn_in_expressionNoIn4442);
            exprs=assignmentExpressionNoIn();

            state._fsp--;

            stream_assignmentExpressionNoIn.add(exprs.getTree());
            if (list_exprs==null) list_exprs=new ArrayList();
            list_exprs.add(exprs.getTree());

            // ES3.g:1143:36: ( COMMA exprs+= assignmentExpressionNoIn )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==COMMA) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ES3.g:1143:38: COMMA exprs+= assignmentExpressionNoIn
            	    {
            	    COMMA140=(Token)match(input,COMMA,FOLLOW_COMMA_in_expressionNoIn4446);  
            	    stream_COMMA.add(COMMA140);

            	    pushFollow(FOLLOW_assignmentExpressionNoIn_in_expressionNoIn4450);
            	    exprs=assignmentExpressionNoIn();

            	    state._fsp--;

            	    stream_assignmentExpressionNoIn.add(exprs.getTree());
            	    if (list_exprs==null) list_exprs=new ArrayList();
            	    list_exprs.add(exprs.getTree());


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);



            // AST REWRITE
            // elements: exprs, exprs
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: exprs
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"token exprs",list_exprs);
            root_0 = (Object)adaptor.nil();
            // 1144:2: -> { $exprs.size() > 1 }? ^( CEXPR ( $exprs)+ )
            if ( list_exprs.size() > 1 ) {
                // ES3.g:1144:28: ^( CEXPR ( $exprs)+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CEXPR, "CEXPR"), root_1);

                if ( !(stream_exprs.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_exprs.hasNext() ) {
                    adaptor.addChild(root_1, stream_exprs.nextTree());

                }
                stream_exprs.reset();

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 1145:2: -> $exprs
            {
                adaptor.addChild(root_0, stream_exprs.nextTree());

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expressionNoIn"

    public static class semic_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "semic"
    // ES3.g:1170:1: semic : ( SEMIC | EOF | RBRACE | EOL | MultiLineComment );
    public final ES3Parser.semic_return semic() throws RecognitionException {
        ES3Parser.semic_return retval = new ES3Parser.semic_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SEMIC141=null;
        Token EOF142=null;
        Token RBRACE143=null;
        Token EOL144=null;
        Token MultiLineComment145=null;

        Object SEMIC141_tree=null;
        Object EOF142_tree=null;
        Object RBRACE143_tree=null;
        Object EOL144_tree=null;
        Object MultiLineComment145_tree=null;


        	// Mark current position so we can unconsume a RBRACE.
        	int marker = input.mark();
        	// Promote EOL if appropriate	
        	promoteEOL(retval);

        try {
            // ES3.g:1178:2: ( SEMIC | EOF | RBRACE | EOL | MultiLineComment )
            int alt44=5;
            switch ( input.LA(1) ) {
            case SEMIC:
                {
                alt44=1;
                }
                break;
            case EOF:
                {
                alt44=2;
                }
                break;
            case RBRACE:
                {
                alt44=3;
                }
                break;
            case EOL:
                {
                alt44=4;
                }
                break;
            case MultiLineComment:
                {
                alt44=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ES3.g:1178:4: SEMIC
                    {
                    root_0 = (Object)adaptor.nil();

                    SEMIC141=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_semic4501); 
                    SEMIC141_tree = (Object)adaptor.create(SEMIC141);
                    adaptor.addChild(root_0, SEMIC141_tree);


                    }
                    break;
                case 2 :
                    // ES3.g:1179:4: EOF
                    {
                    root_0 = (Object)adaptor.nil();

                    EOF142=(Token)match(input,EOF,FOLLOW_EOF_in_semic4506); 
                    EOF142_tree = (Object)adaptor.create(EOF142);
                    adaptor.addChild(root_0, EOF142_tree);


                    }
                    break;
                case 3 :
                    // ES3.g:1180:4: RBRACE
                    {
                    root_0 = (Object)adaptor.nil();

                    RBRACE143=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_semic4511); 
                    RBRACE143_tree = (Object)adaptor.create(RBRACE143);
                    adaptor.addChild(root_0, RBRACE143_tree);

                     input.rewind(marker); 

                    }
                    break;
                case 4 :
                    // ES3.g:1181:4: EOL
                    {
                    root_0 = (Object)adaptor.nil();

                    EOL144=(Token)match(input,EOL,FOLLOW_EOL_in_semic4518); 
                    EOL144_tree = (Object)adaptor.create(EOL144);
                    adaptor.addChild(root_0, EOL144_tree);


                    }
                    break;
                case 5 :
                    // ES3.g:1181:10: MultiLineComment
                    {
                    root_0 = (Object)adaptor.nil();

                    MultiLineComment145=(Token)match(input,MultiLineComment,FOLLOW_MultiLineComment_in_semic4522); 
                    MultiLineComment145_tree = (Object)adaptor.create(MultiLineComment145);
                    adaptor.addChild(root_0, MultiLineComment145_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "semic"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // ES3.g:1189:1: statement options {k=1; } : ({...}? block | statementTail );
    public final ES3Parser.statement_return statement() throws RecognitionException {
        ES3Parser.statement_return retval = new ES3Parser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ES3Parser.block_return block146 = null;

        ES3Parser.statementTail_return statementTail147 = null;



        try {
            // ES3.g:1194:2: ({...}? block | statementTail )
            int alt45=2;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // ES3.g:1194:4: {...}? block
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( input.LA(1) == LBRACE )) ) {
                        throw new FailedPredicateException(input, "statement", " input.LA(1) == LBRACE ");
                    }
                    pushFollow(FOLLOW_block_in_statement4551);
                    block146=block();

                    state._fsp--;

                    adaptor.addChild(root_0, block146.getTree());

                    }
                    break;
                case 2 :
                    // ES3.g:1195:4: statementTail
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statementTail_in_statement4556);
                    statementTail147=statementTail();

                    state._fsp--;

                    adaptor.addChild(root_0, statementTail147.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class statementTail_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statementTail"
    // ES3.g:1198:1: statementTail : ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement );
    public final ES3Parser.statementTail_return statementTail() throws RecognitionException {
        ES3Parser.statementTail_return retval = new ES3Parser.statementTail_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ES3Parser.variableStatement_return variableStatement148 = null;

        ES3Parser.emptyStatement_return emptyStatement149 = null;

        ES3Parser.expressionStatement_return expressionStatement150 = null;

        ES3Parser.ifStatement_return ifStatement151 = null;

        ES3Parser.iterationStatement_return iterationStatement152 = null;

        ES3Parser.continueStatement_return continueStatement153 = null;

        ES3Parser.breakStatement_return breakStatement154 = null;

        ES3Parser.returnStatement_return returnStatement155 = null;

        ES3Parser.withStatement_return withStatement156 = null;

        ES3Parser.labelledStatement_return labelledStatement157 = null;

        ES3Parser.switchStatement_return switchStatement158 = null;

        ES3Parser.throwStatement_return throwStatement159 = null;

        ES3Parser.tryStatement_return tryStatement160 = null;



        try {
            // ES3.g:1199:2: ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement )
            int alt46=13;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // ES3.g:1199:4: variableStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_variableStatement_in_statementTail4568);
                    variableStatement148=variableStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, variableStatement148.getTree());

                    }
                    break;
                case 2 :
                    // ES3.g:1200:4: emptyStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_emptyStatement_in_statementTail4574);
                    emptyStatement149=emptyStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, emptyStatement149.getTree());

                    }
                    break;
                case 3 :
                    // ES3.g:1201:4: expressionStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_expressionStatement_in_statementTail4580);
                    expressionStatement150=expressionStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, expressionStatement150.getTree());

                    }
                    break;
                case 4 :
                    // ES3.g:1202:4: ifStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ifStatement_in_statementTail4586);
                    ifStatement151=ifStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement151.getTree());

                    }
                    break;
                case 5 :
                    // ES3.g:1203:4: iterationStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_iterationStatement_in_statementTail4592);
                    iterationStatement152=iterationStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, iterationStatement152.getTree());

                    }
                    break;
                case 6 :
                    // ES3.g:1204:4: continueStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_continueStatement_in_statementTail4598);
                    continueStatement153=continueStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, continueStatement153.getTree());

                    }
                    break;
                case 7 :
                    // ES3.g:1205:4: breakStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_breakStatement_in_statementTail4604);
                    breakStatement154=breakStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, breakStatement154.getTree());

                    }
                    break;
                case 8 :
                    // ES3.g:1206:4: returnStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_returnStatement_in_statementTail4610);
                    returnStatement155=returnStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, returnStatement155.getTree());

                    }
                    break;
                case 9 :
                    // ES3.g:1207:4: withStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_withStatement_in_statementTail4616);
                    withStatement156=withStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, withStatement156.getTree());

                    }
                    break;
                case 10 :
                    // ES3.g:1208:4: labelledStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_labelledStatement_in_statementTail4622);
                    labelledStatement157=labelledStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, labelledStatement157.getTree());

                    }
                    break;
                case 11 :
                    // ES3.g:1209:4: switchStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_switchStatement_in_statementTail4628);
                    switchStatement158=switchStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, switchStatement158.getTree());

                    }
                    break;
                case 12 :
                    // ES3.g:1210:4: throwStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_throwStatement_in_statementTail4634);
                    throwStatement159=throwStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, throwStatement159.getTree());

                    }
                    break;
                case 13 :
                    // ES3.g:1211:4: tryStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_tryStatement_in_statementTail4640);
                    tryStatement160=tryStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, tryStatement160.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statementTail"

    public static class block_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block"
    // ES3.g:1216:1: block : lb= LBRACE ( statement )* RBRACE -> ^( BLOCK[$lb, \"BLOCK\"] ( statement )* ) ;
    public final ES3Parser.block_return block() throws RecognitionException {
        ES3Parser.block_return retval = new ES3Parser.block_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token lb=null;
        Token RBRACE162=null;
        ES3Parser.statement_return statement161 = null;


        Object lb_tree=null;
        Object RBRACE162_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // ES3.g:1217:2: (lb= LBRACE ( statement )* RBRACE -> ^( BLOCK[$lb, \"BLOCK\"] ( statement )* ) )
            // ES3.g:1217:4: lb= LBRACE ( statement )* RBRACE
            {
            lb=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_block4656);  
            stream_LBRACE.add(lb);

            // ES3.g:1217:14: ( statement )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=NULL && LA47_0<=BREAK)||LA47_0==CONTINUE||(LA47_0>=DELETE && LA47_0<=DO)||(LA47_0>=FOR && LA47_0<=IF)||(LA47_0>=NEW && LA47_0<=WITH)||LA47_0==CONST||LA47_0==LBRACE||LA47_0==LPAREN||LA47_0==LBRACK||LA47_0==SEMIC||(LA47_0>=ADD && LA47_0<=SUB)||(LA47_0>=INC && LA47_0<=DEC)||(LA47_0>=NOT && LA47_0<=INV)||(LA47_0>=Identifier && LA47_0<=StringLiteral)||LA47_0==RegularExpressionLiteral||(LA47_0>=DecimalLiteral && LA47_0<=HexIntegerLiteral)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ES3.g:1217:14: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block4658);
            	    statement161=statement();

            	    state._fsp--;

            	    stream_statement.add(statement161.getTree());

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            RBRACE162=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_block4661);  
            stream_RBRACE.add(RBRACE162);



            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1218:2: -> ^( BLOCK[$lb, \"BLOCK\"] ( statement )* )
            {
                // ES3.g:1218:5: ^( BLOCK[$lb, \"BLOCK\"] ( statement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, lb, "BLOCK"), root_1);

                // ES3.g:1218:28: ( statement )*
                while ( stream_statement.hasNext() ) {
                    adaptor.addChild(root_1, stream_statement.nextTree());

                }
                stream_statement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class variableStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableStatement"
    // ES3.g:1225:1: variableStatement : ( VAR variableDeclaration ( COMMA variableDeclaration )* semic -> ^( VAR ( variableDeclaration )+ ) | CONST variableDeclaration ( COMMA variableDeclaration )* semic -> ^( VAR ( variableDeclaration )+ ) );
    public final ES3Parser.variableStatement_return variableStatement() throws RecognitionException {
        ES3Parser.variableStatement_return retval = new ES3Parser.variableStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VAR163=null;
        Token COMMA165=null;
        Token CONST168=null;
        Token COMMA170=null;
        ES3Parser.variableDeclaration_return variableDeclaration164 = null;

        ES3Parser.variableDeclaration_return variableDeclaration166 = null;

        ES3Parser.semic_return semic167 = null;

        ES3Parser.variableDeclaration_return variableDeclaration169 = null;

        ES3Parser.variableDeclaration_return variableDeclaration171 = null;

        ES3Parser.semic_return semic172 = null;


        Object VAR163_tree=null;
        Object COMMA165_tree=null;
        Object CONST168_tree=null;
        Object COMMA170_tree=null;
        RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_CONST=new RewriteRuleTokenStream(adaptor,"token CONST");
        RewriteRuleSubtreeStream stream_variableDeclaration=new RewriteRuleSubtreeStream(adaptor,"rule variableDeclaration");
        RewriteRuleSubtreeStream stream_semic=new RewriteRuleSubtreeStream(adaptor,"rule semic");
        try {
            // ES3.g:1226:2: ( VAR variableDeclaration ( COMMA variableDeclaration )* semic -> ^( VAR ( variableDeclaration )+ ) | CONST variableDeclaration ( COMMA variableDeclaration )* semic -> ^( VAR ( variableDeclaration )+ ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==VAR) ) {
                alt50=1;
            }
            else if ( (LA50_0==CONST) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ES3.g:1226:4: VAR variableDeclaration ( COMMA variableDeclaration )* semic
                    {
                    VAR163=(Token)match(input,VAR,FOLLOW_VAR_in_variableStatement4690);  
                    stream_VAR.add(VAR163);

                    pushFollow(FOLLOW_variableDeclaration_in_variableStatement4692);
                    variableDeclaration164=variableDeclaration();

                    state._fsp--;

                    stream_variableDeclaration.add(variableDeclaration164.getTree());
                    // ES3.g:1226:28: ( COMMA variableDeclaration )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==COMMA) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ES3.g:1226:30: COMMA variableDeclaration
                    	    {
                    	    COMMA165=(Token)match(input,COMMA,FOLLOW_COMMA_in_variableStatement4696);  
                    	    stream_COMMA.add(COMMA165);

                    	    pushFollow(FOLLOW_variableDeclaration_in_variableStatement4698);
                    	    variableDeclaration166=variableDeclaration();

                    	    state._fsp--;

                    	    stream_variableDeclaration.add(variableDeclaration166.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    pushFollow(FOLLOW_semic_in_variableStatement4703);
                    semic167=semic();

                    state._fsp--;

                    stream_semic.add(semic167.getTree());


                    // AST REWRITE
                    // elements: VAR, variableDeclaration
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1226:65: -> ^( VAR ( variableDeclaration )+ )
                    {
                        // ES3.g:1226:68: ^( VAR ( variableDeclaration )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_VAR.nextNode(), root_1);

                        if ( !(stream_variableDeclaration.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_variableDeclaration.hasNext() ) {
                            adaptor.addChild(root_1, stream_variableDeclaration.nextTree());

                        }
                        stream_variableDeclaration.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // ES3.g:1227:4: CONST variableDeclaration ( COMMA variableDeclaration )* semic
                    {
                    CONST168=(Token)match(input,CONST,FOLLOW_CONST_in_variableStatement4719);  
                    stream_CONST.add(CONST168);

                    pushFollow(FOLLOW_variableDeclaration_in_variableStatement4721);
                    variableDeclaration169=variableDeclaration();

                    state._fsp--;

                    stream_variableDeclaration.add(variableDeclaration169.getTree());
                    // ES3.g:1227:30: ( COMMA variableDeclaration )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==COMMA) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ES3.g:1227:32: COMMA variableDeclaration
                    	    {
                    	    COMMA170=(Token)match(input,COMMA,FOLLOW_COMMA_in_variableStatement4725);  
                    	    stream_COMMA.add(COMMA170);

                    	    pushFollow(FOLLOW_variableDeclaration_in_variableStatement4727);
                    	    variableDeclaration171=variableDeclaration();

                    	    state._fsp--;

                    	    stream_variableDeclaration.add(variableDeclaration171.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);

                    pushFollow(FOLLOW_semic_in_variableStatement4732);
                    semic172=semic();

                    state._fsp--;

                    stream_semic.add(semic172.getTree());


                    // AST REWRITE
                    // elements: variableDeclaration
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1227:67: -> ^( VAR ( variableDeclaration )+ )
                    {
                        // ES3.g:1227:70: ^( VAR ( variableDeclaration )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR, "VAR"), root_1);

                        if ( !(stream_variableDeclaration.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_variableDeclaration.hasNext() ) {
                            adaptor.addChild(root_1, stream_variableDeclaration.nextTree());

                        }
                        stream_variableDeclaration.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variableStatement"

    public static class variableDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableDeclaration"
    // ES3.g:1230:1: variableDeclaration : Identifier ( ASSIGN assignmentExpression )? ;
    public final ES3Parser.variableDeclaration_return variableDeclaration() throws RecognitionException {
        ES3Parser.variableDeclaration_return retval = new ES3Parser.variableDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Identifier173=null;
        Token ASSIGN174=null;
        ES3Parser.assignmentExpression_return assignmentExpression175 = null;


        Object Identifier173_tree=null;
        Object ASSIGN174_tree=null;

        try {
            // ES3.g:1231:2: ( Identifier ( ASSIGN assignmentExpression )? )
            // ES3.g:1231:4: Identifier ( ASSIGN assignmentExpression )?
            {
            root_0 = (Object)adaptor.nil();

            Identifier173=(Token)match(input,Identifier,FOLLOW_Identifier_in_variableDeclaration4754); 
            Identifier173_tree = (Object)adaptor.create(Identifier173);
            adaptor.addChild(root_0, Identifier173_tree);

            // ES3.g:1231:15: ( ASSIGN assignmentExpression )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==ASSIGN) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ES3.g:1231:17: ASSIGN assignmentExpression
                    {
                    ASSIGN174=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_variableDeclaration4758); 
                    ASSIGN174_tree = (Object)adaptor.create(ASSIGN174);
                    root_0 = (Object)adaptor.becomeRoot(ASSIGN174_tree, root_0);

                    pushFollow(FOLLOW_assignmentExpression_in_variableDeclaration4761);
                    assignmentExpression175=assignmentExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpression175.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variableDeclaration"

    public static class variableDeclarationNoIn_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variableDeclarationNoIn"
    // ES3.g:1234:1: variableDeclarationNoIn : Identifier ( ASSIGN assignmentExpressionNoIn )? ;
    public final ES3Parser.variableDeclarationNoIn_return variableDeclarationNoIn() throws RecognitionException {
        ES3Parser.variableDeclarationNoIn_return retval = new ES3Parser.variableDeclarationNoIn_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Identifier176=null;
        Token ASSIGN177=null;
        ES3Parser.assignmentExpressionNoIn_return assignmentExpressionNoIn178 = null;


        Object Identifier176_tree=null;
        Object ASSIGN177_tree=null;

        try {
            // ES3.g:1235:2: ( Identifier ( ASSIGN assignmentExpressionNoIn )? )
            // ES3.g:1235:4: Identifier ( ASSIGN assignmentExpressionNoIn )?
            {
            root_0 = (Object)adaptor.nil();

            Identifier176=(Token)match(input,Identifier,FOLLOW_Identifier_in_variableDeclarationNoIn4776); 
            Identifier176_tree = (Object)adaptor.create(Identifier176);
            adaptor.addChild(root_0, Identifier176_tree);

            // ES3.g:1235:15: ( ASSIGN assignmentExpressionNoIn )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==ASSIGN) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ES3.g:1235:17: ASSIGN assignmentExpressionNoIn
                    {
                    ASSIGN177=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_variableDeclarationNoIn4780); 
                    ASSIGN177_tree = (Object)adaptor.create(ASSIGN177);
                    root_0 = (Object)adaptor.becomeRoot(ASSIGN177_tree, root_0);

                    pushFollow(FOLLOW_assignmentExpressionNoIn_in_variableDeclarationNoIn4783);
                    assignmentExpressionNoIn178=assignmentExpressionNoIn();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentExpressionNoIn178.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variableDeclarationNoIn"

    public static class emptyStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "emptyStatement"
    // ES3.g:1242:1: emptyStatement : SEMIC ;
    public final ES3Parser.emptyStatement_return emptyStatement() throws RecognitionException {
        ES3Parser.emptyStatement_return retval = new ES3Parser.emptyStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SEMIC179=null;

        Object SEMIC179_tree=null;

        try {
            // ES3.g:1243:2: ( SEMIC )
            // ES3.g:1243:4: SEMIC
            {
            root_0 = (Object)adaptor.nil();

            SEMIC179=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_emptyStatement4802); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "emptyStatement"

    public static class expressionStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expressionStatement"
    // ES3.g:1256:1: expressionStatement : expression semic ;
    public final ES3Parser.expressionStatement_return expressionStatement() throws RecognitionException {
        ES3Parser.expressionStatement_return retval = new ES3Parser.expressionStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ES3Parser.expression_return expression180 = null;

        ES3Parser.semic_return semic181 = null;



        try {
            // ES3.g:1257:2: ( expression semic )
            // ES3.g:1257:4: expression semic
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_expressionStatement4821);
            expression180=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression180.getTree());
            pushFollow(FOLLOW_semic_in_expressionStatement4823);
            semic181=semic();

            state._fsp--;


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expressionStatement"

    protected static class ifStatement_scope {
        boolean elsevar;
    }
    protected Stack ifStatement_stack = new Stack();

    public static class ifStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStatement"
    // ES3.g:1264:1: ifStatement : IF LPAREN expression RPAREN ifstat= statement ({...}? ELSE elsestat= statement )? -> {$ifStatement::elsevar == true}? ^( IF expression $ifstat $elsestat) -> ^( IF expression $ifstat) ;
    public final ES3Parser.ifStatement_return ifStatement() throws RecognitionException {
        ifStatement_stack.push(new ifStatement_scope());
        ES3Parser.ifStatement_return retval = new ES3Parser.ifStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IF182=null;
        Token LPAREN183=null;
        Token RPAREN185=null;
        Token ELSE186=null;
        ES3Parser.statement_return ifstat = null;

        ES3Parser.statement_return elsestat = null;

        ES3Parser.expression_return expression184 = null;


        Object IF182_tree=null;
        Object LPAREN183_tree=null;
        Object RPAREN185_tree=null;
        Object ELSE186_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        ((ifStatement_scope)ifStatement_stack.peek()).elsevar = false;
        try {
            // ES3.g:1277:2: ( IF LPAREN expression RPAREN ifstat= statement ({...}? ELSE elsestat= statement )? -> {$ifStatement::elsevar == true}? ^( IF expression $ifstat $elsestat) -> ^( IF expression $ifstat) )
            // ES3.g:1277:4: IF LPAREN expression RPAREN ifstat= statement ({...}? ELSE elsestat= statement )?
            {
            IF182=(Token)match(input,IF,FOLLOW_IF_in_ifStatement4875);  
            stream_IF.add(IF182);

            LPAREN183=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_ifStatement4877);  
            stream_LPAREN.add(LPAREN183);

            pushFollow(FOLLOW_expression_in_ifStatement4879);
            expression184=expression();

            state._fsp--;

            stream_expression.add(expression184.getTree());
            RPAREN185=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_ifStatement4881);  
            stream_RPAREN.add(RPAREN185);

            pushFollow(FOLLOW_statement_in_ifStatement4885);
            ifstat=statement();

            state._fsp--;

            stream_statement.add(ifstat.getTree());
            // ES3.g:1277:49: ({...}? ELSE elsestat= statement )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==ELSE) ) {
                int LA53_1 = input.LA(2);

                if ( (( input.LA(1) == ELSE )) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // ES3.g:1277:51: {...}? ELSE elsestat= statement
                    {
                    if ( !(( input.LA(1) == ELSE )) ) {
                        throw new FailedPredicateException(input, "ifStatement", " input.LA(1) == ELSE ");
                    }
                    ((ifStatement_scope)ifStatement_stack.peek()).elsevar = true;
                    ELSE186=(Token)match(input,ELSE,FOLLOW_ELSE_in_ifStatement4893);  
                    stream_ELSE.add(ELSE186);

                    pushFollow(FOLLOW_statement_in_ifStatement4897);
                    elsestat=statement();

                    state._fsp--;

                    stream_statement.add(elsestat.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: expression, expression, elsestat, ifstat, IF, IF, ifstat
            // token labels: 
            // rule labels: retval, elsestat, ifstat
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_elsestat=new RewriteRuleSubtreeStream(adaptor,"token elsestat",elsestat!=null?elsestat.tree:null);
            RewriteRuleSubtreeStream stream_ifstat=new RewriteRuleSubtreeStream(adaptor,"token ifstat",ifstat!=null?ifstat.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1278:11: -> {$ifStatement::elsevar == true}? ^( IF expression $ifstat $elsestat)
            if (((ifStatement_scope)ifStatement_stack.peek()).elsevar == true) {
                // ES3.g:1278:47: ^( IF expression $ifstat $elsestat)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());
                adaptor.addChild(root_1, stream_ifstat.nextTree());
                adaptor.addChild(root_1, stream_elsestat.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }
            else // 1279:11: -> ^( IF expression $ifstat)
            {
                // ES3.g:1279:14: ^( IF expression $ifstat)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());
                adaptor.addChild(root_1, stream_ifstat.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

            ((ifStatement_scope)ifStatement_stack.peek()).elsevar = false;
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            ifStatement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "ifStatement"

    public static class iterationStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "iterationStatement"
    // ES3.g:1287:1: iterationStatement : ( doStatement | whileStatement | forStatement );
    public final ES3Parser.iterationStatement_return iterationStatement() throws RecognitionException {
        ES3Parser.iterationStatement_return retval = new ES3Parser.iterationStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ES3Parser.doStatement_return doStatement187 = null;

        ES3Parser.whileStatement_return whileStatement188 = null;

        ES3Parser.forStatement_return forStatement189 = null;



        try {
            // ES3.g:1288:2: ( doStatement | whileStatement | forStatement )
            int alt54=3;
            switch ( input.LA(1) ) {
            case DO:
                {
                alt54=1;
                }
                break;
            case WHILE:
                {
                alt54=2;
                }
                break;
            case FOR:
                {
                alt54=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // ES3.g:1288:4: doStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_doStatement_in_iterationStatement4968);
                    doStatement187=doStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, doStatement187.getTree());

                    }
                    break;
                case 2 :
                    // ES3.g:1289:4: whileStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_whileStatement_in_iterationStatement4973);
                    whileStatement188=whileStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, whileStatement188.getTree());

                    }
                    break;
                case 3 :
                    // ES3.g:1290:4: forStatement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forStatement_in_iterationStatement4978);
                    forStatement189=forStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, forStatement189.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "iterationStatement"

    public static class doStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "doStatement"
    // ES3.g:1293:1: doStatement : DO statement WHILE LPAREN expression RPAREN semic -> ^( DO statement expression ) ;
    public final ES3Parser.doStatement_return doStatement() throws RecognitionException {
        ES3Parser.doStatement_return retval = new ES3Parser.doStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DO190=null;
        Token WHILE192=null;
        Token LPAREN193=null;
        Token RPAREN195=null;
        ES3Parser.statement_return statement191 = null;

        ES3Parser.expression_return expression194 = null;

        ES3Parser.semic_return semic196 = null;


        Object DO190_tree=null;
        Object WHILE192_tree=null;
        Object LPAREN193_tree=null;
        Object RPAREN195_tree=null;
        RewriteRuleTokenStream stream_DO=new RewriteRuleTokenStream(adaptor,"token DO");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_semic=new RewriteRuleSubtreeStream(adaptor,"rule semic");
        try {
            // ES3.g:1294:2: ( DO statement WHILE LPAREN expression RPAREN semic -> ^( DO statement expression ) )
            // ES3.g:1294:4: DO statement WHILE LPAREN expression RPAREN semic
            {
            DO190=(Token)match(input,DO,FOLLOW_DO_in_doStatement4990);  
            stream_DO.add(DO190);

            pushFollow(FOLLOW_statement_in_doStatement4992);
            statement191=statement();

            state._fsp--;

            stream_statement.add(statement191.getTree());
            WHILE192=(Token)match(input,WHILE,FOLLOW_WHILE_in_doStatement4994);  
            stream_WHILE.add(WHILE192);

            LPAREN193=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_doStatement4996);  
            stream_LPAREN.add(LPAREN193);

            pushFollow(FOLLOW_expression_in_doStatement4998);
            expression194=expression();

            state._fsp--;

            stream_expression.add(expression194.getTree());
            RPAREN195=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_doStatement5000);  
            stream_RPAREN.add(RPAREN195);

            pushFollow(FOLLOW_semic_in_doStatement5002);
            semic196=semic();

            state._fsp--;

            stream_semic.add(semic196.getTree());


            // AST REWRITE
            // elements: expression, statement, DO
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1295:2: -> ^( DO statement expression )
            {
                // ES3.g:1295:5: ^( DO statement expression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_DO.nextNode(), root_1);

                adaptor.addChild(root_1, stream_statement.nextTree());
                adaptor.addChild(root_1, stream_expression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "doStatement"

    public static class whileStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "whileStatement"
    // ES3.g:1298:1: whileStatement : WHILE LPAREN expression RPAREN statement ;
    public final ES3Parser.whileStatement_return whileStatement() throws RecognitionException {
        ES3Parser.whileStatement_return retval = new ES3Parser.whileStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WHILE197=null;
        Token LPAREN198=null;
        Token RPAREN200=null;
        ES3Parser.expression_return expression199 = null;

        ES3Parser.statement_return statement201 = null;


        Object WHILE197_tree=null;
        Object LPAREN198_tree=null;
        Object RPAREN200_tree=null;

        try {
            // ES3.g:1299:2: ( WHILE LPAREN expression RPAREN statement )
            // ES3.g:1299:4: WHILE LPAREN expression RPAREN statement
            {
            root_0 = (Object)adaptor.nil();

            WHILE197=(Token)match(input,WHILE,FOLLOW_WHILE_in_whileStatement5027); 
            WHILE197_tree = (Object)adaptor.create(WHILE197);
            root_0 = (Object)adaptor.becomeRoot(WHILE197_tree, root_0);

            LPAREN198=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_whileStatement5030); 
            pushFollow(FOLLOW_expression_in_whileStatement5033);
            expression199=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression199.getTree());
            RPAREN200=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_whileStatement5035); 
            pushFollow(FOLLOW_statement_in_whileStatement5038);
            statement201=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement201.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "whileStatement"

    public static class forStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forStatement"
    // ES3.g:1343:1: forStatement : FOR ( EACH )? LPAREN forControl RPAREN statement ;
    public final ES3Parser.forStatement_return forStatement() throws RecognitionException {
        ES3Parser.forStatement_return retval = new ES3Parser.forStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FOR202=null;
        Token EACH203=null;
        Token LPAREN204=null;
        Token RPAREN206=null;
        ES3Parser.forControl_return forControl205 = null;

        ES3Parser.statement_return statement207 = null;


        Object FOR202_tree=null;
        Object EACH203_tree=null;
        Object LPAREN204_tree=null;
        Object RPAREN206_tree=null;

        try {
            // ES3.g:1344:2: ( FOR ( EACH )? LPAREN forControl RPAREN statement )
            // ES3.g:1344:4: FOR ( EACH )? LPAREN forControl RPAREN statement
            {
            root_0 = (Object)adaptor.nil();

            FOR202=(Token)match(input,FOR,FOLLOW_FOR_in_forStatement5051); 
            FOR202_tree = (Object)adaptor.create(FOR202);
            root_0 = (Object)adaptor.becomeRoot(FOR202_tree, root_0);

            // ES3.g:1344:9: ( EACH )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==EACH) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ES3.g:1344:10: EACH
                    {
                    EACH203=(Token)match(input,EACH,FOLLOW_EACH_in_forStatement5055); 

                    }
                    break;

            }

            LPAREN204=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_forStatement5060); 
            pushFollow(FOLLOW_forControl_in_forStatement5063);
            forControl205=forControl();

            state._fsp--;

            adaptor.addChild(root_0, forControl205.getTree());
            RPAREN206=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_forStatement5065); 
            pushFollow(FOLLOW_statement_in_forStatement5068);
            statement207=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement207.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "forStatement"

    public static class forControl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forControl"
    // ES3.g:1347:1: forControl : ( forControlVar | forControlExpression | forControlSemic );
    public final ES3Parser.forControl_return forControl() throws RecognitionException {
        ES3Parser.forControl_return retval = new ES3Parser.forControl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ES3Parser.forControlVar_return forControlVar208 = null;

        ES3Parser.forControlExpression_return forControlExpression209 = null;

        ES3Parser.forControlSemic_return forControlSemic210 = null;



        try {
            // ES3.g:1348:2: ( forControlVar | forControlExpression | forControlSemic )
            int alt56=3;
            switch ( input.LA(1) ) {
            case VAR:
                {
                alt56=1;
                }
                break;
            case NULL:
            case TRUE:
            case FALSE:
            case DELETE:
            case FUNCTION:
            case NEW:
            case THIS:
            case TYPEOF:
            case VOID:
            case LBRACE:
            case LPAREN:
            case LBRACK:
            case ADD:
            case SUB:
            case INC:
            case DEC:
            case NOT:
            case INV:
            case Identifier:
            case StringLiteral:
            case RegularExpressionLiteral:
            case DecimalLiteral:
            case OctalIntegerLiteral:
            case HexIntegerLiteral:
                {
                alt56=2;
                }
                break;
            case SEMIC:
                {
                alt56=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // ES3.g:1348:4: forControlVar
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forControlVar_in_forControl5079);
                    forControlVar208=forControlVar();

                    state._fsp--;

                    adaptor.addChild(root_0, forControlVar208.getTree());

                    }
                    break;
                case 2 :
                    // ES3.g:1349:4: forControlExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forControlExpression_in_forControl5084);
                    forControlExpression209=forControlExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, forControlExpression209.getTree());

                    }
                    break;
                case 3 :
                    // ES3.g:1350:4: forControlSemic
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forControlSemic_in_forControl5089);
                    forControlSemic210=forControlSemic();

                    state._fsp--;

                    adaptor.addChild(root_0, forControlSemic210.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "forControl"

    public static class forControlVar_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forControlVar"
    // ES3.g:1353:1: forControlVar : VAR variableDeclarationNoIn ( ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) ) | ( ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) ) ) ;
    public final ES3Parser.forControlVar_return forControlVar() throws RecognitionException {
        ES3Parser.forControlVar_return retval = new ES3Parser.forControlVar_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VAR211=null;
        Token IN213=null;
        Token COMMA215=null;
        Token SEMIC217=null;
        Token SEMIC218=null;
        ES3Parser.expression_return ex1 = null;

        ES3Parser.expression_return ex2 = null;

        ES3Parser.variableDeclarationNoIn_return variableDeclarationNoIn212 = null;

        ES3Parser.expression_return expression214 = null;

        ES3Parser.variableDeclarationNoIn_return variableDeclarationNoIn216 = null;


        Object VAR211_tree=null;
        Object IN213_tree=null;
        Object COMMA215_tree=null;
        Object SEMIC217_tree=null;
        Object SEMIC218_tree=null;
        RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleTokenStream stream_SEMIC=new RewriteRuleTokenStream(adaptor,"token SEMIC");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_variableDeclarationNoIn=new RewriteRuleSubtreeStream(adaptor,"rule variableDeclarationNoIn");
        try {
            // ES3.g:1354:2: ( VAR variableDeclarationNoIn ( ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) ) | ( ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) ) ) )
            // ES3.g:1354:4: VAR variableDeclarationNoIn ( ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) ) | ( ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) ) )
            {
            VAR211=(Token)match(input,VAR,FOLLOW_VAR_in_forControlVar5100);  
            stream_VAR.add(VAR211);

            pushFollow(FOLLOW_variableDeclarationNoIn_in_forControlVar5102);
            variableDeclarationNoIn212=variableDeclarationNoIn();

            state._fsp--;

            stream_variableDeclarationNoIn.add(variableDeclarationNoIn212.getTree());
            // ES3.g:1355:2: ( ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) ) | ( ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==IN) ) {
                alt60=1;
            }
            else if ( ((LA60_0>=SEMIC && LA60_0<=COMMA)) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ES3.g:1356:3: ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) )
                    {
                    // ES3.g:1356:3: ( IN expression -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) ) )
                    // ES3.g:1357:4: IN expression
                    {
                    IN213=(Token)match(input,IN,FOLLOW_IN_in_forControlVar5114);  
                    stream_IN.add(IN213);

                    pushFollow(FOLLOW_expression_in_forControlVar5116);
                    expression214=expression();

                    state._fsp--;

                    stream_expression.add(expression214.getTree());


                    // AST REWRITE
                    // elements: variableDeclarationNoIn, expression, VAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1358:4: -> ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) )
                    {
                        // ES3.g:1358:7: ^( FORITER ^( VAR variableDeclarationNoIn ) ^( EXPR expression ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORITER, "FORITER"), root_1);

                        // ES3.g:1358:18: ^( VAR variableDeclarationNoIn )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(stream_VAR.nextNode(), root_2);

                        adaptor.addChild(root_2, stream_variableDeclarationNoIn.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // ES3.g:1358:51: ^( EXPR expression )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_2);

                        adaptor.addChild(root_2, stream_expression.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }


                    }
                    break;
                case 2 :
                    // ES3.g:1361:3: ( ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) )
                    {
                    // ES3.g:1361:3: ( ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) )
                    // ES3.g:1362:4: ( COMMA variableDeclarationNoIn )* SEMIC (ex1= expression )? SEMIC (ex2= expression )?
                    {
                    // ES3.g:1362:4: ( COMMA variableDeclarationNoIn )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==COMMA) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ES3.g:1362:6: COMMA variableDeclarationNoIn
                    	    {
                    	    COMMA215=(Token)match(input,COMMA,FOLLOW_COMMA_in_forControlVar5162);  
                    	    stream_COMMA.add(COMMA215);

                    	    pushFollow(FOLLOW_variableDeclarationNoIn_in_forControlVar5164);
                    	    variableDeclarationNoIn216=variableDeclarationNoIn();

                    	    state._fsp--;

                    	    stream_variableDeclarationNoIn.add(variableDeclarationNoIn216.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);

                    SEMIC217=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_forControlVar5169);  
                    stream_SEMIC.add(SEMIC217);

                    // ES3.g:1362:48: (ex1= expression )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( ((LA58_0>=NULL && LA58_0<=FALSE)||LA58_0==DELETE||LA58_0==FUNCTION||LA58_0==NEW||LA58_0==THIS||LA58_0==TYPEOF||LA58_0==VOID||LA58_0==LBRACE||LA58_0==LPAREN||LA58_0==LBRACK||(LA58_0>=ADD && LA58_0<=SUB)||(LA58_0>=INC && LA58_0<=DEC)||(LA58_0>=NOT && LA58_0<=INV)||(LA58_0>=Identifier && LA58_0<=StringLiteral)||LA58_0==RegularExpressionLiteral||(LA58_0>=DecimalLiteral && LA58_0<=HexIntegerLiteral)) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // ES3.g:1362:48: ex1= expression
                            {
                            pushFollow(FOLLOW_expression_in_forControlVar5173);
                            ex1=expression();

                            state._fsp--;

                            stream_expression.add(ex1.getTree());

                            }
                            break;

                    }

                    SEMIC218=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_forControlVar5176);  
                    stream_SEMIC.add(SEMIC218);

                    // ES3.g:1362:70: (ex2= expression )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( ((LA59_0>=NULL && LA59_0<=FALSE)||LA59_0==DELETE||LA59_0==FUNCTION||LA59_0==NEW||LA59_0==THIS||LA59_0==TYPEOF||LA59_0==VOID||LA59_0==LBRACE||LA59_0==LPAREN||LA59_0==LBRACK||(LA59_0>=ADD && LA59_0<=SUB)||(LA59_0>=INC && LA59_0<=DEC)||(LA59_0>=NOT && LA59_0<=INV)||(LA59_0>=Identifier && LA59_0<=StringLiteral)||LA59_0==RegularExpressionLiteral||(LA59_0>=DecimalLiteral && LA59_0<=HexIntegerLiteral)) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // ES3.g:1362:70: ex2= expression
                            {
                            pushFollow(FOLLOW_expression_in_forControlVar5180);
                            ex2=expression();

                            state._fsp--;

                            stream_expression.add(ex2.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: variableDeclarationNoIn, ex2, ex1, VAR
                    // token labels: 
                    // rule labels: retval, ex2, ex1
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ex2=new RewriteRuleSubtreeStream(adaptor,"token ex2",ex2!=null?ex2.tree:null);
                    RewriteRuleSubtreeStream stream_ex1=new RewriteRuleSubtreeStream(adaptor,"token ex1",ex1!=null?ex1.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1363:4: -> ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) )
                    {
                        // ES3.g:1363:7: ^( FORSTEP ^( VAR ( variableDeclarationNoIn )+ ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORSTEP, "FORSTEP"), root_1);

                        // ES3.g:1363:18: ^( VAR ( variableDeclarationNoIn )+ )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot(stream_VAR.nextNode(), root_2);

                        if ( !(stream_variableDeclarationNoIn.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_variableDeclarationNoIn.hasNext() ) {
                            adaptor.addChild(root_2, stream_variableDeclarationNoIn.nextTree());

                        }
                        stream_variableDeclarationNoIn.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // ES3.g:1363:52: ^( EXPR ( $ex1)? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_2);

                        // ES3.g:1363:60: ( $ex1)?
                        if ( stream_ex1.hasNext() ) {
                            adaptor.addChild(root_2, stream_ex1.nextTree());

                        }
                        stream_ex1.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // ES3.g:1363:68: ^( EXPR ( $ex2)? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_2);

                        // ES3.g:1363:76: ( $ex2)?
                        if ( stream_ex2.hasNext() ) {
                            adaptor.addChild(root_2, stream_ex2.nextTree());

                        }
                        stream_ex2.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "forControlVar"

    public static class forControlExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forControlExpression"
    // ES3.g:1368:1: forControlExpression : ex1= expressionNoIn ({...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) ) | ( SEMIC (ex2= expression )? SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) ) ) ) ;
    public final ES3Parser.forControlExpression_return forControlExpression() throws RecognitionException {
        ES3Parser.forControlExpression_return retval = new ES3Parser.forControlExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IN219=null;
        Token SEMIC220=null;
        Token SEMIC221=null;
        ES3Parser.expressionNoIn_return ex1 = null;

        ES3Parser.expression_return ex2 = null;

        ES3Parser.expression_return ex3 = null;


        Object IN219_tree=null;
        Object SEMIC220_tree=null;
        Object SEMIC221_tree=null;
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleTokenStream stream_SEMIC=new RewriteRuleTokenStream(adaptor,"token SEMIC");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_expressionNoIn=new RewriteRuleSubtreeStream(adaptor,"rule expressionNoIn");

        	Object[] isLhs = new Object[1];

        try {
            // ES3.g:1373:2: (ex1= expressionNoIn ({...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) ) | ( SEMIC (ex2= expression )? SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) ) ) ) )
            // ES3.g:1373:4: ex1= expressionNoIn ({...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) ) | ( SEMIC (ex2= expression )? SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) ) ) )
            {
            pushFollow(FOLLOW_expressionNoIn_in_forControlExpression5246);
            ex1=expressionNoIn();

            state._fsp--;

            stream_expressionNoIn.add(ex1.getTree());
            // ES3.g:1374:2: ({...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) ) | ( SEMIC (ex2= expression )? SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) ) ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==IN) ) {
                alt63=1;
            }
            else if ( (LA63_0==SEMIC) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ES3.g:1375:3: {...}? ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) )
                    {
                    if ( !(( isLeftHandSideIn(ex1, isLhs) )) ) {
                        throw new FailedPredicateException(input, "forControlExpression", " isLeftHandSideIn(ex1, isLhs) ");
                    }
                    // ES3.g:1375:37: ( IN ex2= expression -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) ) )
                    // ES3.g:1376:4: IN ex2= expression
                    {
                    IN219=(Token)match(input,IN,FOLLOW_IN_in_forControlExpression5261);  
                    stream_IN.add(IN219);

                    pushFollow(FOLLOW_expression_in_forControlExpression5265);
                    ex2=expression();

                    state._fsp--;

                    stream_expression.add(ex2.getTree());


                    // AST REWRITE
                    // elements: ex1, ex2
                    // token labels: 
                    // rule labels: retval, ex2, ex1
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ex2=new RewriteRuleSubtreeStream(adaptor,"token ex2",ex2!=null?ex2.tree:null);
                    RewriteRuleSubtreeStream stream_ex1=new RewriteRuleSubtreeStream(adaptor,"token ex1",ex1!=null?ex1.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1377:4: -> ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) )
                    {
                        // ES3.g:1377:7: ^( FORITER ^( EXPR $ex1) ^( EXPR $ex2) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORITER, "FORITER"), root_1);

                        // ES3.g:1377:18: ^( EXPR $ex1)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_2);

                        adaptor.addChild(root_2, stream_ex1.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // ES3.g:1377:33: ^( EXPR $ex2)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_2);

                        adaptor.addChild(root_2, stream_ex2.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }


                    }
                    break;
                case 2 :
                    // ES3.g:1380:3: ( SEMIC (ex2= expression )? SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) ) )
                    {
                    // ES3.g:1380:3: ( SEMIC (ex2= expression )? SEMIC (ex3= expression )? -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) ) )
                    // ES3.g:1381:4: SEMIC (ex2= expression )? SEMIC (ex3= expression )?
                    {
                    SEMIC220=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_forControlExpression5311);  
                    stream_SEMIC.add(SEMIC220);

                    // ES3.g:1381:13: (ex2= expression )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( ((LA61_0>=NULL && LA61_0<=FALSE)||LA61_0==DELETE||LA61_0==FUNCTION||LA61_0==NEW||LA61_0==THIS||LA61_0==TYPEOF||LA61_0==VOID||LA61_0==LBRACE||LA61_0==LPAREN||LA61_0==LBRACK||(LA61_0>=ADD && LA61_0<=SUB)||(LA61_0>=INC && LA61_0<=DEC)||(LA61_0>=NOT && LA61_0<=INV)||(LA61_0>=Identifier && LA61_0<=StringLiteral)||LA61_0==RegularExpressionLiteral||(LA61_0>=DecimalLiteral && LA61_0<=HexIntegerLiteral)) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // ES3.g:1381:13: ex2= expression
                            {
                            pushFollow(FOLLOW_expression_in_forControlExpression5315);
                            ex2=expression();

                            state._fsp--;

                            stream_expression.add(ex2.getTree());

                            }
                            break;

                    }

                    SEMIC221=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_forControlExpression5318);  
                    stream_SEMIC.add(SEMIC221);

                    // ES3.g:1381:35: (ex3= expression )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( ((LA62_0>=NULL && LA62_0<=FALSE)||LA62_0==DELETE||LA62_0==FUNCTION||LA62_0==NEW||LA62_0==THIS||LA62_0==TYPEOF||LA62_0==VOID||LA62_0==LBRACE||LA62_0==LPAREN||LA62_0==LBRACK||(LA62_0>=ADD && LA62_0<=SUB)||(LA62_0>=INC && LA62_0<=DEC)||(LA62_0>=NOT && LA62_0<=INV)||(LA62_0>=Identifier && LA62_0<=StringLiteral)||LA62_0==RegularExpressionLiteral||(LA62_0>=DecimalLiteral && LA62_0<=HexIntegerLiteral)) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // ES3.g:1381:35: ex3= expression
                            {
                            pushFollow(FOLLOW_expression_in_forControlExpression5322);
                            ex3=expression();

                            state._fsp--;

                            stream_expression.add(ex3.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: ex2, ex3, ex1
                    // token labels: 
                    // rule labels: retval, ex3, ex2, ex1
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ex3=new RewriteRuleSubtreeStream(adaptor,"token ex3",ex3!=null?ex3.tree:null);
                    RewriteRuleSubtreeStream stream_ex2=new RewriteRuleSubtreeStream(adaptor,"token ex2",ex2!=null?ex2.tree:null);
                    RewriteRuleSubtreeStream stream_ex1=new RewriteRuleSubtreeStream(adaptor,"token ex1",ex1!=null?ex1.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 1382:4: -> ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) )
                    {
                        // ES3.g:1382:7: ^( FORSTEP ^( EXPR $ex1) ^( EXPR ( $ex2)? ) ^( EXPR ( $ex3)? ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORSTEP, "FORSTEP"), root_1);

                        // ES3.g:1382:18: ^( EXPR $ex1)
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_2);

                        adaptor.addChild(root_2, stream_ex1.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }
                        // ES3.g:1382:33: ^( EXPR ( $ex2)? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_2);

                        // ES3.g:1382:41: ( $ex2)?
                        if ( stream_ex2.hasNext() ) {
                            adaptor.addChild(root_2, stream_ex2.nextTree());

                        }
                        stream_ex2.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // ES3.g:1382:49: ^( EXPR ( $ex3)? )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_2);

                        // ES3.g:1382:57: ( $ex3)?
                        if ( stream_ex3.hasNext() ) {
                            adaptor.addChild(root_2, stream_ex3.nextTree());

                        }
                        stream_ex3.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "forControlExpression"

    public static class forControlSemic_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forControlSemic"
    // ES3.g:1387:1: forControlSemic : SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( EXPR ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) ;
    public final ES3Parser.forControlSemic_return forControlSemic() throws RecognitionException {
        ES3Parser.forControlSemic_return retval = new ES3Parser.forControlSemic_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SEMIC222=null;
        Token SEMIC223=null;
        ES3Parser.expression_return ex1 = null;

        ES3Parser.expression_return ex2 = null;


        Object SEMIC222_tree=null;
        Object SEMIC223_tree=null;
        RewriteRuleTokenStream stream_SEMIC=new RewriteRuleTokenStream(adaptor,"token SEMIC");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        try {
            // ES3.g:1388:2: ( SEMIC (ex1= expression )? SEMIC (ex2= expression )? -> ^( FORSTEP ^( EXPR ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) ) )
            // ES3.g:1388:4: SEMIC (ex1= expression )? SEMIC (ex2= expression )?
            {
            SEMIC222=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_forControlSemic5381);  
            stream_SEMIC.add(SEMIC222);

            // ES3.g:1388:13: (ex1= expression )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=NULL && LA64_0<=FALSE)||LA64_0==DELETE||LA64_0==FUNCTION||LA64_0==NEW||LA64_0==THIS||LA64_0==TYPEOF||LA64_0==VOID||LA64_0==LBRACE||LA64_0==LPAREN||LA64_0==LBRACK||(LA64_0>=ADD && LA64_0<=SUB)||(LA64_0>=INC && LA64_0<=DEC)||(LA64_0>=NOT && LA64_0<=INV)||(LA64_0>=Identifier && LA64_0<=StringLiteral)||LA64_0==RegularExpressionLiteral||(LA64_0>=DecimalLiteral && LA64_0<=HexIntegerLiteral)) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ES3.g:1388:13: ex1= expression
                    {
                    pushFollow(FOLLOW_expression_in_forControlSemic5385);
                    ex1=expression();

                    state._fsp--;

                    stream_expression.add(ex1.getTree());

                    }
                    break;

            }

            SEMIC223=(Token)match(input,SEMIC,FOLLOW_SEMIC_in_forControlSemic5388);  
            stream_SEMIC.add(SEMIC223);

            // ES3.g:1388:35: (ex2= expression )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=NULL && LA65_0<=FALSE)||LA65_0==DELETE||LA65_0==FUNCTION||LA65_0==NEW||LA65_0==THIS||LA65_0==TYPEOF||LA65_0==VOID||LA65_0==LBRACE||LA65_0==LPAREN||LA65_0==LBRACK||(LA65_0>=ADD && LA65_0<=SUB)||(LA65_0>=INC && LA65_0<=DEC)||(LA65_0>=NOT && LA65_0<=INV)||(LA65_0>=Identifier && LA65_0<=StringLiteral)||LA65_0==RegularExpressionLiteral||(LA65_0>=DecimalLiteral && LA65_0<=HexIntegerLiteral)) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ES3.g:1388:35: ex2= expression
                    {
                    pushFollow(FOLLOW_expression_in_forControlSemic5392);
                    ex2=expression();

                    state._fsp--;

                    stream_expression.add(ex2.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: ex1, ex2
            // token labels: 
            // rule labels: retval, ex2, ex1
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_ex2=new RewriteRuleSubtreeStream(adaptor,"token ex2",ex2!=null?ex2.tree:null);
            RewriteRuleSubtreeStream stream_ex1=new RewriteRuleSubtreeStream(adaptor,"token ex1",ex1!=null?ex1.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1389:2: -> ^( FORSTEP ^( EXPR ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) )
            {
                // ES3.g:1389:5: ^( FORSTEP ^( EXPR ) ^( EXPR ( $ex1)? ) ^( EXPR ( $ex2)? ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FORSTEP, "FORSTEP"), root_1);

                // ES3.g:1389:16: ^( EXPR )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_2);

                adaptor.addChild(root_1, root_2);
                }
                // ES3.g:1389:26: ^( EXPR ( $ex1)? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_2);

                // ES3.g:1389:34: ( $ex1)?
                if ( stream_ex1.hasNext() ) {
                    adaptor.addChild(root_2, stream_ex1.nextTree());

                }
                stream_ex1.reset();

                adaptor.addChild(root_1, root_2);
                }
                // ES3.g:1389:42: ^( EXPR ( $ex2)? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_2);

                // ES3.g:1389:50: ( $ex2)?
                if ( stream_ex2.hasNext() ) {
                    adaptor.addChild(root_2, stream_ex2.nextTree());

                }
                stream_ex2.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "forControlSemic"

    public static class continueStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "continueStatement"
    // ES3.g:1401:1: continueStatement : CONTINUE ( Identifier )? semic ;
    public final ES3Parser.continueStatement_return continueStatement() throws RecognitionException {
        ES3Parser.continueStatement_return retval = new ES3Parser.continueStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CONTINUE224=null;
        Token Identifier225=null;
        ES3Parser.semic_return semic226 = null;


        Object CONTINUE224_tree=null;
        Object Identifier225_tree=null;

        try {
            // ES3.g:1402:2: ( CONTINUE ( Identifier )? semic )
            // ES3.g:1402:4: CONTINUE ( Identifier )? semic
            {
            root_0 = (Object)adaptor.nil();

            CONTINUE224=(Token)match(input,CONTINUE,FOLLOW_CONTINUE_in_continueStatement5446); 
            CONTINUE224_tree = (Object)adaptor.create(CONTINUE224);
            root_0 = (Object)adaptor.becomeRoot(CONTINUE224_tree, root_0);

             if (input.LA(1) == Identifier) promoteEOL(null); 
            // ES3.g:1402:67: ( Identifier )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==Identifier) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ES3.g:1402:67: Identifier
                    {
                    Identifier225=(Token)match(input,Identifier,FOLLOW_Identifier_in_continueStatement5451); 
                    Identifier225_tree = (Object)adaptor.create(Identifier225);
                    adaptor.addChild(root_0, Identifier225_tree);


                    }
                    break;

            }

            pushFollow(FOLLOW_semic_in_continueStatement5454);
            semic226=semic();

            state._fsp--;


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "continueStatement"

    public static class breakStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "breakStatement"
    // ES3.g:1414:1: breakStatement : BREAK ( Identifier )? semic ;
    public final ES3Parser.breakStatement_return breakStatement() throws RecognitionException {
        ES3Parser.breakStatement_return retval = new ES3Parser.breakStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BREAK227=null;
        Token Identifier228=null;
        ES3Parser.semic_return semic229 = null;


        Object BREAK227_tree=null;
        Object Identifier228_tree=null;

        try {
            // ES3.g:1415:2: ( BREAK ( Identifier )? semic )
            // ES3.g:1415:4: BREAK ( Identifier )? semic
            {
            root_0 = (Object)adaptor.nil();

            BREAK227=(Token)match(input,BREAK,FOLLOW_BREAK_in_breakStatement5473); 
            BREAK227_tree = (Object)adaptor.create(BREAK227);
            root_0 = (Object)adaptor.becomeRoot(BREAK227_tree, root_0);

             if (input.LA(1) == Identifier) promoteEOL(null); 
            // ES3.g:1415:64: ( Identifier )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==Identifier) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ES3.g:1415:64: Identifier
                    {
                    Identifier228=(Token)match(input,Identifier,FOLLOW_Identifier_in_breakStatement5478); 
                    Identifier228_tree = (Object)adaptor.create(Identifier228);
                    adaptor.addChild(root_0, Identifier228_tree);


                    }
                    break;

            }

            pushFollow(FOLLOW_semic_in_breakStatement5481);
            semic229=semic();

            state._fsp--;


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "breakStatement"

    public static class returnStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "returnStatement"
    // ES3.g:1435:1: returnStatement : RETURN ( expression )? semic ;
    public final ES3Parser.returnStatement_return returnStatement() throws RecognitionException {
        ES3Parser.returnStatement_return retval = new ES3Parser.returnStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token RETURN230=null;
        ES3Parser.expression_return expression231 = null;

        ES3Parser.semic_return semic232 = null;


        Object RETURN230_tree=null;

        try {
            // ES3.g:1436:2: ( RETURN ( expression )? semic )
            // ES3.g:1436:4: RETURN ( expression )? semic
            {
            root_0 = (Object)adaptor.nil();

            RETURN230=(Token)match(input,RETURN,FOLLOW_RETURN_in_returnStatement5500); 
            RETURN230_tree = (Object)adaptor.create(RETURN230);
            root_0 = (Object)adaptor.becomeRoot(RETURN230_tree, root_0);

             promoteEOL(null); 
            // ES3.g:1436:34: ( expression )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=NULL && LA68_0<=FALSE)||LA68_0==DELETE||LA68_0==FUNCTION||LA68_0==NEW||LA68_0==THIS||LA68_0==TYPEOF||LA68_0==VOID||LA68_0==LBRACE||LA68_0==LPAREN||LA68_0==LBRACK||(LA68_0>=ADD && LA68_0<=SUB)||(LA68_0>=INC && LA68_0<=DEC)||(LA68_0>=NOT && LA68_0<=INV)||(LA68_0>=Identifier && LA68_0<=StringLiteral)||LA68_0==RegularExpressionLiteral||(LA68_0>=DecimalLiteral && LA68_0<=HexIntegerLiteral)) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ES3.g:1436:34: expression
                    {
                    pushFollow(FOLLOW_expression_in_returnStatement5505);
                    expression231=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression231.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_semic_in_returnStatement5508);
            semic232=semic();

            state._fsp--;


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "returnStatement"

    public static class withStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "withStatement"
    // ES3.g:1443:1: withStatement : WITH LPAREN expression RPAREN statement ;
    public final ES3Parser.withStatement_return withStatement() throws RecognitionException {
        ES3Parser.withStatement_return retval = new ES3Parser.withStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WITH233=null;
        Token LPAREN234=null;
        Token RPAREN236=null;
        ES3Parser.expression_return expression235 = null;

        ES3Parser.statement_return statement237 = null;


        Object WITH233_tree=null;
        Object LPAREN234_tree=null;
        Object RPAREN236_tree=null;

        try {
            // ES3.g:1444:2: ( WITH LPAREN expression RPAREN statement )
            // ES3.g:1444:4: WITH LPAREN expression RPAREN statement
            {
            root_0 = (Object)adaptor.nil();

            WITH233=(Token)match(input,WITH,FOLLOW_WITH_in_withStatement5525); 
            WITH233_tree = (Object)adaptor.create(WITH233);
            root_0 = (Object)adaptor.becomeRoot(WITH233_tree, root_0);

            LPAREN234=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_withStatement5528); 
            pushFollow(FOLLOW_expression_in_withStatement5531);
            expression235=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression235.getTree());
            RPAREN236=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_withStatement5533); 
            pushFollow(FOLLOW_statement_in_withStatement5536);
            statement237=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement237.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "withStatement"

    public static class switchStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "switchStatement"
    // ES3.g:1451:1: switchStatement : SWITCH LPAREN expression RPAREN LBRACE ({...}? => defaultClause | caseClause )* RBRACE -> ^( SWITCH expression ( defaultClause )? ( caseClause )* ) ;
    public final ES3Parser.switchStatement_return switchStatement() throws RecognitionException {
        ES3Parser.switchStatement_return retval = new ES3Parser.switchStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SWITCH238=null;
        Token LPAREN239=null;
        Token RPAREN241=null;
        Token LBRACE242=null;
        Token RBRACE245=null;
        ES3Parser.expression_return expression240 = null;

        ES3Parser.defaultClause_return defaultClause243 = null;

        ES3Parser.caseClause_return caseClause244 = null;


        Object SWITCH238_tree=null;
        Object LPAREN239_tree=null;
        Object RPAREN241_tree=null;
        Object LBRACE242_tree=null;
        Object RBRACE245_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_SWITCH=new RewriteRuleTokenStream(adaptor,"token SWITCH");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_caseClause=new RewriteRuleSubtreeStream(adaptor,"rule caseClause");
        RewriteRuleSubtreeStream stream_defaultClause=new RewriteRuleSubtreeStream(adaptor,"rule defaultClause");

        	int defaultClauseCount = 0;

        try {
            // ES3.g:1456:2: ( SWITCH LPAREN expression RPAREN LBRACE ({...}? => defaultClause | caseClause )* RBRACE -> ^( SWITCH expression ( defaultClause )? ( caseClause )* ) )
            // ES3.g:1456:4: SWITCH LPAREN expression RPAREN LBRACE ({...}? => defaultClause | caseClause )* RBRACE
            {
            SWITCH238=(Token)match(input,SWITCH,FOLLOW_SWITCH_in_switchStatement5557);  
            stream_SWITCH.add(SWITCH238);

            LPAREN239=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_switchStatement5559);  
            stream_LPAREN.add(LPAREN239);

            pushFollow(FOLLOW_expression_in_switchStatement5561);
            expression240=expression();

            state._fsp--;

            stream_expression.add(expression240.getTree());
            RPAREN241=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_switchStatement5563);  
            stream_RPAREN.add(RPAREN241);

            LBRACE242=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_switchStatement5565);  
            stream_LBRACE.add(LBRACE242);

            // ES3.g:1456:43: ({...}? => defaultClause | caseClause )*
            loop69:
            do {
                int alt69=3;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==DEFAULT) && (( defaultClauseCount == 0 ))) {
                    alt69=1;
                }
                else if ( (LA69_0==CASE) ) {
                    alt69=2;
                }


                switch (alt69) {
            	case 1 :
            	    // ES3.g:1456:45: {...}? => defaultClause
            	    {
            	    if ( !(( defaultClauseCount == 0 )) ) {
            	        throw new FailedPredicateException(input, "switchStatement", " defaultClauseCount == 0 ");
            	    }
            	    pushFollow(FOLLOW_defaultClause_in_switchStatement5572);
            	    defaultClause243=defaultClause();

            	    state._fsp--;

            	    stream_defaultClause.add(defaultClause243.getTree());
            	     defaultClauseCount++; 

            	    }
            	    break;
            	case 2 :
            	    // ES3.g:1456:118: caseClause
            	    {
            	    pushFollow(FOLLOW_caseClause_in_switchStatement5578);
            	    caseClause244=caseClause();

            	    state._fsp--;

            	    stream_caseClause.add(caseClause244.getTree());

            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);

            RBRACE245=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_switchStatement5583);  
            stream_RBRACE.add(RBRACE245);



            // AST REWRITE
            // elements: caseClause, SWITCH, defaultClause, expression
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1457:2: -> ^( SWITCH expression ( defaultClause )? ( caseClause )* )
            {
                // ES3.g:1457:5: ^( SWITCH expression ( defaultClause )? ( caseClause )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_SWITCH.nextNode(), root_1);

                adaptor.addChild(root_1, stream_expression.nextTree());
                // ES3.g:1457:26: ( defaultClause )?
                if ( stream_defaultClause.hasNext() ) {
                    adaptor.addChild(root_1, stream_defaultClause.nextTree());

                }
                stream_defaultClause.reset();
                // ES3.g:1457:41: ( caseClause )*
                while ( stream_caseClause.hasNext() ) {
                    adaptor.addChild(root_1, stream_caseClause.nextTree());

                }
                stream_caseClause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "switchStatement"

    public static class caseClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "caseClause"
    // ES3.g:1460:1: caseClause : CASE expression COLON ( statement )* ;
    public final ES3Parser.caseClause_return caseClause() throws RecognitionException {
        ES3Parser.caseClause_return retval = new ES3Parser.caseClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CASE246=null;
        Token COLON248=null;
        ES3Parser.expression_return expression247 = null;

        ES3Parser.statement_return statement249 = null;


        Object CASE246_tree=null;
        Object COLON248_tree=null;

        try {
            // ES3.g:1461:2: ( CASE expression COLON ( statement )* )
            // ES3.g:1461:4: CASE expression COLON ( statement )*
            {
            root_0 = (Object)adaptor.nil();

            CASE246=(Token)match(input,CASE,FOLLOW_CASE_in_caseClause5611); 
            CASE246_tree = (Object)adaptor.create(CASE246);
            root_0 = (Object)adaptor.becomeRoot(CASE246_tree, root_0);

            pushFollow(FOLLOW_expression_in_caseClause5614);
            expression247=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression247.getTree());
            COLON248=(Token)match(input,COLON,FOLLOW_COLON_in_caseClause5616); 
            // ES3.g:1461:28: ( statement )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( ((LA70_0>=NULL && LA70_0<=BREAK)||LA70_0==CONTINUE||(LA70_0>=DELETE && LA70_0<=DO)||(LA70_0>=FOR && LA70_0<=IF)||(LA70_0>=NEW && LA70_0<=WITH)||LA70_0==CONST||LA70_0==LBRACE||LA70_0==LPAREN||LA70_0==LBRACK||LA70_0==SEMIC||(LA70_0>=ADD && LA70_0<=SUB)||(LA70_0>=INC && LA70_0<=DEC)||(LA70_0>=NOT && LA70_0<=INV)||(LA70_0>=Identifier && LA70_0<=StringLiteral)||LA70_0==RegularExpressionLiteral||(LA70_0>=DecimalLiteral && LA70_0<=HexIntegerLiteral)) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // ES3.g:1461:28: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_caseClause5619);
            	    statement249=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement249.getTree());

            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "caseClause"

    public static class defaultClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defaultClause"
    // ES3.g:1464:1: defaultClause : DEFAULT COLON ( statement )* ;
    public final ES3Parser.defaultClause_return defaultClause() throws RecognitionException {
        ES3Parser.defaultClause_return retval = new ES3Parser.defaultClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DEFAULT250=null;
        Token COLON251=null;
        ES3Parser.statement_return statement252 = null;


        Object DEFAULT250_tree=null;
        Object COLON251_tree=null;

        try {
            // ES3.g:1465:2: ( DEFAULT COLON ( statement )* )
            // ES3.g:1465:4: DEFAULT COLON ( statement )*
            {
            root_0 = (Object)adaptor.nil();

            DEFAULT250=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_defaultClause5632); 
            DEFAULT250_tree = (Object)adaptor.create(DEFAULT250);
            root_0 = (Object)adaptor.becomeRoot(DEFAULT250_tree, root_0);

            COLON251=(Token)match(input,COLON,FOLLOW_COLON_in_defaultClause5635); 
            // ES3.g:1465:20: ( statement )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( ((LA71_0>=NULL && LA71_0<=BREAK)||LA71_0==CONTINUE||(LA71_0>=DELETE && LA71_0<=DO)||(LA71_0>=FOR && LA71_0<=IF)||(LA71_0>=NEW && LA71_0<=WITH)||LA71_0==CONST||LA71_0==LBRACE||LA71_0==LPAREN||LA71_0==LBRACK||LA71_0==SEMIC||(LA71_0>=ADD && LA71_0<=SUB)||(LA71_0>=INC && LA71_0<=DEC)||(LA71_0>=NOT && LA71_0<=INV)||(LA71_0>=Identifier && LA71_0<=StringLiteral)||LA71_0==RegularExpressionLiteral||(LA71_0>=DecimalLiteral && LA71_0<=HexIntegerLiteral)) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // ES3.g:1465:20: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_defaultClause5638);
            	    statement252=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement252.getTree());

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "defaultClause"

    public static class labelledStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "labelledStatement"
    // ES3.g:1472:1: labelledStatement : Identifier COLON statement -> ^( LABELLED Identifier statement ) ;
    public final ES3Parser.labelledStatement_return labelledStatement() throws RecognitionException {
        ES3Parser.labelledStatement_return retval = new ES3Parser.labelledStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Identifier253=null;
        Token COLON254=null;
        ES3Parser.statement_return statement255 = null;


        Object Identifier253_tree=null;
        Object COLON254_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // ES3.g:1473:2: ( Identifier COLON statement -> ^( LABELLED Identifier statement ) )
            // ES3.g:1473:4: Identifier COLON statement
            {
            Identifier253=(Token)match(input,Identifier,FOLLOW_Identifier_in_labelledStatement5655);  
            stream_Identifier.add(Identifier253);

            COLON254=(Token)match(input,COLON,FOLLOW_COLON_in_labelledStatement5657);  
            stream_COLON.add(COLON254);

            pushFollow(FOLLOW_statement_in_labelledStatement5659);
            statement255=statement();

            state._fsp--;

            stream_statement.add(statement255.getTree());


            // AST REWRITE
            // elements: statement, Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1474:2: -> ^( LABELLED Identifier statement )
            {
                // ES3.g:1474:5: ^( LABELLED Identifier statement )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LABELLED, "LABELLED"), root_1);

                adaptor.addChild(root_1, stream_Identifier.nextNode());
                adaptor.addChild(root_1, stream_statement.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "labelledStatement"

    public static class throwStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "throwStatement"
    // ES3.g:1496:1: throwStatement : THROW expression semic ;
    public final ES3Parser.throwStatement_return throwStatement() throws RecognitionException {
        ES3Parser.throwStatement_return retval = new ES3Parser.throwStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token THROW256=null;
        ES3Parser.expression_return expression257 = null;

        ES3Parser.semic_return semic258 = null;


        Object THROW256_tree=null;

        try {
            // ES3.g:1497:2: ( THROW expression semic )
            // ES3.g:1497:4: THROW expression semic
            {
            root_0 = (Object)adaptor.nil();

            THROW256=(Token)match(input,THROW,FOLLOW_THROW_in_throwStatement5690); 
            THROW256_tree = (Object)adaptor.create(THROW256);
            root_0 = (Object)adaptor.becomeRoot(THROW256_tree, root_0);

             promoteEOL(null); 
            pushFollow(FOLLOW_expression_in_throwStatement5695);
            expression257=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression257.getTree());
            pushFollow(FOLLOW_semic_in_throwStatement5697);
            semic258=semic();

            state._fsp--;


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "throwStatement"

    public static class tryStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tryStatement"
    // ES3.g:1504:1: tryStatement : TRY block ( catchClause ( finallyClause )? | finallyClause ) ;
    public final ES3Parser.tryStatement_return tryStatement() throws RecognitionException {
        ES3Parser.tryStatement_return retval = new ES3Parser.tryStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TRY259=null;
        ES3Parser.block_return block260 = null;

        ES3Parser.catchClause_return catchClause261 = null;

        ES3Parser.finallyClause_return finallyClause262 = null;

        ES3Parser.finallyClause_return finallyClause263 = null;


        Object TRY259_tree=null;

        try {
            // ES3.g:1505:2: ( TRY block ( catchClause ( finallyClause )? | finallyClause ) )
            // ES3.g:1505:4: TRY block ( catchClause ( finallyClause )? | finallyClause )
            {
            root_0 = (Object)adaptor.nil();

            TRY259=(Token)match(input,TRY,FOLLOW_TRY_in_tryStatement5714); 
            TRY259_tree = (Object)adaptor.create(TRY259);
            root_0 = (Object)adaptor.becomeRoot(TRY259_tree, root_0);

            pushFollow(FOLLOW_block_in_tryStatement5717);
            block260=block();

            state._fsp--;

            adaptor.addChild(root_0, block260.getTree());
            // ES3.g:1505:15: ( catchClause ( finallyClause )? | finallyClause )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==CATCH) ) {
                alt73=1;
            }
            else if ( (LA73_0==FINALLY) ) {
                alt73=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ES3.g:1505:17: catchClause ( finallyClause )?
                    {
                    pushFollow(FOLLOW_catchClause_in_tryStatement5721);
                    catchClause261=catchClause();

                    state._fsp--;

                    adaptor.addChild(root_0, catchClause261.getTree());
                    // ES3.g:1505:29: ( finallyClause )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==FINALLY) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // ES3.g:1505:29: finallyClause
                            {
                            pushFollow(FOLLOW_finallyClause_in_tryStatement5723);
                            finallyClause262=finallyClause();

                            state._fsp--;

                            adaptor.addChild(root_0, finallyClause262.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ES3.g:1505:46: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_tryStatement5728);
                    finallyClause263=finallyClause();

                    state._fsp--;

                    adaptor.addChild(root_0, finallyClause263.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tryStatement"

    public static class catchClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "catchClause"
    // ES3.g:1508:1: catchClause : CATCH LPAREN Identifier RPAREN block ;
    public final ES3Parser.catchClause_return catchClause() throws RecognitionException {
        ES3Parser.catchClause_return retval = new ES3Parser.catchClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CATCH264=null;
        Token LPAREN265=null;
        Token Identifier266=null;
        Token RPAREN267=null;
        ES3Parser.block_return block268 = null;


        Object CATCH264_tree=null;
        Object LPAREN265_tree=null;
        Object Identifier266_tree=null;
        Object RPAREN267_tree=null;

        try {
            // ES3.g:1509:2: ( CATCH LPAREN Identifier RPAREN block )
            // ES3.g:1509:4: CATCH LPAREN Identifier RPAREN block
            {
            root_0 = (Object)adaptor.nil();

            CATCH264=(Token)match(input,CATCH,FOLLOW_CATCH_in_catchClause5742); 
            CATCH264_tree = (Object)adaptor.create(CATCH264);
            root_0 = (Object)adaptor.becomeRoot(CATCH264_tree, root_0);

            LPAREN265=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_catchClause5745); 
            Identifier266=(Token)match(input,Identifier,FOLLOW_Identifier_in_catchClause5748); 
            Identifier266_tree = (Object)adaptor.create(Identifier266);
            adaptor.addChild(root_0, Identifier266_tree);

            RPAREN267=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_catchClause5750); 
            pushFollow(FOLLOW_block_in_catchClause5753);
            block268=block();

            state._fsp--;

            adaptor.addChild(root_0, block268.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "catchClause"

    public static class finallyClause_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "finallyClause"
    // ES3.g:1512:1: finallyClause : FINALLY block ;
    public final ES3Parser.finallyClause_return finallyClause() throws RecognitionException {
        ES3Parser.finallyClause_return retval = new ES3Parser.finallyClause_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token FINALLY269=null;
        ES3Parser.block_return block270 = null;


        Object FINALLY269_tree=null;

        try {
            // ES3.g:1513:2: ( FINALLY block )
            // ES3.g:1513:4: FINALLY block
            {
            root_0 = (Object)adaptor.nil();

            FINALLY269=(Token)match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause5765); 
            FINALLY269_tree = (Object)adaptor.create(FINALLY269);
            root_0 = (Object)adaptor.becomeRoot(FINALLY269_tree, root_0);

            pushFollow(FOLLOW_block_in_finallyClause5768);
            block270=block();

            state._fsp--;

            adaptor.addChild(root_0, block270.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "finallyClause"

    public static class functionDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionDeclaration"
    // ES3.g:1526:1: functionDeclaration : FUNCTION name= Identifier formalParameterList functionBody -> ^( FUNCTION $name formalParameterList functionBody ) ;
    public final ES3Parser.functionDeclaration_return functionDeclaration() throws RecognitionException {
        ES3Parser.functionDeclaration_return retval = new ES3Parser.functionDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token FUNCTION271=null;
        ES3Parser.formalParameterList_return formalParameterList272 = null;

        ES3Parser.functionBody_return functionBody273 = null;


        Object name_tree=null;
        Object FUNCTION271_tree=null;
        RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_functionBody=new RewriteRuleSubtreeStream(adaptor,"rule functionBody");
        RewriteRuleSubtreeStream stream_formalParameterList=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterList");
        try {
            // ES3.g:1527:2: ( FUNCTION name= Identifier formalParameterList functionBody -> ^( FUNCTION $name formalParameterList functionBody ) )
            // ES3.g:1527:4: FUNCTION name= Identifier formalParameterList functionBody
            {
            FUNCTION271=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_functionDeclaration5789);  
            stream_FUNCTION.add(FUNCTION271);

            name=(Token)match(input,Identifier,FOLLOW_Identifier_in_functionDeclaration5793);  
            stream_Identifier.add(name);

            pushFollow(FOLLOW_formalParameterList_in_functionDeclaration5795);
            formalParameterList272=formalParameterList();

            state._fsp--;

            stream_formalParameterList.add(formalParameterList272.getTree());
            pushFollow(FOLLOW_functionBody_in_functionDeclaration5797);
            functionBody273=functionBody();

            state._fsp--;

            stream_functionBody.add(functionBody273.getTree());


            // AST REWRITE
            // elements: FUNCTION, name, formalParameterList, functionBody
            // token labels: name
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1528:2: -> ^( FUNCTION $name formalParameterList functionBody )
            {
                // ES3.g:1528:5: ^( FUNCTION $name formalParameterList functionBody )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_FUNCTION.nextNode(), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                adaptor.addChild(root_1, stream_formalParameterList.nextTree());
                adaptor.addChild(root_1, stream_functionBody.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionDeclaration"

    public static class functionExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionExpression"
    // ES3.g:1531:1: functionExpression : FUNCTION (name= Identifier )? formalParameterList functionBody -> ^( FUNCTION ( $name)? formalParameterList functionBody ) ;
    public final ES3Parser.functionExpression_return functionExpression() throws RecognitionException {
        ES3Parser.functionExpression_return retval = new ES3Parser.functionExpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token FUNCTION274=null;
        ES3Parser.formalParameterList_return formalParameterList275 = null;

        ES3Parser.functionBody_return functionBody276 = null;


        Object name_tree=null;
        Object FUNCTION274_tree=null;
        RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_functionBody=new RewriteRuleSubtreeStream(adaptor,"rule functionBody");
        RewriteRuleSubtreeStream stream_formalParameterList=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterList");
        try {
            // ES3.g:1532:2: ( FUNCTION (name= Identifier )? formalParameterList functionBody -> ^( FUNCTION ( $name)? formalParameterList functionBody ) )
            // ES3.g:1532:4: FUNCTION (name= Identifier )? formalParameterList functionBody
            {
            FUNCTION274=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_functionExpression5824);  
            stream_FUNCTION.add(FUNCTION274);

            // ES3.g:1532:17: (name= Identifier )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==Identifier) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ES3.g:1532:17: name= Identifier
                    {
                    name=(Token)match(input,Identifier,FOLLOW_Identifier_in_functionExpression5828);  
                    stream_Identifier.add(name);


                    }
                    break;

            }

            pushFollow(FOLLOW_formalParameterList_in_functionExpression5831);
            formalParameterList275=formalParameterList();

            state._fsp--;

            stream_formalParameterList.add(formalParameterList275.getTree());
            pushFollow(FOLLOW_functionBody_in_functionExpression5833);
            functionBody276=functionBody();

            state._fsp--;

            stream_functionBody.add(functionBody276.getTree());


            // AST REWRITE
            // elements: FUNCTION, name, formalParameterList, functionBody
            // token labels: name
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1533:2: -> ^( FUNCTION ( $name)? formalParameterList functionBody )
            {
                // ES3.g:1533:5: ^( FUNCTION ( $name)? formalParameterList functionBody )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_FUNCTION.nextNode(), root_1);

                // ES3.g:1533:17: ( $name)?
                if ( stream_name.hasNext() ) {
                    adaptor.addChild(root_1, stream_name.nextNode());

                }
                stream_name.reset();
                adaptor.addChild(root_1, stream_formalParameterList.nextTree());
                adaptor.addChild(root_1, stream_functionBody.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionExpression"

    public static class formalParameterList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "formalParameterList"
    // ES3.g:1536:1: formalParameterList : LPAREN (args+= Identifier ( COMMA args+= Identifier )* )? RPAREN -> ^( ARGS ( $args)* ) ;
    public final ES3Parser.formalParameterList_return formalParameterList() throws RecognitionException {
        ES3Parser.formalParameterList_return retval = new ES3Parser.formalParameterList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN277=null;
        Token COMMA278=null;
        Token RPAREN279=null;
        Token args=null;
        List list_args=null;

        Object LPAREN277_tree=null;
        Object COMMA278_tree=null;
        Object RPAREN279_tree=null;
        Object args_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");

        try {
            // ES3.g:1537:2: ( LPAREN (args+= Identifier ( COMMA args+= Identifier )* )? RPAREN -> ^( ARGS ( $args)* ) )
            // ES3.g:1537:4: LPAREN (args+= Identifier ( COMMA args+= Identifier )* )? RPAREN
            {
            LPAREN277=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_formalParameterList5861);  
            stream_LPAREN.add(LPAREN277);

            // ES3.g:1537:11: (args+= Identifier ( COMMA args+= Identifier )* )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==Identifier) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ES3.g:1537:13: args+= Identifier ( COMMA args+= Identifier )*
                    {
                    args=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterList5867);  
                    stream_Identifier.add(args);

                    if (list_args==null) list_args=new ArrayList();
                    list_args.add(args);

                    // ES3.g:1537:30: ( COMMA args+= Identifier )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==COMMA) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // ES3.g:1537:32: COMMA args+= Identifier
                    	    {
                    	    COMMA278=(Token)match(input,COMMA,FOLLOW_COMMA_in_formalParameterList5871);  
                    	    stream_COMMA.add(COMMA278);

                    	    args=(Token)match(input,Identifier,FOLLOW_Identifier_in_formalParameterList5875);  
                    	    stream_Identifier.add(args);

                    	    if (list_args==null) list_args=new ArrayList();
                    	    list_args.add(args);


                    	    }
                    	    break;

                    	default :
                    	    break loop75;
                        }
                    } while (true);


                    }
                    break;

            }

            RPAREN279=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_formalParameterList5883);  
            stream_RPAREN.add(RPAREN279);



            // AST REWRITE
            // elements: args
            // token labels: 
            // rule labels: retval
            // token list labels: args
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_args=new RewriteRuleTokenStream(adaptor,"token args", list_args);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1538:2: -> ^( ARGS ( $args)* )
            {
                // ES3.g:1538:5: ^( ARGS ( $args)* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGS, "ARGS"), root_1);

                // ES3.g:1538:13: ( $args)*
                while ( stream_args.hasNext() ) {
                    adaptor.addChild(root_1, stream_args.nextNode());

                }
                stream_args.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "formalParameterList"

    public static class functionBody_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionBody"
    // ES3.g:1541:1: functionBody : lb= LBRACE ( sourceElement )* RBRACE -> ^( FUNBODY[$lb, \"FUNBODY\"] ( sourceElement )* ) ;
    public final ES3Parser.functionBody_return functionBody() throws RecognitionException {
        ES3Parser.functionBody_return retval = new ES3Parser.functionBody_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token lb=null;
        Token RBRACE281=null;
        ES3Parser.sourceElement_return sourceElement280 = null;


        Object lb_tree=null;
        Object RBRACE281_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_sourceElement=new RewriteRuleSubtreeStream(adaptor,"rule sourceElement");
        try {
            // ES3.g:1542:2: (lb= LBRACE ( sourceElement )* RBRACE -> ^( FUNBODY[$lb, \"FUNBODY\"] ( sourceElement )* ) )
            // ES3.g:1542:4: lb= LBRACE ( sourceElement )* RBRACE
            {
            lb=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_functionBody5909);  
            stream_LBRACE.add(lb);

            // ES3.g:1542:14: ( sourceElement )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( ((LA77_0>=NULL && LA77_0<=BREAK)||LA77_0==CONTINUE||(LA77_0>=DELETE && LA77_0<=DO)||(LA77_0>=FOR && LA77_0<=IF)||(LA77_0>=NEW && LA77_0<=WITH)||LA77_0==CONST||LA77_0==LBRACE||LA77_0==LPAREN||LA77_0==LBRACK||LA77_0==SEMIC||(LA77_0>=ADD && LA77_0<=SUB)||(LA77_0>=INC && LA77_0<=DEC)||(LA77_0>=NOT && LA77_0<=INV)||(LA77_0>=Identifier && LA77_0<=StringLiteral)||LA77_0==RegularExpressionLiteral||(LA77_0>=DecimalLiteral && LA77_0<=HexIntegerLiteral)) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ES3.g:1542:14: sourceElement
            	    {
            	    pushFollow(FOLLOW_sourceElement_in_functionBody5911);
            	    sourceElement280=sourceElement();

            	    state._fsp--;

            	    stream_sourceElement.add(sourceElement280.getTree());

            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

            RBRACE281=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_functionBody5914);  
            stream_RBRACE.add(RBRACE281);



            // AST REWRITE
            // elements: sourceElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1543:2: -> ^( FUNBODY[$lb, \"FUNBODY\"] ( sourceElement )* )
            {
                // ES3.g:1543:5: ^( FUNBODY[$lb, \"FUNBODY\"] ( sourceElement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNBODY, lb, "FUNBODY"), root_1);

                // ES3.g:1543:32: ( sourceElement )*
                while ( stream_sourceElement.hasNext() ) {
                    adaptor.addChild(root_1, stream_sourceElement.nextTree());

                }
                stream_sourceElement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionBody"

    public static class program_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // ES3.g:1550:1: program : (se= sourceElement )* -> ^( ROOT_ID ( sourceElement )* ) ;
    public final ES3Parser.program_return program() throws RecognitionException {
        ES3Parser.program_return retval = new ES3Parser.program_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ES3Parser.sourceElement_return se = null;


        RewriteRuleSubtreeStream stream_sourceElement=new RewriteRuleSubtreeStream(adaptor,"rule sourceElement");
        try {
            // ES3.g:1551:2: ( (se= sourceElement )* -> ^( ROOT_ID ( sourceElement )* ) )
            // ES3.g:1551:4: (se= sourceElement )*
            {
            // ES3.g:1551:7: (se= sourceElement )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( ((LA78_0>=NULL && LA78_0<=BREAK)||LA78_0==CONTINUE||(LA78_0>=DELETE && LA78_0<=DO)||(LA78_0>=FOR && LA78_0<=IF)||(LA78_0>=NEW && LA78_0<=WITH)||LA78_0==CONST||LA78_0==LBRACE||LA78_0==LPAREN||LA78_0==LBRACK||LA78_0==SEMIC||(LA78_0>=ADD && LA78_0<=SUB)||(LA78_0>=INC && LA78_0<=DEC)||(LA78_0>=NOT && LA78_0<=INV)||(LA78_0>=Identifier && LA78_0<=StringLiteral)||LA78_0==RegularExpressionLiteral||(LA78_0>=DecimalLiteral && LA78_0<=HexIntegerLiteral)) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // ES3.g:1551:7: se= sourceElement
            	    {
            	    pushFollow(FOLLOW_sourceElement_in_program5947);
            	    se=sourceElement();

            	    state._fsp--;

            	    stream_sourceElement.add(se.getTree());

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);



            // AST REWRITE
            // elements: sourceElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 1552:2: -> ^( ROOT_ID ( sourceElement )* )
            {
                // ES3.g:1552:5: ^( ROOT_ID ( sourceElement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROOT_ID, "ROOT_ID"), root_1);

                // ES3.g:1552:15: ( sourceElement )*
                while ( stream_sourceElement.hasNext() ) {
                    adaptor.addChild(root_1, stream_sourceElement.nextTree());

                }
                stream_sourceElement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class sourceElement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sourceElement"
    // ES3.g:1560:1: sourceElement options {k=1; } : ({...}? functionDeclaration | statement );
    public final ES3Parser.sourceElement_return sourceElement() throws RecognitionException {
        ES3Parser.sourceElement_return retval = new ES3Parser.sourceElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        ES3Parser.functionDeclaration_return functionDeclaration282 = null;

        ES3Parser.statement_return statement283 = null;



        try {
            // ES3.g:1565:2: ({...}? functionDeclaration | statement )
            int alt79=2;
            alt79 = dfa79.predict(input);
            switch (alt79) {
                case 1 :
                    // ES3.g:1565:4: {...}? functionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(( input.LA(1) == FUNCTION )) ) {
                        throw new FailedPredicateException(input, "sourceElement", " input.LA(1) == FUNCTION ");
                    }
                    pushFollow(FOLLOW_functionDeclaration_in_sourceElement5986);
                    functionDeclaration282=functionDeclaration();

                    state._fsp--;

                    adaptor.addChild(root_0, functionDeclaration282.getTree());

                    }
                    break;
                case 2 :
                    // ES3.g:1566:4: statement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_sourceElement5991);
                    statement283=statement();

                    state._fsp--;

                    adaptor.addChild(root_0, statement283.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sourceElement"

    // Delegated rules


    protected DFA45 dfa45 = new DFA45(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA79 dfa79 = new DFA79(this);
    static final String DFA45_eotS =
        "\45\uffff";
    static final String DFA45_eofS =
        "\45\uffff";
    static final String DFA45_minS =
        "\1\4\1\0\43\uffff";
    static final String DFA45_maxS =
        "\1\u00a1\1\0\43\uffff";
    static final String DFA45_acceptS =
        "\2\uffff\1\2\41\uffff\1\1";
    static final String DFA45_specialS =
        "\1\uffff\1\0\43\uffff}>";
    static final String[] DFA45_transitionS = {
            "\4\2\2\uffff\1\2\1\uffff\2\2\2\uffff\3\2\2\uffff\13\2\6\uffff"+
            "\1\2\26\uffff\1\1\1\uffff\1\2\1\uffff\1\2\2\uffff\1\2\11\uffff"+
            "\2\2\2\uffff\2\2\6\uffff\2\2\70\uffff\2\2\5\uffff\1\2\3\uffff"+
            "\3\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "1189:1: statement options {k=1; } : ({...}? block | statementTail );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA45_1 = input.LA(1);

                         
                        int index45_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( input.LA(1) == LBRACE )) ) {s = 36;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index45_1);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 45, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA46_eotS =
        "\17\uffff";
    static final String DFA46_eofS =
        "\4\uffff\1\3\12\uffff";
    static final String DFA46_minS =
        "\1\4\3\uffff\1\23\12\uffff";
    static final String DFA46_maxS =
        "\1\u00a1\3\uffff\1\u0092\12\uffff";
    static final String DFA46_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\13\1\14"+
        "\1\15\1\12";
    static final String DFA46_specialS =
        "\17\uffff}>";
    static final String[] DFA46_transitionS = {
            "\3\3\1\10\2\uffff\1\7\1\uffff\1\3\1\6\2\uffff\1\6\1\3\1\5\2"+
            "\uffff\1\3\1\11\1\13\1\3\1\14\1\15\1\3\1\1\1\3\1\6\1\12\6\uffff"+
            "\1\1\26\uffff\1\3\1\uffff\1\3\1\uffff\1\3\2\uffff\1\2\11\uffff"+
            "\2\3\2\uffff\2\3\6\uffff\2\3\70\uffff\1\4\1\3\5\uffff\1\3\3"+
            "\uffff\3\3",
            "",
            "",
            "",
            "\2\3\51\uffff\2\3\1\uffff\1\3\1\uffff\27\3\2\uffff\3\3\1\16"+
            "\15\3\44\uffff\2\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "1198:1: statementTail : ( variableStatement | emptyStatement | expressionStatement | ifStatement | iterationStatement | continueStatement | breakStatement | returnStatement | withStatement | labelledStatement | switchStatement | throwStatement | tryStatement );";
        }
    }
    static final String DFA79_eotS =
        "\45\uffff";
    static final String DFA79_eofS =
        "\45\uffff";
    static final String DFA79_minS =
        "\1\4\1\0\43\uffff";
    static final String DFA79_maxS =
        "\1\u00a1\1\0\43\uffff";
    static final String DFA79_acceptS =
        "\2\uffff\1\2\41\uffff\1\1";
    static final String DFA79_specialS =
        "\1\uffff\1\0\43\uffff}>";
    static final String[] DFA79_transitionS = {
            "\4\2\2\uffff\1\2\1\uffff\2\2\2\uffff\1\2\1\1\1\2\2\uffff\13"+
            "\2\6\uffff\1\2\26\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff"+
            "\1\2\11\uffff\2\2\2\uffff\2\2\6\uffff\2\2\70\uffff\2\2\5\uffff"+
            "\1\2\3\uffff\3\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA79_eot = DFA.unpackEncodedString(DFA79_eotS);
    static final short[] DFA79_eof = DFA.unpackEncodedString(DFA79_eofS);
    static final char[] DFA79_min = DFA.unpackEncodedStringToUnsignedChars(DFA79_minS);
    static final char[] DFA79_max = DFA.unpackEncodedStringToUnsignedChars(DFA79_maxS);
    static final short[] DFA79_accept = DFA.unpackEncodedString(DFA79_acceptS);
    static final short[] DFA79_special = DFA.unpackEncodedString(DFA79_specialS);
    static final short[][] DFA79_transition;

    static {
        int numStates = DFA79_transitionS.length;
        DFA79_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA79_transition[i] = DFA.unpackEncodedString(DFA79_transitionS[i]);
        }
    }

    class DFA79 extends DFA {

        public DFA79(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 79;
            this.eot = DFA79_eot;
            this.eof = DFA79_eof;
            this.min = DFA79_min;
            this.max = DFA79_max;
            this.accept = DFA79_accept;
            this.special = DFA79_special;
            this.transition = DFA79_transition;
        }
        public String getDescription() {
            return "1560:1: sourceElement options {k=1; } : ({...}? functionDeclaration | statement );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA79_1 = input.LA(1);

                         
                        int index79_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( input.LA(1) == FUNCTION )) ) {s = 36;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index79_1);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 79, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_reservedWord_in_token1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_token1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_punctuator_in_token1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_token1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_token1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyword_in_reservedWord1773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_futureReservedWord_in_reservedWord1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_reservedWord1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanLiteral_in_reservedWord1788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_keyword0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_futureReservedWord0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_punctuator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_literal2459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanLiteral_in_literal2464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_literal2469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_literal2474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RegularExpressionLiteral_in_literal2479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_booleanLiteral0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_numericLiteral0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_primaryExpression3102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_primaryExpression3107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primaryExpression3112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayLiteral_in_primaryExpression3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_objectLiteral_in_primaryExpression3122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpression3129 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_primaryExpression3131 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpression3133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayLiteral3157 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC026L,0x0000000388300000L});
    public static final BitSet FOLLOW_arrayItem_in_arrayLiteral3161 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
    public static final BitSet FOLLOW_COMMA_in_arrayLiteral3165 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC026L,0x0000000388300000L});
    public static final BitSet FOLLOW_arrayItem_in_arrayLiteral3167 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
    public static final BitSet FOLLOW_RBRACK_in_arrayLiteral3175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentExpression_in_arrayItem3203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_objectLiteral3235 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000020L,0x0000000380300000L});
    public static final BitSet FOLLOW_nameValuePair_in_objectLiteral3239 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_COMMA_in_objectLiteral3243 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000380300000L});
    public static final BitSet FOLLOW_nameValuePair_in_objectLiteral3245 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_COMMA_in_objectLiteral3253 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RBRACE_in_objectLiteral3256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_propertyName_in_nameValuePair3281 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_COLON_in_nameValuePair3283 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_nameValuePair3285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getterOrSetterExpression_in_nameValuePair3302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_getterOrSetterExpression3316 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_Identifier_in_getterOrSetterExpression3320 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_formalParameterList_in_getterOrSetterExpression3322 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_functionBody_in_getterOrSetterExpression3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_propertyName3356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_propertyName3361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_numericLiteral_in_propertyName3366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpression_in_memberExpression3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionExpression_in_memberExpression3389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_newExpression_in_memberExpression3394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_newExpression3405 = new BitSet(new long[]{0xA000000001220070L,0x0000000000000002L,0x0000000388300000L});
    public static final BitSet FOLLOW_leftHandSideExpression_in_newExpression3408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arguments3422 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC003L,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_arguments3426 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000021L});
    public static final BitSet FOLLOW_COMMA_in_arguments3430 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_arguments3432 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000021L});
    public static final BitSet FOLLOW_RPAREN_in_arguments3440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memberExpression_in_leftHandSideExpression3469 = new BitSet(new long[]{0x8000000000000002L,0x000000000000000AL});
    public static final BitSet FOLLOW_arguments_in_leftHandSideExpression3485 = new BitSet(new long[]{0x8000000000000002L,0x000000000000000AL});
    public static final BitSet FOLLOW_LBRACK_in_leftHandSideExpression3505 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_leftHandSideExpression3509 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RBRACK_in_leftHandSideExpression3511 = new BitSet(new long[]{0x8000000000000002L,0x000000000000000AL});
    public static final BitSet FOLLOW_DOT_in_leftHandSideExpression3532 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_Identifier_in_leftHandSideExpression3534 = new BitSet(new long[]{0x8000000000000002L,0x000000000000000AL});
    public static final BitSet FOLLOW_leftHandSideExpression_in_postfixExpression3571 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_postfixOperator_in_postfixExpression3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INC_in_postfixOperator3595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_postfixOperator3604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpression3621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOperator_in_unaryExpression3626 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression3629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_unaryOperator3641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_unaryOperator3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPEOF_in_unaryOperator3651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INC_in_unaryOperator3656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_unaryOperator3661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ADD_in_unaryOperator3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUB_in_unaryOperator3677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INV_in_unaryOperator3684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryOperator3689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression3704 = new BitSet(new long[]{0x0000000000000002L,0x0000080000030000L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression3708 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression3723 = new BitSet(new long[]{0x0000000000000002L,0x0000080000030000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression3741 = new BitSet(new long[]{0x0000000000000002L,0x000000000000C000L});
    public static final BitSet FOLLOW_set_in_additiveExpression3745 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression3756 = new BitSet(new long[]{0x0000000000000002L,0x000000000000C000L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression3775 = new BitSet(new long[]{0x0000000000000002L,0x0000000000700000L});
    public static final BitSet FOLLOW_set_in_shiftExpression3779 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression3794 = new BitSet(new long[]{0x0000000000000002L,0x0000000000700000L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression3813 = new BitSet(new long[]{0x0000000000180002L,0x00000000000003C0L});
    public static final BitSet FOLLOW_set_in_relationalExpression3817 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression3844 = new BitSet(new long[]{0x0000000000180002L,0x00000000000003C0L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpressionNoIn3858 = new BitSet(new long[]{0x0000000000100002L,0x00000000000003C0L});
    public static final BitSet FOLLOW_set_in_relationalExpressionNoIn3862 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpressionNoIn3885 = new BitSet(new long[]{0x0000000000100002L,0x00000000000003C0L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression3904 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003C00L});
    public static final BitSet FOLLOW_set_in_equalityExpression3908 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression3927 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003C00L});
    public static final BitSet FOLLOW_relationalExpressionNoIn_in_equalityExpressionNoIn3941 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003C00L});
    public static final BitSet FOLLOW_set_in_equalityExpressionNoIn3945 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_relationalExpressionNoIn_in_equalityExpressionNoIn3964 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003C00L});
    public static final BitSet FOLLOW_equalityExpression_in_bitwiseANDExpression3984 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_AND_in_bitwiseANDExpression3988 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_equalityExpression_in_bitwiseANDExpression3991 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_equalityExpressionNoIn_in_bitwiseANDExpressionNoIn4005 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_AND_in_bitwiseANDExpressionNoIn4009 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_equalityExpressionNoIn_in_bitwiseANDExpressionNoIn4012 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_bitwiseANDExpression_in_bitwiseXORExpression4028 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_XOR_in_bitwiseXORExpression4032 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_bitwiseANDExpression_in_bitwiseXORExpression4035 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_bitwiseANDExpressionNoIn_in_bitwiseXORExpressionNoIn4051 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_XOR_in_bitwiseXORExpressionNoIn4055 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_bitwiseANDExpressionNoIn_in_bitwiseXORExpressionNoIn4058 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_bitwiseXORExpression_in_bitwiseORExpression4073 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_OR_in_bitwiseORExpression4077 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_bitwiseXORExpression_in_bitwiseORExpression4080 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_bitwiseXORExpressionNoIn_in_bitwiseORExpressionNoIn4095 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_OR_in_bitwiseORExpressionNoIn4099 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_bitwiseXORExpressionNoIn_in_bitwiseORExpressionNoIn4102 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_bitwiseORExpression_in_logicalANDExpression4121 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_LAND_in_logicalANDExpression4125 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_bitwiseORExpression_in_logicalANDExpression4128 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_bitwiseORExpressionNoIn_in_logicalANDExpressionNoIn4142 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_LAND_in_logicalANDExpressionNoIn4146 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_bitwiseORExpressionNoIn_in_logicalANDExpressionNoIn4149 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_logicalANDExpression_in_logicalORExpression4164 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_LOR_in_logicalORExpression4168 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_logicalANDExpression_in_logicalORExpression4171 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_logicalANDExpressionNoIn_in_logicalORExpressionNoIn4186 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_LOR_in_logicalORExpressionNoIn4190 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_logicalANDExpressionNoIn_in_logicalORExpressionNoIn4193 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_logicalORExpression_in_conditionalExpression4212 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_QUE_in_conditionalExpression4216 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_conditionalExpression4219 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_COLON_in_conditionalExpression4221 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_conditionalExpression4224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalORExpressionNoIn_in_conditionalExpressionNoIn4238 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_QUE_in_conditionalExpressionNoIn4242 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_conditionalExpressionNoIn4245 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_COLON_in_conditionalExpressionNoIn4247 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_conditionalExpressionNoIn4250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_assignmentExpression4278 = new BitSet(new long[]{0x0000000000000002L,0x000017FF00000000L});
    public static final BitSet FOLLOW_assignmentOperator_in_assignmentExpression4285 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_assignmentExpression4288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_assignmentOperator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpressionNoIn_in_assignmentExpressionNoIn4365 = new BitSet(new long[]{0x0000000000000002L,0x000017FF00000000L});
    public static final BitSet FOLLOW_assignmentOperator_in_assignmentExpressionNoIn4372 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_assignmentExpressionNoIn4375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentExpression_in_expression4397 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_COMMA_in_expression4401 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_expression4405 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_expressionNoIn4442 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_COMMA_in_expressionNoIn4446 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_expressionNoIn4450 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_SEMIC_in_semic4501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EOF_in_semic4506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RBRACE_in_semic4511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EOL_in_semic4518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MultiLineComment_in_semic4522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_statement4551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statementTail_in_statement4556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableStatement_in_statementTail4568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emptyStatement_in_statementTail4574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionStatement_in_statementTail4580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statementTail4586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iterationStatement_in_statementTail4592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statementTail4598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statementTail4604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statementTail4610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_withStatement_in_statementTail4616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelledStatement_in_statementTail4622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statementTail4628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statementTail4634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tryStatement_in_statementTail4640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_block4656 = new BitSet(new long[]{0xE0000040FFE734F0L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_block4658 = new BitSet(new long[]{0xE0000040FFE734F0L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_RBRACE_in_block4661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_variableStatement4690 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_variableDeclaration_in_variableStatement4692 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000030L,0x0000000000060000L});
    public static final BitSet FOLLOW_COMMA_in_variableStatement4696 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_variableDeclaration_in_variableStatement4698 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000030L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_variableStatement4703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_variableStatement4719 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_variableDeclaration_in_variableStatement4721 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000030L,0x0000000000060000L});
    public static final BitSet FOLLOW_COMMA_in_variableStatement4725 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_variableDeclaration_in_variableStatement4727 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000030L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_variableStatement4732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_variableDeclaration4754 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_ASSIGN_in_variableDeclaration4758 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpression_in_variableDeclaration4761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_variableDeclarationNoIn4776 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_ASSIGN_in_variableDeclarationNoIn4780 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_assignmentExpressionNoIn_in_variableDeclarationNoIn4783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMIC_in_emptyStatement4802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expressionStatement4821 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000030L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_expressionStatement4823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement4875 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_ifStatement4877 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_ifStatement4879 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RPAREN_in_ifStatement4881 = new BitSet(new long[]{0xA0000040FFE734F0L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_ifStatement4885 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ELSE_in_ifStatement4893 = new BitSet(new long[]{0xA0000040FFE734F0L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_ifStatement4897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doStatement_in_iterationStatement4968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_iterationStatement4973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_iterationStatement4978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_in_doStatement4990 = new BitSet(new long[]{0xA0000040FFE734F0L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_doStatement4992 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_WHILE_in_doStatement4994 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_doStatement4996 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_doStatement4998 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RPAREN_in_doStatement5000 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000030L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_doStatement5002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_whileStatement5027 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_whileStatement5030 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_whileStatement5033 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RPAREN_in_whileStatement5035 = new BitSet(new long[]{0xA0000040FFE734F0L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_whileStatement5038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forStatement5051 = new BitSet(new long[]{0x8000000100000000L});
    public static final BitSet FOLLOW_EACH_in_forStatement5055 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_forStatement5060 = new BitSet(new long[]{0xA000000039221070L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_forControl_in_forStatement5063 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RPAREN_in_forStatement5065 = new BitSet(new long[]{0xA0000040FFE734F0L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_forStatement5068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forControlVar_in_forControl5079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forControlExpression_in_forControl5084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forControlSemic_in_forControl5089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_forControlVar5100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_variableDeclarationNoIn_in_forControlVar5102 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000030L});
    public static final BitSet FOLLOW_IN_in_forControlVar5114 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlVar5116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_forControlVar5162 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_variableDeclarationNoIn_in_forControlVar5164 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_SEMIC_in_forControlVar5169 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlVar5173 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_SEMIC_in_forControlVar5176 = new BitSet(new long[]{0xA000000029221072L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlVar5180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionNoIn_in_forControlExpression5246 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000010L});
    public static final BitSet FOLLOW_IN_in_forControlExpression5261 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlExpression5265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMIC_in_forControlExpression5311 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlExpression5315 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_SEMIC_in_forControlExpression5318 = new BitSet(new long[]{0xA000000029221072L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlExpression5322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMIC_in_forControlSemic5381 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlSemic5385 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_SEMIC_in_forControlSemic5388 = new BitSet(new long[]{0xA000000029221072L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_forControlSemic5392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_continueStatement5446 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000030L,0x0000000000160000L});
    public static final BitSet FOLLOW_Identifier_in_continueStatement5451 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000030L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_continueStatement5454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_breakStatement5473 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000030L,0x0000000000160000L});
    public static final BitSet FOLLOW_Identifier_in_breakStatement5478 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000030L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_breakStatement5481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_returnStatement5500 = new BitSet(new long[]{0xE000000029221070L,0x000000000C0CC032L,0x0000000388360000L});
    public static final BitSet FOLLOW_expression_in_returnStatement5505 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000030L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_returnStatement5508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_withStatement5525 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_withStatement5528 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_withStatement5531 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RPAREN_in_withStatement5533 = new BitSet(new long[]{0xA0000040FFE734F0L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_withStatement5536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWITCH_in_switchStatement5557 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_switchStatement5559 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_switchStatement5561 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RPAREN_in_switchStatement5563 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_LBRACE_in_switchStatement5565 = new BitSet(new long[]{0x4000000000000900L});
    public static final BitSet FOLLOW_defaultClause_in_switchStatement5572 = new BitSet(new long[]{0x4000000000000900L});
    public static final BitSet FOLLOW_caseClause_in_switchStatement5578 = new BitSet(new long[]{0x4000000000000900L});
    public static final BitSet FOLLOW_RBRACE_in_switchStatement5583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_caseClause5611 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_caseClause5614 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_COLON_in_caseClause5616 = new BitSet(new long[]{0xA0000040FFE734F2L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_caseClause5619 = new BitSet(new long[]{0xA0000040FFE734F2L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_DEFAULT_in_defaultClause5632 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_COLON_in_defaultClause5635 = new BitSet(new long[]{0xA0000040FFE734F2L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_defaultClause5638 = new BitSet(new long[]{0xA0000040FFE734F2L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_Identifier_in_labelledStatement5655 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_COLON_in_labelledStatement5657 = new BitSet(new long[]{0xA0000040FFE734F0L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_statement_in_labelledStatement5659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROW_in_throwStatement5690 = new BitSet(new long[]{0xA000000029221070L,0x000000000C0CC002L,0x0000000388300000L});
    public static final BitSet FOLLOW_expression_in_throwStatement5695 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000030L,0x0000000000060000L});
    public static final BitSet FOLLOW_semic_in_throwStatement5697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRY_in_tryStatement5714 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_block_in_tryStatement5717 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_catchClause_in_tryStatement5721 = new BitSet(new long[]{0x0000000000008202L});
    public static final BitSet FOLLOW_finallyClause_in_tryStatement5723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finallyClause_in_tryStatement5728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCH_in_catchClause5742 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_catchClause5745 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_Identifier_in_catchClause5748 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RPAREN_in_catchClause5750 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_block_in_catchClause5753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause5765 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_block_in_finallyClause5768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_functionDeclaration5789 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_Identifier_in_functionDeclaration5793 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_formalParameterList_in_functionDeclaration5795 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_functionBody_in_functionDeclaration5797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_functionExpression5824 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_Identifier_in_functionExpression5828 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_formalParameterList_in_functionExpression5831 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_functionBody_in_functionExpression5833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_formalParameterList5861 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000000100000L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterList5867 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000021L});
    public static final BitSet FOLLOW_COMMA_in_formalParameterList5871 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_Identifier_in_formalParameterList5875 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000021L});
    public static final BitSet FOLLOW_RPAREN_in_formalParameterList5883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_functionBody5909 = new BitSet(new long[]{0xE0000040FFE734F0L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_sourceElement_in_functionBody5911 = new BitSet(new long[]{0xE0000040FFE734F0L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_RBRACE_in_functionBody5914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sourceElement_in_program5947 = new BitSet(new long[]{0xA0000040FFE734F2L,0x000000000C0CC012L,0x0000000388300000L});
    public static final BitSet FOLLOW_functionDeclaration_in_sourceElement5986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_sourceElement5991 = new BitSet(new long[]{0x0000000000000002L});

}
