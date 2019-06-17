package com.desafio.lanchonete.domain.dto;

import com.desafio.lanchonete.domain.model.Ingredient;

import java.math.BigDecimal;

public class IngredientsDto {

    private String description;
    private BigDecimal value;

    public IngredientsDto(){}

    public IngredientsDto(Ingredient ingredient)
    {
        this.description = ingredient.getDescription();
        this.value = ingredient.getValue();
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
}
