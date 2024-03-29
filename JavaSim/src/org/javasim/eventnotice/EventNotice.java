//This is a generic EventNotice object with EventTime and EventType attributes

//TODO: the raw object class is really dangerous here. I need to think of a better way to do this.

package org.javasim.eventnotice;

public class EventNotice {
	private double eventTime;
	private String eventType;
	private Object whichObject;

	// Add additional problem specific attributes here

	public EventNotice(double eventTime, String eventType, Object whichObject) {
		this.eventTime = eventTime;
		this.eventType = eventType;
		this.whichObject = whichObject;
	}

	public EventNotice(double eventTime, String eventType) {
		this.eventTime = eventTime;
		this.eventType = eventType;
	}

	public double getEventTime() {
		return eventTime;
	}

	public String getEventType() {
		return eventType;
	}

	public Object getWhichObject() {
		return whichObject;
	}

}
