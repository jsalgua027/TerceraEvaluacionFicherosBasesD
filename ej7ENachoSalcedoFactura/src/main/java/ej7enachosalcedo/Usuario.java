/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej7enachosalcedo;

import java.util.Scanner;

/**
 *
 * @author Windows10
 */
public class Usuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Factura facturaSolicitada;
        ServicioArchivos.mostrarConteniDirectorio("./facturascsv");
        String respuesta;
        System.out.println("Que factura quieres leer");
        respuesta = teclado.nextLine();
        LecturaYEscritura.leerArchivoCSV("facturascsv/" + respuesta);
        facturaSolicitada = LecturaYEscritura.leerCsvYcrearObjeto("facturascsv/" + respuesta);

        System.out.println("Imprimo el objeto creado");
        System.out.println(facturaSolicitada.toString());

        ServicioArchivos.borrarFichero("facturascsv/" + respuesta);
        System.out.println("Muesto el contenido del directorio despues del borrado");
        ServicioArchivos.mostrarConteniDirectorio("./facturascsv");

    }

}
