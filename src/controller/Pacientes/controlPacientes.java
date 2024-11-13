package controller.Pacientes;


import model.dataBase.Pacientes.ConsultaPacientes;
import model.objects.Paciente.paciente;

public class controlPacientes {

    ConsultaPacientes dataPacientes;

    public controlPacientes() {
        dataPacientes = new ConsultaPacientes();
    }

    public boolean agregarPaciente(String nombre, String telefono, String correo) {
        return dataPacientes.agregarPaciente("INSERT INTO PACIENTE (NombreCompleto, Telefono, Correo_electronico) " +
                "VALUES (?, ?, ?)", nombre, telefono, correo);
    }

    public Object[][] consultarPacientes(String entrada, String opcion) {
        switch (opcion) {
            case "Nombre":
                opcion = "NombreCompleto";
                break;
            case "Telefono":
                opcion = "Telefono";
                break;
            case "Correo":
                opcion = "Correo_electronico";
                break;
        }
        String query = "SELECT * FROM PACIENTE WHERE LOWER(" + opcion + ") LIKE '" + entrada + "%'";
        // String query = "SELECT * FROM PACIENTE";
        paciente[] pacietes = dataPacientes.consultarPaciente(query);
        Object[][] pacientesSalida = new Object[pacietes.length][3];
        for (int i = 0; i < pacietes.length; i++) {
            pacientesSalida[i][0] = pacietes[i].getName();
            pacientesSalida[i][1] = pacietes[i].getPhoneNumber();
            pacientesSalida[i][2] = pacietes[i].getEmail();
        }
        return pacientesSalida;
    }

    public boolean modicarPaciente(String nombreAnterior, String telefonoAnterior, String correoAnterior,
            String nombreNuevo, String telefonoNuevo, String correoNuevo) {
        return dataPacientes.modificarPaciente(nombreAnterior, telefonoAnterior, correoAnterior, nombreNuevo, telefonoNuevo, correoNuevo);
    }

    public boolean eliminarPaciente(String nombre, String telefono, String correo){
        return dataPacientes.eliminarPaciente(nombre, telefono, correo);
    }
}
