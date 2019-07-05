package com.desafio.lanchonete.domain.model;

import com.desafio.lanchonete.domain.dto.BurguerDto;
import com.desafio.lanchonete.domain.dto.IngredientsDto;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public class MeatPromotion implements Promotion {

    @Override
    public BurguerDto applyDiscount(BurguerDto burguer) {
        long meatOccurences = burguer.getIngredients().stream().filter(i -> i.getIngredients() == IngredientsEnum.HAMBURGUER_CARNE).count();

        if (meatOccurences >= 3) {
            Double sumOfIngredient = burguer.getIngredients().stream().filter(i ->  i.getIngredients() == IngredientsEnum.HAMBURGUER_CARNE).mapToDouble(i -> i.getValue().doubleValue()).sum();

            Double quantityToDiscount = (meatOccurences / 3) * (sumOfIngredient / meatOccurences);

            burguer.setTotalAmount(burguer.getTotalAmount().subtract(BigDecimal.valueOf(quantityToDiscount)));
        }

        return burguer;
    }
}
