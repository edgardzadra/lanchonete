package com.desafio.lanchonete.domain.dto;

import com.desafio.lanchonete.domain.model.Ingredient;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BurguerDto {

    private String description;
    private List<IngredientsDto> ingredients;
    private BigDecimal totalAmount;

    public BurguerDto(){}

    public  BurguerDto(String description, List<Ingredient> ingredients, BigDecimal totalAmount){
        this.ingredients = new ArrayList<>();
        ingredients.forEach(i -> this.ingredients.add(new IngredientsDto(i)));
        this.description = description;
        this.totalAmount = totalAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IngredientsDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsDto> ingredients) {
        this.ingredients = ingredients;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
