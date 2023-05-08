/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p81nachosalcedofacturasbd.aplicacion;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import p81nachosalcedofacturasbd.modelo.FacturaDAO;
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

        List<FacturaVO> listaFacturas = p81nachosalcedofacturasbd.modelo.LeerArchivo.leerCsvYcrearObjeto("facturas.csv");

       // listaFacturas.forEach(System.out::println);

        FacturaDAO daoFactura = new FacturaDAO();

        try {

            System.out.println("Nº personas insertadas " + daoFactura.insertFactura(listaFacturas));
            System.out.println("-----------------------------------------");
            System.out.println("Comprobamos en una nueva lista que se recogen los datos desde la tabla.");
            List<FacturaVO> nuevaLista = daoFactura.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Persona con primary key 1: ");
            System.out.println(daoFactura.findByPk(1));
            System.out.println("-----------------------------------------");
            System.out.println("Se va a borrar la persona con pk 3");
            //System.out.println("Nº personas borradas " + 
            //  daoFactura.deleteFactura(new FacturaVO(3,"Pablo Pérez", LocalDate.of(1997, 12, 5))));
            //  System.out.println("-----------------------------------------");
            nuevaLista = daoFactura.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de borrar una persona -------------");
            nuevaLista.forEach(System.out::println);
            System.out.println("-----------------------------------------");
            System.out.println("Modificación de la persona con pk 5");
//            System.out.println("Nº Personas modificadas " + 
//                    daoPersona.updatePersona(5, new PersonaVO(7,"NuevoNombre", LocalDate.of(2019, 6, 5))));
            System.out.println("-----------------------------------------");
            nuevaLista = daoFactura.getAll();
            System.out.println("-------- Lista con datos recogidos desde la B.D despues de modificar una factura -------------");
            nuevaLista.forEach(System.out::println);
        } catch (SQLException sqle) {
            System.out.println("No se ha podido realizar la operación:");
            System.out.println(sqle.getMessage());
        }
        System.out.println("-------- Lista original --------------------");
        listaFacturas.forEach(System.out::println);

    }

}
