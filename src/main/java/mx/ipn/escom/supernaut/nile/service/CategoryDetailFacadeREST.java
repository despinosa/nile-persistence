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
import mx.ipn.escom.supernaut.nile.model.CategoryDetailEntity;
import mx.ipn.escom.supernaut.nile.model.CategoryDetailPKEmbeddable;

/**
 *
 * @author supernaut
 */
@Stateless
@Path("mx.ipn.escom.supernaut.nile.model.categorydetail")
public class CategoryDetailFacadeREST extends AbstractFacade<CategoryDetailEntity> {

    @PersistenceContext(unitName = "mx.ipn.escom.supernaut_nile-persistence_war_0.1PU")
    private EntityManager em;

    private CategoryDetailPKEmbeddable getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;category=categoryValue;attribute=attributeValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        mx.ipn.escom.supernaut.nile.model.CategoryDetailPKEmbeddable key = new mx.ipn.escom.supernaut.nile.model.CategoryDetailPKEmbeddable();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> category = map.get("category");
        if (category != null && !category.isEmpty()) {
            key.setCategory(new java.lang.Short(category.get(0)));
        }
        java.util.List<String> attribute = map.get("attribute");
        if (attribute != null && !attribute.isEmpty()) {
            key.setAttribute(new java.lang.Integer(attribute.get(0)));
        }
        return key;
    }

    public CategoryDetailFacadeREST() {
        super(CategoryDetailEntity.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(CategoryDetailEntity entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, CategoryDetailEntity entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        mx.ipn.escom.supernaut.nile.model.CategoryDetailPKEmbeddable key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public CategoryDetailEntity find(@PathParam("id") PathSegment id) {
        mx.ipn.escom.supernaut.nile.model.CategoryDetailPKEmbeddable key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CategoryDetailEntity> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CategoryDetailEntity> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
