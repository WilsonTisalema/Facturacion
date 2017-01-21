/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.facturacion;

import javax.swing.JOptionPane;
/**
 *
 * @author Cristty
 */
public class Proveedores extends javax.swing.JFrame {

    /**
     * s
     * Creates new form Proveedores
     */
    public Proveedores() {
        initComponents();
        TipoContriyentes();
        ProvinciasEc();

    }

    public void guardar(){
        if(!controles()){
            
        }
    }
    public boolean controles(){
        boolean error=false;
        
        return error;
    }
    public void TipoContriyentes() {
        cbxTipoCont.removeAllItems();
        cbxTipoCont.addItem("SELECCIONE UNO");
        cbxTipoCont.addItem("PERSOAN NATURAL");
        cbxTipoCont.addItem("PERSONA JURÍDICA ");
        cbxTipoCont.addItem("SOCIEDAD");
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

        String aux = txtRzon.getText();
        txtRzon.setText("");
        if (!aux.isEmpty()) {
            aux = aux.substring(0, aux.length() - 1);
        }
        aux += String.valueOf(c).toUpperCase();
        txtRzon.setText(aux);
    }

    public void mayusclasRazonSocial(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        String aux = txtRazonSo.getText();
        txtRazonSo.setText("");
        if (!aux.isEmpty()) {
            aux = aux.substring(0, aux.length() - 1);
        }
        aux += String.valueOf(c).toUpperCase();
        txtRazonSo.setText(aux);
    }

