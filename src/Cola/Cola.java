package Cola;

import java.util.ArrayList;
import java.util.Date;

public class Cola extends Persona{
	private ArrayList<Persona> queue;
	
	public Cola() {
		queue = new ArrayList<Persona>();
	}
	
	public void add(Persona p) {
		queue.add(p);
	}
	
	public void remove() {
		System.out.println(queue.get(0).getName()+" has gone");
		queue.remove(0);
	}
	
	public void removeAll() {
		for(int i = 0; i < queue.size(); i++) {
			queue.remove(i);
		}
		System.out.println("The queue is empty!");
	}
	
	public String toString() {
		String report = "";
		
		for(int i = 0; i < queue.size(); i++) {
			report += queue.get(i).toString() + "\n";
		}
		
		return report;
	}
	
	public void orderQueue() {
		ArrayList<Persona> orderedQueue = new ArrayList<Persona>();
		
		int limit = (int) (queue.size());
		do {
			int i = 0;
			// if(priorities(queue.get(i).getPriority())) {
			// 	orderedQueue.add(queue.get(i));
			// }
			if(queue.get(i+1).getPriority() < queue.get(i).getPriority()) {
				orderedQueue.add(queue.get(i+1));
			}
			i++;
		}while(orderedQueue.size() != limit);
		
		for(int i = 0; i < orderedQueue.size(); i++) {
			queue.set(i, orderedQueue.get(i));
		}
	}
}
	
/*	public boolean priorities(int priority) {
		int counter = 0;
		for(int i = 0; i < queue.size(); i++) {
			if(queue.get(i).getPriority() > priority) {
				counter++;
			}
		}
		if(counter != 0) {
			return false;
		}
		return true;
	}
	
}
*/
// Mayores de 65 años
// Sanitarios 
// Personas expuestas