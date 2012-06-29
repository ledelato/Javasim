package org.javasim.ctstat;


/**
 * 
 * @author ledelato
 * Generic continuous-time statistics object.
 */
public class CTStat {
  private double area;
  private double tLast;
  
  /**
   * Initialize continuous-time statistic.
   */
  public CTStat() {
    area = 0;
    tLast = 0;
  }
  
  /**
   * 
   * @param x
   * @param time
   */
  public void record(double x, double time) {
    area += x*(time-tLast);
    tLast = time;
  }
  
  /**
   * 
   * @return
   */
  public double getMean() {
    double mean = area/tLast;
    return mean;
  }
  
  /**
   * 
   * @param time
   */
  public void clear(double time) {
    area = 0;
    tLast = time;
  }
  
  
}
