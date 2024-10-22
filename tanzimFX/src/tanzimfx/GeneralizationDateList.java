package tanzimfx;

import java.sql.Date;


public class GeneralizationDateList {
  private String msg;
  private String doctorName;
  private Date sendDate;

  public GeneralizationDateList(String msg, String doctorName, Date sendDate) {
    this.msg = msg;
    this.doctorName = doctorName;
    this.sendDate = sendDate;
  }

  public String getMsg() {
    return msg;
  }
  public void setMsg(String msg) {
    this.msg = msg;
  }
  public String getDoctorName() {
    return doctorName;
  }
  public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
  }
  public Date getSendDate() {
    return sendDate;
  }
  public void setSendDate(Date sendDate) {
    this.sendDate = sendDate;
  }
  
  
}
