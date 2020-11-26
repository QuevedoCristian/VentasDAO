package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.DetalleFactura;
import ventasdao.objetos.Factura;

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
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DetalleFactura d = detallesFacturas.get(rowIndex);
        
        switch(columnIndex){
            case 0: return d.getId();
            case 1: return d.getProducto();
            case 2: return d.getCantidad();
            case 3: return d.getMonto();
            case 4: return d.getFactura();
            default: return "";
        }
    }
    
    @Override
    public String getColumnName (int column){
        switch(column){
            case 0: return "ID";
            case 1: return "PRODUCTO";
            case 2: return "CANTIDAD";
            case 3: return "MONTO";
            case 4: return "FACTURA";
            default: return "";
        }
    }
    
    public DetalleFactura getFacturaFromRow(int rowIndex){
        
        return detallesFacturas.get(rowIndex);
        
    }
}
