/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package mx.ipn.escom.supernaut.nile.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import mx.ipn.escom.supernaut.nile.model.AttributeEntity;

/**
 *
 * @author supernaut
 */
@Stateless
@Path("mx.ipn.escom.supernaut.nile.model.attribute")
public class AttributeFacadeREST extends AbstractFacade<AttributeEntity> {

  @PersistenceContext(
      unitName = "mx.ipn.escom.supernaut_nile-persistence_war_0.1PU")
  private EntityManager em;

  public AttributeFacadeREST() {
    super(AttributeEntity.class);
  }

  @POST
  @Override
  @Consumes({MediaType.APPLICATION_XML + "; charset=UTF-8",
      MediaType.APPLICATION_JSON + "; charset=UTF-8"})
  public void create(AttributeEntity entity) {
    super.create(entity);
  }

  @PUT
  @Path("{id}")
  @Consumes({MediaType.APPLICATION_XML + "; charset=UTF-8",
      MediaType.APPLICATION_JSON + "; charset=UTF-8"})
  public void edit(@PathParam("id") Integer id, AttributeEntity entity) {
    super.edit(entity);
  }

  @DELETE
  @Path("{id}")
  public void remove(@PathParam("id") Integer id) {
    super.remove(super.find(id));
  }

  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_XML + "; charset=UTF-8",
      MediaType.APPLICATION_JSON + "; charset=UTF-8"})
  public AttributeEntity find(@PathParam("id") Integer id) {
    return super.find(id);
  }

  @GET
  @Override
  @Produces({MediaType.APPLICATION_XML + "; charset=UTF-8",
      MediaType.APPLICATION_JSON + "; charset=UTF-8"})
  public List<AttributeEntity> findAll() {
    return super.findAll();
  }

  @GET
  @Path("{from}/{to}")
  @Produces({MediaType.APPLICATION_XML + "; charset=UTF-8",
      MediaType.APPLICATION_JSON + "; charset=UTF-8"})
  public List<AttributeEntity> findRange(@PathParam("from") Integer from,
      @PathParam("to") Integer to) {
    return super.findRange(new int[] {from, to});
  }

  @GET
  @Path("count")
  @Produces(MediaType.TEXT_PLAIN)
  public String countREST() {
    return String.valueOf(super.count());
  }

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

}
