package com.nofsd.domain.models;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public enum TipoAtivo {
    SMARTPHONE(1), TABLET(2), CHIP(3), NOTEBOOK(4);

    private TipoAtivo(Integer id) {
        this.id = id;
    }

    private final Integer id;

    public Integer getId() {
        return id;
    }

    public static TipoAtivo getStatus(Integer id) {
        return Arrays.asList(TipoAtivo.values())
            .stream()
            .filter(s -> Objects.equals(s.id, id))
            .findFirst()
            .orElseThrow();
    }

    public static Map<String, Integer> TIPOS = Stream
        .of( values() )
        .collect( Collectors.toMap( v -> v.toString(), k -> k.id ) );

}