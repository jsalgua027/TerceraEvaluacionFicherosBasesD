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

        //ejercicio1
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

        // ejercicio2
        String patron2 = "ini[0-9]{2}fin";
        String texto = "Hola como estas bien ini2fin fin45ini, aunque si eso pues ini45fin , ini78fin";

        Pattern pattern2 = Pattern.compile(patron2);
        Matcher matcher2 = pattern2.matcher(texto);

        System.out.println("Patrones encontrados en la cadena texto, del segundo apartado");
        while (matcher2.find()) {
            // matcher.group(0) es equivalente a matcher.group()
            System.out.println("Patrón encontrado: " + matcher2.group());

        }
        // ejercicio3
        String patron3 = "[0-9][a-z]";
        String texto2 = " juego de palabras  aa244ab456b   a2d3d4f5";

        Pattern pattern3 = Pattern.compile(patron3);
        Matcher matcher3 = pattern3.matcher(texto);

        System.out.println("Patrones encontrados en la cadena texto2, del tercer apartado");
        while (matcher3.find()) {
            // matcher.group(0) es equivalente a matcher.group()
            System.out.println("Patrón encontrado: " + matcher3.group());
        }
    }
}