    public void ProvinciasEc() {
        cbxProv.removeAllItems();
        cbxProv.addItem("SELECCIONE UNO");
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
            cbxCan.addItem("SELECCIONE UNO");
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
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("CALUMA");
            cbxCan.addItem("CHILLANES");
            cbxCan.addItem("CHIMBO");
            cbxCan.addItem("ECHEANDÍA");
            cbxCan.addItem("GUARANDA");
            cbxCan.addItem("LAS NAVES");
            cbxCan.addItem("SAN MIGUEL");
        } else if (cbxProv.getSelectedIndex() == 3) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("AZOGUES");
            cbxCan.addItem("BIBLIÁN");
            cbxCan.addItem("CAÑAR");
            cbxCan.addItem("DÉLEG");
            cbxCan.addItem("EL TAMBO");
            cbxCan.addItem("LA TRONCAL ");
            cbxCan.addItem("SUSCAL");
        } else if (cbxProv.getSelectedIndex() == 4) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("BOLÍVAR");
            cbxCan.addItem("ESPEJO");
            cbxCan.addItem("MIRA");
            cbxCan.addItem("MONTÚFAR");
            cbxCan.addItem("SAN PEDRO DE HUACA");
            cbxCan.addItem("TULCÁN");
        } else if (cbxProv.getSelectedIndex() == 5) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
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
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("LA MANÁ");
            cbxCan.addItem("LATACUNGA");
            cbxCan.addItem("PANGUA");
            cbxCan.addItem("PUJILÍ");
            cbxCan.addItem("SALCEDO");
            cbxCan.addItem("SAQUISILÍ");
            cbxCan.addItem("SIGCHOS");

        } else if (cbxProv.getSelectedIndex() == 7) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
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
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("ATACAMES");
            cbxCan.addItem("ELOY ALFARO");
            cbxCan.addItem("ESMERALDAS");
            cbxCan.addItem("MUISNE");
            cbxCan.addItem("QUININDÉ");
            cbxCan.addItem("RIOVERDE");
            cbxCan.addItem("SAN LORENZO");
        } else if (cbxProv.getSelectedIndex() == 9) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("ISABELA");
            cbxCan.addItem("SAN CRISTÓBAL");
            cbxCan.addItem("SANTA CRUZ");
        } else if (cbxProv.getSelectedIndex() == 10) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
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
            cbxCan.addItem("SELECCIONE UNO");
            cbxCan.addItem("ANTONIO ANTE");
            cbxCan.addItem("COTACACHI");
            cbxCan.addItem("IBARRA");
            cbxCan.addItem("OTAVALO");
            cbxCan.addItem("PIMAMPIRO");
            cbxCan.addItem("SAN MIGUEL DE URCUQUÍ");
        } else if (cbxProv.getSelectedIndex() == 12) {
            cbxCan.removeAllItems();
            cbxCan.addItem("SELECCIONE UNO");
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
            cbxCan.addItem("SELECCIONE UNO");
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
            cbxCan.addItem("SELECCIONE UNO");
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
            cbxCan.addItem("SELECCIONE UNO");
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

    public void sacarCodigo() {
        if (txtCodEmpresa.getText().length() == 12) {
            txtCodEmpresa.setEnabled(false);
            txtCodEmpresa.setText(txtCodEmpresa.getText().substring(1, 6));
                txtCodEmpresa.setEnabled(false);
        } else {
            if (txtCodEmpresa.getText().length() == 13) {
                txtCodEmpresa.setText(txtCodEmpresa.getText().substring(2, 7));
                txtCodEmpresa.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese con pistola de codigo de barras");
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

        jPanel6 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCed = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRUC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxTipoCont = new javax.swing.JComboBox<String>();
        jLabel4 = new javax.swing.JLabel();
        txtRazonSo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCodEmpresa = new javax.swing.JTextField();
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
        jLabel13 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtRzon = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtDir = new javax.swing.JTextField();
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

        jLabel1.setText("Cédula*:");

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

        jLabel3.setText("Tipo Contribuyente:");

        cbxTipoCont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Razón Social:");

        txtRazonSo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRazonSoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSoKeyTyped(evt);
            }
        });

        jLabel7.setText("Codigo Empresa:");

        txtCodEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodEmpresaActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addComponent(txtCed, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodEmpresa)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTipoCont, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtRazonSo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbxTipoCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRazonSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCodEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(419, 419, 419))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setText("Provincia:");

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

        jLabel6.setText("Cantón:");

        jLabel9.setText("Celular:");

        txtTelfComve.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelfComveKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelfComveKeyTyped(evt);
            }
        });

        jLabel10.setText("Teléfono:");

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

        jLabel12.setText("E-mail:");

        jLabel13.setText("Direccion:");

        txtRzon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRzonKeyTyped(evt);
            }
        });

        jLabel14.setText("Forma Pago:");

        txtDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirActionPerformed(evt);
            }
        });
        txtDir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDirKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxProv, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelfCelu, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
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
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(288, 288, 288))))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel15.setText("Rept legal:");

        txtReLe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReLeKeyTyped(evt);
            }
        });

        jLabel16.setText("Extensión1:");

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
                .addGap(40, 40, 40)
                .addComponent(txtReLe, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(txtExt1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtReLe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtExt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
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
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
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

    private void txtRazonSoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSoKeyReleased
        // TODO add your handling code here:
        mayusclasRazonSocial(evt);
    }//GEN-LAST:event_txtRazonSoKeyReleased

    private void txtDirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirKeyReleased
        // TODO add your handling code here:
        mayusclasComen(evt);
    }//GEN-LAST:event_txtDirKeyReleased

    private void txtDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDirActionPerformed

    private void txtTelfComveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelfComveKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
    }//GEN-LAST:event_txtTelfComveKeyTyped

    private void txtRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUCKeyTyped
        soloNumeros(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_txtRUCKeyTyped

    private void txtRzonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRzonKeyTyped
        // TODO add your handling code here:
        soloLetras(evt);
    }//GEN-LAST:event_txtRzonKeyTyped

    private void txtRazonSoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSoKeyTyped
        // TODO add your handling code here:
        soloLetras(evt);
    }//GEN-LAST:event_txtRazonSoKeyTyped

    private void txtReLeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReLeKeyTyped
        // TODO add your handling code here:
        soloLetras(evt);
    }//GEN-LAST:event_txtReLeKeyTyped

    private void txtExt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExt1KeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
    }//GEN-LAST:event_txtExt1KeyTyped

    private void txtCedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
    }//GEN-LAST:event_txtCedKeyTyped

    private void txtTelfCeluKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelfCeluKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);

    }//GEN-LAST:event_txtTelfCeluKeyTyped

    private void txtTelfCeluFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelfCeluFocusLost
        // TODO add your handling code here:
        contTelCel();
    }//GEN-LAST:event_txtTelfCeluFocusLost

    private void txtDirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirKeyTyped
        // TODO add your handling code here:
        soloLetras(evt);
    }//GEN-LAST:event_txtDirKeyTyped

    private void txtTelfComveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelfComveKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelfComveKeyReleased

    private void txtCodEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodEmpresaActionPerformed
        // TODO add your handling code here:
        sacarCodigo();
    }//GEN-LAST:event_txtCodEmpresaActionPerformed

    private void jbtNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNuevoActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jbtNuevoActionPerformed

    private void jbtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGuardarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jbtGuardarActionPerformed

    private void jbtActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtActualizarActionPerformed
        // TODO add your handling code here:

    
    }//GEN-LAST:event_jbtActualizarActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jbtSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbtSalirActionPerformed

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
    private javax.swing.JComboBox<String> cbxCan;
    private javax.swing.JComboBox<String> cbxProv;
    private javax.swing.JComboBox<String> cbxTipoCont;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JTextField txtCed;
    private javax.swing.JTextField txtCodEmpresa;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtExt1;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtRazonSo;
    private javax.swing.JTextField txtReLe;
    private javax.swing.JTextField txtRzon;
    private javax.swing.JTextField txtTelfCelu;
    private javax.swing.JTextField txtTelfComve;
    // End of variables declaration//GEN-END:variables
}
