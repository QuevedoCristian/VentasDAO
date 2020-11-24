/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.abm;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import ventasdao.controladores.CategoriaControlador;
import ventasdao.controladores.ControladorProducto;
import ventasdao.objetos.Categoria;
import ventasdao.objetos.Producto;
import ventasdao.ui.grilla.GrillaProducto;

/**
 *
 * @author Crist
 */
public class AbmProducto extends javax.swing.JInternalFrame {
    
    private Producto producto;
    private ControladorProducto productoControlador;
    private CategoriaControlador categoriaControlador;
    private GrillaProducto grillaProducto;
    private DefaultComboBoxModel modelCombo;

    /**
     * Creates new form AbmProducto
     */
    public AbmProducto() {
        initComponents();
        
        productoControlador = new ControladorProducto();
        categoriaControlador = new CategoriaControlador();
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            ArrayList<Categoria> categorias = categoriaControlador.listar();
            modelCombo = new DefaultComboBoxModel(categorias.toArray());
            jcbCategorias.setModel(modelCombo);
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            productos = productoControlador.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        grillaProducto = new GrillaProducto(productos);
        jtListadoProductos.setModel(grillaProducto);
        
    }
    
    public void limpiarCampos(){
        
        //jtfCategoria.setText("");
        jtfNombre.setText("");
        jtfDescripcion.setText("");
        jtfPrecio.setText("");
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
        jtListadoProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfDescripcion = new javax.swing.JTextField();
        jtfPrecio = new javax.swing.JTextField();
        jbAltaProducto = new javax.swing.JButton();
        jbModificarProducto = new javax.swing.JButton();
        jbBajaProducto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jcbCategorias = new javax.swing.JComboBox<>();

        setClosable(true);

        jtListadoProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtListadoProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListadoProductos);

        jLabel1.setText("ID");

        jLabel3.setText("Nombre");

        jLabel4.setText("Descripcion");

        jLabel5.setText("Precio");

        jtfId.setEnabled(false);
        jtfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdActionPerformed(evt);
            }
        });

        jbAltaProducto.setText("Agregar");
        jbAltaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAltaProductoActionPerformed(evt);
            }
        });

        jbModificarProducto.setText("Modificar");
        jbModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarProductoActionPerformed(evt);
            }
        });

        jbBajaProducto.setText("Eliminar");
        jbBajaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBajaProductoActionPerformed(evt);
            }
        });

        jLabel2.setText("Categoria");

        jcbCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jtfDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jtfId, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jtfPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jcbCategorias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jbAltaProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbModificarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBajaProducto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAltaProducto)
                    .addComponent(jbModificarProducto)
                    .addComponent(jbBajaProducto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdActionPerformed

    private void jbAltaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaProductoActionPerformed
        // TODO add your handling code here:
        producto = new Producto();
        
        producto.setNombre(jtfNombre.getText());
        producto.setDescripcion(jtfDescripcion.getText());
        producto.setPrecio(Float.parseFloat(jtfPrecio.getText()));
        producto.setCategoria((Categoria) jcbCategorias.getSelectedItem());
        
        try {
            productoControlador.crear(producto);
            limpiarCampos();
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            jtListadoProductos.setModel(new GrillaProducto(productoControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbAltaProductoActionPerformed

    private void jbModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarProductoActionPerformed
        // TODO add your handling code here:
        producto = new Producto();
        
        producto.setNombre(jtfNombre.getText());
        producto.setDescripcion(jtfDescripcion.getText());
        producto.setPrecio(Float.parseFloat(jtfPrecio.getText()));
        producto.setCategoria((Categoria) jcbCategorias.getSelectedItem());
        producto.setId(Integer.parseInt(jtfId.getText()));
        
        try {
            productoControlador.modificar(producto);
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            jtListadoProductos.setModel(new GrillaProducto(productoControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbModificarProductoActionPerformed

    private void jbBajaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBajaProductoActionPerformed
        // TODO add your handling code here:
        producto = new Producto();
        
        producto.setId(Integer.parseInt(jtfId.getText()));
        
        try {
            productoControlador.eliminar(producto);
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            jtListadoProductos.setModel(new GrillaProducto(productoControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbBajaProductoActionPerformed

    private void jtListadoProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoProductosMouseClicked
        // TODO add your handling code here:
        Producto producto = grillaProducto.getProductoFromRow(jtListadoProductos.getSelectedRow());
        
        jtfId.setText(producto.getId().toString());
        jtfNombre.setText(producto.getNombre());
        jtfDescripcion.setText(producto.getDescripcion());
        jtfPrecio.setText(producto.getPrecio().toString());
        //jcbCategorias.setSelectedItem(producto.getCategoria().getId());
    }//GEN-LAST:event_jtListadoProductosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAltaProducto;
    private javax.swing.JButton jbBajaProducto;
    private javax.swing.JButton jbModificarProducto;
    private javax.swing.JComboBox<String> jcbCategorias;
    private javax.swing.JTable jtListadoProductos;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPrecio;
    // End of variables declaration//GEN-END:variables
}
