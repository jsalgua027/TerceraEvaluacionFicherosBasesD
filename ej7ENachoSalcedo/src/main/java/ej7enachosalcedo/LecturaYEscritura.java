/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej7enachosalcedo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author nacho
 */
public class LecturaYEscritura {

    public static void escritura(List<Factura> aux, String ruta) {

        String tmp = " ";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {

            for (Factura factura : aux) {
                tmp = factura.toString();
                flujo.write(tmp);
                flujo.newLine();
            }

            flujo.flush();

            System.out.println("Fichero " + ruta + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void escritura2(List<Factura> aux) {

        String tmp = " ";

        for (Factura factura : aux) {
            try ( BufferedWriter flujo = new BufferedWriter(new FileWriter("CSV/facturas" + factura.getCodigoUnico() + ".csv"))) {

                tmp = factura.toString();
                flujo.write(tmp);
                flujo.newLine();
                flujo.flush();

                System.out.println("Fichero " + "CSV/facturas" + factura.getCodigoUnico() + ".csv" + " creado correctamente.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public static void escrituraXML(List<Factura> listAux, String descripcion, String ruta) throws JAXBException {

        // Se preparan los objetos a utilizar, en esta caso un catálogo
        CatalogoFacturas catalogo = new CatalogoFacturas();
        catalogo.setLista((ArrayList<Factura>) listAux);
        catalogo.setDescripcion(descripcion);

        // Crea el contexto JAXB. Se encarga de definir los objetos 
        // que vamos a guardar. En nuestro caso sólo el tipo CatalogoMuebles
        JAXBContext contexto = JAXBContext.newInstance(CatalogoFacturas.class);

        // El contexto JAXB permite crear un objeto Marshaller, que sirve para
        // generar la estructura del fichero XML 
        // El proceso de pasar objetos Java (CatalogoMuebles) a ficheros XML 
        // se conoce como "marshalling" o "serialización"
        Marshaller serializador = contexto.createMarshaller();

        // Especificamos que la propiedad del formato de salida
        // del serializador sea true, lo que implica que el formato se 
        // realiza con indentación y saltos de línea
        serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Llamando al método de serialización marshal (sobrecargado) se pueden
        // serializar objetos java en formato XML y volcarlos donde necesitemos:
        // consola, ficheros. El proceso consiste en que el contexto es el 
        // encargo de leer los objetos java, pasarlos al serializador y éste 
        // crear la salida de serialización
        // Serialización y salida por consola
        serializador.marshal(catalogo, System.out);

        // Volcado al fichero xml
        serializador.marshal(catalogo, new File(ruta));

    }
;

}
