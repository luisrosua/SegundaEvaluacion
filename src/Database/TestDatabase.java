package Database;

import Otro.User;

public class TestDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DBEmail db = new DBEmail();
			System.out.println("You are connected to EMAIL");
			User u = db.getUser("PEPE", "1234");
			if(u == null) {
				System.out.println("It is not in the DB");
			} else {
				System.out.println(u);
			}
		}
		catch(Exception ex) {
			System.out.println("Red code You are NOT connected to EMAIL"+ex.toString());
		}
	}

}
