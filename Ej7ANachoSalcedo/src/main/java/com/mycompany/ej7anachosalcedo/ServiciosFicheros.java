/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ej7anachosalcedo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author nacho
 */
public class ServiciosFicheros {

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

    public static List<String> lecturaFicheroPasoALista(String nombreArchivo) {
        ArrayList<String> lista = new ArrayList<>();
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

                lista.add(tokens[0].trim());

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static List<String> devolverPuntosCardinales(List<String> aux) {

        List<String> resultado = new ArrayList<>();

        String patron = "[N|S|E|O]";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher;

        for (int i = 0; i < aux.size(); i++) {

            String txt = aux.get(i);
            matcher = pattern.matcher(txt);
            while (matcher.find()) {
                resultado.add(matcher.group());

            }

        }

        return resultado;
    }

    public static Map<String, Integer> devulevoMap(List<String> aux) {

        Map<String, Integer> resultado = new TreeMap<>();
        int contadorN = 0;
        int contadorS = 0;
        int contadorE = 0;
        int contadorO = 0;

        for (String s : aux) {
            switch (s) {
                case "N" ->
                    contadorN++;

                case "S" ->
                    contadorS++;
                case "E" ->
                    contadorE++;
                case "O" ->
                    contadorO++;
            }

        }
        resultado.put("N", contadorN);
        resultado.put("S", contadorS);
        resultado.put("E", contadorE);
        resultado.put("O", contadorO);

        return resultado;
    }

    public static void escrituraMap(Map<String, Integer> aux, String nombreArchivo) {

        String tmp = " ";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(nombreArchivo))) {

            for (Map.Entry<String, Integer> entry : aux.entrySet()) {
//                Object key = entry.getKey();
//                Object val = entry.getValue();
                tmp = "Localizacion : "+entry.getKey()+" ; tiene : " + String.valueOf(entry.getValue());
                flujo.write(tmp);
                flujo.newLine();

            }
            flujo.flush();


            System.out.println("Fichero " + nombreArchivo + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
