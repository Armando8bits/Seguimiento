package Forms;

//import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Operaciones.ConexionMongoDB;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 * @author ROQUEARMANDORAMIREZP
 */
public class FrmPerfAdm extends javax.swing.JInternalFrame {

    ConexionMongoDB conexion = new ConexionMongoDB();
    int IntFila;
    String StrCodFila;

    /**
     * Creates new form FrmPerfAdm
     */
    public FrmPerfAdm() {

        initComponents();
        try {
            this.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FrmPerfAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
        CargarDatos();
    }

    private void CargarDatos() {
        DefaultTableModel modelo = new DefaultTableModel();
        List<String> ListaOrdena = new ArrayList<>();
        List<String> ListaFiltro = new ArrayList<>();
        List<String> ListaContFiltro = new ArrayList<>();
        List<String> ListaCampMostra = new ArrayList<>(Arrays.asList("_id", "nom", "ape", "sex", "est", "dir"));

        //primero saco los datos bajo que orden se quieren
        switch (jComboOrdena.getSelectedIndex()) {
            case 0:
                ListaOrdena.add("ca1");
                ListaOrdena.add("ca2");
                break;
            case 1:
                ListaOrdena.add("est");
                break;
            case 2:
                ListaOrdena.add("nom");
                break;
            case 3:
                ListaOrdena.add("ape");
                break;
            case 4:
                ListaOrdena.add("sex");
                break;
        }
        //luego saco los datos del filtro
        if (jCheckM.isSelected() && !jCheckF.isSelected()) {
            ListaFiltro.add("sex");
            ListaContFiltro.add("M");
        } else if (jCheckF.isSelected() && !jCheckM.isSelected()) {
            ListaFiltro.add("sex");
            ListaContFiltro.add("F");
        } else {
            jCheckF.setSelected(true);
            jCheckM.setSelected(true);
        }
        if (jCheckIn.isSelected()) {
            ListaFiltro.add("est");
            ListaContFiltro.add("1");
        } else if (jCheckDe.isSelected()) {
            ListaFiltro.add("est");
            ListaContFiltro.add("2");
        } else if (jCheckTr.isSelected()) {
            ListaFiltro.add("est");
            ListaContFiltro.add("3");
        } else if (jCheckFa.isSelected()) {
            ListaFiltro.add("est");
            ListaContFiltro.add("4");
        } else if (jCheckTras.isSelected()) {
            ListaFiltro.add("est");
            ListaContFiltro.add("5");
        }

        // Obtener los datos de MongoDB
        //List<Document> documentos = conexion.obtenerDatos(); //obtiene todo sin filtros
        List<Document> documentos = conexion.consulta(ListaFiltro, ListaContFiltro, ListaCampMostra, ListaOrdena);
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Sexo");
        modelo.addColumn("Estado");
        modelo.addColumn("Calle 1");
        modelo.addColumn("Calle 2");

        // Añadir los datos al modelo
        for (Document documento : documentos) {
            Object[] fila = new Object[7];
            fila[0] = documento.get("_id");
            fila[1] = documento.get("nom");
            fila[2] = documento.get("ape");
            fila[3] = documento.get("sex");
            fila[4] = documento.get("est");
            // Obtener el objeto dirección y concatenar sus propiedades
            Document direccion = (Document) documento.get("dir");
            fila[5] = direccion.get("ca1");
            fila[6] = direccion.get("ca2");
            modelo.addRow(fila);
        }

        // Asignar el modelo a la tabla
        Grdbuscar.setModel(modelo);
        IntFila = -1; //inica como -1 para saber en que momento tocan el control
        //StrCodFila = "";

        if (Grdbuscar.getRowCount() < 1) {
            //CmdNuevo.setEnabled(true);
            CmdEditar.setEnabled(false);
            CmdSeguimiento.setEnabled(false);
            CmdEliminar.setEnabled(false);
            jLayeredP1.setEnabled(false);
            jLayeredP2.setEnabled(false);
        } else {
            //CmdNuevo.setEnabled(true);
            CmdEditar.setEnabled(true);
            CmdSeguimiento.setEnabled(true);
            CmdEliminar.setEnabled(true);
            jLayeredP1.setEnabled(true);
            jLayeredP2.setEnabled(true);
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
        Grdbuscar = new javax.swing.JTable();
        CmdEliminar = new javax.swing.JButton();
        CmdEditar = new javax.swing.JButton();
        CmdSeguimiento = new javax.swing.JButton();
        jLayeredP2 = new javax.swing.JLayeredPane();
        jCheckM = new javax.swing.JCheckBox();
        jCheckF = new javax.swing.JCheckBox();
        jCheckIn = new javax.swing.JCheckBox();
        jCheckFa = new javax.swing.JCheckBox();
        jCheckTr = new javax.swing.JCheckBox();
        jCheckDe = new javax.swing.JCheckBox();
        jCheckTras = new javax.swing.JCheckBox();
        CmdActualiza = new javax.swing.JButton();
        jLayeredP1 = new javax.swing.JLayeredPane();
        jComboOrdena = new javax.swing.JComboBox<>();

        setClosable(true);
        setMaximizable(true);
        setTitle("Administrar Perfiles");
        setFrameIcon(null);
        setVisible(true);

        Grdbuscar= new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        Grdbuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Grdbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Grdbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrdbuscarMouseClicked(evt);
            }
        });
        Grdbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GrdbuscarKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Grdbuscar);

        CmdEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CmdEliminar.setText("Eliminar");
        CmdEliminar.setToolTipText("Eliminar");
        CmdEliminar.setFocusable(false);
        CmdEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CmdEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CmdEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdEliminarActionPerformed(evt);
            }
        });

        CmdEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CmdEditar.setText("Editar");
        CmdEditar.setToolTipText("Editar");
        CmdEditar.setFocusable(false);
        CmdEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CmdEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CmdEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdEditarActionPerformed(evt);
            }
        });

        CmdSeguimiento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CmdSeguimiento.setText("Seguimiento");
        CmdSeguimiento.setToolTipText("");
        CmdSeguimiento.setFocusable(false);
        CmdSeguimiento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CmdSeguimiento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CmdSeguimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdSeguimientoActionPerformed(evt);
            }
        });

        jLayeredP2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro:"));

        jCheckM.setSelected(true);
        jCheckM.setText("Masculino");

        jCheckF.setSelected(true);
        jCheckF.setText("Femenino");

        jCheckIn.setText("Incierto");

        jCheckFa.setText("Falecido");

        jCheckTr.setText("Trabajable");

        jCheckDe.setText("Desinteresado");

        jCheckTras.setText("Traslado");

        CmdActualiza.setText("Actualizar");
        CmdActualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmdActualizaActionPerformed(evt);
            }
        });

        jLayeredP2.setLayer(jCheckM, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredP2.setLayer(jCheckF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredP2.setLayer(jCheckIn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredP2.setLayer(jCheckFa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredP2.setLayer(jCheckTr, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredP2.setLayer(jCheckDe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredP2.setLayer(jCheckTras, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredP2.setLayer(CmdActualiza, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredP2Layout = new javax.swing.GroupLayout(jLayeredP2);
        jLayeredP2.setLayout(jLayeredP2Layout);
        jLayeredP2Layout.setHorizontalGroup(
            jLayeredP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredP2Layout.createSequentialGroup()
                .addGroup(jLayeredP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckM)
                    .addComponent(jCheckF))
                .addGap(18, 18, 18)
                .addGroup(jLayeredP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckIn)
                    .addComponent(jCheckFa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckDe)
                    .addGroup(jLayeredP2Layout.createSequentialGroup()
                        .addComponent(jCheckTr)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckTras)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(CmdActualiza)
                .addGap(19, 19, 19))
        );
        jLayeredP2Layout.setVerticalGroup(
            jLayeredP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredP2Layout.createSequentialGroup()
                .addGroup(jLayeredP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckM)
                    .addComponent(jCheckIn)
                    .addComponent(jCheckTr)
                    .addComponent(jCheckTras))
                .addGroup(jLayeredP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredP2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckF)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredP2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jLayeredP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckFa)
                            .addComponent(jCheckDe))
                        .addContainerGap())))
            .addGroup(jLayeredP2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CmdActualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredP1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenar por:"));

        jComboOrdena.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dirección", "Estado", "Nombres", "Apellidos", "Sexo" }));
        jComboOrdena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboOrdenaActionPerformed(evt);
            }
        });

        jLayeredP1.setLayer(jComboOrdena, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredP1Layout = new javax.swing.GroupLayout(jLayeredP1);
        jLayeredP1.setLayout(jLayeredP1Layout);
        jLayeredP1Layout.setHorizontalGroup(
            jLayeredP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredP1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboOrdena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredP1Layout.setVerticalGroup(
            jLayeredP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredP1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboOrdena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CmdEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CmdEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CmdSeguimiento)
                        .addGap(18, 18, 18)
                        .addComponent(jLayeredP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CmdEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CmdEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CmdSeguimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredP2)
                    .addComponent(jLayeredP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GrdbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrdbuscarMouseClicked
        IntFila = (Grdbuscar.rowAtPoint(evt.getPoint())); //obtiene el numero de fila de la tabla.
        //StrCodFila = String.valueOf(Grdbuscar.getValueAt(IntFila, 0)); //obtiene el Valor del COD seleccionada 

        if (evt.getClickCount() == 2) { //si se hace doble click...
            Editar();
        }
    }//GEN-LAST:event_GrdbuscarMouseClicked

    private void CmdEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdEliminarActionPerformed
        Eliminar();
    }//GEN-LAST:event_CmdEliminarActionPerformed

    private void CmdEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdEditarActionPerformed
        Editar();
    }//GEN-LAST:event_CmdEditarActionPerformed

    private void GrdbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GrdbuscarKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            Eliminar();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
            IntFila = Grdbuscar.getSelectedRow();
            //System.out.println("\t\t EL Numero de Fila ES: " + IntFila);
            //StrCodFila = String.valueOf(Grdbuscar.getValueAt(IntFila, 0)); //obtiene el Valor del COD seleccionada 
        }
    }//GEN-LAST:event_GrdbuscarKeyReleased

    private void CmdSeguimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdSeguimientoActionPerformed
        if (Grdbuscar.getRowCount() > 0 && IntFila >= 0) {
            StrCodFila = GetStrCod(); //obtiene el Valor del COD seleccionada
            FrmSeguimiento muestrate = new FrmSeguimiento(StrCodFila);
            FrmPrincipal.Escritorio.add(muestrate);
            muestrate.show();
        }
    }//GEN-LAST:event_CmdSeguimientoActionPerformed

    private String GetStrCod() {
        return String.valueOf(Grdbuscar.getValueAt(IntFila, 0));
    }
    private void CmdActualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmdActualizaActionPerformed
        CargarDatos();
    }//GEN-LAST:event_CmdActualizaActionPerformed

    private void jComboOrdenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboOrdenaActionPerformed
        CargarDatos();
    }//GEN-LAST:event_jComboOrdenaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CmdActualiza;
    private javax.swing.JButton CmdEditar;
    private javax.swing.JButton CmdEliminar;
    private javax.swing.JButton CmdSeguimiento;
    private javax.swing.JTable Grdbuscar;
    private javax.swing.JCheckBox jCheckDe;
    private javax.swing.JCheckBox jCheckF;
    private javax.swing.JCheckBox jCheckFa;
    private javax.swing.JCheckBox jCheckIn;
    private javax.swing.JCheckBox jCheckM;
    private javax.swing.JCheckBox jCheckTr;
    private javax.swing.JCheckBox jCheckTras;
    private javax.swing.JComboBox<String> jComboOrdena;
    private javax.swing.JLayeredPane jLayeredP1;
    private javax.swing.JLayeredPane jLayeredP2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void Editar() {
        if (Grdbuscar.getRowCount() > 0 && IntFila >= 0) {
            StrCodFila = GetStrCod(); //obtiene el Valor del COD seleccionada 
            FrmPerfNue muestrate = new FrmPerfNue(StrCodFila);
            FrmPrincipal.Escritorio.add(muestrate);
            muestrate.setTitle("Editar Ficha");

            Document archivo = conexion.obtenerArchivoPorId(StrCodFila);
            //System.out.println("\t\t EL CODIGO ES: " + StrCodFila);
            if (archivo != null) {//si lo encuentra
                muestrate.TxtNom.setText(archivo.getString("nom"));
                muestrate.TxtApe.setText(archivo.getString("ape"));
                muestrate.TxtTel.setText(archivo.getString("tel"));
                muestrate.TxtCor.setText(archivo.getString("cor"));

                String StrSex = archivo.getString("sex");
                if (StrSex.matches("M")) {
                    muestrate.jComboSex.setSelectedIndex(0);
                } else {
                    muestrate.jComboSex.setSelectedIndex(1);
                }

                muestrate.TxtFec.setText(archivo.getString("fen"));
                Document direccion = (Document) archivo.get("dir");
                muestrate.TxtCa1.setText(direccion.getString("ca1"));
                muestrate.TxtCa2.setText(direccion.getString("ca2"));
                muestrate.TxtRef.setText(direccion.getString("ref"));
            }
            //muestrate.CodModif = StrCodFila; //habilita modo Edición
            //System.out.println("\t\t EL CODIGO en adm ES: " + StrCodFila);
            muestrate.show();
            //conexion.cierraSesion();
            this.dispose();    //cierra esta ventana  
        }
    }

    private void Eliminar() {
        if (!(Grdbuscar.getRowCount() > 0 && IntFila >= 0)) {
            return;
        }
        int opci = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Eliminar la Ficha de " + Grdbuscar.getValueAt(IntFila, 1) + "?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (opci == JOptionPane.YES_OPTION) { //elimina si y solo si el usuario acepta
            StrCodFila = GetStrCod(); //obtiene el Valor del COD seleccionada 
            conexion.eliminarDocumento(StrCodFila);
            JOptionPane.showMessageDialog(null, "Ficha de " + Grdbuscar.getValueAt(IntFila, 1) + " eliminada con exito", "Aviso", JOptionPane.DEFAULT_OPTION);
            CargarDatos();
        }
    }

    @Override
    public void dispose() {
        conexion.cierraSesion();
        //System.out.println("\t\t sesión cerrada");
    }
}