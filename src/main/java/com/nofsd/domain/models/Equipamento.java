package com.nofsd.domain.models;
import java.util.Objects;
 
public class Equipamento {

    public static final String IDENTIFICADOR_REQUERIDO = "Informe o identificador";
    public static final String NOME_REQUERIDO = "Informe o nome";
    public static final String IDENTIFICADOR_PADRAO = "Identificador fora do padrão";

    private String identificador;
    private String nome;

    @Deprecated
    public Equipamento() {}

    private Equipamento(final String identificador, final String nome) {
        this.identificador = identificador;
        this.nome = nome;
    }

    public String getIdentificado() { 
        return this.identificador;
    }

    public String getNome() {
        return this.nome;
    }

    public static EquipamentoBuild builder() {
        return new EquipamentoBuild();
    }

    public static EquipamentoRules validator() {
        return new EquipamentoRules();
    }

    public static class EquipamentoBuild {

        private String identificador;
        private String nome;
    
        public EquipamentoBuild identificador(final String identificador) {
            this.identificador = identificador;
            return this;
        }
    
        public EquipamentoBuild nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public Equipamento build() {
            Objects.requireNonNull(identificador, IDENTIFICADOR_REQUERIDO);
            Objects.requireNonNull(nome, NOME_REQUERIDO);
            Equipamento.validator().validaPadraoIdentificador(identificador);

            return new Equipamento(identificador, nome);
        }
    }

    public static class EquipamentoRules {
        
        private void validaPadraoIdentificador(String identificador) {
            if (!identificador.substring(0, 1).matches("[A-Z\s]")) {
                throw new IllegalArgumentException(IDENTIFICADOR_PADRAO); 
            }
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Equipamento)) {
            return false;
        }
        final Equipamento equipamento = (Equipamento) o;
        return Objects.equals(identificador, equipamento.identificador) && Objects.equals(nome, equipamento.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, nome);
    }

    @Override
    public String toString() {
        return "{" +
            " identificador='" + getIdentificado() + "'" +
            ", nome='" + getNome() + "'" +
            "}";
    }
    

}