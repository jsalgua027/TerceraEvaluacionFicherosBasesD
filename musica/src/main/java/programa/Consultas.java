/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programa;

import controladoras.BiografiaJpaController;
import controladoras.GrabacionJpaController;
import controladoras.InstrumentoJpaController;
import controladoras.MusicoJpaController;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class Consultas {

    /**
     * @param args the command line arguments private static final
     * EntityManagerFactory emf =
     * Persistence.createEntityManagerFactory("alquiler"); private static final
     * VehiculoJpaController vc = new VehiculoJpaController(emf); private static
     * final AlquilerJpaController ac = new AlquilerJpaController(emf); private
     * static final TarjetaBancariaJpaController tc = new
     * TarjetaBancariaJpaController(emf); private static final
     * ClienteJpaController cc = new ClienteJpaController(emf);
     *
     *
     * public static void mostrarVehiculos() { System.out.println("---------
     * Listado de Vehículos -------------");
     * vc.findVehiculoEntities().forEach(System.out::println);
     * System.out.println("--------------------------------------------");
     *
     * }
     *
     * public static void mostrarClientes() { System.out.println("---------
     * Listado de Clientes -------------");
     * cc.findClienteEntities().forEach(System.out::println);
     * System.out.println("--------------------------------------------"); }
     *
     * public static void mostrarAlquileres() { System.out.println("---------
     * Listado de Alquileres -------------");
     * ac.findAlquilerEntities().forEach(System.out::println);
     * System.out.println("--------------------------------------------"); }
     *
     * public static void mostrarTarjetas() { System.out.println("---------
     * Listado de Tarjetas -------------");
     * tc.findTarjetaBancariaEntities().forEach(System.out::println);
     * System.out.println("--------------------------------------------"); }
     *
     *
     * public GrabacionJpaController(){
     *
     * emf=
     * Persistence.createEntityManagerFactory("com.mycompany_musica_jar_1.0-SNAPSHOTPU");
     * }
     *
     *
     *
     */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_musica_jar_1.0-SNAPSHOTPU");
    private static final MusicoJpaController mc = new MusicoJpaController(emf);
    private static final InstrumentoJpaController ic = new InstrumentoJpaController(emf);
    private static final GrabacionJpaController gc = new GrabacionJpaController(emf);
    private static final BiografiaJpaController bc = new BiografiaJpaController(emf);

    private static void mostarMusicos() {
        System.out.println("-------Listado de Músicos------");
        mc.findMusicoEntities().forEach(System.out::println);
        System.out.println("---------------------------------------");

    }

    private static void mostrarInstrumentos() {
        System.out.println("-------Listado de Instrumentos------");
        ic.findInstrumentoEntities().forEach(System.out::println);
        System.out.println("---------------------------------------");

    }

    private static void mostrarGrabaciones() {

        System.out.println("-------Listado de Grabaciones------");
        gc.findGrabacionEntities().forEach(System.out::println);

        System.out.println("-----------------------------------");
    }

    private static void mostrarBiografia() {

        System.out.println("-------Listado de biografias------");
        bc.findBiografiaEntities().forEach(System.out::println);

        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        mostarMusicos();
        mostrarInstrumentos();
        mostrarGrabaciones();
        mostrarBiografia();

        
        
        
        
        
        
        
    }

}
