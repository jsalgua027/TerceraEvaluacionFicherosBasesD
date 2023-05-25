/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programa;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

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
                                               2. Modificar biografia
                                               3.Buscar Biografia
                                               4.salir
                                                
                          
                          
                                           """;

        String menuMusicos = """
                                                
                                                    GESTION MUSICOS
                          
                                               1.Dar de alta Musico
                                               2.Modificar Musico
                                               3.Buscar Musico
                                               4.salir
                                                
                                                    
                                           """;

        String menuInstrumentos = """
                          
                                                
                                                    GESTION INSTRUMENTOS    
                          
                                               1.Dar de alta Instrumento
                                               2.Modificar Instrumento
                                               3.Buscar Instrumento
                                               4.salir
                                                
                                                    
                                           """;

        String menuGrabaciones = """
                       
                                                
                                                    GESTION GRABACIONES
                          
                                               1.Dar de alta Grabación
                                               2. Modificar Grabación
                                               3.Buscar Grabación
                                               4.salir
                                                
                                                    
                                           """;

        String menuCopiasSegurida = """
                                                            GESTION COPIAS DE SEGURIDAD
                                                             
                                                            1.Copia de seguridad de  listado de Biografias
                                                            2.Copia de seguridad de listado de Musicos
                                                            3.Copia de seguridad de listado de Instrumentos
                                                            4.Copia de seguridad de listado de Granaciones
                                                            5. Salir
                                  
                                  
                                                           """;

        String gestionMenu = " ";

        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println(menuPrincipal);
            System.out.println("Elija una Opcion");
            gestionMenu = entrada.nextLine();
            switch (gestionMenu) {
                case "1":
                    do {
                        System.out.println(menuBiografia);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) {
                            case "1":
                                  String bioAux;
                                  LocalDate fechaNaciAux;
                                  String lugarNacimientoAux;
                                  
                                    System.out.println("Gestion de Altas");
                                    System.out.println("Indique la descripcion de la Biografia");

                                break;

                            case "2":

                                break;
                            case "3":

                                break;

                        }

                    } while (!gestionMenu.contains("4"));
                    break;

                case "2":
                    do {
                        System.out.println(menuMusicos);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) {
                            case "1":

                                break;

                            case "2":

                                break;
                            case "3":

                                break;

                        }

                    } while (!gestionMenu.contains("4"));

                    break;
                case "3":
                    do {
                        System.out.println(menuInstrumentos);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) {
                            case "1":

                                break;

                            case "2":

                                break;
                            case "3":

                                break;

                        }

                    } while (!gestionMenu.contains("4"));
                    break;
                case "4":
                    do {
                        System.out.println(menuGrabaciones);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) {
                            case "1":

                                break;

                            case "2":

                                break;
                            case "3":

                                break;

                        }

                    } while (!gestionMenu.contains("4"));

                    break;
                case "5":
                    do {
                        System.out.println(menuCopiasSegurida);
                        System.out.println("Elija una Opcion");
                        gestionMenu = entrada.nextLine();
                        switch (gestionMenu) {
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
