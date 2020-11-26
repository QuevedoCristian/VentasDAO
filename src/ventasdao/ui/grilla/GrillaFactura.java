package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Factura;

public class GrillaFactura extends AbstractTableModel {

    private ArrayList<Factura> facturas = new ArrayList<>();

    public GrillaFactura(ArrayList<Factura> datos) {
        this.facturas = datos;
    }

    @Override
    public int getRowCount() {
        return facturas.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Factura f = facturas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return f.getId();
            case 1:
                return f.getNumeroFactura();
            case 2:
                return f.getMontoTotal();
            case 3:
                return f.getFechaFacturacion();
            case 4:
                return f.getObservaciones();
            case 5:
                return f.getCliente();
            case 6:
                return f.getFormaPago();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "NRO FACTURA";
            case 2:
                return "MONTO TOTAL";
            case 3:
                return "FECHA FACTURACION";
            case 4:
                return "OBSERVACIONES";
            case 5:
                return "CLIENTE";
            case 6:
                return "FORMA PAGO";
            default:
                return "";
        }
    }
    
    public Factura getFacturaFromRow(int rowIndex){
        return facturas.get(rowIndex);
    }

}
