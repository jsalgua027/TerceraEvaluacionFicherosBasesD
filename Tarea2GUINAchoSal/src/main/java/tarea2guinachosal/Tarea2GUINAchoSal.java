/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package tarea2guinachosal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Windows10
 */
public class Tarea2GUINAchoSal extends JPanel implements ActionListener {

    private JButton boton1;
    private JButton boton2;
    private JTextArea texto1;

    public Tarea2GUINAchoSal() {
        initComponents();
    }

    private void initComponents() {
        // Tamaño del panel
        this.setPreferredSize(new Dimension(600, 200));

        // Borde del panel
        this.setBorder(new TitledBorder("AnexoIl Eventos y controladores"));

        // Creamos el botón, con un texto a mostrar
        boton1 = new JButton("Nombre");
        boton2 = new JButton("Apellidos");
        texto1 = new JTextArea(1, 25);

        // Establecemos el color de fondo del textArea
        texto1.setBackground(Color.GRAY);

        // Posicionamiento de componentes con FlowLayout
        this.setLayout(new FlowLayout());

        // Añadimos los componentes al panel
        this.add(boton1);
        this.add(boton2);
        this.add(texto1);
        // la llmada al metodo del boton
        boton1.addActionListener(this);
        boton2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(boton1)) {
            texto1.setBackground(Color.WHITE);
            texto1.setText("MI nombre es nacho");
        } else if (e.getSource().equals(boton2)) {
            texto1.setBackground(Color.BLUE);
                texto1.setText("MI apellido es Salcedo");
        }
    }

    public static void main(String[] args) {
        // Construimos la ventana
        JFrame frame = new JFrame("App");
        // La ventana no se puede redimensionar
        frame.setResizable(false);
        // Posición de la ventana
        frame.setLocationRelativeTo(null);
        // Incluimos el panel en la ventana
        frame.add(new Tarea2GUINAchoSal());
        // Ajusta el frame al contenido
        frame.pack();
        // Hacemos visible la ventana
        frame.setVisible(true);
        //Acción por defecto al pulsar el botón de cierre de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
