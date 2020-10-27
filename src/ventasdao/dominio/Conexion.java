package ventasdao.dominio;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

   //static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost:5432/VentasDAO";
   //static final String DB_URL = "jdbc:mysql://localhost:3306/sales_system";
   //static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
   //  Database credentials

   
   private static Connection conn = null;



   public static Connection obtenerConexion() throws SQLException, ClassNotFoundException {
     
         try {
            //Set Values from  .env configuration file
            //Properties enviromentsVaribles = Conexion.getProperties();
            final String  USER = "postgres"; 
            final String  PASS = "123456789";

            //Class.forName(JDBC_DRIVER);
             //STEP 3: Open a connection
      
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (Exception e) {
            e.printStackTrace();
         }
      
      return conn;
   }
   
   public static void cerrar() throws SQLException {
      if (conn != null) {
         conn.close();
      }
   }

   public static Properties  getProperties() throws Exception {
      FileReader reader=new FileReader(".env");
      Properties p = new Properties();
      p.load(reader);
      return p;
   }
}
