/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.tarea3guinachosal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Windows10
 */
public class Tarea3GUINachoSal extends JPanel {

    //Atributos
    private JButton botonNombre, botonApellidos, botonAleatorio;
    private JTextArea texto;
    private JLabel numero;

    private static Random rd = new Random();

    //Constructor
    public Tarea3GUINachoSal() {
        initComponents();
    }

    private void initComponents() {

        //Creamos los botones
        botonNombre = new JButton("Nombre");
        botonApellidos = new JButton("Apellidos");

        //Le ponemos tamaño al area de texto y le ponemos color
        texto = new JTextArea(1, 25);
        texto.setBackground(Color.green);

        this.setLayout(new FlowLayout());

        //Añadimos los elementos al panel
        this.add(botonNombre);
        this.add(botonApellidos);
        this.add(texto);

        //Usamos clases anonimas para darle funcionalidad cuando le damos al botón 
        botonNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setBackground(Color.white);
                texto.setText("Nacho");
            }
        });

        botonApellidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setBackground(Color.cyan);
                texto.setText("Salcedo");
            }
        });

        botonAleatorio = new JButton("Generar Aleatorio");
        numero = new JLabel("Numero");

        this.add(botonAleatorio);
        this.add(numero);

        botonAleatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numero.setText(String.valueOf(rd.nextInt(11)));
            }
        });

        botonAleatorio.addMouseListener(new MouseListener() {
            //Los métodos están vacíos porque es obligatorio implementarlos
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                botonAleatorio.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                botonAleatorio.setBackground(null);
            }
        });

    }

    public static void main(String[] args) {
        // Construimos la ventana
        JFrame frame = new JFrame("App");
        // La ventana no se puede redimensionar
        frame.setResizable(false);
        // Posición de la ventana
        frame.setLocationRelativeTo(null);
        // Incluimos el panel en la ventana
        frame.add(new Tarea3GUINachoSal());
        // Ajusta el frame al contenido
        frame.pack();
        // Hacemos visible la ventana
        frame.setVisible(true);
        //Acción por defecto al pulsar el botón de cierre de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
