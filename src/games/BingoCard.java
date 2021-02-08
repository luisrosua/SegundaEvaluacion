package games;

import java.util.Arrays;

public class BingoCard {

	private int[][] card;
	private int[][] originalCard;

	public BingoCard() {

		prepareCard();
		copy();
	}

	private void copy() {
		this.originalCard = new int[3][9];

		for (int c = 0; c < card[0].length; c++)

			for (int f = 0; f < card.length; f++)
				this.originalCard[f][c] = this.card[f][c];

	}

	public void prepareCard() {
		myCard();
		sort();
		hidePositions();
	}

	private void hidePositions() {
        
		
				 
		for (int f = 0; f < 3; f++) {// ocultamos 4 números en cada fila
			int hidden = 0;
			while (hidden < 4) {
				int doblete = doubleInColumn();
				int r = (int) (Math.random() * 9);
				if (f < 2 && card[f][r] != 0) {
					if ( (f==1 && card[0][r]==0 && doblete >=3))continue;
					card[f][r] = 0;
					hidden++;
				} else {
					if (f==2 && card[2][r]!=0 && dobla(r)<2) {
						 if (doblete >=3 && dobla(r)>0) continue;
						 else {
		                    	card[f][r] = 0;
		    					hidden++;
						 }
		                    }
					}
                   
				}

			}
		}
	
   private int dobla(int c) {
	  int co=0;
	  for (int i =0;i<3;i++)
		  if (this.card[i][c]==0)
			  co++;
	  return co;
   }
	private int doubleInColumn() {
		int d =0;;
		for (int c = 0; c < card[0].length; c++) {
			int count =0;
		
			for (int f = 0; f < card.length; f++) 
				if (this.card[f][c]==0)
					count++;
			if (count==2)
				d++;
		}
		return d;
	}
	/*
	 * public void hidePositions() { //Ocultamos un número en cada columna for (int
	 * c = 0; c < card[0].length; c++) { int r = (int) (Math.random() * 3);
	 * card[r][c] = 0;
	 * 
	 * } //ocultamos 3 mas en las filas que tengan menos de 4 ocultos
	 *  int masTres =0; do { for (int f = 0; f < card.length; f++) { int count = 0; for (int c =
	 * 0; c < card[0].length; c++) { if (card[f][c] == 0) count++; } if (count < 4)
	 * { //añadimos otro oculto en la fila, hasta completar 12 ocultos boolean ok =
	 * false; do { int r = (int) (Math.random() * 9); if (card[f][r] != 0) {
	 * card[f][r] = 0; ok = true; ++masTres; }
	 * 
	 * } while (!ok); } } } while (masTres != 3); checkCard();
	 * 
	 * }
	 

	private void checkCard() {
		for (int f = 0; f < card.length; f++) {
			int count = 0;
			for (int c = 0; c < card[0].length; c++) {
				if (card[f][c] == 0) {
					count++;
					if (count > 4) {
						boolean change = false;
						do {
							int r = (int) (Math.random() * 3);
							if (r != f && card[r][c] != 0) {

								card[f][c] = card[r][c];
								card[r][c] = 0;
								change = true;
							}
						} while (!change);
					}
				}
			}

		}
	}*/

	private void myCard() {
		this.card = new int[3][9];

		for (int c = 0; c < card[0].length; c++) {

			for (int f = 0; f < card.length; f++) {

				boolean esta = false;
				int num;
				do {
					esta = false;
					if (c == 8) {
						num = 80 + (int) (Math.random() * 20);
					} else {
						num = (int) (Math.random() * 10) + 10 * c;
						if (c == 0 && num == 0)
							num = 1;
					}
					for (int i = 0; i < f; i++)
						if (card[i][c] == num)
							esta = true;

				} while (esta);

				card[f][c] = num;

			}

			// Arrays.sort(card[c]);

		}

	}

	private void sort() {
		for (int c = 0; c < card[0].length; c++)
			sortColumn(c);
	}

	private void sortColumn(int c) {
		for (int f = 0; f < card.length - 1; f++) {

			int indexOfS = f;

			for (int j = f + 1; j < card.length; j++) {

				if (card[j][c] < card[indexOfS][c])
					indexOfS = j;
			}
			int aux = card[f][c];
			card[f][c] = card[indexOfS][c];
			card[indexOfS][c] = aux;
		}
	}

	public int hasNumber(int n) {// devuelve la fila donde está el número o -1 si no está
		for (int f = 0; f < card.length; f++) {

			for (int c = 0; c < card[f].length; c++) {
				if (this.card[f][c] == n) {
					this.card[f][c] = -1;
					return f;
				}
			}
		}
		return -1;
	}

	public boolean bingo() {
		for (int f = 0; f < card.length; f++)

			for (int c = 0; c < card[f].length; c++)
				if (this.card[f][c] > 0)
					return false;
		return true;
	}

	public String toString() {
		String s = "";
		for (int f = 0; f < card.length; f++) {

			for (int c = 0; c < card[f].length; c++) {
				if (card[f][c] == 0)
					s += "##" + "\t";
				else if (card[f][c] == -1)
					s += "XX" + "\t";
				else
					s += card[f][c] + "\t";
			}
			s += "\n";
		}
		return s;
	}

	public String getOriginal() {
		String s = "";
		for (int f = 0; f < card.length; f++) {

			for (int c = 0; c < card[f].length; c++) {
				if (originalCard[f][c] == 0)
					s += "##" + "\t";

				else
					s += originalCard[f][c] + "\t";
			}
			s += "\n";
		}
		return s;
	}
}
