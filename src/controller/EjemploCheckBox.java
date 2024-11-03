package controller;
import java.awt.FlowLayout;

import javax.swing.*;

public class EjemploCheckBox {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JCheckBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        
        // Crear un JCheckBox
        JCheckBox checkBox = new JCheckBox("Acepto los términos y condiciones");
        
        // Configuración del layout y agregar el checkbox
        frame.setLayout(new FlowLayout());
        frame.add(checkBox);
        
        // Mostrar la ventana
        frame.setVisible(true);
    }
}


