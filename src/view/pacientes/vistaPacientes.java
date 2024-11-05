package view.pacientes;

import java.awt.*;
import javax.swing.*;

public class vistaPacientes {
    public static void main(String[] args) {
        vistaPacientes k = new vistaPacientes();
        k.vistaAgregar();
        // k.vistaEliminar();
    }

    public void vistaAgregar() {
        JFrame jf_Frame = new JFrame();
        jf_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf_Frame.setSize(800, 600);
        jf_Frame.setLocationRelativeTo(null);
        jf_Frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173, 232, 244));
        jf_Frame.add(panel);

        JPanel panelIntermedio = new JPanel();
        panelIntermedio.setBounds(190, 100, 400, 400);
        panelIntermedio.setLayout(null);
        panel.add(panelIntermedio);

        JTextField jtf_nombre = new JTextField("Nombre");
        jtf_nombre.setBounds(130, 30, 140, 30);
        panelIntermedio.add(jtf_nombre);

        JTextField jtf_Numero = new JTextField("Numero");
        jtf_Numero.setBounds(130, 100, 140, 30);
        panelIntermedio.add(jtf_Numero);

        JTextField jtf_correo = new JTextField("Correo");
        jtf_correo.setBounds(130, 170, 140, 30);
        panelIntermedio.add(jtf_correo);


        JButton jb_Listo = new JButton("Listo");
        jb_Listo.setBackground(new Color(0, 150, 199));
        jb_Listo.setForeground(Color.WHITE);
        jb_Listo.setBounds(350 , 510, 80, 30);
        panel.add(jb_Listo);

        JButton jb_volver = new JButton("Volver");
        jb_volver.setBackground(new Color(0, 150, 199));
        jb_volver.setForeground(Color.WHITE);
        jb_volver.setBounds(30, 30, 80, 30);
        panel.add(jb_volver);

        jf_Frame.repaint();
        jf_Frame.revalidate();
    }

    public void vistaEliminar() {
        JFrame jf_Frame = new JFrame();
        jf_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf_Frame.setSize(800, 600);
        jf_Frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173, 232, 244));

        JTextField jtf_busqueda = new JTextField();
        jtf_busqueda.setBounds(30, 30, 430, 30);
        panel.add(jtf_busqueda);

        JButton jb_ButtonBuscar = new JButton("Buscar");
        jb_ButtonBuscar.setBackground(new Color(0, 150, 199));
        jb_ButtonBuscar.setForeground(Color.WHITE);
        jb_ButtonBuscar.setBounds(620, 30, 80, 30);
        panel.add(jb_ButtonBuscar);

        JButton jb_ButtonEliminar = new JButton("Eliminar");
        jb_ButtonEliminar.setBackground(new Color(0, 150, 199));
        jb_ButtonEliminar.setForeground(Color.WHITE);
        jb_ButtonEliminar.setBounds(650, 350, 80, 30);
        panel.add(jb_ButtonEliminar);

        String[] opciones = { "Nombre","Correo", "Teléfono" };
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(500, 30, 100, 30);
        panel.add(comboBox);

        String[] columnas = { "Nombre", "Teléfono", "Correo" };
        Object[][] datos = {
                { "Juan Pérez", "123456789", "juan@example.com" },
                { "Ana Gómez", "987654321", "ana@example.com" },
                { "Luis Martínez", "456789123", "luis@example.com" },
                { "Marta Sánchez", "321654987", "marta@example.com" },
                { "Carlos Ruiz", "654321789", "carlos@example.com" },
                { "Laura Torres", "789123456", "laura@example.com" },
                { "Javier Fernández", "135792468", "javier@example.com" },
                { "Patricia Díaz", "246813579", "patricia@example.com" },
                { "Pedro López", "369258147", "pedro@example.com" },
                { "Juan Pérez", "123456789", "juan@example.com" },
                { "Ana Gómez", "987654321", "ana@example.com" },
                { "Luis Martínez", "456789123", "luis@example.com" },
                { "Marta Sánchez", "321654987", "marta@example.com" },
                { "Carlos Ruiz", "654321789", "carlos@example.com" },
                { "Laura Torres", "789123456", "laura@example.com" },
                { "Javier Fernández", "135792468", "javier@example.com" },
                { "Patricia Díaz", "246813579", "patricia@example.com" },
                { "Pedro López", "369258147", "pedro@example.com" },
                { "Juan Pérez", "123456789", "juan@example.com" },
                { "Ana Gómez", "987654321", "ana@example.com" },
                { "Luis Martínez", "456789123", "luis@example.com" },
                { "Marta Sánchez", "321654987", "marta@example.com" },
                { "Carlos Ruiz", "654321789", "carlos@example.com" },
                { "Laura Torres", "789123456", "laura@example.com" },
                { "Javier Fernández", "135792468", "javier@example.com" },
                { "Patricia Díaz", "246813579", "patricia@example.com" },
                { "Pedro López", "369258147", "pedro@example.com" },
                { "Sofía Hernández", "147258369", "sofia@example.com" }
        };

        JTable tablaPacientes = new JTable(datos, columnas);
        JScrollPane scrollPane = new JScrollPane(tablaPacientes);
        scrollPane.setBounds(30, 100, 600, 400);
        panel.add(scrollPane);

        jf_Frame.add(panel);
        jf_Frame.setVisible(true);

    }
}
