/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import controladoras.BiografiaJpaController;
import controladoras.GrabacionJpaController;
import controladoras.InstrumentoJpaController;
import controladoras.MusicoJpaController;
import entidades.Biografia;
import entidades.Grabacion;
import entidades.Instrumento;
import entidades.Musico;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class ServicioArchivos {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_musica_jar_1.0-SNAPSHOTPU");
    private static final MusicoJpaController mc = new MusicoJpaController(emf);
    private static final InstrumentoJpaController ic = new InstrumentoJpaController(emf);
    private static final GrabacionJpaController gc = new GrabacionJpaController(emf);
    private static final BiografiaJpaController bc = new BiografiaJpaController(emf);

    public static void crearDirectorio(String nombreDirecT) {

        Path directory = Paths.get("./" + nombreDirecT);
        try {
            Files.createDirectory(directory);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio.");
            System.out.println(e.toString());
        }

    }

    public static void crearDirectorioFechas() {
        String fechaCarpeta = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss"));
        Path directory = Paths.get("./copias/" + fechaCarpeta);
        try {
            Files.createDirectory(directory);

        } catch (IOException e) {
            System.out.println("Problema creando el directorio.");
            System.out.println(e.toString());
        }

    }
    // metodo para crear directorios con fechas y crear los archivos

    public static void rellenarDirectorios() {
        String fechaCarpeta = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss"));
        List<Musico> listaMusi = mc.findMusicoEntities();
        List<Biografia> listaBio = bc.findBiografiaEntities();
        List<Instrumento> listaInstru = ic.findInstrumentoEntities();
        List<Grabacion> listaGraba = gc.findGrabacionEntities();
        LecturaYEscritura.escrituraBiogra(listaBio, "./copias/" + fechaCarpeta + "/Biografias.csv");
        LecturaYEscritura.escrituraMusicos(listaMusi, "./copias/" + fechaCarpeta + "/Musicos.csv");
        LecturaYEscritura.escrituraGraba(listaGraba, "./copias/" + fechaCarpeta + "/Grabaciones.csv");
        LecturaYEscritura.escrituraInstru(listaInstru, "./copias/" + fechaCarpeta + "/Instrumentos.csv");
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
// metodo para ver todos los directorios

    public static void mostrarConteniDirectorio(String directorio) {
        File f = new File(directorio);
        // uso el inidice de la lista para seleccionar al carpeta que quiera el usuario
        List<String> listaIndice = new ArrayList<>();
        if (f.exists()) {
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                listaIndice.add(file2.getName());
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }

    }

    // metodo para obtener  la ruta del directorio para restaurar
    public static String optenerRutaDirectorio(String directorio, int posicion) {
        File f = new File(directorio);
        String ruta = "";
        // uso el inidice de la lista para seleccionar al carpeta que quiera el usuario
        List<String> listaIndice = new ArrayList<>();
        if (f.exists()) {
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                listaIndice.add(file2.getName());

            }
            System.out.println("El directorio es:  " + listaIndice.get(posicion));
            ruta = listaIndice.get(posicion);
        } else {
            System.out.println("El directorio a listar no existe");
        }
        return ruta;
    }

    // metodo para restaurar  datos del directorio seleccionado a la base de datos
    public static void DirectorioABasededatos(String ruta) {

        if (ruta.equalsIgnoreCase(ruta + "/Biografias.csv")) {
            LecturaYEscritura.leerCsvYcrearObjetoBiografia(ruta + "/Biografias.csv");

        } else if (ruta.equalsIgnoreCase(ruta + "/Musicos.csv")) {
            LecturaYEscritura.leerCsvYcrearObjetoMusicos(ruta + "/Musicos.csv");

        } else if (ruta.equalsIgnoreCase(ruta + "/Instrumentos.csv")) {
            LecturaYEscritura.leerCsvYcrearObjetoInstrumento(ruta + "/Instrumentos.csv");

        } else if (ruta.equalsIgnoreCase(ruta + "/Grabaciones.csv")) {
            LecturaYEscritura.leerCsvYcrearObjetoGrabaciones(ruta + "/Grabaciones.csv");

        }

    }

}
