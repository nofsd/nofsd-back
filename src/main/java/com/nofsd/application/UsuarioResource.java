package com.nofsd.application;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import javax.ws.rs.QueryParam;



import com.nofsd.infra.db.UsuarioDB;

import org.bson.types.ObjectId;

@Path("/usuarios")
public class UsuarioResource {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUsuario(UsuarioDB usuarioDB) {

        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        try {
            usuarioDB.persist();
            builder.status(Response.Status.CREATED);

        } catch (Exception exc) {
            builder.status(Response.Status.BAD_REQUEST);
        }

        return builder.build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UsuarioDB> getTodosUsuarios(@QueryParam("prv") String prv) {
        System.out.println("Todos");

        if (Objects.nonNull(prv)) {
           return UsuarioDB.find("prv",prv).list();
        }

        return UsuarioDB.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioDB buscaUsuarioPorId(@PathParam("id") String id) {
        return UsuarioDB.findById(new ObjectId(id));
    }

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioDB buscaUsuarioPorPrv(@QueryParam("prv") String prv) {
       System.out.println(prv);
       return UsuarioDB.find("prv",prv).firstResult();
    }*/

}