/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package mx.ipn.escom.supernaut.nile.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author supernaut
 */
@Embeddable
public class AddressPKEmbeddable extends AddressPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  private int customer;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 11)
  private String type;

  public AddressPKEmbeddable() {}

  public AddressPKEmbeddable(int customer, String type) {
    this.customer = customer;
    this.type = type;
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
  public String getType() {
    return type;
  }

  @Override
  public void setType(String type) {
    this.type = type;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) customer;
    hash += (type != null ? type.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AddressPKEmbeddable)) {
      return false;
    }
    AddressPKEmbeddable other = (AddressPKEmbeddable) object;
    if (this.customer != other.customer) {
      return false;
    }
    if ((this.type == null && other.type != null)
        || (this.type != null && !this.type.equals(other.type))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.AddressPKEmbeddable[ customer="
        + customer + ", type=" + type + " ]";
  }

}
