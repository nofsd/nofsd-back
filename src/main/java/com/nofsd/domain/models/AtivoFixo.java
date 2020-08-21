package com.nofsd.domain.models;

import java.util.Objects;

public class AtivoFixo {
    
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
    private StatusAtivo status;
    private TipoAtivo tipoAtivo;

    @Deprecated
    public AtivoFixo() {
    }

    private AtivoFixo(String modelo, String marca, String imei, String vouncher, String tradeIn, 
        String usuario, String prv, String operadora, String pin, String numero, String ddd, String pais,
        String dataLocacao, String dataDevolucao, StatusAtivo status, TipoAtivo tipoAtivo) {
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
        this.tipoAtivo = tipoAtivo;
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

    public StatusAtivo getStatus() {
        return status;
    }

    public TipoAtivo getTipoAtivo() {
        return tipoAtivo;
    }

    public static AtivoFixoBuild builder() {
        return new AtivoFixoBuild();
    }

    public static class AtivoFixoBuild {

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
        private StatusAtivo status;
        private TipoAtivo tipoAtivo;

        public AtivoFixoBuild modelo(String modelo) {
            this.modelo = modelo;
            return this;
        }
    
        public AtivoFixoBuild marca(String marca) {
            this.marca = marca;
            return this;
        }
    
        public AtivoFixoBuild imei(String imei) {
            this.imei = imei;
            return this;
        }
    
        public AtivoFixoBuild vouncher(String vouncher) {
            this.vouncher = vouncher;
            return this;
        }
    
        public AtivoFixoBuild tradeIn(String tradeIn) {
            this.tradeIn = tradeIn;
            return this;
        }
    
        public AtivoFixoBuild usuario(String usuario) {
            this.usuario = usuario;
            return this;
        }
    
        public AtivoFixoBuild prv(String prv) {
            this.prv = prv;
            return this;
        }
    
        public AtivoFixoBuild operadora(String operadora) {
            this.operadora = operadora;
            return this;
        }
    
        public AtivoFixoBuild pin(String pin) {
            this.pin = pin;
            return this;
        }
    
        public AtivoFixoBuild numero(String numero) {
            this.numero = numero;
            return this;
        }
    
        public AtivoFixoBuild ddd(String ddd) {
            this.ddd = ddd;
            return this;
        }
    
        public AtivoFixoBuild pais(String pais) {
            this.pais = pais;
            return this;
        }

        public AtivoFixoBuild dataDevolucao(String dataDevolucao) {
            this.dataDevolucao = dataDevolucao;
            return this;
        }

        public AtivoFixoBuild dataLocacao(String dataLocacao) {
            this.dataLocacao = dataLocacao;
            return this;
        }

        public AtivoFixoBuild status(StatusAtivo status) {
            this.status = status;
            return this;
        }

        public AtivoFixoBuild tipoAtivo(TipoAtivo tipoAtivo) {
            this.tipoAtivo = tipoAtivo;
            return this;
        }

        public AtivoFixo build() {
            return new AtivoFixo(modelo, marca, imei, vouncher, tradeIn, usuario, prv, operadora, pin, numero, 
                    ddd, pais, dataLocacao, dataDevolucao, status, tipoAtivo);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AtivoFixo)) {
            return false;
        }
        AtivoFixo ativoFixo = (AtivoFixo) o;
        return Objects.equals(modelo, ativoFixo.modelo) && Objects.equals(marca, ativoFixo.marca) && Objects.equals(imei, ativoFixo.imei) && Objects.equals(vouncher, ativoFixo.vouncher) && Objects.equals(tradeIn, ativoFixo.tradeIn) && Objects.equals(usuario, ativoFixo.usuario) && Objects.equals(prv, ativoFixo.prv) && Objects.equals(operadora, ativoFixo.operadora) && Objects.equals(pin, ativoFixo.pin) && Objects.equals(numero, ativoFixo.numero) && Objects.equals(ddd, ativoFixo.ddd) && Objects.equals(pais, ativoFixo.pais) && Objects.equals(dataLocacao, ativoFixo.dataLocacao) && Objects.equals(dataDevolucao, ativoFixo.dataDevolucao) && Objects.equals(status, ativoFixo.status);
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