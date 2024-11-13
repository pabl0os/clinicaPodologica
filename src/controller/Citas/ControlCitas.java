package controller.Citas;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import model.dataBase.Citas.ConsultasCitas;
import model.objects.Citas.Cita;
import model.objects.Paciente.paciente;


public class ControlCitas {
    private ConsultasCitas consultaCitas;
    public ControlCitas (){
        consultaCitas = new ConsultasCitas();
    }

    //Agendar
    public void AgendarCita(String datos){
        consultaCitas.gResultSet("Insert into CITAS values( "+datos+");");
    }

    //Cancelar
    public void CancelarCita(String nombreColumna,String datoAbuscar){
        String idPaciente=""+consultaCitas.gResultSet("Select IDPaciente from PACIENTE where "+nombreColumna+"= '"+datoAbuscar+"'");
        consultaCitas.gResultSet("Delete from CITAS where IDPaciente ="+idPaciente);
    }
   
    //Modificar
    public void ModificarCita(String nombreColumna,String datoABuscar,String fechaCita,String horarioCita){
        String idPaciente=""+consultaCitas.gResultSet("Select IDPaciente from PACIENTE where" + nombreColumna+"= '"+datoABuscar+"'");
        consultaCitas.gResultSet("UPDATE CITA" +
                        "SET FechaCita = '"+fechaCita+"',"+
                        "SET HorarioCita= '"+horarioCita+"',"+
                        "WHERE IDPaciente = "+idPaciente);
    }

    
    //Consultar
    public Object[][] ConsultaGeneralCita(){
        Object[][] datos=null;
        ArrayList<paciente> datospaciente = new ArrayList<>();
        ArrayList<Cita> datosCita = new ArrayList<>();
        // paciente paciente = new paciente(0, null, 0, null, null)
        try {
            consultaCitas.OpenConeccionDataBase();
            ResultSet resultado = consultaCitas.gResultSet("Select P.NombreCompleto, P.Telefono,P.Correo_electronico,C.FechaCita,C.HorarioCita\n"+
                                "from PACIENTE P \n" + 
                                "inner Join CITA C on P.IDPaciente = C.IDPaciente");
                        

            int contador=0;
            // datos = new Object[10][4];
                while (resultado.next()) {
                    String nombreP = resultado.getString("NombreCompleto");
                    String telefono = resultado.getString("Telefono");
                    String correo = resultado.getString("Correo_electronico");
                    Date fechaCita = resultado.getDate("FechaCita");
                    Time horarioCita = resultado.getTime("HorarioCita");
                    String cita = ""+horarioCita+"  "+fechaCita;
                    

                    // datos[contador][0] = nombreP;
                    // datos[contador][1] = telefono;
                    // datos[contador][2] = correo;
                    // datos[contador][3] = cita;
                    contador++;
                }
        } catch (SQLException e) {
            System.err.println("Error: "+e.getMessage());
            return null;
        }
        consultaCitas.CloseConneccionDataBase();
        return datos;
    }

    public Object[][] ConsultaIndividuallCita(String datoAbuscar,String columName){
        Object[][] datos;
        try {
            ResultSet resultado = consultaCitas.gResultSet("Select P.NombreCompleto, P.Telefono,P.Correo_electronico,C.FechaCita,C.HorarioCita\n"+
                                "from PACIENTES P \n" + 
                                "inner Join CITA C on PACIENTE, P.IDPaciente = C.IDPaciente \n"+
                                "where "+columName+" = "+datoAbuscar);
            
            datos = new Object[resultado.getRow()][4];
            int contador =0;
            if (resultado!=null) {
                while (resultado.next()) {
                    String nombreP = resultado.getString("NombreCompleto");
                    String telefono = resultado.getString("Telefono");
                    String correo = resultado.getString("Correo_electronico");
                    Date fechaCita = resultado.getDate("FechaCita");
                    Time horarioCita = resultado.getTime("HorarioCita");
                    String cita = ""+fechaCita+""+horarioCita;
                    datos[contador][0] = nombreP;
                    datos[contador][1] = telefono;
                    datos[contador][2] = correo;
                    datos[contador][3] = cita;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: "+e.getMessage());
            return null;
        }
        return datos;
    }

    //Recordatorios
    public Object[][] Recordatorios(){
        Object [][] datosRecordatorio;
        
        ResultSet resultado = consultaCitas.gResultSet("SELECT P.NombreCompleto, P.Telefono, C.HorarioCita, C.Recuerdo, C.Confirmacion\n"+
                        "FROM PACIENTES P \n"+
                        "INNER JOIN CITA C ON P.IDPaciente = C.IDPaciente;");
        
        if (resultado!=null) {
            try {
                int renglones = resultado.getRow();
                datosRecordatorio = new String[renglones][5];
                renglones = 0;
                while (resultado.next()) {
                    String nombreP = resultado.getString("P.NombreCompleto");
                    String telefonoP = resultado.getString("P.Telefono");
                    Time horarioCita = resultado.getTime("C.HorarioCita");
                    boolean recuerdo = resultado.getBoolean("Recuerdo");
                    boolean confirmacion = resultado.getBoolean("Confirmacion");
                    datosRecordatorio[renglones][0] = nombreP;
                    datosRecordatorio[renglones][1] = telefonoP;
                    datosRecordatorio[renglones][2] = horarioCita;
                    datosRecordatorio[renglones][3] = recuerdo;
                    datosRecordatorio[renglones][4] = confirmacion;
                    renglones++;                    
                }
            } catch (SQLException e) {
                System.err.println("Error: "+e.getMessage());
                datosRecordatorio = null;
            }
           
            return datosRecordatorio; 
        } 
        else { return null;}
    }



}

