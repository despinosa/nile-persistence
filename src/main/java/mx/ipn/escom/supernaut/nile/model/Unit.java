/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package mx.ipn.escom.supernaut.nile.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u"),
    @NamedQuery(name = "Unit.findByMagni", query = "SELECT u FROM Unit u WHERE u.unitPK.magni = :magni"),
    @NamedQuery(name = "Unit.findByUnitId", query = "SELECT u FROM Unit u WHERE u.unitPK.unitId = :unitId"),
    @NamedQuery(name = "Unit.findByName", query = "SELECT u FROM Unit u WHERE u.name = :name"),
    @NamedQuery(name = "Unit.findByAbbreviation", query = "SELECT u FROM Unit u WHERE u.abbreviation = :abbreviation"),
    @NamedQuery(name = "Unit.findByShownAsPrefix", query = "SELECT u FROM Unit u WHERE u.shownAsPrefix = :shownAsPrefix"),
    @NamedQuery(name = "Unit.findByDescription", query = "SELECT u FROM Unit u WHERE u.description = :description")})
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UnitPK unitPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String abbreviation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shown_as_prefix")
    private boolean shownAsPrefix;
    @Size(max = 250)
    private String description;
    @OneToMany(mappedBy = "unit")
    private Collection<CategoryDetail> categoryDetailCollection;
    @JoinColumn(name = "magni", referencedColumnName = "magni_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Magnitude magnitude;

    public Unit() {
    }

    public Unit(UnitPK unitPK) {
        this.unitPK = unitPK;
    }

    public Unit(UnitPK unitPK, String name, String abbreviation, boolean shownAsPrefix) {
        this.unitPK = unitPK;
        this.name = name;
        this.abbreviation = abbreviation;
        this.shownAsPrefix = shownAsPrefix;
    }

    public Unit(short magni, short unitId) {
        this.unitPK = new UnitPK(magni, unitId);
    }

    public UnitPK getUnitPK() {
        return unitPK;
    }

    public void setUnitPK(UnitPK unitPK) {
        this.unitPK = unitPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public boolean getShownAsPrefix() {
        return shownAsPrefix;
    }

    public void setShownAsPrefix(boolean shownAsPrefix) {
        this.shownAsPrefix = shownAsPrefix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<CategoryDetail> getCategoryDetailCollection() {
        return categoryDetailCollection;
    }

    public void setCategoryDetailCollection(Collection<CategoryDetail> categoryDetailCollection) {
        this.categoryDetailCollection = categoryDetailCollection;
    }

    public Magnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unitPK != null ? unitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        if ((this.unitPK == null && other.unitPK != null) || (this.unitPK != null && !this.unitPK.equals(other.unitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.ipn.escom.supernaut.nile.model.Unit[ unitPK=" + unitPK + " ]";
    }

}
