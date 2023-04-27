/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eje7fnachosalcedo;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Windows10
 */
public class GestionCSV {

    public static List<Empleado> leerCsvYcrearObjeto(String ruta) {

        // Fichero a leer con datos de ejemplo
        String idFichero = ruta;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        Empleado auxE = new Empleado();
        List<Empleado> listaAux = new ArrayList<>();
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
                     
                     tokens[i]=tokens[i].replaceAll("\"", "");
                 
                    
                }
                
                   auxE.setApellido(tokens[0]);
                    auxE.setNombre(tokens[1]);
                    auxE.setDni(tokens[2]);
                    auxE.setPuesto(tokens[3]);
                    if (tokens[4].equals("")) {

                        auxE.setFechaPosesion(null);
                    } else {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate fecha = LocalDate.parse(tokens[4], formatter);

                        auxE.setFechaPosesion(fecha);
                    }
                    if (tokens[5].equals("")) {

                        auxE.setFechaCese(null);
                    } else {

                     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate fecha = LocalDate.parse(tokens[5], formatter);

                        auxE.setFechaPosesion(fecha);

                    }
                    auxE.setTelefono(tokens[6]);
                    auxE.setEvaluador(Boolean.parseBoolean(tokens[7]));
                    auxE.setCoodinador(Boolean.parseBoolean(tokens[8]));

                    listaAux.add(auxE);
                //    System.out.println(tokens[i].toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaAux;

    }
    
    
  
    
}
