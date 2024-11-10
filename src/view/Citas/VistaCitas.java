package view.Citas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.border.BevelBorder;

import controller.WindowMain;
import database.coneccionDataBase;

public class VistaCitas {

    // -------------Inicio----------------------------//

    // AGENDAR
    public static JPanel getVistaBuscarAgendar() {
        // VARIABLES
        JButton jb_botonPanel = new JButton("Agendar");
        JButton jb_atras = new JButton("Volver");
        String[] columnas = { "Nombre", "Telefono", "Correo" };
        String[] opcionesComboBox = columnas;
        JPanel jp_panel = new JPanel();
        JTextField jtf_busqueda = new JTextField();
        JButton jb_Buscar = new JButton("Buscar");
        JButton jb_Aqui = new JButton("Aquí");
        JLabel jl_Aqui = new JLabel("<html>Si no encuentras al <br> paciente, registralo!</html>");

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

        scrollPane.setBounds(30, 150, 600, 350);

        jb_Aqui.setBounds(650, 400, 80, 30);
        jb_Aqui.setBackground(new Color(0, 150, 199));
        jb_Aqui.setForeground(Color.WHITE);

        jl_Aqui.setBounds(650, 350, 150, 30);

        jb_atras.setBounds(30, 20, 80, 30);
        jb_atras.setBackground(new Color(0, 150, 199));
        jb_atras.setForeground(Color.WHITE);

        // ARMADO
        jp_panel.add(jtf_busqueda);
        jp_panel.add(jb_Buscar);
        jp_panel.add(jb_botonPanel);
        jp_panel.add(comboBox);
        jp_panel.add(scrollPane);
        jp_panel.add(jb_Aqui);
        jp_panel.add(jl_Aqui);
        jp_panel.add(jb_atras);
        jp_panel.remove(jb_atras);

        // ESCUCHAS
        jb_Aqui.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                WindowMain.quitarPanel();
                WindowMain.jf_ventanaPrincipal.add(vistaAgregarAgendar(""));
            }
        });

        jb_botonPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowMain.quitarPanel();
                WindowMain.jf_ventanaPrincipal.add(VistaFechaAgendar(VistaCitas.vistaCalendarioAgendar(0, 0)));
            }

        });

        // MOSTRAR

        return jp_panel;
    }

    private static JPanel vistaAgregarAgendar(String texto) {
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

        // ARMADO
        jp_panel.add(panelIntermedio);
        panelIntermedio.add(jtf_nombre);
        panelIntermedio.add(jtf_Numero);
        panelIntermedio.add(jtf_correo);
        jp_panel.add(jb_Listo);
        jp_panel.add(jl_textoinformativo);

        // ESCUCHAS
        jb_Listo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                WindowMain.quitarPanel();
                WindowMain.jf_ventanaPrincipal.add(VistaFechaAgendar(VistaCitas.vistaCalendarioAgendar(0, 0)));
            }

        });

        // MOSTRAR
        return jp_panel;
    }

    private static JPanel vistaCalendarioAgendar(int año, int mes) {
        // Variables
        JPanel jp_vistaCalendario = new JPanel();
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicialMes = LocalDate.of(fechaActual.getYear() + año, fechaActual.getMonthValue() + mes, 1);
        JButton[][] jb_DiasMes = new JButton[6][7];
        GridLayout estructura = new GridLayout(7, 7);
        String[] diasSemanaTexto = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };
        JLabel[] jl_diasSemanaColumnas = new JLabel[7];
        int diasEnElMes = fechaInicialMes.lengthOfMonth();
        int contadorSemanas = 0;
        int diaEntreSemana = fechaInicialMes.getDayOfWeek().getValue() - 1;
        int diaMes = fechaInicialMes.getDayOfMonth();

        // Atributos
        jp_vistaCalendario.setBounds(150, 150, 500, 350);
        jp_vistaCalendario.setBackground(new Color(173, 232, 244));
        jp_vistaCalendario.setLayout(estructura);

        // Armado
        // For para crear y agregar los componentes al panel
        for (int semana = 0; semana < estructura.getRows(); semana++) {
            for (int dia = 0; dia < estructura.getColumns(); dia++) {
                // Se agregan lbl al panel con los dias de la semana
                if (semana < 1) {
                    jl_diasSemanaColumnas[dia] = new JLabel();
                    jl_diasSemanaColumnas[dia].setText(diasSemanaTexto[dia]);
                    jl_diasSemanaColumnas[dia].setBackground(new Color(0, 150, 199));
                    jl_diasSemanaColumnas[dia].setOpaque(true);
                    jl_diasSemanaColumnas[dia].setBorder(new BevelBorder(BevelBorder.RAISED));
                    jp_vistaCalendario.add(jl_diasSemanaColumnas[dia]);
                    jp_vistaCalendario.setBackground(new Color(238, 238, 238));

                }
                // Se agregan los botones al panel
                if (semana > 0) {
                    jb_DiasMes[semana - 1][dia] = new JButton();
                    jb_DiasMes[semana - 1][dia].setBackground(Color.WHITE);
                    jp_vistaCalendario.add(jb_DiasMes[semana - 1][dia]);
                    jb_DiasMes[semana - 1][dia].setEnabled(false);
                }
            }

        }
        for (int dia = diaEntreSemana; diaMes <= diasEnElMes; dia++) {
            if (dia > 6) {
                dia = 0;
                contadorSemanas++;
            }
            if (contadorSemanas > 5) {
                break;
            }
            jb_DiasMes[contadorSemanas][dia].setText("" + diaMes);
            jb_DiasMes[contadorSemanas][dia].setEnabled(true);
            diaMes++;
            diaEntreSemana++;

        }

        // Escuchas
        for (int semana = 0; semana < 6; semana++) {
            for (int dia = 0; dia < 7; dia++) {
                jb_DiasMes[semana][dia].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        WindowMain.quitarPanel();
                        WindowMain.jf_ventanaPrincipal.add(VistaCitas.VistaHorarioAgendar());
                    }

                });
            }
        }

        return jp_vistaCalendario;
    }

    private static JPanel VistaFechaAgendar(JPanel jp_vistaCalendario) {
        // Variables
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicialdelMes = LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), 1);
        JPanel jp_vistaFecha = new JPanel();
        JButton jb_Seleccionar = new JButton("Seleccionar");
        JButton jb_Podologo1 = new JButton("Podologo 1");
        JButton jb_Podologo2 = new JButton("Podologo 2");
        JButton jb_mesAnterior = new JButton("Mes Anterior");
        JButton jb_mesSiguiente = new JButton("Mes Siguiente");
        JButton jb_Volver = new JButton("Volver");
        JLabel jl_año_mes = new JLabel();
        JLabel jl_horariodisponible = new JLabel("Horario disponible");
        JLabel jl_diaLleno = new JLabel("Dia lleno");
        JLabel jl_diaPasado = new JLabel("Dia Pasado");
        // Armado
        jp_vistaFecha.add(vistaCalendarioAgendar(0, 0));
        jp_vistaFecha.add(jl_año_mes);
        jp_vistaFecha.add(jb_Volver);
        jp_vistaFecha.add(jb_mesAnterior);
        jp_vistaFecha.add(jb_mesSiguiente);
        jp_vistaFecha.add(jb_Seleccionar);
        jp_vistaFecha.add(jb_Podologo1);
        jp_vistaFecha.add(jb_Podologo2);
        jp_vistaFecha.add(jl_diaPasado);
        jp_vistaFecha.add(jl_diaLleno);
        jp_vistaFecha.add(jl_horariodisponible);

        // Atributos
        jp_vistaFecha.setSize(800, 600);
        jp_vistaCalendario.setLocation(150, 150);
        jp_vistaFecha.setBackground(new Color(173, 232, 244));
        jp_vistaFecha.setLayout(null);
        jl_año_mes.setBounds(485, 100, 200, 40);
        jl_año_mes.setText("Año: " + fechaInicialdelMes.getYear() +
                "  Mes: " + fechaInicialdelMes.getMonth().getValue());
        jl_año_mes.setFont(new Font("Carlos", Font.ITALIC, 18));
        jb_Volver.setBounds(25, 50, 100, 40);
        jb_mesAnterior.setBounds(10, 270, 130, 40);
        jb_mesSiguiente.setBounds(660, 270, 120, 40);
        jb_Seleccionar.setBounds(650, 50, 130, 40);
        jb_Podologo1.setBounds(152, 110, 100, 40);
        jb_Podologo2.setBounds(252, 110, 100, 40);
        jb_Podologo1.setBackground(Color.white);
        jb_Podologo2.setBackground(Color.white);
        jl_diaPasado.setBounds(160, 50, 70, 40);
        jl_diaLleno.setBounds(240, 50, 50, 40);
        jl_horariodisponible.setBounds(300, 50, 110, 40);
        jl_diaPasado.setBackground(new Color(223, 227, 232));
        jl_diaLleno.setBackground(new Color(255, 217, 217));
        jl_horariodisponible.setBackground(new Color(195, 247, 200));
        jl_diaPasado.setOpaque(true);
        jl_diaLleno.setOpaque(true);
        jl_horariodisponible.setOpaque(true);

        // Escuchas
        jb_Volver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                WindowMain.quitarPanel();
                WindowMain.jf_ventanaPrincipal.add(getVistaBuscarAgendar());
            }

        });
        return jp_vistaFecha;
    }

    private static JPanel VistaHorarioAgendar() {
        // Variables
        LocalDate fechaActual = LocalDate.now();
        JPanel jp_vistaHorarios = new JPanel();
        JLabel jl_Fecha = new JLabel("" + fechaActual);
        JPanel jp_horarios = new JPanel(new GridLayout(5, 2));
        JScrollPane scroll_panelHorarios = new JScrollPane(jp_horarios);
        JLabel jl_horariodisponible = new JLabel("Horario disponible");
        JLabel jl_horarioOcupado = new JLabel("Horario Ocupado");
        JButton[] jb_horarios = new JButton[10];
        JButton jb_Volver = new JButton("Volver");

        // Armado
        jp_vistaHorarios.add(jb_Volver);
        jp_vistaHorarios.add(jl_Fecha);
        jp_vistaHorarios.add(scroll_panelHorarios);
        jp_vistaHorarios.add(jl_horariodisponible);
        jp_vistaHorarios.add(jl_horarioOcupado);
        for (int i = 0; i < 10; i++) {
            jb_horarios[i] = new JButton((9 + i) + ":00");
            jp_horarios.add(jb_horarios[i]);
            jb_horarios[i].setBackground(Color.WHITE);

        }

        // Atributos
        jp_vistaHorarios.setBounds(20, 30, 800, 600);
        jp_vistaHorarios.setBackground(new Color(173, 232, 244));
        jp_vistaHorarios.setLayout(null);
        jb_Volver.setBounds(25, 50, 100, 40);
        scroll_panelHorarios.setBounds(10, 100, 400, 400);
        jp_horarios.setSize(400, 400);
        jl_horariodisponible.setBounds(450, 100, 120, 50);
        jl_horariodisponible.setBackground(new Color(195, 247, 200));
        jl_horariodisponible.setOpaque(true);
        jl_horarioOcupado.setBounds(580, 100, 120, 50);
        jl_horarioOcupado.setBackground(new Color(255, 217, 217));
        jl_horarioOcupado.setOpaque(true);
        jl_Fecha.setText("" + fechaActual.atTime(9, 0));
        jl_Fecha.setBounds(500, 200, 200, 50);

        // Escuchas
        for (int horario = 0; horario < 10; horario++) {
            jb_horarios[horario].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "Se cancelara una cita para: "
                            + "\ncon fecha: "
                            + "¿Desea continuar?", null, JOptionPane.YES_NO_OPTION);
                    WindowMain.quitarPanel();
                    WindowMain.jf_ventanaPrincipal.add(getVistaBuscarAgendar());
                }

            });
        }
        jb_Volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowMain.quitarPanel();
                WindowMain.jf_ventanaPrincipal.add(VistaFechaAgendar(VistaCitas.vistaCalendarioAgendar(0, 0)));
            }

        });
        return jp_vistaHorarios;
    }

    // CANCELAR
    public static JPanel getVistaBuscarCancelar() {
        // VARIABLES
        JButton jb_botonPanel = new JButton("Eliminar");
        JButton jb_atras = new JButton("Volver");
        String[] columnas = { "Nombre", "Telefono", "Correo" };
        String[] opcionesComboBox = columnas;
        JPanel jp_panel = new JPanel();
        JTextField jtf_busqueda = new JTextField();
        JButton jb_Buscar = new JButton("Buscar");
        JButton jb_Aqui = new JButton("Aquí");
        JLabel jl_Aqui = new JLabel("<html>Si no encuentras al <br> paciente, registralo!</html>");
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

        scrollPane.setBounds(30, 150, 600, 350);

        jb_Aqui.setBounds(650, 400, 80, 30);
        jb_Aqui.setBackground(new Color(0, 150, 199));
        jb_Aqui.setForeground(Color.WHITE);

        jl_Aqui.setBounds(650, 350, 150, 30);

        jb_atras.setBounds(30, 20, 80, 30);
        jb_atras.setBackground(new Color(0, 150, 199));
        jb_atras.setForeground(Color.WHITE);

        // ARMADO
        jp_panel.add(jtf_busqueda);
        jp_panel.add(jb_Buscar);
        jp_panel.add(jb_botonPanel);
        jp_panel.add(comboBox);
        jp_panel.add(scrollPane);
        jp_panel.add(jb_Aqui);
        jp_panel.add(jl_Aqui);
        jp_panel.add(jb_atras);
        jp_panel.remove(jb_atras);

        // ESCUCHAS
        jb_botonPanel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(null, "Se cancelara una cita para: "
                        + "\ncon fecha: "
                        + "¿Desea continuar?", null, JOptionPane.YES_NO_OPTION);
                WindowMain.quitarPanel();
                WindowMain.jf_ventanaPrincipal.add(getVistaBuscarCancelar());
            }

        });

        return jp_panel;
    }

    // MODIFICAR
    public static JPanel getVistaBuscarModificar() {
        // VARIABLES
        JButton jb_botonPanel = new JButton("Modificar Cita");
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
        jb_botonPanel.setBounds(650, 250, 120, 50);

        JComboBox<String> comboBox = new JComboBox<>(opcionesComboBox);
        comboBox.setBounds(500, 80, 100, 30);

        scrollPane.setBounds(30, 150, 600, 350);

        jb_atras.setBounds(30, 20, 80, 30);
        jb_atras.setBackground(new Color(0, 150, 199));
        jb_atras.setForeground(Color.WHITE);

        // ARMADO
        jp_panel.add(jtf_busqueda);
        jp_panel.add(jb_Buscar);
        jp_panel.add(jb_botonPanel);
        jp_panel.add(comboBox);
        jp_panel.add(scrollPane);
        jp_panel.add(jb_atras);
        jp_panel.remove(jb_atras);

        // ESCUCHAS
        jb_botonPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowMain.quitarPanel();
                WindowMain.jf_ventanaPrincipal.add(VistaFechaModificar(VistaCitas.vistaCalendarioModificar(0, 0)));
            }

        });

        // MOSTRAR

        return jp_panel;
    }

    private static JPanel vistaCalendarioModificar(int año, int mes) {

        // Variables
        JPanel jp_vistaCalendario = new JPanel();
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicialMes = LocalDate.of(fechaActual.getYear() + año, fechaActual.getMonthValue() + mes, 1);
        JButton[][] jb_DiasMes = new JButton[6][7];
        GridLayout estructura = new GridLayout(7, 7);
        String[] diasSemanaTexto = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };
        JLabel[] jl_diasSemanaColumnas = new JLabel[7];
        int diasEnElMes = fechaInicialMes.lengthOfMonth();
        int contadorSemanas = 0;
        int diaEntreSemana = fechaInicialMes.getDayOfWeek().getValue() - 1;
        int diaMes = fechaInicialMes.getDayOfMonth();

        // Atributos
        jp_vistaCalendario.setBounds(150, 150, 500, 350);
        jp_vistaCalendario.setBackground(new Color(173, 232, 244));
        jp_vistaCalendario.setLayout(estructura);

        // Armado
        // For para crear y agregar los componentes al panel
        for (int semana = 0; semana < estructura.getRows(); semana++) {
            for (int dia = 0; dia < estructura.getColumns(); dia++) {
                // Se agregan lbl al panel con los dias de la semana
                if (semana < 1) {
                    jl_diasSemanaColumnas[dia] = new JLabel();
                    jl_diasSemanaColumnas[dia].setText(diasSemanaTexto[dia]);
                    jl_diasSemanaColumnas[dia].setBackground(new Color(0, 150, 199));
                    jl_diasSemanaColumnas[dia].setOpaque(true);
                    jl_diasSemanaColumnas[dia].setBorder(new BevelBorder(BevelBorder.RAISED));
                    jp_vistaCalendario.add(jl_diasSemanaColumnas[dia]);
                    jp_vistaCalendario.setBackground(new Color(238, 238, 238));

                }
                // Se agregan los botones al panel
                if (semana > 0) {
                    jb_DiasMes[semana - 1][dia] = new JButton();
                    jb_DiasMes[semana - 1][dia].setBackground(Color.WHITE);
                    jp_vistaCalendario.add(jb_DiasMes[semana - 1][dia]);
                    jb_DiasMes[semana - 1][dia].setEnabled(false);
                }
            }

        }
        for (int dia = diaEntreSemana; diaMes <= diasEnElMes; dia++) {
            if (dia > 6) {
                dia = 0;
                contadorSemanas++;
            }
            if (contadorSemanas > 5) {
                break;
            }
            jb_DiasMes[contadorSemanas][dia].setText("" + diaMes);
            jb_DiasMes[contadorSemanas][dia].setEnabled(true);
            diaMes++;
            diaEntreSemana++;

        }

        // Escuchas
        for (int semana = 0; semana < 6; semana++) {
            for (int dia = 0; dia < 7; dia++) {
                jb_DiasMes[semana][dia].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        WindowMain.quitarPanel();
                        WindowMain.jf_ventanaPrincipal.add(VistaCitas.VistaHorarioModificar());
                    }

                });
            }
        }

        return jp_vistaCalendario;
    }

    private static JPanel VistaFechaModificar(JPanel jp_vistaCalendario) {
        // Variables
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicialdelMes = LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), 1);
        JPanel jp_vistaFecha = new JPanel();
        JButton jb_Seleccionar = new JButton("Seleccionar");
        JButton jb_Podologo1 = new JButton("Podologo 1");
        JButton jb_Podologo2 = new JButton("Podologo 2");
        JButton jb_mesAnterior = new JButton("Mes Anterior");
        JButton jb_mesSiguiente = new JButton("Mes Siguiente");
        JButton jb_Volver = new JButton("Volver");
        JLabel jl_año_mes = new JLabel();
        JLabel jl_horariodisponible = new JLabel("Horario disponible");
        JLabel jl_diaLleno = new JLabel("Dia lleno");
        JLabel jl_diaPasado = new JLabel("Dia Pasado");

        // Armado
        jp_vistaFecha.add(vistaCalendarioModificar(0, 0));
        jp_vistaFecha.add(jl_año_mes);
        jp_vistaFecha.add(jb_Volver);
        jp_vistaFecha.add(jb_mesAnterior);
        jp_vistaFecha.add(jb_mesSiguiente);
        jp_vistaFecha.add(jb_Seleccionar);
        jp_vistaFecha.add(jb_Podologo1);
        jp_vistaFecha.add(jb_Podologo2);
        jp_vistaFecha.add(jl_diaPasado);
        jp_vistaFecha.add(jl_diaLleno);
        jp_vistaFecha.add(jl_horariodisponible);

        // Atributos
        jp_vistaFecha.setSize(800, 600);
        jp_vistaCalendario.setLocation(150, 150);
        jp_vistaFecha.setBackground(new Color(173, 232, 244));
        jp_vistaFecha.setLayout(null);
        jl_año_mes.setBounds(485, 100, 200, 40);
        jl_año_mes.setText("Año: " + fechaInicialdelMes.getYear() +
                "  Mes: " + fechaInicialdelMes.getMonth().getValue());
        jl_año_mes.setFont(new Font("Carlos", Font.ITALIC, 18));
        jb_Volver.setBounds(25, 50, 100, 40);
        jb_mesAnterior.setBounds(10, 270, 130, 40);
        jb_mesSiguiente.setBounds(660, 270, 120, 40);
        jb_Seleccionar.setBounds(650, 50, 130, 40);
        jb_Podologo1.setBounds(152, 110, 100, 40);
        jb_Podologo2.setBounds(252, 110, 100, 40);
        jb_Podologo1.setBackground(Color.white);
        jb_Podologo2.setBackground(Color.white);
        jl_diaPasado.setBounds(160, 50, 70, 40);
        jl_diaLleno.setBounds(240, 50, 50, 40);
        jl_horariodisponible.setBounds(300, 50, 110, 40);
        jl_diaPasado.setBackground(new Color(223, 227, 232));
        jl_diaLleno.setBackground(new Color(255, 217, 217));
        jl_horariodisponible.setBackground(new Color(195, 247, 200));
        jl_diaPasado.setOpaque(true);
        jl_diaLleno.setOpaque(true);
        jl_horariodisponible.setOpaque(true);

        // Escuchas
        jb_Volver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                WindowMain.quitarPanel();
                WindowMain.jf_ventanaPrincipal.add(getVistaBuscarModificar());
            }

        });

        return jp_vistaFecha;
    }

    private static JPanel VistaHorarioModificar() {

        // Variables
        LocalDate fechaActual = LocalDate.now();
        JPanel jp_vistaHorarios = new JPanel();
        JLabel jl_Fecha = new JLabel("" + fechaActual);
        JPanel jp_horarios = new JPanel(new GridLayout(5, 2));
        JScrollPane scroll_panelHorarios = new JScrollPane(jp_horarios);
        JLabel jl_horariodisponible = new JLabel("Horario disponible");
        JLabel jl_horarioOcupado = new JLabel("Horario Ocupado");
        JButton[] jb_horarios = new JButton[10];
        JButton jb_Volver = new JButton("Volver");

        // Armado
        jp_vistaHorarios.add(jb_Volver);
        jp_vistaHorarios.add(jl_Fecha);
        jp_vistaHorarios.add(scroll_panelHorarios);
        jp_vistaHorarios.add(jl_horariodisponible);
        jp_vistaHorarios.add(jl_horarioOcupado);
        for (int i = 0; i < 10; i++) {
            jb_horarios[i] = new JButton((9 + i) + ":00");
            jp_horarios.add(jb_horarios[i]);
            jb_horarios[i].setBackground(Color.WHITE);

        }

        // Atributos
        jp_vistaHorarios.setBounds(20, 30, 800, 600);
        jp_vistaHorarios.setBackground(new Color(173, 232, 244));
        jp_vistaHorarios.setLayout(null);
        jb_Volver.setBounds(25, 50, 100, 40);
        scroll_panelHorarios.setBounds(10, 100, 400, 400);
        jp_horarios.setSize(400, 400);
        jl_horariodisponible.setBounds(450, 100, 120, 50);
        jl_horariodisponible.setBackground(new Color(195, 247, 200));
        jl_horariodisponible.setOpaque(true);
        jl_horarioOcupado.setBounds(580, 100, 120, 50);
        jl_horarioOcupado.setBackground(new Color(255, 217, 217));
        jl_horarioOcupado.setOpaque(true);
        jl_Fecha.setText("" + fechaActual.atTime(9, 0));
        jl_Fecha.setBounds(500, 200, 200, 50);

        // Escuchas
        for (int horario = 0; horario < 10; horario++) {
            jb_horarios[horario].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "Se modificara una cita para: "
                            + "\ncon fecha: "
                            + "¿Desea continuar?", null, JOptionPane.YES_NO_OPTION);
                    WindowMain.quitarPanel();
                    WindowMain.jf_ventanaPrincipal.add(getVistaBuscarModificar());
                }

            });
        }

        jb_Volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowMain.quitarPanel();
                WindowMain.jf_ventanaPrincipal.add(VistaFechaModificar(VistaCitas.vistaCalendarioModificar(0, 0)));
            }

        });

        return jp_vistaHorarios;
    }

    // CONSULTAR
    public static JPanel getVistaBuscarConsultas() {
        // VARIABLES
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

        JComboBox<String> comboBox = new JComboBox<>(opcionesComboBox);
        comboBox.setBounds(500, 80, 100, 30);

        scrollPane.setBounds(30, 150, 600, 350);

        jb_atras.setBounds(30, 20, 80, 30);
        jb_atras.setBackground(new Color(0, 150, 199));
        jb_atras.setForeground(Color.WHITE);

        // ARMADO
        jp_panel.add(jtf_busqueda);
        jp_panel.add(jb_Buscar);
        jp_panel.add(comboBox);
        jp_panel.add(scrollPane);
        jp_panel.add(jb_atras);
        jp_panel.remove(jb_atras);

        // ESCUCHAS
        jb_Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });

        // MOSTRAR

        return jp_panel;
    }

    // RECORDATORIOS
    public static JPanel VistaRecordatorios() {
        // Variables
        JPanel jp_vistaRecordatorios = new JPanel(null);
        String[] columNames = null;
        Object[][] datos = null;
        JCheckBox[][] jcbox_confirmaciones = null;
        JTable jt_tablaRecordatorios = new JTable();
        JScrollPane js_scrollrecodatorios = new JScrollPane(jt_tablaRecordatorios);
        JLabel jl_citasMañana = new JLabel("Citas Para Mañana");
        JLabel jl_hecho = new JLabel("Hecho");
        JLabel jl_nohecho = new JLabel("No Hecho");

        // Armado
        jp_vistaRecordatorios.add(jl_citasMañana);
        jp_vistaRecordatorios.add(jl_hecho);
        jp_vistaRecordatorios.add(jl_nohecho);
        jp_vistaRecordatorios.add(js_scrollrecodatorios);

        // Atributos
        jp_vistaRecordatorios.setBounds(30, 0, 800, 600);
        jp_vistaRecordatorios.setBackground(new Color(173, 232, 244));

        jl_citasMañana.setBounds(250, 40, 130, 40);

        jl_hecho.setBounds(390, 40, 50, 40);
        jl_hecho.setBackground(new Color(195, 247, 200));
        jl_hecho.setOpaque(true);

        jl_nohecho.setBounds(450, 40, 70, 40);
        jl_nohecho.setBackground(new Color(255, 217, 217));
        jl_nohecho.setOpaque(true);

        js_scrollrecodatorios.setBounds(30, 110, 700, 400);
       
        // Escuchas
        return jp_vistaRecordatorios;
    }

}
