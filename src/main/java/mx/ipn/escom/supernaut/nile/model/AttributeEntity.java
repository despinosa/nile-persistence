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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "AttributeEntity.findAll",
        query = "SELECT a FROM AttributeEntity a"),
    @NamedQuery(
        name = "AttributeEntity.findByAttributeId",
        query = "SELECT a FROM AttributeEntity a WHERE a.attributeId = :attributeId"),
    @NamedQuery(name = "AttributeEntity.findByName",
        query = "SELECT a FROM AttributeEntity a WHERE a.name = :name"),
    @NamedQuery(
        name = "AttributeEntity.findByDescription",
        query = "SELECT a FROM AttributeEntity a WHERE a.description = :description")})
public class AttributeEntity implements Serializable, Attribute {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "attribute_id")
  private Integer attributeId;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  private String name;
  @Size(max = 250)
  private String description;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "attribute1")
  private Collection<ProductDetailEntity> productDetailCollection;
  @JoinColumn(name = "magni", referencedColumnName = "magni_id")
  @ManyToOne
  private MagnitudeEntity magni;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "attribute1")
  private Collection<CategoryDetailEntity> categoryDetailCollection;

  public AttributeEntity() {}

  public AttributeEntity(Integer attributeId) {
    this.attributeId = attributeId;
  }

  public AttributeEntity(Integer attributeId, String name) {
    this.attributeId = attributeId;
    this.name = name;
  }

  @Override
  public Integer getAttributeId() {
    return attributeId;
  }

  public void setAttributeId(Integer attributeId) {
    this.attributeId = attributeId;
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
  public Collection<ProductDetailEntity> getProductDetailCollection() {
    return productDetailCollection;
  }

  public void setProductDetailCollection(
      Collection<ProductDetailEntity> productDetailCollection) {
    this.productDetailCollection = productDetailCollection;
  }

  @Override
  public MagnitudeEntity getMagni() {
    return magni;
  }

  @Override
  public void setMagni(Magnitude magni) {
    this.magni = (MagnitudeEntity) magni;
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
  public int hashCode() {
    int hash = 0;
    hash += (attributeId != null ? attributeId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AttributeEntity)) {
      return false;
    }
    AttributeEntity other = (AttributeEntity) object;
    if ((this.attributeId == null && other.attributeId != null)
        || (this.attributeId != null && !this.attributeId
            .equals(other.attributeId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.AttributeEntity[ attributeId="
        + attributeId + " ]";
  }

}
