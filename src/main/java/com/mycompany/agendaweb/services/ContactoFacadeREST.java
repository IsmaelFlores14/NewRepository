/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agendaweb.services;

import com.mycompany.agendaweb.entities.Contacto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ismael
 */
@Stateless
@Path("contacto")
public class ContactoFacadeREST extends AbstractFacade<Contacto> {

    //tomcat ignora esta inyeccion de recursos
    //@PersistenceContext(unitName = "com.mycompany_agendaweb_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private final String JSON_RESPONSE = "{\"Id\":%d, \"Nombre\":\"%s\", \"md5\":\"%s\", \"Operation\":\"%s\", \"Resultado\":\"%s\"}";
    
    public ContactoFacadeREST() {
        super(Contacto.class);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contacto find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contacto> findAll() {
        return super.findAll();
    }
    
    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String create(Contacto entity) {
        String resultado = super.create(entity);
        return String.format(JSON_RESPONSE, entity.getId(), entity.getNombre(), entity.getMd5(),"insert", resultado);
    }

    /*@PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String edit(@PathParam("id") Integer id, Contacto entity) {
        String resultado = super.edit(entity);
        return String.format(JSON_RESPONSE, entity.getId(), entity.getNombre(), entity.getMd5(), "update", resultado);
    }*/

    /*@DELETE
    @Path("{id}")
    public String remove(@PathParam("id") Integer id) {
        String resultado = super.remove(super.find(id));
        String mensaje = "{\"Id\":%d, \"operation\":\"%s\", \"resultado\":\"%s\"}";
        return String.format(mensaje, id, "delete", resultado);
    }*/

    /*@GET
    @Override
    @Path("propietario/{owner}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contacto> findAllByOwner(@PathParam("owner") String owner) {
        return super.findAllByOwner(owner);
    }*/
    
    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contacto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /*@GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }*/

    @Override
    protected EntityManager getEntityManager() {
        if(em == null){
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_agendaweb_war_1.0-SNAPSHOTPU");
            em = factory.createEntityManager();
        }        
        return em;
    }
    
}
