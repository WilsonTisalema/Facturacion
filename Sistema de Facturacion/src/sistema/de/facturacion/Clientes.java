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
        txtRucC.setEnabled(false);
        cbxTipContribuyente.setEnabled(false);
        cbxGeneroC.setEnabled(false);
        txtNomComC.setEnabled(false);
        txtNombre.setEnabled(false);
        txtNombre1.setEnabled(false);
        txtApellido1.setEnabled(false);
        txtApellido.setEnabled(false);
        txtFecNacC.setEnabled(false);
        cbxEstadocivil.setEnabled(false);
        txtRazonSocialC.setEnabled(false);
        cbxProvincia.setEnabled(false);
        cbxCanton.setEnabled(false);
        txtDireccionC.setEnabled(false);
        txtCelUnoC.setEnabled(false);
        txtCelDosC.setEnabled(false);
        txtTelfUnoC.setEnabled(false);
        txtTelDosC.setEnabled(false);
        txtEmailC.setEnabled(false);
        txtEmprPubliC.setEnabled(false);
        txtConPediC.setEnabled(false);
        txtRecMercC.setEnabled(false);
        txtCuotaGraciaC.setEnabled(false);
        txtContCobC.setEnabled(false);
        txtRecDevoC.setEnabled(false);
        txtFormaPago.setEnabled(false);
        txtLimiteCreditoC.setEnabled(false);
        chkActivoC.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnCerrarC.setEnabled(true);
        btnGuargarC.setEnabled(false);
        btnEditar.setEnabled(false);
    }

    public void botonNuevo() {
        txtCedulaC.requestFocus();
        txtCedulaC.setEnabled(true);
        txtRucC.setEnabled(true);
        cbxTipContribuyente.setEnabled(true);
        cbxGeneroC.setEnabled(true);
        txtNomComC.setEnabled(true);
        txtNombre.setEnabled(true);
        txtNombre1.setEnabled(true);
        txtApellido1.setEnabled(true);
        txtApellido.setEnabled(true);
        txtFecNacC.setEnabled(true);
        cbxEstadocivil.setEnabled(true);
        txtRazonSocialC.setEnabled(true);
        cbxProvincia.setEnabled(true);
        cbxCanton.setEnabled(true);
        txtDireccionC.setEnabled(true);
        txtCelUnoC.setEnabled(true);
        txtCelDosC.setEnabled(true);
        txtTelfUnoC.setEnabled(true);
        txtTelDosC.setEnabled(true);
        txtEmailC.setEnabled(true);
        txtEmprPubliC.setEnabled(true);
        txtConPediC.setEnabled(true);
        txtRecMercC.setEnabled(true);
        txtCuotaGraciaC.setEnabled(true);
        txtContCobC.setEnabled(true);
        txtRecDevoC.setEnabled(true);
        txtFormaPago.setEnabled(true);
        txtLimiteCreditoC.setEnabled(true);
        chkActivoC.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnBorrar.setEnabled(true);
        btnCerrarC.setEnabled(true);
        btnGuargarC.setEnabled(true);
        btnEditar.setEnabled(false);
    }

    public void botonBorara() {

        txtCedulaC.setText("");
        txtRucC.setText("");
        cbxTipContribuyente.setSelectedIndex(0);
        cbxGeneroC.setSelectedIndex(0);
        txtNomComC.setText("");
        txtFecNacC.setText("");
        cbxEstadocivil.setSelectedIndex(0);
        txtRazonSocialC.setText("");
        cbxProvincia.setSelectedIndex(0);
        cbxCanton.setSelectedIndex(0);
        txtDireccionC.setText("");
        txtCelUnoC.setText("");
        txtCelDosC.setText("");
        txtTelfUnoC.setText("");
        txtTelDosC.setText("");
        txtEmailC.setText("");
        txtEmprPubliC.setText("");
        txtConPediC.setText("");
        txtRecMercC.setText("");
        txtCuotaGraciaC.setText("");
        txtContCobC.setText("");
        txtRecDevoC.setText("");
        txtFormaPago.setText("");
        txtLimiteCreditoC.setText("");
        chkActivoC.setSelected(false);
        btnNuevo.setEnabled(true);
        btnBorrar.setEnabled(false);
        btnCerrarC.setEnabled(true);
        btnGuargarC.setEnabled(false);
        btnEditar.setEnabled(false);
    }

    public void controlCampos() {
        if (txtCedulaC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Cèdula no ingresada");
        }
        if (txtRucC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Ruc no ingresado");
        }
        if (txtNombre1.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nombre1 no ingresada");
        }
        if (txtNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nombre no ingresada");
        }
        if (txtApellido.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Apellido no ingresada");
        }
        if (txtApellido1.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Apellido1 no ingresada");
        }
        if (txtNomComC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nombre Comercial no ingresada");
        }
        if(txtNomComC.getText().length()==0){
              JOptionPane.showMessageDialog(this, "Nombre no ingresada");
          }
        if(txtRazonSocialC.getText().length()==0){
              JOptionPane.showMessageDialog(this, "Razon Social no ingresada");
          }
        if(cbxGeneroC.getSelectedIndex()==0){
              JOptionPane.showMessageDialog(this, "Seleccione genero");
          }
        if(cbxProvincia.getSelectedIndex()==0){
              JOptionPane.showMessageDialog(this, "Seleccione Provincia");
          }
         if(cbxCanton.getSelectedIndex()==0){
              JOptionPane.showMessageDialog(this, "Seleccione Canton");
          }
         if (txtFecNacC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Fecha de nacimiento no ingresada");
        }
         if (txtDireccionC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Direccion no ingresada");
        }
         if (txtCelUnoC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Celular uno no ingresado");
        }
          if (txtCelDosC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Celular dos no ingresado");
        }
          if (txtTelfUnoC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Telefono uno no ingresado");
        }
          if (txtTelDosC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Telefono dos no ingresado");
        }
          if (txtEmailC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Email no ingresado");
        }
          if (txtEmprPubliC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Empresa Publica no ingresado");
        }
          if (txtContCobC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Contacto cobro no ingresado");
        }
          if (txtConPediC.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Contacto pedido no ingresado");
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
        btnGuargarC = new javax.swing.JButton();
        btnCerrarC = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbxTipContribuyente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomComC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRazonSocialC = new javax.swing.JTextField();
        txtRucC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxGeneroC = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtFecNacC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxEstadocivil = new javax.swing.JComboBox<>();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbxProvincia = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbxCanton = new javax.swing.JComboBox<>();
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
        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtEmprPubliC = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        chkActivoC = new javax.swing.JCheckBox();
        txtCuotaGraciaC = new javax.swing.JTextField();
        txtRecMercC = new javax.swing.JTextField();
        txtConPediC = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtLimiteCreditoC = new javax.swing.JTextField();
        txtFormaPago = new javax.swing.JTextField();
        txtRecDevoC = new javax.swing.JTextField();
        txtContCobC = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

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

        btnGuargarC.setText("Guardar");
        btnGuargarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuargarCActionPerformed(evt);
            }
        });

        btnCerrarC.setText("Cerrar");
        btnCerrarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbxTipContribuyente.setToolTipText("Seleccione uno ");

        jLabel2.setText("Tipo Contribuyente:");

        jLabel5.setText("Nombre Comercial ");

        txtNomComC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomComCFocusLost(evt);
            }
        });

        jLabel6.setText("Razon Social");

        txtRazonSocialC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRazonSocialCFocusLost(evt);
            }
        });
        txtRazonSocialC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialCKeyTyped(evt);
            }
        });

        txtRucC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucCKeyTyped(evt);
            }
        });

        jLabel3.setText("Ruc:");

        jLabel8.setText("Género:");

        cbxGeneroC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Fecha de Nacimiento");

        jLabel7.setText("Estado Civil :");

        cbxEstadocivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Cédula:");

        txtCedulaC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaCFocusLost(evt);
            }
        });
        txtCedulaC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaCKeyTyped(evt);
            }
        });

        jLabel9.setText("Nombre :");

        jLabel12.setText("Nombre 1 :");

        jLabel14.setText("Apellido:");

        jLabel19.setText("Apellido 1:");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidoFocusLost(evt);
            }
        });
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtNombre1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombre1FocusLost(evt);
            }
        });
        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre1KeyTyped(evt);
            }
        });

        txtApellido1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellido1FocusLost(evt);
            }
        });
        txtApellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellido1KeyTyped(evt);
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
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNomComC, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxGeneroC, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCedulaC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTipContribuyente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12)
                    .addComponent(jLabel19))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxEstadocivil, 0, 144, Short.MAX_VALUE)
                    .addComponent(txtRazonSocialC)
                    .addComponent(txtFecNacC)
                    .addComponent(txtRucC)
                    .addComponent(txtNombre1)
                    .addComponent(txtApellido1))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCedulaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtRucC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel19)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxTipContribuyente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecNacC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(cbxEstadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRazonSocialC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxGeneroC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomComC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Provincia:");

        cbxProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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

        cbxCanton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addComponent(cbxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel11))
                    .addComponent(txtDireccionC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxCanton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addComponent(txtTelDosC, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCelDosC, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtEmailC, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setText("Empresa Publica:");

        jLabel25.setText("Contacto Pedido:");

        jLabel27.setText("Recibe Mercadería:");

        jLabel29.setText("Cuota Gracia:");

        chkActivoC.setText("Activo");

        jLabel26.setText("Contacto Cobro:");

        jLabel28.setText("Recibe Devoluciones:");

        jLabel30.setText("Forma Pago:");

        jLabel32.setText("Límite Crédito ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29)
                    .addComponent(chkActivoC)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtEmprPubliC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConPediC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRecMercC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCuotaGraciaC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel26)
                    .addComponent(jLabel30)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContCobC, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRecDevoC, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLimiteCreditoC, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtContCobC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(txtFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLimiteCreditoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmprPubliC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(jLabel26)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtConPediC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(txtRecDevoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtRecMercC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtCuotaGraciaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkActivoC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuargarC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCerrarC)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo)
                        .addComponent(btnEditar)
                        .addComponent(btnBorrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuargarC)
                        .addComponent(btnCerrarC))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProvinciaItemStateChanged
        // TODO add your handling code here:
        cantones();
    }//GEN-LAST:event_cbxProvinciaItemStateChanged

    private void txtCedulaCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaCFocusLost
        // TODO add your handling code here:
        // comprovacionCedula();
    }//GEN-LAST:event_txtCedulaCFocusLost

    private void cbxProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProvinciaActionPerformed

    private void btnCerrarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarCActionPerformed

    private void txtRucCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucCKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
    }//GEN-LAST:event_txtRucCKeyTyped

    private void txtRazonSocialCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialCKeyTyped
        // TODO add your handling code here:
        soloLetras(evt);
    }//GEN-LAST:event_txtRazonSocialCKeyTyped

    private void txtCedulaCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaCKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
    }//GEN-LAST:event_txtCedulaCKeyTyped

    private void txtCelUnoCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelUnoCKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);

    }//GEN-LAST:event_txtCelUnoCKeyTyped

    private void txtTelfUnoCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelfUnoCKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);

    }//GEN-LAST:event_txtTelfUnoCKeyTyped

    private void txtCelDosCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelDosCKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);

    }//GEN-LAST:event_txtCelDosCKeyTyped

    private void txtTelDosCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelDosCKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);

    }//GEN-LAST:event_txtTelDosCKeyTyped

    private void txtRazonSocialCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRazonSocialCFocusLost
        // TODO add your handling code here:
        mayusculas(txtRazonSocialC);
    }//GEN-LAST:event_txtRazonSocialCFocusLost

    private void txtNomComCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomComCFocusLost
        // TODO add your handling code here:
        mayusculas(txtNomComC);
    }//GEN-LAST:event_txtNomComCFocusLost

    private void txtDireccionCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionCFocusLost
        // TODO add your handling code here:
        mayusculas(txtDireccionC);
    }//GEN-LAST:event_txtDireccionCFocusLost

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        botonNuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        botonBorara();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        // TODO add your handling code here:
        mayusculas(txtNombre);
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusLost
        // TODO add your handling code here:
        mayusculas(txtApellido);
    }//GEN-LAST:event_txtApellidoFocusLost

    private void txtNombre1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombre1FocusLost
        // TODO add your handling code here
        mayusculas(txtNombre1);
    }//GEN-LAST:event_txtNombre1FocusLost

    private void txtApellido1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellido1FocusLost
        // TODO add your handling code here:
        mayusculas(txtApellido1);
    }//GEN-LAST:event_txtApellido1FocusLost

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        soloLetras(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        // TODO add your handling code here:
        soloLetras(evt);
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtNombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyTyped
        // TODO add your handling code here:
        soloLetras(evt);
    }//GEN-LAST:event_txtNombre1KeyTyped

    private void txtApellido1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido1KeyTyped
        // TODO add your handling code here:
        soloLetras(evt);
    }//GEN-LAST:event_txtApellido1KeyTyped

    private void btnGuargarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuargarCActionPerformed
        // TODO add your handling code here:
        controlCampos();
    }//GEN-LAST:event_btnGuargarCActionPerformed

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
    private javax.swing.JCheckBox chkActivoC;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JTextField txtConPediC;
    private javax.swing.JTextField txtContCobC;
    private javax.swing.JTextField txtCuotaGraciaC;
    private javax.swing.JTextField txtDireccionC;
    private javax.swing.JTextField txtEmailC;
    private javax.swing.JTextField txtEmprPubliC;
    private javax.swing.JTextField txtFecNacC;
    private javax.swing.JTextField txtFormaPago;
    private javax.swing.JTextField txtLimiteCreditoC;
    private javax.swing.JTextField txtNomComC;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtRazonSocialC;
    private javax.swing.JTextField txtRecDevoC;
    private javax.swing.JTextField txtRecMercC;
    private javax.swing.JTextField txtRucC;
    private javax.swing.JTextField txtTelDosC;
    private javax.swing.JTextField txtTelfUnoC;
    // End of variables declaration//GEN-END:variables
}
