//This is a generic EventNotice object with EventTime and EventType attributes

//TODO: the raw object class is really dangerous here. I need to think of a better way to do this.

package org.javasim.eventnotice;

public class EventNotice {
	private final double eventTime;
	private final String eventType;
	private final Object whichObject;
	
	// Add additional problem specific attributes here
	
	public EventNotice(double eventTime, String eventType, Object whichObject) {
	  this.eventTime = eventTime;
	  this.eventType = eventType;
	  this.whichObject = whichObject;
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
