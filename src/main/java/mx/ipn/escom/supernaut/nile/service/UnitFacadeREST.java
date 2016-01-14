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
import javax.ws.rs.core.PathSegment;
import mx.ipn.escom.supernaut.nile.model.UnitEntity;
import mx.ipn.escom.supernaut.nile.model.UnitPKEmbeddable;

/**
 *
 * @author supernaut
 */
@Stateless
@Path("mx.ipn.escom.supernaut.nile.model.unit")
public class UnitFacadeREST extends AbstractFacade<UnitEntity> {

    @PersistenceContext(unitName = "mx.ipn.escom.supernaut_nile-persistence_war_0.1PU")
    private EntityManager em;

    private UnitPKEmbeddable getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;magni=magniValue;unitId=unitIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        mx.ipn.escom.supernaut.nile.model.UnitPKEmbeddable key = new mx.ipn.escom.supernaut.nile.model.UnitPKEmbeddable();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> magni = map.get("magni");
        if (magni != null && !magni.isEmpty()) {
            key.setMagni(new java.lang.Short(magni.get(0)));
        }
        java.util.List<String> unitId = map.get("unitId");
        if (unitId != null && !unitId.isEmpty()) {
            key.setUnitId(new java.lang.Short(unitId.get(0)));
        }
        return key;
    }

    public UnitFacadeREST() {
        super(UnitEntity.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(UnitEntity entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, UnitEntity entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        mx.ipn.escom.supernaut.nile.model.UnitPKEmbeddable key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public UnitEntity find(@PathParam("id") PathSegment id) {
        mx.ipn.escom.supernaut.nile.model.UnitPKEmbeddable key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UnitEntity> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UnitEntity> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
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
