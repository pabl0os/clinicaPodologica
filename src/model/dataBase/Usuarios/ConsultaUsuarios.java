package model.dataBase.Usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.objects.User.user;

public class ConsultaUsuarios {
    // Datos de conexión
    final private static String url = "jdbc:mysql://root:zbHWBzTqpdWaLFOhxgYfMJNTFanUeLrY@autorack.proxy.rlwy.net:27850/railway";
    final private static String usuario = "root";
    final private static String contraseña = "zbHWBzTqpdWaLFOhxgYfMJNTFanUeLrY";

    public boolean agregarUsuario(user user) {
        boolean salida = false;
        String query = "INSERT INTO USUARIO (" +
                "NombreCompleto, Contraseña, CorreoElectronico, " +
                "AgendarC, CancelarC, ModificarC, ConsultarC, RecordatoriosC, " +
                "AgregarP, EliminarP, ModificarP, ConsultarP, HistorialClinicoP, " +
                "ImprimirJustificanteO, ImprimirRecetaO, Rol) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
                PreparedStatement stmt = conexion.prepareStatement(query)) {

            // Sustituye los valores "?" por los datos del nuevo usuario
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPass());
            stmt.setString(3, user.getEmail());
            stmt.setBoolean(4, user.isAgendarCita());
            stmt.setBoolean(5, user.isCancelarCita());
            stmt.setBoolean(6, user.isModificarCita());
            stmt.setBoolean(7, user.isConsultarCita());
            stmt.setBoolean(8, user.isRecordatoriosCita());
            stmt.setBoolean(9, user.isAgregarPaciente());
            stmt.setBoolean(10, user.isEliminarPaciente());
            stmt.setBoolean(11, user.isModificarPaciente());
            stmt.setBoolean(12, user.isConsultarPaciente());
            stmt.setBoolean(13, user.isHistorialClinico());
            stmt.setBoolean(14, user.isImprimirJustificante());
            stmt.setBoolean(15, user.isImprimirReceta());
            stmt.setString(16, user.getRol()); // Rol como "Podólogo", "Asistente" o "Administrador"

