package com.desafio.lanchonete.domain.model;

import java.math.BigDecimal;

public class IngredientBuilder {
    private String descripton;
    private BigDecimal value;
    private IngredientsEnum ingredient;

    public IngredientBuilder setDescripton(String descripton) {
        this.descripton = descripton;
        return this;
    }

    public IngredientBuilder setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public IngredientBuilder withIngredient(IngredientsEnum ingredient){
        this.ingredient = ingredient;
        return this;
    }

    public Ingredient createIngredient() {
        return new Ingredient(descripton, value, ingredient);
    }
}