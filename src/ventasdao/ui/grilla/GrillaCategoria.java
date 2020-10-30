/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Categoria;

/**
 *
 * @author Hugo Chanampe
 */
public class GrillaCategoria extends AbstractTableModel{
    
    private ArrayList<Categoria> categorias = new ArrayList<>();

    public GrillaCategoria(ArrayList<Categoria> datos) {
        this.categorias = datos;
    }

    @Override
    public int getRowCount() {
        return categorias.size(); 
    }

    @Override
    public int getColumnCount() {
        return 3; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
             Categoria c = categorias.get(rowIndex);
                
          switch(columnIndex){
              case 0: return c.getId();
              case 1: return c.getDenominacion();
              case 2: return c.getDescripcion();
              default: return "";
          }
          
          
          
    }

    @Override
    public String getColumnName(int column) {
        
        switch(column){
            case 0: return "ID";
            case 1: return "DENOMINACION";
            case 2: return "DESCRIPCION";
            default: return "";
        }
    }
    
    public Categoria getCategoriaFromRow(int rowIndex){
        
        return categorias.get(rowIndex);
        
    }
}
