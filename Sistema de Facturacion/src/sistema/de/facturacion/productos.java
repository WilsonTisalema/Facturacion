/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.facturacion;

import dialogs.AgregarPresenProductos;
import dialogs.consultaProductos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Cristty
 */
public class productos extends javax.swing.JFrame {

    /**
     * Creates new form productos
     */
    public productos() {
        initComponents();
        bloquear();
//        Tipo();
//        Categoria();
     categoria();
     cbxFam.removeAllItems();
      cbxFam.addItem("SELECCIONE UNO");
    }

    public void soloNumeros(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }

    public void soloLetras(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }

    public void bloquear() {
        btnNuevo.setEnabled(true);
        btnAgregar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnActualizar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnSalir.setEnabled(true);
        btnBusqueda.setEnabled(false);
        btnPresent.setEnabled(false);

        txtCod.setEnabled(false);
        txtDesc.setEnabled(false);
        jcbPresentaciones.setEnabled(false);
        jcbiva.setEnabled(false);
        txtUnid.setEnabled(false);

        txtPreBas.setEnabled(false);
        txtPre1.setEnabled(false);
        txtUltPreCo.setEnabled(false);
        cbxFam.setEnabled(false);
       // cbxSubFam.setEnabled(false);
        cbxcateg.setEnabled(false);
//        txtPre2.setEnabled(false);
        
        txtCntUltCom.setEnabled(false);
        txtMaxDes.setEnabled(false);
        txtUltCom.setEnabled(false);
        txtStockMax.setEnabled(false);
        txtStockMin.setEnabled(false);
        txtUltVen.setEnabled(false);

        txtcodbarras.setEnabled(false);
     //   labecodigincorecto.setVisible(false);
        labelcodigobarras.setVisible(false);
        
    }

    public void desbloquear() {
        btnNuevo.setEnabled(false);
        btnAgregar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
        btnBusqueda.setEnabled(true);
        btnPresent.setEnabled(true);
        txtCod.setEnabled(true);
        txtDesc.setEnabled(true);
        jcbPresentaciones.setEnabled(true);
        jcbiva.setEnabled(true);
        txtUnid.setEnabled(true);

        txtPreBas.setEnabled(true);
        txtPre1.setEnabled(true);
        txtUltPreCo.setEnabled(true);
        cbxFam.setEnabled(true);
        cbxcateg.setEnabled(true);
     //   txtPre2.setEnabled(true);
    
        txtCntUltCom.setEnabled(true);
        txtMaxDes.setEnabled(true);
        txtUltCom.setEnabled(true);
        txtStockMax.setEnabled(true);
        txtStockMin.setEnabled(true);
        txtUltVen.setEnabled(true);
 
        txtcodbarras.setEnabled(true);
        txtCod.requestFocus();
    }

    public void cancelar() {
        txtCod.setText("");
        txtDesc.setText("");
        jcbPresentaciones.setSelectedItem(" ");
        jcbiva.setText("");
        txtUnid.setText("");
   
        txtPreBas.setText("");
        txtPre1.setText("");
        txtUltPreCo.setText("");
        cbxFam.setSelectedItem(" ");       
        cbxcateg.setSelectedItem(" ");  
      //  txtPre2.setText("");
      
        txtCntUltCom.setText("");
        txtMaxDes.setText("");
        txtUltCom.setText("");
        txtStockMax.setText("");
        txtStockMin.setText("");
        txtUltVen.setText("");
     
        txtCod.requestFocus();
    }

