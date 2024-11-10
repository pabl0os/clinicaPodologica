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
        // return conexion;
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

    public static Statement getStatement() {
        try {
            statment = conexion.createStatement();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return statment;
    }

    public static Connection gConnection() {
        return conexion;
    }

    public static void main(String[] args) {
        // String sentencia = "CREATE TABLE PACIENTE ("
        //         + "IDPaciente INT PRIMARY KEY, "
        //         + "NombreCompleto VARCHAR(255) NOT NULL, "
        //         + "Telefono VARCHAR(20) NOT NULL, "
        //         + "Correo_electronico VARCHAR(255) NOT NULL, "
        //         + "Enlace TEXT"
        //         + ");";
        // String sentencia2 = "CREATE TABLE USUARIO (\n" +
        //         "    IDUsuario INT PRIMARY KEY AUTO_INCREMENT,\n" +
        //         "    NombreCompleto VARCHAR(50) NOT NULL, \n" +
        //         "    Contraseña VARCHAR(15) NOT NULL, \n" +
        //         "    CorreoElectronico VARCHAR(50), \n" +
        //         "    Rol ENUM('Podólogo', 'Asistente', 'Administrador') NOT NULL \n" +
        //         ");";
        // String sentencia3 = "CREATE TABLE CITA (" + //
        //         "    IDCita INT PRIMARY KEY AUTO_INCREMENT," + //
        //         "    FechaCita DATE NOT NULL," + //
        //         "    HorarioCita TIME NOT NULL," + //
        //         "    IDPaciente INT," + //
        //         "    IDUsuario INT," + //
        //         "    Recuerdo BOOLEAN," + //
        //         "    Confirmacion BOOLEAN," + //
        //         "    FOREIGN KEY (IDPaciente) REFERENCES PACIENTE(IDPaciente)," + //
        //         "    FOREIGN KEY (IDUsuario) REFERENCES USUARIO(IDUsuario)" + //
        //         ");";
        // String sentencia4 = "ALTER TABLE USUARIO\n" + //
        //                 "ADD COLUMN AgendarC BOOLEAN AFTER Rol,\n" + //
        //                 "ADD COLUMN CancelarC BOOLEAN AFTER AgendarC,\n" + //
        //                 "ADD COLUMN ModificarC BOOLEAN AFTER CancelarC,\n" + //
        //                 "ADD COLUMN ConsultarC BOOLEAN AFTER ModificarC,\n" + //
        //                 "ADD COLUMN RecordatoriosC BOOLEAN AFTER ConsultarC,\n" + //
        //                 "ADD COLUMN AgregarP BOOLEAN AFTER RecordatoriosC,\n" + //
        //                 "ADD COLUMN EliminarP BOOLEAN AFTER AgregarP,\n" + //
        //                 "ADD COLUMN ModificarP BOOLEAN AFTER EliminarP,\n" + //
        //                 "ADD COLUMN ConsultarP BOOLEAN AFTER ModificarP,\n" + //
        //                 "ADD COLUMN HistorialClinicoP BOOLEAN AFTER ConsultarP,\n" + //
        //                 "ADD COLUMN ImprimirJustificanteO BOOLEAN AFTER HistorialClinicoP,\n" + //
        //                 "ADD COLUMN ImprimirRecetaO BOOLEAN AFTER ImprimirJustificanteO;";

    //     coneccionDataBase cone = new coneccionDataBase();
    //     cone.OpenConeccionDataBase();
    //     try {
    //         cone.statment = cone.conexion.createStatement();
    //         // cone.statment.executeUpdate("Delete from PACIENTE");
    //         cone.statment.executeUpdate(sentencia4);
    //         // cone.statment.executeUpdate(
    //                 // "Insert into PACIENTE values ('1','Carlos Cuellar','4775022030','cuellar.11498@gmail.com','www.google.com')");
    //         // System.out.println("Tabla Creada correctamente");
    //         // resultado = cone.statment.executeQuery("SELECT * FROM Paciente");

    //         // while (resultado.next()) {
    //         // // Obtener los valores de las columnas por nombre
    //         // int idPaciente = resultado.getInt("IDPaciente");
    //         // String nombreCompleto = resultado.getString("NombreCompleto");
    //         // String telefono = resultado.getString("Telefono");
    //         // String correoElectronico = resultado.getString("Correo_electronico");

    //         // // Imprimir los resultados
    //         // System.out.println("\t" + idPaciente +
    //         // "\t" + nombreCompleto +
    //         // "\t" + telefono +
    //         // "\t" + correoElectronico);
    //         // }
    //         // resultado.close();

    //     } catch (SQLException e) {
    //         System.out.println("Eror al ejecutar la sentencia" + e.getMessage());

    //     }
    //     cone.CloseConneccionDataBase();
    // }
    }

}
