package bingo;

import java.util.Scanner;

public class mainBingo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		bingoCard card1 = new bingoCard();
		bingoCard card2 = new bingoCard();
		
		
		int op = 0;
		do {
			System.out.println("Do you want to play now?\n 1. Yes\n 2. No");
			op = input.nextInt();
			if(op == 1) {
				startGame(card1, card2);
			}
		}while(op > 3);
	}
	
	public static void startGame(bingoCard card1, bingoCard card2) {
		do {
			System.out.println("Player 1's card is: \n"+card1.toString()+"\n");
			System.out.println("Player 2's card is: \n"+card2.toString());
			
			Match match = new Match();
			match.toString();
		
			card1.hideNumber(match.getRandomNumber());
			card2.hideNumber(match.getRandomNumber());
		}while(!card1.checkWinner() || !card2.checkWinner());
		
		if(card1.checkLine()) {
			System.out.println("Player 1 has line");
		} else
			if(card2.checkLine()) {
				System.out.println("Player 2 has line");
			}
		
		if(card1.checkWinner()) {
			System.out.println("Player 1 has won!");
		} else
			if(card2.checkWinner()){
				System.out.println("Player 2 has won!");
			}
		
	}
	
	/*public static int gameOptions() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("1. Get new number");
		System.out.println("2. End game");
		int op = input.nextInt();
		
		return op;
	}
	 */
}
