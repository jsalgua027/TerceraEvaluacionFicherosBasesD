/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejer3y4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nacho
 */
public class Eje3y4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          List<Profesor> listaAux = new ArrayList<>();
        
         listaAux= GestionCSV.leerCsvYcrearObjeto("RelEmpCenAus.csv");
        
        
        listaAux.forEach(System.out::println);
        
        
        
        // ejercicio 4
        
        System.out.println("Aparatado 4_1"); 
        List<String> listaPuestos;
        
        listaPuestos= listaAux.stream()
                .map(p->p.getPuestoTrabajo())
                .distinct()
                .toList();
        
          listaPuestos.forEach(System.out::println);
                       
         System.out.println("Aparatado 4_2");
         
         long cantidadTrabajadores = listaAux.stream()
                        .count();
         
         System.out.println("La cantidadad de trabajadores es: "+ cantidadTrabajadores);
         
         
        System.out.println("Aparatado 4_3");
        
           List<String> listaDniDifere;
           listaDniDifere=listaAux.stream()
                   .filter(p->p.getActivo().equalsIgnoreCase("n"))
                   .sorted((p1,p2)->p1.getDni().compareToIgnoreCase(p2.getDni()))
                  .distinct()
                   .map(p->p.getDni())
                   .toList();
           
           listaDniDifere.forEach(System.out::println);
                   
                   
        System.out.println("Aparatado 4_5");
        
           List<Double> listaPersonasHoras;
           listaPersonasHoras= (List<Double>) listaAux.stream()
                  .map(p->p.getTotalHoras())
                   .sorted((p1,p2)->p1.compareTo(p2))
                   .toList();
                   
                   
           for (int i = 0; i < listaPersonasHoras.size(); i++) {
            
               System.out.println("La persona que mas horas tiene es: "+ listaPersonasHoras.get(1));
               
        }
                  
                   
           
           
        
        
    }
    
}
