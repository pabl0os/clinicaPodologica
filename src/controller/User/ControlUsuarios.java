package controller.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dataBase.Usuarios.ConsultaUsuarios;
import model.objects.User.user;

public class ControlUsuarios {

    private ConsultaUsuarios dataUsers;

    public ControlUsuarios() {
        dataUsers = new ConsultaUsuarios();
    }

    public boolean agregarUsuario(user usario) {
        return dataUsers.agregarUsuario(usario);
    }

    public Object[][] consultarUsers(String opcion, String entrada) {
        switch (opcion) {
            case "Nombre":
                opcion = "NombreCompleto";
                break;
            case "Correo":
                opcion = "CorreoElectronico";
                break;
        }
        user[] users = dataUsers.consultarUsuarios(opcion, entrada);
        Object[][] salida = new Object[users.length][4];
        for (int i = 0; i < users.length; i++) {
            salida[i][0] = users[i].getName();
            salida[i][1] = users[i].getPass();
            salida[i][2] = users[i].getEmail();
            salida[i][3] = users[i].getRol();
        }
        return salida;

    }

    public Object[][] consultarAllUsers() {
        user[] users = dataUsers.consultarAllUsers();
        Object[][] salida = new Object[users.length][4];
        for (int i = 0; i < users.length; i++) {
            salida[i][0] = users[i].getName();
            salida[i][1] = users[i].getPass();
            salida[i][2] = users[i].getEmail();
            salida[i][3] = users[i].getRol();
        }
        return salida;
    }

    public boolean eliminarUsuario(user usuario) {
        return dataUsers.eliminarUsuario(usuario);
    }

    public boolean modificarUsuario(user usuarioModificar, user nuevoUserModificar) {
        return dataUsers.modificarUsuario(usuarioModificar, nuevoUserModificar);
    }

    public user consultarUser(user usuario) {
        return dataUsers.consultarUser(usuario);
    }

}
