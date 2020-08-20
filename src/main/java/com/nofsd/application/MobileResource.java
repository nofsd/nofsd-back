package com.nofsd.application;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.nofsd.domain.models.Mobile;
import com.nofsd.infra.db.MobileDB;

@Path("/mobiles")
public class MobileResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MobileDB> getTodosMobiles() {
        return MobileDB.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postEquipamento(MobileDB mobileDB) {

        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);

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
                .build();

            mobileDB.persist();
            builder.status(Response.Status.CREATED);

        } catch (Exception exc) {
            
			builder.status(Response.Status.BAD_REQUEST).entity(exc.getMessage());
        }

        return builder.build();
    }

}