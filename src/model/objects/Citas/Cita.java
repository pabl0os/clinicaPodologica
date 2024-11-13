package model.objects.Citas;

<<<<<<< HEAD
public class Cita {
=======
import java.sql.Date;
import java.sql.Time;

public class Cita {
    private int idCita;
    private Date fechaCita;
    private Time horarioCita;
    private int idPaciente;
    private int idUsuario;
    private boolean recuerdo;
    private boolean confirmacion;

    public Cita(int idCita, Date fechaCita, Time horarioCita, int idPaciente, int idUsuario, boolean recuerdo,
            boolean confirmacion) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.horarioCita = horarioCita;
        this.idPaciente = idPaciente;
        this.idUsuario = idUsuario;
        this.recuerdo = recuerdo;
        this.confirmacion = confirmacion;
    }
    
>>>>>>> 89c8b035e2cc4f7ad48266fe622fc74c816dccdf

}
