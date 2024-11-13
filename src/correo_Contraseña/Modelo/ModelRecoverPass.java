package correo_Contraseña.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class ModelRecoverPass {
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
    
    public ResultSet gResultSet(String correo) {
        Random aleatorio = new Random();
        long random = aleatorio.nextInt(100000, 999999);
        try {
            statment = conexion.createStatement();
            String query = "Update USUARIO\n"+
                            "Set Contraseña = "+random+"\n"+
                            "where CorreoElectronico = "+correo;
            // String query = "Select Contraseña from USUARIO where CorreoElectronico = "+correo;
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
