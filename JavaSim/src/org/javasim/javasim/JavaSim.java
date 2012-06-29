/**
 * THIS IS JAVASIM
 * Javasim is a minimal collection of functions to support
 * discrete-event simulation programming in Java.
 *  Random-number and variate generation routines borrowed from simlib (Law 2007)
 * and translated into Java by Luis de la Torre
 */

//TODO: figure out how to do global variables

package org.javasim.javasim;

import java.util.ArrayList;
import java.util.Collection;

import org.javasim.ctstat.CTStat;
import org.javasim.dtstat.DTStat;
import org.javasim.eventcalendar.EventCalendar;
import org.javasim.eventnotice.EventNotice;
import org.javasim.javasim.fifoqueue.FifoQueue;
import org.javasim.javasim.resource.Resource;

public class JavaSim {

	public double clock; // simulation global clock
	public EventCalendar calendar; // event calendar

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
		while (calendar.N() > 0) {
			calendar.remove();
		}
		for (FifoQueue q : theQueues) {
			while (q.numQueue() > 0) {
				q.remove(clock);
			}
		}
		for (CTStat ct : theCTStats) {
			ct.clear(clock);
		}
		for (DTStat dt : theDTStats) {
			dt.clear();
		}

		for (Resource re : theResources) {
			re.setBusy(0);
		}

	}

	public JavaSim() {
		theCTStats = new ArrayList<CTStat>();
		theDTStats = new ArrayList<DTStat>();
		theQueues = new ArrayList<FifoQueue>();
		theResources = new ArrayList<Resource>();
	}

	public void schedule(String eventType, double eventTime) {
		EventNotice addedEvent = new EventNotice(clock + eventTime, eventType);
		calendar.schedule(addedEvent);
	}

	public void report() {
		// TODO: write a csv writer that will write the output
	}

	public void schedulePlus(String eventType, double eventTime,
			Object theObject) {
		EventNotice addedEvent = new EventNotice(clock + eventTime, eventType,
				theObject);
		calendar.schedule(addedEvent);
	}

	public void clearStats() {
		for (CTStat ct : theCTStats) {
			ct.clear(clock);
		}

		for (DTStat dt : theDTStats) {
			dt.clear();
		}
	}

}
