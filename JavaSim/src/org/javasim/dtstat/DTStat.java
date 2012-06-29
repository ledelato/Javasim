//Generic discrete-time statistics object
package org.javasim.dtstat;

public class DTStat {
	private double sum;
	private double sumSquared;
	private double numberOfObservations;

	// Executes when DTStat object is created to initialize variables
	public DTStat() {
		sum = 0.0;
		sumSquared = 0.0;
		numberOfObservations = 0.0 ;
		numberOfObservations = 0.0 ;
	}

	public void record(double x) {
		sum += x;
		sumSquared += x * x;
		numberOfObservations++;
	}

	public double mean() {
		double mean = sum / numberOfObservations;
		return mean;
	}

	public double stdDev() {
		if(numberOfObservations > 1.0) {
		return Math.sqrt((sumSquared - sum * sum
				/ numberOfObservations)
				/ (numberOfObservations - 1.0));
		}
		return 0;
	}
	
	public void clear() {
	  sum = 0.0;
	  sumSquared = 0.0;
	  numberOfObservations = 0.0;
	}
}
