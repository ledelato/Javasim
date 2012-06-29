package org.javasim.ctstat;

/**
 * 
 * @author ledelato Generic continuous-time statistics object. Note that CTStat
 *         should be called AFTER the value of the variable changes.
 */
public class CTStat {
	private double area;
	private double tLast;
	private double xLast;
	private double tClear;

	/**
	 * Initialize continuous-time statistic.
	 */
	public CTStat() {
		area = 0.0;
		tLast = 0.0;
		tClear = 0.0;
		xLast = 0.0;
	}

	/**
	 * 
	 * @param x
	 * @param time
	 */
	public void record(double x, double clock) {
		area = area + xLast * (clock - tLast);
		tLast = clock;
		xLast = x;
	}

	/**
	 * 
	 * @return
	 */
	public double mean(double clock) {
		double mean = 0;
		if (clock - tClear > 0) {
			mean = (area * xLast * (clock - tLast)) / (clock - tClear);
		}
		return mean;

	}

	/**
	 * 
	 * @param time
	 */
	public void clear(double clock) {
		area = 0.0;
		tLast = clock;
		tClear = clock;
	}

}
