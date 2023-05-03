/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej7enachosalcedo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;

/**
 *
 * @author nacho
 */
public class GenerarFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException {
        
        List<Factura>listaFactura= new ArrayList<>();
        
        String carpetaCSV= "CSV";
        String carpetaXML= "XML";
        String carpetaFacturas= "facturascsv";
        
        for (int i = 0; i < 50; i++) {
            
            Factura aux = new Factura();
            listaFactura.add(aux);
                    
        }
        
        listaFactura.forEach(System.out::println);
        
        ServicioArchivos.crearDirectorio(carpetaCSV);
        ServicioArchivos.crearDirectorio(carpetaXML);
        
        LecturaYEscritura.escritura(listaFactura, "CSV/facturas.csv");
        LecturaYEscritura.escrituraXML(listaFactura, "Lista Facturas", "XML/facturas.xml");
        
           ServicioArchivos.crearDirectorio(carpetaFacturas);
           
           LecturaYEscritura.escritura2(listaFactura);
        
        
    }
    
}
