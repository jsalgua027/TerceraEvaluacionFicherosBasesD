/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bnachosalcedo;

import ejercicio2_vehiculo.Deportivo;
import ejercicio2_vehiculo.Furgoneta;
import ejercicio2_vehiculo.Turismo;
import ejercicio2_vehiculo.Vehiculo;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nacho
 */
public class General {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos= new ArrayList<>();

        Vehiculo t1 = new Turismo(4, true, Long.MAX_VALUE, "4512f", "Seat", "Ibiza", "Blanco", 12.000, true);
        Vehiculo t2 = new Turismo(4, true, Long.MAX_VALUE, "2222f", "ford", "ka", "Rojo", 12.000, true);
        Vehiculo t3 = new Turismo(4, true, Long.MAX_VALUE, "3333f", "porche", "911", "Azul", 50.000, true);
        Vehiculo t4 = new Turismo(4, true, Long.MAX_VALUE, "4444f", "ferrari", "F50", "Blanco", 120.000, true);
        Vehiculo t5 = new Turismo(4, true, Long.MAX_VALUE, "5555", "opel", "Sierra", "Verde", 15.000, true);
        Vehiculo t6 = new Turismo(4, true, Long.MAX_VALUE, "6666f", "wolfaen", "GolfV", "Blanco", 24.000, true);
        Vehiculo t7 = new Turismo(4, true, Long.MAX_VALUE, "7777f", "Dacia", "Ibiza", "Blanco", 12.000, true);
        Vehiculo t8 = new Turismo(4, true, Long.MAX_VALUE, "8888f", "Mercedes", "A2", "Negro", 30.000, true);
        Vehiculo t9 = new Turismo(4, true, Long.MAX_VALUE, "9999f", "Lamborgini", "Diablo", "Verde", 250.000, true);
        Vehiculo t10 = new Turismo(4, true, Long.MAX_VALUE, "1010f", "Opel", "Corsa", "Blanco", 12.000, true);

        Vehiculo d1 = new Deportivo(1200, Long.MAX_VALUE, "1234F", "Porche", "944", "Azul", 120.000, true);
        Vehiculo d2 = new Deportivo(2200, Long.MAX_VALUE, "5555F", "Ferrari", "F40", "Rojo", 500.000, true);
        Vehiculo d3 = new Deportivo(3300, Long.MAX_VALUE, "8596F", "Porche", "943", "verde", 156.000, true);
        Vehiculo d4 = new Deportivo(2000, Long.MAX_VALUE, "4587F", "Ferrari", "Testarrosa", "Rojo", 500.000, true);
        Vehiculo d5 = new Deportivo(4000, Long.MAX_VALUE, "7894F", "Ferrari", "435", "Amarillo", 250.000, true);
        Vehiculo d6 = new Deportivo(5000, Long.MAX_VALUE, "4523F", "Maserati", "GranTurismo", "Gris", 500.000, true);
        Vehiculo d7 = new Deportivo(2200, Long.MAX_VALUE, "5863F", "Mercedes", "A45AMG", "Plata", 120.000, true);
        Vehiculo d8 = new Deportivo(3500, Long.MAX_VALUE, "8965F", "Audi", "A5", "Amarillo", 80.000, true);
        Vehiculo d9 = new Deportivo(4500, Long.MAX_VALUE, "7891F", "Lamborgini", "Diabele", "Negro", 500.000, true);
        Vehiculo d10 = new Deportivo(6800, Long.MAX_VALUE, "4569F", "Porche", "928", "Rojo", 350.000, true);

        Vehiculo f1 = new Furgoneta(2500, 250, Long.MAX_VALUE, "1234G", "Opel", "Van", "Verde", 25.000, true);
        Vehiculo f2 = new Furgoneta(2500, 255, Long.MAX_VALUE, "3546G", "Ford", "fff", "Azul", 12.000, true);
        Vehiculo f3 = new Furgoneta(3500, 266, Long.MAX_VALUE, "8654G", "Seat", "aaa", "Rojo", 10.500, true);
        Vehiculo f4 = new Furgoneta(1000, 134, Long.MAX_VALUE, "9999G", "Renault", "eee", "Amarillo", 5.000, true);
        Vehiculo f5 = new Furgoneta(2200, 333, Long.MAX_VALUE, "4575G", "Opel", "iii", "Verde", 6.000, true);
        Vehiculo f6 = new Furgoneta(2300, 444, Long.MAX_VALUE, "8963G", "Mercedes", "yyy", "Marron", 15.000, true);
        Vehiculo f7 = new Furgoneta(1235, 555, Long.MAX_VALUE, "4567G", "Renault", "ooo", "Rojo", 22.000, true);
        Vehiculo f8 = new Furgoneta(5632, 666, Long.MAX_VALUE, "3569G", "Seat", "uuu", "Gris", 25.000, true);
        Vehiculo f9 = new Furgoneta(2230, 255, Long.MAX_VALUE, "7846G", "Opel", "eee", "Tierra", 12.500, true);
        Vehiculo f10 = new Furgoneta(2531, 124, Long.MAX_VALUE, "8654G", "Mercedes", "jjj", "Rosa", 11.000, true);
        
        
        
        listaVehiculos.add(t1);
        listaVehiculos.add(t2);
        listaVehiculos.add(t3);
        listaVehiculos.add(t4);
        listaVehiculos.add(t5);
        listaVehiculos.add(t6);
        listaVehiculos.add(t7);
        listaVehiculos.add(t8);
        listaVehiculos.add(t9);
        listaVehiculos.add(t10);
        
        
        listaVehiculos.add(d1);
        listaVehiculos.add(d2);
        listaVehiculos.add(d3);
        listaVehiculos.add(d4);
        listaVehiculos.add(d5);
        listaVehiculos.add(d6);
        listaVehiculos.add(d7);
        listaVehiculos.add(d8);
        listaVehiculos.add(d9);
        listaVehiculos.add(d10);
        
        
        listaVehiculos.add(f1);
        listaVehiculos.add(f2);
        listaVehiculos.add(f3);
        listaVehiculos.add(f4);
        listaVehiculos.add(f5);
        listaVehiculos.add(f6);
        listaVehiculos.add(f7);
        listaVehiculos.add(f8);
        listaVehiculos.add(f9);
        listaVehiculos.add(f10);
        
        ServicoCoches.escritura(listaVehiculos, "Vehiculos.txt");
        
        List<Vehiculo> listaArchivo = ServicoCoches.lecturaFicheroPasoALista( "Vehiculos.txt");
        
        
        for (Vehiculo v : listaArchivo) {
            System.out.println(v.toString());
        }
                

    }

}
