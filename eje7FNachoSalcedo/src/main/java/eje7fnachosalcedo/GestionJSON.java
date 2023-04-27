/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eje7fnachosalcedo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Windows10
 */
public class GestionJSON {
    
    public static void escribirJSO(List<Empleado>aux,String ruta) throws IOException{
        // Voy a filtrar la lista aux y sacar una nueva lista con la condicion de los a�os trabajados
        // Y esa nueva lista es la que le paso al writeValue()
//        Predicate filtroPoredad
//        aux.stream()
//                .filter(predicate)
    
       ObjectMapper mapeador = new ObjectMapper();
        
        // Permite a mapeador usar fechas seg�n java time
        mapeador.registerModule(new JavaTimeModule());
        
        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el cat�logo de muebles
        mapeador.writeValue(new File(ruta), aux);
                
       
    
    }
    
    
}
