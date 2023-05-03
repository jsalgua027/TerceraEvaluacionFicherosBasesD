package eje7fnachosalcedo;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

    public static void borrarFichero(String archivoBorrar) {

        Path element = Paths.get(archivoBorrar);
        try {
            Files.delete(element);
        } catch (IOException e) {
            System.out.println("Problema borrando el archivo.");
            System.out.println(e.toString());
        }

    }

    public static void copiarArchivos(String origenP, String destinoP) {

        Path origen = Paths.get(origenP);
        Path destino = Paths.get(destinoP);
        try {
            Files.copy(origen, destino);
        } catch (IOException e) {
            System.out.println("Problema copiando el archivo.");
            System.out.println(e.toString());
        }

    }

    public static void mostrarConteniDirectorio(String directorio) {
        File f = new File(directorio);
        if (f.exists()) {
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }

    }
    
      // Método recursivo para mostrar archivos y carpetas
    public static void mostrarFicheros(File file) {
        List<File> ficheros = new ArrayList<>();
        List<File> carpetas = new ArrayList<>();

        String texto = file.isDirectory() ? "D - " + file.getName() : file.getName();
        System.out.println(texto);

        if (file.isDirectory()) { // Directorio - Tiene hijos
            File[] listaHijos = file.listFiles();
            // Por cada elemento separo en archivos y directorios
            for (File fichero : listaHijos) {
                if (fichero.isFile()) {
                    ficheros.add(fichero);
                } else {
                    carpetas.add(fichero);
                }
            }
            // Ordena la lista de ficheros por nombre
            ficheros.sort((f1, f2) -> f1.getName().compareTo(f2.getName()));
            // Muestra los nombres de los ficheros
            ficheros.forEach(f -> System.out.println("\t" + f.getName()));
            // Por cada carpeta, llama a la recursividad
            carpetas.forEach(c -> mostrarFicheros(c));
        }
    }

}
