package drugaGodina.asp;
import drugaGodina.asp.StackFull;
//import drugaGodina.asp.StackEmpty;

class Stack {
	
	char[] b;
	int size;
	int top;
	
	Stack (int size){
		top = 0; // empty stack
		this.size=size;
		b = new char[size];
	}
	
	void push(char x) /*throws StackFull*/ {
		if (this.full()) 
			;//throw new StackFull(this);
		else {
			b[top]=x; top++; 
		}
	}
	char pop () /*throws StackEmpty*/ {
		if (this.empty()) {
			//throw new StackEmpty(this);
			return '\0';	
		}
		else {
			top--;
			return b[top];
		}
	}
	
	char top() {
		if (!(this.empty())) {
		return b[top-1];
		}
		return '\0';
		
	}
	
	boolean full () {
		if (top==size) return true;
		else return false;
	}
	boolean empty () {
		if (top == 0) return true;
		else return false;
	}
	
	public String print() {
		return String.copyValueOf(b).substring(0,top); 
	}
	
}
