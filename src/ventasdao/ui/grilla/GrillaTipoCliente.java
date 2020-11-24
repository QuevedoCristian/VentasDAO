/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.TipoCliente;

/**
 *
 * @author Crist
 */
public class GrillaTipoCliente extends AbstractTableModel {

    private ArrayList<TipoCliente> tipoClientes = new ArrayList<>();

    public GrillaTipoCliente(ArrayList<TipoCliente> datos) {
        this.tipoClientes = datos;
    }

    @Override
    public int getRowCount() {
        return tipoClientes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoCliente tc = tipoClientes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return tc.getId();
            case 1:
                return tc.getNombre();
            case 2:
                return tc.getDescripcion();
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
                return "NOMBRE";
            case 2:
                return "DESCRIPCION";
            default:
                return "";
        }
    }

    public TipoCliente getTipoClienteFromRow(int rowIndex) {

        return tipoClientes.get(rowIndex);

    }

}
