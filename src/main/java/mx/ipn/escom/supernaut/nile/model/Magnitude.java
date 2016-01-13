/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package mx.ipn.escom.supernaut.nile.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author supernaut
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Magnitude.findAll", query = "SELECT m FROM Magnitude m"),
    @NamedQuery(name = "Magnitude.findByMagniId", query = "SELECT m FROM Magnitude m WHERE m.magniId = :magniId"),
    @NamedQuery(name = "Magnitude.findByName", query = "SELECT m FROM Magnitude m WHERE m.name = :name"),
    @NamedQuery(name = "Magnitude.findByDescription", query = "SELECT m FROM Magnitude m WHERE m.description = :description")})
public class Magnitude implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "magni_id")
    private Short magniId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    @Size(max = 250)
    private String description;
    @OneToMany(mappedBy = "magni")
    private Collection<Attribute> attributeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magnitude")
    private Collection<Unit> unitCollection;

    public Magnitude() {
    }

    public Magnitude(Short magniId) {
        this.magniId = magniId;
    }

    public Magnitude(Short magniId, String name) {
        this.magniId = magniId;
        this.name = name;
    }

    public Short getMagniId() {
        return magniId;
    }

    public void setMagniId(Short magniId) {
        this.magniId = magniId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Attribute> getAttributeCollection() {
        return attributeCollection;
    }

    public void setAttributeCollection(Collection<Attribute> attributeCollection) {
        this.attributeCollection = attributeCollection;
    }

    @XmlTransient
    public Collection<Unit> getUnitCollection() {
        return unitCollection;
    }

    public void setUnitCollection(Collection<Unit> unitCollection) {
        this.unitCollection = unitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (magniId != null ? magniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Magnitude)) {
            return false;
        }
        Magnitude other = (Magnitude) object;
        if ((this.magniId == null && other.magniId != null) || (this.magniId != null && !this.magniId.equals(other.magniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.ipn.escom.supernaut.nile.model.Magnitude[ magniId=" + magniId + " ]";
    }

}
