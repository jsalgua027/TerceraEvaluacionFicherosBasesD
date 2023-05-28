/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import controladoras.BiografiaJpaController;
import controladoras.GrabacionJpaController;
import controladoras.InstrumentoJpaController;
import controladoras.MusicoJpaController;
import controladoras.exceptions.IllegalOrphanException;
import controladoras.exceptions.NonexistentEntityException;
import entidades.Biografia;
import entidades.Grabacion;
import entidades.Instrumento;
import entidades.Musico;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
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

    //metodo para gestionar de LocalDate a date
    public static LocalDate DateALocalDate(Date fecha) {
        Instant aux = fecha.toInstant();
        return aux.atZone(ZoneId.systemDefault()).toLocalDate();
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
    //alta biografia
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
    // alta musico

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

    //alta Instrumentos
    public static void altaInstrumentos() {
        Instrumento altaInstru = new Instrumento();
        String nombre;
        String tipo;
        
        System.out.println("Gestion de Altas Instrumentos");
        System.out.println("Indique el Nombre del Instrumento");
        nombre = teclado.nextLine();
        System.out.println("Indique el tipo de instrumento");
        tipo = teclado.nextLine();
        
        altaInstru.setNombre(nombre);
        altaInstru.setTipo(tipo);
        ic.create(altaInstru);
        
    }

    //alta grabacion
    public static void altaGrabacion() {
        Grabacion grabAux = new Grabacion();
        String tituloAux;
        LocalDate fechaGrabacAux;
        int dia = 0;
        int mes = 0;
        int anio = 0;
        System.out.println("Indique el Título de la Grabación");
        tituloAux = teclado.nextLine();
        System.out.println("Indique la Fecha de Grabación");
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
        
        fechaGrabacAux = LocalDate.of(anio, mes, dia);
        grabAux.setTitulo(tituloAux);
        grabAux.setFecha(Utilidades.LocalADate(fechaGrabacAux));
        
        gc.create(grabAux);
        
    }

    //MODIFICADORES
    //modificar biografia
    public static void modificarBiografia(int id) throws NonexistentEntityException, Exception {
        
        var bio = bc.findBiografia(id);
        System.out.println(bio);
        try {
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
            
        } catch (NullPointerException e) {
            System.out.println("Esa biográfia no existe");
        }
        
    }

    // enlazo a la biografia un Musico
    public static void enlazarMusicoABiografia(int idBio, int idMUsico) throws NonexistentEntityException, Exception {
        
        var bio = bc.findBiografia(idBio);
        try {
            var musi = mc.findMusico(idMUsico);
            
            bio.setIdMusico(musi);
            bc.edit(bio);
        } catch (NullPointerException e) {
            System.out.println("El Musico no existe");
        }
        
    }

    // modificador musico
    public static void modificarMusico(int idmus) throws NonexistentEntityException, Exception {
        var musci = mc.findMusico(idmus);
        System.out.println(musci);
        try {
            if (musci != null) {
                
                String nombre;
                String genero;
                teclado.nextLine(); // limpio bufer
                System.out.println("Indique el Nombre del Músico");
                nombre = teclado.nextLine();
                System.out.println("Indique el genero Musical");
                genero = teclado.nextLine();
                
                musci.setNombre(nombre);
                musci.setGenero(genero);
            }
            mc.edit(musci);
            
        } catch (NullPointerException e) {
            System.out.println("Ese Músico no existe");
        }
        
    }

    // enlazo a la Un instrumento  a un Musico
    public static void enlazarInstrumentoAMusico(int idIns, int idMUsico) throws NonexistentEntityException, Exception {
        var Intru = ic.findInstrumento(idIns);
        
        try {
            var musi = mc.findMusico(idMUsico);
            
            musi.setIdInstrumento(Intru);
            mc.edit(musi);
        } catch (NullPointerException e) {
            System.out.println("El Instrumento no existe");
        }
        
    }

    // modificador Instrumento
    public static void modificarInstrumento(int idInstrumento) throws NonexistentEntityException, Exception {
        var instrumento = ic.findInstrumento(idInstrumento);
        System.out.println(instrumento);
        try {
            if (instrumento != null) {
                
                String nombre;
                String tipo;
                teclado.nextLine(); // limpio bufer
                System.out.println("Indique el Nombre del Instrumento");
                nombre = teclado.nextLine();
                System.out.println("Indique el Tipo");
                tipo = teclado.nextLine();
                
                instrumento.setNombre(nombre);
                instrumento.setTipo(tipo);
            }
            ic.edit(instrumento);
            
        } catch (NullPointerException e) {
            System.out.println("No existe ese Instrumento");
        }
        
    }

    // enlazo a la Un instrumento  a un Musico
    public static void añadirMusicosAlInstrumento(int idIns, int idMUsico) throws NonexistentEntityException, Exception {
        var Intru = ic.findInstrumento(idIns);
        
        try {
            var musi = mc.findMusico(idMUsico);
            
            Intru.getMusicoList().add(musi);
            
            ic.edit(Intru);
        } catch (NullPointerException e) {
            System.out.println("No existe ese Musico");
        }
        
    }

    // enlazo a la Un instrumento  las grabaciones
    public static void añadirGrabacionesAlInstrumento(int idIns, int idGraba) throws NonexistentEntityException, Exception {
        var Intru = ic.findInstrumento(idIns);
        try {
            var graba = gc.findGrabacion(idGraba);
            
            Intru.getGrabacionList().add(graba);
            ic.edit(Intru);
        } catch (NullPointerException e) {
            System.out.println("No existe esa Grabación");
        }
        
    }

    // modificador Grabación
    public static void modificarGrabacion(int idGraba) throws NonexistentEntityException, Exception {
        var grabacion = gc.findGrabacion(idGraba);
        System.out.println(grabacion);
        try {
            if (grabacion != null) {
                
                String tituloAux;
                LocalDate fechaGrabacAux;
                int dia = 0;
                int mes = 0;
                int anio = 0;
                teclado.nextLine(); // limpio bufer
                System.out.println("Indique el Título de la Grabación");
                tituloAux = teclado.nextLine();
                System.out.println("Indique la Fecha de Grabación");
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
                
                fechaGrabacAux = LocalDate.of(anio, mes, dia);
                grabacion.setTitulo(tituloAux);
                grabacion.setFecha(Utilidades.LocalADate(fechaGrabacAux));
            }
            gc.edit(grabacion);
            
        } catch (NullPointerException e) {
            System.out.println("No existe esa Grabación");
        }
        
    }

    // enlazo Musicos a la grabacion
    public static void añadirInstrumentosAGrabacion(int idGraba, int idInstru) throws NonexistentEntityException, Exception {
        var graba = gc.findGrabacion(idGraba);
        try {
            var instru = ic.findInstrumento(idInstru);
            
            graba.setIdInstrumento(instru);
            
            gc.edit(graba);
        } catch (NullPointerException e) {
            System.out.println("No existe ese Instrumento");
        }
        
    }

    //BORRADOS
    //borrado biografia
    public static void borrarBiografia(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        // Se borra el biografia por ID, si no existe lanza excepción NonexistentEntityException
        // Si tiene musicos lanza excepción IllegalOrphanException
        // Si tiene una musico asociad, la biografia se queda sin musico
        bc.destroy(id);
    }

    //borrado musico
    public static void borrarMusico(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        // Se borra el musico por ID, si no existe lanza excepción NonexistentEntityException
        // Si tiene biografias lanza excepción IllegalOrphanException
        // Si tiene una musico asociado, el musico se queda sin biografia
        mc.destroy(id);
    }

    //borrado musico
    public static void borrarInstrumento(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        // Se borra el instrumento por ID, si no existe lanza excepción NonexistentEntityException

        ic.destroy(id);
    }

    //borrado grabacion
    public static void borrarGrabacion(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        // Se borra el instrumento por ID, si no existe lanza excepción NonexistentEntityException

        gc.destroy(id);
    }

    // borrado de todos los datos 
    public static void borrarBase() throws NonexistentEntityException {
        List<Musico> listaMusi = mc.findMusicoEntities();
        List<Biografia> listaBio = bc.findBiografiaEntities();
        List<Instrumento> listaInstru = ic.findInstrumentoEntities();
        List<Grabacion> listaGraba = gc.findGrabacionEntities();
        // booro todas las grabaciones
        for (Grabacion grabacion : listaGraba) {
            gc.destroy(grabacion.getIdGrabacion());
        }
        // borro todos los instrumentos
        for (Instrumento intru : listaInstru) {
            ic.destroy(intru.getIdInstrumento());
        }
        // borro todos los músicos
        
        for (Musico musci : listaMusi) {
            mc.destroy(musci.getIdMusico());
        }

        // borro todas las biografias
        for (Biografia biogra : listaBio) {
            bc.destroy(biogra.getIdBiografia());
        }
        
    }
    
}
