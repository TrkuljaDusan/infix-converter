package drugaGodina.asp;
import drugaGodina.asp.Stack;
import drugaGodina.asp.Operator;

class Izraz {

	String infix;
	String postfix="";
	
	Izraz(String s)throws Exception{
		
		infix= s;
		this.postfix();
		
		
		
	}
	void postfix() throws StackFull, StackEmpty{
		Stack s= new Stack (100);
		int rank = 0;
		char x;
		int n = infix.length();
		for  (int i=0; i<n;i++)
		{
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
					rank+= Operator.rank(x);}
					//if (rank<1)
						//throw new NepravilanIzraz();
					else {break;
				}
						
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
	
	/*	if (rank!=1) {
			break;
			//throw new Nepravilan izraz
		
		}*/
		
		
		
		
		
		
	}
}
