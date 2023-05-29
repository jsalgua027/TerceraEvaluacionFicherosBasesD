/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

/**
 *
 * @author Windows10
 */
import controladoras.GrabacionJpaController;
import controladoras.InstrumentoJpaController;
import controladoras.MusicoJpaController;
import controladoras.exceptions.IllegalOrphanException;
import controladoras.exceptions.NonexistentEntityException;
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

public class UtilidadesProg {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_musica2_jar_1.0-SNAPSHOTPU");
    private static final MusicoJpaController mc = new MusicoJpaController(emf);
    private static final InstrumentoJpaController ic = new InstrumentoJpaController(emf);
    private static final GrabacionJpaController gc = new GrabacionJpaController(emf);

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
        anio = UtilidadesProg.leerEnteroSinErroresScanner();
        do {
            System.out.println("Que Mes");
            mes = UtilidadesProg.leerEnteroSinErroresScanner();
        } while (mes < 1 || mes > 12);
        do {
            System.out.println("Que dia");
            dia = UtilidadesProg.leerEnteroSinErroresScanner();
        } while (dia < 1 || dia > 31);

        fechaGrabacAux = LocalDate.of(anio, mes, dia);
        grabAux.setTitulo(tituloAux);
        grabAux.setFecha(UtilidadesProg.LocalADate(fechaGrabacAux));

        gc.create(grabAux);

    }

    //BORRADOS
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

    }
    
    
    // MODIFICADORES
    
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
            
            musi.setInstrumento(Intru);
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
  // enlazo a la Un instrumento  a un Musico  Este metodo es usado en Instrmento
    public static void añadirMusicosAlInstrumento(int idIns, int idMUsico) throws NonexistentEntityException, Exception {
        var Intru = ic.findInstrumento(idIns);
        
        try {
            var musi = mc.findMusico(idMUsico);
            
            Intru.setIdMusico(musi);
            
            ic.edit(Intru);
        } catch (NullPointerException e) {
            System.out.println("No existe ese Musico");
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
                anio = UtilidadesProg.leerEnteroSinErroresScanner();
                do {
                    System.out.println("Que Mes");
                    mes = UtilidadesProg.leerEnteroSinErroresScanner();
                } while (mes < 1 || mes > 12);
                do {
                    System.out.println("Que dia");
                    dia = UtilidadesProg.leerEnteroSinErroresScanner();
                } while (dia < 1 || dia > 31);
                
                fechaGrabacAux = LocalDate.of(anio, mes, dia);
                grabacion.setTitulo(tituloAux);
                grabacion.setFecha(UtilidadesProg.LocalADate(fechaGrabacAux));
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

}
