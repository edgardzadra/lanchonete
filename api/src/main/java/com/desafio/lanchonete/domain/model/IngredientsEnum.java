package com.desafio.lanchonete.domain.model;

import java.math.BigDecimal;

public enum IngredientsEnum {

    HAMBURGUER("Hámburguer de carne", BigDecimal.valueOf(3.00)),
    ALFACE("Alface", BigDecimal.valueOf(0.40)),
    BACON("Bacon", BigDecimal.valueOf(2.00)),
    QUEIJO("Queijo", BigDecimal.valueOf(1.50)),
    OVO("Ovo", BigDecimal.valueOf(0.80));

    private String description;
    private BigDecimal value;

    IngredientsEnum(String description, BigDecimal value){
        this.value = value;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }
}
