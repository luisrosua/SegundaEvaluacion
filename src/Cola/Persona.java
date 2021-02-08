package Cola;

import java.util.Date;

public class Persona {
	private static int counter = 0;
	
	private int id;
	private String name;
	private Date date;
	private int priority;
	
	private String [] listOfNames = {"Luis","Juan","Maria","Teresa","Pedro"};
	
	public Persona(){
		this.id = counter;
		this.name = listOfNames[(int) (Math.random()*5)];
		this.date = new Date();
		this.priority = (int) (Math.random()*3)+1;
		
		counter++;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return this.id + "   " + this.name + "  " + this.date + "  " + this.priority;
	}
	
	
}
