
package maralboran.expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PasswordsEntre6y8 {

    public static void main(String[] args) {
        // En la variable regexp se guarda una expresión regular para coincidir con cualquier
        // caracter entre 6 y 8 veces
        // Un sombrero ^ (circunflejo) al principio de una expresión regular significa que es 
        // el principio de una línea, y cualquier carácter inmediatamente siguiente a él debe ubicarse al principio de la cadena.
        // La cadena debe comenzar exactamente con este patrón.
        // El caracter $ indica que la cadena debe terminar exactamente con este patrón.
        String regexp = "^.{6,8}$";
        // Estos string guardan las cadenas de texto de ejemplo para evaluar
        String ejemplo1 = "2345!%!";
        String ejemplo2 = "235!%!%$contraseña!";
        

        // El método matches indica si la cadena que llama al método coincide exactamente
        // con el patrón en cuanto a caracteres y longitud
        if (ejemplo1.matches(regexp)){ // Este ejemplo devuelve true
            System.out.println("La cadena de texto ejemplo1 coincide exactamente con la expresión regular");
        }
        
        if (ejemplo2.matches(regexp)){ // Este ejemplo devuelve false por el tamaño de la cadena
            System.out.println("La cadena de texto ejemplo2 coincide exactamente con la expresión regular");
        }
        
        // Que matches devuelva false no implica que parte de la cadena no cumpla el patrón
        // Para saberlo hay que compilar la expresión regular a un objeto Pattern
        // y a partir de éste obtener un objeto Matcher para el string de ejemplo, ejemplo2 en este caso
        
        //regexp = ".{6,8}"; // En este caso no se fuerza a que la cadena comience y termine con el patrón exacto
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(ejemplo2);

        // El método find() de Matcher busca, dentro de la cadena ejemplo2, 
        // las secuencias de caracteres que cumplen el patrón
        System.out.println("Patrones encontrados en la cadena ejemplo2");
        while (matcher.find()) {
            // matcher.group(0) es equivalente a matcher.group()
            System.out.println("Patrón encontrado: " + matcher.group());
        }
        
        // Si las contraseñas deben ser de tamaño exacto 8, se puede usar
        // la siguiente expresión regular
        //String regexp = ".{8}";
        
        
        // Si las contraseñas deben ser mínimo de 8 y sin un ḿaximo de
        // caracteres establecido se puede usar la siguiente expresión regular
        //String regexp = ".{8,}";
        
        // También se pueden tener contraseñas con ciertos caracteres especiales
        // String regexp = [A-Za-z0-9_@#*.;$%&()]{6,8}
    }

}
