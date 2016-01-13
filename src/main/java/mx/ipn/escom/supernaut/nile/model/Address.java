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
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(
        name = "Address.findByCustomer",
        query = "SELECT a FROM Address a WHERE a.addressPK.customer = :customer"),
    @NamedQuery(name = "Address.findByType",
        query = "SELECT a FROM Address a WHERE a.addressPK.type = :type"),
    @NamedQuery(name = "Address.findByState",
        query = "SELECT a FROM Address a WHERE a.state = :state"),
    @NamedQuery(name = "Address.findByLine1",
        query = "SELECT a FROM Address a WHERE a.line1 = :line1"),
    @NamedQuery(name = "Address.findByLine2",
        query = "SELECT a FROM Address a WHERE a.line2 = :line2"),
    @NamedQuery(name = "Address.findByPostcode",
        query = "SELECT a FROM Address a WHERE a.postcode = :postcode")})
public class Address implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AddressPK addressPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 19)
  private String state;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  private String line1;
  @Size(max = 100)
  private String line2;
  private Integer postcode;
  @JoinColumn(name = "customer", referencedColumnName = "customer_id",
      insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Customer customer1;

  public Address() {}

  public Address(AddressPK addressPK) {
    this.addressPK = addressPK;
  }

  public Address(AddressPK addressPK, String state, String line1) {
    this.addressPK = addressPK;
    this.state = state;
    this.line1 = line1;
  }

  public Address(int customer, String type) {
    this.addressPK = new AddressPK(customer, type);
  }

  public AddressPK getAddressPK() {
    return addressPK;
  }

  public void setAddressPK(AddressPK addressPK) {
    this.addressPK = addressPK;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getLine1() {
    return line1;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public String getLine2() {
    return line2;
  }

  public void setLine2(String line2) {
    this.line2 = line2;
  }

  public Integer getPostcode() {
    return postcode;
  }

  public void setPostcode(Integer postcode) {
    this.postcode = postcode;
  }

  public Customer getCustomer1() {
    return customer1;
  }

  public void setCustomer1(Customer customer1) {
    this.customer1 = customer1;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (addressPK != null ? addressPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Address)) {
      return false;
    }
    Address other = (Address) object;
    if ((this.addressPK == null && other.addressPK != null)
        || (this.addressPK != null && !this.addressPK.equals(other.addressPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.Address[ addressPK=" + addressPK
        + " ]";
  }

}
