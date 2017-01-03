/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.facturacion;

import dialogs.consultaCliente;
import dialogs.consultaProductos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Benjita
 */
public class FacturaVenta extends javax.swing.JFrame {

    /**
     * Creates new form FacturaVenta
     */
    DefaultTableModel modelo;

    public FacturaVenta() {
        initComponents();
        cargarHora();
        txtFecha.setEnabled(false);
        cargarSecuencial();
        String[] titulos = {"Código", "Descripcion", "Cantidad", "Pre. Uni", "Descuento %", "Total"};
        modelo = new DefaultTableModel(null, titulos);
        jtbProductos.setModel(modelo);
        txtNumFac.setEnabled(false);
        txtVendedor.setEnabled(false);
        txtVendedor.setText("1804181400");
        setLocationRelativeTo(null);
    }

    public FacturaVenta(String vendedor) {
        initComponents();
        cargarHora();
        txtFecha.setEnabled(false);
        cargarSecuencial();
        txtNumFac.setEnabled(false);
        txtVendedor.setEnabled(false);
        txtVendedor.setText(vendedor);
        setLocationRelativeTo(null);
    }

    public void cargarHora() {
        Calendar cs = new GregorianCalendar();
        Date fecha = cs.getTime();
        String dia, mes, anio;
        dia = String.valueOf(fecha.getDate());
        mes = String.valueOf(fecha.getMonth() + 1);
        anio = String.valueOf(fecha.getYear() + 1900);
        String fecha1 = anio + "-" + mes + "-" + dia;
        txtFecha.setText(fecha1);
    }

