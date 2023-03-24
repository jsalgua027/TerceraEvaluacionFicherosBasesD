
package maralboran.expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DNI {
    
    public static void main(String[] args) {
        String dni = "73552299D";
        String regex = "^[0-9]{8}[a-zA-Z]$"; // También se puede \d{8}[a-zA-Z]

        boolean isValidDNI = dni.matches(regex);
        System.out.println(isValidDNI);
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dni);
        
        System.out.println("Patrones encontrados en la cadena dni");
        while (matcher.find()) {
            System.out.println("Patrón encontrado: " + matcher.group());
        }

    }
    
}
