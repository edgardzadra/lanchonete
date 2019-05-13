package com.desafio.lanchonete.domain.dto;

public class IngredientsDto {

    private String description;

    public IngredientsDto(){}

    public IngredientsDto(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
