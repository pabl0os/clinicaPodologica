package view.usuarios;

import controller.WindowMain;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VistaEntrar {

  JPanel jp_panelprincipal;

  // LOGIN
  JPanel jp_login;

  public JPanel getJp_login() {
    if (jp_login == null) {
      jp_login = new JPanel();

      // variables
      JLabel jl_titulo = new JLabel("Clinica Podologica Zane");
      JLabel jl_correo = new JLabel("Correo");
      JLabel jl_pass = new JLabel("Contraseña");
      JTextField jtf_correo = new JTextField(15);
      JPasswordField jpf_pass = new JPasswordField(15);
      ImageIcon logo = new ImageIcon("src/image/Sin título.png");
      JLabel jl_imagen = new JLabel(logo);
      JButton jb_entrar = new JButton("Entrar");

      // ATRIBUTOS
      jl_titulo.setFont(new Font("Arial", Font.BOLD, 24));
      jl_titulo.setBounds(250, 50, 400, 40);
      jl_correo.setBounds(250, 150, 50, 20);
      jl_pass.setBounds(230, 200, 70, 20);
      jl_imagen.setBounds(500, -150, 400, 400);

      jp_login.setBackground(new Color(173, 232, 244));
      jp_login.setLayout(null);

      jtf_correo.setBounds(300, 150, 140, 20);

      jpf_pass.setBounds(300, 200, 140, 20);

      jb_entrar.setBounds(350, 300, 70, 30);

      // ARMADO
      jp_login.add(jtf_correo);
      jp_login.add(jl_correo);
      jp_login.add(jpf_pass);
      jp_login.add(jl_pass);
      jp_login.add(jl_titulo);
      jp_login.add(jl_imagen);
      jp_login.add(jb_entrar);

      JMenuBar menuBar = WindowMain.menuBar;
      JFrame jf_ventanaPrincipal = WindowMain.jf_ventanaPrincipal;

      // ESCUCHAS
      jb_entrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

          jf_ventanaPrincipal.setJMenuBar(menuBar);
          jf_ventanaPrincipal.add(getJp_principal());
          jf_ventanaPrincipal.remove(jp_login);
          jf_ventanaPrincipal.repaint();
          jf_ventanaPrincipal.revalidate();
        }
      });

      // MOSTRAR
    }
    return jp_login;
  }

  public JPanel getJp_principal(){
    if(jp_panelprincipal == null){


      // VARIABLES
      jp_panelprincipal = new JPanel();
      ImageIcon logo = new ImageIcon("src/image/imagenMediana.png");
      JLabel jl_imagen = new JLabel(logo);
      
      // ATRIBUTOS 
      jl_imagen.setBounds(120, 50, 550, 400);

      jp_panelprincipal.setBackground(new Color(173, 232, 244));

      jp_panelprincipal.setLayout(null);


      // ARMADO 
      jp_panelprincipal.add(jl_imagen);

      // ESCUCHAS 

      // MOSTRAR 


    }
    return jp_panelprincipal;
  }

}
