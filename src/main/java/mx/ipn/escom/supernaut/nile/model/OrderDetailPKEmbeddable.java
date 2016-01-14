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
public class OrderDetailPKEmbeddable extends OrderDetailPK implements
    Serializable {

  @Basic(optional = false)
  @NotNull
  private int customer;
  @Basic(optional = false)
  @NotNull
  private short order;
  @Basic(optional = false)
  @NotNull
  private int product;

  public OrderDetailPKEmbeddable() {}

  public OrderDetailPKEmbeddable(int customer, short order, int product) {
    this.customer = customer;
    this.order = order;
    this.product = product;
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
  public short getOrder() {
    return order;
  }

  @Override
  public void setOrder(short order) {
    this.order = order;
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
  public int hashCode() {
    int hash = 0;
    hash += (int) customer;
    hash += (int) order;
    hash += (int) product;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof OrderDetailPKEmbeddable)) {
      return false;
    }
    OrderDetailPKEmbeddable other = (OrderDetailPKEmbeddable) object;
    if (this.customer != other.customer) {
      return false;
    }
    if (this.order != other.order) {
      return false;
    }
    if (this.product != other.product) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.OrderDetailPKEmbeddable[ customer="
        + customer + ", order=" + order + ", product=" + product + " ]";
  }

}
