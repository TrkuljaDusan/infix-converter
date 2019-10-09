package drugaGodina.asp;

import java.util.Scanner;

class konverzija {

	public static void main(String[] args) {
		
		Scanner ulaz= new Scanner(System.in);
		System.out.println("Izraz u infiksnoj notaciji:");
		
		String infix = ulaz.nextLine();
		
		try {
		Izraz i= new Izraz (infix);
		i = new Izraz (infix);
		System.out.println(i.postfix);}
		catch (Exception e) {};
				
		
		
		
		
		
		
		
		ulaz.close();
	}
	
	
}
