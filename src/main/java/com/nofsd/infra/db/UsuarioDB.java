package com.nofsd.infra.db;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "usuarios")
public class UsuarioDB extends PanacheMongoEntity {
    
    public ObjectId id;
    public String prv;
    public String nome;
    public String cargo;
    public String gerencia;
    public String diretoria;

}