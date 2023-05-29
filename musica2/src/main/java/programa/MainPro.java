/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programa;

import controladoras.GrabacionJpaController;
import controladoras.InstrumentoJpaController;
import controladoras.MusicoJpaController;
import controladoras.exceptions.IllegalOrphanException;
import controladoras.exceptions.NonexistentEntityException;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Windows10
 */
public class MainPro {

    /**
     * @param args the command line arguments
     */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_musica2_jar_1.0-SNAPSHOTPU");
    private static final MusicoJpaController mc = new MusicoJpaController(emf);
    private static final InstrumentoJpaController ic = new InstrumentoJpaController(emf);
    private static final GrabacionJpaController gc = new GrabacionJpaController(emf);

    public static void main(String[] args) throws IllegalOrphanException, Exception {
        String menuPrincipal = """
                           
                                                     PRODUCCIONES MUSICALES GEPETO
                           
                           
                                                    
                                                      1.Gestion Musicos
                                                      2.Gestion Instrumentos
                                                      3.Gestion Grabaciones
                                                      4.Gestion Copias de seguridad
                                                      6.Salir
                          
                          
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
                                                             
                                                            1.Realizar Copia de Seguridad
                                                            2.Mostrar Directorios
                                                            3.Restaurar
                                                            4.Salir
                                                     
                                  
                                  
                                                           """;

        String modMusi
                = """
                                  MODIFICACION MUSICOS
                                 
                                 1.Para modificar Datos
                                 2.Para Añadir Instrumento
                                 3.Salir
                                 
                                 
                                 """;

        String modInstrumentos = """
                                                 MODIFICACION INSTRUMENTOS
                                                 
                                                 1.Para modificar Datos
                                                 2.Para Añadir Músicos
                                                 3.Salir
                               
                                               """;

        String modGrabaciones = """
                                                 MODIFICACION GRABACIONES
                                                 
                                                 1.Para modificar Grabacion
                                                 2.Para Añadir Instrumentos
                                                 3.Salir
                               
                                               """;

        String gestionMenu = " ";

        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println(menuPrincipal);
            System.out.println("Elija una Opcion");
            gestionMenu = entrada.nextLine();
            switch (gestionMenu) {

                case "1" -> {
                    // MUSICOS
                    do {
                        System.out.println(menuMusicos);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) {
                            case "1" -> {
                                // ALTA MUSICO

                                Utilidades.UtilidadesProg.altaMusico();
                                Utilidades.UtilidadesProg.mostraMusicos();
                            }

                            case "2" -> {
                                // MOD MUSICO
                                do {
                                    System.out.println(modMusi);
                                    System.out.println("Elija una Opcion");
                                    gestionMenu = entrada.nextLine();
                                    switch (gestionMenu) {
                                        case "1" -> {
                                            //MOD A
                                            Utilidades.UtilidadesProg.mostraMusicos();
                                            System.out.println("Indique el codigo de biografia que quiere modificar");
                                            int idModificar = Utilidades.UtilidadesProg.leerEnteroSinErroresScanner();
                                            Utilidades.UtilidadesProg.modificarMusico(idModificar);
                                            Utilidades.UtilidadesProg.mostraMusicos();
                                        }
                                        case "2" -> {
                                            // MOD B
                                            int codInstru;
                                            int musicCod;
                                            System.out.println("Mostramos la lista de Musicos Y Instrumento");
                                          
                                            Utilidades.UtilidadesProg.mostraMusicos();
                                              Utilidades.UtilidadesProg.mostrarInstrumentos();
                                            System.out.println("Indique el codigo de Músico que quiere enlazar");
                                            musicCod = Utilidades.UtilidadesProg.leerEnteroSinErroresScanner();
                                            System.out.println("Indique el codigo de Instrumento que quiere enlazar");
                                            codInstru = Utilidades.UtilidadesProg.leerEnteroSinErroresScanner();
                                            try {
                                                Utilidades.UtilidadesProg.enlazarInstrumentoAMusico(codInstru, musicCod);
                                                Utilidades.UtilidadesProg.mostraMusicos();
                                            } catch (NullPointerException e) {
                                                System.out.println("No existe ese instrumento");
                                            }

                                        }

                                    }

                                } while (!gestionMenu.contains("3"));
                            }
                            case "3" -> // MOSTRAR MUSICO
                                Utilidades.UtilidadesProg.mostraMusicos();
                            case "4" -> {
                                // BORRAR MUSICO
                                String codigoBorradoMusci;
                                System.out.println("BORRADO DE MUSICOS");
                                Utilidades.UtilidadesProg.mostraMusicos();
                                System.out.println("Indique el código de Músico que quiere borrar");
                                codigoBorradoMusci = entrada.nextLine();

                                mc.findMusico(Integer.valueOf(codigoBorradoMusci));
                                try {
                                    Utilidades.UtilidadesProg.borrarMusico(Integer.valueOf(codigoBorradoMusci));
                                    Utilidades.UtilidadesProg.mostraMusicos();
                                } catch (NonexistentEntityException e) {
                                    System.out.println("Ese Músico no se encuenta en la Base de datos");
                                }
                            }

                        }

                    } while (!gestionMenu.contains("5"));
                }
                case "2" -> {
                    // INSTRUMENTOS
                    do {
                        System.out.println(menuInstrumentos);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) {
                            case "1" -> {
                                // ALTA INSTRU
                                Utilidades.UtilidadesProg.altaInstrumentos();
                                Utilidades.UtilidadesProg.mostrarInstrumentos();
                            }

                            case "2" -> {
                                // MOD INSTRU
                                do {
                                    System.out.println(modInstrumentos);
                                    System.out.println("Elija una Opcion");
                                    gestionMenu = entrada.nextLine();
                                    switch (gestionMenu) {
                                        case "1" -> {
                                            //MOD A
                                            Utilidades.UtilidadesProg.mostrarInstrumentos();
                                            System.out.println("Indique el codigo de Instrumento que quiere modificar");
                                            int idModificar = Utilidades.UtilidadesProg.leerEnteroSinErroresScanner();
                                            Utilidades.UtilidadesProg.modificarInstrumento(idModificar);
                                            Utilidades.UtilidadesProg.mostrarInstrumentos();
                                        }
                                        case "2" -> {
                                            // MOD B
                                            int instruCod;
                                            int musicCod;
                                            System.out.println("Mostramos la lista de Instrumentos y Músicos");
                                            Utilidades.UtilidadesProg.mostrarInstrumentos();
                                            Utilidades.UtilidadesProg.mostraMusicos();
                                            System.out.println("Indique el codigo de Instrumento que quiere enlazar");
                                            instruCod = Utilidades.UtilidadesProg.leerEnteroSinErroresScanner();
                                            System.out.println("Indique el codigo de Musico que quiere enlazar");
                                            musicCod = Utilidades.UtilidadesProg.leerEnteroSinErroresScanner();
                                            try {
                                                Utilidades.UtilidadesProg.añadirMusicosAlInstrumento(instruCod, musicCod);
                                                Utilidades.UtilidadesProg.mostrarInstrumentos();
                                            } catch (NullPointerException e) {
                                            }

                                        }

                                    }

                                } while (!gestionMenu.contains("3"));
                            }
                            case "3" -> // MOSTRAR INSTRU
                                Utilidades.UtilidadesProg.mostrarInstrumentos();
                            case "4" -> {
                                // BORRAR INSTRI
                                String codigoBorradoInstrume;
                                System.out.println("BORRADO DE INSTRUMENTOS");
                                Utilidades.UtilidadesProg.mostraMusicos();
                                System.out.println("Indique el código de Instrumento que quiere borrar");
                                codigoBorradoInstrume = entrada.nextLine();
                                ic.findInstrumento(Integer.valueOf(codigoBorradoInstrume));
                                try {
                                    Utilidades.UtilidadesProg.borrarInstrumento(Integer.valueOf(codigoBorradoInstrume));
                                    Utilidades.UtilidadesProg.mostrarInstrumentos();
                                } catch (NonexistentEntityException e) {
                                    System.out.println("Ese Instrumento no se encuenta en la Base de datos");

                                }
                            }

                        }

                    } while (!gestionMenu.contains("5"));
                }
                case "3" -> {
                    // GRABACIONES
                    do {
                        System.out.println(menuGrabaciones);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) {
                            case "1" -> {
                                // ALTA GRABA
                                Utilidades.UtilidadesProg.altaGrabacion();
                                Utilidades.UtilidadesProg.mostrarGrabaciones();
                            }

                            case "2" -> {
                                // MOD GRABA
                                do {
                                    System.out.println(modGrabaciones);
                                    System.out.println("Elija una Opcion");
                                    gestionMenu = entrada.nextLine();
                                    switch (gestionMenu) {
                                        case "1" -> {
                                            //MOD A
                                            Utilidades.UtilidadesProg.mostrarGrabaciones();
                                            System.out.println("Indique el codigo de Grabacion que quiere modificar");
                                            int idModificar = Utilidades.UtilidadesProg.leerEnteroSinErroresScanner();
                                            Utilidades.UtilidadesProg.modificarGrabacion(idModificar);
                                            Utilidades.UtilidadesProg.mostrarGrabaciones();
                                        }
                                        case "2" -> {
                                            // MOD B
                                            int instruCod;
                                            int grabaCod;
                                            System.out.println("Mostramos la lista de Grabaciones y Instrumentos");
                                            Utilidades.UtilidadesProg.mostrarGrabaciones();
                                            Utilidades.UtilidadesProg.mostrarInstrumentos();
                                            System.out.println("Indique el codigo de Grabación que quiere enlazar");
                                            grabaCod = Utilidades.UtilidadesProg.leerEnteroSinErroresScanner();
                                            System.out.println("Indique el codigo del Instrumento que quiere enlazar");
                                            instruCod = Utilidades.UtilidadesProg.leerEnteroSinErroresScanner();
                                            try {
                                                Utilidades.UtilidadesProg.añadirInstrumentosAGrabacion(grabaCod, instruCod);
                                                Utilidades.UtilidadesProg.mostrarGrabaciones();
                                            } catch (NullPointerException e) {

                                            }

                                        }

                                    }

                                } while (!gestionMenu.contains("3"));
                            }
                            case "3" -> // MOSTRAR GRABA
                                Utilidades.UtilidadesProg.mostrarGrabaciones();
                            case "4" -> {
                                // BORRAR GRABA
                                String codigoBorradoGrabacion;
                                System.out.println("BORRADO DE GRABACIONES");
                                Utilidades.UtilidadesProg.mostrarGrabaciones();
                                System.out.println("Indique el código de Grabación que quiere borrar");
                                codigoBorradoGrabacion = entrada.nextLine();
                                gc.findGrabacion(Integer.valueOf(codigoBorradoGrabacion));
                                try {
                                    Utilidades.UtilidadesProg.borrarGrabacion(Integer.valueOf(codigoBorradoGrabacion));
                                    Utilidades.UtilidadesProg.mostrarGrabaciones();
                                } catch (NonexistentEntityException e) {
                                    System.out.println("Esa Grabación no se encuenta en la Base de datos");
                                }
                            }

                        }

                    } while (!gestionMenu.contains("5"));
                }
                case "4" -> {
                    do {
                        System.out.println(menuCopiasSegurida);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) { // COPIAS SEGURIDAD
                            case "1" -> {
                              //   creo directorio y archivos
                                Utilidades.ServicioArchivos.crearDirectorioFechas();
                                Utilidades.ServicioArchivos.rellenarDirectorios();
                            }

                            case "2" -> {
                                // muestro
                                Utilidades.ServicioArchivos.mostrarConteniDirectorio("./copias/");

                            }
                            case "3" -> {
                               // Restauraciones
                                int posicion;
                                String ruta;
                                Utilidades.ServicioArchivos.mostrarConteniDirectorio("./copias/");
                                System.out.println("Indique que Directorio quiere Restaurar de la lista, según el orden del listado indique que número quiere restaurar");
                                posicion = Utilidades.UtilidadesProg.leerEnteroSinErroresScanner()-1 ;
                                ruta = Utilidades.ServicioArchivos.optenerRutaDirectorio("./copias/", posicion);
                                Utilidades.UtilidadesProg.borrarBase();
                                
                                System.out.println("LA RUTA QUE LLEGA AL METODO ES: "+ ruta);
                                Utilidades.ServicioArchivos.DirectorioABasededatos(ruta);

                            }

                        }
                        // COPIAS SEGURIDAD

                    } while (!gestionMenu.contains("4"));
                }

            }

        } while (!gestionMenu.contains("6"));

    }

}
