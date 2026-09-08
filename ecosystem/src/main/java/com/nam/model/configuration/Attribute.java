package com.nam.model.configuration;

import lombok.Getter;

@Getter 
public final class Attribute<T> {
    private final String name;

    private Attribute(String name) {
        this.name = name;
    }

    public static <T> Attribute<T> of(String name) {
        return new Attribute<>(name);
    }
}
