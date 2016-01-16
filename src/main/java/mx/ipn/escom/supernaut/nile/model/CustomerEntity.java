/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package mx.ipn.escom.supernaut.nile.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "Customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerEntity.findAll",
        query = "SELECT c FROM CustomerEntity c"),
    @NamedQuery(
        name = "CustomerEntity.findByCustomerId",
        query = "SELECT c FROM CustomerEntity c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "CustomerEntity.findByUsername",
        query = "SELECT c FROM CustomerEntity c WHERE c.username = :username"),
    @NamedQuery(name = "CustomerEntity.findByFirstName",
        query = "SELECT c FROM CustomerEntity c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "CustomerEntity.findByLastName",
        query = "SELECT c FROM CustomerEntity c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "CustomerEntity.findByPwordHash",
        query = "SELECT c FROM CustomerEntity c WHERE c.pwordHash = :pwordHash"),
    @NamedQuery(name = "CustomerEntity.findByPwordSalt",
        query = "SELECT c FROM CustomerEntity c WHERE c.pwordSalt = :pwordSalt"),
    @NamedQuery(name = "CustomerEntity.findByAddedOn",
        query = "SELECT c FROM CustomerEntity c WHERE c.addedOn = :addedOn"),
    @NamedQuery(name = "CustomerEntity.findByLastLogin",
        query = "SELECT c FROM CustomerEntity c WHERE c.lastLogin = :lastLogin")})
public class CustomerEntity extends Customer implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "customer_id")
  private Integer customerId;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  private String username;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "first_name")
  private String firstName;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "last_name")
  private String lastName;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 8)
  @Column(name = "pword_hash")
  private String pwordHash;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "pword_salt")
  private String pwordSalt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "added_on")
  @Temporal(TemporalType.TIMESTAMP)
  private Date addedOn;
  @Basic(optional = false)
  @NotNull
  @Column(name = "last_login")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastLogin;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer1")
  private Collection<OrderEntity> orderCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer1")
  private Collection<AddressEntity> addressCollection;

  public CustomerEntity() {}

  public CustomerEntity(Integer customerId) {
    this.customerId = customerId;
  }

  public CustomerEntity(Integer customerId, String username, String firstName,
      String lastName, String pwordHash, String pwordSalt, Date addedOn,
      Date lastLogin) {
    this.customerId = customerId;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.pwordHash = pwordHash;
    this.pwordSalt = pwordSalt;
    this.addedOn = addedOn;
    this.lastLogin = lastLogin;
  }

  @Override
  public Integer getCustomerId() {
    return customerId;
  }

  @Override
  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  @Override
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  @Override
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String getPwordHash() {
    return pwordHash;
  }

  @Override
  public void setPwordHash(String pwordHash) {
    this.pwordHash = pwordHash;
  }

  @Override
  public String getPwordSalt() {
    return pwordSalt;
  }

  @Override
  public void setPwordSalt(String pwordSalt) {
    this.pwordSalt = pwordSalt;
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
  public Date getLastLogin() {
    return lastLogin;
  }

  @Override
  public void setLastLogin(Date lastLogin) {
    this.lastLogin = lastLogin;
  }

  @XmlTransient
  @Override
  public Collection<OrderEntity> getOrderCollection() {
    return orderCollection;
  }

  public void setOrderCollection(Collection<OrderEntity> orderCollection) {
    this.orderCollection = orderCollection;
  }

  @XmlTransient
  public Collection<AddressEntity> getAddressCollection() {
    return addressCollection;
  }

  public void setAddressCollection(Collection<AddressEntity> addressCollection) {
    this.addressCollection = addressCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (customerId != null ? customerId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CustomerEntity)) {
      return false;
    }
    CustomerEntity other = (CustomerEntity) object;
    if ((this.customerId == null && other.customerId != null)
        || (this.customerId != null && !this.customerId
            .equals(other.customerId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.CustomerEntity[ customerId="
        + customerId + " ]";
  }

}
