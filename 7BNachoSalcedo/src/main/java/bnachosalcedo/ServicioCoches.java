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
public class ServicioCoches {

    public static void escritura(List<Vehiculo> aux, String nombreArchivo) {

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

                if (tokens[0].contains("0 -")) {
                    String regex = "^[0-2]\\s-\\s";
                    tokens[0] = tokens[0].replaceAll(regex, "");

                    Vehiculo auxt1 = new Turismo(Integer.parseInt(tokens[7]), Boolean.parseBoolean(tokens[8]),
                            Long.parseLong(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], Double.parseDouble(tokens[5]), Boolean.parseBoolean(tokens[6]));

                    lista.add(auxt1);
//                        System.out.println("turismmo: " +tokens[0]);
                }

                if (tokens[0].contains("1 -")) {
                    String regex = "^[0-2]\\s-\\s";
                    tokens[0] = tokens[0].replaceAll(regex, "");

                    Vehiculo auxD = new Deportivo(Integer.parseInt(tokens[7]),
                            Long.valueOf(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4],
                            Double.parseDouble(tokens[5]), Boolean.parseBoolean(tokens[6]));
                    lista.add(auxD);
//                      System.out.println("deportivo: " +tokens[0]);
                }

                if (tokens[0].contains("2 -")) {
                    String regex = "^[0-2]\\s-\\s";
                    tokens[0] = tokens[0].replaceAll(regex, "");

                    Vehiculo auxF = new Furgoneta(Integer.parseInt(tokens[8]), Integer.parseInt(tokens[7]),
                            Long.valueOf(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4],
                            Double.parseDouble(tokens[5]), Boolean.parseBoolean(tokens[6]));

                    lista.add(auxF);
//                      System.out.println("furgoneta: " +tokens[0]);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static void escrituraPorTipo(List<Vehiculo> aux) {

        String idFicheroTu = "turismos.txt";
        String idFicheroDe = "deportivos.txt";
        String idFicheroFu = "furgonetas.txt";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFicheroTu))) {

            for (Vehiculo v : aux) {

                if (v instanceof Turismo) {
                    flujo.write(v.toString());
                    flujo.newLine();

                }

            }

            flujo.flush();

            System.out.println("Fichero " + idFicheroTu + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFicheroDe))) {

            for (Vehiculo v : aux) {

                if (v instanceof Deportivo) {

                    flujo.write(v.toString());
                    flujo.newLine();
                }

            }

            flujo.flush();

            System.out.println("Fichero " + idFicheroDe + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFicheroFu))) {

            for (Vehiculo v : aux) {

                if (v instanceof Furgoneta) {

                    flujo.write(v.toString());
                    flujo.newLine();
                }

            }

            flujo.flush();

            System.out.println("Fichero " + idFicheroFu + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
