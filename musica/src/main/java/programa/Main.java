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
    
    public static void main(String[] args) throws NonexistentEntityException {
        
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
                                               3.Buscar Biografia
                                               4.Borrar Biografia
                                               5.salir
                                                
                          
                          
                                           """;
        
        String menuMusicos = """
                                                
                                                    GESTION MUSICOS
                          
                                               1.Dar de alta Musico
                                               2.Modificar Musico
                                               3.Buscar Musico
                                               4.Borrar Musico
                                               5.salir
                                                
                                                    
                                           """;
        
        String menuInstrumentos = """
                          
                                                
                                                    GESTION INSTRUMENTOS    
                          
                                               1.Dar de alta Instrumento
                                               2.Modificar Instrumento
                                               3.Buscar Instrumento
                                               4.Borrar Instrumento
                                               4.salir
                                                
                                                    
                                           """;
        
        String menuGrabaciones = """
                       
                                                
                                                    GESTION GRABACIONES
                          
                                               1.Dar de alta Grabación
                                               2.Modificar Grabación
                                               3.Buscar Grabación
                                               4.Borrar Grabacion
                                               5.salir
                                                
                                                    
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
                                 2.Para Añadir Biografia
                                 3.Salir
                                 
                                 
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
//                                Biografia altaBio = new Biografia();
//                                String descriAux;
//                                LocalDate fechaNaciAux;
//                                int dia = 0;
//                                int mes = 0;
//                                int anio = 0;
//                                
//                                String lugarNacimientoAux;
//                                
//                                System.out.println("Gestion de Altas");
//                                System.out.println("Indique la descripcion de la Biografia");
//                                descriAux = entrada.nextLine();
//                                System.out.println("Indique la Fecha de Nacimiento");
//                                System.out.println("Que año");
//                                anio = Utilidades.Utilidades.leerEnteroSinErroresScanner();
//                                do {
//                                    System.out.println("Que Mes");
//                                    mes = Utilidades.Utilidades.leerEnteroSinErroresScanner();
//                                } while (mes < 1 || mes > 12);
//                                do {
//                                    System.out.println("Que dia");
//                                    dia = Utilidades.Utilidades.leerEnteroSinErroresScanner();
//                                } while (dia < 1 || dia > 31);
//                                
//                                System.out.println("Indique lugar de Nacimiento");
//                                lugarNacimientoAux = entrada.nextLine();
//                                
//                                fechaNaciAux = LocalDate.of(anio, mes, dia);
//                                altaBio.setDescripcion(descriAux);
//                                altaBio.setFechaNacimiento(Utilidades.Utilidades.LocalADate(fechaNaciAux));
//                                altaBio.setLugarNacimiento(lugarNacimientoAux);
//                                bc.create(altaBio);
                                Utilidades.Utilidades.altaBiografia();
                                Utilidades.Utilidades.mostrarBiografia();
                                
                                break;
                            
                            case "2":
                                do {                                    
                                    System.out.println(modBio);
                                    System.out.println("Elija una Opcion");
                                    gestionMenu = entrada.nextLine();
                                    switch (gestionMenu) {
                                        case "1":
                                             Utilidades.Utilidades.mostrarBiografia();
                                            System.out.println("Indique el codigo de biografia que quiere modificar");
                                            int idModificar = Utilidades.Utilidades.leerEnteroSinErroresScanner();
                                            bc.findBiografia(idModificar);
                                            
                                            break;
                                         case "2":
                                             System.out.println("Mostramos la lista de Musicos Y Biografias");
                                              Utilidades.Utilidades.mostrarBiografia();
                                               Utilidades.Utilidades.mostraMusicos();
                                            
                                            break;
                                       
                                    }
                                    
                                } while (!gestionMenu.contains("3"));
                                break;
                            case "3":
                                
                                break;
                            case "4":
                                String codigoBorradoBio;
                                System.out.println("BORRADO DE BIOGRAFIAS");
                                Utilidades.Utilidades.mostrarBiografia();
                                System.out.println("Indique el código de biografia que quiere borrar");
                                codigoBorradoBio = entrada.nextLine();
                                bc.findBiografia(Integer.parseInt(codigoBorradoBio));
                                bc.destroy(Integer.parseInt(codigoBorradoBio));
                                Utilidades.Utilidades.mostrarBiografia();
                                
                                break;
                            
                        }
                        
                    } while (!gestionMenu.contains("5"));
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
                            case "4":
                                
                                break;
                            
                        }
                        
                    } while (!gestionMenu.contains("5"));
                    
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
                            case "4":
                                
                                break;
                            
                        }
                        
                    } while (!gestionMenu.contains("5"));
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
                            
                            case "4":
                                
                                break;
                            
                        }
                        
                    } while (!gestionMenu.contains("5"));
                    
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
