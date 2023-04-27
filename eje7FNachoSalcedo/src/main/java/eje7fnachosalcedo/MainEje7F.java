/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eje7fnachosalcedo;

import java.io.IOException;
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
        List<Empleado>listaEmpleados;
  
        ServicioArchivos.crearDirectorio("JSO");
        
        listaEmpleados= GestionCSV.leerCsvYcrearObjeto("RelPerCen.csv");
       GestionJSON.escribirJSO(listaEmpleados, "JSO/listaEmpleados.json");

    }
    
}
