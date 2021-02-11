package Bingo2;

import java.util.Scanner;

public class mainBingo {
	
	public static int line = 0;
	public static int counter = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		
		
		int op = 0;
		do {
			System.out.println("Do you want to play now?\n 1. Yes\n 2. No");
			op = input.nextInt();
			if(op == 1) {
				startGame();
			}
		}while(op > 3);
	}
	
	public static void startGame() {
		Persona p1 = new Persona(askName());
		Persona p2 = new Persona(askName());
		Persona p3 = new Persona(askName());
		Persona p4 = new Persona(askName());
		
		Card card1 = new Card();
		Card card2 = new Card();
		Card card3 = new Card();
		Card card4 = new Card();
		
		Match match = new Match();
		do {
			System.out.println("Your card is: \n"+card1.toString()+"\n");
			System.out.println(p2.getName()+"'s card is: \n"+card2.toString());
			System.out.println(p3.getName()+"'s card is: \n"+card3.toString());
			System.out.println(p4.getName()+"'s card is: \n"+card4.toString());
			
			//if(counter == 0) {
				System.out.println(match.toString());
			//	counter++;
			//}
			
			
			int op = gameOptions();
			if(op == 1) {
				int n = match.getNumber();
				System.out.println(match.toString());
				
				
				
				hideCheckAsk(n, card1);
				card2.hideNumber(n);
				card3.hideNumber(n);
				card4.hideNumber(n);
				
				if(line == 0) {
					if(card1.checkLine()) {
						System.out.println(p1.getName()+" has line!");
					} 
					else
						if(card2.checkLine()) {
							System.out.println(p2.getName()+" has line!");
						}
						else
							if(card3.checkLine()) {
								System.out.println(p3.getName()+" has line!");
							}
							else
								if(card4.checkLine()) {
									System.out.println(p4.getName()+" has line!");
								}
				}
				
				
			}
			
		}while(!card1.checkWinner() || !card2.checkWinner() || !card3.checkWinner() || !card4.checkWinner());
	}
	
	public static void hideCheckAsk(int n, Card card) {
		int op = askNumber();
		if(op == n) {
			card.hideNumber(n);
		}
		else
			if(op == 0) {
				System.out.println("Okay");
			}
			else
				if(op != n) {
					System.out.println(op+" is not the correct number");
				}
	}
	
	public static int askNumber() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Strike out a number (Press '0' to skip): ");
		int op = input.nextInt();
		
		return op;
	}
	
	public static int gameOptions() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Press 1 to get a new number!");
		int op = input.nextInt();
		
		return op;
	}
	
	public static String askName() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("What's this player name?");
		String name = input.next();
		return name;
	}

}