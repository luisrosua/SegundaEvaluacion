package Bingo2;

import java.util.ArrayList;
import java.util.Random;

public class Match {
	
	private int[] listOfNumbers	= new int[99];

	private ArrayList<Integer> namedNumbers;
	
	public Match() {
		listOfNumbers = setList();
		namedNumbers = new ArrayList<Integer>();
		
	}
	
	public int getNumber() {
		int n = getRandomNumber();
		return listOfNumbers[n];
	}
	
	public int getRandomNumber() {
		Random rnd = new Random();
		int n = 0;
		do {
			n = rnd.nextInt(listOfNumbers.length);
		}while(!checkNumbers(n));
		
		addToList(n);
		
		return n;
	}
	
	private void addToList(int n) {
		namedNumbers.add(n);
	}
	
	private boolean checkNumbers(int n) {
		int counter = 0;
		for(int i = 0; i < namedNumbers.size(); i++) {
			if(n == namedNumbers.get(i)) {
				counter++;
			}
		}
		if(counter == 0) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String list = printList();
		return "Named numbers: \n"+list;
	}
	
	public int[] setList() {
		for(int i = 0; i < listOfNumbers.length; i++) {
			listOfNumbers[i] = i+1;
		}
		shuffle();
		return listOfNumbers;
	}
	
	private void shuffle() {
		Random rnd = new Random();
		for(int i = 0; i < listOfNumbers.length; i++) {
			int random = rnd.nextInt(listOfNumbers.length);
			int aux = listOfNumbers[i];
			listOfNumbers[i] = listOfNumbers[random];
			listOfNumbers[random] = aux;
		}
	}
	
	
	public String printList() {
		String report = "";
		for(int i = 0; i < namedNumbers.size(); i++) {
			report += namedNumbers.get(i)+"\t";
			if(report.length() % 10 == 0) {
				report += "\n";
			}
		}
		return report;
	}

}