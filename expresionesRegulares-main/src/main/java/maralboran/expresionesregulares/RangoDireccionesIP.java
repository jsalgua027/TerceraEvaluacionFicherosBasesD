package maralboran.expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RangoDireccionesIP {

    public static void main(String[] args) {
        String direccion = "192.168.2.23";
        // Comprobar si está en un rango entre 192.168.2.0 a 192.168.2.255
        String regex
                = "^192.168.2.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        /* Para validar el último octeto se usa el siguiente grupo
            25[0-5]: que valida números entre 250 y 255.

            2[0-4][0-9]: que valida números entre 200 y 249.

            [01]?[0-9][0-9]?: que valida números entre 0 y 199, incluyendo números con uno o dos dígitos.

            La expresión [01]? permite que el primer dígito del octeto sea opcional, 
            lo que permite que se validen tanto números de un dígito como de dos dígitos 
            (por ejemplo, 0 y 01 son válidos para el primer octeto).

            La expresión [0-9][0-9]? después del primer dígito valida el segundo y tercer dígito del octeto.
            Así se permiten direcciones del tipo: 192.168.2.021, 192.168.2.001, 192.168.2.1
         */
        boolean isValidIP = direccion.matches(regex);
        System.out.println(isValidIP);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(direccion);

        System.out.println("Patrones encontrados en la cadena email");
        while (matcher.find()) {
            System.out.println("Patrón encontrado: " + matcher.group());
            System.out.println("Grupos encontrados " + matcher.groupCount());
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }

}
