package org.javasim.javasim.fifoqueue;

import java.util.ArrayList;
import java.util.Collection;

import org.javasim.ctstat.CTStat;

/**
 * This is a generic FIFO Queue object that also keeps track of statistics on
 * the number in queue (WIP) Last update 6/28/2010
 */

public class FifoQueue {
	private ArrayList<Object> thisQueue;
	CTStat wip;

	public FifoQueue(Collection<CTStat> theCTStats) {
		wip = new CTStat();
		thisQueue = new ArrayList<Object>();
		theCTStats.add(wip);

	}

	public int numQueue() {
		int numQueue = thisQueue.size();
		return numQueue;
	}

	public void add(Object thisEntity, double clock) {
		thisQueue.add(thisEntity);
		wip.record(thisQueue.size(), clock);
	}
	
	public Object remove(double clock) {
	  Object returnObj = null;
	  if(thisQueue.size() > 0) { 
		  returnObj = thisQueue.get(0);
		  thisQueue.remove(0);
	  }
	  wip.record(thisQueue.size(), clock);
	  
	  return returnObj;
	}
	
	public double mean(double clock) {
	  double mean = wip.mean(clock);
	  return mean;
	}
}
