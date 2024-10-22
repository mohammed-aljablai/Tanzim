/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tanzimfx;

/**
 *
 * @author Administrator
 */
public class TeacherGroups {
  private int groupID;
  private int levNo;
  private String Specilazation;
  private int groupNo;

  public TeacherGroups(int groupID, int levNo, String Specilazation, int groupNo) {
    this.groupID = groupID;
    this.levNo = levNo;
    this.Specilazation = Specilazation;
    this.groupNo = groupNo;
  }

  public int getGroupID() {
    return groupID;
  }
  public void setGroupID(int groupID) {
    this.groupID = groupID;
  }
  public int getLevNo() {
    return levNo;
  }
  public void setLevNo(int levNo) {
    this.levNo = levNo;
  }
  public String getSpecilazation() {
    return Specilazation;
  }
  public void setSpecilazation(String Specilazation) {
    this.Specilazation = Specilazation;
  }
  public int getGroupNo() {
    return groupNo;
  }
  public void setGroupNo(int groupNo) {
    this.groupNo = groupNo;
  }
  
}
