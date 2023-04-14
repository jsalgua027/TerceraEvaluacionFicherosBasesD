/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bnachosalcedo;

import ejercicio2_vehiculo.Deportivo;
import ejercicio2_vehiculo.Furgoneta;
import ejercicio2_vehiculo.Turismo;
import ejercicio2_vehiculo.Vehiculo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author nacho
 */
public class ServicoCoches {

    public static void escrituraMap(List<Vehiculo> aux, String nombreArchivo) {

        String tmp = " ";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(nombreArchivo))) {

            for (Vehiculo v : aux) {

                if (v instanceof Turismo) {
                    tmp = "0 - " + v.toString();

                }

                if (v instanceof Deportivo) {

                    tmp = "1 - " + v.toString();
                }

                if (v instanceof Furgoneta) {

                    tmp = "2 - " + v.toString();
                }

                flujo.write(tmp);
                flujo.newLine();
            }

            flujo.flush();

            System.out.println("Fichero " + nombreArchivo + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    
    
    
     public static List<Vehiculo> lecturaFicheroPasoALista(String nombreArchivo) {
        List<Vehiculo> lista = new ArrayList<>();
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
                tokens = linea.split(":");

                
                
//        String patron = "^(0|1|2)-.*";
//        Pattern pattern = Pattern.compile(patron);
//        Matcher matcher;
//
//      
//
//            String txt = aux.get(i);
//            matcher = pattern.matcher(txt);
//            while (matcher.find()) {
//                resultado.add(matcher.group());
//
//            }
//
//        
                
                
             //   lista.add(tokens[0].trim());

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
        
    
    
    
    
    
}
