package view.usuarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.WindowMain;

public class VistaGestionUsuarios {

   private static JPanel panel;
   public static JPanel vistaPermisos(){return panel;}
   private static JButton jb_siguiente = new JButton("Siguiente");
   public static JPanel vistaPermisos(ActionListener escucha) {

      jb_siguiente.addActionListener(escucha);
      if (panel == null) {
         
         panel = new JPanel();
         int altura = 60;
         JButton jb_Volver = new JButton("Volver");
         jb_Volver.setBounds(20, 20, 80, 30);
         jb_siguiente.setBounds(600, 450, 120, 30);
         
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
         
         JCheckBox eliminar = new JCheckBox("Cancelar");
         eliminar.setBounds(400, 130 + altura, 140, 20);
         eliminar.setBackground(new Color(173, 232, 244));
         panel.add(eliminar);
         
         JCheckBox modificarPacientes = new JCheckBox("modificar");
         modificarPacientes.setBounds(400, 160 + altura, 140, 20);
         modificarPacientes.setBackground(new Color(173, 232, 244));
         panel.add(modificarPacientes);
         
         JCheckBox consultarPacientes = new JCheckBox("Consultar");
         consultarPacientes.setBounds(400, 190 + altura, 140, 20);
         consultarPacientes.setBackground(new Color(173, 232, 244));
         panel.add(consultarPacientes);
         
         JCheckBox historialClinico = new JCheckBox("recordatorios");
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
      }
      return panel;

   }

   private static JPanel jp_panel;
   private static JButton jb_Listo = new JButton("Agregar");

   public static JPanel vistAgregarUsuario(ActionListener escucha) {

      if (jp_panel == null) {

         // VARIABLES
         jp_panel = new JPanel();
         JPanel panelIntermedio = new JPanel();
         JTextField jtf_nombre = new JTextField("Nombre");
         JTextField jtf_Numero = new JTextField("Contraseña");
         JTextField jtf_correo = new JTextField("Correo");
         JButton jb_volver = new JButton("Volver");
         String[] roles = {"asistente","podologo"};
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
               WindowMain.jf_ventanaPrincipal.add(vistaPermisos(escucha));
            }
            
         });
         // MOSTRAR


      }
      return jp_panel;

   }
}
