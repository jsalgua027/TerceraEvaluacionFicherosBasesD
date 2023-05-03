/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eje7fnachosalcedo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Windows10
 */
public class MainEje7F {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        List<Empleado> listaEmpleados;
        int contador = 0;
        File aux = new File("./");
        ServicioArchivos.crearDirectorio("JSO");

        listaEmpleados = GestionCSV.leerCsvYcrearObjeto("RelPerCen.csv");
        GestionJSON.escribirJSO(listaEmpleados, "JSO/listaEmpleados.json");
        ServicioArchivos.mostrarFicheros(aux);
        GestionJSON.escribirJSO(listaEmpleados, "JSO/listaEmpleadosFiltrada.json");

        // apartado A
        for (Empleado e : listaEmpleados) {
            if (e.getPuesto().contains("Tecnología")) {

                contador++;

            }

        }

        System.out.println("El número de profesores de Tecnología es: " + contador);

        System.out.println("Saber si algún profesor/a de Informática es también coordinador");
        boolean informatico = false;

        for (Empleado e : listaEmpleados) {
            if (e.getPuesto().contains("Informatica") && e.isCoodinador()) {

                informatico = true;

            }
        }
        System.out.println("Hay algun informatico coordinador: " + informatico);

        System.out.println("Obtener una lista ordenada alfabéticamente con todos los apellidos de los empleados cuyo NIF contenga la letra J.");
        List<String> listaApellidos = new ArrayList<>();

        for (Empleado e : listaEmpleados) {
            if (e.getDni().contains("J")) {

                listaApellidos.add(e.getApellido());
            }

        }
        listaApellidos.sort((a1, a2) -> a1.compareToIgnoreCase(a2));

        listaApellidos.forEach(System.out::println);

        boolean nombre = false;
        for (Empleado e : listaEmpleados) {
            if (e.getNombre().contains("Jonh")) {
                nombre = true;
            }
        }

        System.out.println("Contiene la lista de empleados algún Jonh: " + nombre);

        System.out.println("***************APARTADO B**************************");

        int contadorApiStream = 0;

        contadorApiStream = (int) listaEmpleados.stream()
                .filter(a -> a.getPuesto().contains("Tecnología"))
                .count();

        System.out.println("En la lista de empleados hay:  " + contadorApiStream + " de Tecnología");

        System.out.println(" Saber si algún profesor/a de Informática es también coordinador");

        contadorApiStream = (int) listaEmpleados.stream()
                .filter(a -> a.getPuesto().contains("Informática"))
                .filter(p -> p.getDni().contains("j"))
                .count();

        if (contadorApiStream > 0) {
            System.out.println("Si los hay");
        } else {

            System.out.println("No lo hay");
        }

        System.out.println("Obtener una lista ordenada alfabéticamente con todos los apellidos de los empleados cuyo NIF contenga la letra J.");

        List<String> listaApellidosApistream = new ArrayList<>();

        listaApellidosApistream = listaEmpleados.stream()
                .sorted((a1, a2) -> a1.getApellido().compareToIgnoreCase(a2.getApellido()))
                .filter(a -> a.getDni().contains("J"))
                .map(a -> a.getApellido())
                .toList();

        listaApellidosApistream.forEach(System.out::println);

        boolean hay = true;

        hay = listaEmpleados.stream()
                .allMatch(n -> n.getNombre().contains("Jonh"));

        System.out.println("Hay algún Jonh en la lista de empleados: " + hay);

    }

}
