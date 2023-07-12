package tienda.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
   // private final String DRIVER = "com.mysql.jdbc.Driver";

    protected void conectarBase() throws ClassNotFoundException, SQLException {
       // try {
            //Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE ;
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
       /* } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }*/
    }

    protected void desconectarBase() throws Exception {
        try {
            if (conexion != null) {
                conexion.close();
            }
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }

        } catch (SQLException e) {
            throw e;
        }
    }

    protected void insertarModificarEliminar(String query) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(query);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String query) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(query);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }
}