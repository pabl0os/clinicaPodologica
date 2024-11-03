package view.Citas;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Date;
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

public class VistaCitas {
    private JPanel jp_vistaPrincipalCitas;
    private JPanel jp_vistaHorarios;
    private JPanel jp_vistaFechas;
    private JPanel jp_vistaRecordatorios;
    private JPanel jp_VistaAgregarCliente;

    public VistaCitas() {
        JFrame ventana = new JFrame();
        VistaFechas();
        ventana.add(jp_vistaFechas);
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

    // Vista Horarios
    public JPanel VistaHorarios() {
        // Variables

        // Atributos
        // Armado
        // Escuchas
        return jp_vistaHorarios;
    }

    // Vista Fechas
    public JPanel VistaFechas() {
        // Variables
        jp_vistaFechas = new JPanel();
        JButton[][] jb_DiasMes = new JButton[5][7];
        GridLayout estructura = new GridLayout(6, 7);
        String[] diasSemanaTexto = { "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };
        JLabel[] jl_diasSemanaColumnas = new JLabel[7];
        // String[][] numeroDelDia = new String[5][7];
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicial = LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), 1);
        int diasEnElMes = fechaActual.lengthOfMonth();
        // DayOfWeek diaDelaSemana = fechaActual.getDayOfWeek();
         int contadorSemanas = 0;
         Date fecha = Date.valueOf(fechaActual);
        // Atributos
        jp_vistaFechas.setBounds(0, 0, 600, 400);
        jp_vistaFechas.setBackground(new Color(173, 232, 244));
        jp_vistaFechas.setLayout(estructura);
        System.out.println(fecha.getDay());
        System.out.println(fecha.getDate());






        // For para agregar los componentes inicio del mes
        for (int semana = 0; semana < estructura.getRows(); semana++) {
            for (int dia = 0; dia < estructura.getColumns(); dia++) {
                // Se agregan lbl al panel con los dias de la semana
                if (semana < 1) {
                    jl_diasSemanaColumnas[dia] = new JLabel();
                    jl_diasSemanaColumnas[dia].setText(diasSemanaTexto[dia]);
                    jp_vistaFechas.add(jl_diasSemanaColumnas[dia]);
                    
                }
                if (semana > 0) {
                    jb_DiasMes[semana-1][dia] = new JButton();
                    jb_DiasMes[semana][dia].setName(""+dia);
                    //El de agregar el texto va en otro metodo
                        // jb_DiasMes[semana-1][dia].setText(numeroDelDia[semana-1][dia]);
                        jp_vistaFechas.add(jb_DiasMes[semana-1][dia]);
                        
                        System.out.println("Semana: "+semana +"\t Dia: "+dia);
                    }
            }
           
        }

        for (int dia = 1; dia <diasEnElMes ; dia++) {
            if(dia>6){
                dia=0;
            }
            jb_DiasMes[contadorSemanas][dia].setText("");
            
            if(contadorSemanas>5){
                break;
            }
            contadorSemanas++;
            
        }
        


        // Armado
        // Escuchas
        return jp_vistaFechas;
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

    //hola carlos

}
