/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package mx.ipn.escom.supernaut.nile.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author supernaut
 */
@Embeddable
public class CategoryDetailPKEmbeddable implements Serializable, CategoryDetailPK {

  @Basic(optional = false)
  @NotNull
  private short category;
  @Basic(optional = false)
  @NotNull
  private int attribute;

  public CategoryDetailPKEmbeddable() {}

  public CategoryDetailPKEmbeddable(short category, int attribute) {
    this.category = category;
    this.attribute = attribute;
  }

    @Override
  public short getCategory() {
    return category;
  }

  public void setCategory(short category) {
    this.category = category;
  }

    @Override
  public int getAttribute() {
    return attribute;
  }

  public void setAttribute(int attribute) {
    this.attribute = attribute;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) category;
    hash += (int) attribute;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CategoryDetailPKEmbeddable)) {
      return false;
    }
    CategoryDetailPKEmbeddable other = (CategoryDetailPKEmbeddable) object;
    if (this.category != other.category) {
      return false;
    }
    if (this.attribute != other.attribute) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.CategoryDetailPKEmbeddable[ category="
        + category + ", attribute=" + attribute + " ]";
  }

}
