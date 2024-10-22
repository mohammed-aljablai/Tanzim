/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanzimfx;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DoctoerFXMLController implements Initializable {
    // important varable
  int myId = SharedData.getInstance().getId();
  String name = SharedData.getInstance().getName();
  int exYears = SharedData.getInstance().getExYreas();
  Statement stateSentence;
  ResultSet theResult;
  // FXML varable
  @FXML
  private Label labalId;
  @FXML
  private Button logoutBut;
  @FXML
  private Label drName;
  @FXML
  private Label labalExprince;
  
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
      wrongPssMsg.setText("Enter the same password in the tow filed");
      wrongPssMsg.setTextFill(Color.RED);
    }
    else if(newPassword.getText().isEmpty() || newConfPassword.getText().isEmpty()){
      wrongPssMsg.setText("Enter PassWord, please.");
      wrongPssMsg.setTextFill(Color.RED);
    }else{
      DataBaseConnection connect = new DataBaseConnection();
      Connection myConnect = connect.getConnection();
      String myStatement
          = "UPDATE DOCTOR SET PASSWORD=? WHERE DOCTORID=?";
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

  // sending msg
  @FXML
  private JFXTextArea msg;
  @FXML
  private JFXTextField groupId;
  @FXML
  private Label msgWrong;
  @FXML
  private Button sendingBut;
  public void sendingEvents(ActionEvent e){
    if(groupId.getText().isEmpty() || msg.getText().isEmpty()){
      msgWrong.setText("Please Fill them first.");
      msgWrong.setTextFill(Color.RED);
    } else if(groupIsExist()){
      insetIntoGenerlzation();
    }
    else{
      msgWrong.setText("Wrong Group Id, please Cheack.");
      msgWrong.setTextFill(Color.RED);
    }
  }
  public void insetIntoGenerlzation(){
      DataBaseConnection connect = new DataBaseConnection();
      Connection myConnect = connect.getConnection();
      String myStatement
            = "INSERT INTO GENERALIZATION (DOCTORID, GROUPID, HISTORYOFSEND, CONTENT) VALUES (?, ?, ?, ?)";
      PreparedStatement statement;
      try {
        statement = myConnect.prepareStatement(myStatement);
        statement.setInt(1, myId);
        statement.setInt(2, Integer.parseInt(groupId.getText()));
        Date sendDate = Date.valueOf(LocalDate.now());
        statement.setDate(3, sendDate);
        statement.setString(4, msg.getText());
        statement.execute();
        msgWrong.setText("It has send seccsuflly.");
        msgWrong.setTextFill(Color.GREEN);
        groupId.setText("");
        msg.setText("");
      } catch (SQLException ex) {
        msgWrong.setText("wrong in connection. The Error: " + ex.getMessage());
        msgWrong.setTextFill(Color.RED);
      }
    }
  public boolean groupIsExist(){
    boolean isExist= false;
    
    DataBaseConnection connect = new DataBaseConnection();
    Connection myConnect = connect.getConnection();
    String myStatement
            = "SELECT GROUPID FROM GROUPS";

    try {
      stateSentence = myConnect.createStatement();
      theResult = stateSentence.executeQuery(myStatement);
      while (theResult.next() && theResult != null) {
        if (theResult.getInt("GROUPID") == Integer.parseInt(groupId.getText()) ) {
          isExist = true;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      isExist = false;
    }
    return isExist;
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    drName.setText("Dr." + name);
    labalId.setText(""+myId);
    labalExprince.setText("Exprince " + exYears + " years");
  }
  public void CloseWindow() throws Exception {
    // hide login page
    logoutBut.getScene().getWindow().hide();
  }
    
}

/*
Doctor user;
    // DashBoard var
    @FXML
    private Label drName;
    @FXML
    private Label labalId;
    @FXML
    private Label labalExprince;
    // Circlure var
    @FXML
    private JFXTextArea content;
    @FXML
    private JFXTextField groupID;
    @FXML
    public void insetIntoGenerlzation(ActionEvent e){
      DataBaseConnection connect = new DataBaseConnection();
      Connection myConnect = connect.getConnection();
      String myStatement
            = "INSERT INTO GENERALIZATION (DOCTORID, GROUPID, HISTORYOFSEND, CONTENT) VALUES (?, ?, ?, ?);";
      PreparedStatement statement;
      try {
        statement = myConnect.prepareStatement(myStatement);
        statement.setString(1, user.getId());
        statement.setString(2, groupID.getText());
        Date sendDate = null;
        statement.setDate(3, sendDate);
        statement.setString(4, content.getText());
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
    //Password Updateing
    @FXML
    private JFXPasswordField newPassword;
    @FXML
    private JFXPasswordField newConfPassword;
    @FXML
    private Label wrongPssMsg;
    @FXML
    public void UpdatePassword(ActionEvent e){
      if(!(newPassword.getText().equals(newConfPassword.getText())))
        wrongPssMsg.setText("ENter the same password int the tow filed");
      else{
        DataBaseConnection connect = new DataBaseConnection();
        Connection myConnect = connect.getConnection();
        String myStatement
            = "UPDATE DOCTOR SET PASSWORD=? WHERE DOCTORID=?";
        PreparedStatement statement;
        try {
          statement = myConnect.prepareStatement(myStatement);
          statement.setString(1, newPassword.getText());
          statement.setString(2, user.getId());
        } catch (SQLException ex) {
        ex.printStackTrace();
        }
      }
    }
    //Close window var
    private Button logOut;
  // Table
  TechCourse dataforTeacher;
  @FXML
  private TableView<TechCourse> taCourse;
  @FXML
  private TableColumn<TechCourse, String> course;
  @FXML
  private TableColumn<TechCourse, String> TeacherName;
  @FXML
  private TableColumn<TechCourse, Date> degree;
  public ObservableList<TechCourse> addCourses(){
    
    ObservableList<TechCourse> myCourses = FXCollections.observableArrayList();
    String statment="SELECT STUDENTS.\"NAME\", SUBJECTS.\"NAME\", DOCTOR.\"NAME\", EDUCATION.DEGREE FROM SUBJECTS, DOCTOR, EDUCATION, STUDENTS WHERE DOCTOR.DOCTORID=? AND STUDENTS.STUDENTID=EDUCATION.STUDENTID AND DOCTOR.DOCTORID=EDUCATION.DOCTORID AND SUBJECTS.SUBJECTID=EDUCATION.SUBJECTID";
    DataBaseConnection c=new DataBaseConnection();
    Connection conNew=c.getConnection();
    try {
      PreparedStatement pre = conNew.prepareStatement(statment);
      pre.setInt(1, Integer.parseInt(user.getId()));
      ResultSet Res = pre.executeQuery(statment);
      while (Res.next()) {
        dataforTeacher = new TechCourse(Res.getString("SUBJECTS.\"NAME\""), Res.getDate("THETEACHINGYEAR"), Res.getString("SUBJECTS.\"NAME\""));
        myCourses.add(dataforTeacher);
      }
    } catch (SQLException e) {
    }
    return myCourses;
  }
  private ObservableList<TechCourse>addclintDataList;
  public void addclintDataListShowData(){
    addclintDataList=addCourses();
    course.setCellValueFactory(new PropertyValueFactory<>("SUBJECTS.\"NAME\""));
    TeacherName.setCellValueFactory(new PropertyValueFactory<>("DOCTOR.\"NAME\""));
    degree.setCellValueFactory(new PropertyValueFactory<>("EDUCATION.DEGREE"));
  }
*/
