package drugaGodina.asp;
import javax.swing.JTextArea;

class Expression {

	String infix;
	String postfix="";
	
	String currentInfix;
	Stack s = new Stack(100);
	int rank = 0;
	int currentRank=0;
	
	int n;
	String[] stackSteps;
	String[] expressionSteps;	
	String[] rSteps;
	char[] symbolStep;
	int currentn = n;
	int steps;
	
	Expression(String s) throws InvalidExpressionException{
		
		infix= s;
		currentInfix=s;
		n=infix.length();
		stackSteps= new String[100];
		expressionSteps= new String[100];
		rSteps= new String[100];
		symbolStep=new char[100];
		//this.postfix();	
	}
	void next(JTextArea t1, JTextArea t2) throws /*StackEmpty,*/ InvalidExpressionException/*, StackFull*/ {
		//Stack s= new Stack (100);		
		//int rank = 0; 					//used for checking the validity of the expression
		char x;
		int n = infix.length();
		for  (int i=0; i<n;i++)
		{
			t2.append(postfix+"\n");
			t1.append(s.print()+"\n");
			
			//try {
				//Thread.sleep(2000);
			//} catch (InterruptedException e) {
				//e.printStackTrace();
			//}
			char next = infix.charAt(0);
			infix = infix.substring(1, infix.length());
			
			if(Character.isLetter(next)) {
				postfix = postfix + next;
				rank++;
			}
			else {
				while (!(s.empty())) {
					
					if ( Operator.infixPriority(next)<=Operator.stackPriority(s.top())){
						x=s.pop();
						postfix=postfix+x;
						rank+= Operator.rank(x);
						}
					
					if (rank<1)
						throw new InvalidExpressionException(this);
					//else {
						//break;
					//}		
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
		}
	
		if (rank!=1) {
			//break;
			throw new InvalidExpressionException(this);
		}
	}
	private void updateStep(char next) {
		rSteps[steps]=Integer.toString(rank);
		expressionSteps[steps]=postfix;
		stackSteps[steps]=s.print();
		symbolStep[steps]=next;
		steps++;
	}
	// infix to postfix conversion algorithm
	void postfix() throws /*StackFull, StackEmpty,*/ InvalidExpressionException{	
		
		//Stack s= new Stack (100);		
		//int rank = 0; 					//used for checking the validity of the expression
		char x;
		//int n = infix.length();
		steps=0;
		for  (int i=0; i<n;i++)
		{
			
			
			char next = infix.charAt(0);
			infix = infix.substring(1, infix.length());
			updateStep(next);
			
			if(Character.isLetter(next)) {
				postfix = postfix + next;
				rank++;
			}
			else {
				while (!(s.empty()) && Operator.infixPriority(next)<=Operator.stackPriority(s.top())) {
					
					//if ( Operator.infixPriority(next)<=Operator.stackPriority(s.top())){
						x=s.pop();
						
						postfix=postfix+x;
						rank+= Operator.rank(x);
						
						updateStep(next);
						//}
					
					if (rank<1)
						throw new InvalidExpressionException(this);
					//else {
						//break;
					//}		
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
			
			updateStep(' ');
		}
	
		if (rank!=1) {
			//break;
			throw new InvalidExpressionException(this);
		}
		
		
	}
}
