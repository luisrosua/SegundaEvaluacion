package bingo;

public class Match {
	private static int counter = 0;
	private static boolean line = false;
	
	private static int[] listOfNumbers = new int[99];
	
	private int randomNumber;
	
	public Match() {
		this.randomNumber = getNumber();
	}
	
	public String toString() {
		String list = printList();
		return "Named numbers: "+list+"\nThe number is: "+this.randomNumber;
	}
	
	public int[] setList() {
		for(int i = 0; i < listOfNumbers.length; i++) {
			listOfNumbers[i] = 0;
		}
		return listOfNumbers;
	}
	
	
	public String printList() {
		String report = "";
		for(int i = 0; i < listOfNumbers.length; i++) {
			report += listOfNumbers[i]+"\t";
			if(report.length() % 10 == 0) {
				report += "\n";
			}
		}
		return report;
	}

	public int getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	public int getNumber() {
		int rnd = 0;
		do {
			rnd = (int) (Math.random()*98)+1;
		}while(!checkNumbers(rnd));
		
		addNumber(rnd);
		
		return rnd;
	}
	
	private int [] addNumber(int rnd) {
		listOfNumbers[counter] = rnd;
		counter++;
		
		return listOfNumbers;
	}
	
	private boolean checkNumbers(int rnd) {
		int counter = 0;
		for(int i = 0; i < listOfNumbers.length; i++) {
			if(rnd == listOfNumbers[i]) {
				counter++;
			}
		}
		return line;
	}
		

}
