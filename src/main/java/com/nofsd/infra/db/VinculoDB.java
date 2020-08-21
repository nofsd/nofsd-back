package com.nofsd.infra.db;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "vinculos_ativos_usuarios")
public class VinculoDB extends PanacheMongoEntity {

    public ObjectId id;
    public String idUsuario;
    public String idAtivoFixo;
    public String dataLocacao;
    public String dataDevolucao;
    
}