package org.javasim.entity;
//This is a generic entity that has a single attribute CreateTime

public class Entity {
  private final double createTime;
  
  Entity(double createTime) {
    this.createTime = createTime;
  }
  
  public double getCreateTime() {
    return createTime;
  }
}
