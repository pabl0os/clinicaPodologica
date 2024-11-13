package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class coneccionDataBase {
    // Datos de conexión
    final private static String url = "jdbc:mysql://root:zbHWBzTqpdWaLFOhxgYfMJNTFanUeLrY@autorack.proxy.rlwy.net:27850/railway";
    final private static String usuario = "root";
    final private static String contraseña = "zbHWBzTqpdWaLFOhxgYfMJNTFanUeLrY";
    private static Statement statment = null;
    private static Connection conexion = null;
    private static ResultSet resultado = null;

    public static void OpenConeccionDataBase() {
        try {
            // Crear la conexión
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("" + conexion);
            System.out.println("Conexión exitosa!");

        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }

    public static void CloseConneccionDataBase() {
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

    public static ResultSet gResultSet(String query) {
        try {
            statment = conexion.createStatement();
            resultado = statment.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return resultado;
    }

    public static void main(String[] args) {
         String sentencia5 = "INSERT INTO CITA (FechaCita, HorarioCita,IDPaciente, Recuerdo, Confirmacion) VALUES ( '2023-11-15', '10:00',1, TRUE, FALSE)";
        coneccionDataBase cone = new coneccionDataBase();
        cone.OpenConeccionDataBase();
        try {
            cone.statment = cone.conexion.createStatement();
            cone.statment.executeUpdate(sentencia5);
        } catch (SQLException e) {
            System.out.println("Eror al ejecutar la sentencia" + e.getMessage());

        }
        cone.CloseConneccionDataBase();
    // // }
    }

}
