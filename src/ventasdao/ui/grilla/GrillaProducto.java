/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Producto;

/**
 *
 * @author Crist
 */
public class GrillaProducto extends AbstractTableModel {
    
    private ArrayList<Producto> productos = new ArrayList<>();

    public GrillaProducto(ArrayList<Producto> datos) {
        this.productos = datos;
    }
    
    @Override
    public int getRowCount() {
        return productos.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 5;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p = productos.get(rowIndex);
        
        switch(columnIndex){
            case 0: return p.getId();
            case 1: return p.getNombre();
            case 2: return p.getDescripcion();
            case 3: return p.getPrecio();
            case 4: return p.getCategoria();
            default: return "";
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getColumnName(int column){
        
        switch(column){
            case 0: return "ID";
            case 1: return "NOMBRE";
            case 2: return "DESCRIPCION";
            case 3: return "PRECIO";
            case 4: return "CATEGORIA";
            default: return "";
        }
    }
    
    public Producto getProductoFromRow(int rowIndex){
        
        return productos.get(rowIndex);
        
    }
    
}
