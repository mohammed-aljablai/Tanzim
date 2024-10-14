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
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPageController implements Initializable {
  // My Class Variable
  
  // dataBase Variable
  Statement stateSentence = null;
  ResultSet theResult = null;
  // FX variable 
  //login Enter
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
    if (idFiled.getText().isEmpty() || passwordFiled.getText().isEmpty())
      wrongEnterMsg.setText("Please Fill ID and pasword");
    else{
      if(!isStudentChosen.isDisable()){
        wrongEnterMsg.setText("Students focuse");
      }
      else if(false){}
      else
        wrongEnterMsg.setText("Wrong ID or password.");
    }
  }
  
//  @FXML
//  private void handleButtonAction(ActionEvent event) {
//  }

  public boolean accountIsExists() {
    boolean isExists = false;

    DataBaseConnection connect = new DataBaseConnection();
    Connection myConnect = connect.getConnection();
    String myStatement
            = "select * from students where studentID=" + Integer.valueOf(idFiled.getText()) + " and passWord='" + passwordFiled.getText() + "';";
    try {
      stateSentence = myConnect.createStatement();
      theResult = stateSentence.executeQuery(myStatement);
//            /*
      while (theResult.next() && theResult != null) {
        if (theResult.getString("PASSWORD").equals(passwordFiled.getText())
                && theResult.getString("STUDENTID").equals(idFiled.getText())) {
          isExists = true;
        }
        
      }
//      */
      isExists = true;
    } catch (SQLException e) {
//isExists=true;
            System.err.println(e.getMessage());
    }
    return isExists;
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

}
