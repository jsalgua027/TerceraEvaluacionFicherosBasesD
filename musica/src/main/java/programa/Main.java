/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programa;

import controladoras.BiografiaJpaController;
import controladoras.GrabacionJpaController;
import controladoras.InstrumentoJpaController;
import controladoras.MusicoJpaController;
import controladoras.exceptions.NonexistentEntityException;
import entidades.Biografia;
import java.time.LocalDate;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_musica_jar_1.0-SNAPSHOTPU");
    private static final MusicoJpaController mc = new MusicoJpaController(emf);
    private static final InstrumentoJpaController ic = new InstrumentoJpaController(emf);
    private static final GrabacionJpaController gc = new GrabacionJpaController(emf);
    private static final BiografiaJpaController bc = new BiografiaJpaController(emf);

    public static void main(String[] args) throws NonexistentEntityException, Exception {

        String menuPrincipal = """
                           
                                                     PRODUCCIONES MUSICALES GEPETO
                           
                           
                                                      1.Gestion Biografias
                                                      2.Gestion Musicos
                                                      3.Gestion Instrumentos
                                                      4.Gestion Grabaciones
                                                      5.Gestion Copias de seguridad
                                                      6.Salir
                          
                          
                                            """;

        String menuBiografia = """
                                                
                                                    GESTION BIOGRAFIA
                          
                                               1.Dar de alta Biografia
                                               2.Modificar biografia
                                               3.Mostrar Biografia
                                               4.Borrar Biografia
                                               5.Salir
                                        
                                                
                          
                          
                                           """;

        String menuMusicos = """
                                                
                                                    GESTION MUSICOS
                          
                                               1.Dar de alta Musico
                                               2.Modificar Musico
                                               3.Mostrar Musico
                                               4.Borrar Musico
                                               5.Salir
                                                
                                                    
                                           """;

        String menuInstrumentos = """
                          
                                                
                                                    GESTION INSTRUMENTOS    
                          
                                               1.Dar de alta Instrumento
                                               2.Modificar Instrumento
                                               3.Mostrar Instrumento
                                               4.Borrar Instrumento
                                               5.Salir
                                                
                                                    
                                           """;

        String menuGrabaciones = """
                       
                                                
                                                    GESTION GRABACIONES
                          
                                               1.Dar de alta Grabación
                                               2.Modificar Grabación
                                               3.Mostrar Grabación
                                               4.Borrar Grabacion
                                               5.Salir
                                                
                                                    
                                           """;

        String menuCopiasSegurida = """
                                                            GESTION COPIAS DE SEGURIDAD
                                                             
                                                            1.Copia de seguridad de  listado de Biografias
                                                            2.Copia de seguridad de listado de Musicos
                                                            3.Copia de seguridad de listado de Instrumentos
                                                            4.Copia de seguridad de listado de Grabaciones
                                                            5. Salir
                                  
                                  
                                                           """;

        String modBio
                = """
                                  MODIFICACION BIOGRAFIAS
                                 
                                 1.Para modificar Datos
                                 2.Para Añadir Musico
                                 3.Salir
                                 
                                 
                                 """;

        String modMusi
                = """
                                  MODIFICACION MUSICOS
                                 
                                 1.Para modificar Datos
                                 2.Para Añadir Instrumento
                                 3.Salir
                                 
                                 
                                 """;

        String gestionMenu = " ";

        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println(menuPrincipal);
            System.out.println("Elija una Opcion");
            gestionMenu = entrada.nextLine();
            switch (gestionMenu) {
                case "1": //BIOGRAFIA
                    do {
                        System.out.println(menuBiografia);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) {
                            case "1"://BIO ALTA

                                Utilidades.Utilidades.altaBiografia();
                                Utilidades.Utilidades.mostrarBiografia();

                                break;

                            case "2":// BIO MOD
                                do {
                                    System.out.println(modBio);
                                    System.out.println("Elija una Opcion");
                                    gestionMenu = entrada.nextLine();
                                    switch (gestionMenu) {
                                        case "1": //MOD A
                                            Utilidades.Utilidades.mostrarBiografia();
                                            System.out.println("Indique el codigo de biografia que quiere modificar");
                                            int idModificar = Utilidades.Utilidades.leerEnteroSinErroresScanner();
                                            Utilidades.Utilidades.modificarBiografia(idModificar);
                                            Utilidades.Utilidades.mostrarBiografia();

                                            break;
                                        case "2": // MOD B
                                            int bioCod;
                                            int musicCod;
                                            System.out.println("Mostramos la lista de Musicos Y Biografias");
                                            Utilidades.Utilidades.mostrarBiografia();
                                            Utilidades.Utilidades.mostraMusicos();
                                            System.out.println("Indique el codigo de biografia que quiere enlazar");
                                            bioCod = Utilidades.Utilidades.leerEnteroSinErroresScanner();
                                            System.out.println("Indique el codigo de Musico que quiere enlazar");
                                            musicCod = Utilidades.Utilidades.leerEnteroSinErroresScanner();
                                            Utilidades.Utilidades.enlazarMusicoABiografia(bioCod, musicCod);
                                            Utilidades.Utilidades.mostrarBiografia();

                                            break;

                                    }

                                } while (!gestionMenu.contains("3"));
                                break;
                            case "3": // MOSTRAR BIO
                                Utilidades.Utilidades.mostrarBiografia();
                                break;
                            case "4": // BORRAR BIO
                                String codigoBorradoBio;
                                System.out.println("BORRADO DE BIOGRAFIAS");
                                Utilidades.Utilidades.mostrarBiografia();
                                System.out.println("Indique el código de biografia que quiere borrar");
                                codigoBorradoBio = entrada.nextLine();
                                bc.findBiografia(Integer.valueOf(codigoBorradoBio));
                                bc.destroy(Integer.valueOf(codigoBorradoBio));
                                Utilidades.Utilidades.mostrarBiografia();

                                break;

                        }

                    } while (!gestionMenu.contains("5"));
                    break;

                case "2": // MUSICOS
                    do {
                        System.out.println(menuMusicos);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) {
                            case "1": // ALTA MUSICO

                                Utilidades.Utilidades.altaMusico();
                                Utilidades.Utilidades.mostraMusicos();
                                break;

                            case "2": // MOD MUSICO
                                do {
                                    System.out.println(modMusi);
                                    System.out.println("Elija una Opcion");
                                    gestionMenu = entrada.nextLine();
                                    switch (gestionMenu) {
                                        case "1": //MOD A
                                            Utilidades.Utilidades.mostraMusicos();
                                            System.out.println("Indique el codigo de biografia que quiere modificar");
                                            int idModificar = Utilidades.Utilidades.leerEnteroSinErroresScanner();
                                            Utilidades.Utilidades.modificarMusico(idModificar);
                                            Utilidades.Utilidades.mostraMusicos();

                                            break;
                                        case "2": // MOD B
                                            int codInstru;
                                            int musicCod;
                                            System.out.println("Mostramos la lista de Musicos Y Instrumento");
                                            Utilidades.Utilidades.mostrarInstrumentos();
                                            Utilidades.Utilidades.mostraMusicos();
                                            System.out.println("Indique el codigo de Músico que quiere enlazar");
                                            musicCod = Utilidades.Utilidades.leerEnteroSinErroresScanner();
                                            System.out.println("Indique el codigo de Instrumento que quiere enlazar");
                                            codInstru = Utilidades.Utilidades.leerEnteroSinErroresScanner();
                                            Utilidades.Utilidades.enlazarInstrumentoAMusico(codInstru, musicCod);
                                            Utilidades.Utilidades.mostraMusicos();
                                            break;

                                    }

                                } while (!gestionMenu.contains("3"));

                                break;
                            case "3": // MOSTRAR MUSICO
                                Utilidades.Utilidades.mostraMusicos();

                                break;
                            case "4": // BORRAR MUSICO
                                String codigoBorradoMusci;
                                System.out.println("BORRADO DE MUSICOS");
                                Utilidades.Utilidades.mostraMusicos();
                                System.out.println("Indique el código de Músico que quiere borrar");
                                codigoBorradoMusci = entrada.nextLine();

                                mc.findMusico(Integer.valueOf(codigoBorradoMusci));
                                mc.destroy(Integer.valueOf(codigoBorradoMusci));
                                Utilidades.Utilidades.mostraMusicos();

                                break;

                        }

                    } while (!gestionMenu.contains("5"));

                    break;
                case "3": // INSTRUMENTOS
                    do {
                        System.out.println(menuInstrumentos);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) {
                            case "1": // ALTA INSTRU

                                break;

                            case "2": // MOD INSTRU

                                break;
                            case "3": // MOSTRAR INSTRU

                                break;
                            case "4": // BORRAR INSTRI

                                break;

                        }

                    } while (!gestionMenu.contains("5"));
                    break;
                case "4": // GRABACIONES
                    do {
                        System.out.println(menuGrabaciones);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) {
                            case "1": // ALTA GRABA

                                break;

                            case "2": // MOD GRABA

                                break;
                            case "3": // MOSTRAR GRABA

                            case "4": // BORRAR GRABA

                                break;

                        }

                    } while (!gestionMenu.contains("5"));

                    break;
                case "5":
                    do {
                        System.out.println(menuCopiasSegurida);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) { // COPIAS SEGURIDAD
                            case "1":

                                break;

                            case "2":

                                break;
                            case "3":

                                break;
                            case "4":

                                break;

                        }

                    } while (!gestionMenu.contains("5"));

                    break;

            }

        } while (!gestionMenu.contains("6"));

    }
}
