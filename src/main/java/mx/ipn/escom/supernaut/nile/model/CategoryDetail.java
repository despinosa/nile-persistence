/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package mx.ipn.escom.supernaut.nile.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author supernaut
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoryDetail.findAll", query = "SELECT c FROM CategoryDetail c"),
    @NamedQuery(name = "CategoryDetail.findByCategory", query = "SELECT c FROM CategoryDetail c WHERE c.categoryDetailPK.category = :category"),
    @NamedQuery(name = "CategoryDetail.findByAttribute", query = "SELECT c FROM CategoryDetail c WHERE c.categoryDetailPK.attribute = :attribute")})
public class CategoryDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CategoryDetailPK categoryDetailPK;
    @JoinColumn(name = "attribute", referencedColumnName = "attribute_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Attribute attribute1;
    @JoinColumn(name = "category", referencedColumnName = "category_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Category category1;
    @JoinColumns({
        @JoinColumn(name = "magni", referencedColumnName = "magni"),
        @JoinColumn(name = "unit", referencedColumnName = "unit_id")})
    @ManyToOne
    private Unit unit;

    public CategoryDetail() {
    }

    public CategoryDetail(CategoryDetailPK categoryDetailPK) {
        this.categoryDetailPK = categoryDetailPK;
    }

    public CategoryDetail(short category, int attribute) {
        this.categoryDetailPK = new CategoryDetailPK(category, attribute);
    }

    public CategoryDetailPK getCategoryDetailPK() {
        return categoryDetailPK;
    }

    public void setCategoryDetailPK(CategoryDetailPK categoryDetailPK) {
        this.categoryDetailPK = categoryDetailPK;
    }

    public Attribute getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(Attribute attribute1) {
        this.attribute1 = attribute1;
    }

    public Category getCategory1() {
        return category1;
    }

    public void setCategory1(Category category1) {
        this.category1 = category1;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryDetailPK != null ? categoryDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryDetail)) {
            return false;
        }
        CategoryDetail other = (CategoryDetail) object;
        if ((this.categoryDetailPK == null && other.categoryDetailPK != null) || (this.categoryDetailPK != null && !this.categoryDetailPK.equals(other.categoryDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.ipn.escom.supernaut.nile.model.CategoryDetail[ categoryDetailPK=" + categoryDetailPK + " ]";
    }

}
