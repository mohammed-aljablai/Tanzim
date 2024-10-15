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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * FXML Controller class
 *
 * @author MC
 */
public class StudentsFXMLController implements Initializable {
  Students user = studentNeededMethods.sUser;
    // DashBoard var
  @FXML
  private Label StuName;
  @FXML
  private Label labalId;
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
    if(!(newPassword.getText().equals(newConfPassword.getText())))
      wrongPssMsg.setText("ENter the same password int the tow filed");
    else{
      DataBaseConnection connect = new DataBaseConnection();
      Connection myConnect = connect.getConnection();
      String myStatement
          = "UPDATE STUDENTS SET PASSWORD=? WHERE DOCTORID=?";
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
  @FXML
  //Generlztion Msg
  private Label DoctorsenderName[]=new Label[3];
  private Label History[]=new Label[3];
  private Label Contetnt[]=new Label[3];
  // Table
  @FXML
  private TableView<StudyCourse> studyCourse;
  @FXML
  private TableColumn<StudyCourse, String> course;
  @FXML
  private TableColumn<StudyCourse, String> TeacherName;
  @FXML
  private TableColumn<StudyCourse, Double> degree;
  public ObservableList<StudyCourse> addCourses(){
    StudyCourse data;
    ObservableList<StudyCourse> myCourses = FXCollections.observableArrayList();
    String statment="SELECT STUDENTS.\"NAME\", SUBJECTS.\"NAME\", DOCTOR.\"NAME\", EDUCATION.DEGREE FROM SUBJECTS, DOCTOR, EDUCATION, STUDENTS WHERE STUDENTS.STUDENTID=? AND STUDENTS.STUDENTID=EDUCATION.STUDENTID AND DOCTOR.DOCTORID=EDUCATION.DOCTORID AND SUBJECTS.SUBJECTID=EDUCATION.SUBJECTID";
    DataBaseConnection c=new DataBaseConnection();
    Connection conNew=c.getConnection();
    try {
      PreparedStatement pre = conNew.prepareStatement(statment);
      pre.setInt(1, Integer.parseInt(user.getId()));
      ResultSet Res = pre.executeQuery(statment);
      while (Res.next()) {
        data = new StudyCourse(Res.getString("DOCTOR.\"NAME\""), Res.getString("SUBJECTS.\"NAME\""), Res.getDouble("EDUCATION.DEGREE"));
        myCourses.add(data);
      }
    } catch (SQLException e) {
    }
    return myCourses;
  }
  private ObservableList<StudyCourse>addclintDataList;
  public void addclintDataListShowData(){
    addclintDataList=addCourses();
    course.setCellValueFactory(new PropertyValueFactory<>("SUBJECTS.\"NAME\""));
    TeacherName.setCellValueFactory(new PropertyValueFactory<>("DOCTOR.\"NAME\""));
    degree.setCellValueFactory(new PropertyValueFactory<>("EDUCATION.DEGREE"));
  }
  private Button OpenPDF;  // هذا هو معرف الزر الذي أضفته في SceneBuilder
  // الدالة التي يتم استدعاؤها عند الضغط على الزر
  @FXML
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
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    StuName.setText(user.getName());
    labalId.setText(user.getId());
    Group temp = user.getInGroup();
    labalLevel.setText("Level no."+temp.getLevelNumber());
  }
}
       
    

