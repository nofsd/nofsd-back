package com.nofsd.domain.models;

import java.util.Objects;

public class Mobile {
    
    private String modelo;
    private String marca;
    private String imei;
    private String vouncher;
    private String tradeIn;
    private String usuario;
    private String prv;
    private String operadora;
    private String pin;
    private String numero;
    private String ddd;
    private String pais;
    private String dataLocacao;
    private String dataDevolucao;
    private String status;


    @Deprecated
    public Mobile() {
    }

    private Mobile(String modelo, String marca, String imei, String vouncher, String tradeIn, 
        String usuario, String prv, String operadora, String pin, String numero, String ddd, String pais,
        String dataLocacao, String dataDevolucao, String status) {
        this.modelo = modelo;
        this.marca = marca;
        this.imei = imei;
        this.vouncher = vouncher;
        this.tradeIn = tradeIn;
        this.usuario = usuario;
        this.prv = prv;
        this.operadora = operadora;
        this.pin = pin;
        this.numero = numero;
        this.ddd = ddd;
        this.pais = pais;
        this.dataDevolucao = dataDevolucao;
        this.dataLocacao = dataLocacao;
        this.status = status;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getImei() {
        return this.imei;
    }

    public String getVouncher() {
        return this.vouncher;
    }

    public String getTradeIn() {
        return this.tradeIn;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getPrv() {
        return this.prv;
    }

    public String getOperadora() {
        return this.operadora;
    }

    public String getPin() {
        return this.pin;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getDdd() {
        return this.ddd;
    }

    public String getPais() {
        return this.pais;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public String getStatus() {
        return status;
    }

    public static MobileBuild builder() {
        return new MobileBuild();
    }

    public static class MobileBuild {

        private String modelo;
        private String marca;
        private String imei;
        private String vouncher;
        private String tradeIn;
        private String usuario;
        private String prv;
        private String operadora;
        private String pin;
        private String numero;
        private String ddd;
        private String pais;
        private String dataLocacao;
        private String dataDevolucao;
        private String status;

        public MobileBuild modelo(String modelo) {
            this.modelo = modelo;
            return this;
        }
    
        public MobileBuild marca(String marca) {
            this.marca = marca;
            return this;
        }
    
        public MobileBuild imei(String imei) {
            this.imei = imei;
            return this;
        }
    
        public MobileBuild vouncher(String vouncher) {
            this.vouncher = vouncher;
            return this;
        }
    
        public MobileBuild tradeIn(String tradeIn) {
            this.tradeIn = tradeIn;
            return this;
        }
    
        public MobileBuild usuario(String usuario) {
            this.usuario = usuario;
            return this;
        }
    
        public MobileBuild prv(String prv) {
            this.prv = prv;
            return this;
        }
    
        public MobileBuild operadora(String operadora) {
            this.operadora = operadora;
            return this;
        }
    
        public MobileBuild pin(String pin) {
            this.pin = pin;
            return this;
        }
    
        public MobileBuild numero(String numero) {
            this.numero = numero;
            return this;
        }
    
        public MobileBuild ddd(String ddd) {
            this.ddd = ddd;
            return this;
        }
    
        public MobileBuild pais(String pais) {
            this.pais = pais;
            return this;
        }

        public MobileBuild dataDevolucao(String dataDevolucao) {
            this.dataDevolucao = dataDevolucao;
            return this;
        }

        public MobileBuild dataLocacao(String dataLocacao) {
            this.dataLocacao = dataLocacao;
            return this;
        }

        public MobileBuild status(String status) {
            this.status = status;
            return this;
        }

        public Mobile build() {
            return new Mobile(modelo, marca, imei, vouncher, tradeIn, usuario, prv, operadora, pin, numero, 
                    ddd, pais, dataLocacao, dataDevolucao, status);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mobile)) {
            return false;
        }
        Mobile mobile = (Mobile) o;
        return Objects.equals(modelo, mobile.modelo) && Objects.equals(marca, mobile.marca) && Objects.equals(imei, mobile.imei) && Objects.equals(vouncher, mobile.vouncher) && Objects.equals(tradeIn, mobile.tradeIn) && Objects.equals(usuario, mobile.usuario) && Objects.equals(prv, mobile.prv) && Objects.equals(operadora, mobile.operadora) && Objects.equals(pin, mobile.pin) && Objects.equals(numero, mobile.numero) && Objects.equals(ddd, mobile.ddd) && Objects.equals(pais, mobile.pais) && Objects.equals(dataLocacao, mobile.dataLocacao) && Objects.equals(dataDevolucao, mobile.dataDevolucao) && Objects.equals(status, mobile.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, marca, imei, vouncher, tradeIn, usuario, prv, operadora, pin, numero, ddd, pais, dataLocacao, dataDevolucao, status);
    }
    

    @Override
    public String toString() {
        return "{" +
            " modelo='" + modelo + "'" +
            ", marca='" + marca + "'" +
            ", imei='" + imei + "'" +
            ", vouncher='" + vouncher + "'" +
            ", tradeIn='" + tradeIn + "'" +
            ", usuario='" + usuario + "'" +
            ", prv='" + prv + "'" +
            ", operadora='" + operadora + "'" +
            ", pin='" + pin + "'" +
            ", numero='" + numero + "'" +
            ", ddd='" + ddd + "'" +
            ", pais='" + pais + "'" +
            ", dataLocacao='" + dataLocacao + "'" +
            ", dataDevolucao='" + dataDevolucao + "'" +
            ", status='" + status + "'" +
            "}";
    }
    
   

}