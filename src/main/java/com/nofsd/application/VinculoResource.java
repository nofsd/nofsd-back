package com.nofsd.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.nofsd.infra.db.VinculoDB;

@Path("/ativos-fixos")
public class VinculoResource {

    @GET
    @Path("/{idAtivoFixo}/vinculos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<VinculoDB> getTodosVinculos(@PathParam("idAtivoFixo") String idAtivoFixo) {
        return VinculoDB.find("idAtivoFixo", idAtivoFixo).list();
    }

    @POST
    @Path("/{idAtivoFixo}/vinculos")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postVinculo(@PathParam("idAtivoFixo") String idAtivoFixo, 
        @QueryParam("idUsuario") String idUsuario) {

        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        try {
            VinculoDB vinculoDB = new VinculoDB();
            vinculoDB.dataLocacao = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            vinculoDB.idAtivoFixo = idAtivoFixo;
            vinculoDB.idUsuario = idUsuario;
            vinculoDB.persist();
            builder.status(Response.Status.CREATED);

        } catch (Exception exc) {
            builder.status(Response.Status.BAD_REQUEST);
        }

        return builder.build();
    }
    
    @DELETE
    @Path("/{idAtivoFixo}/vinculos")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteVinculo(@PathParam("idAtivoFixo") String idAtivoFixo, 
        @QueryParam("idUsuario") String idUsuario) {

        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        try {
            
            VinculoDB vinculoDB = VinculoDB.find("idAtivoFixo = ?1 and idUsuario = ?2", idAtivoFixo, idUsuario).firstResult();
            vinculoDB.dataDevolucao = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            vinculoDB.update();
            
            builder.status(Response.Status.OK);

        } catch (Exception exc) {
            builder.status(Response.Status.BAD_REQUEST);
        }

        return builder.build();
    }

}