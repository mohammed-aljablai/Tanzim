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

import java.net.URL;
import java.util.ResourceBundle;
import java.time.LocalDate;
// graphic inter face
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
// for data base connection
import java.sql.Connection;
import java.sql.Date;
import javafx.scene.control.Button;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginPageController implements Initializable {

  // My Class Variable
  // dataBase Variable
  Statement stateSentence;
  ResultSet theResult;
  // FX variable 
  //login Enter
  @FXML
  private Button loginButton;
  //filed
  @FXML
  private JFXTextField idFiled;
  @FXML
  private JFXPasswordField passwordFiled;
  // text
  // Chosen button
  @FXML
  private JFXRadioButton isStudentChosen;
  private JFXRadioButton isDoctorChosen;
  // log in and msg
  @FXML
  private Label wrongEnterMsg;

  // Methods
  @FXML
  public void loginAction(ActionEvent e) {
    if (idFiled.getText().isEmpty() || passwordFiled.getText().isEmpty()) {
      wrongEnterMsg.setText("Please Fill ID and pasword");
    } else {
      if (isStudentChosen.isSelected()) {
        if (studentIsExists()) {
          wrongEnterMsg.setText("You have sing in Seccusfully");
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentsFXML.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.show();
          } catch (Exception ee) {
            ee.printStackTrace();
          }
        } else {
          wrongEnterMsg.setText("Wrong ID or password.");
        }
      } else {
        if (doctorIsExists()) {
          wrongEnterMsg.setText("You have sing in Seccusfully");
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DoctoerFXML.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.show();
          } catch (Exception ex) {
            Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      } 
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }
//  @FXML

  public boolean studentIsExists() {
    boolean isExists = false;

    DataBaseConnection connect = new DataBaseConnection();
    Connection myConnect = connect.getConnection();
    String myStatement
            = "select * from Students where studentID=" + Integer.parseInt(idFiled.getText()) + " and passWord='" + passwordFiled.getText() + "'";

    try {
      stateSentence = myConnect.createStatement();
      theResult = stateSentence.executeQuery(myStatement);
      while (theResult.next() && theResult != null) {
        if (theResult.getString("PASSWORD").equals(passwordFiled.getText())
                && theResult.getString("STUDENTID").equals(idFiled.getText())) {
          isExists = true;
          studentNeededMethods myStudentObj = new studentNeededMethods();
       }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      isExists = false;
    }

    return isExists;
  }

  public boolean doctorIsExists() {
    boolean isExists = false;

    DataBaseConnection connect = new DataBaseConnection();
    Connection myConnect = connect.getConnection();
    String myStatement
            = "select * from DOCTOR where DOCTORID=" + Integer.parseInt(idFiled.getText()) + " and passWord='" + passwordFiled.getText() + "'";

    try {
      stateSentence = myConnect.createStatement();
      theResult = stateSentence.executeQuery(myStatement);
      while (theResult.next() && theResult != null) {
        if (theResult.getString("PASSWORD").equals(passwordFiled.getText())
                && theResult.getString("DOCTORID").equals(idFiled.getText())) {
          isExists = true;
          doctorNeededMethods myDrObj = new doctorNeededMethods();
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      isExists = false;
    }

    return isExists;
  }
  
  /*
  public void openStudentScene() throws Exception {
    // hide login page
   // loginButton.getScene().getWindow().hide();
    // show the new window
    FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentsFXML.fxml"));
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));
    stage.show();
  }
  public void openDoctorScene() throws Exception {
    // hide login page
    loginButton.getScene().getWindow().hide();
    // show the new window
    FXMLLoader loader = new FXMLLoader(getClass().getResource("DoctoerFXML.fxml"));
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));
    stage.setTitle("Tanzim - Student");
    stage.show();
  }
  */
}
