/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.abm;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ventasdao.controladores.TipoClienteControlador;
import ventasdao.objetos.TipoCliente;
import ventasdao.ui.grilla.GrillaTipoCliente;

/**
 *
 * @author Crist
 */
public class AbmTipoCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form AbmTipoCliente
     */
    private TipoCliente tipoCliente;
    private TipoClienteControlador tipoClienteControlador;
    private GrillaTipoCliente grillaTipoCliente;
    
    public AbmTipoCliente() {
        initComponents();
        
        tipoClienteControlador = new TipoClienteControlador();
        ArrayList<TipoCliente> tipoClientes = new ArrayList<>();
        
        try {
            tipoClientes = (ArrayList<TipoCliente>) tipoClienteControlador.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        grillaTipoCliente = new GrillaTipoCliente(tipoClientes);
        jtListadoTipoClientes.setModel(grillaTipoCliente);
    }
    
    public void limpiarCampos(){
        
        jtfNombre.setText("");
        jtfDescripcion.setText("");
        
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
        jtListadoTipoClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfDescripcion = new javax.swing.JTextField();
        jbAltaTipoCliente = new javax.swing.JButton();
        jbModificarTipoCliente = new javax.swing.JButton();
        jbBajaTipoCliente = new javax.swing.JButton();

        setClosable(true);

        jtListadoTipoClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jtListadoTipoClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoTipoClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListadoTipoClientes);

        jLabel1.setText("ID");

        jLabel2.setText("Nombre");

        jLabel3.setText("Descripcion");

        jtfId.setEnabled(false);

        jtfNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfNombreMouseExited(evt);
            }
        });
        jtfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNombreKeyTyped(evt);
            }
        });

        jbAltaTipoCliente.setText("Agregar");
        jbAltaTipoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAltaTipoClienteActionPerformed(evt);
            }
        });

        jbModificarTipoCliente.setText("Modificar");
        jbModificarTipoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarTipoClienteActionPerformed(evt);
            }
        });

        jbBajaTipoCliente.setText("Eliminar");
        jbBajaTipoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBajaTipoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfNombre)
                            .addComponent(jtfDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jtfId)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jbAltaTipoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbModificarTipoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBajaTipoCliente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbAltaTipoCliente)
                            .addComponent(jbModificarTipoCliente)
                            .addComponent(jbBajaTipoCliente))))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAltaTipoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaTipoClienteActionPerformed
        // TODO add your handling code here:
        tipoCliente = new TipoCliente();
        
        tipoCliente.setNombre(jtfNombre.getText());
        tipoCliente.setDescripcion(jtfDescripcion.getText());
        
        try {
            tipoClienteControlador.crear(tipoCliente);
        } catch (Exception ex) {
            Logger.getLogger(AbmTipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            jtListadoTipoClientes.setModel(new GrillaTipoCliente((ArrayList<TipoCliente>) tipoClienteControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmTipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbAltaTipoClienteActionPerformed

    private void jbModificarTipoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarTipoClienteActionPerformed
        // TODO add your handling code here:
        tipoCliente = new TipoCliente();
        
        tipoCliente.setNombre(jtfNombre.getText());
        tipoCliente.setDescripcion(jtfDescripcion.getText());
        tipoCliente.setId(Integer.parseInt(jtfId.getText()));
        
        try {
            tipoClienteControlador.modificar(tipoCliente);
        } catch (Exception ex) {
            Logger.getLogger(AbmTipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            jtListadoTipoClientes.setModel(new GrillaTipoCliente((ArrayList<TipoCliente>) tipoClienteControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmTipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbModificarTipoClienteActionPerformed

    private void jbBajaTipoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBajaTipoClienteActionPerformed
        // TODO add your handling code here:
        tipoCliente = new TipoCliente();
        
        tipoCliente.setId(Integer.parseInt(jtfId.getText()));
        
        try {
            tipoClienteControlador.eliminar(tipoCliente);
        } catch (Exception ex) {
            Logger.getLogger(AbmTipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            jtListadoTipoClientes.setModel(new GrillaTipoCliente((ArrayList<TipoCliente>) tipoClienteControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmTipoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbBajaTipoClienteActionPerformed

    private void jtListadoTipoClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoTipoClientesMouseClicked
        // TODO add your handling code here:
        TipoCliente tipoCliente = grillaTipoCliente.getTipoClienteFromRow(jtListadoTipoClientes.getSelectedRow());
        
        jtfId.setText(tipoCliente.getId().toString());
        jtfNombre.setText(tipoCliente.getNombre());
        jtfDescripcion.setText(tipoCliente.getDescripcion());
    }//GEN-LAST:event_jtListadoTipoClientesMouseClicked

    private void jtfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyTyped
        // TODO add your handling code here:
        /*char validar = evt.getKeyChar();
        
        if(Character.isDigit(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Este campo no admite numeros");
        }*/
    }//GEN-LAST:event_jtfNombreKeyTyped

    private void jtfNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfNombreMouseExited
        // TODO add your handling code here:
        /*if(jtfNombre.getText().length() <= 3){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "El campo nombre debe tener más de 3 caracteres");
        }*/
    }//GEN-LAST:event_jtfNombreMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAltaTipoCliente;
    private javax.swing.JButton jbBajaTipoCliente;
    private javax.swing.JButton jbModificarTipoCliente;
    private javax.swing.JTable jtListadoTipoClientes;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
