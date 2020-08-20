package com.nofsd.application;

import java.util.List;
import java.util.Objects;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.nofsd.domain.models.Mobile;
import com.nofsd.infra.db.MobileDB;

import org.bson.types.ObjectId;

@Path("/mobiles")
public class MobileResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MobileDB> getTodosMobiles() {
        return MobileDB.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MobileDB buscaFamiliaPorId(@PathParam("id") String id) {
        return MobileDB.findById(new ObjectId(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postMobile(MobileDB mobileDB) {

        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        return builder.status(save(mobileDB)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putMobile(@PathParam("id") String id, MobileDB mobileDB) {

        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        return builder.status(save(mobileDB)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMobile(@PathParam("id") String id) {

        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        try {
            MobileDB mobile = MobileDB.findById(new ObjectId(id));
            mobile.delete();
            builder = Response.status(Response.Status.OK);

        } catch (Exception exc) {
            
			builder = Response.status(Response.Status.BAD_REQUEST);
        }
        return builder.build();
    }

    private Response.Status save(MobileDB mobileDB) {

        try {
            
            Mobile.builder()
                .modelo(mobileDB.modelo)
                .marca(mobileDB.marca)
                .imei(mobileDB.imei)
                .vouncher(mobileDB.vouncher)
                .tradeIn(mobileDB.tradeIn)
                .usuario(mobileDB.usuario)
                .prv(mobileDB.prv)
                .operadora(mobileDB.operadora)
                .pin(mobileDB.pin)
                .numero(mobileDB.numero)
                .ddd(mobileDB.ddd)
                .pais(mobileDB.pais)
                .dataDevolucao(mobileDB.dataDevolucao)
                .dataLocacao(mobileDB.dataLocacao)
                .status(mobileDB.status)
                .build();

            if (Objects.isNull(mobileDB.id)) {
                mobileDB.persist();
            } else {
                mobileDB.update();
            }

            
            return Response.Status.CREATED;

        } catch (Exception exc) {
            
			return Response.Status.BAD_REQUEST;
        }

    }

}