            // Ejecuta la inserción
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usuario agregado exitosamente.");
                salida = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salida;
    }

    public user[] consultarUsuarios(String opcion, String entrada) {
        String query = "SELECT * FROM USUARIO WHERE LOWER(" + opcion + ") LIKE ?";
        List<user> usuarios = new ArrayList<>();
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
                PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, entrada + "%"); // Sustituye "nombreCompleto" por el nombre que buscas

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String nombre = rs.getString("NombreCompleto");
                    String pass = rs.getString("Contraseña");
                    String email = rs.getString("CorreoElectronico");
                    String Rol = rs.getString("Rol");
                    usuarios.add(new user(nombre, pass, email, Rol));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios.toArray(new user[0]);
    }

    public user[] consultarAllUsers() {
        String query = "SELECT * FROM USUARIO";
        List<user> usuarios = new ArrayList<>();
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
                PreparedStatement stmt = conexion.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String nombre = rs.getString("NombreCompleto");
                String pass = rs.getString("Contraseña");
                String email = rs.getString("CorreoElectronico");
                String Rol = rs.getString("Rol");
                usuarios.add(new user(nombre, pass, email, Rol));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios.toArray(new user[0]);
    }

    public boolean eliminarUsuario(user usuario2) {
        String query = "DELETE FROM USUARIO WHERE NombreCompleto = ? AND Contraseña = ? AND CorreoElectronico = ? AND Rol = ?";
        boolean salida = false;
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
                PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, usuario2.getName()); // Nombre del usuario a eliminar
            stmt.setString(2, usuario2.getPass()); // Contraseña del usuario a eliminar
            stmt.setString(3, usuario2.getEmail()); // Correo del usuario a eliminar
            stmt.setString(4, usuario2.getRol()); // Rol del usuario a eliminar

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Usuario eliminado correctamente.");
                salida = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salida;

    }

    public user consultarUser(user usuario2) {
        String sql = "SELECT AgendarC, CancelarC, ModificarC, ConsultarC, RecordatoriosC, "
                + "AgregarP, EliminarP, ModificarP, ConsultarP, HistorialClinicoP, "
                + "ImprimirJustificanteO, ImprimirRecetaO "
                + "FROM USUARIO "
                + "WHERE NombreCompleto = ? AND Contraseña = ? AND CorreoElectronico = ? AND Rol = ?";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            // Establecer los parámetros para la consulta
            stmt.setString(1, usuario2.getName());
            stmt.setString(2, usuario2.getPass());
            stmt.setString(3, usuario2.getEmail());
            stmt.setString(4, usuario2.getRol());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    boolean agendarC = rs.getBoolean("AgendarC");
                    boolean cancelarC = rs.getBoolean("CancelarC");
                    boolean modificarC = rs.getBoolean("ModificarC");
                    boolean consultarC = rs.getBoolean("ConsultarC");
                    boolean recordatoriosC = rs.getBoolean("RecordatoriosC");
                    boolean agregarP = rs.getBoolean("AgregarP");
                    boolean eliminarP = rs.getBoolean("EliminarP");
                    boolean modificarP = rs.getBoolean("ModificarP");
                    boolean consultarP = rs.getBoolean("ConsultarP");
                    boolean historialClinicoP = rs.getBoolean("HistorialClinicoP");
                    boolean imprimirJustificanteO = rs.getBoolean("ImprimirJustificanteO");
                    boolean imprimirRecetaO = rs.getBoolean("ImprimirRecetaO");

                    usuario2.setAgendarCita(agendarC);
                    usuario2.setCancelarCita(cancelarC);
                    usuario2.setModificarCita(modificarC);
                    usuario2.setConsultarCita(consultarC);
                    usuario2.setRecordatoriosCita(recordatoriosC);
                    usuario2.setAgregarPaciente(agregarP);
                    usuario2.setEliminarPaciente(eliminarP);
                    usuario2.setModificarPaciente(modificarP);
                    usuario2.setConsultarPaciente(consultarP);
                    usuario2.setHistorialClinico(historialClinicoP);
                    usuario2.setImprimirJustificante(imprimirJustificanteO);
                    usuario2.setImprimirReceta(imprimirRecetaO);

                } else {
                    System.out.println("Usuario no encontrado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario2;
    }

    public boolean modificarUsuario(user usuarioModificar, user nuevoUserModificar) {
        String sql = "UPDATE USUARIO SET "
                + "NombreCompleto = ?, Contraseña = ?, CorreoElectronico = ?, Rol = ?, "
                + "AgendarC = ?, CancelarC = ?, ModificarC = ?, ConsultarC = ?, RecordatoriosC = ?, "
                + "AgregarP = ?, EliminarP = ?, ModificarP = ?, ConsultarP = ?, HistorialClinicoP = ?, "
                + "ImprimirJustificanteO = ?, ImprimirRecetaO = ? "
                + "WHERE NombreCompleto = ? AND Contraseña = ? AND CorreoElectronico = ? AND Rol = ?";
        boolean salida = false;
        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            // Nuevos datos
            stmt.setString(1, nuevoUserModificar.getName());
            stmt.setString(2, nuevoUserModificar.getPass());
            stmt.setString(3, nuevoUserModificar.getEmail());
            stmt.setString(4,nuevoUserModificar.getRol());
            stmt.setBoolean(5, nuevoUserModificar.isAgendarCita());
            stmt.setBoolean(6, nuevoUserModificar.isCancelarCita());
            stmt.setBoolean(7, nuevoUserModificar.isModificarCita());
            stmt.setBoolean(8, nuevoUserModificar.isConsultarCita());
            stmt.setBoolean(9, nuevoUserModificar.isRecordatoriosCita());
            stmt.setBoolean(10, nuevoUserModificar.isAgregarPaciente());
            stmt.setBoolean(11, nuevoUserModificar.isEliminarPaciente());
            stmt.setBoolean(12, nuevoUserModificar.isModificarPaciente());
            stmt.setBoolean(13, nuevoUserModificar.isConsultarPaciente());
            stmt.setBoolean(14, nuevoUserModificar.isHistorialClinico());
            stmt.setBoolean(15, nuevoUserModificar.isImprimirJustificante());
            stmt.setBoolean(16, nuevoUserModificar.isImprimirReceta());

            // Datos antiguos para la condición WHERE
            stmt.setString(17, usuarioModificar.getName());
            stmt.setString(18, usuarioModificar.getPass());
            stmt.setString(19, usuarioModificar.getEmail());
            stmt.setString(20, usuarioModificar.getRol());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Usuario actualizado exitosamente.");
                salida = true;
            } else {
                System.out.println("No se encontró el usuario para actualizar.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salida;

    }
}
