package drugaGodina.asp;

class Expression {

	String infix;
	
	
	String[] stackSteps;
	String[] expressionSteps;	
	String[] rSteps;
	char[] symbolStep;
	int steps;
	
	Expression(String s) throws InvalidExpressionException{
		
		infix= s;
		
		stackSteps= new String[100];
		expressionSteps= new String[100];
		rSteps= new String[100];
		symbolStep=new char[100];
			
	}
	//saves each step in conversion
	private void updateStep(int rank, Stack s, String postfix, char next) {
		rSteps[steps]=Integer.toString(rank);
		expressionSteps[steps]=postfix;
		stackSteps[steps]=s.print();
		symbolStep[steps]=next;
		steps++;
	}
	
	//infix to postfix conversion algorithm
	void postfix() throws /*StackFull,*/ InvalidExpressionException{	
		
		int n=infix.length();
		Stack s= new Stack (100);		
		int rank = 0; 					//used for checking the validity of the expression
		char x;
		steps=0;
		String postfix="";
		char next='\0';
		
		for  (int i=0; i<n;i++)
		{
			updateStep(rank, s, postfix, next);
			
			next = infix.charAt(0);
			infix = infix.substring(1, infix.length());
			
			if(Character.isLetter(next)) {
				postfix = postfix + next;
				rank++;
			}
			else {
				while (!(s.empty()) && Operator.infixPriority(next)<=Operator.stackPriority(s.top())) {
					
						x=s.pop();
						postfix=postfix+x;
						rank+= Operator.rank(x);
						
						updateStep(rank, s, postfix, next);
						//TODO same operator printed multiple times
					if (rank<1)
						throw new InvalidExpressionException(this);
				}
			if (next!=')') 
				s.push(next);
			else
				x=s.pop();
			}
		}
		while (!(s.empty())) {
			x=s.pop();
			postfix+=x;
			rank+= Operator.rank(x);
			//TODO A+B* error isn't caught until the end AB*+
			updateStep(rank, s, postfix,' ');
		}
	
		if (rank!=1) {
			throw new InvalidExpressionException(this);
		}
		
		
	}
}
