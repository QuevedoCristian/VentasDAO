package ventasdao.controladores;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.FormaPago;

public class FormaPagoControlador implements ICrud<FormaPago> {
    
    private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;

    @Override
    public boolean crear(FormaPago entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "INSERT INTO forma_pago (denominacion) VALUES (?)";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getDenominacion());
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(FormaPago entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "DELETE FROM forma_pago WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getId());
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public FormaPago extraer(int id) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "SELECT * FROM forma_pago WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            connection.close();
            
            FormaPago formaPago = new FormaPago();
            if(rs.next()){
                formaPago.setId(id);
                formaPago.setDenominacion(rs.getString("denominacion"));
            }
            return formaPago;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }    
    }

    @Override
    public boolean modificar(FormaPago entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "UPDATE forma_pago SET denominacion = ? WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getDenominacion());
            ps.setInt(2, entidad.getId());
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public List<FormaPago> listar() throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        try {
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM forma_pago";
            this.rs = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<FormaPago> formasPago = new ArrayList<>();
            
            while(rs.next()){
                FormaPago formaPago = new FormaPago();
                
                formaPago.setId(rs.getInt("id"));
                formaPago.setDenominacion(rs.getString("denominacion"));
                
                formasPago.add(formaPago);
            }
            return formasPago;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}
