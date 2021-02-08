package Cola;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Bombo {
	private ArrayList<Integer> hype;
	
	public Bombo(){
		hype = new ArrayList<Integer>();
		
		this.setHype();
		
	}
	
	public int getNext() {
		if(this.isEmpty()) {
			return -1;
		}
		Random ale  = new Random();
		int r = ale.nextInt(hype.size());
		int n = this.hype.get(r);
		this.hype.remove(r);
		
		return n;
	}
	
	public boolean isEmpty() {
		if(this.hype.size() == 0) {
			return true;
		}
		
		return false;
	}
	
	public void setHype() {
		for(int i = 1; i < 100; i++) {
			hype.add(i);
		}
		Collections.shuffle(hype);
	}
}
