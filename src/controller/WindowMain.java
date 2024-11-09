package controller;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import view.usuarios.VistaEntrar;

public class WindowMain {

    VistaEntrar vistaEntrar = new VistaEntrar();

    public static JFrame jf_ventanaPrincipal = new JFrame();

    // MENU VARIABLES
    public static JMenuBar menuBar = new JMenuBar();

    private final JMenu menuPacientes = new JMenu("Gestionar Pacientes");
    private final JMenu menuUsuarios = new JMenu("Gestionar Usuarios");
    private final JMenu menuCitas = new JMenu("Gestionar Citas");
    private final JMenu menuOtros = new JMenu(" otros");

    // pacientes
    private final JMenuItem itemConsultar = new JMenuItem("Consultar");
    private final JMenuItem itemEliminar = new JMenuItem("Eliminar");
    private final JMenuItem itemModificar = new JMenuItem("Modificar");
    private final JMenuItem itemAgregar = new JMenuItem("Agregar");
    // Usuarios
    private final JMenuItem itemEliminar2 = new JMenuItem("Eliminar");
    private final JMenuItem itemConsultar2 = new JMenuItem("Consultar");
    private final JMenuItem itemModificar2 = new JMenuItem("Modificar");
    private final JMenuItem itemAgregar2 = new JMenuItem("Agregar");
    // citas
    private final JMenuItem itemAgendar3 = new JMenuItem("Agendar");
    private final JMenuItem itemCancelar3 = new JMenuItem("Cancelar");
    private final JMenuItem itemModificar3 = new JMenuItem("Modificar");
    private final JMenuItem itemConsultar3 = new JMenuItem("Consultar");
    private final JMenuItem itemRecordatorios3 = new JMenuItem("Recordatorios");
    // otros
    private final JMenuItem impresiones = new JMenuItem("Impresiones");
    private final JMenuItem Salir = new JMenuItem("Salir");

    public WindowMain() {
        atributos();
        armado();
        escuchas();
        mostrar();
    }

    private void atributos() {
        jf_ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf_ventanaPrincipal.setSize(800, 600);
        jf_ventanaPrincipal.setLocationRelativeTo(null);

        menuBar.setBackground(new Color(0, 150, 199));
        menuCitas.setForeground(Color.white);
        menuOtros.setForeground(Color.white);
        menuPacientes.setForeground(Color.white);
        menuUsuarios.setForeground(Color.white);

        menuCitas.setFont(new Font("Arial", Font.BOLD, 15));
        menuOtros.setFont(new Font("Arial", Font.BOLD, 15));
        menuPacientes.setFont(new Font("Arial", Font.BOLD, 15));
        menuUsuarios.setFont(new Font("Arial", Font.BOLD, 15));

        itemEliminar.setForeground(Color.WHITE);
        itemConsultar.setForeground(Color.WHITE);
        itemModificar.setForeground(Color.WHITE);
        itemAgregar.setForeground(Color.WHITE);

        itemEliminar2.setForeground(Color.WHITE);
        itemConsultar2.setForeground(Color.WHITE);
        itemModificar2.setForeground(Color.WHITE);
        itemAgregar2.setForeground(Color.WHITE);

        itemAgendar3.setForeground(Color.WHITE);
        itemCancelar3.setForeground(Color.WHITE);
        itemModificar3.setForeground(Color.WHITE);
        itemConsultar3.setForeground(Color.WHITE);
        itemRecordatorios3.setForeground(Color.WHITE);

        impresiones.setForeground(Color.WHITE);
        Salir.setForeground(Color.WHITE);

        itemEliminar.setBackground(new Color(0, 150, 199));
        itemConsultar.setBackground(new Color(0, 150, 199));
        itemModificar.setBackground(new Color(0, 150, 199));
        itemAgregar.setBackground(new Color(0, 150, 199));

        itemEliminar2.setBackground(new Color(0, 150, 199));
        itemConsultar2.setBackground(new Color(0, 150, 199));
        itemModificar2.setBackground(new Color(0, 150, 199));
        itemAgregar2.setBackground(new Color(0, 150, 199));

        itemAgendar3.setBackground(new Color(0, 150, 199));
        itemCancelar3.setBackground(new Color(0, 150, 199));
        itemModificar3.setBackground(new Color(0, 150, 199));
        itemConsultar3.setBackground(new Color(0, 150, 199));
        itemRecordatorios3.setBackground(new Color(0, 150, 199));

        impresiones.setBackground(new Color(0, 150, 199));
        Salir.setBackground(new Color(0, 150, 199));
    }

    private void armado() {

        jf_ventanaPrincipal.add(vistaEntrar.getJp_login());

        menuPacientes.add(itemEliminar);
        menuPacientes.add(itemConsultar);
        menuPacientes.add(itemModificar);
        menuPacientes.add(itemAgregar);

        menuUsuarios.add(itemAgregar2);
        menuUsuarios.add(itemEliminar2);
        menuUsuarios.add(itemModificar2);
        menuUsuarios.add(itemConsultar2);

        menuCitas.add(itemAgendar3);
        menuCitas.add(itemCancelar3);
        menuCitas.add(itemModificar3);
        menuCitas.add(itemConsultar3);
        menuCitas.add(itemRecordatorios3);

        menuOtros.add(impresiones);
        menuOtros.add(Salir);

        menuBar.add(menuPacientes);
        menuBar.add(menuUsuarios);
        menuBar.add(menuCitas);
        menuBar.add(menuOtros);
    }

    private void escuchas() {

    }

    private void mostrar() {
        jf_ventanaPrincipal.setVisible(true);
    }

}
