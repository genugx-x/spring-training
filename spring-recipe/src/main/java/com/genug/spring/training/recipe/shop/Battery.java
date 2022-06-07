package com.genug.spring.training.recipe.shop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Battery extends Product {

    @Getter
    @Setter
    private Boolean rechargeable;

    public Battery(String name, double price) {
        super(name, price);
    }
}
