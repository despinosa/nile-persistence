/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package mx.ipn.escom.supernaut.nile.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author supernaut
 */
@Entity
@Table(name = "Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductEntity.findAll",
        query = "SELECT p FROM ProductEntity p"),
    @NamedQuery(name = "ProductEntity.findBySku",
        query = "SELECT p FROM ProductEntity p WHERE p.sku = :sku"),
    @NamedQuery(name = "ProductEntity.findByName",
        query = "SELECT p FROM ProductEntity p WHERE p.name = :name"),
    @NamedQuery(name = "ProductEntity.findByPrice",
        query = "SELECT p FROM ProductEntity p WHERE p.price = :price"),
    @NamedQuery(name = "ProductEntity.findByStock",
        query = "SELECT p FROM ProductEntity p WHERE p.stock = :stock"),
    @NamedQuery(name = "ProductEntity.findByAddedOn",
        query = "SELECT p FROM ProductEntity p WHERE p.addedOn = :addedOn"),
    @NamedQuery(
        name = "ProductEntity.findByDescription",
        query = "SELECT p FROM ProductEntity p WHERE p.description = :description")})
public class ProductEntity extends Product implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  private Integer sku;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  private String name;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  private BigDecimal price;
  @Basic(optional = false)
  @NotNull
  private int stock;
  @Basic(optional = false)
  @NotNull
  @Column(name = "added_on")
  @Temporal(TemporalType.TIMESTAMP)
  private Date addedOn;
  @Size(max = 250)
  private String description;
  @Lob
  private byte[] image;
  @ManyToMany(mappedBy = "productCollection")
  private Collection<CategoryEntity> categoryCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "product1")
  private Collection<OrderDetailEntity> orderDetailCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "product1")
  private Collection<ProductDetailEntity> productDetailCollection;

  public ProductEntity() {}

  public ProductEntity(Integer sku) {
    this.sku = sku;
  }

  public ProductEntity(Integer sku, String name, BigDecimal price, int stock,
      Date addedOn) {
    this.sku = sku;
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.addedOn = addedOn;
  }

  @Override
  public Integer getSku() {
    return sku;
  }

  @Override
  public void setSku(Integer sku) {
    this.sku = sku;
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
  public BigDecimal getPrice() {
    return price;
  }

  @Override
  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public int getStock() {
    return stock;
  }

  @Override
  public void setStock(int stock) {
    this.stock = stock;
  }

  @Override
  public Date getAddedOn() {
    return addedOn;
  }

  @Override
  public void setAddedOn(Date addedOn) {
    this.addedOn = addedOn;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public byte[] getImage() {
    return image;
  }

  @Override
  public void setImage(byte[] image) {
    this.image = image;
  }

  @XmlTransient
  @Override
  public Collection<CategoryEntity> getCategoryCollection() {
    return categoryCollection;
  }

  public void setCategoryCollection(
      Collection<CategoryEntity> categoryCollection) {
    this.categoryCollection = categoryCollection;
  }

  @XmlTransient
  @Override
  public Collection<OrderDetailEntity> getOrderDetailCollection() {
    return orderDetailCollection;
  }

  public void setOrderDetailCollection(
      Collection<OrderDetailEntity> orderDetailCollection) {
    this.orderDetailCollection = orderDetailCollection;
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
  public int hashCode() {
    int hash = 0;
    hash += (sku != null ? sku.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ProductEntity)) {
      return false;
    }
    ProductEntity other = (ProductEntity) object;
    if ((this.sku == null && other.sku != null)
        || (this.sku != null && !this.sku.equals(other.sku))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.ProductEntity[ sku=" + sku + " ]";
  }

}
