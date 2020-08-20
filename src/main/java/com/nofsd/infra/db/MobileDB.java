package com.nofsd.infra.db;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "mobiles")
public class MobileDB extends PanacheMongoEntity {
    
    public ObjectId id;
    public String modelo;
    public String marca;
    public String imei;
    public String vouncher;
    public String tradeIn;
    public String usuario;
    public String prv;
    public String operadora;
    public String pin;
    public String numero;
    public String ddd;
    public String pais;
    public String dataLocacao;
    public String dataDevolucao;
    public String status;
}