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
public class UnitPKEmbeddable extends UnitPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  private short magni;
  @Basic(optional = false)
  @NotNull
  @Column(name = "unit_id")
  private short unitId;

  public UnitPKEmbeddable() {}

  public UnitPKEmbeddable(short magni, short unitId) {
    this.magni = magni;
    this.unitId = unitId;
  }

  @Override
  public short getMagni() {
    return magni;
  }

  @Override
  public void setMagni(short magni) {
    this.magni = magni;
  }

  @Override
  public short getUnitId() {
    return unitId;
  }

  @Override
  public void setUnitId(short unitId) {
    this.unitId = unitId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) magni;
    hash += (int) unitId;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof UnitPKEmbeddable)) {
      return false;
    }
    UnitPKEmbeddable other = (UnitPKEmbeddable) object;
    if (this.magni != other.magni) {
      return false;
    }
    if (this.unitId != other.unitId) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "mx.ipn.escom.supernaut.nile.model.UnitPKEmbeddable[ magni=" + magni
        + ", unitId=" + unitId + " ]";
  }

}
