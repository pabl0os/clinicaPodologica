package correo_Contraseña.Controlador;

import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import correo_Contraseña.Modelo.ModelRecoverPass;

public class ControlRecoverPass {
    private String correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void CrearContraseñaTemporal(String correo) {
        ModelRecoverPass model = new ModelRecoverPass();
        try {
            String contra = model.gResultSet(correo).getString("Contraseña");
            EnviarContraseñaAlCorreo(contra, correo);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se encontro el correo");
        }
    }

    private void EnviarContraseñaAlCorreo(String mensaje, String correo) {
        // Configuraciones de la cuenta y del servidor SMTP
        String host = "smtp.gmail.com";
        final String username = "monrealcarlos71@gmail.com"; // Tu correo de Gmail
        final String password = "ybmv onrw gvjb wqdg"; // Tu contraseña de Gmail

        // Propiedades para la conexión con el servidor SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Habilitar TLS

        // Crear el objeto de autenticación (Authenticator)
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        // Obtener la sesión con la autenticación
        Session session = Session.getInstance(properties, auth);

        try {
            // Crear el objeto MimeMessage
            Message message = new MimeMessage(session);

            // Establecer el remitente
            message.setFrom(new InternetAddress(username));

            // Establecer el destinatario
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));

            // Establecer el asunto
            message.setSubject("Recuperacion de Contraseña");

            // Establecer el contenido del correo
            message.setText("Contraseña: " + mensaje);

            // Enviar el mensaje
            Transport.send(message);

            System.out.println("Correo enviado exitosamente.");
            

        } catch (MessagingException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ControlRecoverPass control = new ControlRecoverPass();
        String correo = "pablinchus12@gmail.com";
        String mensaje = "";
        control.EnviarContraseñaAlCorreo(mensaje, correo);
    }

}
