/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nacho
 */
@Entity
@Table(name = "Biografia")
@NamedQueries({
    @NamedQuery(name = "Biografia.findAll", query = "SELECT b FROM Biografia b"),
    @NamedQuery(name = "Biografia.findByIdBiografia", query = "SELECT b FROM Biografia b WHERE b.idBiografia = :idBiografia"),
    @NamedQuery(name = "Biografia.findByFechaNacimiento", query = "SELECT b FROM Biografia b WHERE b.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Biografia.findByLugarNacimiento", query = "SELECT b FROM Biografia b WHERE b.lugarNacimiento = :lugarNacimiento")})
public class Biografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBiografia")
    private Integer idBiografia;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "lugarNacimiento")
    private String lugarNacimiento;
    @JoinColumn(name = "idMusico", referencedColumnName = "idMusico")
    @OneToOne
    private Musico idMusico;

    public Biografia() {
    }

    public Biografia(Integer idBiografia) {
        this.idBiografia = idBiografia;
    }

    public Integer getIdBiografia() {
        return idBiografia;
    }

    public void setIdBiografia(Integer idBiografia) {
        this.idBiografia = idBiografia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    // Método añadido , no generadi por el IDE al crear la entidad
    public LocalDate getFechaNacimientoLocalDate() {

        return new Date(this.fechaNacimiento.getTime()).
                toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    }

    // metodo setter añadido, no generado por el Ide al crear la entidad
    public void setFechaNacimientoLocalDate(LocalDate fecha) {

        this.fechaNacimiento = Date.from(fecha.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
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
        hash += (idBiografia != null ? idBiografia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biografia)) {
            return false;
        }
        Biografia other = (Biografia) object;
        if ((this.idBiografia == null && other.idBiografia != null) || (this.idBiografia != null && !this.idBiografia.equals(other.idBiografia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Biografia{");
        sb.append("idBiografia=").append(idBiografia);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", fechaNacimiento=").append(getFechaNacimientoLocalDate());
        sb.append(", lugarNacimiento=").append(lugarNacimiento);
        sb.append(", idMusico=").append(idMusico);
        sb.append('}');
        return sb.toString();
    }

}
