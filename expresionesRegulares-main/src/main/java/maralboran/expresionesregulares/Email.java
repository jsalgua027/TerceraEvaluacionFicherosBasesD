
package maralboran.expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * OBTENIDO CON CHATGPT
 En este ejemplo, se define una cadena email que contiene la dirección de correo electrónico 
 que se desea validar. La expresión regular se almacena en la cadena emailPattern, 
 que utiliza una serie de caracteres especiales para definir el formato que se espera de un correo electrónico válido.

La expresión regular incluye los siguientes elementos:

    ^: indica que la cadena debe comenzar con el patrón que sigue [a-zA-Z0-9_+&*-]+
    [a-zA-Z0-9_+&*-]+: indica que se permiten letras, números y ciertos caracteres especiales 
    (como _, +, &, * y -) en el nombre de usuario del correo electrónico. 
    El + indica que se permiten uno o más de estos caracteres.
    
    (?:\\.[a-zA-Z0-9_+&*-]+)*: indica que se pueden agregar puntos y caracteres adicionales 
    al nombre de usuario, siempre y cuando se siga el mismo patrón de letras, números 
    y caracteres especiales. El * indica que se permiten cero o más ocurrencias de este patrón, 
    y el (?: indica que este grupo no se captura como un grupo separado en la expresión regular.
    
    @: indica que debe haber un símbolo de arroba después del nombre de usuario.
    
    (?:[a-zA-Z0-9-]+\\.)+: indica que debe haber uno o más grupos de caracteres 
    alfanuméricos separados por un punto después del símbolo de arroba, 
    lo que representa el dominio del correo electrónico. 
    El (?: nuevamente indica que este grupo no se captura separado, y 
    el + indica que debe haber uno o más de estos grupos.
    
    [a-zA-Z]{2,7}$: indica que el dominio debe ser una cadena de letras 
    de entre 2 y 7 caracteres de longitud. El $ indica que la cadena debe terminar con este patrón.

 */
public class Email {

    public static void main(String[] args) {
        String email = "example.ej@example.com";
        String regex = 
          "^[a-zA-Z0-9_+&-*]+(?:\\.[a-zA-Z0-9_+&-*]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        // CUIDADO - PARA ESCAPAR EL . EN EL STRING HAY QUE AÑADIR DOS BARRAS INVERTIDAS PERO EN 
        // REALIDAD LA EXPRESIÓN REGULAR SOLO TIENE UNA BARRA INVERTIDA \
        boolean isValidEmail = email.matches(regex);
        System.out.println(isValidEmail);
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        
        System.out.println("Patrones encontrados en la cadena email");
        while (matcher.find()) {
            System.out.println("Patrón encontrado: " + matcher.group());
        }
        
        

    }

}
