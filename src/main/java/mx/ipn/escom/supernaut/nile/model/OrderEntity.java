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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderEntity.findAll",
        query = "SELECT o FROM OrderEntity o"),
    @NamedQuery(
        name = "OrderEntity.findByCustomer",
        query = "SELECT o FROM OrderEntity o WHERE o.orderPK.customer = :customer"),
    @NamedQuery(
        name = "OrderEntity.findByOrderId",
        query = "SELECT o FROM OrderEntity o WHERE o.orderPK.orderId = :orderId"),
    @NamedQuery(name = "OrderEntity.findByStatus",
        query = "SELECT o FROM OrderEntity o WHERE o.status = :status"),
    @NamedQuery(name = "OrderEntity.findByOpenedOn",
        query = "SELECT o FROM OrderEntity o WHERE o.openedOn = :openedOn"),
    @NamedQuery(name = "OrderEntity.findByClosedOn",
        query = "SELECT o FROM OrderEntity o WHERE o.closedOn = :closedOn"),
    @NamedQuery(
        name = "OrderEntity.findByUniqueProducts",
        query = "SELECT o FROM OrderEntity o WHERE o.uniqueProducts = :uniqueProducts"),
    @NamedQuery(name = "OrderEntity.findByTotal",
        query = "SELECT o FROM OrderEntity o WHERE o.total = :total")})
public class OrderEntity extends Order implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected OrderPKEmbeddable orderPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  private String status;
  @Basic(optional = false)
  @NotNull
  @Column(name = "opened_on")
  @Temporal(TemporalType.TIMESTAMP)
  private Date openedOn;
  @Column(name = "closed_on")
  @Temporal(TemporalType.TIMESTAMP)
  private Date closedOn;
  @Column(name = "unique_products")
  private Short uniqueProducts;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  private BigDecimal total;
  @JoinColumn(name = "customer", referencedColumnName = "customer_id",
      insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private CustomerEntity customer1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
  private Collection<OrderDetailEntity> orderDetailCollection;

  public OrderEntity() {}

  public OrderEntity(OrderPKEmbeddable orderPK) {
    this.orderPK = orderPK;
  }

  public OrderEntity(OrderPKEmbeddable orderPK, String status, Date openedOn) {
    this.orderPK = orderPK;
    this.status = status;
    this.openedOn = openedOn;
  }

  public OrderEntity(int customer, short orderId) {
    this.orderPK = new OrderPKEmbeddable(customer, orderId);
  }

  @Override
  public OrderPKEmbeddable getOrderPK() {
    return orderPK;
  }

  public void setOrderPK(OrderPKEmbeddable orderPK) {
    this.orderPK = orderPK;
  }

  @Override
  public String getStatus() {
    return status;
  }

  @Override
  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public Date getOpenedOn() {
    return openedOn;
  }

  @Override
  public void setOpenedOn(Date openedOn) {
    this.openedOn = openedOn;
  }

  @Override
  public Date getClosedOn() {
    return closedOn;
  }

  @Override
  public void setClosedOn(Date closedOn) {
    this.closedOn = closedOn;
  }

  @Override
  public Short getUniqueProducts() {
    return uniqueProducts;
  }

  @Override
  public void setUniqueProducts(Short uniqueProducts) {
    this.uniqueProducts = uniqueProducts;
  }

  @Override
  public BigDecimal getTotal() {
    return total;
  }

  @Override
  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  @Override
  public CustomerEntity getCustomer1() {
    return customer1;
  }

  public void setCustomer1(CustomerEntity customer1) {
    this.customer1 = customer1;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (orderPK != null ? orderPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof OrderEntity)) {
      return false;
    }
    OrderEntity other = (OrderEntity) object;
    if ((this.orderPK == null && other.orderPK != null)
        || (this.orderPK != null && !this.orderPK.equals(other.orderPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.OrderEntity[ orderPK=" + orderPK
        + " ]";
  }

}
