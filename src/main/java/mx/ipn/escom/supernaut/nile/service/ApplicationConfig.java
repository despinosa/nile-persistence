/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package mx.ipn.escom.supernaut.nile.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author supernaut
 */
@javax.ws.rs.ApplicationPath("resources")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();
    addRestResourceClasses(resources);
    return resources;
  }

  /**
   * Do not modify addRestResourceClasses() method. It is automatically populated with all resources
   * defined in the project. If required, comment out calling this method in getClasses().
   */
  private void addRestResourceClasses(Set<Class<?>> resources) {
    resources.add(mx.ipn.escom.supernaut.nile.service.AddressFacadeREST.class);
    resources
        .add(mx.ipn.escom.supernaut.nile.service.AttributeFacadeREST.class);
    resources
        .add(mx.ipn.escom.supernaut.nile.service.CategoryDetailFacadeREST.class);
    resources.add(mx.ipn.escom.supernaut.nile.service.CategoryFacadeREST.class);
    resources.add(mx.ipn.escom.supernaut.nile.service.CustomerFacadeREST.class);
    resources
        .add(mx.ipn.escom.supernaut.nile.service.MagnitudeFacadeREST.class);
    resources.add(mx.ipn.escom.supernaut.nile.service.Order1FacadeREST.class);
    resources
        .add(mx.ipn.escom.supernaut.nile.service.OrderDetailFacadeREST.class);
    resources
        .add(mx.ipn.escom.supernaut.nile.service.ProductDetailFacadeREST.class);
    resources.add(mx.ipn.escom.supernaut.nile.service.ProductFacadeREST.class);
    resources.add(mx.ipn.escom.supernaut.nile.service.UnitFacadeREST.class);
  }

}
