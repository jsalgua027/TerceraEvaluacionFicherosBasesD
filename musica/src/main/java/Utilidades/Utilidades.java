/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import controladoras.BiografiaJpaController;
import controladoras.GrabacionJpaController;
import controladoras.InstrumentoJpaController;
import controladoras.MusicoJpaController;
import controladoras.exceptions.NonexistentEntityException;
import entidades.Biografia;
import entidades.Musico;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Windows10
 */
public class Utilidades {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_musica_jar_1.0-SNAPSHOTPU");
    private static final MusicoJpaController mc = new MusicoJpaController(emf);
    private static final InstrumentoJpaController ic = new InstrumentoJpaController(emf);
    private static final GrabacionJpaController gc = new GrabacionJpaController(emf);
    private static final BiografiaJpaController bc = new BiografiaJpaController(emf);
    
    private static Scanner teclado = new Scanner(System.in);

    // metodo para gestionar los LocalDate a Date
    public static Date LocalADate(LocalDate fecha) {
        
        return Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
    }

    // metodos para mostrar los datos de las entidades
    public static void mostraMusicos() {
        System.out.println("-------Listado de Músicos------");
        mc.findMusicoEntities().forEach(System.out::println);
        System.out.println("---------------------------------------");
        
    }
    
    public static void mostrarInstrumentos() {
        System.out.println("-------Listado de Instrumentos------");
        ic.findInstrumentoEntities().forEach(System.out::println);
        System.out.println("---------------------------------------");
        
    }
    
    public static void mostrarGrabaciones() {
        
        System.out.println("-------Listado de Grabaciones------");
        gc.findGrabacionEntities().forEach(System.out::println);
        
        System.out.println("-----------------------------------");
    }
    
    public static void mostrarBiografia() {
        
        System.out.println("-------Listado de biografias------");
        bc.findBiografiaEntities().forEach(System.out::println);
        
        System.out.println("-----------------------------------");
    }

    // leer enteros y decimales  sin errores  SCANNER (INPUTMISMATCHEXCEPTION)
    public static int leerEnteroSinErroresScanner() {
        int num = 0;
        boolean repetir = true;
        
        do {
            //  System.out.println("Introduce el numero entero");
            try {
                
                num = teclado.nextInt();
                repetir = false;
                
            } catch (InputMismatchException ime) {
                System.out.println("No has introducido un numero entero");
                //limpio buffer
                teclado.nextLine();
            }
            
        } while (repetir);
        
        return num;
    }

    // ALTAS
    public static void altaBiografia() {
        Biografia altaBio = new Biografia();
        String descriAux;
        LocalDate fechaNaciAux;
        int dia = 0;
        int mes = 0;
        int anio = 0;
        
        String lugarNacimientoAux;
        
        System.out.println("Gestion de Altas Biografias");
        System.out.println("Indique la descripcion de la Biografia");
        descriAux = teclado.nextLine();
        System.out.println("Indique la Fecha de Nacimiento");
        System.out.println("Que año");
        anio = Utilidades.leerEnteroSinErroresScanner();
        do {
            System.out.println("Que Mes");
            mes = Utilidades.leerEnteroSinErroresScanner();
        } while (mes < 1 || mes > 12);
        do {
            System.out.println("Que dia");
            dia = Utilidades.leerEnteroSinErroresScanner();
        } while (dia < 1 || dia > 31);
        
        System.out.println("Indique lugar de Nacimiento");
        lugarNacimientoAux = teclado.nextLine();
        
        fechaNaciAux = LocalDate.of(anio, mes, dia);
        altaBio.setDescripcion(descriAux);
        altaBio.setFechaNacimiento(Utilidades.LocalADate(fechaNaciAux));
        altaBio.setLugarNacimiento(lugarNacimientoAux);
        bc.create(altaBio);
        
    }
    
    public static void altaMusico() {
        Musico altaMusico = new Musico();
        String nombre;
        String genero;
        
        System.out.println("Gestion de Altas Músico");
        System.out.println("Indique el Nombre del Músico");
        nombre = teclado.nextLine();
        System.out.println("Indique el genero Musical");
        genero = teclado.nextLine();
        
        altaMusico.setNombre(nombre);
        altaMusico.setGenero(genero);
        mc.create(altaMusico);
        
    }

    //MODIFICADORES
    public static void modificarBiografia(int id) throws NonexistentEntityException, Exception {
        
        var bio = bc.findBiografia(id);
        System.out.println(bio);
        if (bio != null) {
            
            String descriAux;
            LocalDate fechaNaciAux;
            int dia = 0;
            int mes = 0;
            int anio = 0;
            
            String lugarNacimientoAux;
            
            teclado.nextLine(); // limpio bufer
            System.out.println("Indique la descripcion de la Biografia");
            descriAux = teclado.nextLine();
            System.out.println("Indique la Fecha de Nacimiento");
            System.out.println("Que año");
            anio = Utilidades.leerEnteroSinErroresScanner();
            do {
                System.out.println("Que Mes");
                mes = Utilidades.leerEnteroSinErroresScanner();
            } while (mes < 1 || mes > 12);
            do {
                System.out.println("Que dia");
                dia = Utilidades.leerEnteroSinErroresScanner();
            } while (dia < 1 || dia > 31);
            
            System.out.println("Indique lugar de Nacimiento");
            lugarNacimientoAux = teclado.nextLine();
            
            fechaNaciAux = LocalDate.of(anio, mes, dia);
            bio.setDescripcion(descriAux);
            bio.setFechaNacimiento(Utilidades.LocalADate(fechaNaciAux));
            bio.setLugarNacimiento(lugarNacimientoAux);
            
        }
        bc.edit(bio);
    }
    
}
