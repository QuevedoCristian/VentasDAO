/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.abm;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ventasdao.controladores.ClienteControlador;
import ventasdao.controladores.DetalleFacturaControlador;
import ventasdao.controladores.FacturaControlador;
import ventasdao.controladores.FormaPagoControlador;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.DetalleFactura;
import ventasdao.objetos.Factura;
import ventasdao.objetos.FormaPago;
import ventasdao.objetos.Producto;
import ventasdao.ui.Principal;
import ventasdao.ui.grilla.GrillaDetallesFactura;
import ventasdao.ui.grilla.GrillaFactura;
import ventasdao.ui.abm.AbmFactura;

/**
 *
 * @author Crist
 */
public class AbmFactura extends javax.swing.JInternalFrame {

    private Factura factura;
    private DetalleFactura detalleFactura;
    private FacturaControlador facturaControlador;
    private GrillaDetallesFactura grillaDetallesFacturas;
    private ClienteControlador clienteControlador;
    private FormaPagoControlador formaPagoControlador;
    private DetalleFacturaControlador detalleFacturaControlador;
    private DefaultComboBoxModel modelComboCliente;
    private DefaultComboBoxModel modelComboFormaPago;
    private DefaultTableModel modelo;

    private double montoTotal = 0;
    private String subTotal = null;
    private String subTotalE = null;

    /**
     * Creates new form AbmFactura
     */
    public AbmFactura() {
        initComponents();

        facturaControlador = new FacturaControlador();
        clienteControlador = new ClienteControlador();
        formaPagoControlador = new FormaPagoControlador();
        ArrayList<DetalleFactura> detalleFacturas = new ArrayList<>();

        try {
            ArrayList<Cliente> clientes = clienteControlador.listar();
            modelComboCliente = new DefaultComboBoxModel(clientes.toArray());
            jcbCliente.setModel(modelComboCliente);
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ArrayList<FormaPago> formasPago = (ArrayList<FormaPago>) formaPagoControlador.listar();
            modelComboFormaPago = new DefaultComboBoxModel(formasPago.toArray());
            jcbFormaPago.setModel(modelComboFormaPago);
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*try {
            detalleFacturas = (ArrayList<DetalleFactura>) detalleFacturaControlador.listar();
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        //grillaDetallesFacturas = new GrillaDetallesFactura(detalleFacturas);
        //jtListadoDetallesFactura.setModel(grillaDetallesFacturas);
    }

    public void limpiarCampos() {
        jtfNumeroFactura.setText("");
        jtfMontoTotal.setText("");
        jtfObservaciones.setText("");
    }

    public void limpiarCamposDetalles() {
        jtfCantidad.setText("");
        jtfIdProducto.setText("");
        jtfPrecio.setText("");
        jtfTotal.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jtfNumeroFactura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfMontoTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfObservaciones = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcbCliente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jcbFormaPago = new javax.swing.JComboBox<>();
        jbAltaFactura = new javax.swing.JButton();
        jbModificarFactura = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jtfFechaFacturacion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfIdProducto = new javax.swing.JTextField();
        jtfBuscar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jtfPrecio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListadoDetallesFactura = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setClosable(true);

        jLabel2.setText("Numero Factura");

        jtfNumeroFactura.setEnabled(false);

        jLabel3.setText("Monto Total");

        jtfMontoTotal.setEnabled(false);

        jLabel4.setText("Fecha Facturacion");

        jLabel5.setText("Observaciones");

        jLabel6.setText("Cliente");

        jcbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Forma Pago");

        jcbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbAltaFactura.setText("Confirmar");
        jbAltaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAltaFacturaActionPerformed(evt);
            }
        });

        jbModificarFactura.setText("Modificar");
        jbModificarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarFacturaActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jtfFechaFacturacion.setEnabled(false);

        jLabel1.setText("Detalle de la facturación");

