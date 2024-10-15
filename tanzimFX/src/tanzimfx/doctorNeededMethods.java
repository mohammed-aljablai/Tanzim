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
package tanzimfx;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class doctorNeededMethods {
  public static Doctor dUser;
  Statement stateSentence;
  ResultSet theResult;
  DataBaseConnection connect = new DataBaseConnection();
  Connection myConnect = connect.getConnection();
  String myStatement;
  String id;

  public doctorNeededMethods() {
    try {
      creatStudentUser();
      addEdcate();
      addMsg();
    } catch (SQLException ex) {
      Logger.getLogger(doctorNeededMethods.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void creatStudentUser() throws SQLException{
    id = theResult.getString("DOCTORID");
    String name = theResult.getString("NAME");
    int experince = theResult.getInt("EXPERIENCEYEARS");
    dUser = new Doctor(experince, id, name);
  }
  public void addEdcate() throws SQLException{
    myStatement = "SELECT * FROM TANZIM.EDUCATION, TANZIM.DOCTOR WHERE EDUCATION.DOCTORID="+id+" And DOCTOR.DOCTORID=EDUCATION.DOCTORID";
    try {
      stateSentence = myConnect.createStatement();
      theResult = stateSentence.executeQuery(myStatement);
      while (theResult.next() && theResult != null) {
        dUser.setMyEdcate(theResult.getString("SUBJECTID"), theResult.getString("STUDENTID"), theResult.getString("DOCTORID"), theResult.getDouble("DEGREE"), theResult.getDate("THETEACHINGYEAR"));
      }
    } catch(SQLException e){ e.printStackTrace(); }
  }
  public void addMsg() throws SQLException{
    myStatement = "SELECT * FROM TANZIM.GENERALIZATION, TANZIM.GROUPS WHERE GENERALIZATION.DOCTORID="+id+" AND DOCTOR.DOCTORID=GENERALIZATION.DOCTORID";
    try {
      stateSentence = myConnect.createStatement();
      theResult = stateSentence.executeQuery(myStatement);
      while (theResult.next() && theResult != null) {
        dUser.setMyMsg(theResult.getString("GROUPID"), theResult.getDate("HISTORYOFSEND"), theResult.getString("CONTENT"));
      }
    } catch(SQLException e){ e.printStackTrace(); }
  }

}
