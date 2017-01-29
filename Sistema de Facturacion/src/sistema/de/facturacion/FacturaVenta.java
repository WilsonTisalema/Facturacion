/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.facturacion;

import dialogs.busquedaFactura;
import dialogs.consultaCliente;
import dialogs.consultaProductos;
import dialogs.generarCobros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Benjita
 */
public class FacturaVenta extends javax.swing.JFrame {

    /**
     * Creates new form FacturaVenta
     */
    DefaultTableModel modelo;
    float iva_ecuador;

    public FacturaVenta() {
        initComponents();
        //desactivar();
        txtDescuento.setText("0");
        traerIVA();
        //txtIva.setText(String.valueOf(iva_ecuador));
        //String iv=lblIva.getText();
        lblIva.setText("IVA " + iva_ecuador + "$ :");
        txtIva.setEditable(false);
        cargarHora();
        txtFecha.setEnabled(false);
        cargarSecuencial();
        cargarNumeroFactura();
        String[] titulos = {"Código", "Descripcion", "Cantidad", "Pre. Uni", "IVA", "Descuento %", "Total"};
        modelo = new DefaultTableModel(null, titulos);
        jtbProductos.setModel(modelo);
        txtNumFac.setEnabled(false);
        txtVendedor.setEnabled(false);
        txtVendedor.setText("1804181400");
        setLocationRelativeTo(null);
        bloquear();
    }

    public void bloquear() {
        jbtnNuevo.setEnabled(true);
        jbtnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        jbtnImprimit.setEnabled(false);
        btnSalir.setEnabled(true);
        txtCliente.setEnabled(false);
        txtNomCli.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCelular.setEnabled(false);
        txtRazonS.setEnabled(false);
        txtEmail.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTipo.setEnabled(false);
        txtRuc.setEnabled(false);
        txtCodProd.setEnabled(false);
        txtDesPro.setEnabled(false);
        txtPresentacion.setEnabled(false);
        txtCant.setEnabled(false);
        txtPreU.setEnabled(false);
        txtDescPro.setEnabled(false);
        txtSubT.setEnabled(false);
        txtIva.setEnabled(false);
        txtIva0.setEnabled(false);
        txtDescuento.setEnabled(false);
        txtTotal.setEnabled(false);
        jbtAgregar.setEnabled(false);
        jbtCancela.setEnabled(false);
        jcbPagos.setEnabled(false);

    }

    public void limpiar() {
        txtCliente.setText("");
        txtNomCli.setText("");
        txtTelefono.setText("");
        txtCelular.setText("");
        txtRazonS.setText("");
        txtEmail.setText("");
        txtDireccion.setText("");
        txtTipo.setText("");
        txtRuc.setText("");
        txtCodProd.setText("");
        txtDesPro.setText("");
        txtPresentacion.setText("");
        txtCant.setText("");
        txtPreU.setText("");
        txtDescPro.setText("");
        txtSubT.setText("");
        txtIva.setText("");
        txtIva0.setText("");
        txtDescuento.setText("");
        txtTotal.setText("");
        jbtAgregar.setText("");
        jbtCancela.setText("");
        jcbPagos.setSelectedIndex(0);

    }

    public void inNuevo() {
        jbtnNuevo.setEnabled(false);
        jbtnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        jbtnImprimit.setEnabled(true);
        txtCliente.setEnabled(true);
        txtNomCli.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCelular.setEnabled(true);
        txtRazonS.setEnabled(true);
        txtEmail.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTipo.setEnabled(true);
        txtRuc.setEnabled(true);
        txtCodProd.setEnabled(true);
        txtDesPro.setEnabled(true);
        txtPresentacion.setEnabled(true);
        txtCant.setEnabled(true);
        txtPreU.setEnabled(true);
        txtDescPro.setEnabled(true);
        txtSubT.setEnabled(true);
        txtIva.setEnabled(true);
        txtIva0.setEnabled(true);
        txtDescuento.setEnabled(true);
        txtTotal.setEnabled(true);
        jbtAgregar.setEnabled(true);
        jbtCancela.setEnabled(true);
        jcbPagos.setEnabled(true);
        txtCliente.requestFocus();

    }

