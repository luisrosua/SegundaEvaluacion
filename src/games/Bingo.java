package games;

import java.util.Arrays;

public class Bingo {

	int[][] card;

	public Bingo() {

		 prepareCard();
	}

	public void prepareCard() {
		 myCard();

		sort();
		hidePositions();
		

	}

	public  void hidePositions() {
//Ocultamos un número en cada columna
		for (int c = 0; c < card[0].length; c++) {
			int r = (int) (Math.random() * 3);
			card[r][c] = 0;

		}
//ocultamos 3 mas en las filas que tengan menos de 4 ocultos
		int masTres = 0;
		do {
			for (int f = 0; f < card.length; f++) {
				int count = 0;
				for (int c = 0; c < card[0].length; c++) {
					if (card[f][c] == 0)
						count++;
				}
				if (count < 4) {
//añadimos otro oculto en la fila, hasta completar 12 ocultos
					boolean ok = false;
					do {
						int r = (int) (Math.random() * 9);
						if (card[f][r] != 0) {
							card[f][r] = 0;
							ok = true;
							++masTres;
						}

					} while (!ok);
				}
			}
		} while (masTres != 3);
		checkCard();

	}

	private  void checkCard() {
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
	}

	private void myCard() {
		this.card = new int[3][9];

		for (int c = 0; c < card[0].length; c++) {

			for (int f = 0; f < card.length; f++) {

				boolean esta = false;
				int num;
				do {
					esta = false;
					if (c == 8) {
						num = 80+(int) (Math.random() * 20);
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

	private  void sort() {
		for (int c = 0; c < card[0].length; c++)
			sortColumn( c);
	}

	private  void sortColumn(int c) {
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

	public  String toString() {
		String s = "";
		for (int f = 0; f < card.length; f++) {

			for (int c = 0; c < card[f].length; c++) {
				if (card[f][c] == 0)
					s += "##" + "\t";
				else
					s += card[f][c] + "\t";
			}
			s += "\n";
		}
		return s;
	}
}
