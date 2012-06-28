package org.javasim.javasim.resource;

import org.javasim.ctstat.CTStat;

public class Resource {
  private int numberOfUnits;
  private CTStat numBusy;
  private int busy;
  
  public Resource() {
    
  }
  
  public boolean seize(int units) {
	  int diff;
	  diff = numberOfUnits - units -busy;
	  if(diff >= 0) {
		  numBusy.record((double)busy, clock);
	  }
  }
}
