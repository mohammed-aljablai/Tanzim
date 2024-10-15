package tanzimfx;


public class StudyCourse {
  private String couseName;
  private String teacherName;
  private double avg;

  public StudyCourse(String couseName, String teacherName, double avg) {
    this.couseName = couseName;
    this.teacherName = teacherName;
    this.avg = avg;
  }

  public String getCouseName() {
    return couseName;
  }

  public void setCouseName(String couseName) {
    this.couseName = couseName;
  }

  public String getTeacherName() {
    return teacherName;
  }

  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }

  public double getAvg() {
    return avg;
  }

  public void setAvg(double avg) {
    this.avg = avg;
  }
  
  
}
