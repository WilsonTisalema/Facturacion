/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.facturacion;

import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Oscar
 */

public class Proveedores extends javax.swing.JFrame {
public static final int NUMERO_DE_PROVINCIAS = 24;//22;

    /**
     * s
     * Creates new form Proveedores
     */
    DefaultTableModel modelo;
    int  conbot=0;
    public Proveedores() {
        initComponents();
        bloquear();
        ProvinciasEc();
        cargarcodigoempresa();
//        cargartablapro("");
//        cargarcampos();
        conbot=0;
        botonesblo();
    }
    
    public void botonesblo()
    {
        jbtActualizar.setEnabled(true);
        jbtNuevo.setEnabled(true);
        jbtGuardar.setEnabled(false);
        jbtSalir.setEnabled(true);
        jbtCancelar.setEnabled(false);
    }
    public void botonesnue()
    {
        jbtActualizar.setEnabled(false);
        jbtNuevo.setEnabled(false);
        jbtGuardar.setEnabled(true);
        jbtSalir.setEnabled(true);
        jbtCancelar.setEnabled(true);
    }
     
    
    public void actualizar()
    {
             if (TxtNombre.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "INGRESE EL NOMBRE");
             TxtNombre.requestFocus();
             } else if (TxtApellido.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "INGRESE EL APELLIDO");
             TxtApellido.requestFocus();
             }else if (cbxProv.getSelectedItem().equals("")) {
             JOptionPane.showMessageDialog(null, "INGRESE UNA PROVINCIA");
             cbxProv.requestFocus();
             } else if (cbxCan.getSelectedItem().equals("")) {
             JOptionPane.showMessageDialog(null, "INGRESE UN CANTON");
             cbxCan.requestFocus();
             } else if (txtTelfCelu.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO DE CELULAR");
             txtTelfCelu.requestFocus();
             } else if (txtTelfComve.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO CONVENCIONAL");
             txtTelfComve.requestFocus();
             } else if (txtEmail.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "INGRESE UN EMAIL");
             txtEmail.requestFocus();
             }  else if (txtRzon.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "INGRESE UNA FORMA DE PAGAR");
             txtRzon.requestFocus();
             }  else if (txtReLe.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "INGRESE UN REPRESENTANTE");
             txtReLe.requestFocus();
             } else if (txtExt1.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "INGRESE UNA EXTENCION");
             txtExt1.requestFocus();
             } 
               else {
                       conexion_mysql cc = new conexion_mysql();
                       Connection cn = cc.conectar();
                       String sql = "";
                
                       sql = "update proveedores set NOM_PRO='" + TxtNombre.getText()
                    + "', APE_PRO='" + TxtApellido.getText()
                    + "', PRO_PROV='" + cbxProv.getSelectedItem().toString()
                    + "', CANT_PROV='" + cbxCan.getSelectedItem().toString()
                    + "', CEL_PROV='" + txtTelfCelu.getText()
                    + "', TLF1_PROV='" + txtTelfComve.getText()
                    + "', E_MAIL_PROV='" + txtEmail.getText()
                    + "', FOR_PAG_PROV='" + txtRzon.getText()
                    + "', REP_LEG_PROV='" + txtReLe.getText()
                    + "', EXT1_PROV='" + txtExt1.getText()
                    + "'  where  CED_PROV='" + txtCed.getText() + "'";
            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                int n = psd.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Se Actualizo Correctamente");
//                    cargartablapro("");
                    bloquear();
                    limpiar();
                 }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } 
    }
    public void bloquear()
    {
                    txtCed.setEnabled(false);
                    TxtNombre.setEnabled(false);
                    TxtApellido.setEnabled(false);
                    txtRUC.setEnabled(false);
                    CbxCodigoEmpresa.setEnabled(false);
                    cbxProv.setEnabled(false);
                    cbxCan.setEnabled(false);
                    txtTelfCelu.setEnabled(false);
                    txtTelfComve.setEnabled(false);
                    txtEmail.setEnabled(false);
                    txtRzon.setEnabled(false);
                    txtReLe.setEnabled(false);
                    txtExt1.setEnabled(false);
    }
    public void desbloquearnuevo()
    {
                    txtCed.setEnabled(true);
                    TxtNombre.setEnabled(true);
                    TxtApellido.setEnabled(true);
                    txtRUC.setEnabled(true);
                    CbxCodigoEmpresa.setEnabled(true);
                    cbxProv.setEnabled(true);
                    cbxCan.setEnabled(true);
                    txtTelfCelu.setEnabled(true);
                    txtTelfComve.setEnabled(true);
                    txtEmail.setEnabled(true);
                    txtRzon.setEnabled(true);
                    txtReLe.setEnabled(true);
                    txtExt1.setEnabled(true);
    }
    
    public void desbloquearactualizar()
    {
                    txtCed.setEnabled(false);
                    TxtNombre.setEnabled(true);
                    TxtApellido.setEnabled(true);
                    txtRUC.setEnabled(false);
                    CbxCodigoEmpresa.setEnabled(false);
                    cbxProv.setEnabled(true);
                    cbxCan.setEnabled(true);
                    txtTelfCelu.setEnabled(true);
                    txtTelfComve.setEnabled(true);
                    txtEmail.setEnabled(true);
                    txtRzon.setEnabled(true);
                    txtReLe.setEnabled(true);
                    txtExt1.setEnabled(true);
    }
    
    public void cargarcodigoempresa()
    {
        try {
            conexion_mysql cc = new conexion_mysql();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "select * from fabricante_producto";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                String codigo = rs.getString("EMP_FAB");
                CbxCodigoEmpresa.addItem(codigo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
    public void guardar()
    {
        conexion_mysql cc = new conexion_mysql();
        Connection cn = cc.conectar();
        String ced = txtCed.getText();
        if (esCedulaValida(ced) == true) {
            System.out.println(esCedulaValida(ced));
            //JOptionPane.showMessageDialog(null, "La cedula= " + ced + "  es correcta");
            String sql = "";
            sql = "select count(*) as contar from proveedores where CED_PROV='" + txtCed.getText().replace('-', ' ').replaceAll(" ", "") + "'";
            try {
                Statement psd = cn.createStatement();
                ResultSet rs = psd.executeQuery(sql);
                while (rs.next()) {
                    int contar1 = rs.getInt("contar");
                    if (contar1 > 0) {
                        JOptionPane.showMessageDialog(null, " EL PROVEEDOR YA EXITE ", "ADVERTENCIA !!!!", JOptionPane.WARNING_MESSAGE);
                        txtCed.setText("");
                        txtCed.requestFocus();
                    } else {
                            if (txtRUC.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN RUC");
                            txtRUC.requestFocus();
                        } else if (CbxCodigoEmpresa.getSelectedItem().equals("")) {
                            JOptionPane.showMessageDialog(null, "INGRESE EL CODIGO DE LA EMPRESA");
                            CbxCodigoEmpresa.requestFocus();
                        } else if (TxtNombre.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "INGRESE EL NOMBRE");
                            TxtNombre.requestFocus();
                        } else if (TxtApellido.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "INGRESE EL APELLIDO");
                            TxtApellido.requestFocus();
                        } else if (cbxProv.getSelectedItem().equals("")) {
                            JOptionPane.showMessageDialog(null, "INGRESE UNA PROVINCIA");
                            cbxProv.requestFocus();
                        } else if (cbxCan.getSelectedItem().equals("")) {
                            JOptionPane.showMessageDialog(null, "INGRESE UN CANTON");
                            cbxCan.requestFocus();
                        } else if (txtTelfCelu.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO DE CELULAR");
                            txtTelfCelu.requestFocus();
                        } else if (txtTelfComve.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO CONVENCIONAL");
                            txtTelfComve.requestFocus();
                        } else if (txtEmail.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "INGRESE UN EMAIL");
                            txtEmail.requestFocus();
                        }  else if (txtRzon.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "INGRESE UNA FORMA DE PAGAR");
                            txtRzon.requestFocus();
                        }  else if (txtReLe.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "INGRESE UN REPRESENTANTE");
                            txtReLe.requestFocus();
                        } else if (txtExt1.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "INGRESE UNA EXTENCION");
                            txtExt1.requestFocus();
                        } 
                        
                        else {

                            String cod_emp="",cedu,nom,ape,ruc,tip_con,ra_soc,nom_emp,pro,can,tel,cel,email,for_pag,repre,ext;
                            cedu=txtCed.getText();
                            nom=TxtNombre.getText();
                            ape=TxtApellido.getText();
                            ruc=txtRUC.getText();
                            
                            sql = "select COD_FAB from fabricante_producto where EMP_FAB= '"+ CbxCodigoEmpresa.getSelectedItem().toString()+"'"; 
                                            try {
                                     Statement psd9 = cn.createStatement();
                                     ResultSet rs9 = psd9.executeQuery(sql);
                                     while(rs9.next())
                                     {
                                     cod_emp = rs9.getString("COD_FAB");
                                     }System.out.println(cod_emp);
             //                       CbxCodigoEmpresa.addItem(cod_emp);
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null, ex);
                                         }
                            pro=cbxProv.getSelectedItem().toString();
                            can=cbxCan.getSelectedItem().toString();
                            tel=txtTelfComve.getText();
                            cel=txtTelfCelu.getText();
                            email=txtEmail.getText();
                            for_pag=txtRzon.getText();
                            repre=txtReLe.getText();
                            ext=txtExt1.getText();
                            sql = "insert into proveedores (CED_PROV,NOM_PRO,APE_PRO,RUC_PROV,"
                                  + "COD_EMP_PRO,PRO_PROV,CANT_PROV,CEL_PROV,TLF1_PROV,E_MAIL_PROV,FOR_PAG_PROV,REP_LEG_PROV,EXT1_PROV) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

                                try {
                                    PreparedStatement psd1 = cn.prepareStatement(sql);
                                    psd1.setString(1, cedu);
                                    psd1.setString(2, nom);
                                    psd1.setString(3, ape);
                                    psd1.setString(4, ruc);
                                    psd1.setString(5, cod_emp);
                                    psd1.setString(6, pro );
                                    psd1.setString(7, can);
                                    psd1.setString(8, tel);
                                    psd1.setString(9, cel);
                                    psd1.setString(10, email);
                                    psd1.setString(11, for_pag);
                                    psd1.setString(12, repre);
                                    psd1.setString(13, ext);
                                    int n = psd1.executeUpdate();
                                    if (n > 0) {
                                        JOptionPane.showMessageDialog(null, "se inserto correctamente");
                                        limpiar();
                                        botonesblo();
                                        bloquear();
                                        }
                                    } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null, ex);
                                    }
                                    } 

                        }

                    }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "INGRESE PROVINCIA Y CANTON");
                }

        }else {
            JOptionPane.showMessageDialog(null, "La cedula= " + ced + "  es incorrecta");
            txtCed.setText("");
            txtCed.requestFocus();
        }
}
    public void limpiar()
    {
        txtCed.setText("");
        TxtApellido.setText("");
        txtRUC.setText("");
        //cbxTipoCont.getSelectedItem().toString();
//        txtRazonSo.setText("");
        TxtNombre.setText("");
        cbxProv.removeAllItems();
        cbxCan.removeAllItems();
        txtTelfComve.setText("");
        txtTelfCelu.setText("");
        txtEmail.setText("");
        txtRzon.setText("");
        txtReLe.setText("");
        txtExt1.setText("");
        ProvinciasEc();
        Cantones();
        
    }

    public boolean controles(){
        boolean error=false;
        
        return error;
    }
    public boolean esCedulaValida(String cedula) {
        //verifica que tenga 10 dÃ­gitos y que contenga solo valores numÃ©ricos
        if (!((cedula.length() == 10) && cedula.matches("^[0-9]{10}$"))) {
            return false;
        }

        //verifica que los dos primeros dÃ­gitos correspondan a un valor entre 1 y NUMERO_DE_PROVINCIAS
        int prov = Integer.parseInt(cedula.substring(0, 2));

        if (!((prov > 0) && (prov <= NUMERO_DE_PROVINCIAS))) {
            return false;
        }

        //verifica que el Ãºltimo dÃ­gito de la cÃ©dula sea vÃ¡lido
        int[] d = new int[10];

        //Asignamos el string a un array
        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.parseInt(cedula.charAt(i) + "");
        }

        int imp = 0;
        int par = 0;

        //sumamos los duplos de posiciÃ³n impar
        for (int i = 0; i < d.length; i += 2) {
            d[i] = ((d[i] * 2) > 9) ? ((d[i] * 2) - 9) : (d[i] * 2);
            imp += d[i];
        }

        //sumamos los digitos de posiciÃ³n par
        for (int i = 1; i < (d.length - 1); i += 2) {
            par += d[i];
        }

        //Sumamos los dos resultados
        int suma = imp + par;

        //Restamos de la decena superior
        int d10 = Integer.parseInt(String.valueOf(suma + 10).substring(0, 1)
                + "0") - suma;

        //Si es diez el dÃ©cimo dÃ­gito es cero        
        d10 = (d10 == 10) ? 0 : d10;

        //si el dÃ©cimo dÃ­gito calculado es igual al digitado la cÃ©dula es correcta
        return d10 == d[9];
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
    public void mayusculas(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {
            getToolkit().beep();
            evt.consume();
        }
    }

    public void contTelCel() {

        int c = txtTelfCelu.getText().length();
        if (c <= 9) {
            JOptionPane.showMessageDialog(this, "El Numero tine menos de 10 numeros");
            txtTelfCelu.setText(" ");
        } else if (c > 10) {
            JOptionPane.showMessageDialog(this, "El Numero tine mas de 10 numeros ");
            txtTelfCelu.setText(" ");

        }
    }

    public void contTelConv() {

        int c = txtTelfComve.getText().length();
        if (c <= 8) {
            JOptionPane.showMessageDialog(this, "El Numero tine menos de 9 numeros");
            txtTelfComve.setText(" ");

        } else if (c > 9) {
            JOptionPane.showMessageDialog(this, "El Numero tine mas de 9 numeros ");
            txtTelfComve.setText(" ");
        }
    }

    public void mayusclasComen(java.awt.event.KeyEvent evt) {
       char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
    }

    public void mayusclasnombre(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
    }
    public void mayusclasape(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
    }
    
