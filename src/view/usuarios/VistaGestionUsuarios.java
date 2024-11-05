package view.usuarios;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaGestionUsuarios {
   public static void main(String[] args) {
    VistaGestionUsuarios j = new VistaGestionUsuarios();
    j.vistaPermisos();
   }

   public JPanel vistaPermisos(){
        int altura = 60;
        JPanel jp_panel = new JPanel();
        jp_panel.setLayout(null);
        jp_panel.setBackground(new Color(173, 232, 244));

        JCheckBox agendar = new JCheckBox("Agendar");
        agendar.setBounds(200, 100+altura, 140, 20);
        agendar.setBackground(new Color(173, 232, 244));
        jp_panel.add(agendar);

        JCheckBox cancelar = new JCheckBox("Cancelar");
        cancelar.setBounds(200, 130+altura, 140, 20);
        cancelar.setBackground(new Color(173, 232, 244));
        jp_panel.add(cancelar);

        JCheckBox modificar = new JCheckBox("modificar");
        modificar.setBounds(200, 160+altura, 140, 20);
        modificar.setBackground(new Color(173, 232, 244));
        jp_panel.add(modificar);

        
        JCheckBox consultar = new JCheckBox("Consultar");
        consultar.setBounds(200, 190+altura, 140, 20);
        consultar.setBackground(new Color(173, 232, 244));
        jp_panel.add(consultar);

        JCheckBox recordatorios = new JCheckBox("recordatorios");
        recordatorios.setBounds(200, 220+altura, 140, 20);
        recordatorios.setBackground(new Color(173, 232, 244));
        jp_panel.add(recordatorios);


        

        JCheckBox eliminar = new JCheckBox("Cancelar");
        eliminar.setBounds(400, 130+altura, 140, 20);
        eliminar.setBackground(new Color(173, 232, 244));
        jp_panel.add(eliminar);

        JCheckBox modificarPacientes = new JCheckBox("modificar");
        modificarPacientes.setBounds(400, 160+altura, 140, 20);
        modificarPacientes.setBackground(new Color(173, 232, 244));
        jp_panel.add(modificarPacientes);

        
        JCheckBox consultarPacientes = new JCheckBox("Consultar");
        consultarPacientes.setBounds(400, 190+altura, 140, 20);
        consultarPacientes.setBackground(new Color(173, 232, 244));
        jp_panel.add(consultarPacientes);

        JCheckBox historialClinico = new JCheckBox("recordatorios");
        historialClinico.setBounds(400, 220+altura, 140, 20);
        historialClinico.setBackground(new Color(173, 232, 244));
        jp_panel.add(historialClinico);

        JLabel jl_titulo = new JLabel("Permisos");
        JLabel jl_Citas = new JLabel("Citas");
        JLabel jl_pacientes = new JLabel("Pacientes");
        jl_titulo.setBounds(310, 30, 300, 80);
        jl_titulo.setFont(new Font("Arial", Font.BOLD, 28));
        jl_Citas.setBounds(200, 110, 300, 80);
        jl_Citas.setFont(new Font("Arial", Font.BOLD, 18));
        jl_pacientes.setBounds(400, 110, 300, 80);
        jl_pacientes.setFont(new Font("Arial", Font.BOLD, 18));

        jp_panel.add(jl_titulo);
        jp_panel.add(jl_Citas);
        jp_panel.add(jl_pacientes);
        
        return jp_panel;

   }
}
