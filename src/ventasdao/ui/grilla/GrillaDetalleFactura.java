package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.DetalleFactura;

public class GrillaDetalleFactura extends AbstractTableModel {

    private ArrayList<DetalleFactura> detallesFactura = new ArrayList();

    public GrillaDetalleFactura(ArrayList<DetalleFactura> datos) {
        this.detallesFactura = datos;
    }

    @Override
    public int getRowCount() {
        return detallesFactura.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DetalleFactura d = detallesFactura.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getProducto();
            case 2:
                return d.getMonto();
            case 3:
                return d.getCantidad();
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
                return "PRODUCTO";
            case 2:
                return "MONTO";
            case 3:
                return "CANTIDAD";
            default:
                return "";
        }
    }

    public DetalleFactura getDetalleFacturaFromRow(int rowIndex) {

        return detallesFactura.get(rowIndex);
    }

}
