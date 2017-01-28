/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//hola..
package sistema.de.facturacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Benjita
 */
public class AgregarProductos extends javax.swing.JFrame {

    /**
     * Creates new form AgregarProductos
     */
    public AgregarProductos() {
        initComponents();
        String[] titulos = {"Código", "Código Pro.", "Descripcion", "Fabricante", "Cantidad"};
        modelo = new DefaultTableModel(null, titulos);
        jtblIngreso.setModel(modelo);
    }
    DefaultTableModel modelo;

    public void ingresoStockGNI12() {
        String codigoBarras = txtCodPro.getText().trim();
        String codigo = codigoBarras.substring(1, 6);
        //System.out.println(codigo);
        String fabricante = verificaEmpresa12(codigo);
        // System.out.println(codigoBarras.substring(7, 11));
        String nombrePro = codigoProductos(codigoBarras.substring(7, 11));
        String presentacion = presentacionProductos(codigoBarras.substring(7, 11));
        //System.out.println(presentacion);
        String codigoPro = codigoProductosCod(codigoBarras.substring(7, 11));
        if (codigoPro.length() != 0) {
            if (fabricante.length() != 0) {
                if (presentacion.length() != 0) {
                    String[] datos = {codigoBarras, codigoPro, nombrePro, fabricante, presentacion};
                    modelo.addRow(datos);
                    jtblIngreso.setModel(modelo);
                    txtCodPro.setText("");
                    txtCodPro.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "El producto no registra presentacion de venta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El producto no registra fabricante asociado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El codigo no se encontro");
        }
    }

    public String codigoProductosCod(String codigo) {
        String data = "";
        conexion_mysql cc = new conexion_mysql();
        Connection cn = cc.conectar();
        String sql = "";
        sql = "select p.cod_PROD"
                + " from productos p,presentaciones_productos pr where pr.COD_PRES='" + codigo
                + "' and p.cod_prod=pr.cod_pro_p";
        System.out.println(sql + " es codProd");
        try {
            Statement ps = cn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                data = rs.getString("cod_PROD");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede obtener nombre del producto");
        }

        return data;
    }

    public String codigoProductos(String codigo) {
        String data = "";
        conexion_mysql cc = new conexion_mysql();
        Connection cn = cc.conectar();
        String sql = "";
        sql = "select p.DES_PROD from productos p,presentaciones_productos pr where pr.COD_PRES='" + codigo
                + "' and p.cod_prod=pr.cod_pro_p";
        //System.out.println(sql);
        try {
            Statement ps = cn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                data = rs.getString("DES_PROD");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede obtener nombre del producto");
        }

        return data;
    }

    public String presentacionProductos(String codigo) {
        String data = "";
        conexion_mysql cc = new conexion_mysql();
        Connection cn = cc.conectar();
        String sql = "";
        sql = "select pr.DES_PRES_PRO from productos p,presentaciones_productos pr where pr.COD_PRES='"
                + codigo + "' and p.cod_prod=pr.cod_pro_p";
        // System.out.println(sql);
        try {
            Statement ps = cn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                data = rs.getString("DES_PRES_PRO");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede obtener nombre del producto");
        }

        return data;
    }

    public String verificaEmpresa12(String codigo) {
        String ver = "";
        String sql = "";
        conexion_mysql cc = new conexion_mysql();
        Connection cn = cc.conectar();
        sql = "select EMP_FAB from fabricante_producto where COD_FAB='" + codigo + "'";
        try {
            Statement ps = cn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                ver = rs.getString("EMP_FAB");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede buscar Fabricante");
        }

        return ver;
    }

    public void controlIngreso() {
        calculoCodBarras cd = new calculoCodBarras();
        if (txtCodPro.getText().length() == 12) {
            if (cd.verificador(txtCodPro.getText())) {
                ingresoStockGNI12();
            } else {
                JOptionPane.showMessageDialog(null, "Numero codigo erroneo");
            }
        } else {
            if (cd.verificador13D(txtCodPro.getText())) {
                System.out.println("ok");
            } else {
                JOptionPane.showMessageDialog(null, "Numero codigo erroneo");
            }
        }
    }

    public void codigo() {
        String sql = "";
        sql = "select * from productos";
        conexion_mysql cc = new conexion_mysql();
        Connection cn = cc.conectar();
        try {
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
//            while (rs.next()) {
//                jLabel2.add("COD_PROD", this);
//            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
    public int stockActual(String codigo){
        int stock=0;
        conexion_mysql cn=new conexion_mysql();
        Connection cc=cn.conectar();
        String sql="";
        sql="select stock_pro from productos where cod_prod='"+codigo+"'";
        //System.out.println(sql);
        try {
            Statement ps=cc.createStatement();
            ResultSet rs=ps.executeQuery(sql);
            while(rs.next()){
                stock=Integer.valueOf(rs.getString("stock_pro"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(AgregarProductos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "NO se puede obtener Stock Actual");
        }
        
        return stock;
    }
    public void subirStock(){
        int numeroFilas=jtblIngreso.getRowCount();
        int subida=0;
        for(int i=0;i<numeroFilas;i++){
            int stockTemp=Integer.valueOf(jtblIngreso.getValueAt(i,4).toString());
            String[] datosNosubidos=new String[1000];
            String codigoProd=jtblIngreso.getValueAt(i, 1).toString();
            int stockActualDB=stockActual(codigoProd);
            //System.out.println(stockActualDB+" stock Actual");
            int stockSubir=stockTemp+stockActualDB;
            conexion_mysql cc=new conexion_mysql();
            Connection cn=cc.conectar();
            String sql="";
            sql="update productos set stock_pro='"+stockSubir+"' where cod_prod='"+codigoProd+"'";
            try {
                PreparedStatement ps=cn.prepareStatement(sql);
                if(ps.executeUpdate()>0){
                    subida++;
                    modelo=(DefaultTableModel) jtblIngreso.getModel();
                    modelo.removeRow(i);
                    jtblIngreso.setModel(modelo);
                }
            } catch (Exception ex) {
                //Logger.getLogger(AgregarProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(subida==numeroFilas){
                JOptionPane.showMessageDialog(null, "Se han subido todos los datos");
            }else{
                
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodPro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblIngreso = new javax.swing.JTable();
        jbtnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtCodPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodProActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Producto:");

        jtblIngreso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtblIngreso);

        jbtnConfirmar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnConfirmar.setText("Confirmar");
        jbtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnConfirmar)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jbtnConfirmar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodProActionPerformed
        // TODO add your handling code here:
        controlIngreso();
    }//GEN-LAST:event_txtCodProActionPerformed

    private void jbtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnConfirmarActionPerformed
        // TODO add your handling code here:
        subirStock();
    }//GEN-LAST:event_jbtnConfirmarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnConfirmar;
    private javax.swing.JTable jtblIngreso;
    private javax.swing.JTextField txtCodPro;
    // End of variables declaration//GEN-END:variables
}
