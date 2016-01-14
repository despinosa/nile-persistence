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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "CategoryEntity.findAll",
        query = "SELECT c FROM CategoryEntity c"),
    @NamedQuery(
        name = "CategoryEntity.findByCategoryId",
        query = "SELECT c FROM CategoryEntity c WHERE c.categoryId = :categoryId"),
    @NamedQuery(name = "CategoryEntity.findByName",
        query = "SELECT c FROM CategoryEntity c WHERE c.name = :name"),
    @NamedQuery(
        name = "CategoryEntity.findByDescription",
        query = "SELECT c FROM CategoryEntity c WHERE c.description = :description")})
public class CategoryEntity implements Serializable, Category {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "category_id")
  private Short categoryId;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  private String name;
  @Size(max = 250)
  private String description;
  @JoinTable(name = "ProductCategory", joinColumns = {@JoinColumn(
      name = "category", referencedColumnName = "category_id")},
      inverseJoinColumns = {@JoinColumn(name = "product",
          referencedColumnName = "sku")})
  @ManyToMany
  private Collection<ProductEntity> productCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "category1")
  private Collection<CategoryDetailEntity> categoryDetailCollection;

  public CategoryEntity() {}

  public CategoryEntity(Short categoryId) {
    this.categoryId = categoryId;
  }

  public CategoryEntity(Short categoryId, String name) {
    this.categoryId = categoryId;
    this.name = name;
  }

  @Override
  public Short getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Short categoryId) {
    this.categoryId = categoryId;
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
  public Collection<ProductEntity> getProductCollection() {
    return productCollection;
  }

  public void setProductCollection(Collection<ProductEntity> productCollection) {
    this.productCollection = productCollection;
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
    hash += (categoryId != null ? categoryId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CategoryEntity)) {
      return false;
    }
    CategoryEntity other = (CategoryEntity) object;
    if ((this.categoryId == null && other.categoryId != null)
        || (this.categoryId != null && !this.categoryId
            .equals(other.categoryId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.CategoryEntity[ categoryId="
        + categoryId + " ]";
  }

}
