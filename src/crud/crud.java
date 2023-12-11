/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import connectionBD.MySQLConnection;

public class crud {
    public static void main(String[] args) throws SQLException {
        System.out.println("invocaremos el metodo a elegir");
        insertar();
    }

public static void insertar() throws SQLException{
    String nombre = "Gabriela";
    String apellido_p = "Gonzalez";
    String apellido_m = "López";
    int edad = 20;
    double sueldo = 10456.87;
    Connection cnx = null;
    cnx = (Connection) MySQLConnection.obtener();
    PreparedStatement inserta;
    
    
    
    inserta = cnx.prepareStatement("INSERT INTO crud (nombre, apellido_paterno, apellido_materno, edad, sueldo) "
            + "VALUES (?, ?, ?, ?, ?)");
    inserta.setString(1, nombre);
    inserta.setString(2, apellido_p);
    inserta.setString(3, apellido_m);
    inserta.setInt(4, edad);
    inserta.setDouble(5, sueldo);
    inserta.executeUpdate();
    System.out.println("Lo inserto con éxito");
}

public static void actualizar() throws SQLException{
    int id = 2;
    String nombre = "Adolfo";
    String apellido_p = "Arciniega";
    String apellido_m = "";
    int edad = 15;
    double sueldo = 923.87; 
    PreparedStatement actualiza;
    Connection cnx = null;
    cnx = MySQLConnection.obtener();
    
    actualiza = cnx.prepareStatement("UPDATE crud SET nombre = '" + nombre + "', apellido_paterno = '" + apellido_p + "',"
    + " apellido_materno = '"+ apellido_m + "', edad = " + edad + ", sueldo = " + sueldo + " WHERE id_transaccion = " + id);
    actualiza.executeUpdate();
    System.out.println("Lo actualizo con éxito");
}

public static void eliminar() throws SQLException {
    int id = 5;
    PreparedStatement elimina;
    Connection cnx = null;
    cnx = MySQLConnection.obtener();
    elimina = cnx.prepareStatement("DELETE FROM crud WHERE id_transaccion = " + id);
    elimina.executeUpdate();
    System.out.println("Lo elimino con éxico");
}

public static void listar() throws SQLException {
    String nombre = "", apellido_p = "", apellido_m;
    int edad = 0, id = 0;
    double sueldo = 0;
    Connection cnx = null;
    cnx = (Connection) MySQLConnection.obtener();
    Statement statement = cnx.createStatement();
    ResultSet result = statement.executeQuery("SELECT * from crud");
    
    int i = 1;
    while(result.next()){
        id = result.getInt("id_transaccion");
        nombre = result.getString("nombre");
        apellido_p = result.getString("apellido_paterno");
        apellido_m = result.getString("apellido_materno");
        edad = result.getInt("edad");
        sueldo = result.getDouble("sueldo");
        System.out.println("El no. " + i + " con ID: " + id + ", nombre : "+nombre+ ", apellido paterno: " + apellido_p +", edad: "+ edad+" y sueldo: " + sueldo + ".");
        i++;
    }
}
}
