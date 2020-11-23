package ventasdao.controladores;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.TipoCliente;

/**
 *
 * @author Crist
 */
public class TipoClienteControlador implements ICrud<TipoCliente> {

    private Connection connection;

    private Statement stmt;

    private PreparedStatement ps;

    private ResultSet rs;

    private String sql;

    @Override
    public boolean crear(TipoCliente entidad) throws SQLException, Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        connection = Conexion.obtenerConexion();
        sql = "INSERT INTO tipo_cliente (nombre, descripcion) VALUES (?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(TipoCliente entidad) throws SQLException, Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        connection = Conexion.obtenerConexion();
        sql = "DELETE FROM tipo_cliente WHERE id = ?";

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
    public TipoCliente extraer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(TipoCliente entidad) throws SQLException, Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        connection = Conexion.obtenerConexion();
        sql = "UPDATE tipo_cliente SET nombre = ?, descripcion = ? WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setInt(3, entidad.getId());
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public List<TipoCliente> listar() throws SQLException, Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        connection = Conexion.obtenerConexion();
        try {
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM tipo_cliente";
            this.rs = stmt.executeQuery(sql);
            connection.close();

            ArrayList<TipoCliente> tiposCliente = new ArrayList();

            while (rs.next()) {
                TipoCliente tipoCliente = new TipoCliente();

                tipoCliente.setId(rs.getInt("id"));
                tipoCliente.setNombre(rs.getString("nombre"));
                tipoCliente.setDescripcion(rs.getString("descripcion"));

                tiposCliente.add(tipoCliente);
            }
            return tiposCliente;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