    public void buscarCliente(String cedula) {
        conexion_mysql cn = new conexion_mysql();
        Connection cc = cn.conectar();
        String sql = "";
        sql = "select nom_cli,nom_cli1,ape_cli,ape_cli1,TLF1_CLI,CEL1_CLI,E_MAIL_CLI,DIR_CLI,RAZON_SOCI_USU,RUC_CLI,TIPO_CONT_CLI from clientes where ci_cli='" + cedula + "'";
        // String[] filas=new String[8];
        Statement ps;
        try {
            ps = cc.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                txtNomCli.setText(rs.getString("nom_cli") + " " + rs.getString("nom_cli1") + " " + rs.getString("ape_cli") + " " + rs.getString("ape_cli1"));
                txtTelefono.setText(rs.getString("TLF1_CLI"));
                txtCelular.setText(rs.getString("CEL1_CLI"));
                txtEmail.setText(rs.getString("E_MAIL_CLI"));
                txtDireccion.setText(rs.getString("DIR_CLI"));
                txtRazonS.setText(rs.getString("RAZON_SOCI_USU"));
                txtTipo.setText(rs.getString("TIPO_CONT_CLI"));
                txtRuc.setText(rs.getString("RUC_CLI"));
                txtNomCli.setEnabled(false);
                txtTelefono.setEnabled(false);
                txtCelular.setEnabled(false);
                txtEmail.setEnabled(false);
                txtDireccion.setEnabled(false);
                txtRazonS.setEnabled(false);
                txtTipo.setEnabled(false);
                txtRuc.setEnabled(false);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cargarSecuencial() {
        conexion_mysql cn = new conexion_mysql();
        Connection cc = cn.conectar();
        String sql = "";
        String ultimo = ultimoSecuencial();
        sql = "select num_sec from secuencial where id='" + ultimo + "'";
        //System.out.println(sql);
        try {
            Statement ps = cc.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            rs.next();
            txtNumFac.setText(rs.getString("num_sec"));

        } catch (SQLException ex) {
            //Logger.getLogger(FacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String ultimoSecuencial() {
        conexion_mysql cn = new conexion_mysql();
        Connection cc = cn.conectar();
        String sql = "";
        String datos = "";
        sql = "select max(id) from secuencial";
        try {
            Statement ps = cc.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                datos = String.valueOf(rs.getInt("max(id)"));
            }

        } catch (SQLException ex) {
            //Logger.getLogger(FacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    public void ingresoStockGNI12() {
        String codigoBarras = txtCodProd.getText().trim();
        String codigo = codigoBarras.substring(1, 6);

        String nombrePro = codigoProductos(codigoBarras.substring(7, 11));
        String[] presentacion = presentacionProductos(codigoBarras.substring(7, 11));

        txtCodProd.setText(presentacion[2]);
        txtDesPro.setText(nombrePro);
        txtPresentacion.setText(presentacion[0]);
        txtPresentacion.setEnabled(false);
        txtPreU.setText(presentacion[1]);
        buscarProd(presentacion[2]);
        //txtCodProd.requestFocus();
    }

    public String[] presentacionProductos(String codigo) {
        String[] data = new String[3];
        conexion_mysql cc = new conexion_mysql();
        Connection cn = cc.conectar();
        String sql = "";
        sql = "select pr.DES_PRES_PRO,p.PRE1_PROD,p.COD_PROD from productos p,presentaciones_productos pr where pr.COD_PRES='" + codigo + "' and p.cod_prod=pr.cod_pro_p";
        //System.out.println(sql);
        try {
            Statement ps = cn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                data[0] = rs.getString("DES_PRES_PRO");
                data[1] = rs.getString("PRE1_PROD");
                data[2] = rs.getString("COD_PROD");
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
        sql = "select p.DES_PROD from productos p,presentaciones_productos pr where pr.COD_PRES='" + codigo + "' and p.cod_prod=pr.cod_pro_p";
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

    public void agregarAtabla() {
        int y = 0;
        int dato_stock = Integer.valueOf(txtCant.getText());
        int dato_descuento = Integer.valueOf(txtDescPro.getText());
        if (dato_stock > stockProBase) {
            JOptionPane.showMessageDialog(this, "No hay stock, El stock es = " + stockProBase);
            y++;
        }
        if (dato_descuento > max_descuento) {
            JOptionPane.showMessageDialog(this, "Descuento excede el maximo, Maximo descuento es = " + max_descuento);
            y++;
        }
        if (y == 0) {
            String[] datos = new String[6];
            datos[0] = txtCodProd.getText().trim();
            datos[1] = txtDesPro.getText().trim();
            
            datos[3] = txtPreU.getText().trim();
            datos[4] = txtDescPro.getText().trim();
            float cantidad = Float.valueOf(txtCant.getText().trim()) * Float.valueOf(txtPresentacion.getText().trim());
            datos[2] = String.valueOf(cantidad);
            System.out.println(cantidad+" cantidad a comprar");
            float precioU = Float.valueOf(txtPreU.getText().trim());
            float descuento = Float.valueOf(txtDescPro.getText().trim());
            float totalS = (cantidad * precioU) * (descuento / 100);
            float total = (cantidad * precioU) - totalS;
            datos[5] = String.valueOf(total);
            modelo.addRow(datos);

        }
        jtbProductos.setModel(modelo);
    }
    int stockProBase;
    int max_descuento;

    public void buscarProd(String producto) {
        conexion_mysql cn = new conexion_mysql();
        Connection cc = cn.conectar();
        String sql = "";
        sql = "select p.cod_prod,p.des_prod,p.stock_pro,p.PRE1_PROD,p.POR_MAX_DES_PROD,pr.DES_PRES_PRO from productos p,presentaciones_productos pr where p.cod_prod = '" + producto + "' and p.cod_prod=PR.COD_PRO_P";
        System.out.println(sql + " busqueda");
        int stock = 0;
        try {
            Statement ps = cc.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                txtDesPro.setText(rs.getString("des_prod"));
                txtDesPro.setEnabled(false);
                txtCodProd.setEnabled(false);
                txtPresentacion.setEnabled(false);
                stockProBase = rs.getInt("stock_pro");
                max_descuento = rs.getInt("POR_MAX_DES_PROD");
                txtPreU.setText(rs.getString("PRE1_PROD"));
                txtPresentacion.setText(rs.getString("DES_PRES_PRO"));
                txtPreU.setEnabled(false);
                txtCant.requestFocus();
            }
            //  modelo.addRow(cadena);
            //jtbProductos.setModel(modelo);
        } catch (SQLException ex) {
            //Logger.getLogger(consultaProductos.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumFac = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        txtSecuencial = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNomCli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtRazonS = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbProductos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtCodProd = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDesPro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtSubT = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtDescPro = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtPreU = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jcbPagos = new javax.swing.JComboBox();
        jbtAgregar = new javax.swing.JButton();
        jbtCancela = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtPresentacion = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Factura"));

        jLabel2.setText("Fecha:");

        jLabel3.setText("Número Factura");

        jLabel4.setText("Vendedor:");

        txtSecuencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecuencialActionPerformed(evt);
            }
        });

        jLabel13.setText("--");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumFac, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSecuencial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtVendedor)
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtNumFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSecuencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));

        jLabel1.setText("CI. Cliente:");

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombres y Apellidos:");

        jLabel6.setText("Teléfono:");

        jLabel7.setText("Celular:");

        jLabel8.setText("E-mail:");

        jLabel9.setText("Dirección:");

        jLabel21.setText("Razón Social:");

        jLabel22.setText("Tipo Contribuyente:");

        jLabel23.setText("RUC:");

