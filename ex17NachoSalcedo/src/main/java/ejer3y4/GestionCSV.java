/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer3y4;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nacho
 */
public class GestionCSV {

    public static List<Profesor> leerCsvYcrearObjeto(String ruta) {

        // Fichero a leer con datos de ejemplo
        String idFichero = ruta;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        List<Profesor> listaAux = new ArrayList<>();
        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(",");

                for (int i = 0; i < tokens.length; i++) {

                    tokens[i] = tokens[i].replaceAll("\"", "");

                }

                Profesor auxE = new Profesor();
                auxE.setApellido(tokens[0]);
                auxE.setNombre(tokens[1]);
                auxE.setDni(tokens[2]);
                auxE.setTipoPersonal(tokens[3]);
                auxE.setPuestoTrabajo(tokens[4]);
                auxE.setHorarioPersonalizado(Boolean.parseBoolean(tokens[5]));

                if (tokens[6].equals(" ")) {

                    auxE.setFechaAlta(null);
                } else {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha = LocalDate.parse(tokens[6], formatter);

                    auxE.setFechaAlta(fecha);
                }

                if (tokens[7].trim().isEmpty()) {

                    auxE.setFechaBaja(null);
                } else {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha = LocalDate.parse(tokens[7], formatter);

                    auxE.setFechaBaja(fecha);
                }

                auxE.setHorasIniciales(Double.parseDouble(tokens[8].replace(":", "")));

                auxE.setTotalHoras(Double.parseDouble(tokens[9].replace(":", "")));

                auxE.setActivo(tokens[10].trim());

                
                listaAux.add(auxE);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaAux;

    }

}
