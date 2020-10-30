/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Categoria;
import ventasdao.objetos.Cliente;

/**
 *
 * @author Hugo Chanampe
 */
public class GrillaCliente extends AbstractTableModel{
    
    private ArrayList<Cliente> clientes = new ArrayList<>();
    
    
    
    public GrillaCliente(ArrayList<Cliente> datos) {
        this.clientes = datos;
    }
    
    

    @Override
    public int getRowCount() {
        return clientes.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
         return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch(columnIndex){
              case 0: return cliente.getId();
              case 1: return cliente.getDocumento();
              case 2: return cliente.getNombre();
              case 3: return cliente.getApellido();
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "DOCUMENTO";
            case 2: return "NOMBRE";
            case 3: return "APELLIDO";
            default: return "";
        } //To change body of generated methods, choose Tools | Templates.
    }
    
    public Cliente getClienteFromRow(int rowIndex){
        
        return clientes.get(rowIndex);
        
    }
    
}
