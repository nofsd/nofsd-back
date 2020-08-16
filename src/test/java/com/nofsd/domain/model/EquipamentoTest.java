package com.nofsd.domain.model;

import com.nofsd.domain.models.Equipamento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class EquipamentoTest {

    @Test
    public void testPadraoIdenficadorValido() {

        Equipamento equipamento = Equipamento.builder().nome("iPad").identificador("A12AA456").build();

        Assertions.assertEquals("iPad", equipamento.getNome());
    }

    @Test
    public void testPadraoIdenficadorInvalido() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Equipamento.builder().nome("iPad").identificador("12AA456").build();
        });
    }

}