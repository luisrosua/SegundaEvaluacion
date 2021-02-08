package gam;



import java.util.ArrayList;

public class TestBingo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int PLAYERS = 2;

		BingoCard[] bingo = new BingoCard[PLAYERS];
		LotteryHype hype = new LotteryHype();

		ArrayList<Integer> winners = new ArrayList<Integer>();

		for (int i = 0; i < bingo.length; i++) {
			bingo[i] = new BingoCard();
			System.out.println("\n" + bingo[i]);
		}

		boolean winner = false;
		System.out.println("3...2....1...Starting\n");
		int totalNumbers =0;
		while (!winner) {
			delay(3);
			int n= hype.nextNumber();
			totalNumbers++;
			System.out.print("\t" +n);
			if (totalNumbers%17==0)System.out.println();
			
			for (int i = 0; i < bingo.length; i++) {
				int line = bingo[i].hasNumber(n);
				if(line>=0) {
					if (bingo[i].bingo()) {
						winners.add(i);
						winner = true;
					}
					//else if (bingo[i].line(line))//línea
				}
			}	
		}
		System.out.println(" \nBingooooo;   ");
		for (int i=0;i<winners.size();i++)
		  System.out.println("\n"+bingo[winners.get(i)]+"\n"+bingo[winners.get(i)].getOriginal());
		System.out.println();
		for (int i = 0; i < bingo.length; i++) {
			//bingo[i] = new BingoCard();
			System.out.println("\n" + bingo[i]);
		}
	}

	public static void delay(int n) {
		try {
			Thread.sleep(n * 100);
		} catch (InterruptedException ex) {
			System.out.println("Error");
		}

	}

}

