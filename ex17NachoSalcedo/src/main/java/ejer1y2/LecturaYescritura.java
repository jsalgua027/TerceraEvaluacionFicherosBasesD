/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer1y2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author nacho
 */
public class LecturaYescritura {

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
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                //
                tokens = linea.split("\\|");
                for (int i = 0; i < tokens.length; i++) {

                    tokens[i] = tokens[i].replaceAll("|", "");
                    tokens[i] = tokens[i].replaceAll(",", "");

                    // System.out.println(tokens[i].toString());
                }
                Profesor auxP = new Profesor();

                auxP.setNombreCompleto(tokens[0].trim());

                auxP.setDni(tokens[1].trim());

                auxP.setTipoPersonal(tokens[2].trim());

                auxP.setPuestoTrabajo(tokens[3].trim());

                auxP.setHorarioPersonalizado(Boolean.parseBoolean(tokens[4].trim()));

                if (tokens[5].equals(" ")) {

                    auxP.setFechaAlta(null);
                } else {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha = LocalDate.parse(tokens[5], formatter);

                    auxP.setFechaAlta(fecha);
                }

                if (tokens[6].trim().isEmpty()) {

                    auxP.setFechaBaja(null);
                } else {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha = LocalDate.parse(tokens[6], formatter);

                    auxP.setFechaBaja(fecha);
                }

                auxP.setHorasIniciales(Double.parseDouble(tokens[7].replace(":", "")));

                auxP.setTotalHoras(Double.parseDouble(tokens[8].replace(":", "")));

                auxP.setActivo(tokens[9].trim());

                listaAux.add(auxP);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaAux;

    }

    public static Map<String, Double> listaMap(List<Profesor> aux) {
        Map<String, Double> mapAux = new HashMap<String, Double>();

        for (Profesor p : aux) {

            mapAux.put(p.getDni(), p.getTotalHoras());

        }

        return mapAux;
    }

    public static void escribirJSO(Map<String, Double> aux, String ruta) throws IOException {
        // Voy a filtrar la lista aux y sacar una nueva lista con la condicion de los años trabajados
        // Y esa nueva lista es la que le paso al writeValue()

        ObjectMapper mapeador = new ObjectMapper();

        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());

        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File(ruta), aux);

    }

}
