/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nacho
 */
@Embeddable
public class DirigirPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "numdepto")
    private int numdepto;
    @Basic(optional = false)
    @Column(name = "numempdirec")
    private int numempdirec;
    @Basic(optional = false)
    @Column(name = "fecinidir")
    @Temporal(TemporalType.DATE)
    private Date fecinidir;

    public DirigirPK() {
    }

    public DirigirPK(int numdepto, int numempdirec, Date fecinidir) {
        this.numdepto = numdepto;
        this.numempdirec = numempdirec;
        this.fecinidir = fecinidir;
    }

    public int getNumdepto() {
        return numdepto;
    }

    public void setNumdepto(int numdepto) {
        this.numdepto = numdepto;
    }

    public int getNumempdirec() {
        return numempdirec;
    }

    public void setNumempdirec(int numempdirec) {
        this.numempdirec = numempdirec;
    }

    public Date getFecinidir() {
        return fecinidir;
    }

    public void setFecinidir(Date fecinidir) {
        this.fecinidir = fecinidir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numdepto;
        hash += (int) numempdirec;
        hash += (fecinidir != null ? fecinidir.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DirigirPK)) {
            return false;
        }
        DirigirPK other = (DirigirPK) object;
        if (this.numdepto != other.numdepto) {
            return false;
        }
        if (this.numempdirec != other.numempdirec) {
            return false;
        }
        if ((this.fecinidir == null && other.fecinidir != null) || (this.fecinidir != null && !this.fecinidir.equals(other.fecinidir))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DirigirPK[ numdepto=" + numdepto + ", numempdirec=" + numempdirec + ", fecinidir=" + fecinidir + " ]";
    }
    
}
