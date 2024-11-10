package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import view.pacientes.vistaPacientes;
import view.usuarios.VistaEntrar;
import view.usuarios.VistaGestionUsuarios;

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
    private final JMenuItem itemConsultarPacientes = new JMenuItem("Consultar");
    private final JMenuItem itemEliminarPacientes = new JMenuItem("Eliminar");
    private final JMenuItem itemModificarPacientes = new JMenuItem("Modificar");
    private final JMenuItem itemAgregarPacientes = new JMenuItem("Agregar");
    // Usuarios
    private final JMenuItem itemEliminar2Usuarios = new JMenuItem("Eliminar");
    private final JMenuItem itemConsultar2Usuarios = new JMenuItem("Consultar");
    private final JMenuItem itemModificar2Usuarios = new JMenuItem("Modificar");
    private final JMenuItem itemAgregar2Usuarios = new JMenuItem("Agregar");
    // citas
    private final JMenuItem itemAgendar3Citas = new JMenuItem("Agendar");
    private final JMenuItem itemCancelar3Citas = new JMenuItem("Cancelar");
    private final JMenuItem itemModificar3Citas = new JMenuItem("Modificar");
    private final JMenuItem itemConsultar3Citas = new JMenuItem("Consultar");
    private final JMenuItem itemRecordatorios3Citas = new JMenuItem("Recordatorios");
    // otros
    private final JMenuItem itemimpresionesOtros = new JMenuItem("Impresiones");
    private final JMenuItem ItemSalirOtros = new JMenuItem("Salir");

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

        itemEliminarPacientes.setForeground(Color.WHITE);
        itemConsultarPacientes.setForeground(Color.WHITE);
        itemModificarPacientes.setForeground(Color.WHITE);
        itemAgregarPacientes.setForeground(Color.WHITE);

        itemEliminar2Usuarios.setForeground(Color.WHITE);
        itemConsultar2Usuarios.setForeground(Color.WHITE);
        itemModificar2Usuarios.setForeground(Color.WHITE);
        itemAgregar2Usuarios.setForeground(Color.WHITE);

        itemAgendar3Citas.setForeground(Color.WHITE);
        itemCancelar3Citas.setForeground(Color.WHITE);
        itemModificar3Citas.setForeground(Color.WHITE);
        itemConsultar3Citas.setForeground(Color.WHITE);
        itemRecordatorios3Citas.setForeground(Color.WHITE);

        itemimpresionesOtros.setForeground(Color.WHITE);
        ItemSalirOtros.setForeground(Color.WHITE);

        itemEliminarPacientes.setBackground(new Color(0, 150, 199));
        itemConsultarPacientes.setBackground(new Color(0, 150, 199));
        itemModificarPacientes.setBackground(new Color(0, 150, 199));
        itemAgregarPacientes.setBackground(new Color(0, 150, 199));

        itemEliminar2Usuarios.setBackground(new Color(0, 150, 199));
        itemConsultar2Usuarios.setBackground(new Color(0, 150, 199));
        itemModificar2Usuarios.setBackground(new Color(0, 150, 199));
        itemAgregar2Usuarios.setBackground(new Color(0, 150, 199));

        itemAgendar3Citas.setBackground(new Color(0, 150, 199));
        itemCancelar3Citas.setBackground(new Color(0, 150, 199));
        itemModificar3Citas.setBackground(new Color(0, 150, 199));
        itemConsultar3Citas.setBackground(new Color(0, 150, 199));
        itemRecordatorios3Citas.setBackground(new Color(0, 150, 199));

        itemimpresionesOtros.setBackground(new Color(0, 150, 199));
        ItemSalirOtros.setBackground(new Color(0, 150, 199));
    }

    private void armado() {

        jf_ventanaPrincipal.add(vistaEntrar.getJp_login());

        menuPacientes.add(itemEliminarPacientes);
        menuPacientes.add(itemConsultarPacientes);
        menuPacientes.add(itemModificarPacientes);
        menuPacientes.add(itemAgregarPacientes);

        menuUsuarios.add(itemAgregar2Usuarios);
        menuUsuarios.add(itemEliminar2Usuarios);
        menuUsuarios.add(itemModificar2Usuarios);
        menuUsuarios.add(itemConsultar2Usuarios);

        menuCitas.add(itemAgendar3Citas);
        menuCitas.add(itemCancelar3Citas);
        menuCitas.add(itemModificar3Citas);
        menuCitas.add(itemConsultar3Citas);
        menuCitas.add(itemRecordatorios3Citas);

        menuOtros.add(itemimpresionesOtros);
        menuOtros.add(ItemSalirOtros);

        menuBar.add(menuPacientes);
        menuBar.add(menuUsuarios);
        menuBar.add(menuCitas);
        menuBar.add(menuOtros);
    }

    private void escuchas() {
<<<<<<< HEAD
=======

        // PACIENTES---------------------------------------------------------------------------------------
        itemEliminarPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               quitarPanel();
               jf_ventanaPrincipal.add(vistaPacientes.vistaBuscarEliminar());
            }
        });

        itemConsultarPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               quitarPanel();
               jf_ventanaPrincipal.add(vistaPacientes.vistaBuscarConsultar());
            }
        });

        itemModificarPacientes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                quitarPanel();
                jf_ventanaPrincipal.add(vistaPacientes.vistaBuscarModificar(""));
            }
           
            
        });

        itemAgregarPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               quitarPanel();
               jf_ventanaPrincipal.add(vistaPacientes.vistaAgregar(""));
            }

        });

        // USUARIOS---------------------------------------------------------------------------------------
        itemAgregar2Usuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               quitarPanel();
               jf_ventanaPrincipal.add(VistaGestionUsuarios.vistAgregarUsuarioAgregar(""));
            }
            
        });

        itemEliminar2Usuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitarPanel();
                jf_ventanaPrincipal.add(VistaGestionUsuarios.vistaBuscarEliminar());
            }
            
        });

        itemModificar2Usuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               quitarPanel();
               jf_ventanaPrincipal.add(VistaGestionUsuarios.vistaBuscarModificar(""));
            }
            
        });

        itemConsultar2Usuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitarPanel();
                WindowMain.jf_ventanaPrincipal.add(VistaGestionUsuarios.vistaBuscarConsultar());
            }
            
        });
        // CITAS---------------------------------------------------------------------------------------

        // OTROS---------------------------------------------------------------------------------------
        ItemSalirOtros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitarPanel();
                jf_ventanaPrincipal.add(vistaEntrar.getJp_login());
            }
            
        });
       
>>>>>>> 4c59ba95be566b8ebd949d99480ef558b52c8d3d
    }

    private void mostrar() {
        jf_ventanaPrincipal.setVisible(true);
    }


    
    public static void quitarPanel() {
        SwingUtilities.invokeLater(() -> {
            for (Component comp : jf_ventanaPrincipal.getContentPane().getComponents()) {
                if (comp instanceof JPanel) { // Verificamos si es un JPanel
                    jf_ventanaPrincipal.getContentPane().remove(comp); // Quitamos el JPanel
                    break;
                }
            }
            jf_ventanaPrincipal.revalidate(); // Actualizar el contenedor
            jf_ventanaPrincipal.repaint(); // Repintar la ventana
        });
    }

}
