package drugaGodina.asp;

class InvalidExpressionException extends Exception {
	Step exp;
	InvalidExpressionException (Step e){
		super("Invalid expression");
		exp=e;
	}
}
