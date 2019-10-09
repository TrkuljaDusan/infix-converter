package drugaGodina.asp;
import drugaGodina.asp.StackFull;
import drugaGodina.asp.StackEmpty;

class Stack {
	
	char[] b;
	
	int top;
	
	Stack (int size){
		top = 0; // empty stack
		b = new char[size];
	}
	
	void push(char x) throws StackFull {
		if (this.full()) 
			throw new StackFull(this);
		else {
			b[top]=x; top++; 
		}
	}
	char pop () throws StackEmpty {
		if (this.empty()) {
			throw new StackEmpty(this);
		}
		else {
			top--;
			return b[top];
		}
	}
	
	char top() {
		//if (!(this.empty())) {
		return b[top-1];
		//}
		
	}
	
	boolean full () {
		if (top==100) return true;
		else return false;
	}
	boolean empty () {
		if (top == 0) return true;
		else return false;
	}
	
	
}
