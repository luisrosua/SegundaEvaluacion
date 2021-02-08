package Obj;

import java.util.Scanner;

public class TestBMI {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		double peso;
		double altura;
		
		System.out.println("Introduce tu peso en Kg: ");
		peso = input.nextDouble();
		
		System.out.println("Introduce tu altura en m");
		altura = input.nextDouble();
		
		BMI bmi = new BMI(peso, altura);
		
		System.out.println("Tu IMC es: "+bmi.getBMI()+"....."+bmi.report());
	}
}
