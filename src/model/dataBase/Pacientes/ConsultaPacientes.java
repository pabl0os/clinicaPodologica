package model.dataBase.Pacientes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import model.objects.Paciente.paciente;

public class ConsultaPacientes {
    // Datos de conexión
    final private static String url = "jdbc:mysql://root:zbHWBzTqpdWaLFOhxgYfMJNTFanUeLrY@autorack.proxy.rlwy.net:27850/railway";
    final private static String usuario = "root";
    final private static String contraseña = "zbHWBzTqpdWaLFOhxgYfMJNTFanUeLrY";

    public paciente[] consultarPaciente(String query) {
        List<paciente> listaPacientes = new ArrayList<>();
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
                PreparedStatement stmt = conexion.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                int iDPaciente = rs.getInt("IDPaciente");
                String name = rs.getString("NombreCompleto");
                String numberPhone = rs.getString("Telefono");
                String email = rs.getString("Correo_electronico");
                String enlace = rs.getString("Enlace");
                paciente paci = new paciente(iDPaciente, name, numberPhone, email, enlace);
                listaPacientes.add(paci);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPacientes.toArray(new paciente[0]);
    }

    public boolean agregarPaciente(String query, String nombre, String telefono, String correo) {
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
                PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, telefono);
            stmt.setString(3, correo);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarPaciente(String nombreAnterior, String telefonoAnterior, String correoAnterior,
            String nombreNuevo, String telefonoNuevo, String correoNuevo) {
        boolean salida = false;
        String query = "UPDATE PACIENTE SET NombreCompleto = ?, Telefono = ?, Correo_electronico = ? "
                + "WHERE NombreCompleto = ? AND Telefono = ? AND Correo_electronico = ?";
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
                PreparedStatement stmt = conexion.prepareStatement(query)) {

            // Nuevos valores
            stmt.setString(1, nombreNuevo);
            stmt.setString(2, telefonoNuevo);
            stmt.setString(3, correoNuevo);

            // Valores antiguos (criterios de búsqueda)
            stmt.setString(4, nombreAnterior);
            stmt.setString(5, telefonoAnterior);
            stmt.setString(6, correoAnterior);

            // Ejecuta la actualización
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Paciente actualizado correctamente.");
                salida = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salida;
    }

    public boolean eliminarPaciente(String nombre, String telefono, String correo) {
        String query = "DELETE FROM PACIENTE WHERE NombreCompleto = ? AND Telefono = ? AND Correo_electronico = ?";
        boolean salida = false;
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
                PreparedStatement stmt = conexion.prepareStatement(query)) {

            // Establece los valores de los criterios de búsqueda
            stmt.setString(1, nombre);
            stmt.setString(2, telefono);
            stmt.setString(3, correo);

            // Ejecuta la eliminación
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                salida = true;
                System.out.println("Paciente eliminado correctamente.");
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salida;
    }
}