public void mayusclemail(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
    }
public void mayusformapago(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
    }
public void mayusrepre(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if(Character.isLowerCase(c))
        {
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
        }
    }
    public void ProvinciasEc() {
        cbxProv.removeAllItems();
        cbxProv.addItem("");
        cbxProv.addItem("AZUAY");
        cbxProv.addItem("BOLÍVAR");
        cbxProv.addItem("CAÑAR");
        cbxProv.addItem("CARCHI");
        cbxProv.addItem("CHIMBORAZO");
        cbxProv.addItem("COTOPAXI");
        cbxProv.addItem("EL ORO");
        cbxProv.addItem("ESMERALDAS");
        cbxProv.addItem("GALÁPAGOS");
        cbxProv.addItem("GUAYAS");
        cbxProv.addItem("IMBABURA");
        cbxProv.addItem("LOJA");
        cbxProv.addItem("LOS RÍOS");
        cbxProv.addItem("MANABÍ");
        cbxProv.addItem("MORONA SANTIAGO");
        cbxProv.addItem("NAPO");
        cbxProv.addItem("ORELLANA");
        cbxProv.addItem("PASTAZA");
        cbxProv.addItem("PICHINCHA");
        cbxProv.addItem("SANTA ELENA");
        cbxProv.addItem("SANTO DOMINGO DE LOS TSÁCHILAS");
        cbxProv.addItem("SUCUMBÍOS");
        cbxProv.addItem("TUNGURAHUA");
        cbxProv.addItem("ZAMORA CHINCHIPE");
        cbxProv.setToolTipText("SELECCIONE UNO");
    }

    public void Cantones() {
        if (cbxProv.getSelectedIndex() == 1) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("CHORDELEG");
            cbxCan.addItem("CUENCA");
            cbxCan.addItem("EL PAN");
            cbxCan.addItem("GIRÓN");
            cbxCan.addItem("GUACHAPALA");
            cbxCan.addItem("GUALACEO");
            cbxCan.addItem("NABÓN");
            cbxCan.addItem("OÑA");
            cbxCan.addItem("PAUTE");
            cbxCan.addItem("PONCE ENRIQUEZ");
            cbxCan.addItem("PUCARÁ");
            cbxCan.addItem("SAN FERNANDO");
            cbxCan.addItem("SANTA ISABEL");
            cbxCan.addItem("SEVILLA DE ORO");
            cbxCan.addItem("SÍGSIG");

        } else if (cbxProv.getSelectedIndex() == 2) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("CALUMA");
            cbxCan.addItem("CHILLANES");
            cbxCan.addItem("CHIMBO");
            cbxCan.addItem("ECHEANDÍA");
            cbxCan.addItem("GUARANDA");
            cbxCan.addItem("LAS NAVES");
            cbxCan.addItem("SAN MIGUEL");
        } else if (cbxProv.getSelectedIndex() == 3) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("AZOGUES");
            cbxCan.addItem("BIBLIÁN");
            cbxCan.addItem("CAÑAR");
            cbxCan.addItem("DÉLEG");
            cbxCan.addItem("EL TAMBO");
            cbxCan.addItem("LA TRONCAL ");
            cbxCan.addItem("SUSCAL");
        } else if (cbxProv.getSelectedIndex() == 4) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("BOLÍVAR");
            cbxCan.addItem("ESPEJO");
            cbxCan.addItem("MIRA");
            cbxCan.addItem("MONTÚFAR");
            cbxCan.addItem("SAN PEDRO DE HUACA");
            cbxCan.addItem("TULCÁN");
        } else if (cbxProv.getSelectedIndex() == 5) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("ALAUSÍ");
            cbxCan.addItem("CHAMBO");
            cbxCan.addItem("CHUNCHI");
            cbxCan.addItem("COLTA");
            cbxCan.addItem("CUMANDÁ");
            cbxCan.addItem("GUAMOTE");
            cbxCan.addItem("GUANO");
            cbxCan.addItem("PALLATANGA");
            cbxCan.addItem("PENIPE");
            cbxCan.addItem("RIOBAMBA");
        } else if (cbxProv.getSelectedIndex() == 6) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("LA MANÁ");
            cbxCan.addItem("LATACUNGA");
            cbxCan.addItem("PANGUA");
            cbxCan.addItem("PUJILÍ");
            cbxCan.addItem("SALCEDO");
            cbxCan.addItem("SAQUISILÍ");
            cbxCan.addItem("SIGCHOS");

        } else if (cbxProv.getSelectedIndex() == 7) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("ARENILLAS");
            cbxCan.addItem("ATAHUALPA");
            cbxCan.addItem("BALSAS");
            cbxCan.addItem("CHILLA");
            cbxCan.addItem("EL GUABO");
            cbxCan.addItem("HUAQUILLAS");
            cbxCan.addItem("LAS LAJAS");
            cbxCan.addItem("MACHALA");
            cbxCan.addItem("MARCABELÍ");
            cbxCan.addItem("PASAJE");
            cbxCan.addItem("PIÑAS");
            cbxCan.addItem("PORTOVELO");
            cbxCan.addItem("SANTA ROSA");
            cbxCan.addItem("ZARUMA");
        } else if (cbxProv.getSelectedIndex() == 8) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("ATACAMES");
            cbxCan.addItem("ELOY ALFARO");
            cbxCan.addItem("ESMERALDAS");
            cbxCan.addItem("MUISNE");
            cbxCan.addItem("QUININDÉ");
            cbxCan.addItem("RIOVERDE");
            cbxCan.addItem("SAN LORENZO");
        } else if (cbxProv.getSelectedIndex() == 9) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("ISABELA");
            cbxCan.addItem("SAN CRISTÓBAL");
            cbxCan.addItem("SANTA CRUZ");
        } else if (cbxProv.getSelectedIndex() == 10) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("ALFREDO BAQUERIZO MORENO");
            cbxCan.addItem("BALAO");
            cbxCan.addItem("BALZAR");
            cbxCan.addItem("COLIMES");
            cbxCan.addItem("DAULE");
            cbxCan.addItem("EL EMPALME");
            cbxCan.addItem("EL TRIUNFO");
            cbxCan.addItem("DURÁN");
            cbxCan.addItem("GENERAL ANTONIO ELIZALDE");
            cbxCan.addItem("PLAYAS");
            cbxCan.addItem("GUAYAQUIL");
            cbxCan.addItem("ISIDRO AYORA");
            cbxCan.addItem("LOMAS DE SARGENTILLO");
            cbxCan.addItem("MARCELINO MARIDUEÑA");
            cbxCan.addItem("MILAGRO");
            cbxCan.addItem("NARANJAL");
            cbxCan.addItem("NARANJITO");
            cbxCan.addItem("NOBOL");
            cbxCan.addItem("PALESTINA");
            cbxCan.addItem("PEDRO CARBO");
            cbxCan.addItem("SALITRE");
            cbxCan.addItem("SAMBORONDÓN");
            cbxCan.addItem("SANTA LUCÍA");
            cbxCan.addItem("SIMÓN BOLÍVAR");
            cbxCan.addItem("YAGUACHI");
        } else if (cbxProv.getSelectedIndex() == 11) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("ANTONIO ANTE");
            cbxCan.addItem("COTACACHI");
            cbxCan.addItem("IBARRA");
            cbxCan.addItem("OTAVALO");
            cbxCan.addItem("PIMAMPIRO");
            cbxCan.addItem("SAN MIGUEL DE URCUQUÍ");
        } else if (cbxProv.getSelectedIndex() == 12) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("CALVAS");
            cbxCan.addItem("CATAMAYO");
            cbxCan.addItem("CELICA");
            cbxCan.addItem("CHAGUARPAMBA");
            cbxCan.addItem("ESPÍNDOLA");
            cbxCan.addItem("GONZANAMÁ");
            cbxCan.addItem("LOJA");
            cbxCan.addItem("MACARÁ");
            cbxCan.addItem("OLMEDO");
            cbxCan.addItem("PALTAS");
            cbxCan.addItem("PINDAL");
            cbxCan.addItem("PUYANGO");
            cbxCan.addItem("QUILANGA");
            cbxCan.addItem("SARAGURO");
            cbxCan.addItem("SOZORANGA");
        } else if (cbxProv.getSelectedIndex() == 13) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("BABA");
            cbxCan.addItem("BABAHOYO");
            cbxCan.addItem("BUENA FE");
            cbxCan.addItem("MOCACHE");
            cbxCan.addItem("MONTALVO");
            cbxCan.addItem("PALENQUE");
            cbxCan.addItem("PUEBLOVIEJO");
            cbxCan.addItem("QUEVEDO");
            cbxCan.addItem("QUINSALOMA");
            cbxCan.addItem("URDANETA");
            cbxCan.addItem("VALENCIA");
            cbxCan.addItem("VENTANAS");
            cbxCan.addItem("VINCES");
        } else if (cbxProv.getSelectedIndex() == 14) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("BABA");
            cbxCan.addItem("BABAHOYO");
            cbxCan.addItem("BUENA FE");
            cbxCan.addItem("MOCACHE");
            cbxCan.addItem("MONTALVO");
            cbxCan.addItem("PALENQUE");
            cbxCan.addItem("PUEBLOVIEJO");
            cbxCan.addItem("QUEVEDO");
            cbxCan.addItem("QUINSALOMA");
            cbxCan.addItem("URDANETA");
            cbxCan.addItem("VALENCIA");
            cbxCan.addItem("VENTANAS");
            cbxCan.addItem("VINCES");
        } else if (cbxProv.getSelectedIndex() == 15) {
            cbxCan.removeAllItems();
            cbxCan.addItem("");
            cbxCan.addItem("BOLÍVAR");
            cbxCan.addItem("CHONE");
            cbxCan.addItem("EL CARMEN");
            cbxCan.addItem("FLAVIO ALFARO");
            cbxCan.addItem("JAMA");
            cbxCan.addItem("JARAMIJÓ");
            cbxCan.addItem("JIPIJAPA");
            cbxCan.addItem("JUNÍN");
            cbxCan.addItem("MANTA");
            cbxCan.addItem("MONTECRISTI");
            cbxCan.addItem("OLMEDO");
            cbxCan.addItem("PAJÁN");
            cbxCan.addItem("PEDERNALES");
            cbxCan.addItem("PICHINCHA");
            cbxCan.addItem("PORTOVIEJO");
            cbxCan.addItem("PUERTO LÓPEZ");
            cbxCan.addItem("ROCAFUERTE");
            cbxCan.addItem("SAN VICENTE");
            cbxCan.addItem("SANTA ANA");
            cbxCan.addItem("SUCRE");
            cbxCan.addItem("TOSAGUA");
            cbxCan.addItem("VEINTICUATRO DE MAYO");
        } else if (cbxProv.getSelectedIndex() == 16) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("ARCHIDONA");
            cbxCan.addItem("CARLOS JULIO AROSEMENA TOLA");
            cbxCan.addItem("EL CHACO");
            cbxCan.addItem("QUIJOS");
            cbxCan.addItem("TENA");
        } else if (cbxProv.getSelectedIndex() == 17) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("AGUARICO");
            cbxCan.addItem("ORELLANA");
            cbxCan.addItem("LA JOYA DE LOS SACHAS");
            cbxCan.addItem("LORETO");
        } else if (cbxProv.getSelectedIndex() == 18) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("ARAJUNO");
            cbxCan.addItem("MERA");
            cbxCan.addItem("PASTAZA");
            cbxCan.addItem("SANTA CLARA");
        } else if (cbxProv.getSelectedIndex() == 19) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("QUITO");
            cbxCan.addItem("CAYAMBE");
            cbxCan.addItem("MEJÍA");
            cbxCan.addItem("PEDRO MONCAYO");
            cbxCan.addItem("PEDRO VICENTE MALDONADO");
            cbxCan.addItem("PUERTO QUITO");
            cbxCan.addItem("RUMIÑAHUI");
            cbxCan.addItem("SAN MIGUEL DE LOS BANCOS");
        } else if (cbxProv.getSelectedIndex() == 20) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("LA LIBERTAD");
            cbxCan.addItem("SALINAS");
            cbxCan.addItem("SANTA ELENA");
        } else if (cbxProv.getSelectedIndex() == 21) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("SANTO DOMINGO");
            cbxCan.addItem("LA CONCORDIA");
        } else if (cbxProv.getSelectedIndex() == 22) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("CASCALES");
            cbxCan.addItem("CUYABENO");
            cbxCan.addItem("GONZALO PIZARRO");
            cbxCan.addItem("LAGO AGRIO");
            cbxCan.addItem("PUTUMAYO");
            cbxCan.addItem("SHUSHUFINDI");
            cbxCan.addItem("SUCUMBÍOS");
        } else if (cbxProv.getSelectedIndex() == 23) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("AMBATO");
            cbxCan.addItem("BAÑOS");
            cbxCan.addItem("CEVALLOS");
            cbxCan.addItem("MOCHA");
            cbxCan.addItem("PATATE");
            cbxCan.addItem("PELILEO");
            cbxCan.addItem("QUERO");
            cbxCan.addItem("SANTIAGO DE PÍLLARO");
            cbxCan.addItem("TISALEO");
        } else if (cbxProv.getSelectedIndex() == 24) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("CENTINELA DEL CÓNDOR");
            cbxCan.addItem("CHINCHIPE");
            cbxCan.addItem("EL PANGUI");
            cbxCan.addItem("NANGARITZA");
            cbxCan.addItem("PALANDA");
            cbxCan.addItem("PAQUISHA");
            cbxCan.addItem("YACUAMBI");
            cbxCan.addItem("YANTZAZA");
            cbxCan.addItem("ZAMORA");
        }
    }

