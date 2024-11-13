package view.usuarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.table.DefaultTableModel;

import controller.WindowMain;
import controller.Pacientes.controlPacientes;
import controller.User.ControlUsuarios;
import model.objects.User.user;

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
      String texto = "";
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
      ControlUsuarios control = new ControlUsuarios();
      jb_botonPanel.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (tablaPacientes.getSelectedRow() == -1) {
               JOptionPane.showMessageDialog(null, "Por favor, selecciona un paciente de la lista.",
                     "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
               String nombre = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 0);
               String pass = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 1);
               String correo = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 2);
               String Rol = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 3);
               int respuesta = JOptionPane.showConfirmDialog(WindowMain.jf_ventanaPrincipal,
                     "¿Estas seguro de eliminar al usuario?\n" + //
                           "Nombre: " + nombre + "\n" + //
                           "Teléfono: " + pass + "\n" + //
                           "Teléfono: " + correo + "\n" + //
                           "Correo: " + Rol,
                     "Confimación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
               if (respuesta == JOptionPane.OK_OPTION) {
                  // -----------------------------
                  user usuario = new user(nombre, pass, correo, Rol);
                  if (control.eliminarUsuario(usuario)) {
                     jl_textoinformativo.setText("<html>Se realizo correctamente <br>la eliminacion </html>");
                     jb_Buscar.doClick();
                  } else {
                     jl_textoinformativo.setText(
                           "<html><span style='color:red;'>No se realizo correctamente la eliminacion</span></html>");
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
               }

            }
         }

      });

      jb_Buscar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (jtf_busqueda.getText() == "") {
               model.setDataVector(control.consultarAllUsers(), columnas);
            } else {
               model.setDataVector(control.consultarUsers((String) comboBox.getSelectedItem(), jtf_busqueda.getText()),
                     columnas);
            }
         }

      });
      // MOSTRAR

      return jp_panel;
   }

   // MODIFICAR
   private static user usuarioModificar = new user();
   private static user nuevoUserModificar = new user();

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
      ControlUsuarios control = new ControlUsuarios();
      jb_botonPanel.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (tablaPacientes.getSelectedRow() == -1) {
               JOptionPane.showMessageDialog(null, "Por favor, selecciona un paciente de la lista.",
                     "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
               String nombre = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 0);
               String pass = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 1);
               String email = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 2);
               String rol = (String) tablaPacientes.getValueAt(tablaPacientes.getSelectedRow(), 3);
               usuarioModificar.setName(nombre);
               usuarioModificar.setPass(pass);
               usuarioModificar.setEmail(email);
               usuarioModificar.setRol(rol);
               usuarioModificar = control.consultarUser(usuarioModificar);
               WindowMain.quitarPanel();
               WindowMain.jf_ventanaPrincipal.add(vistAgregarUsuarioModificar());
            }
         }

      });

      jb_Buscar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (jtf_busqueda.getText() == "") {
               model.setDataVector(control.consultarAllUsers(), columnas);
            } else {
               model.setDataVector(control.consultarUsers((String) comboBox.getSelectedItem(), jtf_busqueda.getText()),
                     columnas);
            }
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
      JTextField jtf_nombre = new JTextField(usuarioModificar.getName());
      JTextField jtf_pass = new JTextField(usuarioModificar.getPass());
      JTextField jtf_correo = new JTextField(usuarioModificar.getEmail());
      JButton jb_volver = new JButton("Volver");
      String[] roles = { "Asistente", "Podólogo" };
      @SuppressWarnings("rawtypes")
      JComboBox jcb_roles = new JComboBox<>(roles);
      if (usuarioModificar.getRol().equals("Podólogo")) {
         jcb_roles.setSelectedIndex(1);
      }
      // ATRIBUTOS
      jp_panel.setLayout(null);
      jp_panel.setBackground(new Color(173, 232, 244));

      panelIntermedio.setBounds(190, 100, 400, 300);
      panelIntermedio.setLayout(null);

      jtf_nombre.setBounds(130, 30, 140, 30);
      jtf_pass.setBounds(130, 100, 140, 30);
      jtf_correo.setBounds(130, 170, 140, 30);
      jb_Listo.setForeground(Color.WHITE);

      jb_Listo.setBackground(new Color(0, 150, 199));
      jb_Listo.setBounds(350, 450, 80, 30);

      jb_volver.setBackground(new Color(0, 150, 199));
      jb_volver.setForeground(Color.WHITE);
      jb_volver.setBounds(30, 30, 80, 30);

      jcb_roles.setBounds(130, 220, 140, 30);

      JLabel jl_nombre = new JLabel("Nombre");
      JLabel jl_pass = new JLabel("Contraseña");
      JLabel jl_Correo = new JLabel("Correo");
      jl_nombre.setBounds(50, 30, 80, 30);
      jl_pass.setBounds(50, 100, 80, 30);
      jl_Correo.setBounds(50, 170, 80, 30);
      panelIntermedio.add(jl_Correo);
      panelIntermedio.add(jl_nombre);
      panelIntermedio.add(jl_pass);

      // ARMADO
      jp_panel.add(panelIntermedio);
      panelIntermedio.add(jtf_nombre);
      panelIntermedio.add(jtf_pass);
      panelIntermedio.add(jtf_correo);
      panelIntermedio.add(jcb_roles);
      jp_panel.add(jb_Listo);
      jp_panel.add(jb_volver);

      // ESCUCHAS
      jb_Listo.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            nuevoUserModificar.setName(jtf_nombre.getText());
            nuevoUserModificar.setPass(jtf_pass.getText());
            nuevoUserModificar.setEmail(jtf_correo.getText());
            nuevoUserModificar.setRol((String) jcb_roles.getSelectedItem());
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
      agendar.setSelected(usuarioModificar.isAgendarCita());
      agendar.setBounds(200, 100 + altura, 140, 20);
      agendar.setBackground(new Color(173, 232, 244));
      panel.add(agendar);

      JCheckBox cancelar = new JCheckBox("Cancelar");
      cancelar.setSelected(usuarioModificar.isCancelarCita());
      cancelar.setBounds(200, 130 + altura, 140, 20);
      cancelar.setBackground(new Color(173, 232, 244));
      panel.add(cancelar);

      JCheckBox modificar = new JCheckBox("modificar");
      modificar.setSelected(usuarioModificar.isModificarCita());
      modificar.setBounds(200, 160 + altura, 140, 20);
      modificar.setBackground(new Color(173, 232, 244));
      panel.add(modificar);

      JCheckBox consultar = new JCheckBox("Consultar");
      consultar.setSelected(usuarioModificar.isConsultarCita());
      consultar.setBounds(200, 190 + altura, 140, 20);
      consultar.setBackground(new Color(173, 232, 244));
      panel.add(consultar);

      JCheckBox recordatorios = new JCheckBox("recordatorios");
      recordatorios.setSelected(usuarioModificar.isRecordatoriosCita());
      recordatorios.setBounds(200, 220 + altura, 140, 20);
      recordatorios.setBackground(new Color(173, 232, 244));
      panel.add(recordatorios);

      JCheckBox eliminar = new JCheckBox("Eliminar");
      eliminar.setSelected(usuarioModificar.isEliminarPaciente());
      eliminar.setBounds(400, 130 + altura, 140, 20);
      eliminar.setBackground(new Color(173, 232, 244));
      panel.add(eliminar);

      JCheckBox modificarPacientes = new JCheckBox("Modificar");
      modificarPacientes.setSelected(usuarioModificar.isModificarPaciente());
      modificarPacientes.setBounds(400, 160 + altura, 140, 20);
      modificarPacientes.setBackground(new Color(173, 232, 244));
      panel.add(modificarPacientes);

      JCheckBox consultarPacientes = new JCheckBox("Consultar");
      consultarPacientes.setSelected(usuarioModificar.isConsultarPaciente());
      consultarPacientes.setBounds(400, 190 + altura, 140, 20);
      consultarPacientes.setBackground(new Color(173, 232, 244));
      panel.add(consultarPacientes);

      JCheckBox historialClinico = new JCheckBox("Historial Clínico");
      historialClinico.setSelected(usuarioModificar.isHistorialClinico());
      historialClinico.setBounds(400, 220 + altura, 140, 20);
      historialClinico.setBackground(new Color(173, 232, 244));
      panel.add(historialClinico);

      JCheckBox Agregar = new JCheckBox("Agregar");
      Agregar.setSelected(usuarioModificar.isAgregarPaciente());
      Agregar.setBounds(400, 100 + altura, 140, 20);
      Agregar.setBackground(new Color(173, 232, 244));
      panel.add(Agregar);

      JCheckBox imprimirJustificante = new JCheckBox("Imprimir Justificante");
      imprimirJustificante.setSelected(usuarioModificar.isImprimirJustificante());
      imprimirJustificante.setBounds(600, 100 + altura, 140, 20);
      imprimirJustificante.setBackground(new Color(173, 232, 244));
      panel.add(imprimirJustificante);

      JCheckBox imprimirReceta = new JCheckBox("Imprimir Receta");
      imprimirReceta.setSelected(usuarioModificar.isImprimirReceta());
      imprimirReceta.setBounds(600, 130 + altura, 140, 20);
      imprimirReceta.setBackground(new Color(173, 232, 244));
      panel.add(imprimirReceta);

      JLabel jl_titulo = new JLabel("Permisos");
      JLabel jl_Citas = new JLabel("Citas");
      JLabel jl_pacientes = new JLabel("Pacientes");
      JLabel jl_Otros = new JLabel("Otros");
      jl_Otros.setBounds(600, 130, 300, 25);
      jl_Otros.setFont(new Font("Arial", Font.BOLD, 18));
      jl_titulo.setBounds(310, 30, 300, 80);
      jl_titulo.setFont(new Font("Arial", Font.BOLD, 28));
      jl_Citas.setBounds(200, 110, 300, 80);
      jl_Citas.setFont(new Font("Arial", Font.BOLD, 18));
      jl_pacientes.setBounds(400, 110, 300, 80);
      jl_pacientes.setFont(new Font("Arial", Font.BOLD, 18));

      panel.add(jl_titulo);
      panel.add(jl_Citas);
      panel.add(jl_pacientes);
      panel.add(jl_Otros);
      panel.add(jb_Volver);
      panel.add(jb_siguiente);

      // ESCUCHAS
      ControlUsuarios control = new ControlUsuarios();
      jb_siguiente.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
              // estableciendo permisos
              nuevoUserModificar.setAgendarCita(agendar.isSelected());
              nuevoUserModificar.setCancelarCita(cancelar.isSelected());
              nuevoUserModificar.setModificarCita(modificar.isSelected());
              nuevoUserModificar.setConsultarCita(consultar.isSelected());
              nuevoUserModificar.setRecordatoriosCita(recordatorios.isSelected());
              nuevoUserModificar.setAgregarPaciente(Agregar.isSelected());
              nuevoUserModificar.setEliminarPaciente(eliminar.isSelected());
              nuevoUserModificar.setModificarPaciente(modificarPacientes.isSelected());
              nuevoUserModificar.setConsultarPaciente(consultarPacientes.isSelected());
              nuevoUserModificar.setHistorialClinico(historialClinico.isSelected());
              nuevoUserModificar.setImprimirJustificante(imprimirJustificante.isSelected());
              nuevoUserModificar.setImprimirReceta(imprimirReceta.isSelected());
              int respuesta = JOptionPane.showConfirmDialog(WindowMain.jf_ventanaPrincipal,
                    "¿Son correctos?\n" + //
                          "Nombre: " + nuevoUserModificar.getName() + "\n" +
                          "Contraseña: " + nuevoUserModificar.getPass() + "\n" +
                          "Correo: " + nuevoUserModificar.getEmail() + "\n",
                    "Confimación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
  
              if (respuesta == JOptionPane.OK_OPTION) {
                 WindowMain.quitarPanel();
                 if (control.modificarUsuario(usuarioModificar, nuevoUserModificar)) {
                    WindowMain.jf_ventanaPrincipal
                          .add(vistaBuscarModificar("<html>Se modifico correctamente</html>"));
                 } else {
                    WindowMain.jf_ventanaPrincipal
                          .add(vistaBuscarModificar(
                                "<html><span style='color:red;'>No se modifico correctamente</span></html>"));
                 }
              }
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
      String[] opcionesComboBox = { "Nombre", "Correo" };
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

      JComboBox<String> comboBox = new JComboBox<>(opcionesComboBox);
      comboBox.setBounds(500, 80, 100, 30);

      scrollPane.setBounds(30, 150, 550, 350);

      // ARMADO
      jp_panel.add(jtf_busqueda);
      jp_panel.add(jb_Buscar);
      jp_panel.add(comboBox);
      jp_panel.add(scrollPane);

      // ESCUCHAS
      ControlUsuarios control = new ControlUsuarios();
      jb_Buscar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            model.setDataVector(control.consultarUsers((String) comboBox.getSelectedItem(), jtf_busqueda.getText()),
                  columnas);
         }

      });

      // MOSTRAR

      return jp_panel;
   }

   // AGREGAR
   private static user myuser = new user();

   public static JPanel vistAgregarUsuarioAgregar(String texto) {
      JPanel jp_panel;
      JButton jb_Listo = new JButton("Agregar");

      // VARIABLES
      jp_panel = new JPanel();
      JPanel panelIntermedio = new JPanel();
      JTextField jtf_nombre = new JTextField();
      JTextField jtf_pass = new JTextField();
      JTextField jtf_correo = new JTextField();
      JLabel jl_textoinformativo = new JLabel(texto);

      String[] roles = { "Asistente", "Podólogo" };
      @SuppressWarnings("rawtypes")
      JComboBox jcb_roles = new JComboBox<>(roles);
      // ATRIBUTOS
      jp_panel.setLayout(null);
      jp_panel.setBackground(new Color(173, 232, 244));

      panelIntermedio.setBounds(190, 100, 400, 300);
      panelIntermedio.setLayout(null);

      jtf_nombre.setBounds(130, 30, 140, 30);
      jtf_pass.setBounds(130, 100, 140, 30);
      jtf_correo.setBounds(130, 170, 140, 30);
      jb_Listo.setForeground(Color.WHITE);

      jb_Listo.setBackground(new Color(0, 150, 199));
      jb_Listo.setBounds(350, 450, 80, 30);

      jcb_roles.setBounds(130, 220, 140, 30);

      jl_textoinformativo.setBounds(600, 350, 200, 200);
      jl_textoinformativo.setVisible(true);

      JLabel jl_nombre = new JLabel("Nombre");
      JLabel jl_pass = new JLabel("Contraseña");
      JLabel jl_Correo = new JLabel("Correo");
      jl_nombre.setBounds(50, 30, 80, 30);
      jl_pass.setBounds(50, 100, 80, 30);
      jl_Correo.setBounds(50, 170, 80, 30);
      panelIntermedio.add(jl_Correo);
      panelIntermedio.add(jl_nombre);
      panelIntermedio.add(jl_pass);

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
      panelIntermedio.add(jtf_pass);
      panelIntermedio.add(jtf_correo);
      panelIntermedio.add(jcb_roles);
      jp_panel.add(jb_Listo);
      jp_panel.add(jl_textoinformativo);

      // ESCUCHAS

      jb_Listo.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

            int respuesta = JOptionPane.showConfirmDialog(WindowMain.jf_ventanaPrincipal,
                  "¿Son correctos?\n" + //
                        "Nombre: " + jtf_nombre.getText() + "\n" +
                        "contraseña: " + jtf_pass.getText() + "\n" +
                        "Correo: " + jtf_correo.getText() + "\n" +
                        "Rol: " + jcb_roles.getSelectedItem(),
                  "Confimación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (respuesta == JOptionPane.OK_OPTION) {
               myuser.setName(jtf_nombre.getText());
               myuser.setPass(jtf_pass.getText());
               myuser.setEmail(jtf_correo.getText());
               myuser.setRol((String) jcb_roles.getSelectedItem());
               WindowMain.quitarPanel();
               WindowMain.jf_ventanaPrincipal.add(vistaPermisosAgregar());
            }
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

      JCheckBox imprimirJustificante = new JCheckBox("Imprimir Justificante");
      imprimirJustificante.setBounds(600, 100 + altura, 140, 20);
      imprimirJustificante.setBackground(new Color(173, 232, 244));
      panel.add(imprimirJustificante);

      JCheckBox imprimirReceta = new JCheckBox("Imprimir Receta");
      imprimirReceta.setBounds(600, 130 + altura, 140, 20);
      imprimirReceta.setBackground(new Color(173, 232, 244));
      panel.add(imprimirReceta);

      JLabel jl_titulo = new JLabel("Permisos");
      JLabel jl_Citas = new JLabel("Citas");
      JLabel jl_pacientes = new JLabel("Pacientes");
      JLabel jl_Otros = new JLabel("Otros");
      jl_Otros.setBounds(600, 130, 300, 25);
      jl_Otros.setFont(new Font("Arial", Font.BOLD, 18));
      jl_titulo.setBounds(310, 30, 300, 80);
      jl_titulo.setFont(new Font("Arial", Font.BOLD, 28));
      jl_Citas.setBounds(200, 110, 300, 80);
      jl_Citas.setFont(new Font("Arial", Font.BOLD, 18));
      jl_pacientes.setBounds(400, 110, 300, 80);
      jl_pacientes.setFont(new Font("Arial", Font.BOLD, 18));

      panel.add(jl_titulo);
      panel.add(jl_Citas);
      panel.add(jl_pacientes);
      panel.add(jl_Otros);
      panel.add(jb_Volver);
      panel.add(jb_siguiente);

      List<JCheckBox> boxes = new ArrayList<>();
      boxes.add(agendar);
      boxes.add(cancelar);
      boxes.add(modificar);
      boxes.add(consultar);
      boxes.add(recordatorios);
      boxes.add(Agregar);
      boxes.add(eliminar);
      boxes.add(modificarPacientes);
      boxes.add(consultarPacientes);
      boxes.add(historialClinico);
      boxes.add(imprimirJustificante);
      boxes.add(imprimirReceta);

      // List<JCheckBox> boxesCitas = new ArrayList<>();
      // boxesCitas.add(agendar);
      // boxesCitas.add(cancelar);
      // boxesCitas.add(modificar);
      // boxesCitas.add(consultar);
      // boxesCitas.add(recordatorios);

      // List<JCheckBox> boxesPacientes = new ArrayList<>();
      // boxesPacientes.add(Agregar);
      // boxesPacientes.add(eliminar);
      // boxesPacientes.add(modificarPacientes);
      // boxesPacientes.add(consultarPacientes);
      // boxesPacientes.add(historialClinico);

      // List<JCheckBox> boxesOtros = new ArrayList<>();
      // boxesOtros.add(imprimirJustificante);
      // boxesOtros.add(imprimirReceta);

      // ESCUCHAS
      ControlUsuarios control = new ControlUsuarios();
      jb_siguiente.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // estableciendo permisos
            myuser.setAgendarCita(agendar.isSelected());
            myuser.setCancelarCita(cancelar.isSelected());
            myuser.setModificarCita(modificar.isSelected());
            myuser.setConsultarCita(consultar.isSelected());
            myuser.setRecordatoriosCita(recordatorios.isSelected());
            myuser.setAgregarPaciente(Agregar.isSelected());
            myuser.setEliminarPaciente(eliminar.isSelected());
            myuser.setModificarPaciente(modificarPacientes.isSelected());
            myuser.setConsultarPaciente(consultarPacientes.isSelected());
            myuser.setHistorialClinico(historialClinico.isSelected());
            myuser.setImprimirJustificante(imprimirJustificante.isSelected());
            myuser.setImprimirReceta(imprimirReceta.isSelected());
            int respuesta = JOptionPane.showConfirmDialog(WindowMain.jf_ventanaPrincipal,
                  "¿Son correctos?\n" + //
                        "Nombre: " + myuser.getName() + "\n" +
                        "Contraseña: " + myuser.getPass() + "\n" +
                        "Correo: " + myuser.getEmail() + "\n",
                  "Confimación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (respuesta == JOptionPane.OK_OPTION) {
               WindowMain.quitarPanel();
               if (control.agregarUsuario(myuser)) {
                  WindowMain.jf_ventanaPrincipal
                        .add(vistAgregarUsuarioAgregar("<html>Se agrego correctamente</html>"));
               } else {
                  WindowMain.jf_ventanaPrincipal
                        .add(vistAgregarUsuarioAgregar(
                              "<html><span style='color:red;'>No se agrego correctamente</span></html>"));
               }
            }

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
