
package tanzimfx;
import java.sql.Connection;
import java.sql.DriverManager;

class DataBaseConnection {
      public Connection connect;
  public Connection getConnection(){
    String DataBaseName = "orcl";
    String DataBaseUserName = "tanzim";
    String DataBasePassword = "mohgml1234";
    String DataBaseUrl = "jdbc:oracle:thin:@localhost:1521:"+DataBaseName;
    try {
      connect= DriverManager.getConnection(DataBaseUrl, DataBaseUserName, DataBasePassword);
    } catch (Exception e) {
      //System.err.println(e.getMessage());
      e.printStackTrace();
    }
    return connect;
  }
}
