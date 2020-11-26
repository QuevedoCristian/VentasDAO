package ventasdao.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.DetalleFactura;
import ventasdao.objetos.Factura;
import ventasdao.objetos.Producto;

public class DetalleFacturaControlador implements ICrud<DetalleFactura> {

    private Connection connection;

    private Statement stmt;

    private PreparedStatement ps;

    private ResultSet rs;

    private String sql;
    
    private ControladorProducto productoControlador;
    
    private FacturaControlador facturaControlador;

    @Override
    public boolean crear(DetalleFactura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "INSERT INTO detalle_factura (cantidad, monto, productos_id, facturas_id) VALUES (?,?,?,?)";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getCantidad());
            ps.setFloat(2, entidad.getMonto());
            ps.setInt(3, entidad.getProducto().getId());
            ps.setInt(4, entidad.getFactura().getId());
            
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(DetalleFactura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "DELETE FROM detalle_factura WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getId());
            
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println();
            return false;
        }
        return true;
    }

    @Override
    public DetalleFactura extraer(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(DetalleFactura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "UPDATE detalle_factura SET cantidad = ?, monto = ?, productos_id = ?, facturas_id = ? WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getCantidad());
            ps.setFloat(2, entidad.getMonto());
            ps.setInt(3, entidad.getProducto().getId());
            ps.setInt(4, entidad.getFactura().getId());
            ps.setInt(5, entidad.getId());
            
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public List<DetalleFactura> listar() throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        
        try {
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM detalle_factura";
            this.rs = stmt.executeQuery(sql);
            
            connection.close();
            
            ArrayList<DetalleFactura> detallesFactura = new ArrayList();
            
            while(rs.next()){
                DetalleFactura detalleFactura = new DetalleFactura();
                
                detalleFactura.setId(rs.getInt("id"));
                detalleFactura.setCantidad(rs.getInt("cantidad"));
                detalleFactura.setMonto(rs.getFloat("monto"));
                detalleFactura.setProducto(getProducto(rs.getInt("prodcutos_id")));
                detalleFactura.setFactura(getFactura(rs.getInt("facturas_id")));
                
                detallesFactura.add(detalleFactura);
            }
            connection.close();
            return detallesFactura;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    
    public Producto getProducto(Integer id) throws Exception{
        this.productoControlador = new ControladorProducto();
        
        Producto producto = productoControlador.extraer(id);
        
        return producto;
    }
    
    public Factura getFactura (Integer id) throws Exception {
        this.facturaControlador = new FacturaControlador();
        
        Factura factura = facturaControlador.extraer(id);
        
        return factura;
    }

}