    public void inCancelar() {
        jbtnNuevo.setEnabled(true);
        jbtnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        jbtnImprimit.setEnabled(false);
    }

    public FacturaVenta(String vendedor) {
        initComponents();
        txtDescuento.setText("0");
        jbtnImprimit.setEnabled(false);
        cargarHora();
        lblIva.setText("IVA " + iva_ecuador + "$ :");
        txtIva.setEditable(false);
        txtFecha.setEnabled(false);
        cargarSecuencial();
        txtNumFac.setEnabled(false);
        txtVendedor.setEnabled(false);
        txtVendedor.setText(vendedor);
        setLocationRelativeTo(null);
        cargarNumeroFactura();
    }

    public void traerIVA() {
        conexion_mysql cc = new conexion_mysql();
        Connection cn = cc.conectar();
        String sql = "";
        sql = "select NUM_NUM  from numeros where COD_NUM ='CD1'";
        try {
            Statement ps = cn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                iva_ecuador = Float.valueOf(rs.getString("NUM_NUM"));
                //System.out.println(iva_ecuador);
            }
        } catch (Exception ex) {
            // Logger.getLogger(FacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se puede traer el IVA");
        }
    }

    public void cargarNumeroFactura() {
        conexion_mysql cn = new conexion_mysql();
        Connection cc = cn.conectar();
        int secuencial = 0;
        String sql = "select num_fac from encabezadofactura";
        try {
            String numero_factura = "";
            Statement ps = cc.createStatement();
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                numero_factura = rs.getString("num_fac");

            }
            secuencial = Integer.valueOf(numero_factura);
            //System.out.println("numero fac= " + secuencial);
            if (secuencial > 0) {
                secuencial = secuencial + 1;
                //secuencial=1010;
                String secu = String.valueOf(secuencial);
                //traigo el secuencial y le sumo 1 y aumento los 0os de la izquiera
                for (int i = 0; i < 10; i++) {
                    if (secu.length() != 9) {
                        secu = "0" + secu;
                    }
                }
                txtSecuencial.setText(secu);
                System.out.println(secu);
            } else {
                txtSecuencial.setText("000000001");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se puede obtener numero de factura");

        }
        txtSecuencial.setEnabled(false);
        txtCliente.requestFocus();
    }

    public void cargarHora() {
        Calendar cs = new GregorianCalendar();
        Date fecha = cs.getTime();
        String dia, mes, anio;
        dia = String.valueOf(fecha.getDate());
        if (dia.length() == 1) {
            dia = "0" + dia;
        }
        mes = String.valueOf(fecha.getMonth() + 1);
        if (mes.length() == 1) {
            mes = "0" + mes;
        }
        anio = String.valueOf(fecha.getYear() + 1900);
        String fecha1 = anio + "-" + mes + "-" + dia;
        txtFecha.setText(fecha1);
    }

    public void buscarCliente(String cedula) {
        conexion_mysql cn = new conexion_mysql();
        Connection cc = cn.conectar();
        String sql = "";
        sql = "select nom_cli,nom_cli1,ape_cli,ape_cli1,TLF1_CLI,CEL1_CLI,E_MAIL_CLI,DIR_CLI,RUC_CLI,TIPO_CONT_CLI,ACT_CLI from clientes where ci_cli='" + cedula + "'";
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

                txtTipo.setText(rs.getString("TIPO_CONT_CLI"));
                txtRuc.setText(rs.getString("RUC_CLI"));
                int activo = Integer.valueOf(rs.getString("ACT_CLI"));
                if (activo == 0) {
                    jchActivo.setSelected(true);
                } else {
                    jchActivo.setSelected(false);
                }
                jchActivo.setEnabled(false);
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
        txtCodProd.requestFocus();

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

    public void calculoTotalesPie() {
        //txtDescuento.setText("0");
        if (txtDescuento.getText().trim().length() == 0) {
            txtDescuento.setText("0");
        }
        float suma = 0;
        float conIva = 0;
        float sinIva = 0;
        float descuentos = 0;
        for (int i = 0; i < jtbProductos.getRowCount(); i++) {
            suma = suma + Float.valueOf(jtbProductos.getValueAt(i, 6).toString());
            if ("0".equals(jtbProductos.getValueAt(i, 4).toString())) {
                sinIva = sinIva + Float.valueOf(jtbProductos.getValueAt(i, 4).toString());
            } else {
                conIva = conIva + Float.valueOf(jtbProductos.getValueAt(i, 4).toString());
            }
            descuentos = descuentos + Float.valueOf(jtbProductos.getValueAt(i, 5).toString());
        }
        txtSubT.setText(String.valueOf(suma));
        txtIva.setText(String.valueOf(conIva));
        txtIva0.setText(String.valueOf(sinIva));
        txtDescuento.setText(String.valueOf(descuentos));
        float subTotal = suma;
        float descuento = Float.valueOf(txtDescuento.getText().trim());
        float descuentoDinero = subTotal * (descuento / 100);
        //float ivaf = (subTotal - descuentoDinero) * ((iva_ecuador / 100));
        double totales = (subTotal - descuentoDinero);
        totales = Math.floor(totales * 100) / 100.0;
        //System.out.println((iva_ecuador / 100) + 1 + " iva");
        txtTotal.setText(String.valueOf(totales));
        //txtIva.setText(String.valueOf(ivaf));
    }

    public int verificarSiEstaEnTabla() {
        int comprobacion = 0;
        int numeroFilas = jtbProductos.getRowCount();
        // System.out.println("Numero de filas= "+numeroFilas);
        for (int i = 0; i < numeroFilas; i++) {
            String datodeCaja = txtCodProd.getText().trim().toUpperCase();
            String datoTabla = jtbProductos.getValueAt(i, 0).toString();
            if (datoTabla.equals(datodeCaja)) {
                comprobacion = i + 1;
                //System.out.println(comprobacion+" comprobaciones");
            }

        }
        return comprobacion;
    }

    public void agregarAtabla() {
        int y = 0;
        if (txtCant.getText().trim().length() > 0) {
            int dato_stock = Integer.valueOf(txtCant.getText().trim());
            if (dato_stock > stockProBase && stockProBase <= 0) {
                JOptionPane.showMessageDialog(null, "El stock es = " + stockProBase);
                y++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar cantidad");
            y++;
        }
        if (txtDescPro.getText().trim().length() > 0) {
            float dato_descuento = Float.valueOf(txtDescPro.getText());

            if (dato_descuento > max_descuento) {
                JOptionPane.showMessageDialog(null, "Descuento Maximo descuento es = " + max_descuento);
                y++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar descuento");
            y++;
        }

        if (y == 0) {
            String[] datos = new String[7];
            datos[0] = txtCodProd.getText().trim().toUpperCase();
            datos[1] = txtDesPro.getText().trim();

            datos[3] = txtPreU.getText().trim();
            //datos[5] = String.valueOf(Integer.valueOf(txtDescPro.getText().trim()));
            float cantidad = Float.valueOf(Float.valueOf(txtCant.getText().trim()) * Float.valueOf(txtPresentacion.getText().trim()));
            datos[2] = String.valueOf(cantidad);
            //System.out.println(cantidad + " cantidad a comprar");
            float precioU = Float.valueOf(txtPreU.getText().trim());
            float descuento = Float.valueOf(txtDescPro.getText().trim());

            float totalS = (cantidad * precioU) * (descuento / 100);
            datos[5] = String.valueOf(totalS);
            float total = ((cantidad * precioU) - totalS);
            float ivaProducto = 0;
            if (jchkIvaP.isSelected()) {
                datos[4] = String.valueOf(total * (iva_ecuador / 100));
                ivaProducto = total * (iva_ecuador / 100);
            } else {
                datos[4] = "0";
                ivaProducto = 0;
            }
            datos[6] = String.valueOf(total + ivaProducto);
            modelo.addRow(datos);
            calculoTotalesPie();
            limiparCajasProductos();
        }
        jtbProductos.setModel(modelo);
    }

    public void limiparCajasProductos() {
        txtCodProd.setText("");
        txtDesPro.setText("");
        txtDescPro.setText("");
        txtCant.setText("");
        txtPreU.setText("");
        txtPresentacion.setText("");
        txtCodProd.setEnabled(true);
        txtCodProd.requestFocus();
    }
    int stockProBase;
    int max_descuento;

    public void buscarProd(String producto) {
        conexion_mysql cn = new conexion_mysql();
        Connection cc = cn.conectar();
        String sql = "";
        sql = "select p.cod_prod,p.des_prod,p.stock_pro,p.PRE1_PROD,p.POR_MAX_DES_PROD,pr.DES_PRES_PRO,p.GRAB_IVA_P from productos p,presentaciones_productos pr where p.cod_prod = '" + producto + "' and p.cod_prod=pr.COD_PRO_P";
        System.out.println(sql);
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
                String iv = rs.getString("GRAB_IVA_P");
                if (Integer.valueOf(iv) == 0) {
                    jchkIvaP.setSelected(true);
                } else {
                    jchkIvaP.setSelected(false);
                }
                jchkIvaP.setEnabled(false);
            }
            //  modelo.addRow(cadena);
            //jtbProductos.setModel(modelo);
        } catch (SQLException ex) {
            //Logger.getLogger(consultaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void imprimir() {
        conexion_mysql cn = new conexion_mysql();
        Connection cc = cn.conectar();
        Map parametro = new HashMap();
        try {
            parametro.put("numero", txtSecuencial.getText().trim());
            JasperReport reporte = JasperCompileManager.compileReport("c:/leb/factura.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporte, parametro, cc);
            JasperViewer.viewReport(print, false);
        } catch (Exception ex) {
            Logger.getLogger(FacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int y = 0;

    public void guardarFactura() {
        conexion_mysql cn = new conexion_mysql();
        Connection cc = cn.conectar();
        String sql = "";
        int insertar = 0;
        sql = "insert into encabezadofactura(SEC_FAC, NUM_FAC, FEC_HOR_FAC, VEN_FAC, CLIE_FAC, SUB_TO_FAC, DES_TO_FAC, IVA_FAC, TOT_FAC, PAG_FAC,EST_FAC) values(?,?,?,?,?,?,?,?,?,?,?)";

        String SEC_FAC, NUM_FAC, FEC_HOR_FAC, VEN_FAC, CLIE_FAC, SUB_TO_FAC, DES_TO_FAC, IVA_FAC, TOT_FAC, PAG_FAC, EST_FAC;
        SEC_FAC = txtNumFac.getText().trim();
        NUM_FAC = txtSecuencial.getText().trim();
        String fecha = txtFecha.getText().trim();
        Calendar calendario = Calendar.getInstance();
        EST_FAC = "0";
        String hora, minutos, segundos;
        hora = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
        if (hora.length() == 1) {
            hora = "0" + hora;
        }
        minutos = String.valueOf(calendario.get(Calendar.MINUTE));
        if (minutos.length() == 1) {
            minutos = "0" + minutos;
        }
        segundos = String.valueOf(calendario.get(Calendar.SECOND));
        if (segundos.length() == 1) {
            segundos = "0" + segundos;
        }
        String horas = hora + ":" + minutos + ":" + segundos;
        //System.out.println(fecha+" "+ horas +"   es hora");
        FEC_HOR_FAC = fecha + " " + horas;
        VEN_FAC = txtVendedor.getText().trim();
        CLIE_FAC = txtCliente.getText().trim();
        SUB_TO_FAC = txtSubT.getText().trim();
        DES_TO_FAC = txtDescuento.getText().trim();
        IVA_FAC = txtIva.getText().trim();
        TOT_FAC = txtTotal.getText().trim();
        PAG_FAC = jcbPagos.getSelectedItem().toString();
        try {
            PreparedStatement ps = cc.prepareStatement(sql);
            ps.setString(1, SEC_FAC);
            ps.setString(2, NUM_FAC);
            ps.setString(3, FEC_HOR_FAC);
            ps.setString(4, VEN_FAC);
            ps.setString(5, CLIE_FAC);
            ps.setString(6, SUB_TO_FAC);
            ps.setString(7, DES_TO_FAC);
            ps.setString(8, IVA_FAC);
            ps.setString(9, TOT_FAC);
            ps.setString(10, PAG_FAC);
            ps.setString(11, EST_FAC);
            //System.out.println(sql);
            insertar = ps.executeUpdate();

        } catch (Exception ex) {
            //Logger.getLogger(FacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se puede guardar encabezado de factura " + ex);
        }
        String sql2 = "";
        sql2 = "insert into  detalle_fac_ven(SEC_NUM_FAC_P, NUM_FAC_PER, COD_PRO_P, CANT_PRO, DES_PRO, PRE_UNI_PRO,tot_det) values(?,?,?,?,?,?,?)";
        String SEC_NUM_FAC_P, NUM_FAC_PER, COD_PRO_P, CANT_PRO, DES_PRO, PRE_UNI_PRO;
        float tot_det;
        for (int i = 0; i < jtbProductos.getRowCount(); i++) {
            SEC_NUM_FAC_P = txtNumFac.getText().trim();
            NUM_FAC_PER = txtSecuencial.getText().trim();
            COD_PRO_P = jtbProductos.getValueAt(i, 0).toString();
            CANT_PRO = jtbProductos.getValueAt(i, 2).toString();
            //System.out.println(CANT_PRO);
            DES_PRO = jtbProductos.getValueAt(i, 5).toString();
            PRE_UNI_PRO = jtbProductos.getValueAt(i, 3).toString();
            tot_det = Float.valueOf(jtbProductos.getValueAt(i, 6).toString());
            //System.out.println(sql2);
            try {
                PreparedStatement ps1 = cc.prepareStatement(sql2);
                ps1.setString(1, SEC_NUM_FAC_P);
                ps1.setString(2, NUM_FAC_PER);
                ps1.setString(3, COD_PRO_P);
                ps1.setString(4, CANT_PRO);
                ps1.setString(5, DES_PRO);
                ps1.setString(6, PRE_UNI_PRO);
                ps1.setFloat(7, tot_det);
                insertar = insertar + ps1.executeUpdate();
                System.out.println(sql2);
                actualizarStock(COD_PRO_P, CANT_PRO);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se puede insertar productos " + ex);
            }
            if (insertar == 2) {
                JOptionPane.showMessageDialog(null, "Factura guardada con exito");
                generarCobros gc = new generarCobros(null, true, txtNumFac.getText(), txtSecuencial.getText(), txtTotal.getText());
                gc.show();
                jbtnImprimit.setEnabled(true);
                jbtnImprimit.requestFocus();
            }
        }

    }

    public void actualizarStock(String codigo, String cantidad) {
        conexion_mysql cc = new conexion_mysql();
        Connection cn = cc.conectar();
        float cantidadB = Float.valueOf(cantidad);
        float stockActual = Float.valueOf(stockBaseM(codigo));
        float nuevoStock = stockActual - cantidadB;
        String sql = "";
        sql = "update productos set stock_pro='" + String.valueOf(nuevoStock) + "' where cod_prod='" + codigo + "'";
        System.out.println("actualizacion " + sql);
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(FacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "update " + ex);
        }
    }

    public void actualizarStockmenos(String codigo, String cantidad) {
        conexion_mysql cc = new conexion_mysql();
        Connection cn = cc.conectar();
        float cantidadB = Float.valueOf(cantidad);
        float stockActual = Float.valueOf(stockBaseM(codigo));
        float nuevoStock = stockActual + cantidadB;
        String sql = "";
        sql = "update productos set stock_pro='" + String.valueOf(nuevoStock) + "' where cod_prod='" + codigo + "'";
        System.out.println("actualizacion " + sql);
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(FacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "update " + ex);
        }
    }

    public String stockBaseM(String codigo) {
        String data = "0";
        conexion_mysql cn = new conexion_mysql();
        Connection cc = cn.conectar();
        String sql = "";
        sql = "select stock_pro from productos where cod_prod='" + codigo + "'";
        try {
            Statement ps = cc.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                data = rs.getString("stock_pro");
            }
        } catch (Exception ex) {
            Logger.getLogger(FacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public void limpiarTodo() {
        FacturaVenta fv = new FacturaVenta(txtVendedor.getText());
        this.dispose();
        fv.show();
    }

    public void anulacion() {
        conexion_mysql cc = new conexion_mysql();
        Connection cn = cc.conectar();
        String sql = "";
        sql = "update encabezadofactura set est_fac='1' where num_fac='" + txtSecuencial.getText() + "'";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se anula exitosamente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        String codigo = "";
        String cantidad = "";
        String sql2 = "";
        for (int i = 0; i < jtbProductos.getRowCount(); i++) {
            codigo = jtbProductos.getValueAt(i, 0).toString();
            cantidad = jtbProductos.getValueAt(i, 2).toString();
            //System.out.println(codigo+"+"+cantidad);
            actualizarStockmenos(codigo, cantidad);

        }

    }

    public void buequedaDeFactura() {
        //traerDetalle
        conexion_mysql cc = new conexion_mysql();
        Connection cn = cc.conectar();
        String sql = "";
        sql = "select df.COD_PRO_P,df.CANT_PRO,df.DES_PRO,df.PRE_UNI_PRO,ef.SUB_TO_FAC,ef.DES_TO_FAC,ef.EST_FAC"
                + " from detalle_fac_ven df, encabezadofactura ef where df.num_fac_per='" + txtSecuencial.getText() + "' "
                + "and  ef.NUM_FAC=df.NUM_FAC_PER";
        String[] datos = new String[7];
        try {
            Statement ps = cn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                txtCodProd.setText(String.valueOf(rs.getString("COD_PRO_P")));
                buscarProd(String.valueOf(rs.getString("COD_PRO_P")));
                txtCant.setText(String.valueOf(rs.getString("CANT_PRO")));
                txtPreU.setText(String.valueOf(rs.getString("PRE_UNI_PRO")));
                txtDescPro.setText(String.valueOf(rs.getString("DES_PRO")));
                txtPresentacion.setText("1");
                int an = Integer.valueOf(String.valueOf(rs.getString("EST_FAC")));
                if (an == 0) {
                    lblFacturaAnulada.setText("");
                } else {
                    lblFacturaAnulada.setText("Anulada");
                }
                agregarAtabla();

            }
        } catch (SQLException ex) {
            Logger.getLogger(FacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
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
        jbtnAnular = new javax.swing.JButton();
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
        jchActivo = new javax.swing.JCheckBox();
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
        lblIva = new javax.swing.JLabel();
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
        jchkIvaP = new javax.swing.JCheckBox();
        lblIva1 = new javax.swing.JLabel();
        txtIva0 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        lblFacturaAnulada = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jbtnNuevo = new javax.swing.JButton();
        jbtnGuardar = new javax.swing.JButton();
        jbtnImprimit = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Fecha:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Número Factura");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Vendedor:");

        txtSecuencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecuencialActionPerformed(evt);
            }
        });

        jLabel13.setText("--");

        jbtnAnular.setText("Buscar");
        jbtnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAnularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumFac, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSecuencial, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnAnular)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSecuencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel4)
                    .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnAnular))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("CI. Cliente:");

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nombres y Apellidos:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Teléfono:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Celular:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("E-mail:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Dirección:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Razón Social:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Tipo Contribuyente:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
                        .addGap(18, 18, 18)
                        .addComponent(txtNomCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(txtNombreLayout.createSequentialGroup()
                        .addGroup(txtNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtNombreLayout.createSequentialGroup()
                                .addComponent(txtRazonS, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel23))
                            .addGroup(txtNombreLayout.createSequentialGroup()
                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(txtNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRuc)
                            .addGroup(txtNombreLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jchActivo)
                .addContainerGap())
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
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchActivo))
                .addGap(2, 2, 2)
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

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

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Descripción:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Cantidad:");

        txtCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Subtotal $:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Descuento:");

        lblIva.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIva.setText("IVA");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Total $:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Descuento %:");

        txtDescPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescProActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Pre. Unit");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Pago:");

        jcbPagos.setBackground(new java.awt.Color(102, 204, 255));
        jcbPagos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbPagos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CONTADO", "TARJETA CREDITO", "CRÉDITO" }));

        jbtAgregar.setBackground(new java.awt.Color(51, 204, 255));
        jbtAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtAgregar.setText("+");
        jbtAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAgregarActionPerformed(evt);
            }
        });

        jbtCancela.setBackground(new java.awt.Color(51, 204, 255));
        jbtCancela.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtCancela.setText("-");
        jbtCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelaActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Presentacion");

        jchkIvaP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jchkIvaP.setText("IVA");

        lblIva1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIva1.setText("IVA 0%:");

        jButton2.setText("Anular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblFacturaAnulada.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblFacturaAnulada.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel10)
                                    .addGap(38, 38, 38)
                                    .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(27, 27, 27)
                                    .addComponent(txtCant)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDesPro, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(jLabel19)
                                    .addGap(29, 29, 29)
                                    .addComponent(txtPreU, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDescPro, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(67, 67, 67)
                                    .addComponent(jchkIvaP)))
                            .addGap(29, 29, 29)
                            .addComponent(jbtAgregar)
                            .addGap(18, 18, 18)
                            .addComponent(jbtCancela)
                            .addGap(17, 17, 17))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jcbPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblFacturaAnulada, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(63, 63, 63)
                            .addComponent(jButton2)
                            .addGap(245, 245, 245)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblIva)
                                        .addComponent(jLabel17))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addGap(21, 21, 21))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblIva1)
                                                .addComponent(jLabel15))
                                            .addGap(18, 18, 18)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtIva0, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSubT, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbtCancela)
                                    .addComponent(jbtAgregar)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(txtDesPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel24)
                                        .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel18)
                                                    .addComponent(txtDescPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jchkIvaP)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel12)
                                                .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel19)
                                            .addComponent(txtPreU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(jcbPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFacturaAnulada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(txtSubT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(21, 21, 21)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIva1)
                    .addComponent(txtIva0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIva)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbtnNuevo.setBackground(new java.awt.Color(51, 204, 255));
        jbtnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jbtnNuevo.setText("Nuevo");
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });

        jbtnGuardar.setBackground(new java.awt.Color(51, 204, 255));
        jbtnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbtnGuardar.setText("Guardar");
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        jbtnImprimit.setBackground(new java.awt.Color(51, 204, 255));
        jbtnImprimit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnImprimit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        jbtnImprimit.setText("Imprimir");
        jbtnImprimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnImprimitActionPerformed(evt);
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

        jButton1.setBackground(new java.awt.Color(51, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("AgregarCliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jbtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnImprimit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jbtnNuevo)
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(26, 26, 26)
                .addComponent(jbtnImprimit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSecuencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecuencialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecuencialActionPerformed

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

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        // TODO add your handling code here:
        //limpiarTodo();
        y = 0;
        cargarSecuencial();
        inNuevo();

    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnImprimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimitActionPerformed
        // TODO add your handling code here:
        imprimir();
    }//GEN-LAST:event_jbtnImprimitActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        // TODO add your handling code here:
        y = 0;
        if (jchActivo.isSelected()) {
            modelo = (DefaultTableModel) jtbProductos.getModel();
            jtbProductos.setModel(modelo);
            guardarFactura();
        } else {
            JOptionPane.showMessageDialog(null, "Cliente inactivo");
        }
        y = 0;
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelaActionPerformed
        // TODO add your handling code here:
        txtCodProd.setText("");
        txtCodProd.setEnabled(true);
        txtCodProd.requestFocus();
    }//GEN-LAST:event_jbtCancelaActionPerformed

    private void jbtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAgregarActionPerformed
        // TODO add your handling code here:
        int n = verificarSiEstaEnTabla();
        if (n == 0) {
            agregarAtabla();
        } else {
            n = n - 1;
            modelo = (DefaultTableModel) jtbProductos.getModel();
            modelo.removeRow(n);
            jtbProductos.setModel(modelo);
            agregarAtabla();
        }

    }//GEN-LAST:event_jbtAgregarActionPerformed

    private void txtDescProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescProActionPerformed
        // TODO add your handling code here:
        jbtAgregar.requestFocus();
    }//GEN-LAST:event_txtDescProActionPerformed

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        // TODO add your handling code here:
        txtDescPro.requestFocus();
    }//GEN-LAST:event_txtCantActionPerformed

    private void txtCodProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodProdKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodProdKeyPressed

    private void txtCodProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodProdActionPerformed
        // TODO add your handling code here:
        txtDescPro.setText("0");
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
                    //System.out.println("ok");

                } else {
                    JOptionPane.showMessageDialog(null, "Numero codigo erroneo");
                }
            }

        } else {
            if (txtCodProd.getText().trim().length() == 6) {
                buscarProd(txtCodProd.getText().trim());
                txtDescPro.setText("0");
            } else {
                consultaProductos bp = new consultaProductos(this, true, txtCodProd.getText().trim());
                bp.show();
                txtCodProd.setText(bp.data);
                buscarProd(txtCodProd.getText().trim());
                txtDescPro.setText("0");
            }

        }
    }//GEN-LAST:event_txtCodProdActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        //limpiarTodo();
        inCancelar();
        limpiar();
        bloquear();
        y = 0;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jbtnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAnularActionPerformed
        // TODO add your handling code here:
        busquedaFactura bf = new busquedaFactura(null, true);
        bf.show();
        txtSecuencial.setText(bf.numero);
        txtCliente.setText(bf.cliente);
        buscarCliente(bf.cliente);
        buequedaDeFactura();
        y = 1;
        txtCodProd.setEnabled(false);
    }//GEN-LAST:event_jbtnAnularActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        y = 0;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (y == 1) {
            System.out.println("Anulada".equals(lblFacturaAnulada.getText()));
            if ("Anulada".equals(lblFacturaAnulada.getText())) {
                
                JOptionPane.showMessageDialog(null, "La factura ya se encuentra anulada");
            } else {
                anulacion();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtAgregar;
    private javax.swing.JButton jbtCancela;
    private javax.swing.JButton jbtnAnular;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnImprimit;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JComboBox jcbPagos;
    private javax.swing.JCheckBox jchActivo;
    private javax.swing.JCheckBox jchkIvaP;
    private javax.swing.JTable jtbProductos;
    private javax.swing.JLabel lblFacturaAnulada;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblIva1;
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
    private javax.swing.JTextField txtIva0;
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
