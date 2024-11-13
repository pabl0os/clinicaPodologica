package model.objects.User;

public class user {

    private int IDuser;
    private String name;
    private String pass;
    private String email;
    private String rol;

    private boolean AgendarCita;
    private boolean CancelarCita;
    private boolean ModificarCita;
    private boolean ConsultarCita;
    private boolean RecordatoriosCita;
    private boolean AgregarPaciente;
    private boolean EliminarPaciente;
    private boolean ModificarPaciente;
    private boolean ConsultarPaciente;
    private boolean HistorialClinico;
    private boolean imprimirJustificante;
    private boolean imprimirReceta;

    public user( String name, String pass, String email, String rol) {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.rol = rol;
    }

    
    public user() {
    }


    public int getIDuser() {
        return IDuser;
    }

    public void setIDuser(int iDuser) {
        IDuser = iDuser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isAgendarCita() {
        return AgendarCita;
    }

    public void setAgendarCita(boolean agendarCita) {
        AgendarCita = agendarCita;
    }

    public boolean isCancelarCita() {
        return CancelarCita;
    }

    public void setCancelarCita(boolean cancelarCita) {
        CancelarCita = cancelarCita;
    }

    public boolean isModificarCita() {
        return ModificarCita;
    }

    public void setModificarCita(boolean modificarCita) {
        ModificarCita = modificarCita;
    }

    public boolean isConsultarCita() {
        return ConsultarCita;
    }

    public void setConsultarCita(boolean consultarCita) {
        ConsultarCita = consultarCita;
    }

    public boolean isRecordatoriosCita() {
        return RecordatoriosCita;
    }

    public void setRecordatoriosCita(boolean recordatoriosCita) {
        RecordatoriosCita = recordatoriosCita;
    }

    public boolean isAgregarPaciente() {
        return AgregarPaciente;
    }

    public void setAgregarPaciente(boolean agregarPaciente) {
        AgregarPaciente = agregarPaciente;
    }

    public boolean isEliminarPaciente() {
        return EliminarPaciente;
    }

    public void setEliminarPaciente(boolean eliminarPaciente) {
        EliminarPaciente = eliminarPaciente;
    }

    public boolean isModificarPaciente() {
        return ModificarPaciente;
    }

    public void setModificarPaciente(boolean modificarPaciente) {
        ModificarPaciente = modificarPaciente;
    }

    public boolean isConsultarPaciente() {
        return ConsultarPaciente;
    }

    public void setConsultarPaciente(boolean consultarPaciente) {
        ConsultarPaciente = consultarPaciente;
    }

    public boolean isHistorialClinico() {
        return HistorialClinico;
    }

    public void setHistorialClinico(boolean historialClinico) {
        HistorialClinico = historialClinico;
    }


    public boolean isImprimirJustificante() {
        return imprimirJustificante;
    }


    public void setImprimirJustificante(boolean imprimirJustificante) {
        this.imprimirJustificante = imprimirJustificante;
    }


    public boolean isImprimirReceta() {
        return imprimirReceta;
    }


    public void setImprimirReceta(boolean imprimirReceta) {
        this.imprimirReceta = imprimirReceta;
    }


    @Override
    public String toString() {
        return "user [IDuser=" + IDuser + ", name=" + name + ", pass=" + pass + ", email=" + email + ", rol=" + rol
                + ", AgendarCita=" + AgendarCita + ", CancelarCita=" + CancelarCita + ", ModificarCita=" + ModificarCita
                + ", ConsultarCita=" + ConsultarCita + ", RecordatoriosCita=" + RecordatoriosCita + ", AgregarPaciente="
                + AgregarPaciente + ", EliminarPaciente=" + EliminarPaciente + ", ModificarPaciente="
                + ModificarPaciente + ", ConsultarPaciente=" + ConsultarPaciente + ", HistorialClinico="
                + HistorialClinico + ", imprimirJustificante=" + imprimirJustificante + ", imprimirReceta="
                + imprimirReceta + "]";
    }

    

   

}
