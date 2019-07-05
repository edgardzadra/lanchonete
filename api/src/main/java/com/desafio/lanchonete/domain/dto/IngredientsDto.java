package com.desafio.lanchonete.domain.dto;

import com.desafio.lanchonete.domain.model.Ingredient;
import com.desafio.lanchonete.domain.model.IngredientsEnum;

import java.math.BigDecimal;

public class IngredientsDto {

    private String description;
    private BigDecimal value;
    private IngredientsEnum ingredients;

    public IngredientsDto(){}

    public IngredientsDto(Ingredient ingredient)
    {
        this.description = ingredient.getDescription();
        this.value = ingredient.getValue();
        this.ingredients = ingredient.getIngredient();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public IngredientsEnum getIngredients() {
        return ingredients;
    }
}
