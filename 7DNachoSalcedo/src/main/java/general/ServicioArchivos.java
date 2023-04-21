/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author nacho
 */
public class ServicioArchivos {

    public static void crearDirectorio(String nombreDirecT) {

        Path directory = Paths.get("./" + nombreDirecT);
        try {
            Files.createDirectory(directory);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio.");
            System.out.println(e.toString());
        }

    }

    public static void crearFicheroVacio(String nombreDirectorio, String nombreArchivoVacio) {

        Path file = Paths.get("./" + nombreDirectorio + "/" + nombreArchivoVacio);
        try {
            // Este método no crea el archivo si ya existe
            Files.createFile(file);
        } catch (IOException e) {
            System.out.println("Problema creando el archivo.");
            System.out.println(e.toString());
        }

    }
    
    
    public static void  borrarFichero(String nombreDirectorio, String archivoBorrar){
                
            Path element = Paths.get("/home/usuario/carpeta");
		try {
			Files.delete(element);
		} catch (IOException e) {
			System.out.println("Problema borrando el archivo.");
			System.out.println(e.toString());
		}

    
    }
    
    public static void copiarArchivos (String origenP, String destinoP){

             Path origen  = Paths.get(origenP);
		Path destino = Paths.get("./"+destinoP);
		try
		{  
			Files.copy(origen, destino);
		}
		catch(IOException e) {     
			System.out.println("Problema copiando el archivo.");
			System.out.println(e.toString());
		}
     
        
        
    
    
    }
    
    

}
