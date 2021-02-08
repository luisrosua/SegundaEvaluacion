package Cola;

public class TestBombo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bombo bombo = new Bombo();
		
		int max = 7;
		int c = 0;
		do {
			if(bombo.isEmpty()) {
				System.out.println("Is empty");
			}
			System.out.println("Next number: "+bombo.getNext());
			c++;
		}while(c < max);
	}

}
