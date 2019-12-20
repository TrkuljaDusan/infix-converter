package drugaGodina.asp;

class Expression {

//	String infix;
//	
//	
//	String[] stackSteps;
//	String[] expressionSteps;	
//	String[] rSteps;
//	char[] symbolStep;
//	int steps;
	
	Expression(String s) {
		
		//infix= s;
		
//		stackSteps= new String[100];
//		expressionSteps= new String[100];
//		rSteps= new String[100];
//		symbolStep=new char[100];
			
	}
	//saves each step in conversion
	static private void updateStep(int rank, Stack s, String postfix, char next, Step st) {
		st.rSteps[st.steps]=Integer.toString(rank);
		st.expressionSteps[st.steps]=postfix;
		st.stackSteps[st.steps]=s.print();
		st.symbolStep[st.steps]=next;
		st.steps++;
	}
	
	//infix to postfix conversion algorithm
	public static Step postfix(String infix) throws /*StackFull,*/ InvalidExpressionException{	
		
		int n=infix.length();
		Stack s= new Stack (100);		
		int rank = 0; 					//used for checking the validity of the expression
		char x;
		Step st = new Step();
		st.steps=0;
		String postfix="";
		char next='\0';
		
		updateStep(rank, s, postfix, next , st);
		for  (int i=0; i<n;i++)
		{
			
			
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
						
						updateStep(rank, s, postfix, next, st);
						//TODO same operator printed multiple times
					if (rank<1)
						throw new InvalidExpressionException(st);
				}
			if (next!=')') 
				s.push(next);
			else
				x=s.pop();
			}
			updateStep(rank, s, postfix, next, st);
		}
		while (!(s.empty())) {
			x=s.pop();
			postfix+=x;
			rank+= Operator.rank(x);
			//TODO A+B* error isn't caught until the end AB*+
			updateStep(rank, s, postfix,' ', st);
		}
		

		if (rank!=1) {
			throw new InvalidExpressionException(st);
		}
		
		return st;
	}
	
}
class Step{
	
	String[] stackSteps;
	String[] expressionSteps;	
	String[] rSteps;
	char[] symbolStep;
	int steps;
	
	Step(){
		stackSteps= new String[100];
		expressionSteps= new String[100];
		rSteps= new String[100];
		symbolStep=new char[100];
		
	}
}

