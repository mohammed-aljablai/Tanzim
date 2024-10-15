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

public final class studentNeededMethods {
  public static Students sUser;
  Statement stateSentence;
  ResultSet theResult;
  DataBaseConnection connect = new DataBaseConnection();
  Connection myConnect = connect.getConnection();
  String myStatement;
  String id;

  public studentNeededMethods() {
    try {
      creatStudentUser();
      addDegrees();
      addEdcate();
      addMsg();
    } catch (SQLException ex) {
      Logger.getLogger(studentNeededMethods.class.getName()).log(Level.SEVERE, null, ex);
    }
    
  }
  
  public void creatStudentUser() throws SQLException{
    id = theResult.getString("STUDENTID");
    String name = theResult.getString("NAME");
    Date tempBirthdate = theResult.getDate("BIRTHDATE");
    Documents userDoc = null;
    Group userGroup = null;
    myStatement = "SELECT * FROM TANZIM.STUDENTS, TANZIM.DOCUMENTS, TANZIM.GROUPS where GROUPS.GROUPID=STUDENTS.GROUPID AND DOCUMENTS.STUDENTID="+id+" AND STUDENTS.STUDENTID=DOCUMENTS.STUDENTID";
    try {
      stateSentence = myConnect.createStatement();
      theResult = stateSentence.executeQuery(myStatement);
      while (theResult.next() && theResult != null) {
        userDoc 
                = new Documents
          (theResult.getBoolean("PHOTOFORPROOFDOCUMENTS"), theResult.getBoolean("PERSONALPHOTO"), theResult.getBoolean("TRUECOPY"), theResult.getBoolean("HIGHSCHOOLCERTIFICATE"));
        userGroup = new Group(theResult.getInt("GROUPNAME"), theResult.getInt("LEVELNUMBER"), theResult.getString("SECTION"), theResult.getString("SPECIALIZATION"));
      }
    } catch(SQLException e){ e.printStackTrace(); }
    sUser = new Students(tempBirthdate, userDoc, userGroup, id, name);
  }
  public void addDegrees() throws SQLException{
    myStatement = "SELECT * FROM TANZIM.GRADE, TANZIM.STUDENTS WHERE GRADE.STUDENTID="+id+" and GRADE.STUDENTID=STUDENTS.STUDENTID";
    try {
      stateSentence = myConnect.createStatement();
      theResult = stateSentence.executeQuery(myStatement);
      while (theResult.next() && theResult != null) {
        sUser.setGrades(theResult.getDouble("DEGREE"));
      }
    } catch(SQLException e){ e.printStackTrace(); }
  }
  public void addEdcate() throws SQLException{
    myStatement = "SELECT * FROM TANZIM.EDUCATION, TANZIM.STUDENTS WHERE EDUCATION.STUDENTID="+id+" And STUDENTS.STUDENTID=EDUCATION.STUDENTID";
    try {
      stateSentence = myConnect.createStatement();
      theResult = stateSentence.executeQuery(myStatement);
      while (theResult.next() && theResult != null) {
        sUser.setMyEdcate(theResult.getString("SUBJECTID"), theResult.getString("STUDENTID"), theResult.getString("DOCTORID"), theResult.getDouble("DEGREE"), theResult.getDate("THETEACHINGYEAR"));
      }
    } catch(SQLException e){ e.printStackTrace(); }
  }
  public void addMsg() throws SQLException{
    myStatement = "SELECT * FROM TANZIM.GENERALIZATION, TANZIM.GROUPS, Tanzim.STUDENTS WHERE GROUPS.STUDENTID="+id+" AND STUDENTS.STUDENTID=GROUPS.STUDENTID AND GROUPS.GROUPID=GENERALIZATION.GROUPID";
    try {
      stateSentence = myConnect.createStatement();
      theResult = stateSentence.executeQuery(myStatement);
      while (theResult.next() && theResult != null) {
        sUser.setMyMsg(theResult.getString("GROUPID"), theResult.getString("DOCTORID"), theResult.getDate("HISTORYOFSEND"), theResult.getString("CONTENT"));
      }
    } catch(SQLException e){ e.printStackTrace(); }
  }

}
