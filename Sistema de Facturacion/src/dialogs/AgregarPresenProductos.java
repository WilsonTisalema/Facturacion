/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import sistema.de.facturacion.conexion_mysql;

/**
 *
 * @author Benjita
 */
public class AgregarPresenProductos extends javax.swing.JDialog {

    /**
     * Creates new form AgregarPresenProductos
     */
    public AgregarPresenProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtCodPro.setText("PRO002");
        txtCodPro.setEnabled(false);
        descargarDatos();
        sacarDatos();
        bloquear();
    }
    DefaultTableModel modelo;
    public AgregarPresenProductos(java.awt.Frame parent, boolean modal,String code) {
        super(parent, modal);
        initComponents();
        txtCodPro.setText(code);
        txtCodPro.setEnabled(false);
        descargarDatos();
        sacarDatos();
    }
    public void bloquear(){
        jbtnNuevo.setEnabled(true);
        jbtnGuardar.setEnabled(false);
        jbtnActualizar.setEnabled(false);
        jbtnCancelar.setEnabled(false);
        jbtnSalir.setEnabled(true);
        txtCodigoPre.setEnabled(false);
        txtDesPresentacion.setEnabled(false);
    }
    public void desbloquear(){
        jbtnNuevo.setEnabled(false);
        jbtnGuardar.setEnabled(true);
        jbtnActualizar.setEnabled(true);
        jbtnCancelar.setEnabled(true);
        jbtnSalir.setEnabled(true);
        txtCodigoPre.setEnabled(true);
        txtDesPresentacion.setEnabled(true);
    }
     public void limpiar(){
        txtCodigoPre.setText("");
        txtDesPresentacion.setText("");
    }
    public void descargarDatos(){
        String[] titulos={"Código Presentacion","Descripcion"};
        modelo= new DefaultTableModel(null, titulos);
        conexion_mysql cc=new conexion_mysql();
        Connection cn=cc.conectar();
        String sql="";
        String[] datos=new String[2];
        sql="select * from presentaciones_productos where COD_PRO_P='"+txtCodPro.getText().trim()+"'";
        try {
            Statement ps=cn.createStatement();
            ResultSet rs=ps.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString("COD_PRES");
                datos[1]=rs.getString("DES_PRES_PRO");
                modelo.addRow(datos);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede realizar la descarga");
        }
        jtbPresentaciones.setModel(modelo);
    }
    public void sacarDatos(){
        jtbPresentaciones.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                int n=jtbPresentaciones.getSelectedRow();
                if(n!=-1){
                    //txtCodigoPre.setEnabled(false);
                    txtCodigoPre.setText(jtbPresentaciones.getValueAt(n, 0).toString());
                    txtDesPresentacion.setText(jtbPresentaciones.getValueAt(n, 1).toString());
                }
            }
        });
    }
    public void actualizar() {
        if(txtCodigoPre.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe insertar la codigo");
            txtCodigoPre.requestFocus();
        }else{
            if(txtDesPresentacion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe insertar la presentacion");
            txtDesPresentacion.requestFocus();
        }else{
            conexion_mysql cc=new conexion_mysql();
            Connection cn=cc.conectar();
            String sql;
            sql = "update presentaciones_productos set COD_PRO_P='" + txtCodigoPre.getText() + "',"
                    + "DES_PRES_PRO='" + txtDesPresentacion.getText() + "',"
                    + "'where COD_PRES='" + txtCodPro.getText() + "'";
                try {
                PreparedStatement psd = cn.prepareStatement(sql);
                int n = psd.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Se actualizo correctamente");
                }
                }catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                        }
                descargarDatos();
                }
            limpiar();
            }
        }
  
    public void guardar(){
        try {
            // TODO add your handling code here:
            conexion_mysql cc=new conexion_mysql();
            Connection cn=cc.conectar();
            String COD_PRES,COD_PRO_P,DES_PRES_PRO;
            String sql="insert INTO presentaciones_productos (COD_PRES,COD_PRO_P,DES_PRES_PRO) values(?,?,?);";
            COD_PRO_P=txtCodPro.getText().trim();
            COD_PRES=txtCodigoPre.getText().trim();
            DES_PRES_PRO=txtDesPresentacion.getText().trim();
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, COD_PRES);
            ps.setString(2,COD_PRO_P );
            ps.setString(3, DES_PRES_PRO);
            int n=ps.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null, "Se agrego una presentacion");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgregarPresenProductos.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jbtnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbtnActualizar = new javax.swing.JButton();
        txtCodPro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDesPresentacion = new javax.swing.JTextField();
        jbtnGuardar = new javax.swing.JButton();
        txtCodigoPre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPresentaciones = new javax.swing.JTable();
        jbtnCancelar = new javax.swing.JButton();
        jbtnNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Codigo Producto:");

        jbtnSalir.setBackground(new java.awt.Color(51, 204, 255));
        jbtnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        jbtnSalir.setText("Salir");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Codigo Presentacion:");

        jbtnActualizar.setBackground(new java.awt.Color(51, 204, 255));
        jbtnActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ACTUALIZAR1.png"))); // NOI18N
        jbtnActualizar.setText("Actualizar");
        jbtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Descripcion Presentacion:");

        jbtnGuardar.setBackground(new java.awt.Color(51, 204, 255));
        jbtnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbtnGuardar.setText("Guardar");
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        txtCodigoPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPreActionPerformed(evt);
            }
        });

        jtbPresentaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtbPresentaciones);

        jbtnCancelar.setBackground(new java.awt.Color(51, 204, 255));
        jbtnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        jbtnCancelar.setText("Calcelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jbtnNuevo.setBackground(new java.awt.Color(51, 204, 255));
        jbtnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jbtnNuevo.setText("Nuevo");
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
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
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtDesPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2)))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoPre, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCodPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtnNuevo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnGuardar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtCodigoPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnCancelar)
                        .addGap(17, 17, 17)
                        .addComponent(jbtnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDesPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPreActionPerformed
        // TODO add your handling code here:
        if(txtCodigoPre.getText().trim().length()==13  ){
            txtCodigoPre.setText(txtCodigoPre.getText().trim().substring(8, 12));
            txtCodigoPre.setEnabled(false);
            
        }else{
            if(txtCodigoPre.getText().trim().length()==12){
                txtCodigoPre.setText(txtCodigoPre.getText().trim().substring(7, 11));
            txtCodigoPre.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null, "Utilice pistola de codigo de barras para agregar item");
            }
        }
    }//GEN-LAST:event_txtCodigoPreActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        guardar();
        
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        // TODO add your handling code here:
        desbloquear();
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        // TODO add your handling code here:
        actualizar();
    }//GEN-LAST:event_jbtnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarPresenProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarPresenProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarPresenProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarPresenProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarPresenProductos dialog = new AgregarPresenProductos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnActualizar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JButton jbtnSalir;
    private javax.swing.JTable jtbPresentaciones;
    private javax.swing.JTextField txtCodPro;
    private javax.swing.JTextField txtCodigoPre;
    private javax.swing.JTextField txtDesPresentacion;
    // End of variables declaration//GEN-END:variables
}
