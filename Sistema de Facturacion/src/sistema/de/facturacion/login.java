/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.facturacion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Benjita
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("INGRESO A PUNTO DE VENTA");
        lblMensaje.setVisible(false);
    }
    public void ingreso() {
        //System.out.println("ok");
        if (VerUsuario()) {
            String password = encriptaEnMD5(txtPass.getText().trim());
            if (password.equals(verClave())) {
                if (jerarquia(txtUser.getText()).equals("ADMINISTRADOR")) {
                    principal pl = new principal(txtUser.getText());
                    principal.jMenu6.setVisible(false);
                    pl.setVisible(true);
                    this.dispose();
                } else if (jerarquia(txtUser.getText()).equals("CAJERO")) {
                    principal pl = new principal(txtUser.getText());
                    principal.jMenu1.setVisible(false);
                    principal.jMenu7.setVisible(false);
                    pl.setVisible(true);
                    this.dispose();
                } else if (jerarquia(txtUser.getText()).equals("BODEGUERO")) {
                    principal pl = new principal(txtUser.getText());
                    principal.jMenu1.setVisible(false);
                    principal.jMenu6.setVisible(false);
                    principal.jMenu7.setVisible(false);
                    pl.setVisible(true);
                    this.dispose();
                }

            }else{
                lblMensaje.setVisible(true);
            }
        }else{
                lblMensaje.setVisible(true);
        }
    }
    public String jerarquia(String ced){
       String res = "";
        try {
            conexion_mysql cc=new conexion_mysql();
            Connection cn=cc.conectar();
            String sql="";
            sql="select * from usuarios where ci_usu='"+ced+"'";
            Statement ps=cn.createStatement();
            ResultSet rs=ps.executeQuery(sql);
            if(rs.next()){
                res=rs.getString("JERAR_USU");
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
            return res;
    }
  
    public boolean VerUsuario(){
        conexion_mysql cc=new conexion_mysql();
        Connection cn=cc.conectar();
        String sql="";
        sql="select ci_usu from usuarios where ci_usu='"+txtUser.getText().trim()+"'";
        boolean data=false;
        try {
            Statement ps=cn.createStatement();
            ResultSet rs=ps.executeQuery(sql);
            if(rs.next()){
                data=true;
            }else{
                data=false;
                txtUser.setText("");
                        
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se puede buscar al usuario");
        }
        return data;
    }
    public String verClave(){
        conexion_mysql cc=new conexion_mysql();
        Connection cn=cc.conectar();
        String sql="";
        sql="select clave_usu from usuarios where ci_usu='"+txtUser.getText().trim()+"'";
        String data="";
        try {
            Statement ps=cn.createStatement();
            ResultSet rs=ps.executeQuery(sql);
            if(rs.next()){
                data=rs.getString("clave_usu");
            }else{
                  txtUser.setText("");
                        
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se puede buscar al usuario");
        }
        return data;
    }
        private static final char[] CONSTS_HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String encriptaEnMD5(String stringAEncriptar) {
        try {
            MessageDigest msgd = MessageDigest.getInstance("MD5");
            byte[] bytes = msgd.digest(stringAEncriptar.getBytes());
            StringBuilder strbCadenaMD5 = new StringBuilder(2 * bytes.length);
            for (int i = 0; i < bytes.length; i++) {
                int bajo = (int) (bytes[i] & 0x0f);
                int alto = (int) ((bytes[i] & 0xf0) >> 4);
                strbCadenaMD5.append(CONSTS_HEX[alto]);
                strbCadenaMD5.append(CONSTS_HEX[bajo]);
            }
            return strbCadenaMD5.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
public void soloNumeros(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        txtUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbtnIngreso = new javax.swing.JButton();
        jbtnSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BIENVENIDO");

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
        });

        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Serif", 0, 14));
        jLabel3.setText("CONTRASEÑA* :");

        jLabel2.setFont(new java.awt.Font("Serif", 0, 14));
        jLabel2.setText("USUARIO*:");

        jbtnIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ingreso.png"))); // NOI18N
        jbtnIngreso.setText("Ingreso");
        jbtnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIngresoActionPerformed(evt);
            }
        });

        jbtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        jbtnSalir.setText("Salir");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.png"))); // NOI18N

        lblMensaje.setForeground(new java.awt.Color(255, 0, 0));
        lblMensaje.setText("Usuario o Contraseña incorrecto. Vuelva a intentarlo ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jbtnSalir)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jbtnIngreso))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(86, 86, 86)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPass)
                                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblMensaje)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnIngreso)
                    .addComponent(jbtnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel4)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        
    }//GEN-LAST:event_txtPassActionPerformed

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void jbtnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIngresoActionPerformed
        // TODO add your handling code here:
        ingreso();
    }//GEN-LAST:event_jbtnIngresoActionPerformed

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
        // TODO add your handling code here:
        lblMensaje.setVisible(false);
    }//GEN-LAST:event_txtPassFocusGained

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
    }//GEN-LAST:event_txtUserKeyTyped

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnIngreso;
    private javax.swing.JButton jbtnSalir;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
