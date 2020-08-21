package com.nofsd.domain.models;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum StatusAtivo {
    
    DISPONIVEL(1), DISPONIBILIZADO(2), INDISPONIVEL(3);

    private StatusAtivo(Integer id) {
        this.id = id;
    }

    private final Integer id;

    public Integer getId() {
        return id;
    }
    
    public static StatusAtivo getStatus(Integer id) {
        return Arrays.asList(StatusAtivo.values())
            .stream()
            .filter(s -> Objects.equals(s.id, id))
            .findFirst()
            .orElseThrow();
    }

    public static Map<String, Integer> STATUS = Stream
        .of( values() )
        .collect( Collectors.toMap( v -> v.toString(), k -> k.id ) );
}
