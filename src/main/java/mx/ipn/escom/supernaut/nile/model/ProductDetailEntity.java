/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package mx.ipn.escom.supernaut.nile.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author supernaut
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductDetailEntity.findAll",
        query = "SELECT p FROM ProductDetailEntity p"),
    @NamedQuery(
        name = "ProductDetailEntity.findByProduct",
        query = "SELECT p FROM ProductDetailEntity p WHERE p.productDetailPK.product = :product"),
    @NamedQuery(
        name = "ProductDetailEntity.findByAttribute",
        query = "SELECT p FROM ProductDetailEntity p WHERE p.productDetailPK.attribute = :attribute"),
    @NamedQuery(name = "ProductDetailEntity.findByValue",
        query = "SELECT p FROM ProductDetailEntity p WHERE p.value = :value")})
public class ProductDetailEntity implements Serializable, ProductDetail {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ProductDetailPKEmbeddable productDetailPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  private String value;
  @JoinColumn(name = "attribute", referencedColumnName = "attribute_id",
      insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private AttributeEntity attribute1;
  @JoinColumn(name = "product", referencedColumnName = "sku",
      insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private ProductEntity product1;

  public ProductDetailEntity() {}

  public ProductDetailEntity(ProductDetailPKEmbeddable productDetailPK) {
    this.productDetailPK = productDetailPK;
  }

  public ProductDetailEntity(ProductDetailPKEmbeddable productDetailPK,
      String value) {
    this.productDetailPK = productDetailPK;
    this.value = value;
  }

  public ProductDetailEntity(int product, int attribute) {
    this.productDetailPK = new ProductDetailPKEmbeddable(product, attribute);
  }

  @Override
  public ProductDetailPK getProductDetailPK() {
    return (ProductDetailPK) productDetailPK;
  }

  public void setProductDetailPK(ProductDetailPKEmbeddable productDetailPK) {
    this.productDetailPK = productDetailPK;
  }

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public AttributeEntity getAttribute1() {
    return attribute1;
  }

  public void setAttribute1(AttributeEntity attribute1) {
    this.attribute1 = attribute1;
  }

  @Override
  public ProductEntity getProduct1() {
    return product1;
  }

  public void setProduct1(ProductEntity product1) {
    this.product1 = product1;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (productDetailPK != null ? productDetailPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ProductDetailEntity)) {
      return false;
    }
    ProductDetailEntity other = (ProductDetailEntity) object;
    if ((this.productDetailPK == null && other.productDetailPK != null)
        || (this.productDetailPK != null && !this.productDetailPK
            .equals(other.productDetailPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.ProductDetailEntity[ productDetailPK="
        + productDetailPK + " ]";
  }

}
