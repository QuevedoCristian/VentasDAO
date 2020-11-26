package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Producto;

public class GrillaGetProducto extends AbstractTableModel {
    
    private ArrayList<Producto> productos = new ArrayList<>();
    
    public GrillaGetProducto (ArrayList<Producto> datos){
        this.productos = datos;
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p = productos.get(rowIndex);
        
        switch(columnIndex){
            case 0: return p.getId();
            case 1: return p.getNombre();
            case 2: return p.getPrecio();
            case 3: return p.getCategoria();
            default: return "";
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "ID";
            case 1: return "NOMBRE";
            case 2: return "PRECIO";
            case 3: return "CATEGORIA";
            default: return "";
        }
    }
    
    public Producto getProductoFromRow (int rowIndex){
        
        return productos.get(rowIndex);
        
    }
}
