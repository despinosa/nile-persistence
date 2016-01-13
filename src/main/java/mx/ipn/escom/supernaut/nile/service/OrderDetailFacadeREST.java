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
import mx.ipn.escom.supernaut.nile.model.OrderDetail;
import mx.ipn.escom.supernaut.nile.model.OrderDetailPK;

/**
 *
 * @author supernaut
 */
@Stateless
@Path("mx.ipn.escom.supernaut.nile.model.orderdetail")
public class OrderDetailFacadeREST extends AbstractFacade<OrderDetail> {

    @PersistenceContext(unitName = "mx.ipn.escom.supernaut_nile-persistence_war_0.1PU")
    private EntityManager em;

    private OrderDetailPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;customer=customerValue;order=orderValue;product=productValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        mx.ipn.escom.supernaut.nile.model.OrderDetailPK key = new mx.ipn.escom.supernaut.nile.model.OrderDetailPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> customer = map.get("customer");
        if (customer != null && !customer.isEmpty()) {
            key.setCustomer(new java.lang.Integer(customer.get(0)));
        }
        java.util.List<String> order = map.get("order");
        if (order != null && !order.isEmpty()) {
            key.setOrder(new java.lang.Short(order.get(0)));
        }
        java.util.List<String> product = map.get("product");
        if (product != null && !product.isEmpty()) {
            key.setProduct(new java.lang.Integer(product.get(0)));
        }
        return key;
    }

    public OrderDetailFacadeREST() {
        super(OrderDetail.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(OrderDetail entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, OrderDetail entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        mx.ipn.escom.supernaut.nile.model.OrderDetailPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public OrderDetail find(@PathParam("id") PathSegment id) {
        mx.ipn.escom.supernaut.nile.model.OrderDetailPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<OrderDetail> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<OrderDetail> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
