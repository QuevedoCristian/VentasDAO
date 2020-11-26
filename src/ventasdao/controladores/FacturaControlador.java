package ventasdao.controladores;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.Factura;
import ventasdao.objetos.FormaPago;

public class FacturaControlador implements ICrud<Factura> {

    private Connection connection;

    private Statement stmt;

    private PreparedStatement ps;

    private ResultSet rs;

    private String sql;

    private FormaPagoControlador formaPagoControlador;

    private ClienteControlador clienteControlador;

    @Override
    public boolean crear(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "INSERT INTO facturas (monto_total, observaciones, clientes_id, forma_pago_id) VALUES (?,?,?,?)";
        Date fecha = new Date(entidad.getFechaFacturacion().getTime());

        try {
            ps = connection.prepareStatement(sql);
            //ps.setInt(1, entidad.getNumeroFactura());
            ps.setFloat(1, entidad.getMontoTotal());
            ps.setString(2, entidad.getObservaciones());
            ps.setInt(3, entidad.getCliente().getId());
            ps.setInt(4, entidad.getFormaPago().getId());
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminar(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "DELETE FROM facturas WHERE numero_factura = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getNumeroFactura());
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public Factura extraer(int id) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "SELECT * FROM facturas WHERE numero_factura = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            connection.close();
            
            Factura factura = new Factura();
            if(rs.next()){
                factura.setId(id);
                factura.setNumeroFactura(rs.getInt("numero_factura"));
                factura.setMontoTotal(rs.getFloat("monto_total"));
                factura.setFechaFacturacion(rs.getDate("fecha_facturacion"));
                factura.setObservaciones(rs.getString("observaciones"));
                factura.setCliente(getCliente(rs.getInt("clientes_id")));
                factura.setFormaPago(getFormaPago(rs.getInt("forma_pago_id")));
            }
            return factura;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public boolean modificar(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        sql = "UPDATE facturas SET monto_total = ?, observaciones = ?, clientes_id = ?, forma_pago_id = ? WHERE numero_factura = ?";
        //Date fecha = new Date(entidad.getFechaFacturacion().getTime());

        try {
            ps = connection.prepareStatement(sql);
            //ps.setInt(1, entidad.getNumeroFactura());
            ps.setFloat(1, entidad.getMontoTotal());
            ps.setString(2, entidad.getObservaciones());
            ps.setInt(3, entidad.getCliente().getId());
            ps.setInt(4, entidad.getFormaPago().getId());
            ps.setInt(5, entidad.getNumeroFactura());
            ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

    @Override
    public List<Factura> listar() throws SQLException, Exception {
        connection = Conexion.obtenerConexion();

        try {
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM facturas";
            this.rs = stmt.executeQuery(sql);

            ArrayList<Factura> facturas = new ArrayList();

            while (rs.next()) {
                Factura factura = new Factura();

                factura.setId(rs.getInt("id"));
                factura.setNumeroFactura(rs.getInt("numero_factura"));
                factura.setMontoTotal(rs.getFloat("monto_total"));
                factura.setFechaFacturacion(rs.getDate("fecha_facturacion"));
                factura.setObservaciones(rs.getString("observaciones"));
                factura.setCliente(getCliente(rs.getInt("clientes_id")));
                factura.setFormaPago(getFormaPago(rs.getInt("forma_pago_id")));

                facturas.add(factura);
            }
            connection.close();
            return facturas;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    private FormaPago getFormaPago(Integer id) throws Exception {
        this.formaPagoControlador = new FormaPagoControlador();

        FormaPago formaPago = formaPagoControlador.extraer(id);

        return formaPago;
    }

    private Cliente getCliente(Integer id) throws Exception {
        this.clienteControlador = new ClienteControlador();

        Cliente cliente = clienteControlador.extraer(id);

        return cliente;
    }
}
