/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aprestjava.tarea1guinachosalcedo;

import javax.swing.JFrame;

/**
 *
 * @author jsalc
 */
public class Test {

    public static void main(String[] args) {

        // Construimos la ventana
        JFrame ventanaPrincipal = new JFrame("Aplicación");

        // Establecemos posición y tamaño
        ventanaPrincipal.setBounds(250, 250, 800, 600);

        // Hacemos visible la ventana
        ventanaPrincipal.setVisible(true);

          // Acción por defecto al pulsar el botón de cierre 
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


