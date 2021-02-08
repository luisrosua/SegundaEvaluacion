package Cola;

import java.util.Scanner;

public class MainCola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cola c = new Cola();
		
		
		
		addPersonas(c);
		
		int op;
		do {
			System.out.println(c.toString());
			
			op = menu();
			
			switch(op) {
			case 1: c.remove(); break;
			case 2: addPersonas(c); break;
			case 3: c.removeAll(); break;
			}
			
		}while(op != 4);
		
	}
	
	public static void addPersonas(Cola c) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("How many people do you want the queue to have?");
		int option = input.nextInt();
		
		for(int i = 0; i < option; i++) {
			Persona p = new Persona();
			c.add(p);
		}

		c.orderQueue();
	}
	
	public static int menu() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("1. Make the first one on the queue go");
		System.out.println("2. Introduce more people");
		System.out.println("3. Remove the whole queue and exit");
		
		int op = input.nextInt();
		return op;
	}

}
