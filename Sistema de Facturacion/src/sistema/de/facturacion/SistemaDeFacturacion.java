/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.de.facturacion;

import java.sql.Connection;

/**
 *
 * @author Wilson
 */
public class SistemaDeFacturacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        conexion_mysql cc=new conexion_mysql();
        Connection cn=cc.conectar();
    }
    
}
