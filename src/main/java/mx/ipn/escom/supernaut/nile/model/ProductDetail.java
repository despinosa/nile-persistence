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
    @NamedQuery(name = "ProductDetail.findAll", query = "SELECT p FROM ProductDetail p"),
    @NamedQuery(name = "ProductDetail.findByProduct", query = "SELECT p FROM ProductDetail p WHERE p.productDetailPK.product = :product"),
    @NamedQuery(name = "ProductDetail.findByAttribute", query = "SELECT p FROM ProductDetail p WHERE p.productDetailPK.attribute = :attribute"),
    @NamedQuery(name = "ProductDetail.findByValue", query = "SELECT p FROM ProductDetail p WHERE p.value = :value")})
public class ProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductDetailPK productDetailPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String value;
    @JoinColumn(name = "attribute", referencedColumnName = "attribute_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Attribute attribute1;
    @JoinColumn(name = "product", referencedColumnName = "sku", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product1;

    public ProductDetail() {
    }

    public ProductDetail(ProductDetailPK productDetailPK) {
        this.productDetailPK = productDetailPK;
    }

    public ProductDetail(ProductDetailPK productDetailPK, String value) {
        this.productDetailPK = productDetailPK;
        this.value = value;
    }

    public ProductDetail(int product, int attribute) {
        this.productDetailPK = new ProductDetailPK(product, attribute);
    }

    public ProductDetailPK getProductDetailPK() {
        return productDetailPK;
    }

    public void setProductDetailPK(ProductDetailPK productDetailPK) {
        this.productDetailPK = productDetailPK;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Attribute getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(Attribute attribute1) {
        this.attribute1 = attribute1;
    }

    public Product getProduct1() {
        return product1;
    }

    public void setProduct1(Product product1) {
        this.product1 = product1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productDetailPK != null ? productDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDetail)) {
            return false;
        }
        ProductDetail other = (ProductDetail) object;
        if ((this.productDetailPK == null && other.productDetailPK != null) || (this.productDetailPK != null && !this.productDetailPK.equals(other.productDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.ipn.escom.supernaut.nile.model.ProductDetail[ productDetailPK=" + productDetailPK + " ]";
    }

}
