package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import com.desafio.lanchonete.domain.dto.IngredientsDto;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public class Meat implements Promotion {

    @Override
    public BurguerDto applyDiscount(BurguerDto burguer) {
        Map<String, BigDecimal> listOfIngredients = burguer.getIngredients().stream()
                .collect(Collectors.groupingBy(IngredientsDto::getDescription, Collectors.reducing(BigDecimal.ZERO,IngredientsDto::getValue,BigDecimal::add)));

        long meatOccurences = burguer.getIngredients().stream().filter(i -> i.getDescription().equals(IngredientsEnum.HAMBURGUER.getDescription())).count();

        if (meatOccurences >= 3) {
            Long quantityToDiscount = (listOfIngredients.get(IngredientsEnum.HAMBURGUER.getDescription()).divide(IngredientsEnum.HAMBURGUER.getValue()).longValue()) / 3;

            BigDecimal valueToDiscount = BigDecimal.valueOf(IngredientsEnum.HAMBURGUER.getValue().doubleValue() * quantityToDiscount.intValue());

            burguer.setTotalAmount(burguer.getTotalAmount().subtract(valueToDiscount));
        }

        return burguer;
    }
}
