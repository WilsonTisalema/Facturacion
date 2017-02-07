/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.facturacion;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import dialogs.consultaCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sistema.de.facturacion.verficacion_cedula_ec;

/**
 *
 * @author Juank
 */
public class Clientes extends javax.swing.JFrame {

    public Clientes() {
        initComponents();
        tipoContri();
        genero();
        estadoCivil();
        provincias();
        btnBuscar.setEnabled(true);
        txtFecha.setEnabled(false);
        botonesInicio();
        lbExtranjero.setVisible(false);
        if (!Extranjero.isSelected()) {
            lbExtranjero.setText("Ecuatoriano");
        }
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

    public void mayusculas(JTextField d) {
        String cad = d.getText().toUpperCase();
        d.setText(cad);

    }

    public static boolean verificaCedula(String ced) {
        int c = ced.length(), i, sumaTotal;
        //String temp="   "; tercer metodo char a entero
        //temp [1]= '\0';
        if (c != 10) {
            return false;
        }
        for (i = 0; i < c; i = i + 1) {     // todos digitos control
            if (ced.charAt(i) < 48 || ced.charAt(i) > 57) {
                return false;
            }
        }
        // logitud correcta
        int sp = 0;
        for (i = 1; i < c - 1; i = i + 2) {// posiciones pares
            sp += Character.getNumericValue(ced.charAt(i));
            //sp+=(ced.charAt(i))-48;  otra forma del la linea anterior
            // temp = Character.toString(ced.charAt(i));
            //sp+= Integer.valueOf(temp);
        }
        //System.out.println(sp); conprobacion

        int si = 0, si2 = 0;
        for (i = 0; i < c - 1; i = i + 2) {// posiciones pares
            si2 += (Character.getNumericValue(ced.charAt(i))) * 2;
            if (si2 > 9) {
                si2 = si2 - 9;
            }
            si += si2;
            si2 = 0;
        }
        sumaTotal = si + sp;
        // comprobacion del ultimo diguito
        int z;
        z = (ced.charAt(9) - 48);
        {
            if (sumaTotal % 10 == 0) {
                if (z == 0) {

                    return true;
                } else {
                    return false;
                }
            } else {
                int a = (((sumaTotal / 10) + 1) * 10) - sumaTotal;
                if (z == a) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public void comprovacionCedula() {
        if (verificaCedula(txtCedulaC.getText()) == true) {

        } else {
            JOptionPane.showMessageDialog(this, "Cédula Incorrecta");
            txtCedulaC.setText("");
            txtCedulaC.requestFocus();
        }
    }

    public void tipoContri() {
        cbxTipContribuyente.removeAllItems();
        cbxTipContribuyente.addItem("SELECCIONE UNO");
        cbxTipContribuyente.addItem("PERSONA NATURAL");
        cbxTipContribuyente.addItem("PERSONA JURÍDICA ");
        cbxTipContribuyente.addItem("SOCIEDAD");
    }

    public void genero() {
        cbxGeneroC.addItem("FEMENINO");
        cbxGeneroC.addItem("MASCULINO");
    }

    public void estadoCivil() {
        cbxEstadocivil.addItem("SOLTERO(A)");
        cbxEstadocivil.addItem("CASADO(A)");
        cbxEstadocivil.addItem("DIVORCIADO(A)");
        cbxEstadocivil.addItem("VIUDO(A)");
        cbxEstadocivil.addItem("UNIÓN LIBRE");
    }

    public void provincias() {
        cbxProvincia.removeAllItems();
        cbxProvincia.addItem("SELECCIONE UNO");
        cbxProvincia.addItem("AZUAY");
        cbxProvincia.addItem("BOLÍVAR");
        cbxProvincia.addItem("CAÑAR");
        cbxProvincia.addItem("CARCHI");
        cbxProvincia.addItem("CHIMBORAZO");
        cbxProvincia.addItem("COTOPAXI");
        cbxProvincia.addItem("EL ORO");
        cbxProvincia.addItem("ESMERALDAS");
        cbxProvincia.addItem("GALÁPAGOS");
        cbxProvincia.addItem("GUAYAS");
        cbxProvincia.addItem("IMBABURA");
        cbxProvincia.addItem("LOJA");
        cbxProvincia.addItem("LOS RÍOS");
        cbxProvincia.addItem("MANABÍ");
        cbxProvincia.addItem("MORONA SANTIAGO");
        cbxProvincia.addItem("NAPO");
        cbxProvincia.addItem("ORELLANA");
        cbxProvincia.addItem("PASTAZA");
        cbxProvincia.addItem("PICHINCHA");
        cbxProvincia.addItem("SANTA ELENA");
        cbxProvincia.addItem("SANTO DOMINGO DE LOS TSÁCHILAS");
        cbxProvincia.addItem("SUCUMBÍOS");
        cbxProvincia.addItem("TUNGURAHUA");
        cbxProvincia.addItem("ZAMORA CHINCHIPE");
    }

    public void cantones() {
        if (cbxProvincia.getSelectedIndex() == 1) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("CHORDELEG");
            cbxCanton.addItem("CUENCA");
            cbxCanton.addItem("EL PAN");
            cbxCanton.addItem("GIRÓN");
            cbxCanton.addItem("GUACHAPALA");
            cbxCanton.addItem("GUALACEO");
            cbxCanton.addItem("NABÓN");
            cbxCanton.addItem("OÑA");
            cbxCanton.addItem("PAUTE");
            cbxCanton.addItem("PONCE ENRIQUEZ");
            cbxCanton.addItem("PUCARÁ");
            cbxCanton.addItem("SAN FERNANDO");
            cbxCanton.addItem("SANTA ISABEL");
            cbxCanton.addItem("SEVILLA DE ORO");
            cbxCanton.addItem("SÍGSIG");

        } else if (cbxProvincia.getSelectedIndex() == 2) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("CALUMA");
            cbxCanton.addItem("CHILLANES");
            cbxCanton.addItem("CHIMBO");
            cbxCanton.addItem("ECHEANDÍA");
            cbxCanton.addItem("GUARANDA");
            cbxCanton.addItem("LAS NAVES");
            cbxCanton.addItem("SAN MIGUEL");
        } else if (cbxProvincia.getSelectedIndex() == 3) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("AZOGUES");
            cbxCanton.addItem("BIBLIÁN");
            cbxCanton.addItem("CAÑAR");
            cbxCanton.addItem("DÉLEG");
            cbxCanton.addItem("EL TAMBO");
            cbxCanton.addItem("LA TRONCAL ");
            cbxCanton.addItem("SUSCAL");
        } else if (cbxProvincia.getSelectedIndex() == 4) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("BOLÍVAR");
            cbxCanton.addItem("ESPEJO");
            cbxCanton.addItem("MIRA");
            cbxCanton.addItem("MONTÚFAR");
            cbxCanton.addItem("SAN PEDRO DE HUACA");
            cbxCanton.addItem("TULCÁN");
        } else if (cbxProvincia.getSelectedIndex() == 5) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("ALAUSÍ");
            cbxCanton.addItem("CHAMBO");
            cbxCanton.addItem("CHUNCHI");
            cbxCanton.addItem("COLTA");
            cbxCanton.addItem("CUMANDÁ");
            cbxCanton.addItem("GUAMOTE");
            cbxCanton.addItem("GUANO");
            cbxCanton.addItem("PALLATANGA");
            cbxCanton.addItem("PENIPE");
            cbxCanton.addItem("RIOBAMBA");
        } else if (cbxProvincia.getSelectedIndex() == 6) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("LA MANÁ");
            cbxCanton.addItem("LATACUNGA");
            cbxCanton.addItem("PANGUA");
            cbxCanton.addItem("PUJILÍ");
            cbxCanton.addItem("SALCEDO");
            cbxCanton.addItem("SAQUISILÍ");
            cbxCanton.addItem("SIGCHOS");

        } else if (cbxProvincia.getSelectedIndex() == 7) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("ARENILLAS");
            cbxCanton.addItem("ATAHUALPA");
            cbxCanton.addItem("BALSAS");
            cbxCanton.addItem("CHILLA");
            cbxCanton.addItem("EL GUABO");
            cbxCanton.addItem("HUAQUILLAS");
            cbxCanton.addItem("LAS LAJAS");
            cbxCanton.addItem("MACHALA");
            cbxCanton.addItem("MARCABELÍ");
            cbxCanton.addItem("PASAJE");
            cbxCanton.addItem("PIÑAS");
            cbxCanton.addItem("PORTOVELO");
            cbxCanton.addItem("SANTA ROSA");
            cbxCanton.addItem("ZARUMA");
        } else if (cbxProvincia.getSelectedIndex() == 8) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("ATACAMES");
            cbxCanton.addItem("ELOY ALFARO");
            cbxCanton.addItem("ESMERALDAS");
            cbxCanton.addItem("MUISNE");
            cbxCanton.addItem("QUININDÉ");
            cbxCanton.addItem("RIOVERDE");
            cbxCanton.addItem("SAN LORENZO");
        } else if (cbxProvincia.getSelectedIndex() == 9) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("ISABELA");
            cbxCanton.addItem("SAN CRISTÓBAL");
            cbxCanton.addItem("SANTA CRUZ");
        } else if (cbxProvincia.getSelectedIndex() == 10) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("ALFREDO BAQUERIZO MORENO");
            cbxCanton.addItem("BALAO");
            cbxCanton.addItem("BALZAR");
            cbxCanton.addItem("COLIMES");
            cbxCanton.addItem("DAULE");
            cbxCanton.addItem("EL EMPALME");
            cbxCanton.addItem("EL TRIUNFO");
            cbxCanton.addItem("DURÁN");
            cbxCanton.addItem("GENERAL ANTONIO ELIZALDE");
            cbxCanton.addItem("PLAYAS");
            cbxCanton.addItem("GUAYAQUIL");
            cbxCanton.addItem("ISIDRO AYORA");
            cbxCanton.addItem("LOMAS DE SARGENTILLO");
            cbxCanton.addItem("MARCELINO MARIDUEÑA");
            cbxCanton.addItem("MILAGRO");
            cbxCanton.addItem("NARANJAL");
            cbxCanton.addItem("NARANJITO");
            cbxCanton.addItem("NOBOL");
            cbxCanton.addItem("PALESTINA");
            cbxCanton.addItem("PEDRO CARBO");
            cbxCanton.addItem("SALITRE");
            cbxCanton.addItem("SAMBORONDÓN");
            cbxCanton.addItem("SANTA LUCÍA");
            cbxCanton.addItem("SIMÓN BOLÍVAR");
            cbxCanton.addItem("YAGUACHI");
        } else if (cbxProvincia.getSelectedIndex() == 11) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("ANTONIO ANTE");
            cbxCanton.addItem("COTACACHI");
            cbxCanton.addItem("IBARRA");
            cbxCanton.addItem("OTAVALO");
            cbxCanton.addItem("PIMAMPIRO");
            cbxCanton.addItem("SAN MIGUEL DE URCUQUÍ");
        } else if (cbxProvincia.getSelectedIndex() == 12) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("CALVAS");
            cbxCanton.addItem("CATAMAYO");
            cbxCanton.addItem("CELICA");
            cbxCanton.addItem("CHAGUARPAMBA");
            cbxCanton.addItem("ESPÍNDOLA");
            cbxCanton.addItem("GONZANAMÁ");
            cbxCanton.addItem("LOJA");
            cbxCanton.addItem("MACARÁ");
            cbxCanton.addItem("OLMEDO");
            cbxCanton.addItem("PALTAS");
            cbxCanton.addItem("PINDAL");
            cbxCanton.addItem("PUYANGO");
            cbxCanton.addItem("QUILANGA");
            cbxCanton.addItem("SARAGURO");
            cbxCanton.addItem("SOZORANGA");
        } else if (cbxProvincia.getSelectedIndex() == 13) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("BABA");
            cbxCanton.addItem("BABAHOYO");
            cbxCanton.addItem("BUENA FE");
            cbxCanton.addItem("MOCACHE");
            cbxCanton.addItem("MONTALVO");
            cbxCanton.addItem("PALENQUE");
            cbxCanton.addItem("PUEBLOVIEJO");
            cbxCanton.addItem("QUEVEDO");
            cbxCanton.addItem("QUINSALOMA");
            cbxCanton.addItem("URDANETA");
            cbxCanton.addItem("VALENCIA");
            cbxCanton.addItem("VENTANAS");
            cbxCanton.addItem("VINCES");
        } else if (cbxProvincia.getSelectedIndex() == 14) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("BABA");
            cbxCanton.addItem("BABAHOYO");
            cbxCanton.addItem("BUENA FE");
            cbxCanton.addItem("MOCACHE");
            cbxCanton.addItem("MONTALVO");
            cbxCanton.addItem("PALENQUE");
            cbxCanton.addItem("PUEBLOVIEJO");
            cbxCanton.addItem("QUEVEDO");
            cbxCanton.addItem("QUINSALOMA");
            cbxCanton.addItem("URDANETA");
            cbxCanton.addItem("VALENCIA");
            cbxCanton.addItem("VENTANAS");
            cbxCanton.addItem("VINCES");
        } else if (cbxProvincia.getSelectedIndex() == 15) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("BOLÍVAR");
            cbxCanton.addItem("CHONE");
            cbxCanton.addItem("EL CARMEN");
            cbxCanton.addItem("FLAVIO ALFARO");
            cbxCanton.addItem("JAMA");
            cbxCanton.addItem("JARAMIJÓ");
            cbxCanton.addItem("JIPIJAPA");
            cbxCanton.addItem("JUNÍN");
            cbxCanton.addItem("MANTA");
            cbxCanton.addItem("MONTECRISTI");
            cbxCanton.addItem("OLMEDO");
            cbxCanton.addItem("PAJÁN");
            cbxCanton.addItem("PEDERNALES");
            cbxCanton.addItem("PICHINCHA");
            cbxCanton.addItem("PORTOVIEJO");
            cbxCanton.addItem("PUERTO LÓPEZ");
            cbxCanton.addItem("ROCAFUERTE");
            cbxCanton.addItem("SAN VICENTE");
            cbxCanton.addItem("SANTA ANA");
            cbxCanton.addItem("SUCRE");
            cbxCanton.addItem("TOSAGUA");
            cbxCanton.addItem("VEINTICUATRO DE MAYO");
        } else if (cbxProvincia.getSelectedIndex() == 16) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("ARCHIDONA");
            cbxCanton.addItem("CARLOS JULIO AROSEMENA TOLA");
            cbxCanton.addItem("EL CHACO");
            cbxCanton.addItem("QUIJOS");
            cbxCanton.addItem("TENA");
        } else if (cbxProvincia.getSelectedIndex() == 17) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("AGUARICO");
            cbxCanton.addItem("ORELLANA");
            cbxCanton.addItem("LA JOYA DE LOS SACHAS");
            cbxCanton.addItem("LORETO");
        } else if (cbxProvincia.getSelectedIndex() == 18) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("ARAJUNO");
            cbxCanton.addItem("MERA");
            cbxCanton.addItem("PASTAZA");
            cbxCanton.addItem("SANTA CLARA");
        } else if (cbxProvincia.getSelectedIndex() == 19) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("QUITO");
            cbxCanton.addItem("CAYAMBE");
            cbxCanton.addItem("MEJÍA");
            cbxCanton.addItem("PEDRO MONCAYO");
            cbxCanton.addItem("PEDRO VICENTE MALDONADO");
            cbxCanton.addItem("PUERTO QUITO");
            cbxCanton.addItem("RUMIÑAHUI");
            cbxCanton.addItem("SAN MIGUEL DE LOS BANCOS");
        } else if (cbxProvincia.getSelectedIndex() == 20) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("LA LIBERTAD");
            cbxCanton.addItem("SALINAS");
            cbxCanton.addItem("SANTA ELENA");
        } else if (cbxProvincia.getSelectedIndex() == 21) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("SANTO DOMINGO");
            cbxCanton.addItem("LA CONCORDIA");
        } else if (cbxProvincia.getSelectedIndex() == 22) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("CASCALES");
            cbxCanton.addItem("CUYABENO");
            cbxCanton.addItem("GONZALO PIZARRO");
            cbxCanton.addItem("LAGO AGRIO");
            cbxCanton.addItem("PUTUMAYO");
            cbxCanton.addItem("SHUSHUFINDI");
            cbxCanton.addItem("SUCUMBÍOS");
        } else if (cbxProvincia.getSelectedIndex() == 23) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("AMBATO");
            cbxCanton.addItem("BAÑOS");
            cbxCanton.addItem("CEVALLOS");
            cbxCanton.addItem("MOCHA");
            cbxCanton.addItem("PATATE");
            cbxCanton.addItem("PELILEO");
            cbxCanton.addItem("QUERO");
            cbxCanton.addItem("SANTIAGO DE PÍLLARO");
            cbxCanton.addItem("TISALEO");
        } else if (cbxProvincia.getSelectedIndex() == 24) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("CENTINELA DEL CÓNDOR");
            cbxCanton.addItem("CHINCHIPE");
            cbxCanton.addItem("EL PANGUI");
            cbxCanton.addItem("NANGARITZA");
            cbxCanton.addItem("PALANDA");
            cbxCanton.addItem("PAQUISHA");
            cbxCanton.addItem("YACUAMBI");
            cbxCanton.addItem("YANTZAZA");
            cbxCanton.addItem("ZAMORA");
        }
    }

    public void botonesInicio() {
        Extranjero.setEnabled(false);
        txtCedulaC.setEnabled(false);
        txtRuc.setEnabled(false);
        cbxTipContribuyente.setEnabled(false);
        cbxGeneroC.setEnabled(false);
        txtNombre.setEnabled(false);
        txtNombre1.setEnabled(false);
        txtApellido1.setEnabled(false);
        txtApellido.setEnabled(false);
        txtFecha.setEnabled(false);
        cbxEstadocivil.setEnabled(false);
        cbxProvincia.setEnabled(false);
        cbxCanton.setEnabled(false);
        txtDireccionC.setEnabled(false);
        txtCelUnoC.setEnabled(false);
        txtTelfUnoC.setEnabled(false);
        txtEmailC.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnCerrarC.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnGuargarC.setEnabled(false);
        btnEditar.setEnabled(false);
    }

    public void botonNuevo() {
        txtCedulaC.requestFocus();
        txtFecha.setEnabled(false);
        lbExtranjero.setVisible(true);
        Extranjero.setEnabled(true);
        txtCedulaC.setEnabled(true);
        cbxTipContribuyente.setEnabled(true);
        cbxGeneroC.setEnabled(true);
        txtRuc.setEnabled(true);
        txtNombre.setEnabled(true);
        txtNombre1.setEnabled(true);
        txtApellido1.setEnabled(true);
        txtApellido.setEnabled(true);
        txtFecha.setEnabled(true);
        cbxEstadocivil.setEnabled(true);
        cbxProvincia.setEnabled(true);
        cbxCanton.setEnabled(true);
        txtDireccionC.setEnabled(true);
        txtCelUnoC.setEnabled(true);
        txtTelfUnoC.setEnabled(true);
        txtEmailC.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnBuscar.setEnabled(true);
        btnCerrarC.setEnabled(true);
        btnGuargarC.setEnabled(true);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnBuscar.setEnabled(false);
    }

    public void inicio() {
        txtCedulaC.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtApellido1.setText("");
        txtNombre1.setText("");
        txtDireccionC.setText("");
        txtCelUnoC.setText("");
        txtTelfUnoC.setText("");
        txtEmailC.setText("");
        txtRuc.setText("");
        cbxProvincia.setSelectedIndex(0);
        cbxCanton.setSelectedIndex(0);
        cbxTipContribuyente.setSelectedIndex(0);
        cbxGeneroC.setSelectedIndex(0);
        cbxEstadocivil.setSelectedIndex(0);
        cbxProvincia.setSelectedIndex(0);
        cbxCanton.setSelectedIndex(0);
        btnNuevo.setEnabled(true);
        btnBuscar.setEnabled(false);
        btnCerrarC.setEnabled(true);
        btnGuargarC.setEnabled(false);
        btnEditar.setEnabled(false);
        Extranjero.setSelected(false);
        k = 0;
    }

    public boolean controlCampos() {
        Calendar fecha1 = new GregorianCalendar();
        String fecha = new SimpleDateFormat("yyyy").format(txtFecha.getDate());
        String fechames = new SimpleDateFormat("MM").format(txtFecha.getDate());
        //fecha nacimiento
        float anio1 = Float.valueOf(fecha);
        float mes1 = Float.valueOf(fechames);
        System.out.println("mes escogido  " + fechames);
        //fecha actual
        float año = fecha1.get(Calendar.YEAR);
        float mes = fecha1.get(Calendar.MONTH);
        System.out.println("mes actual  " + mes);
        // calculo
        float suma = año - anio1;
        System.out.println(suma);

        if (txtCedulaC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cédula no ingresados");
            return false;
        } else if (txtRuc.getText().length() != 13) {
            JOptionPane.showMessageDialog(this, "Ruc no Valida");
            return false;
        } else if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre1 no ingresada");
            return false;
        } else if (txtNombre1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre2 no ingresada");
            return false;
        } else if (txtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Apellido1 no ingresada");
            return false;
        } else if (txtApellido1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Apellido2 no ingresada");
            return false;
        } else if (txtFecha.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Fecha de nacimiento no ingresada");
            return false;
        } else if ((suma < 18 && mes < mes1)) {
            JOptionPane.showMessageDialog(this, "Menor Edad");
            return false;
        } else if (cbxGeneroC.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione genero");
            return false;
        } else if (cbxEstadocivil.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione Estado Civil");
            return false;
        } else if (cbxTipContribuyente.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un Tipo");
            return false;
        } else if (cbxProvincia.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione Provincia");
            return false;
        } else if (cbxCanton.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione Canton");
            return false;
        } else if (txtDireccionC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Direccion no ingresada");
            return false;
        } else if (txtCelUnoC.getText().length() != 10 || txtCelUnoC.getText().charAt(0) != '0' || txtCelUnoC.getText().charAt(1) != '9') {//
            JOptionPane.showMessageDialog(this, "Celular no Valido");
            return false;
        } else if (txtTelfUnoC.getText().length() != 9 || txtTelfUnoC.getText().charAt(0) != '0') {
            JOptionPane.showMessageDialog(this, "Telefono no Valido");
            return false;
        } else if (txtEmailC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Email no ingresado");
            return false;
        }

        return true;
    }

    public void controlactualizar() {
        txtNombre.requestFocus();
        lbExtranjero.setVisible(true);
        Extranjero.setEnabled(true);
        txtCedulaC.setEnabled(false);
        cbxTipContribuyente.setEnabled(true);
        cbxGeneroC.setEnabled(true);
        txtRuc.setEnabled(true);
        txtNombre.setEnabled(true);
        txtNombre1.setEnabled(true);
        txtApellido1.setEnabled(true);
        txtApellido.setEnabled(true);
        txtFecha.setEnabled(true);
        cbxEstadocivil.setEnabled(true);
        cbxProvincia.setEnabled(true);
        cbxCanton.setEnabled(true);
        txtDireccionC.setEnabled(true);
        txtCelUnoC.setEnabled(true);
        txtTelfUnoC.setEnabled(true);
        txtEmailC.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnBuscar.setEnabled(true);
        btnCerrarC.setEnabled(true);
        btnGuargarC.setEnabled(false);
        btnEditar.setEnabled(true);
    }

    //elimine pais,razon,parroquia de la base cliente
    public void guardar() {
        conexion_mysql cx = new conexion_mysql();
        Connection cn = cx.conectar();
        String sql = "insert into clientes(CI_CLI, NOM_CLI, NOM_CLI1, APE_CLI, APE_CLI1, TIPO_CONT_CLI, FEC_NAC_CLI, EST_CIV_CLI, GEN_CLI, PRO_CLI, CANT_CLI, DIR_CLI, CEL1_CLI, TLF1_CLI, E_MAIL_CLI, RUC_CLI,EXT_CLI)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(txtFecha.getDate());
        if (controlCampos()) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, txtCedulaC.getText());
                ps.setString(2, txtNombre.getText());
                ps.setString(3, txtNombre1.getText());
                ps.setString(4, txtApellido.getText());
                ps.setString(5, txtApellido1.getText());
                ps.setString(6, cbxTipContribuyente.getSelectedItem().toString());
                ps.setString(7, fecha);
                ps.setString(8, cbxEstadocivil.getSelectedItem().toString());
                String a = null;
                if (cbxGeneroC.getSelectedItem().toString().equals("MASCULINO")) {
                    a = "M";
                } else {
                    a = "F";
                }
                ps.setString(9, a);
                ps.setString(10, cbxProvincia.getSelectedItem().toString());
                ps.setString(11, cbxCanton.getSelectedItem().toString());
                ps.setString(12, txtDireccionC.getText());
                ps.setString(13, txtCelUnoC.getText());
                ps.setString(14, txtTelfUnoC.getText());
                ps.setString(15, txtEmailC.getText());
                ps.setString(16, txtRuc.getText());
                ps.setString(17, lbExtranjero.getText());
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Guardado Exitoso");
                    botonesInicio();
                    inicio();
                    btnBuscar.setEnabled(true);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public void buscarCliente(String cedula) throws ParseException {
        conexion_mysql cn = new conexion_mysql();
        Connection cc = cn.conectar();
        // CARGAR FECHA EN JCALENDAR 
        Date fechaS = null;
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "";
        sql = "select CI_CLI, NOM_CLI, NOM_CLI1, APE_CLI, APE_CLI1, TIPO_CONT_CLI, FEC_NAC_CLI, EST_CIV_CLI, GEN_CLI, PRO_CLI, CANT_CLI, DIR_CLI, CEL1_CLI, TLF1_CLI, E_MAIL_CLI, RUC_CLI,EXT_CLI from clientes where ci_cli='" + cedula + "'";
        Statement ps;
        try {
            ps = cc.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                txtNombre.setText(rs.getString("nom_cli"));
                txtNombre1.setText(rs.getString("nom_cli1"));
                txtApellido.setText(rs.getString("ape_cli"));
                txtApellido1.setText(rs.getString("ape_cli1"));
                cbxTipContribuyente.setSelectedItem(rs.getString("TIPO_CONT_CLI"));
                fechaS = formatoDeFecha.parse(rs.getString("FEC_NAC_CLI"));
                txtFecha.setDate(fechaS);
                cbxEstadocivil.setSelectedItem(rs.getString("EST_CIV_CLI"));
                if (rs.getString("GEN_CLI").equals("M")) {
                    cbxGeneroC.setSelectedItem("MASCULINO");
                } else {
                    cbxGeneroC.setSelectedItem("FEMENINO");
                }
                cbxProvincia.setSelectedItem(rs.getString("PRO_CLI"));
                cbxCanton.setSelectedItem(rs.getString("CANT_CLI"));
                txtDireccionC.setText(rs.getString("DIR_CLI"));
                txtCelUnoC.setText(rs.getString("CEL1_CLI"));
                txtTelfUnoC.setText(rs.getString("TLF1_CLI"));
                txtEmailC.setText(rs.getString("E_MAIL_CLI"));
                lbExtranjero.setText(rs.getString("EXT_CLI"));
                txtRuc.setText(rs.getString("RUC_CLI"));
            }
            controlactualizar();
        } catch (SQLException ex) {
            Logger.getLogger(FacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtCedulaC.requestFocus();

    }

    public void editar() {
        if (controlCampos()) {
            conexion_mysql cn = new conexion_mysql();
            Connection cc = cn.conectar();
            String fecha = new SimpleDateFormat("yyyy-MM-dd").format(txtFecha.getDate());
            String a = null;
            if (cbxGeneroC.getSelectedItem().toString().equals("MASCULINO")) {
                a = ("M");
            } else {
                a = ("F");
            }
            System.out.println(a);
            String sql = "";
            sql = "update clientes set NOM_CLI ='" + txtNombre.getText() + "',"
                    + "NOM_CLI1 ='" + txtNombre1.getText() + "',"
                    + "APE_CLI ='" + txtApellido.getText() + "',"
                    + "APE_CLI1 ='" + txtApellido1.getText() + "',"
                    + "TIPO_CONT_CLI ='" + cbxTipContribuyente.getSelectedItem() + "',"
                    + "FEC_NAC_CLI ='" + fecha + "',"
                    + "EST_CIV_CLI ='" + cbxEstadocivil.getSelectedItem().toString() + "',"
                    + "GEN_CLI ='" + a + "',"
                    + "PRO_CLI ='" + cbxProvincia.getSelectedItem().toString() + "',"
                    + "CANT_CLI ='" + cbxCanton.getSelectedItem().toString() + "',"
                    + "DIR_CLI ='" + txtDireccionC.getText() + "',"
                    + "CEL1_CLI ='" + txtCelUnoC.getText() + "',"
                    + "TLF1_CLI ='" + txtTelfUnoC.getText() + "',"
                    + "E_MAIL_CLI ='" + txtEmailC.getText() + "',"
                    + "RUC_CLI ='" + txtRuc.getText() + "',"
                    + "EXT_CLI ='" + lbExtranjero.getText() + "' where CI_CLI ='" + txtCedulaC.getText() + "'";

            try {
                PreparedStatement psd = cc.prepareStatement(sql);
                int n = psd.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Se actualizo Correctamente");
                    inicio();
                    botonesInicio();

                }

            } catch (SQLException ex) {
                Logger.getLogger(FacturaVenta.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cbxTipContribuyente = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxGeneroC = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxEstadocivil = new javax.swing.JComboBox<String>();
        jbpasaporte = new javax.swing.JLabel();
        txtCedulaC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNombre1 = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbxProvincia = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        cbxCanton = new javax.swing.JComboBox<String>();
        txtDireccionC = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtCelUnoC = new javax.swing.JTextField();
        txtTelfUnoC = new javax.swing.JTextField();
        txtEmailC = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnGuargarC = new javax.swing.JButton();
        btnCerrarC = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        Extranjero = new javax.swing.JCheckBox();
        lbExtranjero = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbxTipContribuyente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxTipContribuyente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONE CONTRIBUYENTE:" }));
        cbxTipContribuyente.setToolTipText("Seleccione uno ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tipo Contribuyente:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Género:");

        cbxGeneroC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxGeneroC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE GENERO:" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Fecha de Nacimiento");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Estado Civil :");

        cbxEstadocivil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxEstadocivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ESTADO CIVIL:" }));

        jbpasaporte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbpasaporte.setText("Cédula:");

        txtCedulaC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaCKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nombre1:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Nombre2 :");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Apellido1:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Apellido2:");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombre1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre1KeyTyped(evt);
            }
        });

        txtApellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellido1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellido1KeyTyped(evt);
            }
        });

        txtFecha.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Ruc: ");

        txtRuc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRucFocusLost(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRucKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbpasaporte)
                            .addComponent(jLabel9))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedulaC, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxGeneroC, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTipContribuyente, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel12)
                            .addComponent(jLabel22))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(26, 26, 26)
                        .addComponent(cbxEstadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbpasaporte)
                    .addComponent(txtCedulaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxGeneroC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbxEstadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxTipContribuyente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Provincia:");

        cbxProvincia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONE PROVINCIA:" }));
        cbxProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProvinciaItemStateChanged(evt);
            }
        });
        cbxProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProvinciaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Cantón :");

        cbxCanton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxCanton.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECCIONE CANTON:" }));

        txtDireccionC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionCFocusLost(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Dirección :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel10))
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxCanton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDireccionC))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cbxCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Celular:");

        txtCelUnoC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelUnoCKeyTyped(evt);
            }
        });

        txtTelfUnoC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelfUnoCKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("E-mail:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Teléfono:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20))
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCelUnoC, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelfUnoC, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtEmailC))
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtCelUnoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTelfUnoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtEmailC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("CLIENTE");

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

        btnEditar.setBackground(new java.awt.Color(51, 204, 255));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ACTUALIZAR1.png"))); // NOI18N
        btnEditar.setText("Actualizar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(51, 204, 255));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnGuargarC.setBackground(new java.awt.Color(51, 204, 255));
        btnGuargarC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuargarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuargarC.setText("Guardar");
        btnGuargarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuargarCActionPerformed(evt);
            }
        });

        btnCerrarC.setBackground(new java.awt.Color(51, 204, 255));
        btnCerrarC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCerrarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnCerrarC.setText("Salir");
        btnCerrarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnGuargarC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCerrarC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuargarC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnCerrarC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addGap(63, 63, 63))
        );

        Extranjero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Extranjero.setText("Extranjero");
        Extranjero.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ExtranjeroStateChanged(evt);
            }
        });
        Extranjero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExtranjeroActionPerformed(evt);
            }
        });

        lbExtranjero.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(Extranjero)
                .addGap(35, 35, 35)
                .addComponent(lbExtranjero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(158, 158, 158))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Extranjero)
                            .addComponent(lbExtranjero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProvinciaItemStateChanged
        cantones();
    }//GEN-LAST:event_cbxProvinciaItemStateChanged

    private void cbxProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProvinciaActionPerformed

    private void btnCerrarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarCActionPerformed

    private void txtCedulaCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaCKeyTyped
        if (Extranjero.isSelected() == false) {
            soloNumeros(evt);
            if (txtCedulaC.getText().length() > 9) {
                evt.consume();
            }
        } else {
            if (txtCedulaC.getText().length() > 19) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtCedulaCKeyTyped

    private void txtCelUnoCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelUnoCKeyTyped
        soloNumeros(evt);
        if (txtCelUnoC.getText().length() > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelUnoCKeyTyped

    private void txtTelfUnoCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelfUnoCKeyTyped
        soloNumeros(evt);
        if (txtTelfUnoC.getText().length() > 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelfUnoCKeyTyped

    private void txtDireccionCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionCFocusLost
        mayusculas(txtDireccionC);
    }//GEN-LAST:event_txtDireccionCFocusLost

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        botonNuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        consultaCliente cn = new consultaCliente(this, rootPaneCheckingEnabled, txtCedulaC.getText().trim());
        cn.show();
        txtCedulaC.setText(cn.cedula);
        try {
            buscarCliente(txtCedulaC.getText());
            botonesInicio();
            btnEditar.setEnabled(true);
            btnCancelar.setEnabled(true);
            btnBuscar.setEnabled(false);
        } catch (ParseException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        soloLetras(evt);
        if (txtNombre.getText().length() > 19) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        soloLetras(evt);
        if (txtApellido.getText().length() > 19) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtNombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyTyped
        soloLetras(evt);
        if (txtNombre1.getText().length() > 19) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombre1KeyTyped

    private void txtApellido1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido1KeyTyped
        soloLetras(evt);
        if (txtApellido1.getText().length() > 19) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellido1KeyTyped

    private void btnGuargarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuargarCActionPerformed
        if (controlCampos()) {
            if (!Extranjero.isSelected()) {
                if (!verficacion_cedula_ec.verificaCedula(txtCedulaC.getText())) {
                    JOptionPane.showMessageDialog(this, "Cèdula no Valida");
                } else {
                    guardar();
                }
            } else {
                guardar();
            }
        }
    }//GEN-LAST:event_btnGuargarCActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        mayusculas(txtNombre);        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
        mayusculas(txtApellido);
    }//GEN-LAST:event_txtApellidoKeyReleased

    private void txtNombre1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyReleased
        mayusculas(txtNombre1);
    }//GEN-LAST:event_txtNombre1KeyReleased

    private void txtApellido1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido1KeyReleased
        mayusculas(txtApellido1);
    }//GEN-LAST:event_txtApellido1KeyReleased

    private void txtRucFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRucFocusLost
    }//GEN-LAST:event_txtRucFocusLost

    private void txtRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucKeyReleased

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        soloNumeros(evt);
        if (txtRuc.getText().length() > 12) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRucKeyTyped
    int k = 0;
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        k++;
        if (k == 2) {
            editar();
            botonesInicio();
            btnGuargarC.setEnabled(false);
        } else {
            botonNuevo();
            txtCedulaC.setEnabled(false);
            btnEditar.setEnabled(true);
            btnGuargarC.setEnabled(false);
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void ExtranjeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtranjeroActionPerformed
        if (Extranjero.isSelected()) {
            lbExtranjero.setText("Extranjero");
            lbExtranjero.setVisible(true);
        } else {
            lbExtranjero.setText("Ecuatoriano");
            lbExtranjero.setVisible(true);
        }
    }//GEN-LAST:event_ExtranjeroActionPerformed

    private void ExtranjeroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ExtranjeroStateChanged
        if (Extranjero.isSelected()) {
            jbpasaporte.setText("Id Pass:");
        } else {
            jbpasaporte.setText("Cedula:");
        }
    }//GEN-LAST:event_ExtranjeroStateChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        botonesInicio();
        inicio();
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Extranjero;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarC;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuargarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbxCanton;
    private javax.swing.JComboBox<String> cbxEstadocivil;
    private javax.swing.JComboBox<String> cbxGeneroC;
    private javax.swing.JComboBox<String> cbxProvincia;
    private javax.swing.JComboBox<String> cbxTipContribuyente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jbpasaporte;
    private javax.swing.JLabel lbExtranjero;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtCedulaC;
    private javax.swing.JTextField txtCelUnoC;
    private javax.swing.JTextField txtDireccionC;
    private javax.swing.JTextField txtEmailC;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelfUnoC;
    // End of variables declaration//GEN-END:variables
}
