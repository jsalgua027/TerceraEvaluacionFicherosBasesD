/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejer1y2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nacho
 */
public class Eje1y2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
           List<Profesor> listaAux = new ArrayList<>();
           Map<String, Double> mapAux = new HashMap<String, Double>();
           
          listaAux= LecturaYescritura.leerCsvYcrearObjeto("RelEmpCenAus.txt");
           
        listaAux.forEach(System.out::println);
          
          mapAux=LecturaYescritura.listaMap(listaAux);
          
          for (Map.Entry<String, Double> entry : mapAux.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            
              System.out.println(key+"-"+ val);
            
        }
          
          LecturaYescritura.escribirJSO(mapAux, "totalHorasPorTrabajador.json");
          
          
    }
    
}
