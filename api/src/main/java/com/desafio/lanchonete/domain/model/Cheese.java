package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import com.desafio.lanchonete.domain.dto.IngredientsDto;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public class Cheese implements Promotion {

    @Override
    public BurguerDto applyDiscount(BurguerDto burguer) {
        Map<String, BigDecimal> listOfIngredients = burguer.getIngredients().stream()
                .collect(Collectors.groupingBy(IngredientsDto::getDescription, Collectors.reducing(BigDecimal.ZERO,IngredientsDto::getValue,BigDecimal::add)));

        Long cheeseOccurences = burguer.getIngredients().stream().filter(i -> i.getDescription().equals(IngredientsEnum.QUEIJO.getDescription())).count();

        if (cheeseOccurences >= 3) {
            Long quantityToDiscount = (listOfIngredients.get(IngredientsEnum.QUEIJO.getDescription()).divide(IngredientsEnum.QUEIJO.getValue()).longValue()) / 3;
            BigDecimal valueToDiscount = BigDecimal.valueOf(IngredientsEnum.QUEIJO.getValue().doubleValue() * quantityToDiscount.intValue());

            burguer.setTotalAmount(burguer.getTotalAmount().subtract(valueToDiscount));
        }

        return burguer;
    }
}