    public void Nuevo() {
        txtCod.setText("");
        txtDesc.setText("");

        txtUnid.setText("");
        cbxFam.setSelectedIndex(0);       
     
        txtPreBas.setText("");
        cbxcateg.setSelectedIndex(0); 
        txtPre1.setText("");
      //  txtPre2.setText("");
        txtUltPreCo.setText("");
       
        txtCntUltCom.setText("");

        //txtCostoProye.setText("");
        txtStockMin.setText("");
        txtStockMax.setText("");
        txtMaxDes.setText("");
        //txtMaxDes2.setText("");
        //txtDesCom.setText("");
        txtUltCom.setText("");
        txtUltVen.setText("");
     

        txtCod.requestFocus();
    }

//    public void Tipo() {
//        cbxTipo.removeAllItems();
//        cbxTipo.addItem("SELECCIONE UNO");
//        cbxTipo.addItem("tipo");
//        cbxTipo.addItem("tipo");
//        
//        cbxTipo.setToolTipText("SELECCIONE UNO");
//    }
//    
//    public void Categoria() {
//        cbxCategoria.removeAllItems();
//        cbxCategoria.addItem("SELECCIONE UNO");
//        cbxCategoria.addItem("categoria");
//        cbxCategoria.addItem("categoria");
//        
//        cbxTipo.setToolTipText("SELECCIONE UNO");
//    }
//    
//    public void calculoCosto() {
//        int y = 0;
//        if (txtPre1.getText().trim().length() == 0) {
//            JOptionPane.showMessageDialog(null, "No hay Precio 1");
//            y++;
//        } else {
//            if (txtStock.getText().trim().length() == 0) {
//                JOptionPane.showMessageDialog(null, "No hay Stock campo vacio");
//                y++;
//            } else {
//                if (txtCantProxComp.getText().trim().length() == 0) {
//                    JOptionPane.showMessageDialog(null, "No hay Cantidad proxima de compra");
//                    y++;
//                } else {
//                    if (txtPrecioProx.getText().trim().length() == 0) {
//                        JOptionPane.showMessageDialog(null, "No hay Precio proximo de compra");
//                        y++;
//                    }
//                }
//            }
//        }
//        if(y==0){
//            float costoActual=Float.valueOf(txtPre1.getText());
//            float stockActual=Float.valueOf(txtStock.getText());
//            float stockProximo=Float.valueOf(txtCantProxComp.getText());
//            float CostoProximo=Float.valueOf(txtPrecioProx.getText());
//            
//            float respuesta=((costoActual*stockActual)+(stockProximo*CostoProximo))/(stockActual+stockProximo);
//            
//            DecimalFormat df = new DecimalFormat("##.##");
//            
//            //df.setRoundingMode(RoundingMode.DOWN);
//            String resulta = df.format(respuesta);
//            String[] nuevo = resulta.split(",");
//            String primero=nuevo[0];
//            String segundo=nuevo[1];
//            txtPre1.setText(primero+"."+segundo);
//        }
//    }
    public void categoria() {
        cbxcateg.removeAllItems();
        cbxcateg.addItem("SELECCIONE UNO");
        cbxcateg.addItem("BEBIDAS");
        cbxcateg.addItem("SNACKS");
        cbxcateg.addItem("HIGIENE");

       cbxcateg.setToolTipText("SELECCIONE UNO");
    }

    public void familia() {
        if (cbxcateg.getSelectedIndex() == 1) {
            cbxFam.removeAllItems();
            cbxFam.addItem("SELECCIONE UNO");
            cbxFam.addItem("GASEOSAS");
            cbxFam.addItem("ENERGIZANTES");
            cbxFam.addItem("AGUAS");

        } else if (cbxcateg.getSelectedIndex() == 2) {
            cbxFam.removeAllItems();
            cbxFam.addItem("SELECCIONE UNO");
            cbxFam.addItem("PAPASFRITAS");
            cbxFam.addItem("CHITOS");
            cbxFam.addItem("CEREALES");
        } else if (cbxcateg.getSelectedIndex() == 3) {
            cbxFam.removeAllItems();
            cbxFam.addItem("SELECCIONE UNO");
            cbxFam.addItem("PASTADENTAL");
            cbxFam.addItem("JAVON");
            cbxFam.addItem("SHAMPOO");
            cbxFam.addItem("DEJA");
        }
    }
  
