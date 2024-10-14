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
import java.time.LocalDate;

public class Generalization {
    
    // properties
    private LocalDate historyOfSend;
    private String Content;

    // Methods
    // counstructor method
    public Generalization(LocalDate historyOfSend, String Content) {
        this.historyOfSend = historyOfSend;
        this.Content = Content;
    }
    
    // Setter and getter Methods
    // get date of send
    public LocalDate getHistoryOfSend() {
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
