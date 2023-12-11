/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connectionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MySQLConnection {

    private static Connection cnx = null;
    
    public static Connection obtener(){
        if (cnx == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud?verifyServerCertificate=false&useSSL=false","root","1234");
                cnx.setAutoCommit(true);
            } catch (SQLException | ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null, "No se logró establecer la conexion", "¡Advertencia!", JOptionPane.ERROR_MESSAGE);
            }
        }
        return cnx;
    }
    
    public static void cerrar() throws SQLException{
    if(cnx != null){
        cnx.close();
    }
}
}
    
