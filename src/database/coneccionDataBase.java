package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class coneccionDataBase {
    // Datos de conexión
    private String url = "jdbc:mysql://root:zbHWBzTqpdWaLFOhxgYfMJNTFanUeLrY@autorack.proxy.rlwy.net:27850/railway";
    private String usuario = "root";
    private String contraseña = "zbHWBzTqpdWaLFOhxgYfMJNTFanUeLrY";
    private Statement statment = null;

    private Connection conexion = null;

    public void getConeccionDataBase() {
        
        
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

    public Statement getStatement(){
        return statment;
    }

    public static void main(String[] args) {
        ResultSet resultado = null;
        String sentencia ="CREATE TABLE PACIENTE ("
        + "IDPaciente INT PRIMARY KEY, "
        + "NombreCompleto VARCHAR(255) NOT NULL, "
        + "Telefono VARCHAR(20) NOT NULL, "
        + "Correo_electronico VARCHAR(255) NOT NULL, "
        + "Enlace TEXT"
        + ");";
        String sentencia2 = "CREATE TABLE USUARIO (\n" + 
                        "    IDUsuario INT PRIMARY KEY AUTO_INCREMENT,\n" + 
                        "    NombreCompleto VARCHAR(50) NOT NULL, \n" + 
                        "    Contraseña VARCHAR(15) NOT NULL, \n" + 
                        "    CorreoElectronico VARCHAR(50), \n" + 
                        "    Rol ENUM('Podólogo', 'Asistente', 'Administrador') NOT NULL \n" + 
                        ");";
        String sentencia3 = "CREATE TABLE CITA (" + //
                        "    IDCita INT PRIMARY KEY AUTO_INCREMENT," + //
                        "    FechaCita DATE NOT NULL," + //
                        "    HorarioCita TIME NOT NULL," + //
                        "    IDPaciente INT," + //
                        "    IDUsuario INT," + //
                        "    Recuerdo BOOLEAN," + //
                        "    Confirmacion BOOLEAN," + //
                        "    FOREIGN KEY (IDPaciente) REFERENCES PACIENTE(IDPaciente)," + //
                        "    FOREIGN KEY (IDUsuario) REFERENCES USUARIO(IDUsuario)" + //
                        ");";

        coneccionDataBase cone = new coneccionDataBase();
        cone.getConeccionDataBase();
        try{ 
            cone.statment=cone.conexion.createStatement();
            // cone.statment.executeUpdate("Delete from PACIENTE");
            // cone.statment.executeUpdate(sentencia3);
            cone.statment.executeUpdate("Insert into PACIENTE values ('1','Carlos Cuellar','4775022030','cuellar.11498@gmail.com','www.google.com')");
            // System.out.println("Tabla Creada correctamente");
            // resultado = cone.statment.executeQuery("SELECT * FROM Paciente");

            // while (resultado.next()) {
            //     // Obtener los valores de las columnas por nombre
            //     int idPaciente = resultado.getInt("IDPaciente");
            //     String nombreCompleto = resultado.getString("NombreCompleto");
            //     String telefono = resultado.getString("Telefono");
            //     String correoElectronico = resultado.getString("Correo_electronico");

            //     // Imprimir los resultados
            //     System.out.println("\t" + idPaciente + 
            //                     "\t" + nombreCompleto + 
            //                     "\t" + telefono + 
            //                     "\t" + correoElectronico);
            // }
            // resultado.close();

        }
        catch(SQLException e){
            System.out.println("Eror al ejecutar la sentencia"+e.getMessage());
            
        }
        cone.CloseConneccionDataBase();
    }

}
