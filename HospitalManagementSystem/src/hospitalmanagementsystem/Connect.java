package hospitalmanagementsystem;



/**
 *
 * @author Raj
 */
import java.sql.*;
import javax.swing.*;
public class Connect 
{
     Connection con=null;
   
        public static Connection ConnectDB(){
             try{
           
          Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clinicmanagement","root","root");
         return con;
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
    }      
}
}
