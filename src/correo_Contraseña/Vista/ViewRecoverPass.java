package correo_Contraseña.Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import correo_Contraseña.Controlador.ControlRecoverPass;

public class ViewRecoverPass {

    public static JPanel vistaRecuperarContraseña() {
        // Variable
        JPanel jp_vistaRecuperarContra = new JPanel(null);
        JLabel jl_etiqueta = new JLabel("Ingresal el correo del que desee recuperar su contraseña");
        JButton jb_volver = new JButton("Volver");
        JTextField jtf_correo = new JTextField();
        JButton jb_enviar = new JButton("Enviar");
        JLabel jl_correoIncorrecto = new JLabel("Correo no existe o esta incorrecto");
        // Atributos
        jp_vistaRecuperarContra.setBounds(0, 0, 800, 600);
        jp_vistaRecuperarContra.setBackground(new Color(173, 232, 244));

        jl_etiqueta.setBounds(100, 100, 600, 50);
        jl_etiqueta.setFont(new Font("Arial", Font.ITALIC, 22));

        jl_correoIncorrecto.setVisible(false);
        jl_correoIncorrecto.setBounds(235, 350, 600, 50);
        jl_correoIncorrecto.setFont(new Font("Arial", Font.ITALIC, 22));
        jl_correoIncorrecto.setForeground(Color.red);

        jb_volver.setBounds(20, 20, 100, 40);
        jtf_correo.setBounds(100, 170, 600, 40);
        jb_enviar.setBounds(325, 250, 150, 50);
        jb_enviar.setFont(new Font("Arial", Font.ITALIC, 24));
        // Armado
        jp_vistaRecuperarContra.add(jl_etiqueta);
        jp_vistaRecuperarContra.add(jb_volver);
        jp_vistaRecuperarContra.add(jtf_correo);
        jp_vistaRecuperarContra.add(jb_enviar);
        jp_vistaRecuperarContra.add(jl_correoIncorrecto);
        // Escuchas
        jb_enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf_correo.getText().equals("") || jtf_correo.getText().equals(null)) {
                    jl_correoIncorrecto.setVisible(true);
                } else {
                    ControlRecoverPass control = new ControlRecoverPass();
                    control.CrearContraseñaTemporal(jtf_correo.getText());

                }
            }
        });

        return jp_vistaRecuperarContra;
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.add(vistaRecuperarContraseña());
        ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }

}
