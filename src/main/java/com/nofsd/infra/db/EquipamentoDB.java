package com.nofsd.infra.db;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "equipamentos")
public class EquipamentoDB extends PanacheMongoEntity {
    
    public ObjectId id;
    public String nome;
    public String identificador;
}