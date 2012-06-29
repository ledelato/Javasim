package org.javasim.javasim.resource;

import java.util.Collection;

import org.javasim.ctstat.CTStat;

public class Resource {
	private int numberOfUnits;
	private CTStat numBusy;
	private int busy;

	public Resource(Collection<CTStat> theCTStats) {
		numberOfUnits = 0;
		numBusy = new CTStat();
		theCTStats.add(numBusy);
	}

	public boolean seize(int units, double clock) {
		int diff = numberOfUnits - units - busy;
		if (diff >= 0) {
			numBusy.record(busy, clock);
			busy += units;
			numBusy.record(busy, clock);
			return true;
		}
		return false;
	}

	public boolean free(int units, double clock) {
		int diff = busy - units;
		if (diff < 0) {
			return false;
		}
		busy -= units;
		numBusy.record(busy, clock);
		return true;
	}

	public double mean(double clock) {
		return numBusy.mean(clock);
	}

	public void setUnits(int units) {
		numberOfUnits = units;
	}
	
	public void setBusy(int busy) {
		this.busy = busy;
	}
}
