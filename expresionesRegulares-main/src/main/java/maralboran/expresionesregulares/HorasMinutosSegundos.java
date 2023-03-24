
package maralboran.expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HorasMinutosSegundos {

    public static void main(String[] args) {
        // Suponemos todas las horas en formato 24h y separadas por :
        String horas = "23:45:32";
        String regex
                = "^([0-2][0-9]):([0-5][0-9]):([0-5][0-9])$";

        boolean isValidHour = horas.matches(regex);
        System.out.println(isValidHour);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(horas);

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
