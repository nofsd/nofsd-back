package com.nofsd.application;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.nofsd.domain.models.Equipamento;
import com.nofsd.infra.db.EquipamentoDB;

import org.bson.types.ObjectId;

@Path("/equipamentos")
public class EquipamentoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EquipamentoDB> getTodosEquipamentos() {
        return EquipamentoDB.listAll();
    }

    @GET
    @Path("/{idEquipamento}")
    @Produces(MediaType.APPLICATION_JSON)
    public EquipamentoDB buscaEquipamentoPorId(@PathParam("idEquipamento") String id) {
        return EquipamentoDB.findById(new ObjectId(id));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postEquipamento(EquipamentoDB equipamentoDB) {

        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);

        try {
            
            Equipamento.builder()
                .nome(equipamentoDB.nome)
                .identificador(equipamentoDB.identificador)
                .build();

            equipamentoDB.persist();
            builder.status(Response.Status.CREATED);

        } catch (Exception exc) {
            
			builder.status(Response.Status.BAD_REQUEST).entity(exc.getMessage());
        }

        return builder.build();
    }
}