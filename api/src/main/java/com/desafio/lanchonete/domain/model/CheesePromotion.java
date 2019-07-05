package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import com.desafio.lanchonete.domain.dto.IngredientsDto;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public class CheesePromotion implements Promotion {

    @Override
    public BurguerDto applyDiscount(BurguerDto burguer) {

        long cheeseOccurences = burguer.getIngredients().stream().filter(i -> i.getIngredients() == IngredientsEnum.QUEIJO).count();

        if (cheeseOccurences >= 3) {
            Double sumOfIngredient = burguer.getIngredients().stream().filter(i ->  i.getIngredients() == IngredientsEnum.QUEIJO).mapToDouble(i -> i.getValue().doubleValue()).sum();

            Double quantityToDiscount = (cheeseOccurences / 3) * (sumOfIngredient / cheeseOccurences);

            burguer.setTotalAmount(burguer.getTotalAmount().subtract(BigDecimal.valueOf(quantityToDiscount)));
        }

        return burguer;
    }
}