    public void guardar() {
//
//        if (txtCod.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe insertar la codigo");
//            txtCod.requestFocus();
//        } else if (jcbPresentaciones.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(null, "Debe seleccionar una Presentacion");
//            jcbPresentaciones.requestFocus();
//        } else if (txtUnid.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe insertar la Unidad");
//            txtUnid.requestFocus();
//        } else if (txtUnidAl.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe insertar la Unidad Alterna");
//            txtUnidAl.requestFocus();
//        } else if (cbxcateg.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(null, "Debe insertar la Categoria");
//            cbxcateg.requestFocus();
//        } else if (cbxFam.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(null, "Debe seleccionar una Familia");
//            cbxFam.requestFocus();
////        } else if (cbxSubFam.getSelectedIndex() == 0) {
////            JOptionPane.showMessageDialog(null, "Debe seleccionar una SubFamilia");
////            cbxSubFam.requestFocus();
//        } else if (txtPreBas.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe insertar el Precio Base");
//            txtPreBas.requestFocus();
//        } else if (txtPre1.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe insertar la Categoria");
//            txtPre1.requestFocus();
////        } else if (txtPre2.getText().isEmpty()) {
////            JOptionPane.showMessageDialog(null, "Debe insertar la Categoria");
////            txtPre2.requestFocus();
//        } else if (txtUltPreCo.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe insertar el ultimo precio de compra");
//            txtUltPreCo.requestFocus();
//        } else if (txtPreProCom.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe insertar el precio promedio de compra");
//            txtPreProCom.requestFocus();
//        } else if (txtCntUltCom.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe insertar la Ultima Cantidad Comprada");
//            txtCntUltCom.requestFocus();
//        } else if (txtStockMin.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe insertar el Stock Minimo");
//            txtStockMin.requestFocus();
//        } else if (txtStockMax.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe insertar el Stock Maximo");
//            txtStockMax.requestFocus();
//        } else if (txtMaxDes.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe insertar el Porcentaje Maximo de Descuento");
//            txtMaxDes.requestFocus();
            try {
                conexion_mysql cc = new conexion_mysql();
                Connection cn = cc.conectar();
                String COD_PROD,DES_PROD,UNI_PROD,CATE_PRO_PROD,FAM_PROD,PREC_BASE,
                        PRE1_PROD,ULT_PRE_COM_PROD,CNT_ULT_COM_PROD,STOCK_MIN,STOCK_MAX,
                        POR_MAX_DES_PROD,stock_pro,GRAB_IVA_P,COD_BARRAS;
                String sql = "";
                
                sql = "insert into productos(COD_PROD,DES_PROD,UNI_PROD,CATE_PRO_PROD,FAM_PROD,PREC_BASE,PRE1_PROD,ULT_PRE_COM_PROD,CNT_ULT_COM_PROD,STOCK_MIN,STOCK_MAX,POR_MAX_DES_PROD,stock_pro,GRAB_IVA_P,COD_BARRAS ) "
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                COD_PROD = txtCod.getText().toUpperCase().trim();
                if (txtDesc.getText().isEmpty()) {
                    DES_PROD = "NO HAY DESCRIPCION";
                } else {
                    DES_PROD = txtDesc.getText().trim();
                }
                if (txtcodbarras.getText().isEmpty()) {
                    COD_BARRAS = "";
                } else {
                    COD_BARRAS = txtcodbarras.getText().trim();
                }
                UNI_PROD = txtUnid.getText().toUpperCase().trim();
                
                CATE_PRO_PROD = String.valueOf(cbxcateg.getSelectedItem()).trim();
                //PRES_PROD = String.valueOf(jcbPresentaciones.getSelectedItem()).trim();
                FAM_PROD = String.valueOf(cbxFam.getSelectedItem()).trim();
               // SUB_FAM_PROD = String.valueOf(cbxSubFam.getSelectedItem()).trim();
                PREC_BASE = txtPreBas.getText().toUpperCase().trim();
                PRE1_PROD = txtPre1.getText().toUpperCase().trim();
               // PRE2_PROD = txtPre2.getText().toUpperCase().trim();
                ULT_PRE_COM_PROD = txtUltPreCo.getText().toUpperCase().trim();
                
                CNT_ULT_COM_PROD = txtCntUltCom.getText().toUpperCase().trim();
                STOCK_MIN = txtStockMin.getText().toUpperCase().trim();
                STOCK_MAX = txtStockMax.getText().toUpperCase().trim();
                POR_MAX_DES_PROD = txtMaxDes.getText().toUpperCase().trim();
                stock_pro=txtStock.getText().trim();
                if(jcbiva.isSelected()){
                    GRAB_IVA_P="0";
                }else{
                    GRAB_IVA_P="1";
                }
                
                PreparedStatement psd = cn.prepareStatement(sql);

               
               
                psd.setString(1, COD_PROD);
                psd.setString(2, DES_PROD);
                psd.setString(3, UNI_PROD);

                psd.setString(4, CATE_PRO_PROD);
                psd.setString(5,FAM_PROD);
                psd.setString(6, PREC_BASE);
                psd.setString(7, PRE1_PROD);
                psd.setString(8, ULT_PRE_COM_PROD);
                psd.setString(9, CNT_ULT_COM_PROD);
                psd.setString(10, STOCK_MIN);
                psd.setString(11, STOCK_MAX);
                psd.setString(12, POR_MAX_DES_PROD);
                psd.setString(13, stock_pro);
                psd.setString(14, GRAB_IVA_P);
                psd.setString(15, COD_BARRAS);
                
                 int n = psd.executeUpdate();
                
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Se inserto correctamente");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "No se inserto "+ex);
            }

//        }

    }
    public void buscar(String codigo){
        conexion_mysql cn=new conexion_mysql();
        Connection cc=cn.conectar();
        String sql="";
        sql="select COD_PROD,DES_PROD,UNI_PROD,CATE_PRO_PROD,FAM_PROD,PREC_BASE,"
                + "PRE1_PROD,ULT_PRE_COM_PROD,CNT_ULT_COM_PROD,STOCK_MIN,STOCK_MAX,"
                + "POR_MAX_DES_PROD,stock_pro,GRAB_IVA_P,COD_BARRAS from productos where cod_prod='"+codigo+"'";
        try {
            Statement ps=cc.createStatement();
            ResultSet rs=ps.executeQuery(sql);
            while(rs.next()){
                txtDesc.setText(rs.getString("DES_PROD"));
                txtUnid.setText(rs.getString("UNI_PROD"));
               cbxcateg.setSelectedItem(rs.getString("CATE_PRO_PROD"));
                cbxFam.setSelectedItem(rs.getString("FAM_PROD"));
                txtPre1.setText(rs.getString("PRE1_PROD"));
                txtUltPreCo.setText(rs.getString("ULT_PRE_COM_PROD"));
                txtCntUltCom.setText(rs.getString("CNT_ULT_COM_PROD"));
                txtStockMax.setText(rs.getString("STOCK_MAX"));
                txtStockMin.setText(rs.getString("STOCK_MIN"));
                txtMaxDes.setText(rs.getString("POR_MAX_DES_PROD"));
                txtStock.setText(rs.getString("stock_pro"));
                int iva=Integer.valueOf(rs.getString("GRAB_IVA_P").toString());
                if(iva==0){
                    jcbiva.setSelected(true);
                }else{
                    jcbiva.setSelected(false);
                }
                txtcodbarras.setText(rs.getString("COD_BARRAS"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void mayusculas(JTextField d) {
        String cad = d.getText().toUpperCase();
        d.setText(cad);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jcbPresentaciones = new javax.swing.JComboBox();
        btnPresent = new javax.swing.JButton();
        jcbiva = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtUnid = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbxFam = new javax.swing.JComboBox<String>();
        jLabel18 = new javax.swing.JLabel();
        txtPreBas = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtPre1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtUltPreCo = new javax.swing.JTextField();
        txtCntUltCom = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cbxcateg = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtcodbarras = new javax.swing.JTextField();
        labelcodigobarras = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtStockMax = new javax.swing.JTextField();
        txtStockMin = new javax.swing.JTextField();
        txtMaxDes = new javax.swing.JTextField();
        txtUltCom = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtUltVen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código*:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("IVA ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Descripción:");

        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });
        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodKeyTyped(evt);
            }
        });

        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescKeyTyped(evt);
            }
        });

        btnBusqueda.setBackground(new java.awt.Color(102, 204, 255));
        btnBusqueda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBusqueda.setText("Busqueda");
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Presentacion:");

        jcbPresentaciones.setBackground(new java.awt.Color(102, 204, 255));
        jcbPresentaciones.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        btnPresent.setBackground(new java.awt.Color(102, 204, 255));
        btnPresent.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPresent.setText("Presentaciones");
        btnPresent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPresentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCod, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(txtDesc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBusqueda)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbPresentaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPresent))
                    .addComponent(jcbiva))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbiva, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBusqueda)
                        .addComponent(jLabel2)
                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jcbPresentaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPresent))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Unidad:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Familia:");

        cbxFam.setBackground(new java.awt.Color(102, 204, 255));
        cbxFam.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxFam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONE UNO", "BEBIDAS", "SNACK", " " }));
        cbxFam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxFamItemStateChanged(evt);
            }
        });
        cbxFam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFamActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Precio base:");

        txtPreBas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPreBasActionPerformed(evt);
            }
        });
        txtPreBas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPreBasKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Categoria");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Precio 1:");

        txtPre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPre1KeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Ult pre Co:");

        txtUltPreCo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUltPreCoKeyTyped(evt);
            }
        });

        txtCntUltCom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCntUltComKeyTyped(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Cnt ulti com:");

        cbxcateg.setBackground(new java.awt.Color(153, 204, 255));
        cbxcateg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxcateg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxcateg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxcategItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Codigo Barras");

        txtcodbarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodbarrasKeyTyped(evt);
            }
        });

        labelcodigobarras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPreBas, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPre1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(txtUnid, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(txtUltPreCo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcodbarras, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel14))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbxcateg, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(cbxFam, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 2, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(txtCntUltCom, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(117, 117, 117))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(labelcodigobarras, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtUnid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbxcateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cbxFam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtcodbarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPreBas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(txtPre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelcodigobarras, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel28)
                                        .addComponent(txtCntUltCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(txtUltPreCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Stock min:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Stock max:");

        txtStockMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockMaxKeyTyped(evt);
            }
        });

        txtStockMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockMinActionPerformed(evt);
            }
        });
        txtStockMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockMinKeyTyped(evt);
            }
        });

        txtMaxDes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaxDesKeyTyped(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Descuento");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Ultima compra:");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Última venta:");

        jLabel6.setText("Stock:");

        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(21, 21, 21)
                        .addComponent(txtUltCom))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(txtMaxDes, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel39))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txtUltVen, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(66, 66, 66)
                        .addComponent(txtStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(jLabel35)
                        .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34)
                        .addComponent(txtStockMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMaxDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtUltCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(txtUltVen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnNuevo.setBackground(new java.awt.Color(51, 204, 255));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(51, 204, 255));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ACTUALIZAR1.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(51, 204, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(51, 204, 255));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir ");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(51, 204, 255));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregar.setText("Agregar Productos");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(51, 204, 255));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(830, 830, 830)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStockMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockMinActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyTyped
        // TODO add your handling code here:
       // soloNumeros(evt);
         if (txtCod.getText().length() > 5) {
                evt.consume();
                mayusculas(txtCod);
            }
    }//GEN-LAST:event_txtCodKeyTyped

    private void txtDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyTyped
        // TODO add your handling code here:
        soloLetras(evt);
    }//GEN-LAST:event_txtDescKeyTyped

    private void txtStockMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockMinKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
    }//GEN-LAST:event_txtStockMinKeyTyped

    private void txtStockMaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockMaxKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
    }//GEN-LAST:event_txtStockMaxKeyTyped

    private void txtMaxDesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxDesKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
    }//GEN-LAST:event_txtMaxDesKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        //Nuevo();
        desbloquear();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnPresentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresentActionPerformed
        // TODO add your handling code here:
        AgregarPresenProductos agr = new AgregarPresenProductos(this, true, txtCod.getText().trim());
        agr.show();

    }//GEN-LAST:event_btnPresentActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        AgregarProductos agre = new AgregarProductos();
        agre.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodActionPerformed

