package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.DetalleFactura;

public class GrillaDetallesFactura extends AbstractTableModel {
    
    private ArrayList <DetalleFactura> detallesFacturas = new ArrayList<>();
    
    public GrillaDetallesFactura (ArrayList<DetalleFactura> datos){
        this.detallesFacturas = datos;
    }

    @Override
    public int getRowCount() {
        return detallesFacturas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DetalleFactura d = detallesFacturas.get(rowIndex);
        
        switch(columnIndex){
            case 0: return d.getProducto();
            case 1: return d.getCantidad();
            case 2: return d.getMonto();
            default: return "";
        }
    }
    
    @Override
    public String getColumnName (int column){
        switch(column){
            case 0: return "PRODUCTO";
            case 1: return "CANTIDAD";
            case 2: return "MONTO";
            default: return "";
        }
    }
}
