/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package expresiones_regulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author nacho
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    
    /*
    1. mirar un string contiene uno de los siguientes puntos
    
    localizacion :N
    localizacion :S
    localizacion :E
    localizacion :O
    
    
    
    */
    
    
    /*
    2. encontrar si la linea cumple esto:  comience por ini 2 numeros fin ej :in23fin
    
    */
    
    /*
    3    debe de  cumplir letra numero cuantas veces se quiera ej: a5g6a9r9t9 
    
    */
    
    public static void main(String[] args) {
        // creo el patron
        String patron = "Localizacion:[N|S|E|O]";
        
         String textoSinPatron = "hola pepito perez";
         String textoConPatron = "La ciudad de estepona tiene una Localizacion:S ";
         
           Pattern pattern = Pattern.compile(patron);
          Matcher matcher = pattern.matcher(textoConPatron);
         
          System.out.println("Patrones encontrados en la cadena textoConpatron");
        while (matcher.find()) {
            // matcher.group(0) es equivalente a matcher.group()
            System.out.println("Patrón encontrado: " + matcher.group());
        
    }
    
}
}