// public void verificar2(){
//     calculoCodBarras cal = new calculoCodBarras();
//    if(txtcodbarras.getText().length() == 13){
//        cal.verificador13D(txtcodbarras.getText());          
//            labelcodigobarras.setVisible(true);
//        }else{
//         labecodigincorecto.setVisible(true);
//    }
// }
    private void txtcodbarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodbarrasKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
        verificar1();

    }//GEN-LAST:event_txtcodbarrasKeyTyped

    private void cbxcategItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxcategItemStateChanged
        // TODO add your handling code here:
        familia();
    }//GEN-LAST:event_cbxcategItemStateChanged

    private void txtCntUltComKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCntUltComKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
    }//GEN-LAST:event_txtCntUltComKeyTyped

    private void txtUltPreCoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUltPreCoKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
    }//GEN-LAST:event_txtUltPreCoKeyTyped

    private void txtPre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPre1KeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
    }//GEN-LAST:event_txtPre1KeyTyped

    private void txtPreBasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPreBasKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
    }//GEN-LAST:event_txtPreBasKeyTyped

    private void txtPreBasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPreBasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPreBasActionPerformed

    private void cbxFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFamActionPerformed

    private void cbxFamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFamItemStateChanged
        // TODO add your handling code here:
        //familia();
    }//GEN-LAST:event_cbxFamItemStateChanged

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockKeyTyped

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        // TODO add your handling code here:
        consultaProductos pr=new consultaProductos(this, rootPaneCheckingEnabled, " ");
        
        pr.show();
        txtCod.setText(pr.data);
        buscar(txtCod.getText().trim());
    }//GEN-LAST:event_btnBusquedaActionPerformed
 public void verificar1(){
     calculoCodBarras cal = new calculoCodBarras();
     if(txtcodbarras.getText().length() == 12 ){           
            cal.verificador(txtcodbarras.getText());
            labelcodigobarras.setVisible(true);
            labelcodigobarras.setText("Codigo Correcto");
            txtcodbarras.setEnabled(false);
        }else if(txtcodbarras.getText().length() == 13){
        cal.verificador13D(txtcodbarras.getText()); 
         labelcodigobarras.setVisible(true);
            labelcodigobarras.setText("Codigo Correcto");
           txtcodbarras.setEnabled(false);
        }else{
     //   labecodigincorecto.setVisible(true);
             labelcodigobarras.setVisible(true);
              labelcodigobarras.setText("Codigo Incorrecto");

     }
 }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        guardar();
    }

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
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPresent;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxFam;
    private javax.swing.JComboBox cbxcateg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JComboBox jcbPresentaciones;
    private javax.swing.JCheckBox jcbiva;
    private javax.swing.JLabel labelcodigobarras;
    private javax.swing.JTextField txtCntUltCom;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtMaxDes;
    private javax.swing.JTextField txtPre1;
    private javax.swing.JTextField txtPreBas;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtStockMax;
    private javax.swing.JTextField txtStockMin;
    private javax.swing.JTextField txtUltCom;
    private javax.swing.JTextField txtUltPreCo;
    private javax.swing.JTextField txtUltVen;
    private javax.swing.JTextField txtUnid;
    private javax.swing.JTextField txtcodbarras;
    // End of variables declaration//GEN-END:variables
}
