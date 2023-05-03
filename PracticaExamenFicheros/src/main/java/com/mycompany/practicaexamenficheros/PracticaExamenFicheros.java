/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.practicaexamenficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows10
 */
public class PracticaExamenFicheros {

    public static void escritura(List<String> aux, String ruta) {

        String tmp = " ";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {

            for (String s : aux) {
                tmp = s.toString();
                flujo.write(tmp);
                flujo.newLine();
            }

            flujo.flush();

            System.out.println("Fichero " + ruta + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void leerCsvYcrearObjeto(String ruta) {

        // Fichero a leer con datos de ejemplo
        String idFichero = ruta;

        // Variables para guardar los datos que se van leyendo
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                Autobus aux = new Autobus();
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                List<LocalTime> listaHorarios = new ArrayList<>();

                //  patron codigo autobus
                String expCodi = "[0-9]+[A-Z]{1}";
                Pattern pattern = Pattern.compile(expCodi);
                Matcher matcher = pattern.matcher(linea);

                while (matcher.find()) {
                    aux.setCodigoBus(matcher.group());

                }

                // patron origen destino
                // cada parentisis es un grupo 
                String expOrigeDestino = "([A-Za-z\\s]+)-\\s([A-Za-z\\s]+)";
                pattern = Pattern.compile(expOrigeDestino);
                matcher = pattern.matcher(linea);

                while (matcher.find()) {
                    aux.setOrigen(matcher.group(1));
                    aux.setDestino(matcher.group(2));

                }
                // aqui cojo los horarios solo de cada linea
                String expHorarios = "[0-9]{2}:[0-9]{2}";
                pattern = Pattern.compile(expHorarios);
                matcher = pattern.matcher(linea);
                // meto cada horario en la lista
                while (matcher.find()) {
                    listaHorarios.add(LocalTime.parse(matcher.group()));

                }
                aux.setHorarios(listaHorarios);
                System.out.println(aux.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {

        String palabra = "";
        List<String> listadoPalabras = new ArrayList();
        JOptionPane.showMessageDialog(null, "Indique las palabras que quiera, para terminar indique terminar");
        do {

            palabra = JOptionPane.showInputDialog(palabra);
            if (palabra.contains("teminar")) {

            } else {
                listadoPalabras.add(palabra);
            }

        } while (!palabra.contains("terminar"));

        listadoPalabras.remove(listadoPalabras.size() - 1);

        listadoPalabras.forEach(System.out::println);

        escritura(listadoPalabras, "ListaPalabras.txt");
        leerCsvYcrearObjeto("autobuses.txt");

    }

}
