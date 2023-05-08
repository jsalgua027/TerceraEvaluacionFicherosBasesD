/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p81nachosalcedofacturasbd.modelo;

import java.time.LocalDate;
import java.util.Random;
import java.util.stream.DoubleStream;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.RandomStringUtils;


@XmlRootElement(name = "factura")
// Anotación @XmlAccesorType define el elemento que usará JAXB durante el 
// procesamiento de datos (en este caso por atributo)
@XmlAccessorType(XmlAccessType.FIELD)

/**
 *
 * @author nacho
 */
public class FacturaVO {

    private int codigoUnico;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)

    private LocalDate fechaEmision;
    private String descripcion;
    private double totalImporteFactura;

    private Random ale = new Random();

    private static int contador = 1;

    public FacturaVO() {
        this.codigoUnico = contador++;
        this.fechaEmision = LocalDate.now();
        this.descripcion = RandomStringUtils.randomAlphabetic(10);
        DoubleStream stream = ale.doubles(1, 100.0, 1000.0);
        this.totalImporteFactura = stream.findFirst().getAsDouble();
    }

    

    public int getCodigoUnico() {
        return codigoUnico;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getTotalImporteFactura() {
        return totalImporteFactura;
    }

    public Random getAle() {
        return ale;
    }

    public static int getContador() {
        return contador;
    }

    public void setCodigoUnico(int  codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTotalImporteFactura(double totalImporteFactura) {
        this.totalImporteFactura = totalImporteFactura;
    }

    public void setAle(Random ale) {
        this.ale = ale;
    }

    public static void setContador(int contador) {
        FacturaVO.contador = contador;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(codigoUnico);
        sb.append(";").append(fechaEmision);
        sb.append(";").append(descripcion);
        sb.append(";").append(totalImporteFactura);

        return sb.toString();
    }

    int getPk() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
