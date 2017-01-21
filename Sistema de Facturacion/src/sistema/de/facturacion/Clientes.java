/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.facturacion;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Juank
 */
public class Clientes extends javax.swing.JFrame {

    /**
     * Creates new form Clientes
     */
    public Clientes() {
        initComponents();
        tipoContri();
        genero();
        estadoCivil();
        provincias();
        jDateChooser1.setEnabled(false);
        cbxCanton.removeAllItems();
        botonesInicio();
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
        cbxTipContribuyente.addItem("PERSOAN NATURAL");
        cbxTipContribuyente.addItem("PERSONA JURÍDICA ");
        cbxTipContribuyente.addItem("SOCIEDAD");
    }
    
    public void genero() {
        cbxGeneroC.removeAllItems();
        cbxGeneroC.addItem("SELECCIONE UNO");
        cbxGeneroC.addItem("FEMENINO");
        cbxGeneroC.addItem("MASCULINO");
        cbxGeneroC.addItem("NO DEFINIDO");
        cbxGeneroC.setToolTipText("SELECCIONE UNO");
    }
    
    public void estadoCivil() {
        cbxEstadocivil.removeAllItems();
        cbxEstadocivil.addItem("SELECCIONE UNO");
        cbxEstadocivil.addItem("SOLTERO(A)");
        cbxEstadocivil.addItem("CASADO(A)");
        cbxEstadocivil.addItem("DIVORCIADO(A)");
        cbxEstadocivil.addItem("VIUDO(A)");
        cbxEstadocivil.addItem("UNIÓN LIBRE");
        cbxEstadocivil.setToolTipText("SELECCIONE UNO");
        
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
        cbxProvincia.setToolTipText("SELECCIONE UNO");
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
        txtCedulaC.setEnabled(false);
        txtRuc.setEnabled(false);
        cbxTipContribuyente.setEnabled(false);
        cbxGeneroC.setEnabled(false);
        txtNombre.setEnabled(false);
        txtNombre1.setEnabled(false);
        txtApellido1.setEnabled(false);
        txtApellido.setEnabled(false);
        jDateChooser1.setEnabled(false);
        cbxEstadocivil.setEnabled(false);
        cbxProvincia.setEnabled(false);
        cbxCanton.setEnabled(false);
        txtDireccionC.setEnabled(false);
        txtCelUnoC.setEnabled(false);
        txtCelDosC.setEnabled(false);
        txtTelfUnoC.setEnabled(false);
        txtTelDosC.setEnabled(false);
        txtEmailC.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnCerrarC.setEnabled(true);
        btnGuargarC.setEnabled(false);
        btnEditar.setEnabled(false);
    }
    
    public void botonNuevo() {
        txtCedulaC.requestFocus();
        txtCedulaC.setEnabled(true);
        cbxTipContribuyente.setEnabled(true);
        cbxGeneroC.setEnabled(true);
        txtRuc.setEnabled(true);
        txtNombre.setEnabled(true);
        txtNombre1.setEnabled(true);
        txtApellido1.setEnabled(true);
        txtApellido.setEnabled(true);
        jDateChooser1.setEnabled(true);
        cbxEstadocivil.setEnabled(true);
        cbxProvincia.setEnabled(true);
        cbxCanton.setEnabled(true);
        txtDireccionC.setEnabled(true);
        txtCelUnoC.setEnabled(true);
        txtCelDosC.setEnabled(true);
        txtTelfUnoC.setEnabled(true);
        txtTelDosC.setEnabled(true);
        txtEmailC.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnBorrar.setEnabled(true);
        btnCerrarC.setEnabled(true);
        btnGuargarC.setEnabled(true);
        btnEditar.setEnabled(false);
    }
    
    public void botonBorara() {
        txtCedulaC.setText("");
        cbxTipContribuyente.setSelectedIndex(0);
        cbxGeneroC.setSelectedIndex(0);
        jDateChooser1.setDate(null);
        cbxEstadocivil.setSelectedIndex(0);
        cbxProvincia.setSelectedIndex(0);
        cbxCanton.setSelectedIndex(0);
        txtDireccionC.setText("");
        txtCelUnoC.setText("");
        txtCelDosC.setText("");
        txtTelfUnoC.setText("");
        txtTelDosC.setText("");
        txtEmailC.setText("");
        btnNuevo.setEnabled(true);
        btnBorrar.setEnabled(false);
        btnCerrarC.setEnabled(true);
        btnGuargarC.setEnabled(false);
        btnEditar.setEnabled(false);
    }
    
