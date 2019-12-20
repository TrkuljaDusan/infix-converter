package drugaGodina.asp;

class InvalidExpressionException extends Exception {
	Expression exp;
	InvalidExpressionException (Expression e){
		super("Invalid expression");
		exp=e;
	}
}
