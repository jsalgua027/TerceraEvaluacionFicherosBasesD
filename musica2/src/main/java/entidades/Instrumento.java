/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Windows10
 */
@Entity
@Table(name = "instrumento")
@XmlRootElement
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
    private List<Grabacion> grabacionList;
    @JoinColumn(name = "idMusico", referencedColumnName = "idMusico")
    @OneToOne
    private Musico idMusico;

    public Instrumento() {
    }

    public Instrumento(Integer idInstrumento) {
        this.idInstrumento = idInstrumento;
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

    @XmlTransient
    public List<Grabacion> getGrabacionList() {
        return grabacionList;
    }

    public void setGrabacionList(List<Grabacion> grabacionList) {
        this.grabacionList = grabacionList;
    }

    public Musico getIdMusico() {
        return idMusico;
    }

    public void setIdMusico(Musico idMusico) {
        this.idMusico = idMusico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstrumento != null ? idInstrumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instrumento)) {
            return false;
        }
        Instrumento other = (Instrumento) object;
        if ((this.idInstrumento == null && other.idInstrumento != null) || (this.idInstrumento != null && !this.idInstrumento.equals(other.idInstrumento))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "entidades.Instrumento[ idInstrumento=" + idInstrumento + " ]";
//    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instrumento{");
        sb.append("idInstrumento=").append(idInstrumento);
        sb.append(", nombre=").append(nombre);
        sb.append(", tipo=").append(tipo);
        try {
              sb.append(", idMusico=");
            sb.append(idMusico);

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

    public String toString2() {
        return idInstrumento + ";" + nombre + ";" + tipo + ";" + idMusico + ";" + grabacionList;
    }

    private String toStringGrabaciones() {
        StringBuilder tmp = new StringBuilder();
        for (Grabacion gra : grabacionList) {

            tmp.append("id:").append(gra.getIdGrabacion()).append(", ");
        }

        return tmp.length() == 0 ? tmp.toString() : tmp.toString() + "\b\b";
    }

}
