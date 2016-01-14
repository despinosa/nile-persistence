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
public class ProductDetailPKEmbeddable extends ProductDetailPK implements
    Serializable {

  @Basic(optional = false)
  @NotNull
  private int product;
  @Basic(optional = false)
  @NotNull
  private int attribute;

  public ProductDetailPKEmbeddable() {}

  public ProductDetailPKEmbeddable(int product, int attribute) {
    this.product = product;
    this.attribute = attribute;
  }

  @Override
  public int getProduct() {
    return product;
  }

  @Override
  public void setProduct(int product) {
    this.product = product;
  }

  @Override
  public int getAttribute() {
    return attribute;
  }

  @Override
  public void setAttribute(int attribute) {
    this.attribute = attribute;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) product;
    hash += (int) attribute;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ProductDetailPKEmbeddable)) {
      return false;
    }
    ProductDetailPKEmbeddable other = (ProductDetailPKEmbeddable) object;
    if (this.product != other.product) {
      return false;
    }
    if (this.attribute != other.attribute) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.ProductDetailPKEmbeddable[ product="
        + product + ", attribute=" + attribute + " ]";
  }

}
