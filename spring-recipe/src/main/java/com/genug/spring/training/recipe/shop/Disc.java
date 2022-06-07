package com.genug.spring.training.recipe.shop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Disc extends Product {

    @Getter
    @Setter
    private int capacity;

    public Disc(String name, double price) {
        super(name, price);
    }
}
