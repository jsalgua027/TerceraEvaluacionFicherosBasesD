/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p81nachosalcedofacturasbd.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nacho
 */
public class LeerArchivo {
    
      public static List<FacturaVO> leerCsvYcrearObjeto(String ruta) {

          List<FacturaVO> listaAux = new ArrayList<>();
          
        // Fichero a leer con datos de ejemplo
        String idFichero = ruta;

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
                 FacturaVO aux = new FacturaVO();
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                for (String string : tokens) {
                  
                   aux.setCodigoUnico(Integer.parseInt(tokens[0]));
                   aux.setFechaEmision(LocalDate.parse(tokens[1]));
                   aux.setDescripcion(tokens[2]);
                   aux.setTotalImporteFactura(Double.parseDouble(tokens[3]));
                }
             listaAux.add(aux);
            }
             
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaAux;
    }
    
}
