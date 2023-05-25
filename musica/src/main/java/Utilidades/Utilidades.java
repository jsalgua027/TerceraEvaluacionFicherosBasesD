/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import controladoras.BiografiaJpaController;
import controladoras.GrabacionJpaController;
import controladoras.InstrumentoJpaController;
import controladoras.MusicoJpaController;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
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
      public static void mostarMusicos() {
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
    
}
