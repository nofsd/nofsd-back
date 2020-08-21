package com.nofsd.application;

import java.util.List;
import java.util.Map;
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

import com.nofsd.domain.models.AtivoFixo;
import com.nofsd.domain.models.StatusAtivo;
import com.nofsd.domain.models.TipoAtivo;
import com.nofsd.infra.db.AtivoFixoDB;

import org.bson.types.ObjectId;

@Path("/ativos-fixos")
public class AtivoFixoResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AtivoFixoDB> getTodosAtivoFixos() {
        return AtivoFixoDB.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AtivoFixoDB buscaFamiliaPorId(@PathParam("id") String id) {
        return AtivoFixoDB.findById(new ObjectId(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postAtivoFixo(AtivoFixoDB ativoFixoDB) {

        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        return builder.status(save(ativoFixoDB)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putAtivoFixo(@PathParam("id") String id, AtivoFixoDB ativoFixoDB) {

        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        return builder.status(save(ativoFixoDB)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAtivoFixo(@PathParam("id") String id) {

        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        try {
            AtivoFixoDB ativoFixo = AtivoFixoDB.findById(new ObjectId(id));
            ativoFixo.delete();
            builder = Response.status(Response.Status.OK);

        } catch (Exception exc) {
            
			builder = Response.status(Response.Status.BAD_REQUEST);
        }
        return builder.build();
    }

    private Response.Status save(AtivoFixoDB ativoFixoDB) {

        try {
            
            AtivoFixo.builder()
                .modelo(ativoFixoDB.modelo)
                .marca(ativoFixoDB.marca)
                .imei(ativoFixoDB.imei)
                .vouncher(ativoFixoDB.vouncher)
                .tradeIn(ativoFixoDB.tradeIn)
                .usuario(ativoFixoDB.usuario)
                .prv(ativoFixoDB.prv)
                .operadora(ativoFixoDB.operadora)
                .pin(ativoFixoDB.pin)
                .numero(ativoFixoDB.numero)
                .ddd(ativoFixoDB.ddd)
                .pais(ativoFixoDB.pais)
                .dataDevolucao(ativoFixoDB.dataDevolucao)
                .dataLocacao(ativoFixoDB.dataLocacao)
                .status(StatusAtivo.getStatus(ativoFixoDB.status))
                .tipoAtivo(TipoAtivo.getStatus(ativoFixoDB.tipo))
                .build();

            if (Objects.isNull(ativoFixoDB.id)) {
                ativoFixoDB.persist();
            } else {
                ativoFixoDB.update();
            }

            
            return Response.Status.CREATED;

        } catch (Exception exc) {
            
			return Response.Status.BAD_REQUEST;
        }

    }

    @GET
    @Path("/status")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Integer> getStatusAtivoFixo() {
        return StatusAtivo.STATUS;
    }

    @GET
    @Path("/tipos")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Integer> getTiposAtivoFixo() {
        return TipoAtivo.TIPOS;
    }

}