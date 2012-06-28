// This class module creates an event calendar object
// which is a list of event notices ordered by event time.
// Based on a object created by Steve Roberts @ NCSU

package org.javasim.eventcalendar;

import java.util.ArrayList;

import or.javasim.eventnotice.EventNotice;

public class EventCalendar {
	private ArrayList<EventNotice> thisCalendar;

	public void schedule(EventNotice addedEvent) {
		int i;
		if (thisCalendar.size() == 0) {// no events in calendar
			thisCalendar.add(addedEvent);
		} else if (thisCalendar.get(thisCalendar.size() - 1).getEventTime() <= addedEvent
				.getEventTime()) {
			// added event after last event in calendar
			thisCalendar.add(addedEvent);
		} else { // search for the correct place to insert the event
			for (i = 0; i < thisCalendar.size(); i++) {
				if (thisCalendar.get(i).getEventTime() > addedEvent
						.getEventTime()) {
					break;
				}
			}
			thisCalendar.add(i, addedEvent);
		}
	}

	public EventNotice remove() {
		// Remove next event and return the EventNotice object
		if (thisCalendar.size() > 0) {
			EventNotice remove = thisCalendar.get(0);
			thisCalendar.remove(0);
			return remove;
		}
		return null;
	}

	public int getN() {
		return thisCalendar.size();
	}

}
