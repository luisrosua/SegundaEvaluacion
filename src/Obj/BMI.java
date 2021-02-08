package Obj;

public class BMI {
	private double peso;
	private double altura;
	
	public BMI(double peso, double altura) {
		this.peso = peso;
		this.altura = altura;
	}
	
	public double getBMI(){
		double bmi = this.peso / Math.pow(this.altura, 2);
		return bmi;
	}
	
	public String report() {
		double bmi = getBMI();
		if(bmi < 18.5) 
			return "Peso por debajo de lo normal";
		
		if(bmi < 25)
			return "Peso normal";
		
		if(bmi < 30)
			return "Peso superior a lo normal";
		
		return "Obesidad";
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
}
