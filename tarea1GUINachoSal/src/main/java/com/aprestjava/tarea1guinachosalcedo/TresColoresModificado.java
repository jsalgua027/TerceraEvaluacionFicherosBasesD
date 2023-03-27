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
public class TresColoresModificado  extends JPanel{

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
    public TresColoresModificado(Color color) {
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
        
        
        
        TresColoresModificado p1 = new TresColoresModificado(Color.pink);
        TresColoresModificado p2 = new TresColoresModificado(Color.yellow);
        TresColoresModificado p3 = new TresColoresModificado(Color.red);
        TresColoresModificado p4 = new TresColoresModificado(Color.blue);
        TresColoresModificado p5 = new TresColoresModificado(Color.green);
        
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
