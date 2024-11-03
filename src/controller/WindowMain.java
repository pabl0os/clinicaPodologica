package controller;

import java.awt.Color;

import javax.swing.*;

import view.usuarios.VistaEntrar;

public class WindowMain {
  VistaEntrar vistaEntrar = new VistaEntrar();

  public static JFrame jf_ventanaPrincipal = new JFrame();

  public static JMenuBar menuBar = new JMenuBar();

  public static JMenu menuPacientes = new JMenu("Gestionar Pacientes");
  public static JMenu menuUsuarios = new JMenu("Gestionar Usuarios");
  public static JMenu menuCitas = new JMenu("Gestionar Citas");
  public static JMenu menuOtros = new JMenu("Gestionar otros");

  public static JMenuItem itemConsultar = new JMenuItem("Consultar");
  public static JMenuItem itemEliminar = new JMenuItem("Eliminar");
  public static JMenuItem itemModificar = new JMenuItem("Modificar");
  public static JMenuItem itemAgregar = new JMenuItem("Agregar");

  public static JMenuItem itemEliminar2 = new JMenuItem("Eliminar");
  public static JMenuItem itemConsultar2 = new JMenuItem("Consultar");
  public static JMenuItem itemModificar2 = new JMenuItem("Modificar");
  public static JMenuItem itemAgregar2 = new JMenuItem("Agregar");

  public static JMenuItem itemAgendar3 = new JMenuItem("Agendar");
  public static JMenuItem itemCancelar3 = new JMenuItem("Cancelar");
  public static JMenuItem itemModificar3 = new JMenuItem("Modificar");
  public static JMenuItem itemConsultar3 = new JMenuItem("Consultar");
  public static JMenuItem itemRecordatorios3 = new JMenuItem("Recordatorios");

  public static JMenuItem impresiones = new JMenuItem("Impresiones");
  public static JMenuItem Salir = new JMenuItem("Salir");

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

    // barra de menu
    menuBar.setBackground(new Color(0, 150, 199));
    // menus
    menuCitas.setForeground(Color.white);
    menuOtros.setForeground(Color.white);
    menuPacientes.setForeground(Color.white);
    menuUsuarios.setForeground(Color.white);

    // items
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
    
  }
  
  private void armado() {
    jf_ventanaPrincipal.add(vistaEntrar.getJp_login());
  }

  private void escuchas() {
  }

  private void mostrar() {
    jf_ventanaPrincipal.setVisible(true);
  }

}
