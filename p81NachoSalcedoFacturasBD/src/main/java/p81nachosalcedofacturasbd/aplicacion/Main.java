/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p81nachosalcedofacturasbd.aplicacion;

import java.util.List;
import p81nachosalcedofacturasbd.modelo.FacturaVO;

/**
 *
 * @author nacho
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
       List<FacturaVO> listaFacturas= p81nachosalcedofacturasbd.modelo.LeerArchivo.leerCsvYcrearObjeto("facturas.csv");
       
       
       listaFacturas.forEach(System.out::println);
        
        
    }
    
}
