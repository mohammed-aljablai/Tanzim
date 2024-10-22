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
import javafx.scene.control.Button;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginPageController implements Initializable {
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
  // log in and msg
  @FXML
  private Label wrongEnterMsg;

  // Methods
  @FXML
  // All logIn Action
  public void loginAction(ActionEvent e) {
    if (idFiled.getText().isEmpty() || passwordFiled.getText().isEmpty()) {
      wrongEnterMsg.setText("Please Fill ID and pasword");
    } else {
      if (isStudentChosen.isSelected()) {
        if (studentIsExists()) {
          try {
            openScene("StudentsFXML.fxml", "Tanzim Students");
          } catch (Exception ex) {
            System.err.println("The Erroe is: " + ex.getMessage());
          }
        } else {wrongEnterMsg.setText("Wrong ID or password.");}
      }else{
      if (doctorIsExists()) {
          try {
            openScene("DoctoerFXML.fxml", "Tanzim Doctor");
          } catch (Exception ex) {
            System.err.println("The Erroe is: " + ex.getMessage());
          }
        } else {wrongEnterMsg.setText("Wrong ID or password.");}
      }
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

  // Cheack if Student Exists
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
          SharedData.getInstance().setId(Integer.parseInt(idFiled.getText()));
          SharedData.getInstance().setName(theResult.getString("NAME"));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      isExists = false;
    }

    return isExists;
  }
  // Cheach if doctor Exists
  public boolean doctorIsExists() {
    boolean isExists = false;

    DataBaseConnection connect = new DataBaseConnection();
    Connection myConnect = connect.getConnection();
    String myStatement
            = "SELECT * FROM DOCTOR WHERE DOCTORID=" + Integer.parseInt(idFiled.getText()) + " and passWord='" + passwordFiled.getText() + "'";

    try {
      stateSentence = myConnect.createStatement();
      theResult = stateSentence.executeQuery(myStatement);
      while (theResult.next() && theResult != null) {
        if (theResult.getString("PASSWORD").equals(passwordFiled.getText())
                && theResult.getString("DOCTORID").equals(idFiled.getText())) {
          isExists = true;
          SharedData.getInstance().setId(Integer.parseInt(idFiled.getText()));
          SharedData.getInstance().setName(theResult.getString("NAME"));
          SharedData.getInstance().setExYreas(theResult.getInt("EXPERIENCEYEARS"));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      isExists = false;
    }

    return isExists;
  }
  
  
  // Opining a New window
  public void openScene(String fileName, String title) throws Exception {
    // hide login page
    loginButton.getScene().getWindow().hide();
    // show the new window
    Parent root = FXMLLoader.load(getClass().getResource(fileName));
    Stage stage = new Stage();
    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
    stage.setTitle(title);
  }

}
