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
  private Date TeachingYear;
  private String sp;

  public TechCourse(String couseName, Date TeachingYear, String sp) {
    this.couseName = couseName;
    this.TeachingYear = TeachingYear;
    this.sp = sp;
  }

  public String getCouseName() {
    return couseName;
  }

  public void setCouseName(String couseName) {
    this.couseName = couseName;
  }

  public Date getTeachingYear() {
    return TeachingYear;
  }

  public void setTeachingYear(Date TeachingYear) {
    this.TeachingYear = TeachingYear;
  }

  public String getSp() {
    return sp;
  }

  public void setSp(String sp) {
    this.sp = sp;
  }
  
  
  
}