        jLabel8.setText("CANTIDAD");

        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyTyped(evt);
            }
        });

        jLabel9.setText("PRODUCTO (ID)");

        jtfIdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfIdProductoKeyTyped(evt);
            }
        });

        jtfBuscar.setText("Buscar");
        jtfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarActionPerformed(evt);
            }
        });

        jLabel10.setText("PRECIO");

        jtfPrecio.setEnabled(false);

        jLabel11.setText("TOTAL");

        jtfTotal.setEnabled(false);

        jtListadoDetallesFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PRODUCTO", "PRODUCTO", "CANTIDAD", "MONTO"
            }
        ));
        jScrollPane1.setViewportView(jtListadoDetallesFactura);

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfFechaFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtfCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jtfBuscar))
                                    .addComponent(jtfIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbAgregar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel10)
                                        .addGap(72, 72, 72)
                                        .addComponent(jLabel11)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jbAltaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jbModificarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                    .addComponent(jSeparator3))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfFechaFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jcbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jtfBuscar)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtfObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbModificarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAltaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAltaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaFacturaActionPerformed
        // TODO add your handling code here:
        factura = new Factura();

        //factura.setNumeroFactura(Integer.parseInt(jtfNumeroFactura.getText()));
        factura.setMontoTotal(Float.parseFloat(jtfMontoTotal.getText()));
        //factura.setFechaFacturacion(jdcFechaFacturacion.getDate());
        factura.setObservaciones(jtfObservaciones.getText());
        factura.setCliente((Cliente) jcbCliente.getSelectedItem());
        factura.setFormaPago((FormaPago) jcbFormaPago.getSelectedItem());
        
        

        try {
            facturaControlador.crear(factura);
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "Se creo la factura");
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se creo la factura");
        }

        /*try {
            jtListadoFacturas.setModel(new GrillaFactura((ArrayList<Factura>) facturaControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_jbAltaFacturaActionPerformed

    private void jbModificarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarFacturaActionPerformed
        // TODO add your handling code here:
        factura = new Factura();

        //factura.setNumeroFactura(Integer.parseInt(jtfNumeroFactura.getText()));
        factura.setMontoTotal(Float.parseFloat(jtfMontoTotal.getText()));
        factura.setObservaciones(jtfObservaciones.getText());
        factura.setCliente((Cliente) jcbCliente.getSelectedItem());
        factura.setFormaPago((FormaPago) jcbFormaPago.getSelectedItem());

        try {
            facturaControlador.modificar(factura);
            limpiarCampos();
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*try {
            jtListadoFacturas.setModel(new GrillaFactura((ArrayList<Factura>) facturaControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_jbModificarFacturaActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
        int fila = jtListadoDetallesFactura.getSelectedRow();
        
        String monto = (String) jtListadoDetallesFactura.getValueAt(fila, 2);
        
        subTotalE = monto;
        
        modelo = (DefaultTableModel) jtListadoDetallesFactura.getModel();
        
        modelo.removeRow(fila);
        
        montoTotal = montoTotal - Double.parseDouble(monto);
        
        jtfMontoTotal.setText(String.valueOf(montoTotal));
        /*factura = new Factura();

        factura.setNumeroFactura(Integer.parseInt(jtfNumeroFactura.getText()));

        try {
            facturaControlador.eliminar(factura);
            limpiarCampos();
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*try {
            jtListadoFacturas.setModel(new GrillaFactura((ArrayList<Factura>) facturaControlador.listar()));
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jtfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarActionPerformed
        // TODO add your handling code here:
        getProducto getProducto = new getProducto();
        Principal.jdpContenedorPrincipal.add(getProducto);

        getProducto.toFront();
        getProducto.setVisible(true);
    }//GEN-LAST:event_jtfBuscarActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        // TODO add your handling code here:

        DefaultTableModel modelo = (DefaultTableModel) jtListadoDetallesFactura.getModel();

        String[] registro = new String[4];

        registro[0] = jtfIdProducto.getText();
        registro[1] = getProducto.jtfNombreAux.getText();
        registro[2] = jtfCantidad.getText();
        registro[3] = jtfTotal.getText();

        //JOptionPane.showMessageDialog(null, "Llega " +registro);
        modelo.addRow(registro);

        jtListadoDetallesFactura.setModel(modelo);
        //jtListadoDetallesFactura.setModel(modelo);
        subTotal = jtfTotal.getText();
        montoTotal = montoTotal + Double.parseDouble(subTotal);
        jtfMontoTotal.setText(String.valueOf(montoTotal));
        
        limpiarCamposDetalles();

    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jtfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Este campo no admite letras");
        }
    }//GEN-LAST:event_jtfCantidadKeyTyped

    private void jtfIdProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdProductoKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Este campo no admite letras");
        }
    }//GEN-LAST:event_jtfIdProductoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbAltaFactura;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificarFactura;
    private javax.swing.JComboBox<String> jcbCliente;
    private javax.swing.JComboBox<String> jcbFormaPago;
    public static javax.swing.JTable jtListadoDetallesFactura;
    private javax.swing.JButton jtfBuscar;
    public static javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfFechaFacturacion;
    public static javax.swing.JTextField jtfIdProducto;
    private javax.swing.JTextField jtfMontoTotal;
    private javax.swing.JTextField jtfNumeroFactura;
    private javax.swing.JTextField jtfObservaciones;
    public static javax.swing.JTextField jtfPrecio;
    public static javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables
}
