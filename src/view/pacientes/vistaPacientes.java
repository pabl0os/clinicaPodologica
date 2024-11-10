package view.pacientes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.WindowMain;
import controller.Pacientes.controlPacientes;

public class vistaPacientes {
    // ELIMINAR
    public static JPanel vistaBuscarEliminar() {

        // VARIABLES
        String textButton = "Eliminar";
        JButton jb_botonPanel = new JButton(textButton);
        JButton jb_atras = new JButton("Volver");
        String[] columnas = { "Nombre", "Telefono", "Correo" };
        String[] opcionesComboBox = columnas;
        JPanel jp_panel = new JPanel();
        JTextField jtf_busqueda = new JTextField();
        JButton jb_Buscar = new JButton("Buscar");
        String texto = "<html>Se realizo correctamente <br>la eliminacion " +
                "<br>" +
                " <span style='color:red;'>No se realizo correctamente la eliminacion</span></html>";
        JLabel jl_textoinformativo = new JLabel(texto);

        Object[][] datos = {
            {"Ana Pérez", "555-1234", "ana.perez@example.com"},
            {"Carlos López", "555-5678", "carlos.lopez@example.com"},
            {"María Gómez", "555-9101", "maria.gomez@example.com"},
            {"Luis Torres", "555-1122", "luis.torres@example.com"},
            {"Sofía Castro", "555-3344", "sofia.castro@example.com"},
            {"Pedro Mendoza", "555-5566", "pedro.mendoza@example.com"},
            {"Lucía Fernández", "555-7788", "lucia.fernandez@example.com"},
            {"Jorge Díaz", "555-9900", "jorge.diaz@example.com"},
            {"Elena Ríos", "555-2233", "elena.rios@example.com"},
            {"Ana Pérez", "555-1234", "ana.perez@example.com"},
            {"Carlos López", "555-5678", "carlos.lopez@example.com"},
            {"María Gómez", "555-9101", "maria.gomez@example.com"},
            {"Luis Torres", "555-1122", "luis.torres@example.com"},
            {"Sofía Castro", "555-3344", "sofia.castro@example.com"},
            {"Pedro Mendoza", "555-5566", "pedro.mendoza@example.com"},
            {"Lucía Fernández", "555-7788", "lucia.fernandez@example.com"},
            {"Jorge Díaz", "555-9900", "jorge.diaz@example.com"},
            {"Elena Ríos", "555-2233", "elena.rios@example.com"},
            {"Ana Pérez", "555-1234", "ana.perez@example.com"},
            {"Carlos López", "555-5678", "carlos.lopez@example.com"},
            {"María Gómez", "555-9101", "maria.gomez@example.com"},
            {"Luis Torres", "555-1122", "luis.torres@example.com"},
            {"Sofía Castro", "555-3344", "sofia.castro@example.com"},
            {"Pedro Mendoza", "555-5566", "pedro.mendoza@example.com"},
            {"Lucía Fernández", "555-7788", "lucia.fernandez@example.com"},
            {"Jorge Díaz", "555-9900", "jorge.diaz@example.com"},
            {"Elena Ríos", "555-2233", "elena.rios@example.com"},
            {"Fernando Ortiz", "555-4455", "fernando.ortiz@example.com"}
        };
        

        JTable tablaPacientes = new JTable(datos, columnas);
        JScrollPane scrollPane = new JScrollPane(tablaPacientes);
        // ATRIBUTOS
        jp_panel.setLayout(null);
        jp_panel.setBackground(new Color(173, 232, 244));

        jb_Buscar.setBackground(new Color(0, 150, 199));
        jb_Buscar.setForeground(Color.WHITE);
        jb_Buscar.setBounds(620, 80, 80, 30);

        jtf_busqueda.setBounds(30, 80, 430, 30);

        jb_botonPanel.setBackground(new Color(0, 150, 199));
        jb_botonPanel.setForeground(Color.WHITE);
        jb_botonPanel.setBounds(650, 250, 110, 50);

        JComboBox<String> comboBox = new JComboBox<>(opcionesComboBox);
        comboBox.setBounds(500, 80, 100, 30);

        scrollPane.setBounds(30, 150, 550, 350);

        jb_atras.setBounds(30, 20, 80, 30);
        jb_atras.setBackground(new Color(0, 150, 199));
        jb_atras.setForeground(Color.WHITE);

        jl_textoinformativo.setBounds(600, 350, 200, 200);
        jl_textoinformativo.setVisible(false);
        // ARMADO
        jp_panel.add(jtf_busqueda);
        jp_panel.add(jb_Buscar);
        jp_panel.add(jb_botonPanel);
        jp_panel.add(comboBox);
        jp_panel.add(scrollPane);
        jp_panel.add(jl_textoinformativo);

        // ESCUCHAS
        jb_botonPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tablaPacientes.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un paciente de la lista.", 
                                                  "Advertencia", JOptionPane.WARNING_MESSAGE);
                }else{
                    String nombre = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 0);
                    String telefono = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 1);
                    String correo = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 2);
                    int respuesta = JOptionPane.showConfirmDialog(WindowMain.jf_ventanaPrincipal,
                    "¿Estas seguro de eliminar el paciente?\n" + //
                    "Nombre: "+nombre+"\n" + //
                    "Teléfono: "+telefono+"\n" + //
                    "Correo: "+correo,"Confimación",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

                    if (respuesta == JOptionPane.OK_OPTION) {
                        controlPacientes control = new controlPacientes();
                    
                        jl_textoinformativo.setVisible(true);
                        Timer timer = new Timer(4000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                jl_textoinformativo.setVisible(false); // Ocultar el JLabel
                            }
                        });
                        timer.setRepeats(false);
                        timer.start();
                    } else if (respuesta == JOptionPane.CANCEL_OPTION) {
                        
                    }
                   
                }
            }

        });

        jb_Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
            
        });

        // MOSTRAR

        return jp_panel;
    }

    // MODIFICAR
    public static JPanel vistaBuscarModificar(String texto) {

        // VARIABLES
        String textButton = "Modificar";
        JButton jb_botonPanel = new JButton(textButton);
        JButton jb_atras = new JButton("Volver");
        String[] columnas = { "Nombre", "Telefono", "Correo" };
        String[] opcionesComboBox = columnas;
        JPanel jp_panel = new JPanel();
        JTextField jtf_busqueda = new JTextField();
        JButton jb_Buscar = new JButton("Buscar");
        JLabel jl_textoinformativo = new JLabel(texto);

       
        Object[][] datos = {
            {"Ana Pérez", "555-1234", "ana.perez@example.com"},
            {"Carlos López", "555-5678", "carlos.lopez@example.com"},
            {"María Gómez", "555-9101", "maria.gomez@example.com"},
            {"Luis Torres", "555-1122", "luis.torres@example.com"},
            {"Sofía Castro", "555-3344", "sofia.castro@example.com"},
            {"Pedro Mendoza", "555-5566", "pedro.mendoza@example.com"},
            {"Lucía Fernández", "555-7788", "lucia.fernandez@example.com"},
            {"Jorge Díaz", "555-9900", "jorge.diaz@example.com"},
            {"Elena Ríos", "555-2233", "elena.rios@example.com"},
            {"Ana Pérez", "555-1234", "ana.perez@example.com"},
            {"Carlos López", "555-5678", "carlos.lopez@example.com"},
            {"María Gómez", "555-9101", "maria.gomez@example.com"},
            {"Luis Torres", "555-1122", "luis.torres@example.com"},
            {"Sofía Castro", "555-3344", "sofia.castro@example.com"},
            {"Pedro Mendoza", "555-5566", "pedro.mendoza@example.com"},
            {"Lucía Fernández", "555-7788", "lucia.fernandez@example.com"},
            {"Jorge Díaz", "555-9900", "jorge.diaz@example.com"},
            {"Elena Ríos", "555-2233", "elena.rios@example.com"},
            {"Ana Pérez", "555-1234", "ana.perez@example.com"},
            {"Carlos López", "555-5678", "carlos.lopez@example.com"},
            {"María Gómez", "555-9101", "maria.gomez@example.com"},
            {"Luis Torres", "555-1122", "luis.torres@example.com"},
            {"Sofía Castro", "555-3344", "sofia.castro@example.com"},
            {"Pedro Mendoza", "555-5566", "pedro.mendoza@example.com"},
            {"Lucía Fernández", "555-7788", "lucia.fernandez@example.com"},
            {"Jorge Díaz", "555-9900", "jorge.diaz@example.com"},
            {"Elena Ríos", "555-2233", "elena.rios@example.com"},
            {"Fernando Ortiz", "555-4455", "fernando.ortiz@example.com"}
        };
        
        JTable tablaPacientes = new JTable(datos, columnas);
        JScrollPane scrollPane = new JScrollPane(tablaPacientes);
        // ATRIBUTOS
        jp_panel.setLayout(null);
        jp_panel.setBackground(new Color(173, 232, 244));

        jb_Buscar.setBackground(new Color(0, 150, 199));
        jb_Buscar.setForeground(Color.WHITE);
        jb_Buscar.setBounds(620, 80, 80, 30);

        jtf_busqueda.setBounds(30, 80, 430, 30);

        jb_botonPanel.setBackground(new Color(0, 150, 199));
        jb_botonPanel.setForeground(Color.WHITE);
        jb_botonPanel.setBounds(650, 250, 110, 50);

        JComboBox<String> comboBox = new JComboBox<>(opcionesComboBox);
        comboBox.setBounds(500, 80, 100, 30);

        scrollPane.setBounds(30, 150, 550, 350);

        jb_atras.setBounds(30, 20, 80, 30);
        jb_atras.setBackground(new Color(0, 150, 199));
        jb_atras.setForeground(Color.WHITE);

        jl_textoinformativo.setBounds(600, 350, 200, 200);
        jl_textoinformativo.setVisible(true);

        Timer timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jl_textoinformativo.setVisible(false); // Ocultar el JLabel
            }
        });

        // Configurar el Timer para que solo ejecute la acción una vez
        timer.setRepeats(false);

        // Iniciar el Timer
        timer.start();

        // ARMADO
        jp_panel.add(jtf_busqueda);
        jp_panel.add(jb_Buscar);
        jp_panel.add(jb_botonPanel);
        jp_panel.add(comboBox);
        jp_panel.add(scrollPane);
        jp_panel.add(jl_textoinformativo);

        // ESCUCHAS
        jb_botonPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tablaPacientes.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un paciente de la lista.", 
                                                  "Advertencia", JOptionPane.WARNING_MESSAGE);
                }else{
                    String nombre = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 0);
                    String telefono = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 1);
                    String correo = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 2);
                    int respuesta = JOptionPane.showConfirmDialog(WindowMain.jf_ventanaPrincipal,
                    "¿Estas seguro de eliminar el paciente?\n" + //
                    "Nombre: "+nombre+"\n" + //
                    "Teléfono: "+telefono+"\n" + //
                    "Correo: "+correo,"Confimación",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

                    if (respuesta == JOptionPane.OK_OPTION) {
                        WindowMain.quitarPanel();
                        WindowMain.jf_ventanaPrincipal.add(vistaAgregarModificar());
                    } else if (respuesta == JOptionPane.CANCEL_OPTION) {
                        
                    }
                }
            }

        });

        // MOSTRAR

        return jp_panel;
    }

    private static JPanel vistaAgregarModificar() {
        // VARIABLES
        JButton jb_Listo = new JButton("Listo");
        JButton jb_volver = new JButton("Volver");
        JPanel jp_panel;
        jp_panel = new JPanel();
        JPanel panelIntermedio = new JPanel();
        JTextField jtf_nombre = new JTextField("Nombre");
        JTextField jtf_Numero = new JTextField("Numero");
        JTextField jtf_correo = new JTextField("Correo");
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
        jb_Listo.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(WindowMain.jf_ventanaPrincipal, "¿Son correctos?\n" + //
                                "nombre\n" + //
                                "telefono \n" + //
                                "correo");
                        WindowMain.quitarPanel();
                        WindowMain.jf_ventanaPrincipal
                                .add(vistaBuscarModificar("<html>Se realizo correctamente <br>la modificacion " +
                                        "<br>" +
                                        " <span style='color:red;'>No se realizo correctamente la modificacion</span></html>"));
                    }

                });

        jb_volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowMain.quitarPanel();
                WindowMain.jf_ventanaPrincipal.add(vistaBuscarModificar(""));
            }
        });
        // MOSTRAR
        return jp_panel;
    }

    // CONSULTAR
    public static JPanel vistaBuscarConsultar() {

        // VARIABLES
        String textButton = "Consultar";
        JButton jb_botonPanel = new JButton(textButton);
        JButton jb_atras = new JButton("Volver");
        String[] columnas = { "Nombre", "Telefono", "Correo" };
        String[] opcionesComboBox = columnas;
        JPanel jp_panel = new JPanel();
        JTextField jtf_busqueda = new JTextField();
        JButton jb_Buscar = new JButton("Buscar");

        Object[][] datos;

        int renglones = 30;
        int colum = columnas.length;
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
        jb_Buscar.setBounds(620, 80, 80, 30);

        jtf_busqueda.setBounds(30, 80, 430, 30);

        jb_botonPanel.setBackground(new Color(0, 150, 199));
        jb_botonPanel.setForeground(Color.WHITE);
        jb_botonPanel.setBounds(650, 250, 110, 50);

        JComboBox<String> comboBox = new JComboBox<>(opcionesComboBox);
        comboBox.setBounds(500, 80, 100, 30);

        scrollPane.setBounds(30, 150, 550, 350);

        jb_atras.setBounds(30, 20, 80, 30);
        jb_atras.setBackground(new Color(0, 150, 199));
        jb_atras.setForeground(Color.WHITE);

        // ARMADO
        jp_panel.add(jtf_busqueda);
        jp_panel.add(jb_Buscar);
        jp_panel.add(jb_botonPanel);
        jp_panel.add(comboBox);
        jp_panel.add(scrollPane);

        // ESCUCHAS
        jb_botonPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(WindowMain.jf_ventanaPrincipal,
                        "Se te redigira al repositorio del historial clinico ¿Deseas continuar?");
            }

        });

        // MOSTRAR

        return jp_panel;
    }

    // AGREGAR
    public static JPanel vistaAgregar(String texto) {
        // VARIABLES
        JButton jb_Listo = new JButton("Listo");
        JPanel jp_panel;
        jp_panel = new JPanel();
        JPanel panelIntermedio = new JPanel();
        JTextField jtf_nombre = new JTextField("Nombre");
        JTextField jtf_Numero = new JTextField("Numero");
        JTextField jtf_correo = new JTextField("Correo");
        JLabel jl_textoinformativo = new JLabel(texto);

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

        jl_textoinformativo.setBounds(600, 350, 200, 200);
        jl_textoinformativo.setVisible(true);
  
        Timer timer = new Timer(4000, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent evt) {
              jl_textoinformativo.setVisible(false); // Ocultar el JLabel
           }
        });
  
        // Configurar el Timer para que solo ejecute la acción una vez
        timer.setRepeats(false);
  
        // Iniciar el Timer
        timer.start();

        // ARMADO
        jp_panel.add(panelIntermedio);
        panelIntermedio.add(jtf_nombre);
        panelIntermedio.add(jtf_Numero);
        panelIntermedio.add(jtf_correo);
        jp_panel.add(jb_Listo);
        jp_panel.add(jl_textoinformativo);


        // ESCUCHAS
        jb_Listo.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(WindowMain.jf_ventanaPrincipal, "¿Son correctos?\n" + //
                                "nombre\n" + //
                                "telefono \n" + //
                                "correo");
                        WindowMain.quitarPanel();
                        WindowMain.jf_ventanaPrincipal.add(vistaAgregar("<html>Se agrego correctamente <br> " +
                        "<br>" +
                        " <span style='color:red;'>No se agrego correctamente</span></html>"));
                    }

                });

        // MOSTRAR
        return jp_panel;
    }
}
