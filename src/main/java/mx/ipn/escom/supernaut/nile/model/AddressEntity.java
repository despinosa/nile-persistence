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
    @NamedQuery(name = "AddressEntity.findAll",
        query = "SELECT a FROM AddressEntity a"),
    @NamedQuery(
        name = "AddressEntity.findByCustomer",
        query = "SELECT a FROM AddressEntity a WHERE a.addressPK.customer = :customer"),
    @NamedQuery(name = "AddressEntity.findByType",
        query = "SELECT a FROM AddressEntity a WHERE a.addressPK.type = :type"),
    @NamedQuery(name = "AddressEntity.findByState",
        query = "SELECT a FROM AddressEntity a WHERE a.state = :state"),
    @NamedQuery(name = "AddressEntity.findByLine1",
        query = "SELECT a FROM AddressEntity a WHERE a.line1 = :line1"),
    @NamedQuery(name = "AddressEntity.findByLine2",
        query = "SELECT a FROM AddressEntity a WHERE a.line2 = :line2"),
    @NamedQuery(name = "AddressEntity.findByPostcode",
        query = "SELECT a FROM AddressEntity a WHERE a.postcode = :postcode")})
public class AddressEntity extends Address implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AddressPKEmbeddable addressPK;
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
  private CustomerEntity customer1;

  public AddressEntity() {}

  public AddressEntity(AddressPKEmbeddable addressPK) {
    this.addressPK = addressPK;
  }

  public AddressEntity(AddressPKEmbeddable addressPK, String state, String line1) {
    this.addressPK = addressPK;
    this.state = state;
    this.line1 = line1;
  }

  public AddressEntity(int customer, String type) {
    this.addressPK = new AddressPKEmbeddable(customer, type);
  }

  @Override
  public AddressPKEmbeddable getAddressPK() {
    return addressPK;
  }

  public void setAddressPK(AddressPKEmbeddable addressPK) {
    this.addressPK = addressPK;
  }

  @Override
  public String getState() {
    return state;
  }

  @Override
  public void setState(String state) {
    this.state = state;
  }

  @Override
  public String getLine1() {
    return line1;
  }

  @Override
  public void setLine1(String line1) {
    this.line1 = line1;
  }

  @Override
  public String getLine2() {
    return line2;
  }

  @Override
  public void setLine2(String line2) {
    this.line2 = line2;
  }

  @Override
  public Integer getPostcode() {
    return postcode;
  }

  @Override
  public void setPostcode(Integer postcode) {
    this.postcode = postcode;
  }

  @Override
  public CustomerEntity getCustomer1() {
    return customer1;
  }

  public void setCustomer1(CustomerEntity customer1) {
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
    if (!(object instanceof AddressEntity)) {
      return false;
    }
    AddressEntity other = (AddressEntity) object;
    if ((this.addressPK == null && other.addressPK != null)
        || (this.addressPK != null && !this.addressPK.equals(other.addressPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.AddressEntity[ addressPK="
        + addressPK + " ]";
  }

}
