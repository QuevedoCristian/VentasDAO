/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import ventasdao.dominio.Conexion;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.TipoCliente;

/**
 *
 * @author Hugo Chanampe
 */
public class ClienteControlador implements ICrud<Cliente>{
    
    private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
    
    private TipoClienteControlador tipoClienteControlador;
    
    //public void modificarCategoria(Categoria c);
    //public Categoria obtenerCategoria(Integer id);
    //public void eliminarCategoria(Categoria c);
    
    @Override
    public boolean crear(Cliente entidad) throws SQLException, Exception{

        connection = Conexion.obtenerConexion ();
        sql = "INSERT INTO clientes (nombre,documento,apellido, tipo_cliente_id) VALUES (?,?,?,?)";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDocumento());
            ps.setString(3, entidad.getApellido ());
            ps.setInt(4, entidad.getTipoCliente().getId());
            ps.executeUpdate();
            connection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(Cliente entidad) throws SQLException, Exception{
        
        connection = Conexion.obtenerConexion();
        String sql = "DELETE FROM clientes WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Cliente> listar() throws SQLException,Exception{
        
     connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM clientes";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Cliente> clientes = new ArrayList();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDocumento(rs.getString("documento"));
                cliente.setId(rs.getInt("id"));
                cliente.setApellido (rs.getString("apellido"));
                cliente.setTipoCliente(getTipoCliente(rs.getInt("tipo_cliente_id")));
                        //System.out.println(cliente);
                clientes.add(cliente);
            }
            connection.close();
            return clientes;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean modificar(Cliente entidad) throws SQLException, Exception{
        
        connection = Conexion.obtenerConexion();
        String sql = "UPDATE clientes SET documento = ?, nombre = ?, apellido = ?, tipo_cliente_id = ? WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getDocumento());
            ps.setString(2, entidad.getNombre());
            ps.setString(3, entidad.getApellido());
            ps.setInt(4, entidad.getTipoCliente().getId());
            ps.setInt(5, entidad.getId());
            ps.executeUpdate();
            connection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteControlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public Cliente extraer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private TipoCliente getTipoCliente(Integer id) throws Exception{
        this.tipoClienteControlador = new TipoClienteControlador();
        
        TipoCliente tipoCliente = tipoClienteControlador.extraer(id);
        
        return tipoCliente;
    }
    
}
