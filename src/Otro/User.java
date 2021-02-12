package Otro;

public class User {
	
	private int id;
	private String name;
	private String pass;
	
	public User(int id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}
	
	public String toString() {
		return this.name;
	}
	
}
