/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package mx.ipn.escom.supernaut.nile.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author supernaut
 */
@Entity
@Table(name = "CategoryDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoryDetailEntity.findAll",
        query = "SELECT c FROM CategoryDetailEntity c"),
    @NamedQuery(
        name = "CategoryDetailEntity.findByCategory",
        query = "SELECT c FROM CategoryDetailEntity c WHERE c.categoryDetailPK.category = :category"),
    @NamedQuery(
        name = "CategoryDetailEntity.findByAttribute",
        query = "SELECT c FROM CategoryDetailEntity c WHERE c.categoryDetailPK.attribute = :attribute")})
public class CategoryDetailEntity extends CategoryDetail implements
    Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CategoryDetailPKEmbeddable categoryDetailPK;
  @JoinColumn(name = "attribute", referencedColumnName = "attribute_id",
      insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private AttributeEntity attribute1;
  @JoinColumn(name = "category", referencedColumnName = "category_id",
      insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private CategoryEntity category1;
  @JoinColumns({@JoinColumn(name = "magni", referencedColumnName = "magni"),
      @JoinColumn(name = "unit", referencedColumnName = "unit_id")})
  @ManyToOne
  private UnitEntity unit;

  public CategoryDetailEntity() {}

  public CategoryDetailEntity(CategoryDetailPKEmbeddable categoryDetailPK) {
    this.categoryDetailPK = (CategoryDetailPKEmbeddable) categoryDetailPK;
  }

  public CategoryDetailEntity(short category, int attribute) {
    this.categoryDetailPK = new CategoryDetailPKEmbeddable(category, attribute);
  }

  @Override
  public CategoryDetailPK getCategoryDetailPK() {
    return categoryDetailPK;
  }

  public void setCategoryDetailPK(CategoryDetailPKEmbeddable categoryDetailPK) {
    this.categoryDetailPK = categoryDetailPK;
  }

  @Override
  public AttributeEntity getAttribute1() {
    return attribute1;
  }

  public void setAttribute1(AttributeEntity attribute1) {
    this.attribute1 = attribute1;
  }

  @Override
  public CategoryEntity getCategory1() {
    return category1;
  }

  public void setCategory1(CategoryEntity category1) {
    this.category1 = category1;
  }

  @Override
  public UnitEntity getUnit() {
    return unit;
  }

  public void setUnit(UnitEntity unit) {
    this.unit = unit;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (categoryDetailPK != null ? categoryDetailPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CategoryDetailEntity)) {
      return false;
    }
    CategoryDetailEntity other = (CategoryDetailEntity) object;
    if ((this.categoryDetailPK == null && other.categoryDetailPK != null)
        || (this.categoryDetailPK != null && !this.categoryDetailPK
            .equals(other.categoryDetailPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.CategoryDetailEntity[ categoryDetailPK="
        + categoryDetailPK + " ]";
  }

}
