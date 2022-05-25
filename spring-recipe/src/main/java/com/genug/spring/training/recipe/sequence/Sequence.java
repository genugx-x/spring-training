package com.genug.spring.training.recipe.sequence;

import lombok.Getter;

@Getter
public class Sequence {
    private final String id;
    private final String prefix;
    private final String suffix;

    public Sequence(String id, String prefix, String suffix) {
        this.id = id;
        this.prefix = prefix;
        this.suffix = suffix;
    }
}
