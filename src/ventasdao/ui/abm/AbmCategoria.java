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
import ventasdao.controladores.CategoriaControlador;
import ventasdao.objetos.Categoria;
import ventasdao.ui.grilla.GrillaCategoria;

/**
 *
 * @author Hugo Chanampe
 */
public class AbmCategoria extends javax.swing.JInternalFrame {

    /**
     * Creates new form AbmCategoria
     */
    private Categoria categoria;
    private CategoriaControlador categoriaControlador;
    private GrillaCategoria grillaCategoria;
    
    public AbmCategoria() {
        initComponents();
        
        categoriaControlador = new CategoriaControlador();
        ArrayList<Categoria> categorias = new ArrayList<>();

        try {
            categorias = categoriaControlador.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }

        grillaCategoria = new GrillaCategoria(categorias);
        jtListadoCategorias.setModel(grillaCategoria);
    }
    
    public void limpiarCampos(){
    
    jtfDenominacion.setText("");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfDenominacion = new javax.swing.JTextField();
        jtfDescripcion = new javax.swing.JTextField();
        jbAltaCategoria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListadoCategorias = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();
        jbModificarCategoria = new javax.swing.JButton();
        jbBajasCategoria = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Denominacion");

        jLabel2.setText("Descripcion");

        jtfDenominacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfDenominacionMouseExited(evt);
            }
        });
        jtfDenominacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDenominacionKeyTyped(evt);
            }
        });

        jbAltaCategoria.setText("Agregar");
        jbAltaCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAltaCategoriaMouseClicked(evt);
            }
        });
        jbAltaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAltaCategoriaActionPerformed(evt);
            }
        });

        jtListadoCategorias.setModel(new javax.swing.table.DefaultTableModel(
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
        jtListadoCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListadoCategorias);

        jLabel3.setText("ID");

        jtfId.setEnabled(false);

        jbModificarCategoria.setText("Modificar");
        jbModificarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarCategoriaActionPerformed(evt);
            }
        });

        jbBajasCategoria.setText("Eliminar");
        jbBajasCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBajasCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfDenominacion)
                            .addComponent(jtfDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jtfId)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jbAltaCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbModificarCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBajasCategoria)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfDenominacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbAltaCategoria)
                            .addComponent(jbModificarCategoria)
                            .addComponent(jbBajasCategoria)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAltaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaCategoriaActionPerformed
        categoria = new Categoria();
        
        categoria.setDenominacion(jtfDenominacion.getText());
        categoria.setDescripcion(jtfDescripcion.getText());
        
        try {
            categoriaControlador.crear(categoria);
        } catch (Exception ex) {
            Logger.getLogger(AbmCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            jtListadoCategorias.setModel(new GrillaCategoria(categoriaControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbAltaCategoriaActionPerformed

    private void jbAltaCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAltaCategoriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAltaCategoriaMouseClicked

    private void jbModificarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarCategoriaActionPerformed
        // TODO add your handling code here:
        categoria = new Categoria();
        
        categoria.setDenominacion(jtfDenominacion.getText());
        categoria.setDescripcion(jtfDescripcion.getText());
        categoria.setId(Integer.parseInt(jtfId.getText()));
        
        try {
            categoriaControlador.modificar(categoria);
        } catch (Exception ex) {
            Logger.getLogger(AbmCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            jtListadoCategorias.setModel(new GrillaCategoria(categoriaControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbModificarCategoriaActionPerformed

    private void jtListadoCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoCategoriasMouseClicked
        // TODO add your handling code here:
        Categoria categoria = grillaCategoria.getCategoriaFromRow(jtListadoCategorias.getSelectedRow());
        
        jtfDenominacion.setText(categoria.getDenominacion());
        jtfDescripcion.setText(categoria.getDescripcion());
        jtfId.setText(categoria.getId().toString());
        
    }//GEN-LAST:event_jtListadoCategoriasMouseClicked

    private void jbBajasCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBajasCategoriaActionPerformed
        categoria = new Categoria();
        
        categoria.setId(Integer.parseInt(jtfId.getText()));
        try {
            // TODO add your handling code here:
            categoriaControlador.eliminar(categoria);
        } catch (Exception ex) {
            Logger.getLogger(AbmCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            jtListadoCategorias.setModel(new GrillaCategoria(categoriaControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbBajasCategoriaActionPerformed

    private void jtfDenominacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDenominacionKeyTyped
        // TODO add your handling code here:
        /*if(jtfDenominacion.getText().length() <= 3){
            getToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "Ingrese mas de tres caracteres");
        }*/
    }//GEN-LAST:event_jtfDenominacionKeyTyped

    private void jtfDenominacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfDenominacionMouseExited
        // TODO add your handling code here:
        /*if(jtfDenominacion.getText().length() <= 3){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese más de 3 caracteres");
        }*/
    }//GEN-LAST:event_jtfDenominacionMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAltaCategoria;
    private javax.swing.JButton jbBajasCategoria;
    private javax.swing.JButton jbModificarCategoria;
    private javax.swing.JTable jtListadoCategorias;
    private javax.swing.JTextField jtfDenominacion;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfId;
    // End of variables declaration//GEN-END:variables
}
