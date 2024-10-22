/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tanzimfx;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class TechCourse {
  private String couseName;
  private int TeachingYear;

  public TechCourse(String couseName, int TeachingYear){
    this.couseName = couseName;
    this.TeachingYear = TeachingYear;
  }
  public String getCouseName() {
    return couseName;
  }
  public void setCouseName(String couseName) {
    this.couseName = couseName;
  }
  public int getTeachingYear() {
    return TeachingYear;
  }
  public void setTeachingYear(int TeachingYear) {
    this.TeachingYear = TeachingYear;
  }
  
}
