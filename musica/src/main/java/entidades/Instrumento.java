/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nacho
 */
@Entity
@Table(name = "Instrumento")
@NamedQueries({
    @NamedQuery(name = "Instrumento.findAll", query = "SELECT i FROM Instrumento i"),
    @NamedQuery(name = "Instrumento.findByIdInstrumento", query = "SELECT i FROM Instrumento i WHERE i.idInstrumento = :idInstrumento"),
    @NamedQuery(name = "Instrumento.findByNombre", query = "SELECT i FROM Instrumento i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Instrumento.findByTipo", query = "SELECT i FROM Instrumento i WHERE i.tipo = :tipo")})
public class Instrumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInstrumento")
    private Integer idInstrumento;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(mappedBy = "idInstrumento")
    private List<Musico> musicoList;
    @OneToMany(mappedBy = "idInstrumento")
    private List<Grabacion> grabacionList;

    public Instrumento() {
    }

    public Instrumento(Integer idInstrumento) {
        this.idInstrumento = idInstrumento;
    }

    public Instrumento(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;

    }

    public Integer getIdInstrumento() {
        return idInstrumento;
    }

    public void setIdInstrumento(Integer idInstrumento) {
        this.idInstrumento = idInstrumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Musico> getMusicoList() {
        return musicoList;
    }

    public void setMusicoList(List<Musico> musicoList) {
        this.musicoList = musicoList;
    }

    public List<Grabacion> getGrabacionList() {
        return grabacionList;
    }

    public void setGrabacionList(List<Grabacion> grabacionList) {
        this.grabacionList = grabacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstrumento != null ? idInstrumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Instrumento other = (Instrumento) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.idInstrumento, other.idInstrumento);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instrumento{");
        sb.append("idInstrumento=").append(idInstrumento);
        sb.append(", nombre=").append(nombre);
        sb.append(", tipo=").append(tipo);
        try {
            sb.append(", musicoList{");
            sb.append(toStringInstrumentos());
            sb.append("} ");
        } catch (NullPointerException e) {
            sb.append("No hay lista de musicos asociadas");

        }
        try {
            sb.append(", grabacionList{");
            sb.append(toStringGrabaciones());
            sb.append("} ");
        } catch (NullPointerException e) {
            sb.append("No hay lista de grabaciones");

        }

        sb.append('}');
        return sb.toString();
    }

    private String toStringInstrumentos() {
        StringBuilder tmp = new StringBuilder();

        for (Musico mus : musicoList) {

            tmp.append("id:").append(mus.getIdMusico()).append(", ");
        }

        return tmp.length() == 0 ? tmp.toString() : tmp.toString() + "\b\b";
    }

    private String toStringGrabaciones() {
        StringBuilder tmp = new StringBuilder();
        for (Grabacion gra : grabacionList) {

            tmp.append("id:").append(gra.getIdGrabacion()).append(", ");
        }

        return tmp.length() == 0 ? tmp.toString() : tmp.toString() + "\b\b";
    }

}
