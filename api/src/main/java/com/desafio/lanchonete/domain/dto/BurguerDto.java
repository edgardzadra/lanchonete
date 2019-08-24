package com.desafio.lanchonete.domain.dto;

import com.desafio.lanchonete.domain.model.Ingredient;
import com.desafio.lanchonete.domain.model.IngredientsEnum;
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

    public Long getCountOfAllTypeIngredient(IngredientsEnum ingredient){
        return ingredients.stream().filter(i -> i.getIngredients() == ingredient).count();
    }

    public Double getIngredientValueSum(IngredientsEnum ingredient){
        return ingredients.stream().filter(i ->  i.getIngredients() == ingredient).mapToDouble(i -> i.getValue().doubleValue()).sum();
    }

    public boolean isBaconAvailable() {
        return getCountOfAllTypeIngredient(IngredientsEnum.BACON) > 0;
    }
    
    public boolean isSaladAvailable() {
        return getCountOfAllTypeIngredient(IngredientsEnum.ALFACE) > 0;
    }
}