//    public void sacarCodigo() {
//        if (txtcodigoemp.getText().length() == 12) {
//            txtcodigoemp.setEnabled(false);
//            txtcodigoemp.setText(txtcodigoemp.getText().substring(1, 6));
//                txtcodigoemp.setEnabled(false);
//        } else {
//            if (txtcodigoemp.getText().length() == 13) {
//                txtcodigoemp.setText(txtcodigoemp.getText().substring(2, 7));
//                txtcodigoemp.setEnabled(false);
//            } else {
//                JOptionPane.showMessageDialog(null, "Ingrese con pistola de codigo de barras");
//            }
//        }
//
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCed = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRUC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtApellido = new javax.swing.JTextField();
        CbxCodigoEmpresa = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbxProv = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        cbxCan = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        txtTelfComve = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelfCelu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtRzon = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtReLe = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtExt1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jbtNuevo = new javax.swing.JButton();
        jbtGuardar = new javax.swing.JButton();
        jbtActualizar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jbtSalir = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proveedores");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("CEDULA");

        txtCed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedFocusLost(evt);
            }
        });
        txtCed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedKeyTyped(evt);
            }
        });

        jLabel2.setText("RUC:");

        txtRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRUCKeyTyped(evt);
            }
        });

        jLabel7.setText("CODIGO EMPRESA");

        jLabel8.setText("NOMBRE");

        jLabel11.setText("APELLIDO");

        TxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreActionPerformed(evt);
            }
        });
        TxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombreKeyTyped(evt);
            }
        });

        TxtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtApellidoActionPerformed(evt);
            }
        });
        TxtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtApellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtApellidoKeyTyped(evt);
            }
        });

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCed, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbxCodigoEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(TxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(CbxCodigoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(384, 384, 384))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setText("PROVINCIA");

        cbxProv.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProvItemStateChanged(evt);
            }
        });
        cbxProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProvActionPerformed(evt);
            }
        });

        jLabel6.setText("CANTON");

        jLabel9.setText("CELULAR");

        txtTelfComve.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelfComveKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelfComveKeyTyped(evt);
            }
        });

        jLabel10.setText("TELEFONO");

        txtTelfCelu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelfCeluFocusLost(evt);
            }
        });
        txtTelfCelu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelfCeluKeyTyped(evt);
            }
        });

        jLabel12.setText("E-MAIL");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        txtRzon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRzonKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRzonKeyTyped(evt);
            }
        });

        jLabel14.setText("FORMA PAGO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxProv, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelfCelu, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbxCan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelfComve, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtRzon))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbxCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtTelfComve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTelfCelu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRzon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel15.setText("REPRESENTANTE");

        txtReLe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtReLeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReLeKeyTyped(evt);
            }
        });

        jLabel16.setText("EXTENSION");

        txtExt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExt1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(txtReLe, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(txtExt1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(txtExt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReLe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jbtNuevo.setBackground(new java.awt.Color(51, 204, 255));
        jbtNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jbtNuevo.setText("Nuevo");
        jbtNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNuevoActionPerformed(evt);
            }
        });

        jbtGuardar.setBackground(new java.awt.Color(51, 204, 255));
        jbtGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbtGuardar.setText("Guardar");
        jbtGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGuardarActionPerformed(evt);
            }
        });

        jbtActualizar.setBackground(new java.awt.Color(51, 204, 255));
        jbtActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ACTUALIZAR1.png"))); // NOI18N
        jbtActualizar.setText("Actualizar");
        jbtActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtActualizarActionPerformed(evt);
            }
        });

        jbtCancelar.setBackground(new java.awt.Color(51, 204, 255));
        jbtCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jbtSalir.setBackground(new java.awt.Color(51, 204, 255));
        jbtSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        jbtSalir.setText("SALIR");
        jbtSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtNuevo)
                .addGap(18, 18, 18)
                .addComponent(jbtGuardar)
                .addGap(18, 18, 18)
                .addComponent(jbtActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtCancelar)
                .addGap(18, 18, 18)
                .addComponent(jbtSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProvActionPerformed

    private void txtCedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedFocusLost

    private void cbxProvItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProvItemStateChanged
        // TODO add your handling code here:
        Cantones();
    }//GEN-LAST:event_cbxProvItemStateChanged

    private void txtTelfComveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelfComveKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
         if(txtTelfComve.getText().length() >9)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelfComveKeyTyped

    private void txtRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUCKeyTyped
        soloNumeros(evt); 
         if(txtRUC.getText().length() >13)
        {
            evt.consume();
        }// TODO add your handling code here:
    }//GEN-LAST:event_txtRUCKeyTyped

    private void txtRzonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRzonKeyTyped
        // TODO add your handling code here:
        soloLetras(evt);
        mayusformapago(evt);
         if(txtRzon.getText().length() >24)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtRzonKeyTyped

    private void txtReLeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReLeKeyTyped
        // TODO add your handling code here:
        soloLetras(evt);
        mayusrepre(evt);
         if(txtCed.getText().length() >24)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtReLeKeyTyped

    private void txtExt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExt1KeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
         if(txtExt1.getText().length() >10)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtExt1KeyTyped

    private void txtCedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
           if(txtCed.getText().length() >9)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtCedKeyTyped

    private void txtTelfCeluKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelfCeluKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
         if(txtTelfCelu.getText().length() >9)
        {
            evt.consume();
        }

    }//GEN-LAST:event_txtTelfCeluKeyTyped

    private void txtTelfCeluFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelfCeluFocusLost
        // TODO add your handling code here:
        contTelCel();
    }//GEN-LAST:event_txtTelfCeluFocusLost

    private void txtTelfComveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelfComveKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelfComveKeyReleased

    private void TxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombreActionPerformed

    private void TxtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtApellidoActionPerformed

    private void TxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombreKeyTyped
        soloLetras(evt);
        mayusclasnombre(evt);
         if(TxtNombre.getText().length() >14)
        {
            evt.consume();
        }
    }//GEN-LAST:event_TxtNombreKeyTyped

    private void TxtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtApellidoKeyTyped
        soloLetras(evt);
        mayusclasape(evt);
         if(TxtApellido.getText().length() >14)
        {
            evt.consume();
        }
    }//GEN-LAST:event_TxtApellidoKeyTyped

    private void TxtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombreKeyReleased
        //mayusclasnombre(evt);
    }//GEN-LAST:event_TxtNombreKeyReleased

    private void TxtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtApellidoKeyReleased
        //mayusclasape(evt);
    }//GEN-LAST:event_TxtApellidoKeyReleased

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        mayusclemail(evt);
         if(txtEmail.getText().length() >9)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        // mayusclemail(evt);
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtRzonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRzonKeyReleased
       // mayusformapago(evt);
    }//GEN-LAST:event_txtRzonKeyReleased

    private void txtReLeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReLeKeyReleased
       // mayusrepre(evt);
    }//GEN-LAST:event_txtReLeKeyReleased

    private void jbtSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbtSalirActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        botonesblo();
        limpiar();
        bloquear();
