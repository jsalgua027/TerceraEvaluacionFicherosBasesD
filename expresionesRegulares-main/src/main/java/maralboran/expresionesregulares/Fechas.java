
package maralboran.expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Fechas {
    
     public static void main(String[] args) {
        // Suponemos días, meses y años separados con -
        String fecha = "23-08-2021";
        String regex
                = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{1,4})$";

        boolean isValidDate = fecha.matches(regex);
        System.out.println(isValidDate);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fecha);

        System.out.println("Patrones encontrados en la cadena horas");
        while (matcher.find()) {

            System.out.println("Patrón encontrado: " + matcher.group());
            System.out.println("Grupos encontrados " + matcher.groupCount());
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }

    }
    
}
