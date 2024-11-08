package view.Citas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.border.BevelBorder;

public class VistaCitas {
    private JPanel jp_vistaPrincipalCitas;
    private JPanel jp_vistaCalendario;
    private JPanel jp_vistaFecha;
    private JPanel jp_vistaHorarios;
    private JPanel jp_vistaRecordatorios;
    private JPanel jp_VistaAgregarCliente;
    private LocalDate fechaActual = LocalDate.now();
    private LocalDate fechaInicialdelMes = LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), 1);
    private JButton jb_Volver = new JButton("Volver");

    public VistaCitas() {
        JFrame ventana = new JFrame();
        ventana.add(VistaFecha());
        ventana.setSize(800, 600);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    // Vista Principal
    public JPanel VistaPrincipalCitas() {

        // Variables
        jp_vistaPrincipalCitas = new JPanel();
        JTextField jtf_buscador = new JTextField("Buscador");
        JTable jt_TablaconInfo = new JTable();
        JScrollPane jsp_ScrollTabla = new JScrollPane(jt_TablaconInfo);
        String[] listaDatos = { "Nombre", "Correo", "Telefono" };
        SpinnerModel sModel = new SpinnerListModel(listaDatos);
        JSpinner js_DatoABuscar = new JSpinner(sModel);
        JButton jb_buscar = new JButton("Buscar");
        JButton jb_seleccionar = new JButton("Seleccionar");
        JButton jb_registrar = new JButton("registrar");
        JLabel jl_etiqueta1 = new JLabel("Si no encuentraal paciente \n registrelo aqui");

        // Atributos
        jp_vistaPrincipalCitas.setBounds(0, 0, 800, 600);
        jp_vistaPrincipalCitas.setBackground(new Color(173, 232, 244));
        jp_vistaPrincipalCitas.setLayout(null);
        jtf_buscador.setBounds(20, 65, 200, 30);
        js_DatoABuscar.setBounds(230, 65, 80, 30);
        jsp_ScrollTabla.setBounds(20, 100, 550, 450);
        jb_buscar.setBounds(320, 65, 80, 30);
        jb_buscar.setBackground(new Color(0, 150, 199));
        jb_seleccionar.setBounds(580, 95, 200, 80);
        jb_seleccionar.setBackground(new Color(0, 150, 199));
        jb_registrar.setBounds(580, 480, 200, 80);
        jb_registrar.setBackground(new Color(0, 150, 199));
        jl_etiqueta1.setBounds(580, 350, 150, 150);

        // Armado
        jp_vistaPrincipalCitas.add(jtf_buscador);
        jp_vistaPrincipalCitas.add(js_DatoABuscar);
        jp_vistaPrincipalCitas.add(jtf_buscador);
        jp_vistaPrincipalCitas.add(jsp_ScrollTabla);
        jp_vistaPrincipalCitas.add(jb_buscar);
        jp_vistaPrincipalCitas.add(jb_seleccionar);
        jp_vistaPrincipalCitas.add(jb_registrar);
        jp_vistaPrincipalCitas.add(jl_etiqueta1);

        // Escuchas
        return jp_vistaPrincipalCitas;
    }

    // Vista Fecha
    public JPanel VistaFecha() {
        // Variables
        jp_vistaFecha = new JPanel();
        JButton jb_Seleccionar = new JButton("Seleccionar");
        JButton jb_Podologo1 = new JButton("Podologo 1");
        JButton jb_Podologo2 = new JButton("Podologo 2");
        JButton jb_mesAnterior = new JButton("Mes Anterior");
        JButton jb_mesSiguiente = new JButton("Mes Siguiente");
        JLabel jl_año_mes = new JLabel();
        JLabel jl_horariodisponible = new JLabel("Horario disponible");
        JLabel jl_diaLleno = new JLabel("Dia lleno");
        JLabel jl_diaPasado = new JLabel("Dia Pasado");
        // Armado
        jp_vistaFecha.add(vistaCalendario(fechaInicialdelMes));
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
        jl_horariodisponible.setBackground(new Color(195, 247,200));
        jl_diaPasado.setOpaque(true);
        jl_diaLleno.setOpaque(true);
        jl_horariodisponible.setOpaque(true);
        

        // Escuchas
        return jp_vistaFecha;
    }

    private JPanel vistaCalendarioRecursivo(int año, int mes) {
        fechaInicialdelMes = LocalDate.of(año, mes, 1);
        return vistaCalendario(fechaInicialdelMes);
    }

    private JPanel vistaCalendario(LocalDate FechaCalendario) {

        // if (jp_vistaCalendario == null) {
        // Variables
        jp_vistaCalendario = new JPanel();
        JButton[][] jb_DiasMes = new JButton[6][7];
        GridLayout estructura = new GridLayout(7, 7);
        String[] diasSemanaTexto = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };
        JLabel[] jl_diasSemanaColumnas = new JLabel[7];
        int diasEnElMes = FechaCalendario.lengthOfMonth();
        int contadorSemanas = 0;
        int diaEntreSemana = FechaCalendario.getDayOfWeek().getValue() - 1;

        int diaMes = FechaCalendario.getDayOfMonth();
        // Atributos
        jp_vistaCalendario.setSize(500, 350);
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
                    jl_diasSemanaColumnas[dia].setBackground(new Color(0,150,199));
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
                    jb_DiasMes[semana-1][dia].setEnabled(false);
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
        // }
        return jp_vistaCalendario;
    }
    //Vista Fecha y Vistas Calendario Van Juntos

    // Vista Horario
    public JPanel VistaHorario() {
        // Variables
        jp_vistaHorarios = new JPanel();
        JLabel jl_Fecha = new JLabel(""+fechaActual);
        JPanel jp_horarios = new JPanel(new GridLayout(5, 2));
        JScrollPane scroll_panelHorarios = new JScrollPane(jp_horarios);
        JLabel jl_horariodisponible = new JLabel("Horario disponible");
        JLabel jl_horarioOcupado = new JLabel("Horario Ocupado");
        JButton [] jb_horarios = new JButton[10];
        JButton jb_agendar = new JButton("Agendar");
        // Armado
        jp_vistaHorarios.add(jb_Volver);
        jp_vistaHorarios.add(jl_Fecha);
        jp_vistaHorarios.add(scroll_panelHorarios);
        jp_vistaHorarios.add(jl_horariodisponible);
        jp_vistaHorarios.add(jl_horarioOcupado);
        jp_vistaHorarios.add(jb_agendar);
        for(int i = 0; i<10;i++){
            jb_horarios[i] = new JButton((9+i)+":00");
            jp_horarios.add(jb_horarios[i]);
            jb_horarios[i].setBackground(Color.WHITE);
            
        }
        // Atributos
        jp_vistaHorarios.setSize(800, 600);
        jp_vistaHorarios.setBackground(new Color(173, 232, 244));
        jp_vistaHorarios.setLayout(null);
        jb_Volver.setBounds(25, 50, 100, 40);
        scroll_panelHorarios.setBounds(10, 100, 400, 400);
        jp_horarios.setSize(400, 400);
        jl_horariodisponible.setBounds(450, 100, 120,50);
        jl_horariodisponible.setBackground(new Color(195, 247,200));
        jl_horariodisponible.setOpaque(true);
        jl_horarioOcupado.setBounds(580,100,120,50  );
        jl_horarioOcupado.setBackground(new Color(255, 217, 217));
        jl_horarioOcupado.setOpaque(true);
        jl_Fecha.setText(""+fechaActual.atTime(9,0));
        jl_Fecha.setBounds(500, 200, 200,50);
        jb_agendar.setBounds(500, 270, 100, 50);
        
        
        // Escuchas
        return jp_vistaHorarios;
    }

    // Vista Recordatorios
    public JPanel VistaRecordatorios() {
        // Variables
        jp_vistaRecordatorios = new JPanel();
        // Atributos
        // Armado
        // Escuchas
        return jp_vistaRecordatorios;
    }

    // Vista Agregar Paciente
    public JPanel VistaAgregarPacientes() {
        // Variables
        jp_VistaAgregarCliente = new JPanel();
        // Atributos
        // Armado
        // Escuchas
        return jp_VistaAgregarCliente;
    }

    public static void main(String[] args) {
        new VistaCitas();
    }

}
