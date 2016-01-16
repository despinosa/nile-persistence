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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author supernaut
 */
@Entity
@Table(name = "OrderDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetailEntity.findAll",
        query = "SELECT o FROM OrderDetailEntity o"),
    @NamedQuery(
        name = "OrderDetailEntity.findByCustomer",
        query = "SELECT o FROM OrderDetailEntity o WHERE o.orderDetailPK.customer = :customer"),
    @NamedQuery(
        name = "OrderDetailEntity.findByOrder",
        query = "SELECT o FROM OrderDetailEntity o WHERE o.orderDetailPK.order = :order"),
    @NamedQuery(
        name = "OrderDetailEntity.findByProduct",
        query = "SELECT o FROM OrderDetailEntity o WHERE o.orderDetailPK.product = :product"),
    @NamedQuery(
        name = "OrderDetailEntity.findByQuantity",
        query = "SELECT o FROM OrderDetailEntity o WHERE o.quantity = :quantity")})
public class OrderDetailEntity extends OrderDetail implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected OrderDetailPKEmbeddable orderDetailPK;
  @Basic(optional = false)
  @NotNull
  private short quantity;
  @JoinColumn(name = "product", referencedColumnName = "sku",
      insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private ProductEntity product1;
  @JoinColumns({
      @JoinColumn(name = "customer", referencedColumnName = "customer",
          insertable = false, updatable = false),
      @JoinColumn(name = "`order`", referencedColumnName = "order_id",
          insertable = false, updatable = false)})
  @ManyToOne(optional = false)
  private OrderEntity order1;

  public OrderDetailEntity() {}

  public OrderDetailEntity(OrderDetailPKEmbeddable orderDetailPK) {
    this.orderDetailPK = orderDetailPK;
  }

  public OrderDetailEntity(OrderDetailPKEmbeddable orderDetailPK, short quantity) {
    this.orderDetailPK = orderDetailPK;
    this.quantity = quantity;
  }

  public OrderDetailEntity(int customer, short order, int product) {
    this.orderDetailPK = new OrderDetailPKEmbeddable(customer, order, product);
  }

  @Override
  public OrderDetailPK getOrderDetailPK() {
    return (OrderDetailPK) orderDetailPK;
  }

  public void setOrderDetailPK(OrderDetailPKEmbeddable orderDetailPK) {
    this.orderDetailPK = orderDetailPK;
  }

  @Override
  public short getQuantity() {
    return quantity;
  }

  @Override
  public void setQuantity(short quantity) {
    this.quantity = quantity;
  }

  @Override
  public ProductEntity getProduct1() {
    return product1;
  }

  public void setProduct1(ProductEntity product1) {
    this.product1 = product1;
  }

  @Override
  public OrderEntity getOrder1() {
    return order1;
  }

  public void setOrder1(OrderEntity order1) {
    this.order1 = order1;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (orderDetailPK != null ? orderDetailPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof OrderDetailEntity)) {
      return false;
    }
    OrderDetailEntity other = (OrderDetailEntity) object;
    if ((this.orderDetailPK == null && other.orderDetailPK != null)
        || (this.orderDetailPK != null && !this.orderDetailPK
            .equals(other.orderDetailPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.OrderDetailEntity[ orderDetailPK="
        + orderDetailPK + " ]";
  }

}
