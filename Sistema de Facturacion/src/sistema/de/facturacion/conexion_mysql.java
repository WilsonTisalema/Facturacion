/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.facturacion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class conexion_mysql {
      Connection conexion=null;//crea un objeto de conexion almacena la conexion
    public Connection conectar() 
    {
        try {
            //Class.forName("com.mysql.jdbc.Drive");//empresa a la que hace referencia papi
            //Class.forName("com.mysql.jdbc.Driver"); 
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/leb", "root", "");
            //Class.forName("com.mysql.jdbc.Driver");
            //conexion=DriverManager.getConnection("jdbc:mysql://192.168.137.108/leb", "root", "password");
            //JOptionPane.showMessageDialog(null, "Conexion correcta");
            System.out.println("conexion");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion en la base "+ ex);
            //Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    public static void main(String[]args){
        //conectar();
    }
            
    
}
