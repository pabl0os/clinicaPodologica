package view.pacientes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controller.WindowMain;
import controller.Pacientes.controlPacientes;
import model.objects.Paciente.paciente;

import javax.swing.table.DefaultTableModel;

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

        Object[][] datos = new Object[0][0];

        DefaultTableModel model = new DefaultTableModel(datos, columnas);
        JTable tablaPacientes = new JTable(model);
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
        controlPacientes control = new controlPacientes();
        jb_botonPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tablaPacientes.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un paciente de la lista.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    String nombre = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 0);
                    String telefono = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 1);
                    String correo = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 2);
                    int respuesta = JOptionPane.showConfirmDialog(WindowMain.jf_ventanaPrincipal,
                            "¿Estas seguro de eliminar el paciente?\n" + //
                                    "Nombre: " + nombre + "\n" + //
                                    "Teléfono: " + telefono + "\n" + //
                                    "Correo: " + correo,
                            "Confimación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (respuesta == JOptionPane.OK_OPTION) {
                        if (control.eliminarPaciente(nombre, telefono, correo)) {
                            jl_textoinformativo.setText("<html>Se realizo correctamente <br>la eliminacion </html>");
                        }else{
                            jl_textoinformativo.setText("<html><span style='color:red;'>No se realizo correctamente la eliminación</span></html>");
                        }
                        jl_textoinformativo.setVisible(true);
                        Timer timer = new Timer(4000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                jl_textoinformativo.setVisible(false); // Ocultar el JLabel
                            }
                        });
                        timer.setRepeats(false);
                        timer.start();
                        jb_Buscar.doClick();
                    } else if (respuesta == JOptionPane.CANCEL_OPTION) {

                    }

                }
            }

        });

        jb_Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setDataVector(
                        control.consultarPacientes(jtf_busqueda.getText(), (String) comboBox.getSelectedItem()),
                        columnas);
            }

        });

        // MOSTRAR

        return jp_panel;
    }

    // MODIFICAR
    private static paciente pacienteModificar = new paciente();

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

        Object[][] datos = new Object[0][0];

        DefaultTableModel model = new DefaultTableModel(datos, columnas);
        JTable tablaPacientes = new JTable(model);
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
        controlPacientes control = new controlPacientes();
        jb_botonPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tablaPacientes.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un paciente de la lista.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    String nombre = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 0);
                    String telefono = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 1);
                    String correo = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 2);
                    int respuesta = JOptionPane.showConfirmDialog(WindowMain.jf_ventanaPrincipal,
                            "¿Estas seguro de eliminar el paciente?\n" + //
                                    "Nombre: " + nombre + "\n" + //
                                    "Teléfono: " + telefono + "\n" + //
                                    "Correo: " + correo,
                            "Confimación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (respuesta == JOptionPane.OK_OPTION) {
                        pacienteModificar.setName(nombre);
                        pacienteModificar.setPhoneNumber(telefono);
                        pacienteModificar.setEmail(correo);
                        WindowMain.quitarPanel();
                        WindowMain.jf_ventanaPrincipal.add(vistaAgregarModificar());
                    } else if (respuesta == JOptionPane.CANCEL_OPTION) {

                    }
                
                }
            }

        });

        jb_Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setDataVector(
                        control.consultarPacientes(jtf_busqueda.getText(), (String) comboBox.getSelectedItem()),
                        columnas);
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
        JTextField jtf_nombre = new JTextField(pacienteModificar.getName());
        JTextField jtf_Numero = new JTextField(pacienteModificar.getPhoneNumber());
        JTextField jtf_correo = new JTextField(pacienteModificar.getEmail());
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
        controlPacientes control = new controlPacientes();
        jb_Listo.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int respuesta = JOptionPane.showConfirmDialog(WindowMain.jf_ventanaPrincipal,
                                "¿Son correctos?\n" + //
                                        "Nombre: " + jtf_nombre.getText() + "\n" + //
                                        "Teléfono: " + jtf_Numero.getText() + "\n" + //
                                        "Correo: " + jtf_correo.getText(),
                                "Confimación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (respuesta == JOptionPane.OK_OPTION) {
                            WindowMain.quitarPanel();
                            if (control.modicarPaciente(pacienteModificar.getName(), pacienteModificar.getPhoneNumber(),
                                    pacienteModificar.getEmail(), jtf_nombre.getText(), jtf_Numero.getText(),
                                    jtf_correo.getText())) {
                                WindowMain.jf_ventanaPrincipal.add(vistaBuscarModificar(
                                        "<html>Se realizo correctamente <br>la modificacion </html>"));
                            } else {
                                WindowMain.jf_ventanaPrincipal
                                        .add(vistaBuscarModificar(
                                                "<html> <span style='color:red;'>No se realizo correctamente la modificacion</span></html>"));
                            }
                        } else if (respuesta == JOptionPane.CANCEL_OPTION) {

                        }
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
        String[] columnas = { "Nombre", "Telefono", "Correo" };
        String[] opcionesComboBox = columnas;
        JPanel jp_panel = new JPanel();
        JTextField jtf_busqueda = new JTextField();
        JButton jb_Buscar = new JButton("Buscar");

        Object[][] datos;

        int renglones = 0;
        int colum = 0;
        datos = new Object[renglones][colum];
        for (int i = 0; i < renglones; i++) {
            for (int j = 0; j < colum; j++) {
                datos[i][j] = "texto de prueba";
            }
        }

        DefaultTableModel model = new DefaultTableModel(datos, columnas);
        JTable tablaPacientes = new JTable(model);
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

        // ARMADO
        jp_panel.add(jtf_busqueda);
        jp_panel.add(jb_Buscar);
        jp_panel.add(jb_botonPanel);
        jp_panel.add(comboBox);
        jp_panel.add(scrollPane);

        // ESCUCHAS
        controlPacientes control = new controlPacientes();
        jb_botonPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(WindowMain.jf_ventanaPrincipal,
                        "Se te redigira al repositorio del historial clinico ¿Deseas continuar?");
            }

        });

        jb_Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setDataVector(
                        control.consultarPacientes(jtf_busqueda.getText(), (String) comboBox.getSelectedItem()),
                        columnas);
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
        JTextField jtf_nombre = new JTextField();
        JTextField jtf_Numero = new JTextField();
        // verifiar que sean puros numeros
        // jtf_Numero.addKeyListener(new KeyAdapter() {
        // @Override
        // public void keyTyped(KeyEvent e) {
        // char c = e.getKeyChar();
        // // Verifica si el carácter no es un dígito
        // if (!Character.isDigit(c)) {
        // e.consume(); // Ignora el carácter
        // }
        // }
        // });

        // verificar que sean puras letras
        // campoTexto.addKeyListener(new KeyAdapter() {
        // @Override
        // public void keyTyped(KeyEvent e) {
        // char c = e.getKeyChar();

        // // Verifica si el carácter es una letra o un espacio
        // if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
        // e.consume(); // Ignora el carácter
        // }

        // // Evita que el primer carácter sea un espacio
        // if (campoTexto.getText().isEmpty() && Character.isWhitespace(c)) {
        // e.consume();
        // }
        // }
        // });
        JTextField jtf_correo = new JTextField();
        JLabel jl_textoinformativo = new JLabel(texto);

        JLabel jl_correo = new JLabel("Correo");
        JLabel jl_nombre = new JLabel("Nombre");
        JLabel jl_Numero = new JLabel("Numero");

        // ATRIBUTOS
        jp_panel.setLayout(null);
        jp_panel.setBackground(new Color(173, 232, 244));

        panelIntermedio.setBounds(190, 100, 400, 300);
        panelIntermedio.setLayout(null);

        jtf_nombre.setBounds(130, 30, 140, 30);
        jl_nombre.setBounds(70, 30, 80, 30);
        jtf_Numero.setBounds(130, 100, 140, 30);
        jl_Numero.setBounds(70, 100, 80, 30);
        jtf_correo.setBounds(130, 170, 140, 30);
        jl_correo.setBounds(70, 170, 80, 30);
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
        panelIntermedio.add(jl_nombre);
        panelIntermedio.add(jl_Numero);
        panelIntermedio.add(jl_correo);
        jp_panel.add(jb_Listo);
        jp_panel.add(jl_textoinformativo);

        // ESCUCHAS
        jb_Listo.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int respuesta = JOptionPane.showConfirmDialog(WindowMain.jf_ventanaPrincipal,
                                "¿Son correctos?\n" + //
                                        "Nombre: " + jtf_nombre.getText() + "\n" + //
                                        "Teléfono: " + jtf_Numero.getText() + "\n" + //
                                        "Correo: " + jtf_correo.getText(),
                                "Confimación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (respuesta == JOptionPane.OK_OPTION) {
                            controlPacientes control = new controlPacientes();
                            if (control.agregarPaciente(jtf_nombre.getText(), jtf_Numero.getText(),
                                    jtf_correo.getText())) {
                                WindowMain.quitarPanel();
                                WindowMain.jf_ventanaPrincipal.add(vistaAgregar("<html>Se agrego correctamente <br> " +
                                        "<br></html>"));
                            } else {
                                WindowMain.quitarPanel();
                                WindowMain.jf_ventanaPrincipal.add(vistaAgregar("<html>" +
                                        " <span style='color:red;'>No se agrego correctamente</span></html>"));

                            }
                        }
                    }
                });

        // MOSTRAR
        return jp_panel;
    }
}
