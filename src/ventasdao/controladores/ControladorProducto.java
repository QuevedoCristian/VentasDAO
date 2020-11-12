package ventasdao.controladores;

import ventasdao.objetos.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ventasdao.dominio.Conexion;

public class ControladorProducto implements ICrud<Producto> {

    private Connection connection;

    private Statement statementmt;

    private PreparedStatement preparedStatements;

    private ResultSet resultSet;

    private String query;


    @Override
    public boolean crear(Producto entidad) throws SQLException, Exception{
        
        connection = Conexion.obtenerConexion();
        String sql = "INSERT INTO productos (nombre, descripcion, precio, categorias_id) VALUES (?,?,?,?)";
        
        try {
            preparedStatements = connection.prepareStatement(sql);
            preparedStatements.setString(1, entidad.getNombre());
            preparedStatements.setString(2, entidad.getDescripcion());
            preparedStatements.setFloat(3, entidad.getPrecio());
            preparedStatements.setInt(4, entidad.getCategoria().getId());
            preparedStatements.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(Producto entidad) throws SQLException, Exception{
        
        connection = Conexion.obtenerConexion();
        String sql = "DELETE FROM productos WHERE id = ?";
        
        try {
            preparedStatements = connection.prepareStatement(sql);
            preparedStatements.setInt(1, entidad.getId());
            preparedStatements.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public Producto extraer(int id) {
        return null;
    }

    @Override
    public boolean modificar(Producto entidad) throws SQLException, Exception{
        
        connection = Conexion.obtenerConexion();
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ? WHERE id = ?";
        
        try {
            preparedStatements = connection.prepareStatement(sql);
            preparedStatements.setString(1, entidad.getNombre());
            preparedStatements.setString(2, entidad.getDescripcion());
            preparedStatements.setFloat(3, entidad.getPrecio());
            //preparedStatements.setInt(4, entidad.getCategoria().getId());
            preparedStatements.setInt(4, entidad.getId());
            preparedStatements.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public ArrayList <Producto> listar() throws SQLException, Exception{
        
        connection = Conexion.obtenerConexion();
        try {
            this.statementmt = connection.createStatement();
            this.query = "SELECT * FROM productos";
            this.resultSet = statementmt.executeQuery(query);
            connection.close();
            
            ArrayList <Producto> productos = new ArrayList();
            
            while(resultSet.next()){
                Producto producto = new Producto();
                
                producto.setId(resultSet.getInt("id"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setPrecio(resultSet.getFloat("precio"));
                
                productos.add(producto);
            }
            connection.close();
            return productos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
