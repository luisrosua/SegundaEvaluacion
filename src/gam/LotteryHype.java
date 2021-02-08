package gam;


import java.util.Random;

public class LotteryHype {
	
	int[] numbers;
	int top;
	
    public LotteryHype() {
    	this(99);
    }
    
    public LotteryHype(int n) {
    	numbers = new int[n];
    	initialize();
    	shuffling();
    	top =0;
    	
    }
    
    private void initialize() {
    	for (int i=0;i<this.numbers.length;i++)
    		this.numbers[i]=i+1;
    }
    private void shuffling() {
    	Random rd =new Random();
    	for (int i=0;i<this.numbers.length;i++) {
    		int j = rd.nextInt(this.numbers.length);
    		int aux = this.numbers[i];
    		this.numbers[i] = this.numbers[j];
    		this.numbers[j] = aux;
    		
    	}
    }
    
    public int nextNumber() {
    	if (top == this.numbers.length)
    		return -1;
    	return this.numbers[top++];
    }
}
