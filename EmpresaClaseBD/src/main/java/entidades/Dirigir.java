/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nacho
 */
@Entity
@Table(name = "dirigir")
@NamedQueries({
    @NamedQuery(name = "Dirigir.findAll", query = "SELECT d FROM Dirigir d"),
    @NamedQuery(name = "Dirigir.findByNumdepto", query = "SELECT d FROM Dirigir d WHERE d.dirigirPK.numdepto = :numdepto"),
    @NamedQuery(name = "Dirigir.findByNumempdirec", query = "SELECT d FROM Dirigir d WHERE d.dirigirPK.numempdirec = :numempdirec"),
    @NamedQuery(name = "Dirigir.findByFecinidir", query = "SELECT d FROM Dirigir d WHERE d.dirigirPK.fecinidir = :fecinidir"),
    @NamedQuery(name = "Dirigir.findByFecfindir", query = "SELECT d FROM Dirigir d WHERE d.fecfindir = :fecfindir"),
    @NamedQuery(name = "Dirigir.findByTipodir", query = "SELECT d FROM Dirigir d WHERE d.tipodir = :tipodir")})
public class Dirigir implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DirigirPK dirigirPK;
    @Column(name = "fecfindir")
    @Temporal(TemporalType.DATE)
    private Date fecfindir;
    @Basic(optional = false)
    @Column(name = "tipodir")
    private Character tipodir;
    @JoinColumn(name = "numdepto", referencedColumnName = "numde", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departamentos departamentos;
    @JoinColumn(name = "numempdirec", referencedColumnName = "numem", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleados empleados;

    public Dirigir() {
    }

    public Dirigir(DirigirPK dirigirPK) {
        this.dirigirPK = dirigirPK;
    }

    public Dirigir(DirigirPK dirigirPK, Character tipodir) {
        this.dirigirPK = dirigirPK;
        this.tipodir = tipodir;
    }

    public Dirigir(int numdepto, int numempdirec, Date fecinidir) {
        this.dirigirPK = new DirigirPK(numdepto, numempdirec, fecinidir);
    }

    public DirigirPK getDirigirPK() {
        return dirigirPK;
    }

    public void setDirigirPK(DirigirPK dirigirPK) {
        this.dirigirPK = dirigirPK;
    }

    public Date getFecfindir() {
        return fecfindir;
    }

    public void setFecfindir(Date fecfindir) {
        this.fecfindir = fecfindir;
    }

    public Character getTipodir() {
        return tipodir;
    }

    public void setTipodir(Character tipodir) {
        this.tipodir = tipodir;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dirigirPK != null ? dirigirPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dirigir)) {
            return false;
        }
        Dirigir other = (Dirigir) object;
        if ((this.dirigirPK == null && other.dirigirPK != null) || (this.dirigirPK != null && !this.dirigirPK.equals(other.dirigirPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Dirigir[ dirigirPK=" + dirigirPK + " ]";
    }
    
}
