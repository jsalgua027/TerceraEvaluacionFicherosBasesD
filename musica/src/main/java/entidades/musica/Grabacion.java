/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.musica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nacho
 */
@Entity
@Table(name = "Grabacion")
@NamedQueries({
    @NamedQuery(name = "Grabacion.findAll", query = "SELECT g FROM Grabacion g"),
    @NamedQuery(name = "Grabacion.findByIdGrabacion", query = "SELECT g FROM Grabacion g WHERE g.idGrabacion = :idGrabacion"),
    @NamedQuery(name = "Grabacion.findByTitulo", query = "SELECT g FROM Grabacion g WHERE g.titulo = :titulo"),
    @NamedQuery(name = "Grabacion.findByFecha", query = "SELECT g FROM Grabacion g WHERE g.fecha = :fecha")})
public class Grabacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idGrabacion")
    private Integer idGrabacion;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idInstrumento", referencedColumnName = "idInstrumento")
    @OneToMany
    private List<Instrumento> listaInstrumentos;

    public Grabacion() {
    }

    public Grabacion(Integer idGrabacion) {
        this.idGrabacion = idGrabacion;
    }

    public Integer getIdGrabacion() {
        return idGrabacion;
    }

    public void setIdGrabacion(Integer idGrabacion) {
        this.idGrabacion = idGrabacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Instrumento> getListaInstrumentos() {
        return listaInstrumentos;
    }

    public void setListaInstrumentos(List<Instrumento> listaInstrumentos) {
        this.listaInstrumentos = listaInstrumentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrabacion != null ? idGrabacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grabacion)) {
            return false;
        }
        Grabacion other = (Grabacion) object;
        if ((this.idGrabacion == null && other.idGrabacion != null) || (this.idGrabacion != null && !this.idGrabacion.equals(other.idGrabacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Grabacion{");
        sb.append("idGrabacion=").append(idGrabacion);
        sb.append(", titulo=").append(titulo);
        sb.append(", fecha=").append(fecha);
        sb.append(", idInstrumento=");
        sb.append(listaInstrumentos.toString());
     //   sb.append(toStringInstrumentos());
        sb.append('}');
        return sb.toString();
    }

   private String toStringInstrumentos(){
      StringBuilder tmp = new StringBuilder();
       for (Instrumento instru : listaInstrumentos) {
           tmp.append(instru.getIdInstrumento()).append(", ");
       }
     return tmp.length()==0?tmp.toString():tmp.toString()+"\b\b";
   }

  
}
