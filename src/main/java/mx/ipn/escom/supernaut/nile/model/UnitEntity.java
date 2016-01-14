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
    @NamedQuery(name = "UnitEntity.findAll",
        query = "SELECT u FROM UnitEntity u"),
    @NamedQuery(name = "UnitEntity.findByMagni",
        query = "SELECT u FROM UnitEntity u WHERE u.unitPK.magni = :magni"),
    @NamedQuery(name = "UnitEntity.findByUnitId",
        query = "SELECT u FROM UnitEntity u WHERE u.unitPK.unitId = :unitId"),
    @NamedQuery(name = "UnitEntity.findByName",
        query = "SELECT u FROM UnitEntity u WHERE u.name = :name"),
    @NamedQuery(
        name = "UnitEntity.findByAbbreviation",
        query = "SELECT u FROM UnitEntity u WHERE u.abbreviation = :abbreviation"),
    @NamedQuery(
        name = "UnitEntity.findByShownAsPrefix",
        query = "SELECT u FROM UnitEntity u WHERE u.shownAsPrefix = :shownAsPrefix"),
    @NamedQuery(name = "UnitEntity.findByDescription",
        query = "SELECT u FROM UnitEntity u WHERE u.description = :description")})
public class UnitEntity implements Serializable, Unit {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected UnitPKEmbeddable unitPK;
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
  private Collection<CategoryDetailEntity> categoryDetailCollection;
  @JoinColumn(name = "magni", referencedColumnName = "magni_id",
      insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private MagnitudeEntity magnitude;

  public UnitEntity() {}

  public UnitEntity(UnitPKEmbeddable unitPK) {
    this.unitPK = unitPK;
  }

  public UnitEntity(UnitPKEmbeddable unitPK, String name, String abbreviation,
      boolean shownAsPrefix) {
    this.unitPK = unitPK;
    this.name = name;
    this.abbreviation = abbreviation;
    this.shownAsPrefix = shownAsPrefix;
  }

  public UnitEntity(short magni, short unitId) {
    this.unitPK = new UnitPKEmbeddable(magni, unitId);
  }

  @Override
  public UnitPK getUnitPK() {
    return (UnitPK) unitPK;
  }

  public void setUnitPK(UnitPKEmbeddable unitPK) {
    this.unitPK = unitPK;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getAbbreviation() {
    return abbreviation;
  }

  @Override
  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  @Override
  public boolean getShownAsPrefix() {
    return shownAsPrefix;
  }

  @Override
  public void setShownAsPrefix(boolean shownAsPrefix) {
    this.shownAsPrefix = shownAsPrefix;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @XmlTransient
  @Override
  public Collection<CategoryDetailEntity> getCategoryDetailCollection() {
    return categoryDetailCollection;
  }

  public void setCategoryDetailCollection(
      Collection<CategoryDetailEntity> categoryDetailCollection) {
    this.categoryDetailCollection = categoryDetailCollection;
  }

  @Override
  public MagnitudeEntity getMagnitude() {
    return magnitude;
  }

  public void setMagnitude(MagnitudeEntity magnitude) {
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
    if (!(object instanceof UnitEntity)) {
      return false;
    }
    UnitEntity other = (UnitEntity) object;
    if ((this.unitPK == null && other.unitPK != null)
        || (this.unitPK != null && !this.unitPK.equals(other.unitPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.UnitEntity[ unitPK=" + unitPK
        + " ]";
  }

}
