/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RobotVicoAPIStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *
 * @author nacho
 */
public class Main {

    public static void escrituraLista(List<Robot> aux, String nombreArchivo) {

        String tmp = " ";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(nombreArchivo))) {

            for (Robot robot : aux) {
                tmp = robot.numeroSerie() + ";" + robot.vida() + ";";
                // Usamos metodo write() para escribir en el buffer
                flujo.write(tmp);
                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();

            System.out.println("Fichero " + nombreArchivo + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static ArrayList<Robot> getListaRobores(int num) {
        var listaRobots = new ArrayList<Robot>();

        Random random = new Random();

        if (num <= 0) {

            throw new IllegalArgumentException("El numero de robots a crear no es valido");
        }
        for (int i = 0; i < num; i++) {

            listaRobots.add(new Robot(random.nextInt(0, 5000), random.nextInt(1, 101)));
        }

        return listaRobots;
    }

    public static void lecturaFicheroYMuestro(String nombreArchivo) {

        // Fichero a leer con datos de ejemplo
        String idFichero = nombreArchivo;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                for (String string : tokens) {
                    System.out.print(string + "\t");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static List<Robot> lecturaFicheroPasoALista(String nombreArchivo) {
        ArrayList<Robot> lista = new ArrayList<>();
        // Fichero a leer con datos de ejemplo
        String idFichero = nombreArchivo;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                Robot auxR = new Robot(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
                lista.add(auxR);

//                 String patron = "\\d+";
//                 Pattern pattern = Pattern.compile(patron);
//                   Matcher matcher = pattern.matcher(tokens[0]);
//                   
//                   if(matcher.find()){
//                    
//                   
//                   }
//
//                    if(matcher.find()){
//                   
//                   
//                   }
//                
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static void main(String[] args) {
        ArrayList<Robot> lista = getListaRobores(20);

        lista.forEach(System.out::println);
        escrituraLista(lista, "ListaRobots.txt");
        lecturaFicheroYMuestro("ListaRobots.txt");
        List<Robot> lista2 = lecturaFicheroPasoALista("ListaRobots.txt");

        for (Robot robot : lista2) {
            System.out.println(robot.impresion2());
        }

    }

}
