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
import javafx.stage.Stage;

public class DoctoerFXMLController implements Initializable {
    Doctor user = doctorNeededMethods.dUser;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        drName.setText("Dr."+user.getName());
        labalId.setText(user.getId());
        labalExprince.setText("Exprince "+user.getExperienceYears()+ " years");
    }    
    
    public void CloseWindow() throws Exception{
      // hide login page
      logOut.getScene().getWindow().hide();
    }
    
}
