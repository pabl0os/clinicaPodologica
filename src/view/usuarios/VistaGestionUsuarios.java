package view.usuarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;

import controller.WindowMain;

public class VistaGestionUsuarios {

   // ELIMINAR
   public static JPanel vistaBuscarEliminar() {

      // VARIABLES
      String textButton = "Eliminar";
      JButton jb_botonPanel = new JButton(textButton);
      String[] columnas = { "Nombre", "Contraseña", "Correo", "Rol" };
      String[] opcionesComboBox = columnas;
      JPanel jp_panel = new JPanel();
      JTextField jtf_busqueda = new JTextField();
      JButton jb_Buscar = new JButton("Buscar");
      String texto = "<html>Se realizo correctamente <br>la eliminacion " +
            "<br>" +
            " <span style='color:red;'>No se realizo correctamente la eliminacion</span></html>";
      JLabel jl_textoinformativo = new JLabel(texto);

      Object[][] datos =  {
         {"Ana Pérez", "ana1234", "ana.perez@example.com", "Asistente"},
         {"Carlos López", "carlospass", "carlos.lopez@example.com", "Podólogo"},
         {"María Gómez", "mariag123", "maria.gomez@example.com", "Administrador"},
         {"Luis Torres", "luispass", "luis.torres@example.com", "Asistente"},
         {"Sofía Castro", "sofiac123", "sofia.castro@example.com", "Asistente"},
         {"Pedro Mendoza", "pedrom98", "pedro.mendoza@example.com", "Podólogo"},
         {"Lucía Fernández", "luciaf23", "lucia.fernandez@example.com", "Administrador"},
         {"Jorge Díaz", "jorge123", "jorge.diaz@example.com", "Asistente"},
         {"Elena Ríos", "elenar56", "elena.rios@example.com", "Podólogo"},
         {"Ana Pérez", "ana1234", "ana.perez@example.com", "Asistente"},
         {"Carlos López", "carlospass", "carlos.lopez@example.com", "Podólogo"},
         {"María Gómez", "mariag123", "maria.gomez@example.com", "Administrador"},
         {"Luis Torres", "luispass", "luis.torres@example.com", "Asistente"},
         {"Sofía Castro", "sofiac123", "sofia.castro@example.com", "Asistente"},
         {"Pedro Mendoza", "pedrom98", "pedro.mendoza@example.com", "Podólogo"},
         {"Lucía Fernández", "luciaf23", "lucia.fernandez@example.com", "Administrador"},
         {"Jorge Díaz", "jorge123", "jorge.diaz@example.com", "Asistente"},
         {"Elena Ríos", "elenar56", "elena.rios@example.com", "Podólogo"},
         {"Ana Pérez", "ana1234", "ana.perez@example.com", "Asistente"},
         {"Carlos López", "carlospass", "carlos.lopez@example.com", "Podólogo"},
         {"María Gómez", "mariag123", "maria.gomez@example.com", "Administrador"},
         {"Luis Torres", "luispass", "luis.torres@example.com", "Asistente"},
         {"Sofía Castro", "sofiac123", "sofia.castro@example.com", "Asistente"},
         {"Pedro Mendoza", "pedrom98", "pedro.mendoza@example.com", "Podólogo"},
         {"Lucía Fernández", "luciaf23", "lucia.fernandez@example.com", "Administrador"},
         {"Jorge Díaz", "jorge123", "jorge.diaz@example.com", "Asistente"},
         {"Elena Ríos", "elenar56", "elena.rios@example.com", "Podólogo"},
         {"Fernando Ortiz", "fernando123", "fernando.ortiz@example.com", "Asistente"}
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
            JOptionPane.showMessageDialog(WindowMain.jf_ventanaPrincipal, "¿Estas seguro de eliminar el usuario?\n" + //
                  "Nombre: Juan\n" + //
                  "Teléfono: 2348742\n" + //
                  "Correo: ajdfada");
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
      String[] columnas = { "Nombre", "Contraseña", "Correo", "Rol" };
      String[] opcionesComboBox = columnas;
      JPanel jp_panel = new JPanel();
      JTextField jtf_busqueda = new JTextField();
      JButton jb_Buscar = new JButton("Buscar");
      JLabel jl_textoinformativo = new JLabel(texto);

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
            WindowMain.quitarPanel();
            WindowMain.jf_ventanaPrincipal.add(vistAgregarUsuarioModificar());
         }

      });

      // MOSTRAR

      return jp_panel;
   }

   public static JPanel vistAgregarUsuarioModificar() {
      JPanel jp_panel;
      JButton jb_Listo = new JButton("Agregar");

      // VARIABLES
      jp_panel = new JPanel();
      JPanel panelIntermedio = new JPanel();
      JTextField jtf_nombre = new JTextField("Nombre");
      JTextField jtf_Numero = new JTextField("Contraseña");
      JTextField jtf_correo = new JTextField("Correo");
      JButton jb_volver = new JButton("Volver");
      String[] roles = { "asistente", "podologo" };
      @SuppressWarnings("rawtypes")
      JComboBox jcb_roles = new JComboBox<>(roles);
    
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

      jcb_roles.setBounds(130, 220, 140, 30);

      // ARMADO
      jp_panel.add(panelIntermedio);
      panelIntermedio.add(jtf_nombre);
      panelIntermedio.add(jtf_Numero);
      panelIntermedio.add(jtf_correo);
      panelIntermedio.add(jcb_roles);
      jp_panel.add(jb_Listo);
      jp_panel.add(jb_volver);

      // ESCUCHAS

      jb_Listo.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            WindowMain.quitarPanel();
            WindowMain.jf_ventanaPrincipal.add(vistaPermisosModificar());
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

   public static JPanel vistaPermisosModificar() {
      JButton jb_siguiente = new JButton("Siguiente");
      JPanel panel;

      panel = new JPanel();
      int altura = 60;
      JButton jb_Volver = new JButton("Volver");
      jb_Volver.setBounds(20, 20, 80, 30);
      jb_Volver.setForeground(Color.WHITE);
      jb_Volver.setBackground(new Color(0, 150, 199));
      jb_siguiente.setBounds(600, 450, 120, 30);
      jb_siguiente.setForeground(Color.WHITE);
      jb_siguiente.setBackground(new Color(0, 150, 199));

      panel.setLayout(null);
      panel.setBackground(new Color(173, 232, 244));

      JCheckBox agendar = new JCheckBox("Agendar");
      agendar.setBounds(200, 100 + altura, 140, 20);
      agendar.setBackground(new Color(173, 232, 244));
      panel.add(agendar);

      JCheckBox cancelar = new JCheckBox("Cancelar");
      cancelar.setBounds(200, 130 + altura, 140, 20);
      cancelar.setBackground(new Color(173, 232, 244));
      panel.add(cancelar);

      JCheckBox modificar = new JCheckBox("modificar");
      modificar.setBounds(200, 160 + altura, 140, 20);
      modificar.setBackground(new Color(173, 232, 244));
      panel.add(modificar);

      JCheckBox consultar = new JCheckBox("Consultar");
      consultar.setBounds(200, 190 + altura, 140, 20);
      consultar.setBackground(new Color(173, 232, 244));
      panel.add(consultar);

      JCheckBox recordatorios = new JCheckBox("recordatorios");
      recordatorios.setBounds(200, 220 + altura, 140, 20);
      recordatorios.setBackground(new Color(173, 232, 244));
      panel.add(recordatorios);

      JCheckBox eliminar = new JCheckBox("Eliminar");
      eliminar.setBounds(400, 130 + altura, 140, 20);
      eliminar.setBackground(new Color(173, 232, 244));
      panel.add(eliminar);

      JCheckBox modificarPacientes = new JCheckBox("Modificar");
      modificarPacientes.setBounds(400, 160 + altura, 140, 20);
      modificarPacientes.setBackground(new Color(173, 232, 244));
      panel.add(modificarPacientes);

      JCheckBox consultarPacientes = new JCheckBox("Consultar");
      consultarPacientes.setBounds(400, 190 + altura, 140, 20);
      consultarPacientes.setBackground(new Color(173, 232, 244));
      panel.add(consultarPacientes);

      JCheckBox historialClinico = new JCheckBox("Historial Clínico");
      historialClinico.setBounds(400, 220 + altura, 140, 20);
      historialClinico.setBackground(new Color(173, 232, 244));
      panel.add(historialClinico);

      JCheckBox Agregar = new JCheckBox("Agregar");
      Agregar.setBounds(400, 100 + altura, 140, 20);
      Agregar.setBackground(new Color(173, 232, 244));
      panel.add(Agregar);

      JLabel jl_titulo = new JLabel("Permisos");
      JLabel jl_Citas = new JLabel("Citas");
      JLabel jl_pacientes = new JLabel("Pacientes");
      jl_titulo.setBounds(310, 30, 300, 80);
      jl_titulo.setFont(new Font("Arial", Font.BOLD, 28));
      jl_Citas.setBounds(200, 110, 300, 80);
      jl_Citas.setFont(new Font("Arial", Font.BOLD, 18));
      jl_pacientes.setBounds(400, 110, 300, 80);
      jl_pacientes.setFont(new Font("Arial", Font.BOLD, 18));


      panel.add(jl_titulo);
      panel.add(jl_Citas);
      panel.add(jl_pacientes);
      panel.add(jb_Volver);
      panel.add(jb_siguiente);

      // ESCUCHAS
      jb_siguiente.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(WindowMain.jf_ventanaPrincipal, "¿Los datos a modificar son correctos?\n" + //
                  "Nombre: Pepe\n" + //
                  "Teléfono: 234324\n" + //
                  "Correo: ajdfada");
            WindowMain.quitarPanel();
            WindowMain.jf_ventanaPrincipal
                  .add(vistaBuscarModificar("<html>Se realizo correctamente <br>la Modificacion " +
                        "<br>" +
                        " <span style='color:red;'>No se realizo correctamente la Modificacion</span></html>"));
         }
      });
      jb_Volver.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            WindowMain.quitarPanel();
            WindowMain.jf_ventanaPrincipal.add(vistAgregarUsuarioModificar());
         }
         
      });

      return panel;

   }

   // CONSULTAR
   public static JPanel vistaBuscarConsultar() {

      // VARIABLES
      String[] columnas = { "Nombre", "Contraseña", "Correo", "Rol" };
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

      scrollPane.setBounds(30, 150, 550, 350);

      // ARMADO
      jp_panel.add(jtf_busqueda);
      jp_panel.add(jb_Buscar);
      jp_panel.add(comboBox);
      jp_panel.add(scrollPane);

      // ESCUCHAS

      // MOSTRAR

      return jp_panel;
   }

   // AGREGAR
   public static JPanel vistAgregarUsuarioAgregar(String texto) {
      JPanel jp_panel;
      JButton jb_Listo = new JButton("Agregar");

      // VARIABLES
      jp_panel = new JPanel();
      JPanel panelIntermedio = new JPanel();
      JTextField jtf_nombre = new JTextField("Nombre");
      JTextField jtf_Numero = new JTextField("Contraseña");
      JTextField jtf_correo = new JTextField("Correo");
      JLabel jl_textoinformativo = new JLabel(texto);

      String[] roles = { "asistente", "podologo" };
      @SuppressWarnings("rawtypes")
      JComboBox jcb_roles = new JComboBox<>(roles);
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

      jcb_roles.setBounds(130, 220, 140, 30);

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
      panelIntermedio.add(jcb_roles);
      jp_panel.add(jb_Listo);
      jp_panel.add(jl_textoinformativo);

      // ESCUCHAS

      jb_Listo.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(WindowMain.jf_ventanaPrincipal, "Nombre: Juan\n" + //
                              "Teléfono: 2348742\n" + //
                              "Correo: ajdfada\n¿Ees correcto?");
            WindowMain.quitarPanel();
            WindowMain.jf_ventanaPrincipal.add(vistaPermisosAgregar());
         }

      });

      // MOSTRAR

      return jp_panel;
   }

   public static JPanel vistaPermisosAgregar() {
      JButton jb_siguiente = new JButton("Siguiente");

      JPanel panel;

      panel = new JPanel();
      int altura = 60;
      JButton jb_Volver = new JButton("Volver");
      jb_Volver.setBounds(20, 20, 80, 30);
      jb_siguiente.setBounds(600, 450, 120, 30);
      jb_Volver.setForeground(Color.WHITE);
      jb_Volver.setBackground(new Color(0, 150, 199));
      jb_siguiente.setForeground(Color.WHITE);
      jb_siguiente.setBackground(new Color(0, 150, 199));

      panel.setLayout(null);
      panel.setBackground(new Color(173, 232, 244));

      JCheckBox agendar = new JCheckBox("Agendar");
      agendar.setBounds(200, 100 + altura, 140, 20);
      agendar.setBackground(new Color(173, 232, 244));
      panel.add(agendar);

      JCheckBox cancelar = new JCheckBox("Cancelar");
      cancelar.setBounds(200, 130 + altura, 140, 20);
      cancelar.setBackground(new Color(173, 232, 244));
      panel.add(cancelar);

      JCheckBox modificar = new JCheckBox("modificar");
      modificar.setBounds(200, 160 + altura, 140, 20);
      modificar.setBackground(new Color(173, 232, 244));
      panel.add(modificar);

      JCheckBox consultar = new JCheckBox("Consultar");
      consultar.setBounds(200, 190 + altura, 140, 20);
      consultar.setBackground(new Color(173, 232, 244));
      panel.add(consultar);

      JCheckBox recordatorios = new JCheckBox("recordatorios");
      recordatorios.setBounds(200, 220 + altura, 140, 20);
      recordatorios.setBackground(new Color(173, 232, 244));
      panel.add(recordatorios);

      JCheckBox Agregar = new JCheckBox("Agregar");
      Agregar.setBounds(400, 100 + altura, 140, 20);
      Agregar.setBackground(new Color(173, 232, 244));
      panel.add(Agregar);
      
      JCheckBox eliminar = new JCheckBox("Eliminar");
      eliminar.setBounds(400, 130 + altura, 140, 20);
      eliminar.setBackground(new Color(173, 232, 244));
      panel.add(eliminar);

      JCheckBox modificarPacientes = new JCheckBox("Modificar");
      modificarPacientes.setBounds(400, 160 + altura, 140, 20);
      modificarPacientes.setBackground(new Color(173, 232, 244));
      panel.add(modificarPacientes);

      JCheckBox consultarPacientes = new JCheckBox("Consultar");
      consultarPacientes.setBounds(400, 190 + altura, 140, 20);
      consultarPacientes.setBackground(new Color(173, 232, 244));
      panel.add(consultarPacientes);

      JCheckBox historialClinico = new JCheckBox("Historial Clínico");
      historialClinico.setBounds(400, 220 + altura, 140, 20);
      historialClinico.setBackground(new Color(173, 232, 244));
      panel.add(historialClinico);

      JLabel jl_titulo = new JLabel("Permisos");
      JLabel jl_Citas = new JLabel("Citas");
      JLabel jl_pacientes = new JLabel("Pacientes");
      jl_titulo.setBounds(310, 30, 300, 80);
      jl_titulo.setFont(new Font("Arial", Font.BOLD, 28));
      jl_Citas.setBounds(200, 110, 300, 80);
      jl_Citas.setFont(new Font("Arial", Font.BOLD, 18));
      jl_pacientes.setBounds(400, 110, 300, 80);
      jl_pacientes.setFont(new Font("Arial", Font.BOLD, 18));

      panel.add(jl_titulo);
      panel.add(jl_Citas);
      panel.add(jl_pacientes);
      panel.add(jb_Volver);
      panel.add(jb_siguiente);

      // ESCUCHAS
      jb_siguiente.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(WindowMain.jf_ventanaPrincipal, "¿Los datos a modificar son correctos?\n" + //
                  "Nombre: Pepe\n" + //
                  "Teléfono: 234324\n" + //
                  "Correo: ajdfada");
            WindowMain.quitarPanel();
            WindowMain.jf_ventanaPrincipal
                  .add(vistAgregarUsuarioAgregar("<html>Se agrego correctamente <br> " +
                        "<br>" +
                        " <span style='color:red;'>No se agrego correctamente</span></html>"));
         }

      });

      jb_Volver.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            WindowMain.quitarPanel();
            WindowMain.jf_ventanaPrincipal.add(vistAgregarUsuarioAgregar(""));
         }
         
      });

      return panel;

   }

}
