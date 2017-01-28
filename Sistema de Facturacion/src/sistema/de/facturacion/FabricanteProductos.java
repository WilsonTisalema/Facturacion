/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.de.facturacion;

import javax.swing.JTextField;

/**
 *
 * @author SystemRD
 */
public class FabricanteProductos extends javax.swing.JFrame {

    /**
     * Creates new form FabricanteProductos
     */
    public FabricanteProductos() {
        initComponents();
        ProvinciasEc();

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
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtEmpresa = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxProv = new javax.swing.JComboBox();
        cbxCan = new javax.swing.JComboBox();
        txtDirecion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtWeb = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Codigo :");

        jLabel2.setText("Empresa:");

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        txtEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmpresaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmpresaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Provincia:");

        jLabel4.setText("Canton:");

        cbxProv.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProvItemStateChanged(evt);
            }
        });

        jLabel7.setText("Dirección:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxProv, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbxCan, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDirecion, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(cbxProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDirecion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("E-mail:");

        jLabel8.setText("Teléfono:");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel9.setText("Web:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                        .addComponent(txtTelefono))
                    .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        soloNumeros(evt);
        if (txtTelefono.getText().length() > 9) {
            evt.consume();
        }

    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:
         soloNumeros(evt);
        if (txtCodigo.getText().length() > 9) {
            evt.consume();
        }
    
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaKeyTyped
        // TODO add your handling code here:
        soloLetras(evt);
        if (txtEmpresa.getText().length() > 40) {
            evt.consume();
        }

    }//GEN-LAST:event_txtEmpresaKeyTyped

    private void cbxProvItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProvItemStateChanged
        // TODO add your handling code here:
        Cantones();
    }//GEN-LAST:event_cbxProvItemStateChanged

    private void txtEmpresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaKeyReleased
        // TODO add your handling code here:
        mayusculas(txtEmpresa);
    }//GEN-LAST:event_txtEmpresaKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoKeyReleased

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
            java.util.logging.Logger.getLogger(FabricanteProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FabricanteProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FabricanteProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FabricanteProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FabricanteProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxCan;
    private javax.swing.JComboBox cbxProv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDirecion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtWeb;
    // End of variables declaration//GEN-END:variables
}
