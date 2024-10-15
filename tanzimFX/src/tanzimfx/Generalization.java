/*
 - This project call tanzim.
 - tanzim: is a project where orgnize the stuednt and the doctor, in addtion
   the emplyee life> from sending msg update degree and more...
 - this project have been worked by:
   - Mohammed Abdullh Al-jablai
   - Gamal Aldeen Al-hakl
   - Youseef Al-asadi
   - abdAlmalik
*/
/*
    - this sender and recevier msg class
*/
package tanzimfx;
import java.sql.Date;
import java.time.LocalDate;

public class Generalization {
    
    // properties
    private String groupID;
    private String doctorId;
    private Date historyOfSend;
    private String Content;

    // Methods
    // counstructor method
  public Generalization(String groupID, String doctorId, Date historyOfSend, String Content) {
    this.groupID = groupID;
    this.doctorId = doctorId;
    this.historyOfSend = historyOfSend;
    this.Content = Content;
  }
    
    
    // Setter and getter Methods
    // get date of send
    public Date getHistoryOfSend() {
        return historyOfSend;
    }
    // set and get content
    public String getContent() {
        return Content;
    }
    public void setContent(String Content) {
        this.Content = Content;
    }
    
    
}
