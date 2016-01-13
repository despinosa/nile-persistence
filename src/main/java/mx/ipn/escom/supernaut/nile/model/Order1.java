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
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByCustomer", query = "SELECT o FROM Order1 o WHERE o.order1PK.customer = :customer"),
    @NamedQuery(name = "Order1.findByOrderId", query = "SELECT o FROM Order1 o WHERE o.order1PK.orderId = :orderId"),
    @NamedQuery(name = "Order1.findByStatus", query = "SELECT o FROM Order1 o WHERE o.status = :status"),
    @NamedQuery(name = "Order1.findByOpenedOn", query = "SELECT o FROM Order1 o WHERE o.openedOn = :openedOn"),
    @NamedQuery(name = "Order1.findByClosedOn", query = "SELECT o FROM Order1 o WHERE o.closedOn = :closedOn"),
    @NamedQuery(name = "Order1.findByUniqueProducts", query = "SELECT o FROM Order1 o WHERE o.uniqueProducts = :uniqueProducts"),
    @NamedQuery(name = "Order1.findByTotal", query = "SELECT o FROM Order1 o WHERE o.total = :total")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Order1PK order1PK;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal total;
    @JoinColumn(name = "customer", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order1")
    private Collection<OrderDetail> orderDetailCollection;

    public Order1() {
    }

    public Order1(Order1PK order1PK) {
        this.order1PK = order1PK;
    }

    public Order1(Order1PK order1PK, String status, Date openedOn) {
        this.order1PK = order1PK;
        this.status = status;
        this.openedOn = openedOn;
    }

    public Order1(int customer, short orderId) {
        this.order1PK = new Order1PK(customer, orderId);
    }

    public Order1PK getOrder1PK() {
        return order1PK;
    }

    public void setOrder1PK(Order1PK order1PK) {
        this.order1PK = order1PK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOpenedOn() {
        return openedOn;
    }

    public void setOpenedOn(Date openedOn) {
        this.openedOn = openedOn;
    }

    public Date getClosedOn() {
        return closedOn;
    }

    public void setClosedOn(Date closedOn) {
        this.closedOn = closedOn;
    }

    public Short getUniqueProducts() {
        return uniqueProducts;
    }

    public void setUniqueProducts(Short uniqueProducts) {
        this.uniqueProducts = uniqueProducts;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Customer getCustomer1() {
        return customer1;
    }

    public void setCustomer1(Customer customer1) {
        this.customer1 = customer1;
    }

    @XmlTransient
    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (order1PK != null ? order1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.order1PK == null && other.order1PK != null) || (this.order1PK != null && !this.order1PK.equals(other.order1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.ipn.escom.supernaut.nile.model.Order1[ order1PK=" + order1PK + " ]";
    }

}
