package Forms;

import org.bson.Document;
import javax.swing.JOptionPane;
import Operaciones.ConexionMongoDB;
import Operaciones.Verifica;

/**
 * @author ROQUEARMANDORAMIREZP
 */
public class FrmPerfNue extends javax.swing.JInternalFrame {

    String CodModif; //si está vacio...significa que registrará nuevos

    /**
     * Creates new form FrmPerfNue
     */
    public FrmPerfNue(String Codigo) {
        this.CodModif = Codigo;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtCor = new javax.swing.JTextField();
        TxtNom = new javax.swing.JTextField();
        TxtApe = new javax.swing.JTextField();
        TxtTel = new javax.swing.JTextField();
        CmdCancelar = new javax.swing.JButton();
        CmdAceptar = new javax.swing.JButton();
        jComboSex = new javax.swing.JComboBox<>();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        TxtCa1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtCa2 = new javax.swing.JTextField();
        TxtRef = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TxtFec = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setTitle("Nueva Ficha");
        setFrameIcon(null);

        jLabel1.setText("Nombres:");

        jLabel2.setText("Apellidos:");

        jLabel3.setText("Teléfono:");

        jLabel4.setText("Sexo:");

        jLabel5.setText("Correo:");

        TxtCor.setToolTipText("");
        TxtCor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCorKeyTyped(evt);
            }
        });

        TxtNom.setToolTipText("");
        TxtNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNomKeyTyped(evt);
            }
        });

        TxtApe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtApeKeyTyped(evt);
            }
        });

        TxtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtTelKeyTyped(evt);
            }
        });

        CmdCancelar.setText("Cancelar");
        CmdCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdCancelarActionPerformed(evt);
            }
        });

        CmdAceptar.setText("Aceptar");
        CmdAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdAceptarActionPerformed(evt);
            }
        });

        jComboSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        jComboSex.setSelectedIndex(-1);
        jComboSex.setToolTipText("");

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dirección:"));

        jLabel7.setText("Calle 1:");

        TxtCa1.setToolTipText("");
        TxtCa1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCa1KeyTyped(evt);
            }
        });

        jLabel8.setText("Calle 2");

        TxtCa2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCa2KeyTyped(evt);
            }
        });

        TxtRef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtRefKeyTyped(evt);
            }
        });

        jLabel9.setText("Referencia:");

        jLayeredPane3.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(TxtCa1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(TxtCa2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(TxtRef, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(TxtRef, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtCa2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtCa1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtCa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtCa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TxtFec.setToolTipText("Ingrese Fecha del Formato: (AAAA-MM-DD)");
        TxtFec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtFecKeyTyped(evt);
            }
        });

        jLabel6.setText("Fecha Nacimiento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboSex, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtTel)
                            .addComponent(TxtApe)
                            .addComponent(TxtNom)
                            .addComponent(TxtFec)
                            .addComponent(TxtCor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(CmdAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CmdCancelar)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TxtFec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmdCancelar)
                    .addComponent(CmdAceptar))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jLayeredPane3.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CmdAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdAceptarActionPerformed
        if (!Validacion()) {
            return;
        }

        ConexionMongoDB manejador = new ConexionMongoDB();

        //if (CodModif != null) {//si hay q modificar carga los datos 
        if (CodModif.length()>0) {//si hay q modificar carga los datos 
            manejador.actualizarDocumento(CodModif, CapruraDatos());
            JOptionPane.showMessageDialog(null, "Exito Al Modificar Ficha", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } else {//si agrega un registro nuevo
            manejador.insertarDocumento(CapruraDatos());
            JOptionPane.showMessageDialog(null, "Exito Al Agregar Ficha", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
        manejador.cierraSesion();
        this.dispose();    //cierra esta ventana
    }//GEN-LAST:event_CmdAceptarActionPerformed

    private Document CapruraDatos() {
        String StrSexo = "";
        if (jComboSex.getSelectedIndex() > 0) {
            StrSexo = "F";
        } else {
            StrSexo = "M";
        }
        // Insertar un documento
        Document DocDireccion = new Document("ca1", TxtCa1.getText())
                .append("ca2", TxtCa2.getText())
                .append("ref", TxtRef.getText());

        Document documento = new Document("nom", TxtNom.getText())
                .append("ape", TxtApe.getText())
                .append("tel", TxtTel.getText())
                .append("cor", TxtCor.getText())
                .append("dir", DocDireccion)
                .append("sex", StrSexo)
                .append("fen", TxtFec.getText());
        return documento;
    }

    private Boolean Validacion() {
        Verifica validacion = new Verifica();
        Boolean Rpta = true;

        if (!validacion.EsNombre(TxtNom.getText())) {
            Rpta = false;
            JOptionPane.showMessageDialog(null, "Corrija error en Nombre", "Notificación:", JOptionPane.WARNING_MESSAGE);
            TxtNom.requestFocus();
        } else if (!validacion.EsNombre(TxtApe.getText())) {
            Rpta = false;
            JOptionPane.showMessageDialog(null, "Corrija error en Apellido", "Notificación:", JOptionPane.WARNING_MESSAGE);
            TxtApe.requestFocus();
        } else if (jComboSex.getSelectedIndex() < 0) {
            Rpta = false;
            JOptionPane.showMessageDialog(null, "Seleccione Sexo", "Notificación:", JOptionPane.WARNING_MESSAGE);
            jComboSex.requestFocus();
        } else if (!validacion.EsNumeroTelef(TxtTel.getText())) {
            Rpta = false;
            JOptionPane.showMessageDialog(null, "Corrija error en Número Telefónico", "Notificación:", JOptionPane.WARNING_MESSAGE);
            TxtTel.requestFocus();
        } else if (!validacion.EsFecha(TxtFec.getText())) {
            Rpta = false;
            JOptionPane.showMessageDialog(null, "Corrija Fecha", "Notificación:", JOptionPane.WARNING_MESSAGE);
            TxtFec.requestFocus();
        } else if (!validacion.EsCorreo(TxtCor.getText())) {
            Rpta = false;
            JOptionPane.showMessageDialog(null, "Corrija Correo Electrónico", "Notificación:", JOptionPane.WARNING_MESSAGE);
            TxtCor.requestFocus();
        } else if (TxtCa1.getText().length() < 1) {
            Rpta = false;
            JOptionPane.showMessageDialog(null, "Corrija error Calle 1", "Notificación:", JOptionPane.WARNING_MESSAGE);
            TxtCa1.requestFocus();
        }
        return Rpta;
    }

    private void TxtNomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNomKeyTyped
        if (TxtNom.getText().length() >= 100) {
            evt.consume(); // impide que ingresen más de 30 caracteres
        }
    }//GEN-LAST:event_TxtNomKeyTyped

    private void TxtApeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtApeKeyTyped
        if (TxtApe.getText().length() >= 100) {
            evt.consume(); // impide que ingresen más de 30 caracteres
        }
    }//GEN-LAST:event_TxtApeKeyTyped

    private void TxtTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTelKeyTyped
        if (TxtTel.getText().length() >= 15) {
            evt.consume(); // impide que ingresen más de 30 caracteres
        }
    }//GEN-LAST:event_TxtTelKeyTyped

    private void TxtCorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCorKeyTyped
        if (TxtCor.getText().length() >= 255) {
            evt.consume(); // impide que ingresen más de 30 caracteres
        }
    }//GEN-LAST:event_TxtCorKeyTyped

    private void CmdCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdCancelarActionPerformed
        this.dispose();    //cierra esta ventana 
    }//GEN-LAST:event_CmdCancelarActionPerformed

    private void TxtCa1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCa1KeyTyped
        if (TxtCa1.getText().length() >= 100) {
            evt.consume(); // impide que ingresen más de 30 caracteres
        }
    }//GEN-LAST:event_TxtCa1KeyTyped

    private void TxtCa2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCa2KeyTyped
        if (TxtCa2.getText().length() >= 100) {
            evt.consume(); // impide que ingresen más de 30 caracteres
        }
    }//GEN-LAST:event_TxtCa2KeyTyped

    private void TxtRefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtRefKeyTyped
        if (TxtRef.getText().length() >= 100) {
            evt.consume(); // impide que ingresen más de 30 caracteres
        }
    }//GEN-LAST:event_TxtRefKeyTyped

    private void TxtFecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFecKeyTyped
        if (TxtFec.getText().length() >= 10) {
            evt.consume(); // impide que ingresen más de 30 caracteres
        }
    }//GEN-LAST:event_TxtFecKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CmdAceptar;
    private javax.swing.JButton CmdCancelar;
    public javax.swing.JTextField TxtApe;
    public javax.swing.JTextField TxtCa1;
    public javax.swing.JTextField TxtCa2;
    public javax.swing.JTextField TxtCor;
    public javax.swing.JTextField TxtFec;
    public javax.swing.JTextField TxtNom;
    public javax.swing.JTextField TxtRef;
    public javax.swing.JTextField TxtTel;
    public javax.swing.JComboBox<String> jComboSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane3;
    // End of variables declaration//GEN-END:variables
}
