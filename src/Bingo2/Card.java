package Bingo2;

public class Card {
	private int[][] bingoCard;
	
	public Card() {
		generateCard();
	}
	
	public void generateCard() {
		this.bingoCard = new int[3][9];
		for(int i = 0; i < bingoCard[0].length; i++) {
			for(int j = 0; j < bingoCard.length; j++) {
				boolean esta = false;
				int num;
				
				do {
					esta = false;
					if(i == 8) {
						num = 80 + (int) (Math.random()*20);
					} else {
						num = (int) (Math.random()*10) + 10 * i;
						if(i == 0 && num == 0) {
							num = 1;
						}
					}
					for(int k = 0; k < j; k++) {
						if(bingoCard[k][i] == num) {
							esta = true;
						}
					}
				}while(esta);
				
				bingoCard[j][i] = num;
			}
		}
		sort();
		hideNumbers();
		
	}
	
	private void hideNumbers() {
		for(int i = 0; i < bingoCard.length; i++) {
			int rnd = (int) (Math.random()*3);
			bingoCard[rnd][i] = 0;
		}
		
		int three = 0;
		do {
			for(int i = 0; i < bingoCard.length; i++) {
				int counter = 0;
				for(int j = 0; j < bingoCard[0].length; j++) {
					if(bingoCard[i][j] == 0) {
						counter++;
					}
				}
				if(counter < 4) {
					boolean ready = false;
					do {
						int rnd = (int) (Math.random()*9);						
						if(bingoCard[i][rnd] != 0) {
							bingoCard[i][rnd] = 0;
							three++;
							ready = true;
						}
					}while(!ready);
				}
			}
		}while(three != 3);
		checking();
		
	}
	
	private void checking() {
		for(int i = 0; i < bingoCard.length; i++) {
			int counter = 0;
			for(int j = 0; j < bingoCard[0].length; j++) {
				if(bingoCard[i][j] == 0) {
					counter++;
					if(counter > 4) {
						boolean x = false;
						do {
							int rnd = (int) (Math.random()*3);
							if(rnd != i && bingoCard[rnd][j] != 0) {
								bingoCard[i][j] = bingoCard[rnd][j];
								bingoCard[rnd][j] = 0;
								x = true;
							}
						}while(!x);
					}
				}
			}
		}
	}
	
	
	private void sort() {
		int aux = 0;
		int first = 0;
		for(int i = 0; i < bingoCard[0].length; i++) {
			for(int j = 0; j < bingoCard.length; j++) {
				first = j;
				for(int k = j+1; k < bingoCard.length; k++) {
					if(bingoCard[k][i] < bingoCard[first][i]) {
						first = k;
					}
					aux = bingoCard[j][i];
					bingoCard[j][i] = bingoCard[first][i];
					bingoCard[first][i] = aux;
				}
			}
		}
	}
	
	public String toString() {
		String report = "";
		for(int i = 0; i < bingoCard.length; i++) {
			report += "\n";
			for(int j = 0; j < bingoCard[0].length; j++) {
				if(bingoCard[i][j] == 0) {
					report += "--\t";
				} else {
					report += bingoCard[i][j]+"\t";
				}
			}
		}
		return report;
	}
	
	public void hideNumber(int n) {
		for(int i = 0; i < bingoCard.length; i++) {
			for(int j = 0; j < bingoCard[i].length; j++) {
				if(bingoCard[i][j] == n) {
					bingoCard[i][j] = 0;
				}
			}
		}
	}
	
	public boolean checkWinner() {
		int counter = 0;
		for(int i = 0; i < bingoCard.length; i++) {
			for(int j = 0; j < bingoCard[0].length; j++) {
				if(bingoCard[i][j] == 0) {
					counter++;
				}
			}
		}
		
		if(counter != 27) {
			return false;
		}
		return true;
	}
	
	public boolean checkLine() {
		boolean line = false;
		if(!line) {
			for(int i = 0; i < bingoCard.length; i++) {
				int counter = 0;
				for(int j = 0; j < bingoCard[0].length; j++) {
					if(bingoCard[i][j] == 0) {
						counter++;
						if(counter == 9) {
							line = true;
						}
					}
				}
			}
		}
		
		if(line) {
			return true;
		}
		return false;
	}
	
	}
