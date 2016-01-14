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
    @NamedQuery(name = "MagnitudeEntity.findAll",
        query = "SELECT m FROM MagnitudeEntity m"),
    @NamedQuery(name = "MagnitudeEntity.findByMagniId",
        query = "SELECT m FROM MagnitudeEntity m WHERE m.magniId = :magniId"),
    @NamedQuery(name = "MagnitudeEntity.findByName",
        query = "SELECT m FROM MagnitudeEntity m WHERE m.name = :name"),
    @NamedQuery(
        name = "MagnitudeEntity.findByDescription",
        query = "SELECT m FROM MagnitudeEntity m WHERE m.description = :description")})
public class MagnitudeEntity implements Serializable, Magnitude {

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
  private Collection<AttributeEntity> attributeCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "magnitude")
  private Collection<UnitEntity> unitCollection;

  public MagnitudeEntity() {}

  public MagnitudeEntity(Short magniId) {
    this.magniId = magniId;
  }

  public MagnitudeEntity(Short magniId, String name) {
    this.magniId = magniId;
    this.name = name;
  }

  @Override
  public Short getMagniId() {
    return magniId;
  }

  public void setMagniId(Short magniId) {
    this.magniId = magniId;
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
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @XmlTransient
  @Override
  public Collection<AttributeEntity> getAttributeCollection() {
    return attributeCollection;
  }

  public void setAttributeCollection(
      Collection<AttributeEntity> attributeCollection) {
    this.attributeCollection = attributeCollection;
  }

  @XmlTransient
  @Override
  public Collection<UnitEntity> getUnitCollection() {
    return unitCollection;
  }

  public void setUnitCollection(Collection<UnitEntity> unitCollection) {
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
    if (!(object instanceof MagnitudeEntity)) {
      return false;
    }
    MagnitudeEntity other = (MagnitudeEntity) object;
    if ((this.magniId == null && other.magniId != null)
        || (this.magniId != null && !this.magniId.equals(other.magniId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.MagnitudeEntity[ magniId="
        + magniId + " ]";
  }

}
