import java.util.*;

public class EventManager {
	private long currentDate;
	private LinkedList<Event> events = new LinkedList<Event>();

	public long getcurrentDate() {
		return this.currentDate;
	}

	public LinkedList<Event> getEvents() {
		return this.events;
    }

	public void addEvent(Event e) {
		this.events.add(e);
		Collections.sort(this.events); //on ordonne suivant la date d'éxécution
	}

	public void next() {
		this.currentDate++;
		for (Event e : this.events) {
			if ((e.getDate() <= this.currentDate) && (e.getDate() > this.currentDate-1)) {
				e.execute();
			}
		}
	}

	public boolean isFinished() {
		boolean temp = false;
		
		Iterator <Event> it = this.events.iterator() ;
		while ((temp == false) && (it.hasNext())) {
			Event e = it.next();
			if (e.getDate() >= this.currentDate) {
			 temp = true;
			} 
			
		}

		return !temp;
	}

	public void restart() {
		this.currentDate = 0;
	}
}