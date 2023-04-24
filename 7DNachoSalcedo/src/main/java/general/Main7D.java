/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package general;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import vehiculo.Vehiculo;

/**
 *
 * @author nacho
 */
public class Main7D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String directorio = "copias";
        String archivoVacioPrueba = "ArchivoVacio.txt";
        String origenD = ".\\deportivos.txt";
        String destinoD = ".\\copias\\deportivos.txt";
        String origenT = ".\\turismos.txt";
        String destinoT = ".\\copias\\turismos.txt";
        String origenF = ".\\furgonetas.txt";
        String destinoF = ".\\copias\\furgonetas.txt";
        ServicioArchivos.crearDirectorio(directorio);
        
        ServicioArchivos.crearFicheroVacio(directorio, archivoVacioPrueba);
        ServicioArchivos.mostrarConteniDirectorio(".\\copias");
        
        ServicioArchivos.copiarArchivos(origenD, destinoD);
        ServicioArchivos.copiarArchivos(origenT, destinoT);
        ServicioArchivos.copiarArchivos(origenF, destinoF);
        List<Vehiculo> listaAux = ServicioCoches.tresArchivosALista();
        System.out.println("----------------------Imprimo la lista--------------------");
        listaAux.forEach(System.out::println);
        Comparator<Vehiculo> criterioBastidor = (v1, v2) -> v1.getBastidor().compareTo(v2.getBastidor());
        listaAux.stream()
                .sorted(criterioBastidor)
                .forEach(System.out::println);
        
        ServicioArchivos.borrarFichero("deportivos.txt");
        ServicioArchivos.borrarFichero("furgonetas.txt");
        ServicioArchivos.borrarFichero("turismos.txt");
        System.out.println("-------------------Muestro el directorio original----------------------");
        ServicioArchivos.mostrarConteniDirectorio(".\\");
        System.out.println("Imprime por pantalla todas las matrículas ordenadas alfabéticamente de todos  los coches grises distintos");
        
        Predicate<Vehiculo> predicadoColor = (v) -> v.getColor().equalsIgnoreCase("Gris");
        Comparator<Vehiculo> criterioMatriculaAlfa = (v1, v2) -> v1.getMatricula().compareToIgnoreCase(v2.getMatricula());
        
        listaAux.stream()
                .filter(predicadoColor)
                .sorted(criterioMatriculaAlfa)
                .map(v -> v.getMatricula())
                .distinct()
                .forEach(System.out::println);
        
        System.out.println("Imprime por pantalla todas las marcas de coches distintas de aquellos coches que estén disponibles.");
        //OJO el distinc no distingue entre mayusculas y minusculas y aparecen repetidos algunas marcas por ello
        Predicate<Vehiculo> predicadoDiponibles = (v) -> v.isDisponible();
        listaAux.stream()
                .filter(predicadoDiponibles)
                .map(v -> v.getMarca())
                .distinct()
                .forEach(System.out::println);
        
        System.out.println("Saber la cantidad de vehículos Porches");
        Predicate<Vehiculo> predicadoMarca = (v) -> v.getMarca().equalsIgnoreCase("porche");
        
        long contador = 0;
        contador = listaAux.stream()
                .filter(predicadoMarca)
                .count();
        System.out.println("Hay de la marca porche: " + contador);
        
        System.out.println("Comprobar si hay algún Peugeot negro disponible en la lista.");
        Predicate<Vehiculo> predicadoMarcaPeugot = (v) -> v.getMarca().equalsIgnoreCase("Peugeot");
        Predicate<Vehiculo> predicadoMarcaColor = (v) -> v.getColor().equalsIgnoreCase("Negro");
        boolean marca = listaAux.stream()
                .anyMatch(predicadoMarcaPeugot);
        if (marca) {
            boolean color = listaAux.stream()
                    .anyMatch(predicadoMarcaColor);
            if (color) {
                System.out.println("Si hay Peugeot Negro");
            } else {
                System.out.println("No hay Peugeot Negro");
            }
        } else {
            System.out.println("No hay  ningun Peugeot");
        }
        System.out.println("Obtener una lista con todas las tarifas diferentes que se aplican a los vehículos");
        List<Double> listaTarifas = listaAux.stream()
                .map(v -> v.getTarifa())
                .distinct()
                .toList();
        System.out.println("Imprimo la listas de tarifas");
        listaTarifas.forEach(System.out::println);
        
    }
    
}
