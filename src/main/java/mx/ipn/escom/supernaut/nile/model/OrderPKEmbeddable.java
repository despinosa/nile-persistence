/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package mx.ipn.escom.supernaut.nile.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author supernaut
 */
@Embeddable
public class OrderPKEmbeddable extends OrderPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  private int customer;
  @Basic(optional = false)
  @NotNull
  @Column(name = "order_id")
  private short orderId;

  public OrderPKEmbeddable() {}

  public OrderPKEmbeddable(int customer, short orderId) {
    this.customer = customer;
    this.orderId = orderId;
  }

  @Override
  public int getCustomer() {
    return customer;
  }

  @Override
  public void setCustomer(int customer) {
    this.customer = customer;
  }

  @Override
  public short getOrderId() {
    return orderId;
  }

  @Override
  public void setOrderId(short orderId) {
    this.orderId = orderId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) customer;
    hash += (int) orderId;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof OrderPKEmbeddable)) {
      return false;
    }
    OrderPKEmbeddable other = (OrderPKEmbeddable) object;
    if (this.customer != other.customer) {
      return false;
    }
    if (this.orderId != other.orderId) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.OrderPKEmbeddable[ customer="
        + customer + ", orderId=" + orderId + " ]";
  }

}
