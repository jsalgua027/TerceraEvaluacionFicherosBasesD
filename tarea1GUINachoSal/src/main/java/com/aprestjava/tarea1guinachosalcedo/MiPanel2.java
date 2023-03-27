/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.aprestjava.tarea1guinachosalcedo;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jsalc
 */
public class MiPanel2  extends JPanel{

    /**
     * @param args the command line arguments
     * 
     * 
     * 
     */
    
     // Añadimos un componente de tipo etiqueta (JLabel)
    private JLabel etiqueta;

    // Constructor pasando un color, que llama al método initComponents(),
    // y luego al método cambiarColorFondo 
    public MiPanel2(Color color) {
        initComponents();
        cambiarColorFondo(color);
    }

    // Método que inicializa los elementos gráficos del formulario
    private void initComponents() {
        // Construimos la etiqueta con el texto que queremos que muestre
      this.etiqueta = new JLabel("Etiqueta de MiPanel");
        // Añade la etiqueta al contenedor MiPanel (al JPanel)
        this.add(etiqueta);
    }

    private void cambiarColorFondo(Color color) {
        // Establece el color de fondo del panel
      this.setBackground(color);
    }

    // Método getter
    public JLabel getEtiqueta() {
        return etiqueta;
    }
    
    
    
    public static void main(String[] args) {
        // Construimos la ventana
        JFrame ventanaPrincipal = new JFrame("Aplicación");

        // Establecemos tamaño y posición
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setLocationRelativeTo(null);

        // Hacemos visible la ventana
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setResizable(false);

        // Acción por defecto al pulsar el botón de cierre de la ventana
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     //   ventanaPrincipal.pack();

        ventanaPrincipal.setLayout(new BorderLayout());
        
        
        
        MiPanel2 p1 = new MiPanel2(Color.pink);
        MiPanel2 p2 = new MiPanel2(Color.yellow);
        MiPanel2 p3 = new MiPanel2(Color.red);
        MiPanel2 p4 = new MiPanel2(Color.blue);
        MiPanel2 p5 = new MiPanel2(Color.green);
        
        p1.etiqueta.setText("hola");
        p2.etiqueta.setText("Que tal?");
        p3.etiqueta.setText("Prueba");
        p4.etiqueta.setText("Mar");
        p5.etiqueta.setText("Estructura");

// Añadimos los paneles en cada posición del BorderLayout
// Añadir panel amarillo en la posición superior (NORTH)
        ventanaPrincipal.add(p1, BorderLayout.CENTER);
        ventanaPrincipal.add(p2, BorderLayout.EAST);
        ventanaPrincipal.add(p3, BorderLayout.NORTH);
        ventanaPrincipal.add(p4, BorderLayout.SOUTH);
        ventanaPrincipal.add(p5, BorderLayout.WEST);
        
    }

}
