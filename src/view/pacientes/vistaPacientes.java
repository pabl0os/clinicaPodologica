package view.pacientes;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;


public class vistaPacientes {

    private static JButton jb_Listo = new JButton("Listo");
    private static JPanel jp_panel;

    public static JPanel vistaAgregar() {
        if (jp_panel == null) {

            // VARIABLES
            jp_panel = new JPanel();
            JPanel panelIntermedio = new JPanel();
            JTextField jtf_nombre = new JTextField("Nombre");
            JTextField jtf_Numero = new JTextField("Numero");
            JTextField jtf_correo = new JTextField("Correo");
            JButton jb_volver = new JButton("Volver");
            // ATRIBUTOS
            jp_panel.setLayout(null);
            jp_panel.setBackground(new Color(173, 232, 244));

            panelIntermedio.setBounds(190, 100, 400, 300);
            panelIntermedio.setLayout(null);

            jtf_nombre.setBounds(130, 30, 140, 30);
            jtf_Numero.setBounds(130, 100, 140, 30);
            jtf_correo.setBounds(130, 170, 140, 30);
            jb_Listo.setForeground(Color.WHITE);

            jb_Listo.setBackground(new Color(0, 150, 199));
            jb_Listo.setBounds(350, 450, 80, 30);

            jb_volver.setBackground(new Color(0, 150, 199));
            jb_volver.setForeground(Color.WHITE);
            jb_volver.setBounds(30, 30, 80, 30);

            // ARMADO
            jp_panel.add(panelIntermedio);
            panelIntermedio.add(jtf_nombre);
            panelIntermedio.add(jtf_Numero);
            panelIntermedio.add(jtf_correo);
            jp_panel.add(jb_Listo);
            jp_panel.add(jb_volver);
            // ESCUCHAS

            // MOSTRAR

        }
        return jp_panel;
    }

    public static void setListener(ActionListener escucha) {
        jb_Listo.addActionListener(escucha);
    }

}
