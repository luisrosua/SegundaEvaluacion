package Database;

import java.util.ArrayList;
import java.util.Scanner;

import Otro.Message;
import Otro.User;

public class TestDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DBEmail db = new DBEmail();
			
			//System.out.println("You are connected to EMAIL");
			
			User user; //a
			
			int op;
			
			do {
				op = menu();
				switch(op) {
				case 1: user = login(db);
						if(user != null) {
							insideSystem(db, user);
						}
						else {
							System.out.println("You have to register");
						}
						break;
				case 2: boolean inserted = newUser(db);
						if(inserted) {
							System.out.println("You are registered");
						}
						else {
							System.out.println("Problems with registration");
						}
				}
			}while(op != 4);
			
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
	
	public static int menu() {
		int op;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Menu");
		System.out.println(".....");
		System.out.println("1. Log in");
		System.out.println("2. Register");
		op = input.nextInt();
		
		return op;
	}
	
	public static User login(DBEmail db) throws Exception{
		User u;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Login: ");
		System.out.println("Enter your name");
		String name = input.next();
		System.out.println("Enter your password");
		String password = input.next();
		
		u = db.getUser(name, password);
		
		return u;
		
	}
	
	public static boolean newUser(DBEmail db) throws Exception{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Login: ");
		System.out.println("Enter your name");
		String name = input.next().toUpperCase();
		System.out.println("Enter your password");
		String password = input.next();
		
		return db.newUser(name, password);
	}
	
	public static void insideSystem(DBEmail db, User user) throws Exception{
		System.out.println("Welcome ");
		
		int op = 0;
		do {
			op = loggedMenu();
			switch(op) {
			case 1:
				ArrayList<Message> m = db.getMessages(user);
				printMessages(m); break;
			case 2:sendAMessage(user, db); break;
			}
		}while(op > 3);
	}
	
	public static String printMessages(ArrayList<Message> m) {
		String report = "";
		for(int i = 0; i < m.size(); i++) {
			report += m.get(i).toString()+"\n";
		}
		return report;
	}
	
	public static int loggedMenu() {
		Scanner input = new Scanner(System.in);
		int op;
		System.out.println("1. View messages");
		System.out.println("2. Send a message");
		
		op = input.nextInt();
		return op;
	}
	
	public static void sendAMessage(User u, DBEmail db) throws Exception{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the id of the adressee: ");
		int destiny = input.nextInt();
		System.out.println("Write the message: ");
		String text = input.next();
		
		Message m = new Message(text, u.getId(), destiny, true);
		db.sendMessage(m);
	}

}
