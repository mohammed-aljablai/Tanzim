/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanzimfx;

import com.jfoenix.controls.JFXPasswordField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;


/**
 * FXML Controller class
 *
 * @author MC
 */
public class StudentsFXMLController implements Initializable {
  // important varable
  int myId = SharedData.getInstance().getId();
  String name = SharedData.getInstance().getName();
  Statement stateSentence;
  ResultSet theResult;
  // FXML varable
  @FXML
  private Label labalId;
  @FXML
  private Button logoutBut;
  @FXML
    private Label StuName;
  @FXML
  private Label labalLevel;
  
  //Password Updateing
  @FXML
  private JFXPasswordField newPassword;
  @FXML
  private JFXPasswordField newConfPassword;
  @FXML
  private Label wrongPssMsg;
  @FXML
  public void UpdatePassword(ActionEvent e){
    if(!(newPassword.getText().equals(newConfPassword.getText()))){
      wrongPssMsg.setText("Enter the same password int the tow filed");
      wrongPssMsg.setTextFill(Color.RED);
    }
    else if(newPassword.getText().isEmpty() || newConfPassword.getText().isEmpty()){
      wrongPssMsg.setText("Enter PassWord, please.");
      wrongPssMsg.setTextFill(Color.RED);
    }else{
      DataBaseConnection connect = new DataBaseConnection();
      Connection myConnect = connect.getConnection();
      String myStatement
          = "UPDATE STUDENTS SET PASSWORD=? WHERE STUDENTID=?";
      PreparedStatement statement;
      try {
        statement = myConnect.prepareStatement(myStatement);
        statement.setString(1, newPassword.getText());
        statement.setString(2, ""+myId);
        statement.execute();
        wrongPssMsg.setText("The password has changed Seccsuflly");
        wrongPssMsg.setTextFill(Color.GREEN);
      } catch (SQLException ex) {
        wrongPssMsg.setText("we have Faced Proplem in cinnection>");
        wrongPssMsg.setTextFill(Color.RED);
        System.err.println("The Erro: " + ex.getMessage());
      }
      newPassword.setText("");
      newConfPassword.setText("");
    }
  }
  
  
  // Table
  @FXML
  private TableView<StudyCourse> studyCourse;
  @FXML
  private TableColumn<StudyCourse, String> course;
  @FXML
  private TableColumn<StudyCourse, String> DoctorsenderName;
  @FXML
  private TableColumn<StudyCourse, Double> degree;
  