//        TblPro.setEnabled(true);

    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jbtActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtActualizarActionPerformed
       if(txtCed.getText().isEmpty())
       {JOptionPane.showMessageDialog(null, "SELECCIONE UN PROVEEDOR");}
        else
       {
           desbloquearactualizar();
           conbot=1;
           botonesnue();
//           TblPro.setEnabled(false);
       }
  

    }//GEN-LAST:event_jbtActualizarActionPerformed

    private void jbtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGuardarActionPerformed
        if(conbot==0)
        {guardar();}
        if(conbot==1)
        {actualizar();botonesblo();}
        conbot=0;
//        TblPro.setEnabled(true);
        
    }//GEN-LAST:event_jbtGuardarActionPerformed

    private void jbtNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNuevoActionPerformed
        desbloquearnuevo();
        botonesnue();
        limpiar();
        txtCed.requestFocus();

    }//GEN-LAST:event_jbtNuevoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuscarProveedores bpro = new BuscarProveedores();
        bpro.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox CbxCodigoEmpresa;
    public static javax.swing.JTextField TxtApellido;
    public static javax.swing.JTextField TxtNombre;
    public static javax.swing.JComboBox<String> cbxCan;
    public static javax.swing.JComboBox<String> cbxProv;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbtActualizar;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtGuardar;
    private javax.swing.JButton jbtNuevo;
    private javax.swing.JButton jbtSalir;
    public static javax.swing.JTextField txtCed;
    public static javax.swing.JTextField txtEmail;
    public static javax.swing.JTextField txtExt1;
    public static javax.swing.JTextField txtRUC;
    public static javax.swing.JTextField txtReLe;
    public static javax.swing.JTextField txtRzon;
    public static javax.swing.JTextField txtTelfCelu;
    public static javax.swing.JTextField txtTelfComve;
    // End of variables declaration//GEN-END:variables
}
