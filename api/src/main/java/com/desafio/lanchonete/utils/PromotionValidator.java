package com.desafio.lanchonete.utils;

import com.desafio.lanchonete.domain.model.Ingredient;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PromotionValidator {

    public BigDecimal applyPromotions(List<Ingredient> ingredientList, BigDecimal totalAmount){

        Map<Ingredient,Long> listOfQuantityOfIngredients = ingredientList.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Optional<Ingredient> meat = ingredientList.stream().filter(i -> i.getDescription().equals("Hámburguer de carne")).findAny();
        Optional<Ingredient> cheese = ingredientList.stream().filter(i -> i.getDescription().equals("Queijo")).findAny();

        if(meat.isPresent()){
            totalAmount = applyDiscountOfCheeseOrMeat(listOfQuantityOfIngredients,meat.get(),totalAmount);
        }

        if(cheese.isPresent()){
            totalAmount = applyDiscountOfCheeseOrMeat(listOfQuantityOfIngredients,cheese.get(),totalAmount);
        }

        totalAmount = applyDiscountOfSalad(ingredientList,totalAmount);

        return totalAmount;
    }

    private BigDecimal applyDiscountOfCheeseOrMeat(Map<Ingredient,Long> listOfQuantityOfIngredients, Ingredient ingredient, BigDecimal totalAmount){

        if(listOfQuantityOfIngredients.get(ingredient) >= 3){
            Long quantityToDiscount = listOfQuantityOfIngredients.get(ingredient) / 3;
            BigDecimal valueToDiscount = BigDecimal.valueOf(ingredient.getValue().doubleValue() * quantityToDiscount.intValue());

            return totalAmount.subtract(valueToDiscount);
        }

        return totalAmount;
    }

    private BigDecimal applyDiscountOfSalad(List<Ingredient> ingredientList, BigDecimal totalAmount){
        boolean isBacon = ingredientList.stream().anyMatch(i -> i.getDescription().equals("Bacon"));
        boolean isAlface = ingredientList.stream().anyMatch(i -> i.getDescription().equals("Alface"));
        BigDecimal discount = BigDecimal.valueOf(0.10);

        if(isAlface && !isBacon){
            return totalAmount.subtract(totalAmount.multiply(discount));
        }

        return totalAmount;
    }
}
