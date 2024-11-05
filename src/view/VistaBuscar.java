package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VistaBuscar {
    private static JButton jb_botonPanel;
    public static JPanel getVistaBuscar(String[] columnas, String[] opcionesComboBox, String textButton,
    boolean botonRegistrarPaciente) {
        
        // VARIABLES
        jb_botonPanel = new JButton(textButton);
        JPanel jp_panel = new JPanel();
        JTextField jtf_busqueda = new JTextField();
        JButton jb_Buscar = new JButton("Buscar");
        JButton jb_Aqui = new JButton("Aquí");
        JLabel jl_Aqui = new JLabel("<html>Si no encuentras al <br> paciente, registralo!</html>");

        Object[][] datos; 

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
        jb_botonPanel.setBounds(650, 250, 110, 50);

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

        // ESCUCHAS
        jb_Aqui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
            
        });
        
        // MOSTRAR
        
        return jp_panel;
    }
    public static void setEscucha(ActionListener escuchaBotton){
        jb_botonPanel.addActionListener(escuchaBotton);
    }

}
