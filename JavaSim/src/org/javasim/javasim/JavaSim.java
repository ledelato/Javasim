/**
 * THIS IS JAVASIM
 * Javasim is a minimal collection of functions to support
 * discrete-event simulation programming in Java.
 *  Random-number and variate generation routines borrowed from simlib (Law 2007)
 * and translated into Java by Luis de la Torre
*/

//TODO: figure out how to do global variables

package org.javasim.javasim;

import java.util.Collection;

import org.javasim.ctstat.CTStat;
import org.javasim.dtstat.DTStat;
import org.javasim.eventcalendar.EventCalendar;
import org.javasim.javasim.resource.Resource;

public class JavaSim {
  
	public double clock;               //simulation global clock
	public EventCalendar calendar;     //event calendar

	// Set up Collections to be reinitialized between replications

	public Collection<CTStat> theCTStats;
	public Collection<DTStat> theDTStats;
	public Collection<FifoQueue> theQueues;
	public Collection<Resource> theResources;
	
	public void vbaSimInit() {
	  
	  /**
	   * Reset time and empty event calendar
	   */
	  clock = 0;
	  calendar.remove();
	}
}
