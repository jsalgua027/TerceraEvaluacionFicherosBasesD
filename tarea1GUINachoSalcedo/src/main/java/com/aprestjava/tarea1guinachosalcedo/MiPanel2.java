/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.aprestjava.tarea1guinachosalcedo;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author jsalc
 */
public class MiPanel2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Construimos la ventana
        JFrame ventanaPrincipal = new JFrame("Aplicación");

        // Establecemos tamaño y posición
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setLocationRelativeTo(null);

        // Hacemos visible la ventana
        ventanaPrincipal.setVisible(true);

        // Acción por defecto al pulsar el botón de cierre de la ventana
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventanaPrincipal.pack();

        ventanaPrincipal.setLayout(new BorderLayout());

// Añadimos los paneles en cada posición del BorderLayout
// Añadir panel amarillo en la posición superior (NORTH)
        ventanaPrincipal.add(new MiPanel(Color.yellow), BorderLayout.NORTH);

        // Añadir panel rojo en la posición inferior (SOUTH)
        ventanaPrincipal.add(new MiPanel(Color.red), BorderLayout.SOUTH);

// Añadir panel gris en la posición central (CENTER)
        ventanaPrincipal.add(new MiPanel(Color.gray), BorderLayout.CENTER);

// Añadir panel verde en la posición izquierda (WEST)
        ventanaPrincipal.add(new MiPanel(Color.green), BorderLayout.WEST);

// Añadir panel cián en la posición derecha (EAST)
        ventanaPrincipal.add(new MiPanel(Color.cyan), BorderLayout.EAST);

    }

}
