import java.util.*;

abstract class Event implements Comparable<Event> {
    private long date;

    public long getDate() {
	return this.date;
    }

    public Event(long date) {
	this.date = date;
    }

    @Override
    public int compareTo(Event e) {
	long diff = this.date - e.date;
	if (diff > 0) {
	    return 1;
	} else if (diff ==0) {
	    return 0;
	} else {
	    return -1;
	}
    }

    abstract void execute();
}
