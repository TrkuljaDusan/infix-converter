package drugaGodina.asp;

class Operator {

	static int infixPriority(char o) {
		switch (o) {
		case '+' : return 2; 
		case '-' : return 2;
		case '*' : return 3;
		case '/' : return 3;
		case '%' : return 3;
		case '^' : return 5;
		case '(' : return 6;
		case ')' : return 1;
		default: return 100; //throw exception rewrite
		}
		
	}
	static int stackPriority(char o) {
		switch (o) {
		case '+' : return 2;
		case '-' : return 2;
		case '*' : return 3;
		case '/' : return 3;
		case '%' : return 3;
		case '^' : return 4;
		case '(' : return 0;
		default: return 100;
		}
		
	}
	static int rank(char o) {
		switch (o){
		case '+' : return -1;
		case '-' : return -1;
		case '*' : return -1;
		case '/' : return -1;
		case '%' : return -1;
		case '^' : return -1;		
		default : return 100;
		}
	}
	
}
