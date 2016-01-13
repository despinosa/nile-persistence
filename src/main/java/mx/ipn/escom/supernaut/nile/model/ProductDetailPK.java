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
public class ProductDetailPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    private int product;
    @Basic(optional = false)
    @NotNull
    private int attribute;

    public ProductDetailPK() {
    }

    public ProductDetailPK(int product, int attribute) {
        this.product = product;
        this.attribute = attribute;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) product;
        hash += (int) attribute;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDetailPK)) {
            return false;
        }
        ProductDetailPK other = (ProductDetailPK) object;
        if (this.product != other.product) {
            return false;
        }
        if (this.attribute != other.attribute) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.ipn.escom.supernaut.nile.model.ProductDetailPK[ product=" + product + ", attribute=" + attribute + " ]";
    }

}
