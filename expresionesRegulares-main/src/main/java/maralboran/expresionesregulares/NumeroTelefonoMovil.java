/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maralboran.expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author carlos
 */
public class NumeroTelefonoMovil {

    public static void main(String[] args) {
        // Número de teléfono móvil que empieza con + prefijo internacional
        // y luego el número debe comenzar por 6 o 7
        
        String numero = "+34676667111";
        String regex
                = "^\\+(\\d{2})(?:[67]\\d{8})$";

        /*
            La expresión comienza con el caracter +, seguido de dos números
            cualesquiera para el prefijo internacional \\+(\\d{2}). Este grupo se captura
            por si se quiere saber el prefijo 
            El patrón sigue con otros otro grupo que no se captura (?: , [67] es para indicar que 
            debe haber al menos un 6 o un 7 y  el resto \\d{8} es el que detecta los 8 dígitos 
            restantes del cualesquiera número móvil.
            Si se quiere capturar el grupo que contiene el número sin el prefijo hay que quitar el ?:
        */
        
        boolean isValidNumber = numero.matches(regex);
        System.out.println(isValidNumber);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numero);

        System.out.println("Patrones encontrados en la cadena numero");
        while (matcher.find()) {

            System.out.println("Patrón encontrado: " + matcher.group());
            System.out.println("Grupos encontrados " + matcher.groupCount());
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }

}
