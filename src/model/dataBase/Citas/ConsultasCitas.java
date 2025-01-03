package model.dataBase.Citas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultasCitas {
    // Datos de conexión
    final private String url = "jdbc:mysql://root:zbHWBzTqpdWaLFOhxgYfMJNTFanUeLrY@autorack.proxy.rlwy.net:27850/railway";
    final private String usuario = "root";
    final private String contraseña = "zbHWBzTqpdWaLFOhxgYfMJNTFanUeLrY";
    private Statement statment = null;
    private Connection conexion = null;
    private ResultSet resultado = null;

    public void OpenConeccionDataBase() {
        try {
            // Crear la conexión
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("" + conexion);
            System.out.println("Conexión exitosa!");

        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }

    public void CloseConneccionDataBase() {
        // Cerrar la conexión
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexion cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    
    public ResultSet gResultSet(String query) {
        try {
            statment = conexion.createStatement();
            resultado = statment.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    
        if(resultado!=null){
            return resultado;
        }else{
            return null;
        }
    }

}