  public ObservableList<StudyCourse> addCourses(){
    ObservableList<StudyCourse> myCourses = FXCollections.observableArrayList();
    String statment="SELECT STUDENTS.NAME, SUBJECTS.NAME AS s_name, DOCTOR.NAME AS d_name, EDUCATION.DEGREE AS degree FROM SUBJECTS, DOCTOR, EDUCATION, STUDENTS WHERE STUDENTS.STUDENTID="+myId+" AND STUDENTS.STUDENTID=EDUCATION.STUDENTID AND DOCTOR.DOCTORID=EDUCATION.DOCTORID AND SUBJECTS.SUBJECTID=EDUCATION.SUBJECTID";
    DataBaseConnection c=new DataBaseConnection();
    Connection myConnect=c.getConnection();
    try {
      stateSentence = myConnect.createStatement();
      theResult = stateSentence.executeQuery(statment);
      while (theResult.next() && theResult != null) {
        StudyCourse data = new StudyCourse(theResult.getString("s_name"), theResult.getString("d_name"), theResult.getDouble("degree"));
        myCourses.add(data);
      }
    } catch (SQLException e) {
      System.err.println("The erro is: "+ e.getMessage());
      System.out.println("SQL: "+e.getSQLState());
      System.out.println("SQL: "+e.getErrorCode());
    }
    return myCourses;
  }
  private ObservableList<StudyCourse>addCourseDataList;
  public void addCourseShowDataList(){
    addCourseDataList=addCourses();
    course.setCellValueFactory(new PropertyValueFactory<>("SUBJECTS.NAME"));
    DoctorsenderName.setCellValueFactory(new PropertyValueFactory<>("DOCTOR.NAME"));
    degree.setCellValueFactory(new PropertyValueFactory<>("EDUCATION.DEGREE"));
    studyCourse.setItems(addCourseDataList);
  }
  
  
  // Generalization
  @FXML
  private TableView<GeneralizationDateList> GeneralizationDateList;
  @FXML
  private TableColumn<GeneralizationDateList, String> msg;
  @FXML
  private TableColumn<GeneralizationDateList, String> drName;
  @FXML
  private TableColumn<GeneralizationDateList, Date> date;
  public ObservableList<GeneralizationDateList> addMsg(){
    ObservableList<GeneralizationDateList> msg = FXCollections.observableArrayList();
    String statment
            ="SELECT DOCTOR.NAME As dr_name, CONTENT, HISTORYOFSEND  FROM GENERALIZATION, DOCTOR, STUDENTS, GROUPS WHERE STUDENTS.STUDENTID="+myId+" AND STUDENTS.GROUPID=GENERALIZATION.GROUPID AND DOCTOR.DOCTORID=GENERALIZATION.DOCTORID";
    DataBaseConnection c=new DataBaseConnection();
    Connection myConnect=c.getConnection();
    try {
      stateSentence = myConnect.createStatement();
      theResult = stateSentence.executeQuery(statment);
      while (theResult.next() && theResult != null) {
        GeneralizationDateList data = new GeneralizationDateList(theResult.getString("CONTENT"), theResult.getString("dr_name"), theResult.getDate("HISTORYOFSEND"));
        msg.add(data);
      }
    } catch (SQLException e) {
      System.err.println("The erro is: "+ e.getMessage());
      System.out.println("SQL: "+e.getSQLState());
      System.out.println("SQL: "+e.getErrorCode());
    }
    return msg;
  }
  private ObservableList<GeneralizationDateList>addMsgDataList;
  public void addMsgShowDataList(){
    addMsgDataList=addMsg();
    msg.setCellValueFactory(new PropertyValueFactory<>("CONTENT"));
    drName.setCellValueFactory(new PropertyValueFactory<>("dr_name"));
    date.setCellValueFactory(new PropertyValueFactory<>("HISTORYOFSEND"));
    GeneralizationDateList.setItems(addMsgDataList);
  }
  
  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    labalId.setText(""+myId);
    StuName.setText(name);
    labalLevel.setText("Level No."+ getLevelNumber());
    addCourseShowDataList();
    addMsgShowDataList();
  }
  
  public void closeWindow(ActionEvent e){
    // hide login page
    logoutBut.getScene().getWindow().hide();
  }
  private int getLevelNumber(){
    int lev=1;
    DataBaseConnection connect = new DataBaseConnection();
    Connection myConnect = connect.getConnection();
    String myStatement = "SELECT LEVELNUMBER FROM STUDENTS, GROUPS WHERE STUDENTID=? AND STUDENTS.GROUPID=GROUPS.GROUPID";
    try {
      PreparedStatement statement=myConnect.prepareStatement(myStatement);
      statement.setInt(1, myId);
      theResult = statement.executeQuery();
      while (theResult.next() && theResult != null) {
        lev=theResult.getInt("LEVELNUMBER");
      }
    } catch (SQLException e) {
      System.err.println("The error: " + e.getMessage()) ;
    }
    return lev;
  }
  @FXML
  void refreachGeneralization(ActionEvent event) {
    addMsgShowDataList();
  }
}
       
    
/*
  void openPDFAction(ActionEvent event) {
      try {
          // مسار ملف PDF الذي تريد فتحه
          File file = new File("C:\\Users\\MC\\Downloads\\Tanzim-main\\Tanzim-main\\tanzimFX\\cs.pdf");

          // التأكد من وجود الملف
          if (file.exists()) {
              // التأكد أن نظام التشغيل يدعم فتح الملفات الخارجية
              if (Desktop.isDesktopSupported()) {
                  Desktop desktop = Desktop.getDesktop();
                  desktop.open(file);  // فتح الملف باستخدام تطبيق PDF المثبت على النظام
              } else {
                  System.out.println("Desktop is not supported.");
              }
          } else {
              System.out.println("File does not exist.");
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
  // DashBoard var
  
*/