        javax.swing.GroupLayout txtNombreLayout = new javax.swing.GroupLayout(txtNombre);
        txtNombre.setLayout(txtNombreLayout);
        txtNombreLayout.setHorizontalGroup(
            txtNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtNombreLayout.createSequentialGroup()
                .addGroup(txtNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(txtNombreLayout.createSequentialGroup()
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomCli, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefono))
                    .addGroup(txtNombreLayout.createSequentialGroup()
                        .addGroup(txtNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(txtNombreLayout.createSequentialGroup()
                                .addComponent(txtRazonS, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTipo))
                            .addGroup(txtNombreLayout.createSequentialGroup()
                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(txtNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(txtNombreLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRuc)))))
                .addGap(74, 74, 74))
        );
        txtNombreLayout.setVerticalGroup(
            txtNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtNombreLayout.createSequentialGroup()
                .addGroup(txtNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNomCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(txtNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(txtNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtRazonS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Factura"));

        jtbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtbProductos);

        jLabel10.setText("Còdigo:");

        txtCodProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodProdActionPerformed(evt);
            }
        });
        txtCodProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodProdKeyPressed(evt);
            }
        });

        jLabel11.setText("Descripción:");

        jLabel12.setText("Cantidad:");

        txtCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantActionPerformed(evt);
            }
        });

        jLabel14.setText("Subtotal:");

        jLabel15.setText("Descuento:");

        jLabel16.setText("IVA:");

        jLabel17.setText("Total:");

        jLabel18.setText("Descuento %:");

        jLabel19.setText("Pre. Unit");

        jLabel20.setText("Pago:");

        jcbPagos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CONTADO", "DEPOSITO", "TARJETA CREDITO", "CRÉDITO" }));

        jbtAgregar.setText("+");
        jbtAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAgregarActionPerformed(evt);
            }
        });

        jbtCancela.setText("-");
        jbtCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelaActionPerformed(evt);
            }
        });

        jLabel24.setText("Presentacion");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addGap(21, 21, 21))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel16)
                                            .addGap(44, 44, 44)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(37, 37, 37))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSubT)
                            .addComponent(txtDescuento)
                            .addComponent(txtIva)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDesPro, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel19)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPreU, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDescPro, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(107, 107, 107)
                            .addComponent(jbtAgregar)
                            .addGap(1, 1, 1)
                            .addComponent(jbtCancela))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(txtDesPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24)
                                .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txtDescPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(txtPreU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtAgregar)
                            .addComponent(jbtCancela))))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jcbPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(txtSubT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSecuencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecuencialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecuencialActionPerformed

    private void jbtCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtCancelaActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
        if (txtCliente.getText().trim().length() != 10) {
            consultaCliente cn = new consultaCliente(this, rootPaneCheckingEnabled, txtCliente.getText().trim());
            cn.show();
            txtCliente.setText(cn.cedula);
            buscarCliente(txtCliente.getText());
        } else {
            buscarCliente(txtCliente.getText());
        }
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtCodProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProdKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCodProdKeyPressed

    private void txtCodProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodProdActionPerformed
        // TODO add your handling code here:
        if (txtCodProd.getText().trim().length() == 12 || txtCodProd.getText().trim().length() == 13) {
            calculoCodBarras cd = new calculoCodBarras();
            if (txtCodProd.getText().length() == 12) {
                if (cd.verificador(txtCodProd.getText())) {
                    //System.out.println("entra al if de 12");
                    ingresoStockGNI12();
                } else {
                    JOptionPane.showMessageDialog(null, "Numero codigo erroneo 12");
                }
            } else {
                if (cd.verificador13D(txtCodProd.getText())) {
                    System.out.println("ok");
                } else {
                    JOptionPane.showMessageDialog(null, "Numero codigo erroneo");
                }
            }

        } else {
            if (txtCodProd.getText().trim().length() == 6) {
                buscarProd(txtCodProd.getText().trim());
            } else {
                consultaProductos bp = new consultaProductos(this, true, txtCodProd.getText().trim());
                bp.show();
                txtCodProd.setText(bp.data);
                buscarProd(txtCodProd.getText().trim());
            }

        }

    }//GEN-LAST:event_txtCodProdActionPerformed

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        // TODO add your handling code here:
        txtDescPro.requestFocus();

    }//GEN-LAST:event_txtCantActionPerformed

    private void jbtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAgregarActionPerformed
        // TODO add your handling code here:
        agregarAtabla();
    }//GEN-LAST:event_jbtAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(FacturaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturaVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtAgregar;
    private javax.swing.JButton jbtCancela;
    private javax.swing.JComboBox jcbPagos;
    private javax.swing.JTable jtbProductos;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodProd;
    private javax.swing.JTextField txtDesPro;
    private javax.swing.JTextField txtDescPro;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNomCli;
    private javax.swing.JPanel txtNombre;
    private javax.swing.JTextField txtNumFac;
    private javax.swing.JTextField txtPreU;
    private javax.swing.JTextField txtPresentacion;
    private javax.swing.JTextField txtRazonS;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtSecuencial;
    private javax.swing.JTextField txtSubT;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
