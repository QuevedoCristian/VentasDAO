/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.abm;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventasdao.controladores.CategoriaControlador;
import ventasdao.controladores.ControladorProducto;
import ventasdao.objetos.Producto;
import ventasdao.ui.grilla.GrillaGetProducto;
import ventasdao.ui.abm.AbmFactura;

/**
 *
 * @author Crist
 */
public class getProducto extends javax.swing.JInternalFrame {
    
    private Producto producto;
    private ControladorProducto productoControlador;
    private CategoriaControlador categoriaControlador;
    private GrillaGetProducto grillaGetProducto;

    /**
     * Creates new form getProducto
     */
    public getProducto() {
        initComponents();
        
        productoControlador = new ControladorProducto();
        categoriaControlador = new CategoriaControlador();
        ArrayList<Producto> productos = new ArrayList<>();
        
        try {
            productos = productoControlador.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        grillaGetProducto = new GrillaGetProducto(productos);
        jtListadoProductos.setModel(grillaGetProducto);
        
        jtfIdAux.setVisible(false);
        jtfPrecioAux.setVisible(false);
        jtfNombreAux.setVisible(false);
        
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
        jbSeleccionar = new javax.swing.JButton();
        jtfIdAux = new javax.swing.JTextField();
        jtfPrecioAux = new javax.swing.JTextField();
        jtfNombreAux = new javax.swing.JTextField();

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

        jbSeleccionar.setText("Seleccionar");
        jbSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSeleccionarActionPerformed(evt);
            }
        });

        jtfIdAux.setEnabled(false);
        jtfIdAux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdAuxActionPerformed(evt);
            }
        });

        jtfPrecioAux.setEnabled(false);

        jtfNombreAux.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jtfIdAux, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfPrecioAux, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSeleccionar)
                .addGap(18, 18, 18)
                .addComponent(jtfNombreAux, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSeleccionar)
                    .addComponent(jtfIdAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPrecioAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNombreAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtListadoProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoProductosMouseClicked
        // TODO add your handling code here:
        Producto producto = grillaGetProducto.getProductoFromRow(jtListadoProductos.getSelectedRow());
        
        jtfIdAux.setText(producto.getId().toString());
        jtfPrecioAux.setText(producto.getPrecio().toString());
        jtfNombreAux.setText(producto.getNombre());
    }//GEN-LAST:event_jtListadoProductosMouseClicked

    private void jbSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSeleccionarActionPerformed
        // TODO add your handling code here:
        //Producto producto = new Producto
        AbmFactura.jtfIdProducto.setText(jtfIdAux.getText());
        AbmFactura.jtfPrecio.setText(jtfPrecioAux.getText());
        Float precioBase = Float.parseFloat(jtfPrecioAux.getText());
        Float PrecioTotal = Float.parseFloat(AbmFactura.jtfCantidad.getText());
        Float PrecioFinal;
        PrecioFinal = precioBase*PrecioTotal;
        AbmFactura.jtfTotal.setText(PrecioFinal.toString());
        
        dispose();
    }//GEN-LAST:event_jbSeleccionarActionPerformed

    private void jtfIdAuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdAuxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdAuxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSeleccionar;
    private javax.swing.JTable jtListadoProductos;
    private javax.swing.JTextField jtfIdAux;
    public static javax.swing.JTextField jtfNombreAux;
    private javax.swing.JTextField jtfPrecioAux;
    // End of variables declaration//GEN-END:variables
}
