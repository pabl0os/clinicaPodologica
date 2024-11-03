import java.time.LocalDate;
import java.time.DayOfWeek;

public class FechaUtil {

    public static String obtenerDiaDeLaSemana(int dia, int mes, int año) {
        // Crear una instancia de LocalDate con los valores proporcionados
        LocalDate fecha = LocalDate.of(año, mes, dia);

        // Obtener el día de la semana
        DayOfWeek diaDeLaSemana = fecha.getDayOfWeek();

        // Convertir el valor a texto en español (opcional)
        String nombreDia = diaDeLaSemana.name().toLowerCase(); // convierte el nombre al formato en minúsculas
        return nombreDia.substring(0, 1).toUpperCase() + nombreDia.substring(1); // Primera letra en mayúscula
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int dia = 1;
        int mes = 11;
        int año = 2024;
        String diaDeLaSemana = obtenerDiaDeLaSemana(dia, mes, año);
        System.out.println("La fecha " + dia + "/" + mes + "/" + año + " cae en " + diaDeLaSemana);
    }
}
