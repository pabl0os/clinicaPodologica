package model.objects.Paciente;


public class paciente {
    private int IDPaciente;
    private String name;
    private String phoneNumber;
    private String email;
    private String Enlace;
 
    public paciente(int iDPaciente, String name, String phoneNumber, String email, String enlace) {
        IDPaciente = iDPaciente;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        Enlace = enlace;
    }

    

    public paciente() {
    }



    public int getIDPaciente() {
        return IDPaciente;
    }
    public void setIDPaciente(int iDPaciente) {
        IDPaciente = iDPaciente;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEnlace() {
        return Enlace;
    }
    public void setEnlace(String enlace) {
        Enlace = enlace;
    }

    @Override
    public String toString() {
        return "paciente [IDPaciente=" + IDPaciente + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email="
                + email + ", Enlace=" + Enlace + "]";
    }

    

    

}
