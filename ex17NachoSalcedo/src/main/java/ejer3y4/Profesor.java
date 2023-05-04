/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer3y4;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author nacho
 */
public class Profesor {

    private String nombre;
    private String apellido;

    private String dni;
    private String tipoPersonal;
    private String puestoTrabajo;
    private boolean horarioPersonalizado;
    private LocalDate fechaAlta;
    private LocalDate fechaBaja;
    private double horasIniciales;
    private Double totalHoras;
    private String Activo;

    public Profesor() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTipoPersonal() {
        return tipoPersonal;
    }

    public void setTipoPersonal(String tipoPersonal) {
        this.tipoPersonal = tipoPersonal;
    }

    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public boolean isHorarioPersonalizado() {
        return horarioPersonalizado;
    }

    public void setHorarioPersonalizado(boolean horarioPersonalizado) {
        this.horarioPersonalizado = horarioPersonalizado;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public double getHorasIniciales() {
        return horasIniciales;
    }

    public void setHorasIniciales(double horasIniciales) {
        this.horasIniciales = horasIniciales;
    }

    public Double getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(Double totalHoras) {
        this.totalHoras = totalHoras;
    }

    public String getActivo() {
        return Activo;
    }

    public void setActivo(String Activo) {
        this.Activo = Activo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Profesor{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", dni=").append(dni);
        sb.append(", tipoPersonal=").append(tipoPersonal);
        sb.append(", puestoTrabajo=").append(puestoTrabajo);
        sb.append(", horarioPersonalizado=").append(horarioPersonalizado);
        sb.append(", fechaAlta=").append(fechaAlta);
        sb.append(", fechaBaja=").append(fechaBaja);
        sb.append(", horasIniciales=").append(horasIniciales);
        sb.append(", totalHoras=").append(totalHoras);
        sb.append(", Activo=").append(Activo);
        sb.append('}');
        return sb.toString();
    }

}
