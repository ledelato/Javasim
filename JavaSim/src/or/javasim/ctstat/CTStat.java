package or.javasim.ctstat;
//Generic continuous-time statistics object

public class CTStat {
  private double area;
  private double tLast;
  
  //Executes when CTStat object is created to initialize variables
  public CTStat() {
    area = 0;
    tLast = 0;
  }
  
  public void record(double x, double time) {
    area += x*(time-tLast);
    tLast = time;
  }
  public double getMean() {
    double mean = area/tLast;
    return mean;
  }
  
  public void clear(double time) {
    area = 0;
    tLast = time;
  }
  
  
}
