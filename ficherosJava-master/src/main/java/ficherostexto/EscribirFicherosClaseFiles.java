/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherostexto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 *
 * @author carlos
 */
public class EscribirFicherosClaseFiles {

    public static void main(String[] args) {

        String texto = """
                       Lorem ipsum dolor sit amet, consectetur adipiscing elit, 
                       sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
                       Ut enim ad minim veniam, quis nostrud exercitation ullamco 
                       laboris nisi ut aliquip ex ea commodo consequat. 
                       Duis aute irure dolor in reprehenderit in voluptate velit 
                       esse cillum dolore eu fugiat nulla pariatur. 
                       Excepteur sint occaecat cupidatat non proident, 
                       sunt in culpa qui officia deserunt mollit anim id est laborum
                       """;
        // Escribe el string en un fichero
        escribirString(texto);
        
        // Obtengo la lista de líneas que hay en el String
        List<String> lineas = texto.lines().toList();
        // Imprimo la lista
        lineas.forEach(System.out::println);
        // Escribo en un fichero
        escribirListaString(lineas);
        
    }

    // Escribe un String a un fichero, sobreescribiendo si existe
    public static void escribirString(String datos) {

        try {
            Files.write(Paths.get("escribirString.txt"), datos.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }
    }

    // Método para escribir una lista de String, sobreescribiendo si el fichero existe
    public static void escribirListaString(List<String> lista) {
        
        try {
            Files.write(Paths.get("escribirLineas.txt"), lista, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }
    }
}