    public void controlCampos() {
        if (!verificaCedula(txtCedulaC.getText())) {
            JOptionPane.showMessageDialog(this, "Cèdula no Valida");
        } else if (txtRuc.getText().length() != 13) {
            JOptionPane.showMessageDialog(this, "Ruc no Valida");
        } else if (txtNombre1.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nombre1 no ingresada");
        } else if (txtNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nombre no ingresada");
        } else if (txtApellido.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Apellido no ingresada");
        } else if (txtApellido1.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Apellido1 no ingresada");
        } else if (cbxGeneroC.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione genero");
        } else if (cbxProvincia.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione Provincia");
        } else if (cbxCanton.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione Canton");
        } else if (jDateChooser1.getDate().toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fecha de nacimiento no ingresada");
        } else if (txtDireccionC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Direccion no ingresada");
        } else if (txtCelUnoC.getText().length() != 10 || txtCelUnoC.getText().charAt(0) == '0' || txtCelUnoC.getText().charAt(1) == '9') {
            JOptionPane.showMessageDialog(this, "Celular uno no Valido");
        } else if (txtCelDosC.getText().length() != 10 || txtCelDosC.getText().charAt(0) == '0' || txtCelUnoC.getText().charAt(1) == '9') {
            JOptionPane.showMessageDialog(this, "Celular dos no Valido");
        } else if (txtTelfUnoC.getText().length() != 9 || txtTelfUnoC.getText().charAt(0) == '0' || txtTelfUnoC.getText().charAt(1) == '3' || txtTelfUnoC.getText().charAt(2) == '2') {
            JOptionPane.showMessageDialog(this, "Telefono uno no Valido");
        } else if (txtTelDosC.getText().length() != 9 || txtTelDosC.getText().charAt(0) == '0' || txtTelDosC.getText().charAt(1) == '3' || txtTelDosC.getText().charAt(2) == '2') {
            JOptionPane.showMessageDialog(this, "Telefono dos no Valido");
        } else if (txtEmailC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Email no ingresado");
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
        btnCerrarC = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbxTipContribuyente = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxGeneroC = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxEstadocivil = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        txtCedulaC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNombre1 = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
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
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTelDosC = new javax.swing.JTextField();
        txtCelDosC = new javax.swing.JTextField();
        txtTelfUnoC = new javax.swing.JTextField();
        txtEmailC = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnGuargarC = new javax.swing.JButton();

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

        btnCerrarC.setText("Cerrar");
        btnCerrarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbxTipContribuyente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Contribuyente:" }));
        cbxTipContribuyente.setToolTipText("Seleccione uno ");

        jLabel2.setText("Tipo Contribuyente:");

        jLabel8.setText("Género:");

        cbxGeneroC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione  Genero:" }));

        jLabel4.setText("Fecha de Nacimiento");

        jLabel7.setText("Estado Civil :");

        cbxEstadocivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Esado civil:" }));

        jLabel1.setText("Cédula:");

        txtCedulaC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaCKeyTyped(evt);
            }
        });

        jLabel9.setText("Nombre :");

        jLabel12.setText("Nombre 1 :");

        jLabel14.setText("Apellido:");

        jLabel19.setText("Apellido 1:");

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
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCedulaC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbxTipContribuyente, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtApellido)
                                    .addComponent(cbxGeneroC, 0, 153, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(269, 269, 269)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(32, 32, 32)
                        .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxEstadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbxGeneroC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbxEstadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbxTipContribuyente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Provincia:");

        cbxProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Provincia:" }));
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

        jLabel11.setText("Cantón :");

        cbxCanton.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Canton:" }));

        txtDireccionC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionCFocusLost(evt);
            }
        });

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
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel11)
                        .addGap(30, 30, 30)
                        .addComponent(cbxCanton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDireccionC))
                .addContainerGap(40, Short.MAX_VALUE))
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
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setText("Celular 1:");

        txtCelUnoC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelUnoCKeyTyped(evt);
            }
        });

        jLabel16.setText("Celular 2:");

        jLabel18.setText("Teléfono 2:");

        txtTelDosC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelDosCKeyTyped(evt);
            }
        });

        txtCelDosC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelDosCKeyTyped(evt);
            }
        });

        txtTelfUnoC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelfUnoCKeyTyped(evt);
            }
        });

        jLabel20.setText("E-mail:");

        jLabel17.setText("Teléfono 1:");

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
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCelUnoC)
                            .addComponent(txtTelfUnoC, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 56, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(35, 35, 35))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(26, 26, 26)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCelDosC, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelDosC, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtEmailC))
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(txtCelDosC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelUnoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTelfUnoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtTelDosC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmailC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel21.setText("CLIENTE");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnGuargarC.setText("Guardar");
        btnGuargarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuargarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuargarC, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuargarC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(293, 293, 293))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrarC)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(54, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(btnCerrarC)
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
        soloNumeros(evt);
        if (txtCedulaC.getText().length() > 9) {
            evt.consume();
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

    private void txtCelDosCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelDosCKeyTyped
        soloNumeros(evt);
        if (txtCelUnoC.getText().length() > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelDosCKeyTyped

    private void txtTelDosCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelDosCKeyTyped
        soloNumeros(evt);
        if (txtTelDosC.getText().length() > 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelDosCKeyTyped

    private void txtDireccionCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionCFocusLost
        mayusculas(txtDireccionC);
    }//GEN-LAST:event_txtDireccionCFocusLost

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        botonNuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        botonBorara();
    }//GEN-LAST:event_btnBorrarActionPerformed

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
        controlCampos();
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
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucKeyTyped

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
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCerrarC;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuargarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbxCanton;
    private javax.swing.JComboBox<String> cbxEstadocivil;
    private javax.swing.JComboBox<String> cbxGeneroC;
    private javax.swing.JComboBox<String> cbxProvincia;
    private javax.swing.JComboBox<String> cbxTipContribuyente;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtCedulaC;
    private javax.swing.JTextField txtCelDosC;
    private javax.swing.JTextField txtCelUnoC;
    private javax.swing.JTextField txtDireccionC;
    private javax.swing.JTextField txtEmailC;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelDosC;
    private javax.swing.JTextField txtTelfUnoC;
    // End of variables declaration//GEN-END:variables
}
