/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import controladoras.GrabacionJpaController;
import controladoras.InstrumentoJpaController;
import controladoras.MusicoJpaController;

import entidades.Grabacion;
import entidades.Instrumento;
import entidades.Musico;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class LecturaYEscritura {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_musica2_jar_1.0-SNAPSHOTPU");
    private static final MusicoJpaController mc = new MusicoJpaController(emf);
    private static final InstrumentoJpaController ic = new InstrumentoJpaController(emf);
    private static final GrabacionJpaController gc = new GrabacionJpaController(emf);

//Instrumento
    public static void escrituraInstru(List<Instrumento> aux, String ruta) {
        
        String tmp = " ";
        
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {
            
            for (Instrumento instru : aux) {
                tmp = instru.toString2();
                flujo.write(tmp);
                flujo.newLine();
            }
            
            flujo.flush();
            
            System.out.println("Fichero " + ruta + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }

    //Musicos
    public static void escrituraMusicos(List<Musico> aux, String ruta) {
        
        String tmp = " ";
        
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {
            
            for (Musico music : aux) {
                tmp = music.toString2();
                flujo.write(tmp);
                flujo.newLine();
            }
            
            flujo.flush();
            
            System.out.println("Fichero " + ruta + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }

    //Grabaciones
    public static void escrituraGraba(List<Grabacion> aux, String ruta) {
        
        String tmp = " ";
        
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {
            
            for (Grabacion graba : aux) {
                tmp = graba.toString2();
                //   tmp= graba.getTitulo()+";"+graba.getFecha()+";"+graba.getIdInstrumento().getNombre();
                flujo.write(tmp);
                flujo.newLine();
            }
            
            flujo.flush();
            
            System.out.println("Fichero " + ruta + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }

    // de csv a la persistencia Instrumentos
    public static void leerCsvYcrearObjetoInstrumento(String ruta) {

        // Fichero a leer con datos de ejemplo
        String idFichero = ruta;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        Instrumento aux = null;
        Musico auxMus = null;
        List<Instrumento> listaInstr = new ArrayList<>();
        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                aux = new Instrumento();
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                for (String string : tokens) {
                    
                    auxMus = mc.findMusico(Integer.valueOf(tokens[3]));
                    aux.setIdInstrumento(Integer.valueOf(tokens[0]));
                    aux.setNombre(tokens[1]);
                    aux.setTipo(tokens[2]);
                    aux.setIdMusico(auxMus);
                    aux.setGrabacionList(new ArrayList());
                    
                }
                listaInstr.add(aux);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // meto el instrumento en la base de datos 
        for (Instrumento instrumento : listaInstr) {
            
            ic.modificarAutoIncrementInstru(instrumento);
            ic.create(instrumento);
        }
        
    }

    // de csv a la persistencia Musicos
    public static void leerCsvYcrearObjetoMusicos(String ruta) {

        // Fichero a leer con datos de ejemplo
        String idFichero = ruta;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        Musico aux = null;
        Instrumento insAux = null;
        List<Musico> listaMusi = new ArrayList<>();
        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                aux = new Musico();
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                
                for (String string : tokens) {

                    // insAux=ic.encontraInstrumentoNombre(tokens[3]);
                    aux.setIdMusico(Integer.valueOf(tokens[0]));
                    aux.setNombre(tokens[1]);
                    aux.setGenero(tokens[2]);
                    insAux = ic.findInstrumento(Integer.valueOf(tokens[3]));
                    aux.setInstrumento(insAux);
                    
                }
                listaMusi.add(aux);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // meto el musico en la base de datos 
        for (Musico mus : listaMusi) {
            //  controlarIds(aux);
            mc.modificarAutoIncrement(mus);
            mc.create(mus);
        }
        
    }

    // de csv a la persistencia Biografia
    public static void leerCsvYcrearObjetoGrabaciones(String ruta) {

        // Fichero a leer con datos de ejemplo
        String idFichero = ruta;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        Grabacion aux = null;
        Instrumento insAux = null;
        List<Grabacion> listaGrab = new ArrayList<>();
        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                aux = new Grabacion();
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                for (String string : tokens) {
                    
                    LocalDate fecha = LocalDate.parse(tokens[2]);
                    insAux = ic.findInstrumento(Integer.valueOf(tokens[3]));
                    aux.setIdGrabacion(Integer.valueOf(tokens[0]));
                    aux.setTitulo(tokens[1]);
                    aux.setFecha(UtilidadesProg.LocalADate(fecha));
                    aux.setIdInstrumento(insAux);
                    
                }
                listaGrab.add(aux);
                
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // meto el instrumento en la base de datos 
        for (Grabacion gra : listaGrab) {
            gc.modificarAutoIncrementGrabacion(gra);
            gc.create(gra);
        }
        
    }
    
    public static void leerArchivoCSVMostrar(String ruta) {
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
    
}
