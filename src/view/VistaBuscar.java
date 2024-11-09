package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VistaBuscar {
    public static JPanel getVistaBuscar(String[] columnas, String[] opcionesComboBox, String textButton,
            boolean botonRegistrarPaciente, ActionListener escuchaboton) {

        JFrame jf_Frame = new JFrame();
        jf_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf_Frame.setSize(800, 600);
        jf_Frame.setLocationRelativeTo(null);
        // VARIABLES
        JPanel jp_panel = new JPanel();
        JTextField jtf_busqueda = new JTextField();
        JButton jb_Buscar = new JButton("Buscar");
        JButton jb_botonPanel = new JButton(textButton);
        JButton jb_Aqui = new JButton("Aquí");
        JLabel jl_Aqui = new JLabel("<html>Si no encuentras al <br> paciente, registralo!</html>");

        Object[][] datos = {
                // { "Juan Pérez", "123456789", "juan@example.com","prueba" }
                // ,
                // { "Ana Gómez", "987654321", "ana@example.com" },
                // { "Luis Martínez", "456789123", "luis@example.com" },
                // { "Marta Sánchez", "321654987", "marta@example.com" },
                // { "Carlos Ruiz", "654321789", "carlos@example.com" },
                // { "Laura Torres", "789123456", "laura@example.com" },
                // { "Javier Fernández", "135792468", "javier@example.com" },
                // { "Patricia Díaz", "246813579", "patricia@example.com" },
                // { "Pedro López", "369258147", "pedro@example.com" },
                // { "Juan Pérez", "123456789", "juan@example.com" },
                // { "Ana Gómez", "987654321", "ana@example.com" },
                // { "Luis Martínez", "456789123", "luis@example.com" },
                // { "Marta Sánchez", "321654987", "marta@example.com" },
                // { "Carlos Ruiz", "654321789", "carlos@example.com" },
                // { "Laura Torres", "789123456", "laura@example.com" },
                // { "Javier Fernández", "135792468", "javier@example.com" },
                // { "Patricia Díaz", "246813579", "patricia@example.com" },
                // { "Pedro López", "369258147", "pedro@example.com" },
                // { "Juan Pérez", "123456789", "juan@example.com" },
                // { "Ana Gómez", "987654321", "ana@example.com" },
                // { "Luis Martínez", "456789123", "luis@example.com" },
                // { "Marta Sánchez", "321654987", "marta@example.com" },
                // { "Carlos Ruiz", "654321789", "carlos@example.com" },
                // { "Laura Torres", "789123456", "laura@example.com" },
                // { "Javier Fernández", "135792468", "javier@example.com" },
                // { "Patricia Díaz", "246813579", "patricia@example.com" },
                // { "Pedro López", "369258147", "pedro@example.com" },
                // { "Sofía Hernández", "147258369", "sofia@example.com" }
        };

        int renglones = 30;
        int colum = 4;
        datos = new Object[renglones][colum];
        for (int i = 0; i < renglones; i++) {
            for (int j = 0; j < colum; j++) {
                datos[i][j] = "texto de prueba";
            }
        }
      
        JTable tablaPacientes = new JTable(datos, columnas);
        JScrollPane scrollPane = new JScrollPane(tablaPacientes);
        // ATRIBUTOS
        jp_panel.setLayout(null);
        jp_panel.setBackground(new Color(173, 232, 244));

        jb_Buscar.setBackground(new Color(0, 150, 199));
        jb_Buscar.setForeground(Color.WHITE);
        jb_Buscar.setBounds(620, 30, 80, 30);

        jtf_busqueda.setBounds(30, 30, 430, 30);

        jb_botonPanel.setBackground(new Color(0, 150, 199));
        jb_botonPanel.setForeground(Color.WHITE);
        jb_botonPanel.setBounds(650, 250, 80, 30);

        JComboBox<String> comboBox = new JComboBox<>(opcionesComboBox);
        comboBox.setBounds(500, 30, 100, 30);

        scrollPane.setBounds(30, 100, 600, 400);

        jb_Aqui.setBounds(650, 400, 80, 30);
        jb_Aqui.setBackground(new Color(0, 150, 199));
        jb_Aqui.setForeground(Color.WHITE);

        jl_Aqui.setBounds(650, 350, 150, 30);
        // ARMADO
        jp_panel.add(jtf_busqueda);
        jp_panel.add(jb_Buscar);
        jp_panel.add(jb_botonPanel);
        jp_panel.add(comboBox);
        jp_panel.add(scrollPane);
        if (botonRegistrarPaciente) {
            jp_panel.add(jb_Aqui);
            jp_panel.add(jl_Aqui);
        }

        jf_Frame.add(jp_panel);
        // ESCUCHAS
        jb_botonPanel.addActionListener(escuchaboton);


        // MOSTRAR
        jf_Frame.setVisible(true);

        return jp_panel;
    }

    public static void main(String[] args) {
        String[] columnas = { "Nombre", "Telefono", "Correo", "Cita" };
        VistaBuscar.getVistaBuscar(columnas, columnas, "Eliminar", true, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

}
