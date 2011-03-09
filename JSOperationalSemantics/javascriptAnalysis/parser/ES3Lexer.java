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
// $ANTLR 3.1.1 ES3.g 2010-11-01 00:27:48
package javascriptAnalysis.parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ES3Lexer extends Lexer {
	public static final int PACKAGE = 53;
	public static final int FUNCTION = 17;
	public static final int LOR = 93;
	public static final int VT = 134;
	public static final int SHR = 85;
	public static final int RegularExpressionChar = 170;
	public static final int LT = 70;
	public static final int ROOT_ID = 129;
	public static final int WHILE = 30;
	public static final int MOD = 81;
	public static final int SHL = 84;
	public static final int CONST = 38;
	public static final int BackslashSequence = 168;
	public static final int LS = 142;
	public static final int CASE = 8;
	public static final int NEW = 21;
	public static final int CHAR = 36;
	public static final int DO = 13;
	public static final int DQUOTE = 131;
	public static final int NOT = 90;
	public static final int DecimalDigit = 152;
	public static final int BYFIELD = 112;
	public static final int EOF = -1;
	public static final int BREAK = 7;
	public static final int CEXPR = 115;
	public static final int DIVASS = 108;
	public static final int Identifier = 148;
	public static final int BYINDEX = 113;
	public static final int INC = 82;
	public static final int RPAREN = 64;
	public static final int FINAL = 44;
	public static final int FORSTEP = 118;
	public static final int IMPORT = 48;
	public static final int EOL = 145;
	public static final int POS = 127;
	public static final int OctalDigit = 156;
	public static final int RETURN = 22;
	public static final int THIS = 24;
	public static final int DOUBLE = 40;
	public static final int ARGS = 109;
	public static final int ExponentPart = 157;
	public static final int WhiteSpace = 139;
	public static final int VAR = 28;
	public static final int EXPORT = 42;
	public static final int VOID = 29;
	public static final int LABELLED = 120;
	public static final int EACH = 32;
	public static final int SUPER = 56;
	public static final int GOTO = 46;
	public static final int EQ = 74;
	public static final int XORASS = 106;
	public static final int ADDASS = 97;
	public static final int ARRAY = 110;
	public static final int SHU = 86;
	public static final int RBRACK = 66;
	public static final int FUNBODY = 128;
	public static final int RBRACE = 62;
	public static final int STATIC = 55;
	public static final int INV = 91;
	public static final int SWITCH = 23;
	public static final int NULL = 4;
	public static final int ELSE = 14;
	public static final int NATIVE = 52;
	public static final int THROWS = 58;
	public static final int INT = 49;
	public static final int DELETE = 12;
	public static final int MUL = 80;
	public static final int IdentifierStartASCII = 151;
	public static final int TRY = 26;
	public static final int FF = 135;
	public static final int SHLASS = 101;
	public static final int OctalEscapeSequence = 164;
	public static final int USP = 138;
	public static final int RegularExpressionFirstChar = 169;
	public static final int ANDASS = 104;
	public static final int TYPEOF = 27;
	public static final int IdentifierNameASCIIStart = 154;
	public static final int QUE = 94;
	public static final int OR = 88;
	public static final int DEBUGGER = 39;
	public static final int GT = 71;
	public static final int PDEC = 125;
	public static final int CALL = 114;
	public static final int CharacterEscapeSequence = 162;
	public static final int CATCH = 9;
	public static final int FALSE = 6;
	public static final int EscapeSequence = 167;
	public static final int LAND = 92;
	public static final int THROW = 25;
	public static final int MULASS = 99;
	public static final int PINC = 126;
	public static final int DEC = 83;
	public static final int OctalIntegerLiteral = 160;
	public static final int CLASS = 37;
	public static final int LBRACK = 65;
	public static final int ORASS = 105;
	public static final int HexEscapeSequence = 165;
	public static final int NAMEDVALUE = 121;
	public static final int SingleLineComment = 147;
	public static final int GTE = 73;
	public static final int LBRACE = 61;
	public static final int FOR = 16;
	public static final int SUB = 79;
	public static final int RegularExpressionLiteral = 155;
	public static final int FLOAT = 45;
	public static final int ABSTRACT = 33;
	public static final int AND = 87;
	public static final int DecimalIntegerLiteral = 158;
	public static final int LTE = 72;
	public static final int HexDigit = 150;
	public static final int LPAREN = 63;
	public static final int IF = 18;
	public static final int SUBASS = 98;
	public static final int SYNCHRONIZED = 57;
	public static final int BOOLEAN = 34;
	public static final int EXPR = 116;
	public static final int IN = 19;
	public static final int IMPLEMENTS = 47;
	public static final int CONTINUE = 10;
	public static final int OBJECT = 123;
	public static final int COMMA = 69;
	public static final int TRANSIENT = 59;
	public static final int FORITER = 117;
	public static final int MODASS = 100;
	public static final int SHRASS = 102;
	public static final int PS = 143;
	public static final int DOT = 67;
	public static final int MultiLineComment = 146;
	public static final int IdentifierPart = 153;
	public static final int WITH = 31;
	public static final int ADD = 78;
	public static final int BYTE = 35;
	public static final int XOR = 89;
	public static final int ZeroToThree = 163;
	public static final int VOLATILE = 60;
	public static final int ITEM = 119;
	public static final int UnicodeEscapeSequence = 166;
	public static final int NSAME = 77;
	public static final int DEFAULT = 11;
	public static final int SHUASS = 103;
	public static final int TAB = 133;
	public static final int SHORT = 54;
	public static final int INSTANCEOF = 20;
	public static final int SQUOTE = 132;
	public static final int DecimalLiteral = 159;
	public static final int TRUE = 5;
	public static final int SAME = 76;
	public static final int COLON = 95;
	public static final int StringLiteral = 149;
	public static final int NEQ = 75;
	public static final int PAREXPR = 124;
	public static final int ENUM = 41;
	public static final int FINALLY = 15;
	public static final int NBSP = 137;
	public static final int HexIntegerLiteral = 161;
	public static final int SP = 136;
	public static final int BLOCK = 111;
	public static final int NEG = 122;
	public static final int LineTerminator = 144;
	public static final int ASSIGN = 96;
	public static final int INTERFACE = 50;
	public static final int DIV = 107;
	public static final int SEMIC = 68;
	public static final int LONG = 51;
	public static final int CR = 141;
	public static final int EXTENDS = 43;
	public static final int BSLASH = 130;
	public static final int LF = 140;

	private Token last;

	private final boolean areRegularExpressionsEnabled() {
		if (last == null) {
			return true;
		}
		switch (last.getType()) {
		// identifier
		case Identifier:
			// literals
		case NULL:
		case TRUE:
		case FALSE:
		case THIS:
		case OctalIntegerLiteral:
		case DecimalLiteral:
		case HexIntegerLiteral:
		case StringLiteral:
			// member access ending
		case RBRACK:
			// function call or nested expression ending
		case RPAREN:
			// getter and setter functions (ADDED BY SRUTHI)
			// case SET:
			// case GET:
			return false;
			// otherwise OK
		default:
			return true;
		}
	}

	private final void consumeIdentifierUnicodeStart()
			throws RecognitionException, NoViableAltException {
		int ch = input.LA(1);
		if (isIdentifierStartUnicode(ch)) {
			matchAny();
			do {
				ch = input.LA(1);
				if (ch == '$' || (ch >= '0' && ch <= '9')
						|| (ch >= 'A' && ch <= 'Z') || ch == '\\' || ch == '_'
						|| (ch >= 'a' && ch <= 'z')
						|| isIdentifierPartUnicode(ch)) {
					mIdentifierPart();
				} else {
					return;
				}
			} while (true);
		} else {
			throw new NoViableAltException();
		}
	}

	private final boolean isIdentifierPartUnicode(int ch) {
		return Character.isJavaIdentifierPart(ch);
	}

	private final boolean isIdentifierStartUnicode(int ch) {
		return Character.isJavaIdentifierStart(ch);
	}

	public Token nextToken() {
		Token result = super.nextToken();
		if (result.getChannel() == Token.DEFAULT_CHANNEL) {
			last = result;
		}
		return result;
	}

	// delegates
	// delegators

	public ES3Lexer() {
		;
	}

	public ES3Lexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public ES3Lexer(CharStream input, RecognizerSharedState state) {
		super(input, state);

	}

	public String getGrammarFileName() {
		return "ES3.g";
	}

	// $ANTLR start "NULL"
	public final void mNULL() throws RecognitionException {
		try {
			int _type = NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:87:6: ( 'null' )
			// ES3.g:87:8: 'null'
			{
				match("null");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "NULL"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:88:6: ( 'true' )
			// ES3.g:88:8: 'true'
			{
				match("true");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:89:7: ( 'false' )
			// ES3.g:89:9: 'false'
			{
				match("false");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "FALSE"

	// $ANTLR start "BREAK"
	public final void mBREAK() throws RecognitionException {
		try {
			int _type = BREAK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:90:7: ( 'break' )
			// ES3.g:90:9: 'break'
			{
				match("break");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "BREAK"

	// $ANTLR start "CASE"
	public final void mCASE() throws RecognitionException {
		try {
			int _type = CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:91:6: ( 'case' )
			// ES3.g:91:8: 'case'
			{
				match("case");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CASE"

	// $ANTLR start "CATCH"
	public final void mCATCH() throws RecognitionException {
		try {
			int _type = CATCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:92:7: ( 'catch' )
			// ES3.g:92:9: 'catch'
			{
				match("catch");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CATCH"

	// $ANTLR start "CONTINUE"
	public final void mCONTINUE() throws RecognitionException {
		try {
			int _type = CONTINUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:93:10: ( 'continue' )
			// ES3.g:93:12: 'continue'
			{
				match("continue");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CONTINUE"

	// $ANTLR start "DEFAULT"
	public final void mDEFAULT() throws RecognitionException {
		try {
			int _type = DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:94:9: ( 'default' )
			// ES3.g:94:11: 'default'
			{
				match("default");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DEFAULT"

	// $ANTLR start "DELETE"
	public final void mDELETE() throws RecognitionException {
		try {
			int _type = DELETE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:95:8: ( 'delete' )
			// ES3.g:95:10: 'delete'
			{
				match("delete");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DELETE"

	// $ANTLR start "DO"
	public final void mDO() throws RecognitionException {
		try {
			int _type = DO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:96:4: ( 'do' )
			// ES3.g:96:6: 'do'
			{
				match("do");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DO"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:97:6: ( 'else' )
			// ES3.g:97:8: 'else'
			{
				match("else");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ELSE"

	// $ANTLR start "FINALLY"
	public final void mFINALLY() throws RecognitionException {
		try {
			int _type = FINALLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:98:9: ( 'finally' )
			// ES3.g:98:11: 'finally'
			{
				match("finally");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "FINALLY"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:99:5: ( 'for' )
			// ES3.g:99:7: 'for'
			{
				match("for");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "FOR"

	// $ANTLR start "FUNCTION"
	public final void mFUNCTION() throws RecognitionException {
		try {
			int _type = FUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:100:10: ( 'function' )
			// ES3.g:100:12: 'function'
			{
				match("function");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "FUNCTION"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:101:4: ( 'if' )
			// ES3.g:101:6: 'if'
			{
				match("if");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "IF"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:102:4: ( 'in' )
			// ES3.g:102:6: 'in'
			{
				match("in");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "IN"

	// $ANTLR start "INSTANCEOF"
	public final void mINSTANCEOF() throws RecognitionException {
		try {
			int _type = INSTANCEOF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:103:12: ( 'instanceof' )
			// ES3.g:103:14: 'instanceof'
			{
				match("instanceof");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "INSTANCEOF"

	// $ANTLR start "NEW"
	public final void mNEW() throws RecognitionException {
		try {
			int _type = NEW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:104:5: ( 'new' )
			// ES3.g:104:7: 'new'
			{
				match("new");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "NEW"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:105:8: ( 'return' )
			// ES3.g:105:10: 'return'
			{
				match("return");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "RETURN"

	// $ANTLR start "SWITCH"
	public final void mSWITCH() throws RecognitionException {
		try {
			int _type = SWITCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:106:8: ( 'switch' )
			// ES3.g:106:10: 'switch'
			{
				match("switch");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SWITCH"

	// $ANTLR start "THIS"
	public final void mTHIS() throws RecognitionException {
		try {
			int _type = THIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:107:6: ( 'this' )
			// ES3.g:107:8: 'this'
			{
				match("this");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "THIS"

	// $ANTLR start "THROW"
	public final void mTHROW() throws RecognitionException {
		try {
			int _type = THROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:108:7: ( 'throw' )
			// ES3.g:108:9: 'throw'
			{
				match("throw");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "THROW"

	// $ANTLR start "TRY"
	public final void mTRY() throws RecognitionException {
		try {
			int _type = TRY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:109:5: ( 'try' )
			// ES3.g:109:7: 'try'
			{
				match("try");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "TRY"

	// $ANTLR start "TYPEOF"
	public final void mTYPEOF() throws RecognitionException {
		try {
			int _type = TYPEOF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:110:8: ( 'typeof' )
			// ES3.g:110:10: 'typeof'
			{
				match("typeof");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "TYPEOF"

	// $ANTLR start "VAR"
	public final void mVAR() throws RecognitionException {
		try {
			int _type = VAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:111:5: ( 'var' )
			// ES3.g:111:7: 'var'
			{
				match("var");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "VAR"

	// $ANTLR start "VOID"
	public final void mVOID() throws RecognitionException {
		try {
			int _type = VOID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:112:6: ( 'void' )
			// ES3.g:112:8: 'void'
			{
				match("void");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "VOID"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:113:7: ( 'while' )
			// ES3.g:113:9: 'while'
			{
				match("while");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "WHILE"

	// $ANTLR start "WITH"
	public final void mWITH() throws RecognitionException {
		try {
			int _type = WITH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:114:6: ( 'with' )
			// ES3.g:114:8: 'with'
			{
				match("with");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "WITH"

	// $ANTLR start "EACH"
	public final void mEACH() throws RecognitionException {
		try {
			int _type = EACH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:115:6: ( 'each' )
			// ES3.g:115:8: 'each'
			{
				match("each");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "EACH"

	// $ANTLR start "ABSTRACT"
	public final void mABSTRACT() throws RecognitionException {
		try {
			int _type = ABSTRACT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:116:10: ( 'abstract' )
			// ES3.g:116:12: 'abstract'
			{
				match("abstract");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ABSTRACT"

	// $ANTLR start "BOOLEAN"
	public final void mBOOLEAN() throws RecognitionException {
		try {
			int _type = BOOLEAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:117:9: ( 'boolean' )
			// ES3.g:117:11: 'boolean'
			{
				match("boolean");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "BOOLEAN"

	// $ANTLR start "BYTE"
	public final void mBYTE() throws RecognitionException {
		try {
			int _type = BYTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:118:6: ( 'byte' )
			// ES3.g:118:8: 'byte'
			{
				match("byte");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "BYTE"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:119:6: ( 'char' )
			// ES3.g:119:8: 'char'
			{
				match("char");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CHAR"

	// $ANTLR start "CLASS"
	public final void mCLASS() throws RecognitionException {
		try {
			int _type = CLASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:120:7: ( 'class' )
			// ES3.g:120:9: 'class'
			{
				match("class");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CLASS"

	// $ANTLR start "CONST"
	public final void mCONST() throws RecognitionException {
		try {
			int _type = CONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:121:7: ( 'const' )
			// ES3.g:121:9: 'const'
			{
				match("const");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "CONST"

	// $ANTLR start "DEBUGGER"
	public final void mDEBUGGER() throws RecognitionException {
		try {
			int _type = DEBUGGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:122:10: ( 'debugger' )
			// ES3.g:122:12: 'debugger'
			{
				match("debugger");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DEBUGGER"

	// $ANTLR start "DOUBLE"
	public final void mDOUBLE() throws RecognitionException {
		try {
			int _type = DOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:123:8: ( 'double' )
			// ES3.g:123:10: 'double'
			{
				match("double");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DOUBLE"

	// $ANTLR start "ENUM"
	public final void mENUM() throws RecognitionException {
		try {
			int _type = ENUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:124:6: ( 'enum' )
			// ES3.g:124:8: 'enum'
			{
				match("enum");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ENUM"

	// $ANTLR start "EXPORT"
	public final void mEXPORT() throws RecognitionException {
		try {
			int _type = EXPORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:125:8: ( 'export' )
			// ES3.g:125:10: 'export'
			{
				match("export");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "EXPORT"

	// $ANTLR start "EXTENDS"
	public final void mEXTENDS() throws RecognitionException {
		try {
			int _type = EXTENDS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:126:9: ( 'extends' )
			// ES3.g:126:11: 'extends'
			{
				match("extends");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "EXTENDS"

	// $ANTLR start "FINAL"
	public final void mFINAL() throws RecognitionException {
		try {
			int _type = FINAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:127:7: ( 'final' )
			// ES3.g:127:9: 'final'
			{
				match("final");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "FINAL"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:128:7: ( 'float' )
			// ES3.g:128:9: 'float'
			{
				match("float");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "FLOAT"

	// $ANTLR start "GOTO"
	public final void mGOTO() throws RecognitionException {
		try {
			int _type = GOTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:129:6: ( 'goto' )
			// ES3.g:129:8: 'goto'
			{
				match("goto");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "GOTO"

	// $ANTLR start "IMPLEMENTS"
	public final void mIMPLEMENTS() throws RecognitionException {
		try {
			int _type = IMPLEMENTS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:130:12: ( 'implements' )
			// ES3.g:130:14: 'implements'
			{
				match("implements");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "IMPLEMENTS"

	// $ANTLR start "IMPORT"
	public final void mIMPORT() throws RecognitionException {
		try {
			int _type = IMPORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:131:8: ( 'import' )
			// ES3.g:131:10: 'import'
			{
				match("import");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "IMPORT"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:132:5: ( 'int' )
			// ES3.g:132:7: 'int'
			{
				match("int");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "INT"

	// $ANTLR start "INTERFACE"
	public final void mINTERFACE() throws RecognitionException {
		try {
			int _type = INTERFACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:133:11: ( 'interface' )
			// ES3.g:133:13: 'interface'
			{
				match("interface");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "INTERFACE"

	// $ANTLR start "LONG"
	public final void mLONG() throws RecognitionException {
		try {
			int _type = LONG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:134:6: ( 'long' )
			// ES3.g:134:8: 'long'
			{
				match("long");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "LONG"

	// $ANTLR start "NATIVE"
	public final void mNATIVE() throws RecognitionException {
		try {
			int _type = NATIVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:135:8: ( 'native' )
			// ES3.g:135:10: 'native'
			{
				match("native");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "NATIVE"

	// $ANTLR start "PACKAGE"
	public final void mPACKAGE() throws RecognitionException {
		try {
			int _type = PACKAGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:136:9: ( 'package' )
			// ES3.g:136:11: 'package'
			{
				match("package");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "PACKAGE"

	// $ANTLR start "SHORT"
	public final void mSHORT() throws RecognitionException {
		try {
			int _type = SHORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:137:7: ( 'short' )
			// ES3.g:137:9: 'short'
			{
				match("short");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SHORT"

	// $ANTLR start "STATIC"
	public final void mSTATIC() throws RecognitionException {
		try {
			int _type = STATIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:138:8: ( 'static' )
			// ES3.g:138:10: 'static'
			{
				match("static");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "STATIC"

	// $ANTLR start "SUPER"
	public final void mSUPER() throws RecognitionException {
		try {
			int _type = SUPER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:139:7: ( 'super' )
			// ES3.g:139:9: 'super'
			{
				match("super");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SUPER"

	// $ANTLR start "SYNCHRONIZED"
	public final void mSYNCHRONIZED() throws RecognitionException {
		try {
			int _type = SYNCHRONIZED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:140:14: ( 'synchronized' )
			// ES3.g:140:16: 'synchronized'
			{
				match("synchronized");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SYNCHRONIZED"

	// $ANTLR start "THROWS"
	public final void mTHROWS() throws RecognitionException {
		try {
			int _type = THROWS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:141:8: ( 'throws' )
			// ES3.g:141:10: 'throws'
			{
				match("throws");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "THROWS"

	// $ANTLR start "TRANSIENT"
	public final void mTRANSIENT() throws RecognitionException {
		try {
			int _type = TRANSIENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:142:11: ( 'transient' )
			// ES3.g:142:13: 'transient'
			{
				match("transient");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "TRANSIENT"

	// $ANTLR start "VOLATILE"
	public final void mVOLATILE() throws RecognitionException {
		try {
			int _type = VOLATILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:143:10: ( 'volatile' )
			// ES3.g:143:12: 'volatile'
			{
				match("volatile");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "VOLATILE"

	// $ANTLR start "LBRACE"
	public final void mLBRACE() throws RecognitionException {
		try {
			int _type = LBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:144:8: ( '{' )
			// ES3.g:144:10: '{'
			{
				match('{');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "LBRACE"

	// $ANTLR start "RBRACE"
	public final void mRBRACE() throws RecognitionException {
		try {
			int _type = RBRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:145:8: ( '}' )
			// ES3.g:145:10: '}'
			{
				match('}');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "RBRACE"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:146:8: ( '(' )
			// ES3.g:146:10: '('
			{
				match('(');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:147:8: ( ')' )
			// ES3.g:147:10: ')'
			{
				match(')');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "RPAREN"

	// $ANTLR start "LBRACK"
	public final void mLBRACK() throws RecognitionException {
		try {
			int _type = LBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:148:8: ( '[' )
			// ES3.g:148:10: '['
			{
				match('[');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "LBRACK"

	// $ANTLR start "RBRACK"
	public final void mRBRACK() throws RecognitionException {
		try {
			int _type = RBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:149:8: ( ']' )
			// ES3.g:149:10: ']'
			{
				match(']');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "RBRACK"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:150:5: ( '.' )
			// ES3.g:150:7: '.'
			{
				match('.');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DOT"

	// $ANTLR start "SEMIC"
	public final void mSEMIC() throws RecognitionException {
		try {
			int _type = SEMIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:151:7: ( ';' )
			// ES3.g:151:9: ';'
			{
				match(';');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SEMIC"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:152:7: ( ',' )
			// ES3.g:152:9: ','
			{
				match(',');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "COMMA"

	// $ANTLR start "LT"
	public final void mLT() throws RecognitionException {
		try {
			int _type = LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:153:4: ( '<' )
			// ES3.g:153:6: '<'
			{
				match('<');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "LT"

	// $ANTLR start "GT"
	public final void mGT() throws RecognitionException {
		try {
			int _type = GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:154:4: ( '>' )
			// ES3.g:154:6: '>'
			{
				match('>');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "GT"

	// $ANTLR start "LTE"
	public final void mLTE() throws RecognitionException {
		try {
			int _type = LTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:155:5: ( '<=' )
			// ES3.g:155:7: '<='
			{
				match("<=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "LTE"

	// $ANTLR start "GTE"
	public final void mGTE() throws RecognitionException {
		try {
			int _type = GTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:156:5: ( '>=' )
			// ES3.g:156:7: '>='
			{
				match(">=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "GTE"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:157:4: ( '==' )
			// ES3.g:157:6: '=='
			{
				match("==");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "EQ"

	// $ANTLR start "NEQ"
	public final void mNEQ() throws RecognitionException {
		try {
			int _type = NEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:158:5: ( '!=' )
			// ES3.g:158:7: '!='
			{
				match("!=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "NEQ"

	// $ANTLR start "SAME"
	public final void mSAME() throws RecognitionException {
		try {
			int _type = SAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:159:6: ( '===' )
			// ES3.g:159:8: '==='
			{
				match("===");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SAME"

	// $ANTLR start "NSAME"
	public final void mNSAME() throws RecognitionException {
		try {
			int _type = NSAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:160:7: ( '!==' )
			// ES3.g:160:9: '!=='
			{
				match("!==");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "NSAME"

	// $ANTLR start "ADD"
	public final void mADD() throws RecognitionException {
		try {
			int _type = ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:161:5: ( '+' )
			// ES3.g:161:7: '+'
			{
				match('+');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ADD"

	// $ANTLR start "SUB"
	public final void mSUB() throws RecognitionException {
		try {
			int _type = SUB;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:162:5: ( '-' )
			// ES3.g:162:7: '-'
			{
				match('-');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SUB"

	// $ANTLR start "MUL"
	public final void mMUL() throws RecognitionException {
		try {
			int _type = MUL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:163:5: ( '*' )
			// ES3.g:163:7: '*'
			{
				match('*');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "MUL"

	// $ANTLR start "MOD"
	public final void mMOD() throws RecognitionException {
		try {
			int _type = MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:164:5: ( '%' )
			// ES3.g:164:7: '%'
			{
				match('%');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "MOD"

	// $ANTLR start "INC"
	public final void mINC() throws RecognitionException {
		try {
			int _type = INC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:165:5: ( '++' )
			// ES3.g:165:7: '++'
			{
				match("++");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "INC"

	// $ANTLR start "DEC"
	public final void mDEC() throws RecognitionException {
		try {
			int _type = DEC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:166:5: ( '--' )
			// ES3.g:166:7: '--'
			{
				match("--");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DEC"

	// $ANTLR start "SHL"
	public final void mSHL() throws RecognitionException {
		try {
			int _type = SHL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:167:5: ( '<<' )
			// ES3.g:167:7: '<<'
			{
				match("<<");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SHL"

	// $ANTLR start "SHR"
	public final void mSHR() throws RecognitionException {
		try {
			int _type = SHR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:168:5: ( '>>' )
			// ES3.g:168:7: '>>'
			{
				match(">>");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SHR"

	// $ANTLR start "SHU"
	public final void mSHU() throws RecognitionException {
		try {
			int _type = SHU;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:169:5: ( '>>>' )
			// ES3.g:169:7: '>>>'
			{
				match(">>>");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SHU"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:170:5: ( '&' )
			// ES3.g:170:7: '&'
			{
				match('&');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:171:4: ( '|' )
			// ES3.g:171:6: '|'
			{
				match('|');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "OR"

	// $ANTLR start "XOR"
	public final void mXOR() throws RecognitionException {
		try {
			int _type = XOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:172:5: ( '^' )
			// ES3.g:172:7: '^'
			{
				match('^');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "XOR"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:173:5: ( '!' )
			// ES3.g:173:7: '!'
			{
				match('!');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "NOT"

	// $ANTLR start "INV"
	public final void mINV() throws RecognitionException {
		try {
			int _type = INV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:174:5: ( '~' )
			// ES3.g:174:7: '~'
			{
				match('~');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "INV"

	// $ANTLR start "LAND"
	public final void mLAND() throws RecognitionException {
		try {
			int _type = LAND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:175:6: ( '&&' )
			// ES3.g:175:8: '&&'
			{
				match("&&");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "LAND"

	// $ANTLR start "LOR"
	public final void mLOR() throws RecognitionException {
		try {
			int _type = LOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:176:5: ( '||' )
			// ES3.g:176:7: '||'
			{
				match("||");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "LOR"

	// $ANTLR start "QUE"
	public final void mQUE() throws RecognitionException {
		try {
			int _type = QUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:177:5: ( '?' )
			// ES3.g:177:7: '?'
			{
				match('?');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "QUE"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:178:7: ( ':' )
			// ES3.g:178:9: ':'
			{
				match(':');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "COLON"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:179:8: ( '=' )
			// ES3.g:179:10: '='
			{
				match('=');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ASSIGN"

	// $ANTLR start "ADDASS"
	public final void mADDASS() throws RecognitionException {
		try {
			int _type = ADDASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:180:8: ( '+=' )
			// ES3.g:180:10: '+='
			{
				match("+=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ADDASS"

	// $ANTLR start "SUBASS"
	public final void mSUBASS() throws RecognitionException {
		try {
			int _type = SUBASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:181:8: ( '-=' )
			// ES3.g:181:10: '-='
			{
				match("-=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SUBASS"

	// $ANTLR start "MULASS"
	public final void mMULASS() throws RecognitionException {
		try {
			int _type = MULASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:182:8: ( '*=' )
			// ES3.g:182:10: '*='
			{
				match("*=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "MULASS"

	// $ANTLR start "MODASS"
	public final void mMODASS() throws RecognitionException {
		try {
			int _type = MODASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:183:8: ( '%=' )
			// ES3.g:183:10: '%='
			{
				match("%=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "MODASS"

	// $ANTLR start "SHLASS"
	public final void mSHLASS() throws RecognitionException {
		try {
			int _type = SHLASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:184:8: ( '<<=' )
			// ES3.g:184:10: '<<='
			{
				match("<<=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SHLASS"

	// $ANTLR start "SHRASS"
	public final void mSHRASS() throws RecognitionException {
		try {
			int _type = SHRASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:185:8: ( '>>=' )
			// ES3.g:185:10: '>>='
			{
				match(">>=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SHRASS"

	// $ANTLR start "SHUASS"
	public final void mSHUASS() throws RecognitionException {
		try {
			int _type = SHUASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:186:8: ( '>>>=' )
			// ES3.g:186:10: '>>>='
			{
				match(">>>=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SHUASS"

	// $ANTLR start "ANDASS"
	public final void mANDASS() throws RecognitionException {
		try {
			int _type = ANDASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:187:8: ( '&=' )
			// ES3.g:187:10: '&='
			{
				match("&=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ANDASS"

	// $ANTLR start "ORASS"
	public final void mORASS() throws RecognitionException {
		try {
			int _type = ORASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:188:7: ( '|=' )
			// ES3.g:188:9: '|='
			{
				match("|=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "ORASS"

	// $ANTLR start "XORASS"
	public final void mXORASS() throws RecognitionException {
		try {
			int _type = XORASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:189:8: ( '^=' )
			// ES3.g:189:10: '^='
			{
				match("^=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "XORASS"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:190:5: ( '/' )
			// ES3.g:190:7: '/'
			{
				match('/');

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DIV"

	// $ANTLR start "DIVASS"
	public final void mDIVASS() throws RecognitionException {
		try {
			int _type = DIVASS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:191:8: ( '/=' )
			// ES3.g:191:10: '/='
			{
				match("/=");

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DIVASS"

	// $ANTLR start "BSLASH"
	public final void mBSLASH() throws RecognitionException {
		try {
			// ES3.g:429:2: ( '\\\\' )
			// ES3.g:429:4: '\\\\'
			{
				match('\\');

			}

		} finally {
		}
	}

	// $ANTLR end "BSLASH"

	// $ANTLR start "DQUOTE"
	public final void mDQUOTE() throws RecognitionException {
		try {
			// ES3.g:433:2: ( '\"' )
			// ES3.g:433:4: '\"'
			{
				match('\"');

			}

		} finally {
		}
	}

	// $ANTLR end "DQUOTE"

	// $ANTLR start "SQUOTE"
	public final void mSQUOTE() throws RecognitionException {
		try {
			// ES3.g:437:2: ( '\\'' )
			// ES3.g:437:4: '\\''
			{
				match('\'');

			}

		} finally {
		}
	}

	// $ANTLR end "SQUOTE"

	// $ANTLR start "TAB"
	public final void mTAB() throws RecognitionException {
		try {
			// ES3.g:443:2: ( '\ ' )
			// ES3.g:443:4: '\ '
			{
				match('\t');

			}

		} finally {
		}
	}

	// $ANTLR end "TAB"

	// $ANTLR start "VT"
	public final void mVT() throws RecognitionException {
		try {
			// ES3.g:447:2: ( '\\u000b' )
			// ES3.g:447:4: '\\u000b'
			{
				match('\u000B');

			}

		} finally {
		}
	}

	// $ANTLR end "VT"

	// $ANTLR start "FF"
	public final void mFF() throws RecognitionException {
		try {
			// ES3.g:451:2: ( '\ ' )
			// ES3.g:451:4: '\ '
			{
				match('\f');

			}

		} finally {
		}
	}

	// $ANTLR end "FF"

	// $ANTLR start "SP"
	public final void mSP() throws RecognitionException {
		try {
			// ES3.g:455:2: ( '\ ' )
			// ES3.g:455:4: '\ '
			{
				match(' ');

			}

		} finally {
		}
	}

	// $ANTLR end "SP"

	// $ANTLR start "NBSP"
	public final void mNBSP() throws RecognitionException {
		try {
			// ES3.g:459:2: ( '\\u00a0' )
			// ES3.g:459:4: '\\u00a0'
			{
				match('\u00A0');

			}

		} finally {
		}
	}

	// $ANTLR end "NBSP"

	// $ANTLR start "USP"
	public final void mUSP() throws RecognitionException {
		try {
			// ES3.g:463:2: ( '\\u1680' | '\\u180E' | '\\u2000' | '\\u2001' |
			// '\\u2002' | '\\u2003' | '\\u2004' | '\\u2005' | '\\u2006' |
			// '\\u2007' | '\\u2008' | '\\u2009' | '\\u200A' | '\\u202F' |
			// '\\u205F' | '\\u3000' )
			// ES3.g:
			{
				if (input.LA(1) == '\u1680' || input.LA(1) == '\u180E'
						|| (input.LA(1) >= '\u2000' && input.LA(1) <= '\u200A')
						|| input.LA(1) == '\u202F' || input.LA(1) == '\u205F'
						|| input.LA(1) == '\u3000') {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recover(mse);
					throw mse;
				}

			}

		} finally {
		}
	}

	// $ANTLR end "USP"

	// $ANTLR start "WhiteSpace"
	public final void mWhiteSpace() throws RecognitionException {
		try {
			int _type = WhiteSpace;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:482:2: ( ( TAB | VT | FF | SP | NBSP | USP )+ )
			// ES3.g:482:4: ( TAB | VT | FF | SP | NBSP | USP )+
			{
				// ES3.g:482:4: ( TAB | VT | FF | SP | NBSP | USP )+
				int cnt1 = 0;
				loop1: do {
					int alt1 = 2;
					int LA1_0 = input.LA(1);

					if ((LA1_0 == '\t' || (LA1_0 >= '\u000B' && LA1_0 <= '\f')
							|| LA1_0 == ' ' || LA1_0 == '\u00A0'
							|| LA1_0 == '\u1680' || LA1_0 == '\u180E'
							|| (LA1_0 >= '\u2000' && LA1_0 <= '\u200A')
							|| LA1_0 == '\u202F' || LA1_0 == '\u205F' || LA1_0 == '\u3000')) {
						alt1 = 1;
					}

					switch (alt1) {
					case 1:
						// ES3.g:
					{
						if (input.LA(1) == '\t'
								|| (input.LA(1) >= '\u000B' && input.LA(1) <= '\f')
								|| input.LA(1) == ' '
								|| input.LA(1) == '\u00A0'
								|| input.LA(1) == '\u1680'
								|| input.LA(1) == '\u180E'
								|| (input.LA(1) >= '\u2000' && input.LA(1) <= '\u200A')
								|| input.LA(1) == '\u202F'
								|| input.LA(1) == '\u205F'
								|| input.LA(1) == '\u3000') {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							recover(mse);
							throw mse;
						}

					}
						break;

					default:
						if (cnt1 >= 1)
							break loop1;
						EarlyExitException eee = new EarlyExitException(1,
								input);
						throw eee;
					}
					cnt1++;
				} while (true);

				_channel = HIDDEN;

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "WhiteSpace"

	// $ANTLR start "LF"
	public final void mLF() throws RecognitionException {
		try {
			// ES3.g:490:2: ( '\\n' )
			// ES3.g:490:4: '\\n'
			{
				match('\n');

			}

		} finally {
		}
	}

	// $ANTLR end "LF"

	// $ANTLR start "CR"
	public final void mCR() throws RecognitionException {
		try {
			// ES3.g:494:2: ( '\\r' )
			// ES3.g:494:4: '\\r'
			{
				match('\r');

			}

		} finally {
		}
	}

	// $ANTLR end "CR"

	// $ANTLR start "LS"
	public final void mLS() throws RecognitionException {
		try {
			// ES3.g:498:2: ( '\\u2028' )
			// ES3.g:498:4: '\\u2028'
			{
				match('\u2028');

			}

		} finally {
		}
	}

	// $ANTLR end "LS"

	// $ANTLR start "PS"
	public final void mPS() throws RecognitionException {
		try {
			// ES3.g:502:2: ( '\\u2029' )
			// ES3.g:502:4: '\\u2029'
			{
				match('\u2029');

			}

		} finally {
		}
	}

	// $ANTLR end "PS"

	// $ANTLR start "LineTerminator"
	public final void mLineTerminator() throws RecognitionException {
		try {
			// ES3.g:506:2: ( CR | LF | LS | PS )
			// ES3.g:
			{
				if (input.LA(1) == '\n' || input.LA(1) == '\r'
						|| (input.LA(1) >= '\u2028' && input.LA(1) <= '\u2029')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recover(mse);
					throw mse;
				}

			}

		} finally {
		}
	}

	// $ANTLR end "LineTerminator"

	// $ANTLR start "EOL"
	public final void mEOL() throws RecognitionException {
		try {
			int _type = EOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:510:2: ( ( ( CR ( LF )? ) | LF | LS | PS ) )
			// ES3.g:510:4: ( ( CR ( LF )? ) | LF | LS | PS )
			{
				// ES3.g:510:4: ( ( CR ( LF )? ) | LF | LS | PS )
				int alt3 = 4;
				switch (input.LA(1)) {
				case '\r': {
					alt3 = 1;
				}
					break;
				case '\n': {
					alt3 = 2;
				}
					break;
				case '\u2028': {
					alt3 = 3;
				}
					break;
				case '\u2029': {
					alt3 = 4;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("", 3,
							0, input);

					throw nvae;
				}

				switch (alt3) {
				case 1:
					// ES3.g:510:6: ( CR ( LF )? )
				{
					// ES3.g:510:6: ( CR ( LF )? )
					// ES3.g:510:8: CR ( LF )?
					{
						mCR();
						// ES3.g:510:11: ( LF )?
						int alt2 = 2;
						int LA2_0 = input.LA(1);

						if ((LA2_0 == '\n')) {
							alt2 = 1;
						}
						switch (alt2) {
						case 1:
							// ES3.g:510:11: LF
						{
							mLF();

						}
							break;

						}

					}

				}
					break;
				case 2:
					// ES3.g:510:19: LF
				{
					mLF();

				}
					break;
				case 3:
					// ES3.g:510:24: LS
				{
					mLS();

				}
					break;
				case 4:
					// ES3.g:510:29: PS
				{
					mPS();

				}
					break;

				}

				_channel = HIDDEN;

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "EOL"

	// $ANTLR start "MultiLineComment"
	public final void mMultiLineComment() throws RecognitionException {
		try {
			int _type = MultiLineComment;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:517:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// ES3.g:517:4: '/*' ( options {greedy=false; } : . )* '*/'
			{
				match("/*");

				// ES3.g:517:9: ( options {greedy=false; } : . )*
				loop4: do {
					int alt4 = 2;
					int LA4_0 = input.LA(1);

					if ((LA4_0 == '*')) {
						int LA4_1 = input.LA(2);

						if ((LA4_1 == '/')) {
							alt4 = 2;
						} else if (((LA4_1 >= '\u0000' && LA4_1 <= '.') || (LA4_1 >= '0' && LA4_1 <= '\uFFFF'))) {
							alt4 = 1;
						}

					} else if (((LA4_0 >= '\u0000' && LA4_0 <= ')') || (LA4_0 >= '+' && LA4_0 <= '\uFFFF'))) {
						alt4 = 1;
					}

					switch (alt4) {
					case 1:
						// ES3.g:517:40: .
					{
						matchAny();

					}
						break;

					default:
						break loop4;
					}
				} while (true);

				match("*/");

				_channel = HIDDEN;

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "MultiLineComment"

	// $ANTLR start "SingleLineComment"
	public final void mSingleLineComment() throws RecognitionException {
		try {
			int _type = SingleLineComment;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:521:2: ( '//' (~ ( LineTerminator ) )* )
			// ES3.g:521:4: '//' (~ ( LineTerminator ) )*
			{
				match("//");

				// ES3.g:521:9: (~ ( LineTerminator ) )*
				loop5: do {
					int alt5 = 2;
					int LA5_0 = input.LA(1);

					if (((LA5_0 >= '\u0000' && LA5_0 <= '\t')
							|| (LA5_0 >= '\u000B' && LA5_0 <= '\f')
							|| (LA5_0 >= '\u000E' && LA5_0 <= '\u2027') || (LA5_0 >= '\u202A' && LA5_0 <= '\uFFFF'))) {
						alt5 = 1;
					}

					switch (alt5) {
					case 1:
						// ES3.g:521:11: ~ ( LineTerminator )
					{
						if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t')
								|| (input.LA(1) >= '\u000B' && input.LA(1) <= '\f')
								|| (input.LA(1) >= '\u000E' && input.LA(1) <= '\u2027')
								|| (input.LA(1) >= '\u202A' && input.LA(1) <= '\uFFFF')) {
							input.consume();

						} else {
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							recover(mse);
							throw mse;
						}

					}
						break;

					default:
						break loop5;
					}
				} while (true);

				_channel = HIDDEN;

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "SingleLineComment"

	// $ANTLR start "IdentifierStartASCII"
	public final void mIdentifierStartASCII() throws RecognitionException {
		try {
			// ES3.g:620:2: ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | BSLASH 'u'
			// HexDigit HexDigit HexDigit HexDigit )
			int alt6 = 5;
			switch (input.LA(1)) {
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'g':
			case 'h':
			case 'i':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'o':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'u':
			case 'v':
			case 'w':
			case 'x':
			case 'y':
			case 'z': {
				alt6 = 1;
			}
				break;
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case 'G':
			case 'H':
			case 'I':
			case 'J':
			case 'K':
			case 'L':
			case 'M':
			case 'N':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
			case 'T':
			case 'U':
			case 'V':
			case 'W':
			case 'X':
			case 'Y':
			case 'Z': {
				alt6 = 2;
			}
				break;
			case '$': {
				alt6 = 3;
			}
				break;
			case '_': {
				alt6 = 4;
			}
				break;
			case '\\': {
				alt6 = 5;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 6, 0,
						input);

				throw nvae;
			}

			switch (alt6) {
			case 1:
				// ES3.g:620:4: 'a' .. 'z'
			{
				matchRange('a', 'z');

			}
				break;
			case 2:
				// ES3.g:620:15: 'A' .. 'Z'
			{
				matchRange('A', 'Z');

			}
				break;
			case 3:
				// ES3.g:621:4: '$'
			{
				match('$');

			}
				break;
			case 4:
				// ES3.g:622:4: '_'
			{
				match('_');

			}
				break;
			case 5:
				// ES3.g:623:4: BSLASH 'u' HexDigit HexDigit HexDigit HexDigit
			{
				mBSLASH();
				match('u');
				mHexDigit();
				mHexDigit();
				mHexDigit();
				mHexDigit();

			}
				break;

			}
		} finally {
		}
	}

	// $ANTLR end "IdentifierStartASCII"

	// $ANTLR start "IdentifierPart"
	public final void mIdentifierPart() throws RecognitionException {
		try {
			// ES3.g:631:2: ( DecimalDigit | IdentifierStartASCII | {...}?)
			int alt7 = 3;
			switch (input.LA(1)) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9': {
				alt7 = 1;
			}
				break;
			case '$':
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case 'G':
			case 'H':
			case 'I':
			case 'J':
			case 'K':
			case 'L':
			case 'M':
			case 'N':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
			case 'T':
			case 'U':
			case 'V':
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
			case '\\':
			case '_':
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'g':
			case 'h':
			case 'i':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'o':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'u':
			case 'v':
			case 'w':
			case 'x':
			case 'y':
			case 'z': {
				alt7 = 2;
			}
				break;
			default:
				alt7 = 3;
			}

			switch (alt7) {
			case 1:
				// ES3.g:631:4: DecimalDigit
			{
				mDecimalDigit();

			}
				break;
			case 2:
				// ES3.g:632:4: IdentifierStartASCII
			{
				mIdentifierStartASCII();

			}
				break;
			case 3:
				// ES3.g:633:4: {...}?
			{
				if (!((isIdentifierPartUnicode(input.LA(1))))) {
					throw new FailedPredicateException(input, "IdentifierPart",
							" isIdentifierPartUnicode(input.LA(1)) ");
				}
				matchAny();

			}
				break;

			}
		} finally {
		}
	}

	// $ANTLR end "IdentifierPart"

	// $ANTLR start "IdentifierNameASCIIStart"
	public final void mIdentifierNameASCIIStart() throws RecognitionException {
		try {
			// ES3.g:637:2: ( IdentifierStartASCII ( IdentifierPart )* )
			// ES3.g:637:4: IdentifierStartASCII ( IdentifierPart )*
			{
				mIdentifierStartASCII();
				// ES3.g:637:25: ( IdentifierPart )*
				loop8: do {
					int alt8 = 2;
					int LA8_0 = input.LA(1);

					if ((LA8_0 == '$' || (LA8_0 >= '0' && LA8_0 <= '9')
							|| (LA8_0 >= 'A' && LA8_0 <= 'Z') || LA8_0 == '\\'
							|| LA8_0 == '_' || (LA8_0 >= 'a' && LA8_0 <= 'z'))) {
						alt8 = 1;
					} else if (((isIdentifierPartUnicode(input.LA(1))))) {
						alt8 = 1;
					}

					switch (alt8) {
					case 1:
						// ES3.g:637:25: IdentifierPart
					{
						mIdentifierPart();

					}
						break;

					default:
						break loop8;
					}
				} while (true);

			}

		} finally {
		}
	}

	// $ANTLR end "IdentifierNameASCIIStart"

	// $ANTLR start "Identifier"
	public final void mIdentifier() throws RecognitionException {
		try {
			int _type = Identifier;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:649:2: ( IdentifierNameASCIIStart | )
			int alt9 = 2;
			int LA9_0 = input.LA(1);

			if ((LA9_0 == '$' || (LA9_0 >= 'A' && LA9_0 <= 'Z')
					|| LA9_0 == '\\' || LA9_0 == '_' || (LA9_0 >= 'a' && LA9_0 <= 'z'))) {
				alt9 = 1;
			} else {
				alt9 = 2;
			}
			switch (alt9) {
			case 1:
				// ES3.g:649:4: IdentifierNameASCIIStart
			{
				mIdentifierNameASCIIStart();

			}
				break;
			case 2:
				// ES3.g:650:4:
			{
				consumeIdentifierUnicodeStart();

			}
				break;

			}
			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "Identifier"

	// $ANTLR start "DecimalDigit"
	public final void mDecimalDigit() throws RecognitionException {
		try {
			// ES3.g:733:2: ( '0' .. '9' )
			// ES3.g:733:4: '0' .. '9'
			{
				matchRange('0', '9');

			}

		} finally {
		}
	}

	// $ANTLR end "DecimalDigit"

	// $ANTLR start "HexDigit"
	public final void mHexDigit() throws RecognitionException {
		try {
			// ES3.g:737:2: ( DecimalDigit | 'a' .. 'f' | 'A' .. 'F' )
			// ES3.g:
			{
				if ((input.LA(1) >= '0' && input.LA(1) <= '9')
						|| (input.LA(1) >= 'A' && input.LA(1) <= 'F')
						|| (input.LA(1) >= 'a' && input.LA(1) <= 'f')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recover(mse);
					throw mse;
				}

			}

		} finally {
		}
	}

	// $ANTLR end "HexDigit"

	// $ANTLR start "OctalDigit"
	public final void mOctalDigit() throws RecognitionException {
		try {
			// ES3.g:741:2: ( '0' .. '7' )
			// ES3.g:741:4: '0' .. '7'
			{
				matchRange('0', '7');

			}

		} finally {
		}
	}

	// $ANTLR end "OctalDigit"

	// $ANTLR start "ExponentPart"
	public final void mExponentPart() throws RecognitionException {
		try {
			// ES3.g:745:2: ( ( 'e' | 'E' ) ( '+' | '-' )? ( DecimalDigit )+ )
			// ES3.g:745:4: ( 'e' | 'E' ) ( '+' | '-' )? ( DecimalDigit )+
			{
				if (input.LA(1) == 'E' || input.LA(1) == 'e') {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recover(mse);
					throw mse;
				}

				// ES3.g:745:18: ( '+' | '-' )?
				int alt10 = 2;
				int LA10_0 = input.LA(1);

				if ((LA10_0 == '+' || LA10_0 == '-')) {
					alt10 = 1;
				}
				switch (alt10) {
				case 1:
					// ES3.g:
				{
					if (input.LA(1) == '+' || input.LA(1) == '-') {
						input.consume();

					} else {
						MismatchedSetException mse = new MismatchedSetException(
								null, input);
						recover(mse);
						throw mse;
					}

				}
					break;

				}

				// ES3.g:745:33: ( DecimalDigit )+
				int cnt11 = 0;
				loop11: do {
					int alt11 = 2;
					int LA11_0 = input.LA(1);

					if (((LA11_0 >= '0' && LA11_0 <= '9'))) {
						alt11 = 1;
					}

					switch (alt11) {
					case 1:
						// ES3.g:745:33: DecimalDigit
					{
						mDecimalDigit();

					}
						break;

					default:
						if (cnt11 >= 1)
							break loop11;
						EarlyExitException eee = new EarlyExitException(11,
								input);
						throw eee;
					}
					cnt11++;
				} while (true);

			}

		} finally {
		}
	}

	// $ANTLR end "ExponentPart"

	// $ANTLR start "DecimalIntegerLiteral"
	public final void mDecimalIntegerLiteral() throws RecognitionException {
		try {
			// ES3.g:749:2: ( '0' | '1' .. '9' ( DecimalDigit )* )
			int alt13 = 2;
			int LA13_0 = input.LA(1);

			if ((LA13_0 == '0')) {
				alt13 = 1;
			} else if (((LA13_0 >= '1' && LA13_0 <= '9'))) {
				alt13 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 13, 0,
						input);

				throw nvae;
			}
			switch (alt13) {
			case 1:
				// ES3.g:749:4: '0'
			{
				match('0');

			}
				break;
			case 2:
				// ES3.g:750:4: '1' .. '9' ( DecimalDigit )*
			{
				matchRange('1', '9');
				// ES3.g:750:13: ( DecimalDigit )*
				loop12: do {
					int alt12 = 2;
					int LA12_0 = input.LA(1);

					if (((LA12_0 >= '0' && LA12_0 <= '9'))) {
						alt12 = 1;
					}

					switch (alt12) {
					case 1:
						// ES3.g:750:13: DecimalDigit
					{
						mDecimalDigit();

					}
						break;

					default:
						break loop12;
					}
				} while (true);

			}
				break;

			}
		} finally {
		}
	}

	// $ANTLR end "DecimalIntegerLiteral"

	// $ANTLR start "DecimalLiteral"
	public final void mDecimalLiteral() throws RecognitionException {
		try {
			int _type = DecimalLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:754:2: ( DecimalIntegerLiteral '.' ( DecimalDigit )* (
			// ExponentPart )? | '.' ( DecimalDigit )+ ( ExponentPart )? |
			// DecimalIntegerLiteral ( ExponentPart )? )
			int alt19 = 3;
			alt19 = dfa19.predict(input);
			switch (alt19) {
			case 1:
				// ES3.g:754:4: DecimalIntegerLiteral '.' ( DecimalDigit )* (
				// ExponentPart )?
			{
				mDecimalIntegerLiteral();
				match('.');
				// ES3.g:754:30: ( DecimalDigit )*
				loop14: do {
					int alt14 = 2;
					int LA14_0 = input.LA(1);

					if (((LA14_0 >= '0' && LA14_0 <= '9'))) {
						alt14 = 1;
					}

					switch (alt14) {
					case 1:
						// ES3.g:754:30: DecimalDigit
					{
						mDecimalDigit();

					}
						break;

					default:
						break loop14;
					}
				} while (true);

				// ES3.g:754:44: ( ExponentPart )?
				int alt15 = 2;
				int LA15_0 = input.LA(1);

				if ((LA15_0 == 'E' || LA15_0 == 'e')) {
					alt15 = 1;
				}
				switch (alt15) {
				case 1:
					// ES3.g:754:44: ExponentPart
				{
					mExponentPart();

				}
					break;

				}

			}
				break;
			case 2:
				// ES3.g:755:4: '.' ( DecimalDigit )+ ( ExponentPart )?
			{
				match('.');
				// ES3.g:755:8: ( DecimalDigit )+
				int cnt16 = 0;
				loop16: do {
					int alt16 = 2;
					int LA16_0 = input.LA(1);

					if (((LA16_0 >= '0' && LA16_0 <= '9'))) {
						alt16 = 1;
					}

					switch (alt16) {
					case 1:
						// ES3.g:755:8: DecimalDigit
					{
						mDecimalDigit();

					}
						break;

					default:
						if (cnt16 >= 1)
							break loop16;
						EarlyExitException eee = new EarlyExitException(16,
								input);
						throw eee;
					}
					cnt16++;
				} while (true);

				// ES3.g:755:22: ( ExponentPart )?
				int alt17 = 2;
				int LA17_0 = input.LA(1);

				if ((LA17_0 == 'E' || LA17_0 == 'e')) {
					alt17 = 1;
				}
				switch (alt17) {
				case 1:
					// ES3.g:755:22: ExponentPart
				{
					mExponentPart();

				}
					break;

				}

			}
				break;
			case 3:
				// ES3.g:756:4: DecimalIntegerLiteral ( ExponentPart )?
			{
				mDecimalIntegerLiteral();
				// ES3.g:756:26: ( ExponentPart )?
				int alt18 = 2;
				int LA18_0 = input.LA(1);

				if ((LA18_0 == 'E' || LA18_0 == 'e')) {
					alt18 = 1;
				}
				switch (alt18) {
				case 1:
					// ES3.g:756:26: ExponentPart
				{
					mExponentPart();

				}
					break;

				}

			}
				break;

			}
			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "DecimalLiteral"

	// $ANTLR start "OctalIntegerLiteral"
	public final void mOctalIntegerLiteral() throws RecognitionException {
		try {
			int _type = OctalIntegerLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:760:2: ( '0' ( OctalDigit )+ )
			// ES3.g:760:4: '0' ( OctalDigit )+
			{
				match('0');
				// ES3.g:760:8: ( OctalDigit )+
				int cnt20 = 0;
				loop20: do {
					int alt20 = 2;
					int LA20_0 = input.LA(1);

					if (((LA20_0 >= '0' && LA20_0 <= '7'))) {
						alt20 = 1;
					}

					switch (alt20) {
					case 1:
						// ES3.g:760:8: OctalDigit
					{
						mOctalDigit();

					}
						break;

					default:
						if (cnt20 >= 1)
							break loop20;
						EarlyExitException eee = new EarlyExitException(20,
								input);
						throw eee;
					}
					cnt20++;
				} while (true);

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "OctalIntegerLiteral"

	// $ANTLR start "HexIntegerLiteral"
	public final void mHexIntegerLiteral() throws RecognitionException {
		try {
			int _type = HexIntegerLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:764:2: ( ( '0x' | '0X' ) ( HexDigit )+ )
			// ES3.g:764:4: ( '0x' | '0X' ) ( HexDigit )+
			{
				// ES3.g:764:4: ( '0x' | '0X' )
				int alt21 = 2;
				int LA21_0 = input.LA(1);

				if ((LA21_0 == '0')) {
					int LA21_1 = input.LA(2);

					if ((LA21_1 == 'x')) {
						alt21 = 1;
					} else if ((LA21_1 == 'X')) {
						alt21 = 2;
					} else {
						NoViableAltException nvae = new NoViableAltException(
								"", 21, 1, input);

						throw nvae;
					}
				} else {
					NoViableAltException nvae = new NoViableAltException("",
							21, 0, input);

					throw nvae;
				}
				switch (alt21) {
				case 1:
					// ES3.g:764:6: '0x'
				{
					match("0x");

				}
					break;
				case 2:
					// ES3.g:764:13: '0X'
				{
					match("0X");

				}
					break;

				}

				// ES3.g:764:20: ( HexDigit )+
				int cnt22 = 0;
				loop22: do {
					int alt22 = 2;
					int LA22_0 = input.LA(1);

					if (((LA22_0 >= '0' && LA22_0 <= '9')
							|| (LA22_0 >= 'A' && LA22_0 <= 'F') || (LA22_0 >= 'a' && LA22_0 <= 'f'))) {
						alt22 = 1;
					}

					switch (alt22) {
					case 1:
						// ES3.g:764:20: HexDigit
					{
						mHexDigit();

					}
						break;

					default:
						if (cnt22 >= 1)
							break loop22;
						EarlyExitException eee = new EarlyExitException(22,
								input);
						throw eee;
					}
					cnt22++;
				} while (true);

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "HexIntegerLiteral"

	// $ANTLR start "CharacterEscapeSequence"
	public final void mCharacterEscapeSequence() throws RecognitionException {
		try {
			// ES3.g:783:2: (~ ( DecimalDigit | 'x' | 'u' | LineTerminator ) )
			// ES3.g:783:4: ~ ( DecimalDigit | 'x' | 'u' | LineTerminator )
			{
				if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t')
						|| (input.LA(1) >= '\u000B' && input.LA(1) <= '\f')
						|| (input.LA(1) >= '\u000E' && input.LA(1) <= '/')
						|| (input.LA(1) >= ':' && input.LA(1) <= 't')
						|| (input.LA(1) >= 'v' && input.LA(1) <= 'w')
						|| (input.LA(1) >= 'y' && input.LA(1) <= '\u2027')
						|| (input.LA(1) >= '\u202A' && input.LA(1) <= '\uFFFF')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recover(mse);
					throw mse;
				}

			}

		} finally {
		}
	}

	// $ANTLR end "CharacterEscapeSequence"

	// $ANTLR start "ZeroToThree"
	public final void mZeroToThree() throws RecognitionException {
		try {
			// ES3.g:787:2: ( '0' .. '3' )
			// ES3.g:787:4: '0' .. '3'
			{
				matchRange('0', '3');

			}

		} finally {
		}
	}

	// $ANTLR end "ZeroToThree"

	// $ANTLR start "OctalEscapeSequence"
	public final void mOctalEscapeSequence() throws RecognitionException {
		try {
			// ES3.g:791:2: ( OctalDigit | ZeroToThree OctalDigit | '4' .. '7'
			// OctalDigit | ZeroToThree OctalDigit OctalDigit )
			int alt23 = 4;
			int LA23_0 = input.LA(1);

			if (((LA23_0 >= '0' && LA23_0 <= '3'))) {
				int LA23_1 = input.LA(2);

				if (((LA23_1 >= '0' && LA23_1 <= '7'))) {
					int LA23_4 = input.LA(3);

					if (((LA23_4 >= '0' && LA23_4 <= '7'))) {
						alt23 = 4;
					} else {
						alt23 = 2;
					}
				} else {
					alt23 = 1;
				}
			} else if (((LA23_0 >= '4' && LA23_0 <= '7'))) {
				int LA23_2 = input.LA(2);

				if (((LA23_2 >= '0' && LA23_2 <= '7'))) {
					alt23 = 3;
				} else {
					alt23 = 1;
				}
			} else {
				NoViableAltException nvae = new NoViableAltException("", 23, 0,
						input);

				throw nvae;
			}
			switch (alt23) {
			case 1:
				// ES3.g:791:4: OctalDigit
			{
				mOctalDigit();

			}
				break;
			case 2:
				// ES3.g:792:4: ZeroToThree OctalDigit
			{
				mZeroToThree();
				mOctalDigit();

			}
				break;
			case 3:
				// ES3.g:793:4: '4' .. '7' OctalDigit
			{
				matchRange('4', '7');
				mOctalDigit();

			}
				break;
			case 4:
				// ES3.g:794:4: ZeroToThree OctalDigit OctalDigit
			{
				mZeroToThree();
				mOctalDigit();
				mOctalDigit();

			}
				break;

			}
		} finally {
		}
	}

	// $ANTLR end "OctalEscapeSequence"

	// $ANTLR start "HexEscapeSequence"
	public final void mHexEscapeSequence() throws RecognitionException {
		try {
			// ES3.g:798:2: ( 'x' HexDigit HexDigit )
			// ES3.g:798:4: 'x' HexDigit HexDigit
			{
				match('x');
				mHexDigit();
				mHexDigit();

			}

		} finally {
		}
	}

	// $ANTLR end "HexEscapeSequence"

	// $ANTLR start "UnicodeEscapeSequence"
	public final void mUnicodeEscapeSequence() throws RecognitionException {
		try {
			// ES3.g:802:2: ( 'u' HexDigit HexDigit HexDigit HexDigit )
			// ES3.g:802:4: 'u' HexDigit HexDigit HexDigit HexDigit
			{
				match('u');
				mHexDigit();
				mHexDigit();
				mHexDigit();
				mHexDigit();

			}

		} finally {
		}
	}

	// $ANTLR end "UnicodeEscapeSequence"

	// $ANTLR start "EscapeSequence"
	public final void mEscapeSequence() throws RecognitionException {
		String es = null;

		try {
			// ES3.g:806:2: ( BSLASH ( CharacterEscapeSequence |
			// OctalEscapeSequence | HexEscapeSequence | UnicodeEscapeSequence )
			// )
			// ES3.g:807:2: BSLASH ( CharacterEscapeSequence |
			// OctalEscapeSequence | HexEscapeSequence | UnicodeEscapeSequence )
			{
				mBSLASH();
				// ES3.g:808:2: ( CharacterEscapeSequence | OctalEscapeSequence
				// | HexEscapeSequence | UnicodeEscapeSequence )
				int alt24 = 4;
				int LA24_0 = input.LA(1);

				if (((LA24_0 >= '\u0000' && LA24_0 <= '\t')
						|| (LA24_0 >= '\u000B' && LA24_0 <= '\f')
						|| (LA24_0 >= '\u000E' && LA24_0 <= '/')
						|| (LA24_0 >= ':' && LA24_0 <= 't')
						|| (LA24_0 >= 'v' && LA24_0 <= 'w')
						|| (LA24_0 >= 'y' && LA24_0 <= '\u2027') || (LA24_0 >= '\u202A' && LA24_0 <= '\uFFFF'))) {
					alt24 = 1;
				} else if (((LA24_0 >= '0' && LA24_0 <= '7'))) {
					alt24 = 2;
				} else if ((LA24_0 == 'x')) {
					alt24 = 3;
				} else if ((LA24_0 == 'u')) {
					alt24 = 4;
				} else {
					NoViableAltException nvae = new NoViableAltException("",
							24, 0, input);

					throw nvae;
				}
				switch (alt24) {
				case 1:
					// ES3.g:809:3: CharacterEscapeSequence
				{
					mCharacterEscapeSequence();

				}
					break;
				case 2:
					// ES3.g:810:5: OctalEscapeSequence
				{
					mOctalEscapeSequence();

				}
					break;
				case 3:
					// ES3.g:811:5: HexEscapeSequence
				{
					mHexEscapeSequence();

				}
					break;
				case 4:
					// ES3.g:812:5: UnicodeEscapeSequence
				{
					mUnicodeEscapeSequence();

				}
					break;

				}

			}

		} finally {
		}
	}

	// $ANTLR end "EscapeSequence"

	// $ANTLR start "StringLiteral"
	public final void mStringLiteral() throws RecognitionException {
		try {
			int _type = StringLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			Token st = null;
			List list_st = null;
			// ES3.g:817:2: ( SQUOTE (st+= (~ ( SQUOTE | BSLASH | LineTerminator
			// ) | EscapeSequence ) )* SQUOTE | DQUOTE (st+= (~ ( DQUOTE |
			// BSLASH | LineTerminator ) | EscapeSequence ) )* DQUOTE )
			int alt29 = 2;
			int LA29_0 = input.LA(1);

			if ((LA29_0 == '\'')) {
				alt29 = 1;
			} else if ((LA29_0 == '\"')) {
				alt29 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 29, 0,
						input);

				throw nvae;
			}
			switch (alt29) {
			case 1:
				// ES3.g:817:4: SQUOTE (st+= (~ ( SQUOTE | BSLASH |
				// LineTerminator ) | EscapeSequence ) )* SQUOTE
			{
				mSQUOTE();
				// ES3.g:817:13: (st+= (~ ( SQUOTE | BSLASH | LineTerminator ) |
				// EscapeSequence ) )*
				loop26: do {
					int alt26 = 2;
					int LA26_0 = input.LA(1);

					if (((LA26_0 >= '\u0000' && LA26_0 <= '\t')
							|| (LA26_0 >= '\u000B' && LA26_0 <= '\f')
							|| (LA26_0 >= '\u000E' && LA26_0 <= '&')
							|| (LA26_0 >= '(' && LA26_0 <= '\u2027') || (LA26_0 >= '\u202A' && LA26_0 <= '\uFFFF'))) {
						alt26 = 1;
					}

					switch (alt26) {
					case 1:
						// ES3.g:817:13: st+= (~ ( SQUOTE | BSLASH |
						// LineTerminator ) | EscapeSequence )
					{
						// ES3.g:817:15: (~ ( SQUOTE | BSLASH | LineTerminator )
						// | EscapeSequence )
						int alt25 = 2;
						int LA25_0 = input.LA(1);

						if (((LA25_0 >= '\u0000' && LA25_0 <= '\t')
								|| (LA25_0 >= '\u000B' && LA25_0 <= '\f')
								|| (LA25_0 >= '\u000E' && LA25_0 <= '&')
								|| (LA25_0 >= '(' && LA25_0 <= '[')
								|| (LA25_0 >= ']' && LA25_0 <= '\u2027') || (LA25_0 >= '\u202A' && LA25_0 <= '\uFFFF'))) {
							alt25 = 1;
						} else if ((LA25_0 == '\\')) {
							alt25 = 2;
						} else {
							NoViableAltException nvae = new NoViableAltException(
									"", 25, 0, input);

							throw nvae;
						}
						switch (alt25) {
						case 1:
							// ES3.g:817:17: ~ ( SQUOTE | BSLASH |
							// LineTerminator )
						{
							if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t')
									|| (input.LA(1) >= '\u000B' && input.LA(1) <= '\f')
									|| (input.LA(1) >= '\u000E' && input.LA(1) <= '&')
									|| (input.LA(1) >= '(' && input.LA(1) <= '[')
									|| (input.LA(1) >= ']' && input.LA(1) <= '\u2027')
									|| (input.LA(1) >= '\u202A' && input.LA(1) <= '\uFFFF')) {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(
										null, input);
								recover(mse);
								throw mse;
							}

						}
							break;
						case 2:
							// ES3.g:817:57: EscapeSequence
						{
							mEscapeSequence();

						}
							break;

						}

					}
						break;

					default:
						break loop26;
					}
				} while (true);

				mSQUOTE();

			}
				break;
			case 2:
				// ES3.g:818:4: DQUOTE (st+= (~ ( DQUOTE | BSLASH |
				// LineTerminator ) | EscapeSequence ) )* DQUOTE
			{
				mDQUOTE();
				// ES3.g:818:13: (st+= (~ ( DQUOTE | BSLASH | LineTerminator ) |
				// EscapeSequence ) )*
				loop28: do {
					int alt28 = 2;
					int LA28_0 = input.LA(1);

					if (((LA28_0 >= '\u0000' && LA28_0 <= '\t')
							|| (LA28_0 >= '\u000B' && LA28_0 <= '\f')
							|| (LA28_0 >= '\u000E' && LA28_0 <= '!')
							|| (LA28_0 >= '#' && LA28_0 <= '\u2027') || (LA28_0 >= '\u202A' && LA28_0 <= '\uFFFF'))) {
						alt28 = 1;
					}

					switch (alt28) {
					case 1:
						// ES3.g:818:13: st+= (~ ( DQUOTE | BSLASH |
						// LineTerminator ) | EscapeSequence )
					{
						// ES3.g:818:15: (~ ( DQUOTE | BSLASH | LineTerminator )
						// | EscapeSequence )
						int alt27 = 2;
						int LA27_0 = input.LA(1);

						if (((LA27_0 >= '\u0000' && LA27_0 <= '\t')
								|| (LA27_0 >= '\u000B' && LA27_0 <= '\f')
								|| (LA27_0 >= '\u000E' && LA27_0 <= '!')
								|| (LA27_0 >= '#' && LA27_0 <= '[')
								|| (LA27_0 >= ']' && LA27_0 <= '\u2027') || (LA27_0 >= '\u202A' && LA27_0 <= '\uFFFF'))) {
							alt27 = 1;
						} else if ((LA27_0 == '\\')) {
							alt27 = 2;
						} else {
							NoViableAltException nvae = new NoViableAltException(
									"", 27, 0, input);

							throw nvae;
						}
						switch (alt27) {
						case 1:
							// ES3.g:818:17: ~ ( DQUOTE | BSLASH |
							// LineTerminator )
						{
							if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t')
									|| (input.LA(1) >= '\u000B' && input.LA(1) <= '\f')
									|| (input.LA(1) >= '\u000E' && input.LA(1) <= '!')
									|| (input.LA(1) >= '#' && input.LA(1) <= '[')
									|| (input.LA(1) >= ']' && input.LA(1) <= '\u2027')
									|| (input.LA(1) >= '\u202A' && input.LA(1) <= '\uFFFF')) {
								input.consume();

							} else {
								MismatchedSetException mse = new MismatchedSetException(
										null, input);
								recover(mse);
								throw mse;
							}

						}
							break;
						case 2:
							// ES3.g:818:57: EscapeSequence
						{
							mEscapeSequence();

						}
							break;

						}

					}
						break;

					default:
						break loop28;
					}
				} while (true);

				mDQUOTE();

			}
				break;

			}
			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "StringLiteral"

	// $ANTLR start "BackslashSequence"
	public final void mBackslashSequence() throws RecognitionException {
		try {
			// ES3.g:826:2: ( BSLASH ~ ( LineTerminator ) )
			// ES3.g:826:4: BSLASH ~ ( LineTerminator )
			{
				mBSLASH();
				if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t')
						|| (input.LA(1) >= '\u000B' && input.LA(1) <= '\f')
						|| (input.LA(1) >= '\u000E' && input.LA(1) <= '\u2027')
						|| (input.LA(1) >= '\u202A' && input.LA(1) <= '\uFFFF')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recover(mse);
					throw mse;
				}

			}

		} finally {
		}
	}

	// $ANTLR end "BackslashSequence"

	// $ANTLR start "RegularExpressionFirstChar"
	public final void mRegularExpressionFirstChar() throws RecognitionException {
		try {
			// ES3.g:830:2: (~ ( LineTerminator | MUL | BSLASH | DIV ) |
			// BackslashSequence )
			int alt30 = 2;
			int LA30_0 = input.LA(1);

			if (((LA30_0 >= '\u0000' && LA30_0 <= '\t')
					|| (LA30_0 >= '\u000B' && LA30_0 <= '\f')
					|| (LA30_0 >= '\u000E' && LA30_0 <= ')')
					|| (LA30_0 >= '+' && LA30_0 <= '.')
					|| (LA30_0 >= '0' && LA30_0 <= '[')
					|| (LA30_0 >= ']' && LA30_0 <= '\u2027') || (LA30_0 >= '\u202A' && LA30_0 <= '\uFFFF'))) {
				alt30 = 1;
			} else if ((LA30_0 == '\\')) {
				alt30 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 30, 0,
						input);

				throw nvae;
			}
			switch (alt30) {
			case 1:
				// ES3.g:830:4: ~ ( LineTerminator | MUL | BSLASH | DIV )
			{
				if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t')
						|| (input.LA(1) >= '\u000B' && input.LA(1) <= '\f')
						|| (input.LA(1) >= '\u000E' && input.LA(1) <= ')')
						|| (input.LA(1) >= '+' && input.LA(1) <= '.')
						|| (input.LA(1) >= '0' && input.LA(1) <= '[')
						|| (input.LA(1) >= ']' && input.LA(1) <= '\u2027')
						|| (input.LA(1) >= '\u202A' && input.LA(1) <= '\uFFFF')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recover(mse);
					throw mse;
				}

			}
				break;
			case 2:
				// ES3.g:831:4: BackslashSequence
			{
				mBackslashSequence();

			}
				break;

			}
		} finally {
		}
	}

	// $ANTLR end "RegularExpressionFirstChar"

	// $ANTLR start "RegularExpressionChar"
	public final void mRegularExpressionChar() throws RecognitionException {
		try {
			// ES3.g:835:2: (~ ( LineTerminator | BSLASH | DIV ) |
			// BackslashSequence )
			int alt31 = 2;
			int LA31_0 = input.LA(1);

			if (((LA31_0 >= '\u0000' && LA31_0 <= '\t')
					|| (LA31_0 >= '\u000B' && LA31_0 <= '\f')
					|| (LA31_0 >= '\u000E' && LA31_0 <= '.')
					|| (LA31_0 >= '0' && LA31_0 <= '[')
					|| (LA31_0 >= ']' && LA31_0 <= '\u2027') || (LA31_0 >= '\u202A' && LA31_0 <= '\uFFFF'))) {
				alt31 = 1;
			} else if ((LA31_0 == '\\')) {
				alt31 = 2;
			} else {
				NoViableAltException nvae = new NoViableAltException("", 31, 0,
						input);

				throw nvae;
			}
			switch (alt31) {
			case 1:
				// ES3.g:835:4: ~ ( LineTerminator | BSLASH | DIV )
			{
				if ((input.LA(1) >= '\u0000' && input.LA(1) <= '\t')
						|| (input.LA(1) >= '\u000B' && input.LA(1) <= '\f')
						|| (input.LA(1) >= '\u000E' && input.LA(1) <= '.')
						|| (input.LA(1) >= '0' && input.LA(1) <= '[')
						|| (input.LA(1) >= ']' && input.LA(1) <= '\u2027')
						|| (input.LA(1) >= '\u202A' && input.LA(1) <= '\uFFFF')) {
					input.consume();

				} else {
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					recover(mse);
					throw mse;
				}

			}
				break;
			case 2:
				// ES3.g:836:4: BackslashSequence
			{
				mBackslashSequence();

			}
				break;

			}
		} finally {
		}
	}

	// $ANTLR end "RegularExpressionChar"

	// $ANTLR start "RegularExpressionLiteral"
	public final void mRegularExpressionLiteral() throws RecognitionException {
		try {
			int _type = RegularExpressionLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ES3.g:840:2: ({...}? => DIV RegularExpressionFirstChar (
			// RegularExpressionChar )* DIV ( IdentifierPart )* )
			// ES3.g:840:4: {...}? => DIV RegularExpressionFirstChar (
			// RegularExpressionChar )* DIV ( IdentifierPart )*
			{
				if (!((areRegularExpressionsEnabled()))) {
					throw new FailedPredicateException(input,
							"RegularExpressionLiteral",
							" areRegularExpressionsEnabled() ");
				}
				mDIV();
				mRegularExpressionFirstChar();
				// ES3.g:840:73: ( RegularExpressionChar )*
				loop32: do {
					int alt32 = 2;
					int LA32_0 = input.LA(1);

					if (((LA32_0 >= '\u0000' && LA32_0 <= '\t')
							|| (LA32_0 >= '\u000B' && LA32_0 <= '\f')
							|| (LA32_0 >= '\u000E' && LA32_0 <= '.')
							|| (LA32_0 >= '0' && LA32_0 <= '\u2027') || (LA32_0 >= '\u202A' && LA32_0 <= '\uFFFF'))) {
						alt32 = 1;
					}

					switch (alt32) {
					case 1:
						// ES3.g:840:73: RegularExpressionChar
					{
						mRegularExpressionChar();

					}
						break;

					default:
						break loop32;
					}
				} while (true);

				mDIV();
				// ES3.g:840:100: ( IdentifierPart )*
				loop33: do {
					int alt33 = 2;
					int LA33_0 = input.LA(1);

					if ((LA33_0 == '$' || (LA33_0 >= '0' && LA33_0 <= '9')
							|| (LA33_0 >= 'A' && LA33_0 <= 'Z')
							|| LA33_0 == '\\' || LA33_0 == '_' || (LA33_0 >= 'a' && LA33_0 <= 'z'))) {
						alt33 = 1;
					} else if (((isIdentifierPartUnicode(input.LA(1))))) {
						alt33 = 1;
					}

					switch (alt33) {
					case 1:
						// ES3.g:840:100: IdentifierPart
					{
						mIdentifierPart();

					}
						break;

					default:
						break loop33;
					}
				} while (true);

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
		}
	}

	// $ANTLR end "RegularExpressionLiteral"

	public void mTokens() throws RecognitionException {
		// ES3.g:1:8: ( NULL | TRUE | FALSE | BREAK | CASE | CATCH | CONTINUE |
		// DEFAULT | DELETE | DO | ELSE | FINALLY | FOR | FUNCTION | IF | IN |
		// INSTANCEOF | NEW | RETURN | SWITCH | THIS | THROW | TRY | TYPEOF |
		// VAR | VOID | WHILE | WITH | EACH | ABSTRACT | BOOLEAN | BYTE | CHAR |
		// CLASS | CONST | DEBUGGER | DOUBLE | ENUM | EXPORT | EXTENDS | FINAL |
		// FLOAT | GOTO | IMPLEMENTS | IMPORT | INT | INTERFACE | LONG | NATIVE
		// | PACKAGE | SHORT | STATIC | SUPER | SYNCHRONIZED | THROWS |
		// TRANSIENT | VOLATILE | LBRACE | RBRACE | LPAREN | RPAREN | LBRACK |
		// RBRACK | DOT | SEMIC | COMMA | LT | GT | LTE | GTE | EQ | NEQ | SAME
		// | NSAME | ADD | SUB | MUL | MOD | INC | DEC | SHL | SHR | SHU | AND |
		// OR | XOR | NOT | INV | LAND | LOR | QUE | COLON | ASSIGN | ADDASS |
		// SUBASS | MULASS | MODASS | SHLASS | SHRASS | SHUASS | ANDASS | ORASS
		// | XORASS | DIV | DIVASS | WhiteSpace | EOL | MultiLineComment |
		// SingleLineComment | Identifier | DecimalLiteral | OctalIntegerLiteral
		// | HexIntegerLiteral | StringLiteral | RegularExpressionLiteral )
		int alt34 = 115;
		alt34 = dfa34.predict(input);
		switch (alt34) {
		case 1:
			// ES3.g:1:10: NULL
		{
			mNULL();

		}
			break;
		case 2:
			// ES3.g:1:15: TRUE
		{
			mTRUE();

		}
			break;
		case 3:
			// ES3.g:1:20: FALSE
		{
			mFALSE();

		}
			break;
		case 4:
			// ES3.g:1:26: BREAK
		{
			mBREAK();

		}
			break;
		case 5:
			// ES3.g:1:32: CASE
		{
			mCASE();

		}
			break;
		case 6:
			// ES3.g:1:37: CATCH
		{
			mCATCH();

		}
			break;
		case 7:
			// ES3.g:1:43: CONTINUE
		{
			mCONTINUE();

		}
			break;
		case 8:
			// ES3.g:1:52: DEFAULT
		{
			mDEFAULT();

		}
			break;
		case 9:
			// ES3.g:1:60: DELETE
		{
			mDELETE();

		}
			break;
		case 10:
			// ES3.g:1:67: DO
		{
			mDO();

		}
			break;
		case 11:
			// ES3.g:1:70: ELSE
		{
			mELSE();

		}
			break;
		case 12:
			// ES3.g:1:75: FINALLY
		{
			mFINALLY();

		}
			break;
		case 13:
			// ES3.g:1:83: FOR
		{
			mFOR();

		}
			break;
		case 14:
			// ES3.g:1:87: FUNCTION
		{
			mFUNCTION();

		}
			break;
		case 15:
			// ES3.g:1:96: IF
		{
			mIF();

		}
			break;
		case 16:
			// ES3.g:1:99: IN
		{
			mIN();

		}
			break;
		case 17:
			// ES3.g:1:102: INSTANCEOF
		{
			mINSTANCEOF();

		}
			break;
		case 18:
			// ES3.g:1:113: NEW
		{
			mNEW();

		}
			break;
		case 19:
			// ES3.g:1:117: RETURN
		{
			mRETURN();

		}
			break;
		case 20:
			// ES3.g:1:124: SWITCH
		{
			mSWITCH();

		}
			break;
		case 21:
			// ES3.g:1:131: THIS
		{
			mTHIS();

		}
			break;
		case 22:
			// ES3.g:1:136: THROW
		{
			mTHROW();

		}
			break;
		case 23:
			// ES3.g:1:142: TRY
		{
			mTRY();

		}
			break;
		case 24:
			// ES3.g:1:146: TYPEOF
		{
			mTYPEOF();

		}
			break;
		case 25:
			// ES3.g:1:153: VAR
		{
			mVAR();

		}
			break;
		case 26:
			// ES3.g:1:157: VOID
		{
			mVOID();

		}
			break;
		case 27:
			// ES3.g:1:162: WHILE
		{
			mWHILE();

		}
			break;
		case 28:
			// ES3.g:1:168: WITH
		{
			mWITH();

		}
			break;
		case 29:
			// ES3.g:1:173: EACH
		{
			mEACH();

		}
			break;
		case 30:
			// ES3.g:1:178: ABSTRACT
		{
			mABSTRACT();

		}
			break;
		case 31:
			// ES3.g:1:187: BOOLEAN
		{
			mBOOLEAN();

		}
			break;
		case 32:
			// ES3.g:1:195: BYTE
		{
			mBYTE();

		}
			break;
		case 33:
			// ES3.g:1:200: CHAR
		{
			mCHAR();

		}
			break;
		case 34:
			// ES3.g:1:205: CLASS
		{
			mCLASS();

		}
			break;
		case 35:
			// ES3.g:1:211: CONST
		{
			mCONST();

		}
			break;
		case 36:
			// ES3.g:1:217: DEBUGGER
		{
			mDEBUGGER();

		}
			break;
		case 37:
			// ES3.g:1:226: DOUBLE
		{
			mDOUBLE();

		}
			break;
		case 38:
			// ES3.g:1:233: ENUM
		{
			mENUM();

		}
			break;
		case 39:
			// ES3.g:1:238: EXPORT
		{
			mEXPORT();

		}
			break;
		case 40:
			// ES3.g:1:245: EXTENDS
		{
			mEXTENDS();

		}
			break;
		case 41:
			// ES3.g:1:253: FINAL
		{
			mFINAL();

		}
			break;
		case 42:
			// ES3.g:1:259: FLOAT
		{
			mFLOAT();

		}
			break;
		case 43:
			// ES3.g:1:265: GOTO
		{
			mGOTO();

		}
			break;
		case 44:
			// ES3.g:1:270: IMPLEMENTS
		{
			mIMPLEMENTS();

		}
			break;
		case 45:
			// ES3.g:1:281: IMPORT
		{
			mIMPORT();

		}
			break;
		case 46:
			// ES3.g:1:288: INT
		{
			mINT();

		}
			break;
		case 47:
			// ES3.g:1:292: INTERFACE
		{
			mINTERFACE();

		}
			break;
		case 48:
			// ES3.g:1:302: LONG
		{
			mLONG();

		}
			break;
		case 49:
			// ES3.g:1:307: NATIVE
		{
			mNATIVE();

		}
			break;
		case 50:
			// ES3.g:1:314: PACKAGE
		{
			mPACKAGE();

		}
			break;
		case 51:
			// ES3.g:1:322: SHORT
		{
			mSHORT();

		}
			break;
		case 52:
			// ES3.g:1:328: STATIC
		{
			mSTATIC();

		}
			break;
		case 53:
			// ES3.g:1:335: SUPER
		{
			mSUPER();

		}
			break;
		case 54:
			// ES3.g:1:341: SYNCHRONIZED
		{
			mSYNCHRONIZED();

		}
			break;
		case 55:
			// ES3.g:1:354: THROWS
		{
			mTHROWS();

		}
			break;
		case 56:
			// ES3.g:1:361: TRANSIENT
		{
			mTRANSIENT();

		}
			break;
		case 57:
			// ES3.g:1:371: VOLATILE
		{
			mVOLATILE();

		}
			break;
		case 58:
			// ES3.g:1:380: LBRACE
		{
			mLBRACE();

		}
			break;
		case 59:
			// ES3.g:1:387: RBRACE
		{
			mRBRACE();

		}
			break;
		case 60:
			// ES3.g:1:394: LPAREN
		{
			mLPAREN();

		}
			break;
		case 61:
			// ES3.g:1:401: RPAREN
		{
			mRPAREN();

		}
			break;
		case 62:
			// ES3.g:1:408: LBRACK
		{
			mLBRACK();

		}
			break;
		case 63:
			// ES3.g:1:415: RBRACK
		{
			mRBRACK();

		}
			break;
		case 64:
			// ES3.g:1:422: DOT
		{
			mDOT();

		}
			break;
		case 65:
			// ES3.g:1:426: SEMIC
		{
			mSEMIC();

		}
			break;
		case 66:
			// ES3.g:1:432: COMMA
		{
			mCOMMA();

		}
			break;
		case 67:
			// ES3.g:1:438: LT
		{
			mLT();

		}
			break;
		case 68:
			// ES3.g:1:441: GT
		{
			mGT();

		}
			break;
		case 69:
			// ES3.g:1:444: LTE
		{
			mLTE();

		}
			break;
		case 70:
			// ES3.g:1:448: GTE
		{
			mGTE();

		}
			break;
		case 71:
			// ES3.g:1:452: EQ
		{
			mEQ();

		}
			break;
		case 72:
			// ES3.g:1:455: NEQ
		{
			mNEQ();

		}
			break;
		case 73:
			// ES3.g:1:459: SAME
		{
			mSAME();

		}
			break;
		case 74:
			// ES3.g:1:464: NSAME
		{
			mNSAME();

		}
			break;
		case 75:
			// ES3.g:1:470: ADD
		{
			mADD();

		}
			break;
		case 76:
			// ES3.g:1:474: SUB
		{
			mSUB();

		}
			break;
		case 77:
			// ES3.g:1:478: MUL
		{
			mMUL();

		}
			break;
		case 78:
			// ES3.g:1:482: MOD
		{
			mMOD();

		}
			break;
		case 79:
			// ES3.g:1:486: INC
		{
			mINC();

		}
			break;
		case 80:
			// ES3.g:1:490: DEC
		{
			mDEC();

		}
			break;
		case 81:
			// ES3.g:1:494: SHL
		{
			mSHL();

		}
			break;
		case 82:
			// ES3.g:1:498: SHR
		{
			mSHR();

		}
			break;
		case 83:
			// ES3.g:1:502: SHU
		{
			mSHU();

		}
			break;
		case 84:
			// ES3.g:1:506: AND
		{
			mAND();

		}
			break;
		case 85:
			// ES3.g:1:510: OR
		{
			mOR();

		}
			break;
		case 86:
			// ES3.g:1:513: XOR
		{
			mXOR();

		}
			break;
		case 87:
			// ES3.g:1:517: NOT
		{
			mNOT();

		}
			break;
		case 88:
			// ES3.g:1:521: INV
		{
			mINV();

		}
			break;
		case 89:
			// ES3.g:1:525: LAND
		{
			mLAND();

		}
			break;
		case 90:
			// ES3.g:1:530: LOR
		{
			mLOR();

		}
			break;
		case 91:
			// ES3.g:1:534: QUE
		{
			mQUE();

		}
			break;
		case 92:
			// ES3.g:1:538: COLON
		{
			mCOLON();

		}
			break;
		case 93:
			// ES3.g:1:544: ASSIGN
		{
			mASSIGN();

		}
			break;
		case 94:
			// ES3.g:1:551: ADDASS
		{
			mADDASS();

		}
			break;
		case 95:
			// ES3.g:1:558: SUBASS
		{
			mSUBASS();

		}
			break;
		case 96:
			// ES3.g:1:565: MULASS
		{
			mMULASS();

		}
			break;
		case 97:
			// ES3.g:1:572: MODASS
		{
			mMODASS();

		}
			break;
		case 98:
			// ES3.g:1:579: SHLASS
		{
			mSHLASS();

		}
			break;
		case 99:
			// ES3.g:1:586: SHRASS
		{
			mSHRASS();

		}
			break;
		case 100:
			// ES3.g:1:593: SHUASS
		{
			mSHUASS();

		}
			break;
		case 101:
			// ES3.g:1:600: ANDASS
		{
			mANDASS();

		}
			break;
		case 102:
			// ES3.g:1:607: ORASS
		{
			mORASS();

		}
			break;
		case 103:
			// ES3.g:1:613: XORASS
		{
			mXORASS();

		}
			break;
		case 104:
			// ES3.g:1:620: DIV
		{
			mDIV();

		}
			break;
		case 105:
			// ES3.g:1:624: DIVASS
		{
			mDIVASS();

		}
			break;
		case 106:
			// ES3.g:1:631: WhiteSpace
		{
			mWhiteSpace();

		}
			break;
		case 107:
			// ES3.g:1:642: EOL
		{
			mEOL();

		}
			break;
		case 108:
			// ES3.g:1:646: MultiLineComment
		{
			mMultiLineComment();

		}
			break;
		case 109:
			// ES3.g:1:663: SingleLineComment
		{
			mSingleLineComment();

		}
			break;
		case 110:
			// ES3.g:1:681: Identifier
		{
			mIdentifier();

		}
			break;
		case 111:
			// ES3.g:1:692: DecimalLiteral
		{
			mDecimalLiteral();

		}
			break;
		case 112:
			// ES3.g:1:707: OctalIntegerLiteral
		{
			mOctalIntegerLiteral();

		}
			break;
		case 113:
			// ES3.g:1:727: HexIntegerLiteral
		{
			mHexIntegerLiteral();

		}
			break;
		case 114:
			// ES3.g:1:745: StringLiteral
		{
			mStringLiteral();

		}
			break;
		case 115:
			// ES3.g:1:759: RegularExpressionLiteral
		{
			mRegularExpressionLiteral();

		}
			break;

		}

	}

	protected DFA19 dfa19 = new DFA19(this);
	protected DFA34 dfa34 = new DFA34(this);
	static final String DFA19_eotS = "\1\uffff\2\4\3\uffff\1\4";
	static final String DFA19_eofS = "\7\uffff";
	static final String DFA19_minS = "\3\56\3\uffff\1\56";
	static final String DFA19_maxS = "\1\71\1\56\1\71\3\uffff\1\71";
	static final String DFA19_acceptS = "\3\uffff\1\2\1\3\1\1\1\uffff";
	static final String DFA19_specialS = "\7\uffff}>";
	static final String[] DFA19_transitionS = { "\1\3\1\uffff\1\1\11\2",
			"\1\5", "\1\5\1\uffff\12\6", "", "", "", "\1\5\1\uffff\12\6" };

	static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
	static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
	static final char[] DFA19_min = DFA
			.unpackEncodedStringToUnsignedChars(DFA19_minS);
	static final char[] DFA19_max = DFA
			.unpackEncodedStringToUnsignedChars(DFA19_maxS);
	static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
	static final short[] DFA19_special = DFA
			.unpackEncodedString(DFA19_specialS);
	static final short[][] DFA19_transition;

	static {
		int numStates = DFA19_transitionS.length;
		DFA19_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
		}
	}

	class DFA19 extends DFA {

		public DFA19(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 19;
			this.eot = DFA19_eot;
			this.eof = DFA19_eof;
			this.min = DFA19_min;
			this.max = DFA19_max;
			this.accept = DFA19_accept;
			this.special = DFA19_special;
			this.transition = DFA19_transition;
		}

		public String getDescription() {
			return "753:1: DecimalLiteral : ( DecimalIntegerLiteral '.' ( DecimalDigit )* ( ExponentPart )? | '.' ( DecimalDigit )+ ( ExponentPart )? | DecimalIntegerLiteral ( ExponentPart )? );";
		}
	}

	static final String DFA34_eotS = "\21\53\6\uffff\1\130\2\uffff\1\133\1\136\1\140\1\142\1\145\1\150"
			+ "\1\152\1\154\1\157\1\162\1\164\3\uffff\1\170\3\uffff\1\55\2\uffff"
			+ "\23\53\1\u0096\4\53\1\u009c\1\u009f\17\53\2\uffff\1\u00b1\2\uffff"
			+ "\1\u00b4\1\uffff\1\u00b6\1\uffff\1\u00b8\23\uffff\1\u00b9\6\uffff"
			+ "\1\53\1\u00bb\2\53\1\u00be\6\53\1\u00c5\16\53\1\uffff\5\53\1\uffff"
			+ "\1\53\1\u00dc\1\uffff\7\53\1\u00e5\10\53\2\uffff\1\u00ef\7\uffff"
			+ "\1\u00f0\1\uffff\1\53\1\u00f2\1\uffff\1\53\1\u00f4\4\53\1\uffff"
			+ "\4\53\1\u00fd\1\u00fe\3\53\1\u0102\5\53\1\u0108\1\u0109\1\u010a"
			+ "\4\53\1\uffff\10\53\1\uffff\1\u0117\2\53\1\u011a\1\53\1\u011c\1"
			+ "\u011d\1\53\3\uffff\1\53\1\uffff\1\53\1\uffff\1\u0122\1\53\1\u0124"
			+ "\1\u0126\1\53\1\u0128\1\u0129\1\53\2\uffff\1\u012b\1\53\1\u012d"
			+ "\1\uffff\1\u012e\4\53\3\uffff\10\53\1\u013b\1\53\1\u013d\1\53\1"
			+ "\uffff\1\53\1\u0140\1\uffff\1\53\2\uffff\1\53\1\u0143\1\53\1\u0145"
			+ "\1\uffff\1\u0146\1\uffff\1\53\1\uffff\1\53\2\uffff\1\53\1\uffff"
			+ "\1\53\2\uffff\1\53\1\u014c\1\53\1\u014e\1\u014f\4\53\1\u0154\1\u0155"
			+ "\1\u0156\1\uffff\1\u0157\1\uffff\2\53\1\uffff\2\53\1\uffff\1\53"
			+ "\2\uffff\1\u015d\1\53\1\u015f\1\53\1\u0161\1\uffff\1\53\2\uffff"
			+ "\1\u0163\3\53\4\uffff\3\53\1\u016a\1\53\1\uffff\1\u016c\1\uffff"
			+ "\1\u016d\1\uffff\1\u016e\1\uffff\4\53\1\u0173\1\u0174\1\uffff\1"
			+ "\u0175\3\uffff\1\53\1\u0177\2\53\3\uffff\1\u017a\1\uffff\1\u017b"
			+ "\1\53\2\uffff\1\53\1\u017e\1\uffff";
	static final String DFA34_eofS = "\u017f\uffff";
	static final String DFA34_minS = "\1\11\1\141\1\150\1\141\1\157\1\141\1\145\1\141\1\146\1\145\1\150"
			+ "\1\141\1\150\1\142\2\157\1\141\6\uffff\1\60\2\uffff\1\74\3\75\1"
			+ "\53\1\55\2\75\1\46\2\75\3\uffff\1\0\3\uffff\1\60\2\uffff\1\154\1"
			+ "\167\1\164\1\141\1\151\1\160\1\154\1\156\1\162\1\156\1\157\1\145"
			+ "\1\157\1\164\1\163\1\156\2\141\1\142\1\44\1\163\1\143\1\165\1\160"
			+ "\2\44\1\160\1\164\1\151\1\157\1\141\1\160\1\156\1\162\2\151\1\164"
			+ "\1\163\1\164\1\156\1\143\2\uffff\1\75\2\uffff\1\75\1\uffff\1\75"
			+ "\1\uffff\1\75\23\uffff\1\0\6\uffff\1\154\1\44\1\151\1\145\1\44\1"
			+ "\156\1\163\1\157\1\145\1\163\1\141\1\44\1\143\2\141\1\154\2\145"
			+ "\1\143\1\163\1\162\1\163\1\141\1\145\1\165\1\142\1\uffff\1\145\1"
			+ "\150\1\155\1\157\1\145\1\uffff\1\164\1\44\1\uffff\1\154\1\165\1"
			+ "\164\1\162\1\164\1\145\1\143\1\44\1\144\1\141\1\154\1\150\1\164"
			+ "\1\157\1\147\1\153\2\uffff\1\75\7\uffff\1\44\1\uffff\1\166\1\44"
			+ "\1\uffff\1\163\1\44\1\167\1\157\1\145\1\154\1\uffff\2\164\1\153"
			+ "\1\145\2\44\1\150\1\151\1\164\1\44\1\163\1\165\1\164\1\147\1\154"
			+ "\3\44\1\162\1\156\1\141\1\162\1\uffff\1\145\2\162\1\143\1\164\1"
			+ "\151\1\162\1\150\1\uffff\1\44\1\164\1\145\1\44\1\162\2\44\1\141"
			+ "\3\uffff\1\145\1\uffff\1\151\1\uffff\1\44\1\146\2\44\1\151\2\44"
			+ "\1\141\2\uffff\1\44\1\156\1\44\1\uffff\1\44\1\154\1\145\1\147\1"
			+ "\145\3\uffff\1\164\1\144\1\156\1\146\1\155\1\164\1\156\1\150\1\44"
			+ "\1\143\1\44\1\162\1\uffff\1\151\1\44\1\uffff\1\141\2\uffff\1\147"
			+ "\1\44\1\145\1\44\1\uffff\1\44\1\uffff\1\171\1\uffff\1\157\2\uffff"
			+ "\1\156\1\uffff\1\165\2\uffff\1\164\1\44\1\145\2\44\1\163\1\143\1"
			+ "\141\1\145\3\44\1\uffff\1\44\1\uffff\1\157\1\154\1\uffff\1\143\1"
			+ "\145\1\uffff\1\156\2\uffff\1\44\1\156\1\44\1\145\1\44\1\uffff\1"
			+ "\162\2\uffff\1\44\1\145\1\143\1\156\4\uffff\1\156\1\145\1\164\1"
			+ "\44\1\164\1\uffff\1\44\1\uffff\1\44\1\uffff\1\44\1\uffff\1\157\1"
			+ "\145\1\164\1\151\2\44\1\uffff\1\44\3\uffff\1\146\1\44\1\163\1\172"
			+ "\3\uffff\1\44\1\uffff\1\44\1\145\2\uffff\1\144\1\44\1\uffff";
	static final String DFA34_maxS = "\1\u3000\1\165\1\171\1\165\1\171\2\157\1\170\1\156\1\145\1\171\1"
			+ "\157\1\151\1\142\2\157\1\141\6\uffff\1\71\2\uffff\1\75\1\76\7\75"
			+ "\1\174\1\75\3\uffff\1\uffff\3\uffff\1\170\2\uffff\1\154\1\167\1"
			+ "\164\1\171\1\162\1\160\1\154\1\156\1\162\1\156\1\157\1\145\1\157"
			+ "\2\164\1\156\2\141\1\154\1\172\1\163\1\143\1\165\1\164\2\172\1\160"
			+ "\1\164\1\151\1\157\1\141\1\160\1\156\1\162\1\154\1\151\1\164\1\163"
			+ "\1\164\1\156\1\143\2\uffff\1\75\2\uffff\1\76\1\uffff\1\75\1\uffff"
			+ "\1\75\23\uffff\1\uffff\6\uffff\1\154\1\172\1\151\1\145\1\172\1\156"
			+ "\1\163\1\157\1\145\1\163\1\141\1\172\1\143\2\141\1\154\2\145\1\143"
			+ "\1\164\1\162\1\163\1\141\1\145\1\165\1\142\1\uffff\1\145\1\150\1"
			+ "\155\1\157\1\145\1\uffff\1\164\1\172\1\uffff\1\157\1\165\1\164\1"
			+ "\162\1\164\1\145\1\143\1\172\1\144\1\141\1\154\1\150\1\164\1\157"
			+ "\1\147\1\153\2\uffff\1\75\7\uffff\1\172\1\uffff\1\166\1\172\1\uffff"
			+ "\1\163\1\172\1\167\1\157\1\145\1\154\1\uffff\2\164\1\153\1\145\2"
			+ "\172\1\150\1\151\1\164\1\172\1\163\1\165\1\164\1\147\1\154\3\172"
			+ "\1\162\1\156\1\141\1\162\1\uffff\1\145\2\162\1\143\1\164\1\151\1"
			+ "\162\1\150\1\uffff\1\172\1\164\1\145\1\172\1\162\2\172\1\141\3\uffff"
			+ "\1\145\1\uffff\1\151\1\uffff\1\172\1\146\2\172\1\151\2\172\1\141"
			+ "\2\uffff\1\172\1\156\1\172\1\uffff\1\172\1\154\1\145\1\147\1\145"
			+ "\3\uffff\1\164\1\144\1\156\1\146\1\155\1\164\1\156\1\150\1\172\1"
			+ "\143\1\172\1\162\1\uffff\1\151\1\172\1\uffff\1\141\2\uffff\1\147"
			+ "\1\172\1\145\1\172\1\uffff\1\172\1\uffff\1\171\1\uffff\1\157\2\uffff"
			+ "\1\156\1\uffff\1\165\2\uffff\1\164\1\172\1\145\2\172\1\163\1\143"
			+ "\1\141\1\145\3\172\1\uffff\1\172\1\uffff\1\157\1\154\1\uffff\1\143"
			+ "\1\145\1\uffff\1\156\2\uffff\1\172\1\156\1\172\1\145\1\172\1\uffff"
			+ "\1\162\2\uffff\1\172\1\145\1\143\1\156\4\uffff\1\156\1\145\1\164"
			+ "\1\172\1\164\1\uffff\1\172\1\uffff\1\172\1\uffff\1\172\1\uffff\1"
			+ "\157\1\145\1\164\1\151\2\172\1\uffff\1\172\3\uffff\1\146\1\172\1"
			+ "\163\1\172\3\uffff\1\172\1\uffff\1\172\1\145\2\uffff\1\144\1\172"
			+ "\1\uffff";
	static final String DFA34_acceptS = "\21\uffff\1\72\1\73\1\74\1\75\1\76\1\77\1\uffff\1\101\1\102\13\uffff"
			+ "\1\130\1\133\1\134\1\uffff\1\152\1\153\1\156\1\uffff\1\157\1\162"
			+ "\51\uffff\1\100\1\105\1\uffff\1\103\1\106\1\uffff\1\104\1\uffff"
			+ "\1\135\1\uffff\1\127\1\117\1\136\1\113\1\120\1\137\1\114\1\140\1"
			+ "\115\1\141\1\116\1\131\1\145\1\124\1\132\1\146\1\125\1\147\1\126"
			+ "\1\uffff\1\154\1\155\1\150\1\163\1\161\1\160\32\uffff\1\12\5\uffff"
			+ "\1\17\2\uffff\1\20\20\uffff\1\142\1\121\1\uffff\1\143\1\122\1\111"
			+ "\1\107\1\112\1\110\1\151\1\uffff\1\22\2\uffff\1\27\6\uffff\1\15"
			+ "\26\uffff\1\56\10\uffff\1\31\10\uffff\1\144\1\123\1\1\1\uffff\1"
			+ "\2\1\uffff\1\25\10\uffff\1\40\1\5\3\uffff\1\41\5\uffff\1\13\1\35"
			+ "\1\46\14\uffff\1\32\2\uffff\1\34\1\uffff\1\53\1\60\4\uffff\1\26"
			+ "\1\uffff\1\3\1\uffff\1\51\1\uffff\1\52\1\4\1\uffff\1\6\1\uffff\1"
			+ "\43\1\42\14\uffff\1\63\1\uffff\1\65\2\uffff\1\33\2\uffff\1\61\1"
			+ "\uffff\1\67\1\30\5\uffff\1\11\1\uffff\1\45\1\47\4\uffff\1\55\1\23"
			+ "\1\24\1\64\5\uffff\1\14\1\uffff\1\37\1\uffff\1\10\1\uffff\1\50\6"
			+ "\uffff\1\62\1\uffff\1\16\1\7\1\44\4\uffff\1\71\1\36\1\70\1\uffff"
			+ "\1\57\2\uffff\1\21\1\54\2\uffff\1\66";
	static final String DFA34_specialS = "\50\uffff\1\0\114\uffff\1\1\u0109\uffff}>";
	static final String[] DFA34_transitionS = {
			"\1\51\1\52\2\51\1\52\22\uffff\1\51\1\35\1\56\2\uffff\1\41\1"
					+ "\42\1\56\1\23\1\24\1\40\1\36\1\31\1\37\1\27\1\50\1\54\11\55"
					+ "\1\47\1\30\1\32\1\34\1\33\1\46\33\uffff\1\25\1\uffff\1\26\1"
					+ "\44\2\uffff\1\15\1\4\1\5\1\6\1\7\1\3\1\16\1\uffff\1\10\2\uffff"
					+ "\1\17\1\uffff\1\1\1\uffff\1\20\1\uffff\1\11\1\12\1\2\1\uffff"
					+ "\1\13\1\14\3\uffff\1\21\1\43\1\22\1\45\41\uffff\1\51\u15df\uffff"
					+ "\1\51\u018d\uffff\1\51\u07f1\uffff\13\51\35\uffff\2\52\5\uffff"
					+ "\1\51\57\uffff\1\51\u0fa0\uffff\1\51",
			"\1\61\3\uffff\1\60\17\uffff\1\57",
			"\1\63\11\uffff\1\62\6\uffff\1\64",
			"\1\65\7\uffff\1\66\2\uffff\1\71\2\uffff\1\67\5\uffff\1\70",
			"\1\73\2\uffff\1\72\6\uffff\1\74",
			"\1\75\6\uffff\1\77\3\uffff\1\100\2\uffff\1\76",
			"\1\101\11\uffff\1\102",
			"\1\104\12\uffff\1\103\1\uffff\1\105\11\uffff\1\106",
			"\1\107\6\uffff\1\111\1\110",
			"\1\112",
			"\1\114\13\uffff\1\115\1\116\1\uffff\1\113\1\uffff\1\117",
			"\1\120\15\uffff\1\121",
			"\1\122\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\55",
			"",
			"",
			"\1\132\1\131",
			"\1\134\1\135",
			"\1\137",
			"\1\141",
			"\1\143\21\uffff\1\144",
			"\1\146\17\uffff\1\147",
			"\1\151",
			"\1\153",
			"\1\155\26\uffff\1\156",
			"\1\161\76\uffff\1\160",
			"\1\163",
			"",
			"",
			"",
			"\12\171\1\uffff\2\171\1\uffff\34\171\1\166\4\171\1\167\15\171"
					+ "\1\165\u1fea\171\2\uffff\udfd6\171",
			"",
			"",
			"",
			"\10\173\40\uffff\1\172\37\uffff\1\172",
			"",
			"",
			"\1\174",
			"\1\175",
			"\1\176",
			"\1\u0081\23\uffff\1\177\3\uffff\1\u0080",
			"\1\u0082\10\uffff\1\u0083",
			"\1\u0084",
			"\1\u0085",
			"\1\u0086",
			"\1\u0087",
			"\1\u0088",
			"\1\u0089",
			"\1\u008a",
			"\1\u008b",
			"\1\u008c",
			"\1\u008d\1\u008e",
			"\1\u008f",
			"\1\u0090",
			"\1\u0091",
			"\1\u0094\3\uffff\1\u0092\5\uffff\1\u0093",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\24\53\1\u0095\5\53",
			"\1\u0097",
			"\1\u0098",
			"\1\u0099",
			"\1\u009a\3\uffff\1\u009b",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\22\53\1\u009d\1\u009e\6\53",
			"\1\u00a0",
			"\1\u00a1",
			"\1\u00a2",
			"\1\u00a3",
			"\1\u00a4",
			"\1\u00a5",
			"\1\u00a6",
			"\1\u00a7",
			"\1\u00a8\2\uffff\1\u00a9",
			"\1\u00aa",
			"\1\u00ab",
			"\1\u00ac",
			"\1\u00ad",
			"\1\u00ae",
			"\1\u00af",
			"",
			"",
			"\1\u00b0",
			"",
			"",
			"\1\u00b3\1\u00b2",
			"",
			"\1\u00b5",
			"",
			"\1\u00b7",
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
			"\12\171\1\uffff\2\171\1\uffff\u201a\171\2\uffff\udfd6\171",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u00ba",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u00bc",
			"\1\u00bd",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u00bf",
			"\1\u00c0",
			"\1\u00c1",
			"\1\u00c2",
			"\1\u00c3",
			"\1\u00c4",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u00c6",
			"\1\u00c7",
			"\1\u00c8",
			"\1\u00c9",
			"\1\u00ca",
			"\1\u00cb",
			"\1\u00cc",
			"\1\u00ce\1\u00cd",
			"\1\u00cf",
			"\1\u00d0",
			"\1\u00d1",
			"\1\u00d2",
			"\1\u00d3",
			"\1\u00d4",
			"",
			"\1\u00d5",
			"\1\u00d6",
			"\1\u00d7",
			"\1\u00d8",
			"\1\u00d9",
			"",
			"\1\u00da",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\4\53\1\u00db\25\53",
			"",
			"\1\u00dd\2\uffff\1\u00de",
			"\1\u00df",
			"\1\u00e0",
			"\1\u00e1",
			"\1\u00e2",
			"\1\u00e3",
			"\1\u00e4",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u00e6",
			"\1\u00e7",
			"\1\u00e8",
			"\1\u00e9",
			"\1\u00ea",
			"\1\u00eb",
			"\1\u00ec",
			"\1\u00ed",
			"",
			"",
			"\1\u00ee",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\u00f1",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\u00f3",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u00f5",
			"\1\u00f6",
			"\1\u00f7",
			"\1\u00f8",
			"",
			"\1\u00f9",
			"\1\u00fa",
			"\1\u00fb",
			"\1\u00fc",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u00ff",
			"\1\u0100",
			"\1\u0101",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u0103",
			"\1\u0104",
			"\1\u0105",
			"\1\u0106",
			"\1\u0107",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u010b",
			"\1\u010c",
			"\1\u010d",
			"\1\u010e",
			"",
			"\1\u010f",
			"\1\u0110",
			"\1\u0111",
			"\1\u0112",
			"\1\u0113",
			"\1\u0114",
			"\1\u0115",
			"\1\u0116",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u0118",
			"\1\u0119",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u011b",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u011e",
			"",
			"",
			"",
			"\1\u011f",
			"",
			"\1\u0120",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\22\53\1\u0121\7\53",
			"\1\u0123",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\13\53\1\u0125\16\53",
			"\1\u0127",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u012a",
			"",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u012c",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u012f",
			"\1\u0130",
			"\1\u0131",
			"\1\u0132",
			"",
			"",
			"",
			"\1\u0133",
			"\1\u0134",
			"\1\u0135",
			"\1\u0136",
			"\1\u0137",
			"\1\u0138",
			"\1\u0139",
			"\1\u013a",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u013c",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u013e",
			"",
			"\1\u013f",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\u0141",
			"",
			"",
			"\1\u0142",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u0144",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\u0147",
			"",
			"\1\u0148",
			"",
			"",
			"\1\u0149",
			"",
			"\1\u014a",
			"",
			"",
			"\1\u014b",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u014d",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u0150",
			"\1\u0151",
			"\1\u0152",
			"\1\u0153",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\u0158",
			"\1\u0159",
			"",
			"\1\u015a",
			"\1\u015b",
			"",
			"\1\u015c",
			"",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u015e",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u0160",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\u0162",
			"",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u0164",
			"\1\u0165",
			"\1\u0166",
			"",
			"",
			"",
			"",
			"\1\u0167",
			"\1\u0168",
			"\1\u0169",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u016b",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\u016f",
			"\1\u0170",
			"\1\u0171",
			"\1\u0172",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"",
			"",
			"\1\u0176",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u0178",
			"\1\u0179",
			"",
			"",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53",
			"\1\u017c",
			"",
			"",
			"\1\u017d",
			"\1\53\13\uffff\12\53\7\uffff\32\53\1\uffff\1\53\2\uffff\1\53"
					+ "\1\uffff\32\53", "" };

	static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
	static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
	static final char[] DFA34_min = DFA
			.unpackEncodedStringToUnsignedChars(DFA34_minS);
	static final char[] DFA34_max = DFA
			.unpackEncodedStringToUnsignedChars(DFA34_maxS);
	static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
	static final short[] DFA34_special = DFA
			.unpackEncodedString(DFA34_specialS);
	static final short[][] DFA34_transition;

	static {
		int numStates = DFA34_transitionS.length;
		DFA34_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
		}
	}

	class DFA34 extends DFA {

		public DFA34(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 34;
			this.eot = DFA34_eot;
			this.eof = DFA34_eof;
			this.min = DFA34_min;
			this.max = DFA34_max;
			this.accept = DFA34_accept;
			this.special = DFA34_special;
			this.transition = DFA34_transition;
		}

		public String getDescription() {
			return "1:1: Tokens : ( NULL | TRUE | FALSE | BREAK | CASE | CATCH | CONTINUE | DEFAULT | DELETE | DO | ELSE | FINALLY | FOR | FUNCTION | IF | IN | INSTANCEOF | NEW | RETURN | SWITCH | THIS | THROW | TRY | TYPEOF | VAR | VOID | WHILE | WITH | EACH | ABSTRACT | BOOLEAN | BYTE | CHAR | CLASS | CONST | DEBUGGER | DOUBLE | ENUM | EXPORT | EXTENDS | FINAL | FLOAT | GOTO | IMPLEMENTS | IMPORT | INT | INTERFACE | LONG | NATIVE | PACKAGE | SHORT | STATIC | SUPER | SYNCHRONIZED | THROWS | TRANSIENT | VOLATILE | LBRACE | RBRACE | LPAREN | RPAREN | LBRACK | RBRACK | DOT | SEMIC | COMMA | LT | GT | LTE | GTE | EQ | NEQ | SAME | NSAME | ADD | SUB | MUL | MOD | INC | DEC | SHL | SHR | SHU | AND | OR | XOR | NOT | INV | LAND | LOR | QUE | COLON | ASSIGN | ADDASS | SUBASS | MULASS | MODASS | SHLASS | SHRASS | SHUASS | ANDASS | ORASS | XORASS | DIV | DIVASS | WhiteSpace | EOL | MultiLineComment | SingleLineComment | Identifier | DecimalLiteral | OctalIntegerLiteral | HexIntegerLiteral | StringLiteral | RegularExpressionLiteral );";
		}

		public int specialStateTransition(int s, IntStream _input)
				throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch (s) {
			case 0:
				int LA34_40 = input.LA(1);

				int index34_40 = input.index();
				input.rewind();
				s = -1;
				if ((LA34_40 == '=')) {
					s = 117;
				}

				else if ((LA34_40 == '*')) {
					s = 118;
				}

				else if ((LA34_40 == '/')) {
					s = 119;
				}

				else if (((LA34_40 >= '\u0000' && LA34_40 <= '\t')
						|| (LA34_40 >= '\u000B' && LA34_40 <= '\f')
						|| (LA34_40 >= '\u000E' && LA34_40 <= ')')
						|| (LA34_40 >= '+' && LA34_40 <= '.')
						|| (LA34_40 >= '0' && LA34_40 <= '<')
						|| (LA34_40 >= '>' && LA34_40 <= '\u2027') || (LA34_40 >= '\u202A' && LA34_40 <= '\uFFFF'))
						&& ((areRegularExpressionsEnabled()))) {
					s = 121;
				}

				else
					s = 120;

				input.seek(index34_40);
				if (s >= 0)
					return s;
				break;
			case 1:
				int LA34_117 = input.LA(1);

				int index34_117 = input.index();
				input.rewind();
				s = -1;
				if (((LA34_117 >= '\u0000' && LA34_117 <= '\t')
						|| (LA34_117 >= '\u000B' && LA34_117 <= '\f')
						|| (LA34_117 >= '\u000E' && LA34_117 <= '\u2027') || (LA34_117 >= '\u202A' && LA34_117 <= '\uFFFF'))
						&& ((areRegularExpressionsEnabled()))) {
					s = 121;
				}

				else
					s = 185;

				input.seek(index34_117);
				if (s >= 0)
					return s;
				break;
			}
			NoViableAltException nvae = new NoViableAltException(
					getDescription(), 34, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
